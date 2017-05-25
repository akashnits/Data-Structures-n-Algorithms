/*Author - Akash
Data Structures and Algotithms
*/
 
 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 
/* Name of the class has to be "Main" only if the class is public. */ 
class gcd 
{ 
private static int aPrime; 
public static void main (String[] args) throws java.lang.Exception 
{ 
int a,b; 
Scanner scan = new Scanner(System.in); 
a = scan.nextInt(); 
b = scan.nextInt(); 
System.out.println(eGCD(a, b)); 
} 
public static int eGCD(int a, int b) 
{ 
if(b==0) 
return a; 
else 
aPrime = a % b; 
return eGCD(b, aPrime); 
} 
}