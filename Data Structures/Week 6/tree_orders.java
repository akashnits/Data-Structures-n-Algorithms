/* package whatever; // don't place package name! */ 
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
/* Name of the class has to be "Main" only if the class is public. */ 
class tree_orders 
{ 
    private static Node[] nodes; 
    public static void main (String[] args) throws java.lang.Exception 
    { 
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        nodes= new Node[n]; 
        for(int i=0; i<n; i++){ 
            nodes[i]= new tree_orders().new Node(scan.nextLong(), scan.nextInt(), scan.nextInt()); 
        } 
        Node root = nodes[0]; 
         
        new Thread(null, new Runnable() { 
                    public void run() { 
                        try { 
                            inOrderTraversal(root); 
                            System.out.println(); 
                            preOrderTraversal(root); 
                            System.out.println(); 
                            postOrderTraversal(root); 
                        } catch (Exception e) { 
                        } 
                    } 
                }, "1", 1 << 26).start(); 
    } 
    public static void inOrderTraversal(Node node){ 
        if(node == null){ 
            return; 
        } 
        if(node.getLeftIndex() != -1){ 
            inOrderTraversal(nodes[node.getLeftIndex()]); 
        }else{ 
            inOrderTraversal(null); 
        } 
         
        System.out.print(node.getKey() + " "); 
         
        if(node.getRightIndex() != -1){ 
            inOrderTraversal(nodes[node.getRightIndex()]); 
        }else{ 
            inOrderTraversal(null); 
        } 
    } 
     
    public static void preOrderTraversal(Node node){ 
        if(node == null){ 
            return; 
        } 
        System.out.print(node.getKey() + " "); 
        if(node.getLeftIndex() != -1){ 
            preOrderTraversal(nodes[node.getLeftIndex()]); 
        }else{ 
            preOrderTraversal(null); 
        } 
        if(node.getRightIndex() != -1){ 
            preOrderTraversal(nodes[node.getRightIndex()]); 
        }else{ 
            preOrderTraversal(null); 
        } 
    } 
     
    public static void postOrderTraversal(Node node){ 
        if(node == null){ 
            return; 
        } 
        if(node.getLeftIndex() != -1){ 
            postOrderTraversal(nodes[node.getLeftIndex()]); 
        }else{ 
            postOrderTraversal(null); 
        } 
        if(node.getRightIndex() != -1){ 
            postOrderTraversal(nodes[node.getRightIndex()]); 
        }else{ 
            postOrderTraversal(null); 
        } 
        System.out.print(node.getKey() + " "); 
    } 
     
    class Node{ 
        private long key; 
        private int leftIndex; 
        private int rightIndex; 
         
        Node(){} 
        Node(long key, int leftIndex, int rightIndex){ 
            this.key=key; 
            this.leftIndex = leftIndex; 
            this.rightIndex = rightIndex; 
        } 
        public long getKey(){ 
            return key; 
        } 
        public int getLeftIndex(){ 
            return leftIndex; 
        } 
        public int getRightIndex(){ 
            return rightIndex; 
        } 
    } 
} 