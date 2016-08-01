package com.company;

public class LinkedList<T> {

    private ListNode header;

    public LinkedList() {

        header = new ListNode(null);

    }


    public LinkedListIterator zero() {

        return new LinkedListIterator(header);

    }


    public LinkedListIterator first() {

        return new LinkedListIterator(header.next);

    }


    public void insert(T x, LinkedListIterator p) {

        if (p != null && p.current != null)

            p.current.next = new ListNode(x, p.current.next);

    }


    public void remove(T x) {
        ListNode itr = header.next;
        while (itr != null && !itr.element.equals(x)){
            itr = itr.next;
        }

        LinkedListIterator p = new LinkedListIterator(itr);
        if (p.current.next != null)
            p.current.next = p.current.next.next;
    }


    public static int listSize(LinkedList theList) {

        LinkedListIterator itr=new LinkedListIterator(theList.header);

        int size = 0;


        while (itr.current.next!=null)
            size++;


        return size;

    }
}
