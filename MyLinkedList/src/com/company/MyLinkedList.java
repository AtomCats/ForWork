/*
package com.company;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private Node<T> header;
    private int n;

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public int size(){
        return n;
    }

    public T peek() {
        return first.item;
    }

    public void add(T item) {
        Node<T> oldlast = last;
        last = new Node<T>();
        last.item = item;
        last.next = null;
        n++;
    }

    public T remove(int index) {
        int counter;
        for (int i=0;i<size();i++){
        }
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Iterator<T> iterator()  {
        return new ListIterator<T>(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
}
*/
