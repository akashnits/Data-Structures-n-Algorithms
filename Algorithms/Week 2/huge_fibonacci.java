/*Author - Akash
Data Structures and Algotithms
*/
  
  
import java.util.*;  
import java.lang.*;  
import java.io.*;  
  
  
/* Name of the class has to be "Main" only if the class is public. */  
class huge_fibonacci  
{  
public static void main (String[] args) throws java.lang.Exception  
{  
boolean flag = true;  
//long zero =0L;long one =1L; 
ArrayList<Integer> fibMod = new ArrayList<>();   
 
 
fibMod.add(0); fibMod.add(1); 
 
 
int i= 2;  
int plength=0, m;
long n;  
Scanner scan = new Scanner(System.in);  
n = scan.nextLong();  
m = scan.nextInt();  
while(flag)  
{  
fibMod.add(i, (fibMod.get(i-1) + fibMod.get(i-2)) % m);  
 
if(fibMod.get(i) == 1 && fibMod.get(i-1) ==0)  
{  
flag = false;  
plength = fibMod.size()-2;  
}  
i++;  
}  
//System.out.prlongln(plength); 
if(plength != 0) 
System.out.println(fibMod.get((int)(n % plength)));  
}  
} 