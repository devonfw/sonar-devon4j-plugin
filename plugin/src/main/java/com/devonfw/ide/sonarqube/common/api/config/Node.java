package com.devonfw.ide.sonarqube.common.api.config;

/**
 * {@link Node} of a hierarchical structure.
 */
@SuppressWarnings("javadoc")
class Node<V> {

  private final Node<V> parent;

  private final V value;

  /**
   * The constructor for a root node.
   *
   * @param value the {@link #getValue() value}.
   */
  public Node(V value) {

    this(null, value);
  }

  /**
   * The constructor.
   *
   * @param parent the {@link #getParent() parent}.
   * @param value the {@link #getValue() value}.
   */
  public Node(Node<V> parent, V value) {

    super();
    this.parent = parent;
    this.value = value;
  }

  /**
   * @return parent
   */
  public Node<V> getParent() {

    return this.parent;
  }

  /**
   * @return value
   */
  public V getValue() {

    return this.value;
  }

  public Node<V> createChild(V childValue) {

    return new Node<>(this, childValue);
  }

  public Node<V> find(V expectedValue) {

    if (this.value.equals(expectedValue)) {
      return this;
    }
    if (this.parent != null) {
      return this.parent.find(expectedValue);
    }
    return null;
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();
    toString(sb);
    return sb.toString();
  }

  private void toString(StringBuilder sb) {

    if (this.parent != null) {
      this.parent.toString(sb);
      sb.append("->");
    }
    sb.append(this.value);
  }

}
