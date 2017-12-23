class Stack{
    private static String[] stackArry = new String[100];
    private int top;

    Stack(){
        top = -1;
    }

    boolean isFull(){
        if(top == 4){
            return true;
        }else{
            return false;
        }
    }
    
    public void push(String value){
        if(!isFull()){
            stackArry[++top] = value;
        }else{
            System.out.println("Stack is Full!!");
        }
    }

    public String pop(){
        String retValue = stackArry[top--];
        return retValue;
    }

    public String peek(){
        return stackArry[top];
    }

    public int count(){
        return top+1;
    }

    public void clear(){
        for(int i=0; i<=top-1; i++){
            stackArry[i] = "";
        }
    }
}

public class Stacks{
    public static void main(String args[]){
        Stack stackObj = new Stack();
        stackObj.push("Arjun");
        stackObj.push("Tom");

        System.out.println(stackObj.peek());
        System.out.println(stackObj.count());

        stackObj.push("David");
        stackObj.push("Jim");

        System.out.println(stackObj.peek());
        System.out.println(stackObj.count());

        stackObj.pop();

        System.out.println(stackObj.peek());
        System.out.println(stackObj.count());

        stackObj.push("Jim");
        stackObj.push("Eric");
        stackObj.push("Terrance");
    }
}