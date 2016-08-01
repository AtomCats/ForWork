package com.company;

/**
 * Created by Admin on 01.08.2016.
 */
public class LinkedListIterator {
    ListNode current;

    LinkedListIterator( ListNode theNode ) {

        current = theNode;

    }

    public void move_next( ) {

            current = current.next;

    }

    public Object get_current( ) {

        return current.element;

    }
}
