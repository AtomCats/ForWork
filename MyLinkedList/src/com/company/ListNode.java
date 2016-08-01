package com.company;

class ListNode <T>{
    public T   element;
    public ListNode<T> next;

    public ListNode( T theElement ) {

        this( theElement, null );
    }



    public ListNode( T theElement, ListNode n ) {

        element = theElement;
        next    = n;
    }





}
