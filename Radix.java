

public class Radix {
  public static void radixsort(int[] data) {
    int runs = 0;
    for (int x = 0; x < data.length; x++) {
      if (Math.log10(Math.abs(data[x])) > runs) {
        runs = (int)Math.ceil(Math.log10(Math.abs(data[x])));
      }
    }
    //System.out.println(runs);
  }

  @SuppressWarnings("unchecked")
  private static void radicalh(int[] data, int significant) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];


  }

  private static int place(int value, int place) {
    int a = value;
    for (int x = 1; x < place; x++) {
      a = a % 10;
    }

    return a;
  }

  public static void main(String[] args) {
    int[] a = {1,35,23213};
    radixsort(a);
  }
}
