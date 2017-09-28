package io.oasp.ide.sonarqube.common.impl;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.model.JavaTree;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.PackageDeclarationTree;
import org.sonar.plugins.java.api.tree.SyntaxToken;
import org.sonar.plugins.java.api.tree.Tree;

import io.oasp.module.basic.common.api.reflect.OaspPackage;

@Rule(key = "DevonArchitecturePackageCheck", name = "Devon Package Check", description = "Verify that the code is following the devon package conventions.", //
		priority = Priority.MAJOR, tags = { "bug" })
public class DevonArchitecturePackageCheck implements JavaFileScanner {

	@Override
	public void scanFile(JavaFileScannerContext context) {
		if (context.fileParsed()) {
			CompilationUnitTree cut = context.getTree();
			PackageDeclarationTree packageDeclaration = cut.packageDeclaration();
			String packageName = "";
			int lineNumber = -1;
			if (packageDeclaration != null) {
				JavaTree pkg = (JavaTree) packageDeclaration.packageName();
				lineNumber = pkg.getLine();
				StringBuilder sb = new StringBuilder();
				printPackage(pkg, sb);
				packageName = sb.toString();
			}
			OaspPackage pkg = OaspPackage.of(packageName);
			if (!pkg.isValid()) {
				context.addIssue(lineNumber, this, "Invalid Package " + packageName + " !");
			}
		}
	}

	private void printPackage(JavaTree pkg, StringBuilder sb) {
		for (Tree child : pkg.getChildren()) {
			if (child instanceof SyntaxToken) {
				sb.append(((SyntaxToken) child).text());
			} else if (child instanceof MemberSelectExpressionTree) {
				printPackage((JavaTree) child, sb);
			} else if (child instanceof IdentifierTree) {
				sb.append(((IdentifierTree) child).name());
			}
		}
	}

}