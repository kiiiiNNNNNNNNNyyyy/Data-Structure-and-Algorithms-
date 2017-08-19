#include <iostream>

class Stack{
    private:
        int top;
        std::string stackArray[100];

    public:
        Stack(){
            int top = -1;
        }

        void push(std::string value){
            if(!isFull()){
                stackArray[++top] = value;
            }else{
                std::cout << "Stack is full!";
            }
        }

        std::string pop(){
            std::string returningValue = stackArray[top--];
            return returningValue;
        }

        int count(){
            return top;
        }

        std::string peek(){
            return stackArray[top];
        }

        void clear(){
            for(int i=0; i<=top-1; i++){
                stackArray[i] = "";
            }
            top = -1;
        }

        bool isFull(){ 
            if(top == 5){
                return true;
            }else{
                return false;
            }
        }
};

int main(){

    Stack stackObj;
    stackObj.push("Arjun");
    stackObj.push("Tom");

    std::cout << stackObj.peek() << std::endl;

    stackObj.push("David");
    stackObj.push("Jim");
    
    std::cout << stackObj.peek() << std::endl;
    std::cout << stackObj.count() << std::endl;
    
    stackObj.pop();
    
    std::cout << stackObj.peek() << std::endl;
    std::cout << stackObj.count() << std::endl;

    stackObj.push("Jim");
    stackObj.push("Eric");
    stackObj.push("Terrance");   
    
    return 0;
}