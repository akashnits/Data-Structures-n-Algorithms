/*Author - Akash
Data Structures and Algotithms
*/ 
    
    
import java.util.*;    
import java.lang.*;    
import java.io.*;    
    
    
/* Name of the class has to be "Main" only if the class is public. */    
public class fibonacci_partial_sum    
{    
public static void main (String[] args) throws java.lang.Exception    
{    
boolean flag = true;       
ArrayList<Integer> fibMod = new ArrayList<>();     

fibMod.add(0); fibMod.add(1);   
   
   
int i= 2,p=0, q=0;    
int sum1=0, sum2=0;
int plength=0;  
long m, n;    
Scanner scan = new Scanner(System.in);    
m = scan.nextLong();   
n = scan.nextLong();

while(flag)    
{    
fibMod.add(i, (fibMod.get(i-1) + fibMod.get(i-2)) % 10);    
   
if(fibMod.get(i) == 1 && fibMod.get(i-1) ==0)    
{    
flag = false;    
plength = fibMod.size()-2;    
}    
i++;    
} 

if(n >= m)
{
if(m == 0) 
sum1 = 0;   
else      
p = fibMod.get((int)((m+1) % plength));

sum1= (p == 0) ? 9: p -1;


if(n == 0) 
sum2 = 0;   
else      
q = fibMod.get((int)((n+2) % plength));

sum2= (q == 0) ? 9: q -1;


if(sum1 > sum2)
{
	System.out.println(sum2 - sum1 + 10);
	}
else
{
	System.out.println(sum2 - sum1);
	}
}
else
	return;

}    
} 