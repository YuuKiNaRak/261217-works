package hw2;

public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void pushBack(int data){
        if (size == capacity)
        {
            int ncap = capacity * 2;
            int[] narr = new int[ncap];
            for (int k = 0; k < size; ++k) {
               narr[k] = arr[k];
            }
            arr = narr;
            capacity = ncap;
        }
        arr[size] = data;
        ++size;
    }
    public int popBack(){
        if (size > 0){
            int t = arr[size-1];
            size--;
            return t;
        }else{
            System.out.println("ERROR");
            return 0;
        }
    }

    public int get(int i){
        if(i < size){
            return arr[i];
        }else{
            System.out.println("ERROR");
            return 0;
        }
    }
    public void set(int i, int value){
        if(i < size){
          arr[i] = value;   
        }else{
            System.out.println("ERROR");
        }
    }
    
    public void remove(int i){
        if(i < size){
          for(int m = i; m < size - 1; m++){
              arr[m] = arr[m + 1];   
            }   
           arr[size - 1] = 0;   
           size--;
        }else{
            System.out.println("ERROR");
        }
    }
    
    public boolean isEmpty(){
        boolean q = true;
        for (int i = 0; i < capacity-1; i++) {
            if(arr[i] != 0) q = false;
        }
        return q;
    }
    
    public int getSize(){
        return size;
    }
    
    public void printStructure(){
        if(size > 0 && capacity > 0){
            System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [");
            for (int i = 0; i < size-1; i++) {
                System.out.print( " " + arr[i] + "," );
            }
            System.out.println( " " + arr[size-1] + " ] " );
        }else
        System.out.println("Size = " + size + ", Cap = " + capacity + ", arr = [ ] ");
    }
}
