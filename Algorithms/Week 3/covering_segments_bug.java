/*Author - Akash
Data Structures and Algotithms
*/
 
 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 
/* Name of the class has to be "Main" only if the class is public. */ 
class covering_segments 
{ 
public static void main (String[] args) throws java.lang.Exception 
{ 
int n, m=0, greedy_choice; 
Scanner scan = new Scanner(System.in); 
n = scan.nextInt(); 
int[][] points = new int[n][2]; 
ArrayList<Integer> output = new ArrayList<>(); 
for(int i=0; i<n; i++) 
{ 
for(int j=0; j<2; j++) 
{ 
points[i][j] = scan.nextInt(); 
} 
} 
Arrays.sort(points, new java.util.Comparator<int[]>() { 
            public int compare(int[] a, int[] b) 
            { 
            return Integer.compare(b[0], a[0]); 
            } 
            }); 
             
            while(m < n) 
            { 
            greedy_choice = points[m][0]; 
            if(m == n-1) 
            { 
            output.add(greedy_choice); 
            break; 
            } 
            else 
            { 
            while(m < n) 
            { 
            m = m+1; 
            if(!(points[m][0] <= greedy_choice && greedy_choice <= points[m][1])) 
            { 
            output.add(greedy_choice); 
            break; 
            } 
            } 
                } 
            } 
             
            System.out.println(output.size()); 
             
            for(int k=0; k < output.size(); k++) 
            { 
            System.out.print(output.get(k) + " " ); 
            } 
             
} 
}