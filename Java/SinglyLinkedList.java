import java.util.*;
import java.lang.Object.*;
import java.util.LinkedList.*;

class SinglyLinkedList{

    private static Element head;
    private static Element tail;

    // creating an element sub class in order to store any kind of data.
    public final class Element{
        Object data;
        Element next;

        Element(Object data, Element next){
            this.data = data;
            this.next = next;
        }

        public Object getData(){
            return data;
        }

        public Object getNext(){
            return next;
        }
    }

    // Since the heads and Ttails are initially null, the list is empty by defualt and therefore the constructor does nothing.
    SinglyLinkedList(){
        // no args contructor
    }

    // Purge method - This method discard the current list contents and make the list empty again. - running time - O(n).

    public static void purge(){
        head = null;
        tail = null;
    }

    // Accessor Methods - There are three accessor methods namel getHead, getTail, isEmpty - running time O(1)

    public Element getHead(){
        return head;
    }

    public Element getTail(){
        return tail;
    }

    public boolean isEmpty(){
        return head == null;
    }
    
    // getFirst Method - The getFirst method returns the first element - running time O(1)
    
    public Object getFirst(){
        if(head == null){
            System.out.println("Container Empty");
        }
        
        return head.data;
    }

    // getLast method - The getLast method return the last element of the lists - running time - O(1)

    public Object getLast(){
        if(tail == null){
            System.out.println("Container Empty");
        }
        return tail.data;
    }

    //prepend - insert an element in front of the first element.

    public void prepend(Object item){
        Element temp = new Element(item, head);
        if(head == null){
            tail = temp;
        }
        head = temp;
    }

    // append - adds a new element to the end of the list

    public void appends(Object item){
        Element temp = new Element(item, null);

        if(head == null){
            head = temp;
        }else{
            tail.next = temp;
        }

        tail = temp;
    }


    // assign - The assign method is used to assign the elements of one list to another. - running time - O(n)
    // It does so by discarding the elements of the current list elements and then building a copy of the given linked list
    // The assign methods begins by calling the purge function on the new list to make sure itit empty.
    // Then it traverse the list and appends all the elements of the old list to the new one.

    public void assign(SinglyLinkedList list){
        if(list != this){   // if its not the same list
            purge();
            for(Element i = list.head; i != null; i = i.next){
                appends(i.data);
            }
        }
    }

    public void insertBefore(Object item, Object toAdd){

        Element temp = new Element(toAdd, null);
        Element ptr = head;
        Element prevPtr = null;

        while(ptr != tail){
            if(ptr.data != item){
                prevPtr = ptr;
                ptr = ptr.next;
            }else{
                Element currentNext = prevPtr.next;
                //temp.next = prevPtr.next;
                prevPtr.next = temp;
                ptr = temp;
                ptr.next = currentNext; 
                break;
            }
        }
    }
    // extract - the purpose of this method is to delete the specific element of the list

    public void extract(Object item){
        
        Element ptr = head;
        Element prevPtr = null;

        while(ptr != null && ptr.data != item){
            prevPtr = ptr;
            ptr = ptr.next;
        }

        if(ptr == null){
            //throw new IllegalArgumentException("Item not found!");
            System.out.println("Item not found!");
            return;
        }

        if(ptr == head){
            head = ptr.next;
        }else{
            prevPtr.next = ptr.next;
        }

        if(ptr == tail){
            tail = prevPtr;
            System.out.println("Item deleted!");
        }
    }

    public void printList(){
        Element ptr = head;
        Element prevPtr = null;
        do{
            System.out.print(ptr.data + " | ");
            prevPtr = ptr;
            ptr = ptr.next;
        }
        while(ptr != tail);
    }

    public static void main(String args[]){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        String x = "Hello";
        linkedList.appends(x);
        linkedList.appends("My");
        linkedList.appends("roll no is");
        linkedList.appends(123);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.getHead());
        System.out.println(linkedList.getTail());
        linkedList.extract("delete");
        linkedList.appends("delete");
        linkedList.printList();
        linkedList.insertBefore(123 , "this");
        System.out.println();
        
        linkedList.printList();
        System.out.println(linkedList.getLast());
        linkedList.extract("delete");
        linkedList.printList();
    }

    // getLast method - The getLast method returns the last list element.
}