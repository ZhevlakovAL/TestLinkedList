package zhevlakov;

import java.util.NoSuchElementException;

/**
 Design an int type singly linkedlist class, and then implement some functions
 below using the self designed class.
 Can not use Java built in List interface
 1. Append an element into the linkedlist
 2. Remove the tail element from a linkedlist
 3. Remove all element in the linkedlist that is great than a target value
 */
public class LinkedList<E> {
    private int size;
    private Node<E> head;

    public LinkedList() {
        this.size = 0;
        head = new Node<E>(null, null, null);
        head.next = head.prev = head;
    }

    public void add(final E value) {
        Node<E> newNode = new Node<E>(value, head, head.prev);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    /**
     * @return Removes and returns the last element from this list.
     */
    public E removeTail() {
        return remove(head.prev);
    }

    public void removeGreatThan(final E value) {
        Object[] needRemoved = new Object[size];
        int count = 0;
        for (Node<E> node = head.next; node != head; node = node.next) {
            if(node.value != null && value != null && value instanceof Comparable) {
                if(((Comparable)node.value).compareTo(value) > 0) {
                    needRemoved[count++] = node;
                }
            }
        }
        for(int i = 0; i < count; i ++) {
            if(needRemoved[i] != null) {
                remove((Node<E>) needRemoved[i]);
            }
        }
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> e = head.next; e != head; e = e.next) {
                result[i++] = e.value;
        }
        return result;
    }

    private E remove(Node<E> e) {
        if (e == head) {
            throw new NoSuchElementException();
        }
        E result = e.value;
        e.prev.next = e.next;
        e.next.prev = e.prev;
        e.next = e.prev = null;
        e.value = null;
        size--;
        return result;
    }

    public E getFirst() {
        if (size==0) {
            throw new NoSuchElementException();
        }
        return head.next.value;
    }

    public E getLast() {
        if (size==0) {
            throw new NoSuchElementException();
        }
        return head.prev.value;
    }
}
