package generics.linkedList;

public class LinkedListClient {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("a");
    list.add("b");
    list.add("c");

    System.out.println(list.isEmpty());
    list.display();
    System.out.println(list.size());

    LinkedList<Integer> list2 = new LinkedList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    list2.add(4);
    list2.add(5);

    System.out.println(list2.isEmpty());
    list2.display();
    System.out.println(list2.size());
  }
}
