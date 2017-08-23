class Queue{
    private static String[] queueArray = new String[100];
    private int back;
    private final int front = 0;

    Queue(){
        back = -1;
    }

    public boolean isEmpty(){
        if(back == -1){
            return true;
        }else{
            return false;
        }
    }

    public void enqueue(String value){
        queueArray[++back] = value;
    }

    public String dequeue(){
        if(!isEmpty()){
            String returnValue = queueArray[front];
             
            for(int i=front; i<=back; ++i){
                    queueArray[i] = queueArray[i+1];
            }

            --back;
            return returnValue;
        }else{
            String comment = "queue is Empty!";
            return comment;
        }
    }

    public void displayQueue(){
        for(int i=front; i<=back; i++){
            System.out.print(queueArray[i] + " : ");
        }
        System.out.println();
    }

    public void clear(){
        for(int i=front; i<=back; i++){
            System.out.print(queueArray[i] + " : ");
        }
        System.out.println();
    }

    public String qFront(){
        return queueArray[front];
    }

    public String qBack(){
        return queueArray[back];
    }
}

public class Queues{
    public static void main(String args[]){
        Queue queuesObj = new Queue();
        queuesObj.enqueue("Tom");
        queuesObj.enqueue("Arjun");
        queuesObj.displayQueue();
        queuesObj.enqueue("Jim");
        queuesObj.enqueue("David");
        queuesObj.displayQueue();
        queuesObj.dequeue();
        System.out.println(queuesObj.qFront());
        System.out.println(queuesObj.qBack());
        queuesObj.displayQueue();
        queuesObj.enqueue("Eric");
        queuesObj.enqueue("Will");
        queuesObj.displayQueue();
        queuesObj.dequeue();
        queuesObj.displayQueue();

    }
}