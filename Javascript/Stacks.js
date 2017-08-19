class Stacks{
    constructor(aray){
        this.array = [100];
        this.top = -1;
    }

    isFull(){
        if(this.top === 4){
            return true;
        }else{
            return false;
        }
    }
    
    push(value){
        if(!this.isFull()){
    this.array[++this.top] = value;
        }else{
            console.log("Stack is Full!!");
        }
        
    }

    pop(){
        var returnValue = this.array[this.top--];
        return returnValue;
    }

    peek(){
        return this.array[this.top];
    }

    count(){
        return this.top + 1;
    }
}

var stack = new Stacks();
stack.push("Arjun");
stack.push("Tom");

console.log(stack.peek());
console.log(stack.count());

stack.push("David");
stack.push("Jim");

console.log(stack.peek());
console.log(stack.count());

stack.pop();

console.log(stack.peek());
console.log(stack.count());

stack.push("Jim");
stack.push("Eric");
stack.push("Terrance");


