package simple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UseAList {
  public static void breakList(List l) {
    l.add(0, LocalDate.now());
  }

  public static void main(String[] args) {
//    List<String> names = new ArrayList(List.of(LocalDate.now(), "Bob"));
//    List<String> names = new ArrayList<String>(List.of(LocalDate.now(), "Bob"));
//    List<String> names = new ArrayList<String>(List.of("Alex", "Bob"));
    // List.of -> "unmodifiable" list, before Java 9, Arrays.asList is similar
    List<String> names = new ArrayList<>(List.of("Alex", "Bob"));
    names = Collections.checkedList(names, String.class);
    names.add("Fred");
    names.add("Jim");
    names.add("Sheila");
//    names.add(LocalDate.now());
//    breakList(names);
    System.out.println(names);
    System.out.println(names.get(0)); // includes a cast!!!
    String nameZero = /*(String)*/names.get(0);

    List<LocalDate> ld = new ArrayList();
//    ld.add("Sheila")
    ld.add(LocalDate.now());

//    List<String> x = List.<String>of("Fred"/*, LocalDate.now()*/);
//    List<Object> x = List.<String>of("Fred", LocalDate.now());
    // type inferencing, looks at arguments, and "where result
    // type is assigned"
//    List<String> x = List.of("Fred", LocalDate.now()); // no solution!!!
    List<String> x = List.of("Fred", "Jim"); // works

    Object theNames = names;
    // Object can't help us, and the list doesn't know!!!
//    if (theNames instanceof List<String>) {  // ERROR
    if (theNames instanceof List) {
      System.out.println("names is a list!");
    }
    // since (14?) LTS 17
    Collection<String> nameCollection = names;
    if (nameCollection instanceof List<String> target) {
//      List<String> target = (List<String>)nameCollection;
      System.out.println("yup, List<String>");
      target.add("Albert"); // this is now checked :)
      String n1 = target.get(0);
    }
  }
}
