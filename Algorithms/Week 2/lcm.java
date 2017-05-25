/*Author - Akash
Data Structures and Algotithms
*/
 
 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 
/* Name of the class has to be "Main" only if the class is public. */ 
class lcm 
{ 
private static long aPrime; 
public static void main (String[] args) throws java.lang.Exception 
{ 
long a,b,gcd; 
Scanner scan = new Scanner(System.in); 
a = scan.nextLong(); 
b = scan.nextLong(); 
gcd = eGCD(a, b); 
System.out.println((a*b)/gcd); 
} 
public static long eGCD(long a, long b) 
{ 
if(b==0) 
return a; 
else 
aPrime = a % b; 
return eGCD(b, aPrime); 
} 
}