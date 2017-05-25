/*Author - Akash
Data Structures and Algotithms
*/ 
   
   
import java.util.*;   
import java.lang.*;   
import java.io.*;   
   
   
/* Name of the class has to be "Main" only if the class is public. */   
class fibonacci_sum   
{   
public static void main (String[] args) throws java.lang.Exception   
{   
boolean flag = true;   
//long zero =0L;long one =1L;  
ArrayList<Integer> fibMod = new ArrayList<>();    
  
  
fibMod.add(0); fibMod.add(1);  
  
  
int i= 2,q=0;   
int plength=0; 
long n;   
Scanner scan = new Scanner(System.in);   
n = scan.nextLong();  
if(n == 0)
{
	System.out.println(n);
	return;
}	
  
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
//System.out.prlongln(plength);  
if(plength != 0)  
q = fibMod.get((int)((n+2) % plength));

if(q == 0)
{
	System.out.println(9);
}
else
{
	System.out.println(q -1);
}

}   
} 