import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 /*Author - Akash
Data Structures and Algotithms
*/
/* Name of the class has to be "Main" only if the class is public. */ 
class fibonacci_last_digit 
{ 
public static void main (String[] args) throws java.lang.Exception 
{ 
Scanner scan = new Scanner(System.in); 
System.out.println(FibList(scan.nextInt())); 
} 
public static int FibList(int n) 
{ 
if(n == 0)
	return 0;
int[] fibArray = new int[n+1]; 
fibArray[0] = 0; 
fibArray[1] = 1; 
for(int i =2; i <= n; i++) 
{ 
fibArray[i] = (fibArray[i-1] + fibArray[i-2]) % 10 ; 
} 
return fibArray[n]; 
} 
}