class Stack{
    private static String[] stackArry;
    private int top;

    Stack(){
        top = -1;
    }

    public void push(String value){
        stackArry[++top] = value;
    }

    public String pop(){
        String retValue = stackArry[top--];
        return retValue;
    }

    public String peek(){
        return stackArry[top];
    }

    public int count(){
        return top;
    }

    public void clear(){
        for(int i=0; i<=top-1; i++){
            stackArry[i] = "";
        }
    }

    boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }
}

public class Stacks{
    public static void main(String args[]){
        Stack stackObj = new Stack();
        stackObj.push("Arjun");
        stackObj.push("Tom");
    }
}