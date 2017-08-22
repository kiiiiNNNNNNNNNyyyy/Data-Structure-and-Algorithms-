#include <iostream>

class Queue{
    private:
        std::string queueArray[100];
        const static int front = 0;
        int back;

    public:

        Queue(){
            back = -1;
        }
        void enqueue(std::string value){
            queueArray[++back] = value;
        }

        std::string dequeue(){
            std::string returnValue;
            if(!isEmpty()){
                returnValue = queueArray[front];
                for(int i=front; i<=back; ++i){
                    queueArray[i] = queueArray[i+1];
                }
                --back;
                return returnValue;
            }else{
                returnValue = "Queue is Empty!";
                return returnValue;
            } 
        }

        std::string qFront(){
            return queueArray[front];
        }

        std::string qBack(){
            return queueArray[back];
        }

        void displayQueue(){
            for(int i=front; i<=back; ++i){
                std::cout << queueArray[i] << " : ";
            }
            std::cout << std::endl;
        }

        void clear(){
            for(int i=front; i<=back; ++i){
                queueArray[i] = "";
            }
        }

        bool isEmpty(){
            if(back == -1){
               return true; 
            }else{
                return false;
            }
        }
};

int main(){

    Queue queue;
    std::cout << queue.dequeue() << std::endl;
    queue.enqueue("Tom");
    queue.enqueue("Arjun");
    queue.displayQueue();
    queue.enqueue("Jim");
    queue.enqueue("David");
    queue.displayQueue();
    queue.dequeue();
    std::cout << queue.qFront() << std::endl;
    std::cout << queue.qBack() << std::endl;
    queue.displayQueue();
    queue.enqueue("Eric");
    queue.enqueue("Will");
    queue.displayQueue();
    queue.dequeue();
    queue.displayQueue();

    return 0;
}