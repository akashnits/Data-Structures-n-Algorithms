import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class tree_height { 
  
    
    void fDepth(int parent[], int i, int depth[]) { 
  
         
        if (depth[i] != 0) { 
            return; 
        } 
  
         
        if (parent[i] == -1) { 
            depth[i] = 1; 
            return; 
        } 
  
        
        if (depth[parent[i]] == 0) { 
            fDepth(parent, parent[i], depth); 
        } 
  
        
        depth[i] = depth[parent[i]] + 1; 
    } 
  
     
    int findHeight(int parent[], int n) { 
          
        
        int depth[] = new int[n]; 
        for (int i = 0; i < n; i++) { 
            depth[i] = 0; 
        } 
  
         
        for (int i = 0; i < n; i++) { 
            fDepth(parent, i, depth); 
        } 
  
        int ht = depth[0]; 
        for (int i = 1; i < n; i++) { 
            if (ht < depth[i]) { 
                ht = depth[i]; 
            } 
        } 
        return ht; 
    } 
  
     
    public static void main (String[] args) throws java.lang.Exception { 
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        int parent[] = new int[n]; 
        for(int i=0; i<n; i++){ 
            parent[i]= scan.nextInt(); 
        } 
        tree_height tree = new tree_height(); 
        new Thread(null, new Runnable() { 
                    public void run() { 
                        try { 
                            System.out.println(tree.findHeight(parent, n)); 
                        } catch (Exception e) { 
                        } 
                    } 
                }, "1", 1 << 26).start(); 
    } 
} 