class Queue{
    constructor(){
        this.queueArray = [100];
        this.front = 0;
        this.rear = -1;
    }

    isFull(){
        if(this.rear === 100){
            return true;
        }else{
            return false;
        }
    }

    isEmpty(){
        if(this.rear === -1){
            return true;
        }else{
            return false;
        }
    }

    enqueue(value){
        if(!this.isFull()){
            this.queueArray[++this.rear] = value;
        }else{
            console.log("The Stack is full!!");
        }
    }

    dequeue(){
        if(!this.isEmpty()){
            var returnValue = this.queueArray[this.front];
            for(let i=this.front; i<=this.rear; ++i){
                this.queueArray[i] = this.queueArray[i+1];
            }
            --this.rear;
            return returnValue;
        }else{
            console.log("The queue is Empty!");
        }
    }

    qFront(){
        return this.queueArray[this.front];
    }

    qRear(){
        return rhis.queueArray[this.back];
    }

    displayQueue(){
        var s = '';
        for(let i=this.front; i<=this.rear; ++i){
            s += this.queueArray[i] + " : ";
        }
        console.log(s);
    }
}

var queue = new Queue();
queue.dequeue();
queue.enqueue("Tom");
queue.enqueue("Arjun");
queue.displayQueue();
queue.enqueue("Jim");
queue.enqueue("David");
queue.dequeue();
queue.displayQueue();
queue.displayQueue();
queue.enqueue("Eric");
queue.enqueue("Will");
queue.displayQueue();
queue.dequeue();
queue.displayQueue();