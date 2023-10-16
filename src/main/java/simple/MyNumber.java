package simple;

public class MyNumber implements Comparable<MyNumber> {
  private int number;

  public MyNumber(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "MyNumber{" +
      "number=" + number +
      '}';
  }

  @Override
  // THIS IS NOT an override!!! arg type differs!!!
  public int compareTo(MyNumber o) {
    return 0;
  }
}
