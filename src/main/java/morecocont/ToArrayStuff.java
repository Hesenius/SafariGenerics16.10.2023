package morecocont;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ToArrayStuff {
  public static <E extends F, F> F[] getAsArray(List<E> input, Class<F> cl) {
//    E [] result = new E[input.size()]; // NOPE, no type for E at runtime!!
//    E [] result = (E[])new Object[input.size()];
    // for legacy reasons, we must cast anyway!
//    E[] result = (E[]) Array.newInstance(cl, input.size());
    F[] result = (F[]) Array.newInstance(cl, input.size());

    for (int idx = 0; idx < result.length; idx++) {
      result[idx] = input.get(idx);
    }
    return result;
  }
  public static void main(String[] args) {
    List<String> ls = List.of("Alex", "Jim");

//    Object [] sa = getAsArray(ls);
    CharSequence[] sa = getAsArray(ls, CharSequence.class);
    System.out.println(Arrays.toString(sa));
    System.out.println("type of array is " + sa.getClass().getName());

//    Object [] sa2 = {"Hello"};
//    System.out.println("type of array is " + sa2.getClass().getName());
  }
}
