class Stacks{
    constructor(aray){
        this.array = [100];
        this.top = -1;
    }
    
    push(value){
        this.array[++this.top] = value;
    }

    pop(){
        var returnValue = this.array[this.top--];
        return returnValue;
    }

    peek(){
        return this.array[this.top];
    }

    count(){
        return this.top;
    }

    isEmpty(){
        if(top <= -1){
            return true;
        }else{
            return false;
        }
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