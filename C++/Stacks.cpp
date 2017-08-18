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
            stackArray[++top] = value;
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

        bool isEmpty(){ 
            if(top == -1){
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

    
    return 0;
}