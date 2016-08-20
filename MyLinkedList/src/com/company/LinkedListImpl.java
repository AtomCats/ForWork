package com.company;

import java.util.Iterator;
/**
 * Created by Admin on 17.08.2016.
 */
public class LinkedListImpl<T> implements MyList,Iterable<T> {
    private Node header;
    private Node last;
    private Node first;
    private int size;

    public LinkedListImpl(){
      header=null;
      last=null;
      first=null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }
    private class ListIterator implements Iterator <T>{
        private Node current;

        public ListIterator(Node first){
            current=first;
        }
        public boolean hasNext(){
            return current!=null;
        }

        public void remove(){}

        public T next(){

            T item=(T)current.item;
            current=current.next;
            return item;
        }
    }

    private class Node<T>{
        T item;
        Node next;
        Node prev;
        public Node(T element){
            item=element;
        }
        public Node(T element,Node nextNode){
            item=element;
            next=nextNode;
        }
    }

 /*   @Override
    public T getFirst() {
        if(header.item!=null)
        return (T)header.item;
        else
            return null;
    }

    @Override
    public T getLast(){
        T result = null;
        Node temp;
            while (header.next!=null) {
                result = (T) header.item;
                header.item=header.next;
            }
            return result;

    }



    public void addFirst(Object element) {
        T oldfirst;
        Node oldFirst;
        oldFirst=first;



    }

    public void addLast(T element) {

    }*/

    @Override
    public void add(Object o) {
        Node n=last;
        Node temp_Node=new Node(o,null);
        //last=temp_Node;
        if(first==null){
            first=temp_Node;
            last=first;
        }
        else{
            last.next=temp_Node;
        last=temp_Node;}
        size++;
    }

    @Override
    public Object get(int i) {
        Node temp_Node=first;
        int counter=1;
        if(i<=size) {
            while(counter<i) {
                if(counter==i){
                    return temp_Node.item;
                }
                temp_Node=temp_Node.next;
                counter++;
            }
            return temp_Node.item;
        }
        else
            throw new IndexOutOfBoundsException();

    }

    @Override
    public  int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        boolean result;
        if(first==null) {
            result = true;
        }
        else
            result=false;
        return result;
    }

    @Override
    public boolean remove (int i){
        Node prev;
        Node last;
        Node current=first;

        boolean result;
        int counter=1;

        if(i<=size+1) {

            for(Node element=first;element!=null;element=element.next)
            {

                if(counter==i-1){
                    if(element.next.next==null){
                        element.next=null;
                    }
                    else
                    element.next=element.next.next;

                }
                counter++;
            }

            result=true;
        }

        else {
            throw new IndexOutOfBoundsException();
        }

        return result;
    }
/*        else if(i==size+1)
        {
            counter=0;
            for(Node element=first;element!=null;element=element.next){
                if(counter==i-1){
                    element.next=null;
                }
                counter++;

            }
        }*/
/*            while(counter<=i) {
                current=current.next;

                if(counter==i-1) {
                    prev=current;
                }
                else if(counter==i){
                    last=current;
                }

                counter++;
            }
            prev.next=last;*/


/*        else if(i==size){
            while(counter<i-1) {
                prev=prev.next;
                counter++;
            }
            prev.next=null;
        }*/



}
