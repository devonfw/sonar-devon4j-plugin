package com.devonfw.ide.sonarqube.common.impl.check;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sonar.java.ast.parser.JavaParser;
import org.sonar.java.model.JavaTree;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.ListTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.TypeTree;

import com.sonar.sslr.api.typed.ActionParser;

public abstract class DevonNamingConventionInterfaceExtendsInterfaceCheck implements JavaFileScanner {

  private JavaFileScannerContext context;

  protected String extendedInterface;

  protected String extendingInterfaceSuffix;

  public abstract void init();

  @Override
  public void scanFile(JavaFileScannerContext context) {

    init();
    this.context = context;

    File file = context.getFile();

    CompilationUnitTree parsedTree = parseJavaFile(file.getPath());

    List<Tree> types = parsedTree.types();
    ClassTree tree = getTreeInstance(types);

    Kind kind = tree.kind();

    boolean isInterface = kind.equals(Tree.Kind.INTERFACE);

    if (!isInterface)
      return;

    LinkedList<String> superInterfacesNames = new LinkedList<String>();
    ListTree<TypeTree> superInterfaces = tree.superInterfaces();
    // TODO falls leer, tue nichts
    for (Iterator<TypeTree> iterator = superInterfaces.iterator(); iterator.hasNext();) {
      TypeTree typeTree = iterator.next();
      superInterfacesNames.add(typeTree.toString());
    }

    IdentifierTree simpleName = tree.simpleName();
    String className = simpleName.name();

    boolean containsInterface = superInterfacesNames.contains(this.extendedInterface);

    ArrayList<String> matchingInterfaces = (ArrayList<String>) getMatchingStrings(superInterfacesNames,
        this.extendingInterfaceSuffix);

    if (containsInterface) {

      Pattern pattern = Pattern.compile(this.extendingInterfaceSuffix);
      Matcher matcher = pattern.matcher(className);
      boolean endsWith = matcher.find();

      if (!endsWith) {
        this.context.addIssueOnFile(this, "Interfaces inheriting from " + this.extendedInterface + " should have "
            + this.extendingInterfaceSuffix + " as prefix");
      }
    } else if (!matchingInterfaces.isEmpty()) {
      if (!className.endsWith(this.extendingInterfaceSuffix)) {
        this.context.addIssueOnFile(this, "If a superinterface has " + this.extendingInterfaceSuffix
            + " as prefix, then the subinteraface should also have" + this.extendingInterfaceSuffix + " as prefix.");
      }

    }

  }

  private static String getFileContent(File file) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader(file));
    String output = "";
    String st;
    while ((st = br.readLine()) != null)
      output += st + "\n";

    return output;
  }

  private static CompilationUnitTree parseJavaFile(String path) {

    ActionParser<Tree> parser = JavaParser.createParser();

    File input = new File(path);

    String fileContent = null;
    try {
      fileContent = getFileContent(input);
    } catch (IOException e) {
      e.printStackTrace();
    }

    Tree javaFileTree = parser.parse(fileContent);

    CompilationUnitTree parsedTree = new JavaTree.CompilationUnitTreeImpl(null, new ArrayList<>(), new ArrayList<>(),
        null);

    parsedTree = (CompilationUnitTree) javaFileTree;

    return parsedTree;
  }

  private static ClassTree getTreeInstance(List<Tree> types) {

    for (Iterator iterator = types.iterator(); iterator.hasNext();) {
      Tree tree = (Tree) iterator.next();
      if (tree instanceof ClassTree) {
        return (ClassTree) tree;
      }
    }
    return null;
  }

  List<String> getMatchingStrings(List<String> list, String regex) {

    ArrayList<String> matches = new ArrayList<>();

    Pattern p = Pattern.compile(regex);

    for (String s : list) {
      if (p.matcher(s).matches()) {
        matches.add(s);
      }
    }

    return matches;
  }
}
