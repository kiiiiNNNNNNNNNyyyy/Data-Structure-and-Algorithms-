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

        // insertAfter and insertBefore
        public void insertAfter(Object item){
            next = new Element(item, next);
            
            if(tail == this){
                tail = next;
            }
        }

        public void insertBefore(Object item){
            Element temp = new Element(item, this);
            
            if(this == head){
                head = temp;
            }else{
                Element prevPtr = head;
                
                while(prevPtr != null && prevPtr.next != this){
                    prevPtr = prevPtr.next;
                }
                
                prevPtr.next = temp;
            }
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

    // extract - the purpose of this method is to delete the specific element of the list

    public void extract(Object item){
        
        Element ptr = head;
        Element prevPtr = null;

        while(ptr != null && ptr.data != item){
            prevPtr = ptr;
            ptr = ptr.next;
        }

        if(ptr == null){
            throw new IllegalArgumentException("Item not found!");
        }

        if(ptr == head){
            head = ptr.next;
        }else{
            prevPtr.next = ptr.next;
        }

        if(ptr == tail){
            tail = prevPtr;
        }
    }

    public static void main(String args[]){
        
    }

    // getLast method - The getLast method returns the last list element.
}