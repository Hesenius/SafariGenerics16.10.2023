package odd;

import java.util.function.Predicate;

public class Example {
  public static <E extends CharSequence> boolean allMatch(Predicate<E> test, E... items) {
    Predicate<E> theTest = test;
    for (E e : items) {
      if (!theTest.test(e) || e.length() < 3) return false;
    }
    return true;
  }
}
