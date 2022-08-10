package hw5;

public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;


    public Stack(int cap){
        this.capacity = cap; //set capacity = cap
        arr = new Node[capacity]; //create array 
    }
    
    public void push(Node node){
        if (!isFull()){
            arr[size] = node; //push node into array
            size++;//+1 size of array
        }else{
            System.out.println("Stack Overflow!!!");
        }
    }
    public Node pop(){
        if (!isEmpty()){
            size--; //-1 size of array
            return arr[size]; //pop node out of array
        }else{
            System.out.println("Stack Underflow!!!");
        }
        return null;
    }
    public boolean isFull(){
        return (size == capacity);//check isFull is true or false
    }
    public boolean isEmpty(){
        return (size == 0);//check isEmpty is true or false
    }
    
    public void printStack(){
        if (!isEmpty()) {
            System.out.print("[Bottom] ");
            for(int i = 0; i < size ; i++ ){
                System.out.print(arr[i].data + " ");//print out data in array
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}
