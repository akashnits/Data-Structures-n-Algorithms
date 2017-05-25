/*Author - Akash
Data Structures and Algotithms
*/
 
 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 
/* Name of the class has to be "Main" only if the class is public. */ 
class change 
{ 
public static void main (String[] args) throws java.lang.Exception 
{ 
int amount; 
int[] denominations = {10, 5, 1}; 
Scanner scan = new Scanner(System.in); 
amount= scan.nextInt(); 
int n = denominations.length; 
int count=0, i =0; 
while(amount != 0 && i < n) 
{ 
while(amount >= denominations[i] && i < n) 
{ 
amount = amount - denominations[i]; 
count++; 
} 
i++; 
} 
System.out.println(count); 
} 
}