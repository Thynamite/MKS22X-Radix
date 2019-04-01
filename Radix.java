

public class Radix {
  public static void radixsort(int[] data) {
    int runs = 0;
    for (int x = 0; x < data.length; x++) {
      if (Math.log10(Math.abs(data[x])) > runs) {
        runs = (int)Math.floor(Math.log10(Math.abs(data[x])));
      }
    }
  }

  private static void radicalh(int[] data, int significant) {
    int[] buckets = new int[20];


  }
}
