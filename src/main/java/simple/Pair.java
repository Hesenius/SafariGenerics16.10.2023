package simple;

import shop.Colored;

import java.util.function.BiPredicate;

public class Pair<E> {
  private E left;
  private E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public E getLeft() {
    return left;
  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public void setRight(E right) {
    this.right = right;
  }

  // Smart approach :) (command pattern)
  public boolean passesTest(BiPredicate<E, E> test) {
    return test.test(left, right);
  }

  @Override
  public String toString() {
    return "Pair{" +
      "left=" + left +
      ", right=" + right +
      '}';
  }
}
