package simple;

import java.time.LocalDate;

public class UsePair {
  public static void main(String[] args) {
    Pair<String> p = new Pair<>("Hello", "Bonjour");
    String eng = p.getLeft();
    String fr = p.getRight();
    p.setRight("Salut");
    System.out.println(p);

    Pair<LocalDate> pld = new Pair<>(LocalDate.now(), LocalDate.now().plusDays(2));
  }
}
