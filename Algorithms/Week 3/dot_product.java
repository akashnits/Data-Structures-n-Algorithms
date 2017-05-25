/*Author - Akash
Data Structures and Algotithms
*/
 
 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 
/* Name of the class has to be "Main" only if the class is public. */ 
class dot_product 
{ 
public static void main (String[] args) throws java.lang.Exception 
{ 
int n;
long sum=0L; 
Scanner scan = new Scanner(System.in); 
n = scan.nextInt(); 
ArrayList<Long> a = new ArrayList<>(); 
ArrayList<Long> b = new ArrayList<>(); 
for(int i=0; i< n; i++) 
{ 
a.add(i, scan.nextLong()); 
} 
for(int j=0; j< n; j++) 
{ 
b.add(j, scan.nextLong()); 
} 
Collections.sort(a); 
Collections.sort(b); 
for(int k=0; k< n; k++) 
{ 
sum = sum + (a.get(k)* b.get(k)); 
} 
System.out.println(sum); 
} 
}