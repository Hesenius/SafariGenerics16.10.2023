package morecocont;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Example {
  // where you provide a "function" (e.g. Predicate): arguments should ACCEPT the
  // expected type, and are, therefore (almost always) CONTRA-VARIANT -> ? super
  // return types of functions must be assignable TO the intended target, which means
  // (almost always) they are CO-VARIANT -> ? extends
  // "PECS" -- "producer (output/return type) extends, consumer (input/arguments) super"
  public static <E> List<E> select(List<E> items, Predicate<? super E> test) {
    List<E> res = new ArrayList<>();
    for (E e : items) {
      if (test.test(e)) {
        res.add(e);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    List<String> names = List.of("Fred", "Jim", "Sheila", "Alice", "Bob");

//    Predicate<Integer> ps = s -> s > 3;
    Predicate<CharSequence> ps = s -> s.length() > 3;
    // defines boolean test(CharSequence cs); <-- String, StringBuilder are VALID arguments

    List<String> longNames = select(names, ps);

    System.out.println(longNames);
    List<StringBuilder> namesSB = List.of(
      new StringBuilder("Frederick"),
      new StringBuilder("Jo"),
      new StringBuilder("Sam"),
      new StringBuilder("Alice"),
      new StringBuilder("Robert"));


  }
}
