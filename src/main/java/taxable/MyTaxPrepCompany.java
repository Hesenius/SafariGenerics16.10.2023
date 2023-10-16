package taxable;

import java.util.List;

public class MyTaxPrepCompany {

  public static void processTaxes(Taxable t) {}

  // E is never used again...
//  public static <E extends Taxable> void processManyTaxes(List<E> lt) {
  // This form does not name "E", so we cannot refer to it again :)
  // but "simplifies" the syntax??
  // This is broadly "co-variance"
  public static void processManyTaxes(List<? extends Taxable> lt) {

    // these ALL FAIL for E extends Taxable--we have NO IDEA what E is
    // therefore NO IDEA what we can assign TO it.
// E e = new Corporation();
// lt.add(e);
//    lt.add(new Corporation()); // not good if lt were List<Individual>
//    lt.add(new Charity()); // not good if lt were List<Individual>
//    lt.add(new Taxable()); // not good if lt were List<Individual>
    int idx = 0;
    while (idx < lt.size()) { // DO NOT DO THIS FOR LIST PROCESSING!!!
      Taxable t = lt.get(idx);
      processTaxes(t);
      idx++;
    }

    // "proper" list processing
//    for (Taxable t : lt) {}
  }

//  public static void collectJoesClients(List<Individual> ljc) {
  // in this situation, we know NOTHING useful about E, so this "named" syntax
  // is not permitted, must use ? form
//  public static void collectJoesClients(List<E accept assignment of an Individual> ljc) {
// go with this:
//  public static void collectJoesClients(List<? accept assignment of an Individual> ljc) {

    public static void collectJoesClients(List<? super Individual> ljc) {
      ljc.add(new Individual());
      ljc.add(new Individual());
      ljc.add(new Individual());

// NOPE, we know nothing about ? type -- it could be Object!!!
//    Individual i = ljc.get(0);
    }

    public static void main(String[] args) {
      List<Taxable> clients = List.of(
        new Corporation(),
        new Corporation(),
        new Individual(),
        new Charity(),
        new Individual()
      );
      collectJoesClients(clients);
//      nope, Corporation is not assignable to Individual so this fails.
//      collectJoesClients(List.<Corporation>of());
      processManyTaxes(clients);

      List<Individual> joesClients = List.of(
        new Individual(),
        new Individual(),
        new Individual(),
        new Individual()
      );

      // fails at runtime because List.of is unmodifiable
      collectJoesClients(joesClients);

      // Liskov substitution principle (L in SOLID) says (roughly)
      // if this thing IS A X then it must substitute for X in all cases
      // "without surprises"
      processManyTaxes(joesClients);
    }
  }
