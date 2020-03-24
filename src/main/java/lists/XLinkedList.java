package lists;

import java.util.StringJoiner;

public class XLinkedList {

  static class Node {
    final int value;
    Node next;

    Node(int value) {
      this.value = value;
    }

    Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  Node head = null;

  void prepend(int element) {
    head = new Node(element, head);
  }

  void append(int element) {
    Node node = new Node(element);
    if (head == null) {
      head = node;
    } else {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = node;
    }
  }

  int size() {
    int size = 0;
    for (Node curr = head; curr != null; size++, curr = curr.next );
    return size;
  }

  boolean contains(int element){
    for (Node curr = head; curr != null; curr = curr.next)
      if (curr.value == element)
        return true;
    return false;
  }

  void reverse() {
    Node curr = head;
    Node rev = null;
    while (curr != null){
      Node next = curr.next;
      curr.next = rev;
      rev = curr;
      curr = next;
    }
    head = rev;
  }

  void insertBefore(int index, int value) {

    Node newNode = new Node(value);
    if (index == 0){
      head = new Node(value, head);
    } else {
      Node curr = head;
      while (--index > 0){
        curr = curr.next;
      }
      newNode.next = curr.next;
      curr.next = newNode;
    }

  }

  void insertAfter(int index, int value) {
    Node newNode = new Node(value);
      Node curr = head;
      while (index-- > 0){
        curr = curr.next;
      }
      newNode.next = curr.next;
      curr.next = newNode;
  }

  void deleteHead() {
    head = head.next;
  }

  void deleteLast() {
    Node curr = head;
    while (curr.next.next != null){
      curr=curr.next;
    }
    curr.next = curr.next.next;
  }

  void deleteAt(int index) {
    if (index == 0) head = head.next;
    else {
      Node curr = head;
      for (int i = 0; i < index - 1; curr = curr.next, i++);
      curr.next = curr.next.next;
    }
  }

  String represent() {
    StringJoiner sj = new StringJoiner(",", "(", ")");
    for (Node curr = head; curr != null; curr = curr.next) {
      sj.add(String.valueOf(curr.value));
    }
    return sj.toString();
  }

}
