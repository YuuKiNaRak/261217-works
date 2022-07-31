package hw4;

public class Stock {
    private List list;
    private int totalShares;
    
    public Stock(String costBasis){
        switch (costBasis) {
            case "FIFO":
                list = new Queue();
                break;
            case "LIFO":
                list = new Stack();
                break;
            default:
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }
    
    public void buy(int boughtShares, double boughtPrice){
        list.push(new Node(boughtShares, boughtPrice)); //pushing new purchase into to the list
        
        totalShares += boughtShares;
    }
    
    public void sell(int soldShares, double soldPrice){
        if (soldShares <= totalShares){
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;
            
            //calculating realized Gain/Loss
            while(soldShares != 0){ //loop until there is no soldShares left
                Node current = list.top(); 
                int reducedShares = Math.min(current.shares, soldShares); //determine highest number of shares that can be sold at the current node
                soldShares -= reducedShares;
                current.shares -= reducedShares;
                realizedGain += (soldPrice - current.price) * reducedShares; //adding gain/loss price
                if(current.shares == 0) //if current node has no share left even after reduction, pop the node out
                    list.pop(); 
                
                /*note: if there is some shares left in the current node, the node will still be left in the list to be calulated for unrealized Gain/Loss
                  and this loop will stop since soldShares must equal to 0 if there's some left in current node.*/
            }
            
            Node current = list.top();
            //calculating unrealized Gain/Loss
            while(current != null){ //iterate the entire list
                unrealizedGain += (soldPrice - current.price) * current.shares; // adding gain/loss price
                current = current.next;
                
                //note: Since the remaining list has to be intacted, the program must iterate through the list instead of popping each node.
            }
            
            totalShares -= soldShares;
            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain);
        }else{
            System.out.println("Sell command rejected");
        }
    }
    
    public void showList(){
        Node currentNode = list.top();
        System.out.print("head -> ");
        while (currentNode!=null){
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
}
