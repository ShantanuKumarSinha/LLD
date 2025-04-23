package generics.linkedList;

class ListNode<T> {
  T data;
  ListNode<T> next;

  public ListNode(T data) {
    this.data = data;
    this.next = null;
  }
}

public class LinkedList<T> {

  ListNode<T> head;
  ListNode<T> tmp;

  LinkedList() {
    head = new ListNode<>(null);
    tmp = head;
  }

  // TODO: Create and initialize the head to null in the constructor
  public void add(T data) {
    // TODO: Implement the add method to add a new node with the specified data at the end of the
    // list
    tmp.next = new ListNode<>(data);
    tmp = tmp.next;
  }

  public void display() {
    // TODO: Implement the display method to print the data of each node in the list separated by
    // spaces
    ListNode<T> tmp = head.next;
    while (tmp != null) {
      System.out.print(tmp.data + " ");
      tmp = tmp.next;
    }
    System.out.println();
  }

  public boolean isEmpty() {
    // TODO: Implement the isEmpty method to return true if the list is empty (i.e., head is null),
    // otherwise false.
    return head.next == null;
  }

  public int size() {
    // TODO: Implement the size method to return the number of nodes in the list
    ListNode<T> tmp = head.next;
    int size = 0;
    while (tmp != null) {
      size++;
      tmp = tmp.next;
    }
    return size;
  }
}
