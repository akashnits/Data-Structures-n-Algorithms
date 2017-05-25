/* package whatever; // don't place package name! */ 
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
/* Name of the class has to be "Main" only if the class is public. */ 
class make_heap 
{ 
    private static int minIndex=0; 
    private static int count =0; 
    private static ArrayList<Integer> list; 
    private static boolean flag; 
    public static void main (String[] args) throws java.lang.Exception 
    { 
        // your code goes here 
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt(); 
        int[] inputArray = new int[n]; 
        list = new ArrayList<Integer>(); 
        for(int i=0; i <n; i++){ 
            inputArray[i]= scan.nextInt(); 
        } 
        int l,r; 
        for(int k=(n/2-1); k >=0; k--){ 
            minIndex =k; 
            while(minIndex < n/2){ 
                flag = false; 
                l= 2*minIndex+1; 
                r= 2*minIndex+2; 
                if(l < n && inputArray[l] < inputArray[minIndex]){ 
                    minIndex = l; 
                    flag= true; 
                } 
                if(r < n && inputArray[r] < inputArray[minIndex]){ 
                    minIndex =r; 
                    flag= true; 
                } 
                 
                if(flag){ 
                    count++; 
                    int swapIndex = (minIndex-1)/2; 
                    int temp= inputArray[minIndex]; 
                    inputArray[minIndex]= inputArray[swapIndex]; 
                    inputArray[swapIndex]= temp; 
                    list.add(swapIndex); 
                    list.add(minIndex); 
                } 
                else{ 
                    break; 
                } 
            } 
        } 
        System.out.print(count); 
        for(int s=0 ; s < list.size(); s++){ 
            if(s %2 == 0){ 
                System.out.println(); 
            } 
            System.out.print(list.get(s) + " "); 
        } 
    } 
} 