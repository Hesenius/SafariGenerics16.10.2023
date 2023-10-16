package shop;

import simple.Pair;

import java.util.function.BiPredicate;

public class Store {
  public static void main(String[] args) {
    ClothingPair<Shoe> ps = new ClothingPair<>(new Shoe(9, "Brown"), new Shoe(9, "Black"));
    System.out.println(ps);
    System.out.println("pair matches? " + ps.matches());
    ClothingPair<Shoe> ps2 = new ClothingPair<>(new Shoe(8, "Brown"), new Shoe(9, "Brown"));
    System.out.println(ps2);
    System.out.println("pair 2 matches? " + ps2.matches());

    BiPredicate<Shoe, Shoe> matchedProperly = (s1, s2) -> {
      return s1.getColor().equals(s2.getColor()) &&
        s1.getSize() == s2.getSize();
    };

    System.out.println("pair 2 matches properly? " + ps2.passesTest(matchedProperly));
  }
}
