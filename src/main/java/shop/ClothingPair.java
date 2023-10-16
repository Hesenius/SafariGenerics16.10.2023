package shop;

import simple.Pair;

// & here represents additional constring NOT bit manipulation!
public class ClothingPair<E extends Colored & Sized/*, String*/> extends Pair<E> {
//  java.lang.String s = "Hello"; // OK
//  String s = "Hello"; // fails with second type param called String
  public ClothingPair(E left, E right) {
    super(left, right);
  }

  public boolean matches() {
    return getLeft().getColor().equals(getRight().getColor())
      && getLeft().getSize() == getRight().getSize();
  }

  public static <F extends Colored & Sized> boolean matched(Pair<F> p1) {
    return p1.getLeft().getColor().equals(p1.getRight().getColor());
  }
}
