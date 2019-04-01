public class MyLinkedList<E>{

  private class Node {
    private E data;
    private Node next, prev;

    private Node(E dats, Node net, Node pre) {                                //standard constructor
      data = dats;
      next = net;
      prev = pre;
    }
    //gives the next node
    private Node next(){
      return next;
    }
    //gives the previous node
    private Node prev(){
      return prev;
    }
    //mutator for the next node
    private void setNext(Node net){
      next = net;
    }
    //mutator for the previous Node
    private void setPrev(Node pre){
      prev = pre;
    }
    //returns the data
    private E getData() {
      return data;
    }
    //does this return the original value or the new value? before it's usually the old value. Sets the data variable to i
    private E setData(E i) {
      E ori = data;
      data = i;
      return ori;
    }
    //string to see individual parts (not used)
    public String toString() {
      String tostrung = "Previous Node: " + prev + ", " + "Object Value: " + data + ", " + "NextNode: " + next;
      return tostrung;
    }
  }
  private int size;
  private Node start, end;

  public String toString() {
    String a = "{";
    int index = 0;
    Node looking = start;
    while (index < size) {
      a += looking.getData() + " ";
      looking = looking.next();
    }
    a += "}";
    return a;
  }
    //not REQUIRED, but it would be crazy of you not to have this
    public MyLinkedList() {
      size = 0;
      start = null;
      end = null;
    }
    //construct an empty list
    public void clear() {
      size = 0;
      start = null;
      end = null;
    }
    //reset the list to an empty state. Very similar to the constructor.
    public boolean add(E value) {
      Node ender = new Node(value, null, end);
      if (size > 0) {
        end.setNext(ender);       //will get nullpointer exception otherwise
      }
      else {
        start = ender;      //changes the start to ender when start is null
      }
      end = ender;          //end will now refer to this new node
      size++;
      return true;
    }
    //add an element to the end of the list (the boolean would be true all the time if you want to conform to list standards)
    public void extend(MyLinkedList<E> other){
    //in O(1) runtime, move the elements from other onto the end of this
    //The size of other is reduced to 0           Does this set start and end to null as well?
    //The size of this is now the combined sizes of both original lists
    if (other.size != 0 && this.size != 0) {
      Node firstend = this.end;                                                 //Marks the end of the first list
      Node secondstart = other.start;                                           //The start of the second

      firstend.setNext(secondstart);                                            //modifiers to the added to list that need to add the second exisitng list
      secondstart.setPrev(firstend);
      this.end = other.end;
      this.size += other.size;

      other.size = 0;                                                           //Eliminates the second list as a thing
      //other.start = null;
      //other.end = null;
    }
    else if (this.size == 0 && other.size != 0) {
      this.start = other.start;
      this.end = other.end;
      this.size = other.size;
      //this = other;                                       Basically the short version to comprehend, but this isn't allowed in this form
      //other.start = null;
      //other.end = null;
      other.size = 0;
      //other = New MyLinkedList();                         ^
    }
    else {
      //the other cases that go here are both lists are empty, or the second list is empty and no change occurs because you add 0 to something it's still something
    }
  }
        /*in O(1) time, connect the other list to the end of this list.
        The other list is then reset to size 0 (do not wipe out the nodes, just disconnect them.)
        This is how you will merge lists together for your radix sort.
        */
    public E removeFront() {
      Node starter = start;
      start = start.next();
      return starter.getData();
    }
        //remove the 1st element of the list, and return that value.
    }
