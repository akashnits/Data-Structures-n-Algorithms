/* package whatever; // don't place package name! */ 
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
/* Name of the class has to be "Main" only if the class is public. */ 
class is_bst 
{ 
    private static Node[] nodes; 
    private static long max = Long.MIN_VALUE; 
    private static boolean flag= true; 
    public static void main (String[] args) throws java.lang.Exception 
    { 
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        if(n ==0){ 
            System.out.print("CORRECT"); 
            return; 
        } 
        nodes= new Node[n]; 
        for(int i=0; i<n; i++){ 
            nodes[i]= new is_bst().new Node(scan.nextLong(), scan.nextInt(), scan.nextInt()); 
        } 
        Node root = nodes[0]; 
        new Thread(null, new Runnable() { 
                    public void run() { 
                        try { 
                            inOrderTraversal(root); 
                            if(flag){ 
                            System.out.println("CORRECT"); 
                            }else{ 
                            System.out.println("INCORRECT"); 
                            } 
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
         
        if(node.getKey() > max){ 
            max= node.getKey(); 
        }else{ 
            flag=false; 
            return; 
        } 
         
        if(node.getRightIndex() != -1){ 
            inOrderTraversal(nodes[node.getRightIndex()]); 
        }else{ 
            inOrderTraversal(null); 
        } 
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