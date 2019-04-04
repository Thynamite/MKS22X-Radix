

public class Radix {
  public static void radixsort(int[] data) {
    int runs = 0;
    for (int x = 0; x < data.length; x++) {
      if (Math.log10(Math.abs(data[x])) > runs) {
        runs = (int)Math.ceil(Math.log10(Math.abs(data[x])));
      }
    }
    //System.out.println(runs);
    for (int x = 1; x < runs; x++) {
      radicalh(data,x);
    }
  }


  @SuppressWarnings("unchecked")
  private static void radicalh(int[] data, int significant) {
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new MyLinkedList<Integer>();
    }
    for (int i = 0; i < data.length; i++) {
      if (data[i] < 0) {
        buckets[9-place(data[i],significant)].add(data[i]);
      }
      else {
        buckets[place(data[i],significant)+10].add(data[i]);
      }
    }

    MyLinkedList<Integer> merge = new MyLinkedList<Integer>();
    for (int i = 0; i < buckets.length; i++) {
      if(buckets[i] != null) {
        merge.extend(buckets[i]);
      }
    }

    for (int i = 0; i < merge.size(); i++) {
      data[i] = merge.removeFront();
    }
  }

  private static int place(int value, int place) {
    int a = value;
    int count = 1;
    while(count != place) {
      a = a / 10;
    }
    a = a % 10;
    return a;
  }

  public static void main(String[] args) {
    int[] a = {1,35,23213};
    radixsort(a);
    for (int x = 0; x < a.length; x++) {
      System.out.println(a[x]);
    }
  }
}
