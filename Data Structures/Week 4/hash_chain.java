/* package whatever; // don't place package name! */ 
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
/* Name of the class has to be "Main" only if the class is public. */ 
class hash_chain 
{ 
    private static ArrayList<ArrayList<String>> hashTable; 
    private static int m; 
    private static long p; 
    public static void main (String[] args) throws java.lang.Exception 
    { 
        p = 1000000007; 
        Scanner scan = new Scanner(System.in); 
         m = scan.nextInt(); 
        int n = scan.nextInt(); 
        hashTable = new ArrayList<ArrayList<String>>(m); 
        for(int j=0; j<m; j++){ 
            hashTable.add(j, new ArrayList<String>()); 
        } 
        for(int i =0; i<n; i++){ 
            switch(scan.next()){ 
                case "add": 
                    addString(scan.next()); 
                    break; 
                case "del": 
                    delString(scan.next()); 
                    break; 
                case "find": 
                    findString(scan.next()); 
                    break; 
                case "check": 
                    checkListAtIndex(scan.nextInt()); 
                    break; 
                default: 
                    return; 
            } 
        } 
         
    } 
    public static void addString(String s){ 
        int hashCode = getHashCode(s); 
            ArrayList<String> list = hashTable.get(hashCode); 
            if(!list.contains(s)){ 
            list.add(0,s); 
            hashTable.set(hashCode, list);} 
    } 
     
    public static void delString(String s){ 
        int hashCode = getHashCode(s); 
        ArrayList<String> list = hashTable.get(hashCode); 
        if(list.contains(s)){ 
            list.remove(s); 
        } 
    } 
     
    public static void findString(String s){ 
        int hashCode = getHashCode(s); 
        ArrayList<String> list = hashTable.get(hashCode); 
        if(list.contains(s)){ 
            System.out.println("yes"); 
        }else{ 
            System.out.println("no"); 
        } 
    } 
     
    public static void checkListAtIndex(int a){ 
        ArrayList<String> list = hashTable.get(a); 
        for(int y=0; y < list.size(); y++){ 
            System.out.print(list.get(y) + " "); 
        } 
        System.out.println(); 
    } 
     
    public static int getHashCode(String s){ 
    long hash = 0; 
    for (int k = s.length() - 1; k >= 0; --k){ 
        hash = (((hash * 263 + (int)s.charAt(k)) % p) + p) % p; 
    } 
    return (int)hash % m; 
    } 
} 