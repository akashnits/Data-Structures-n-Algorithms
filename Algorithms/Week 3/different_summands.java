/*Author - Akash
Data Structures and Algotithms
*/ 
 
 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 
/* Name of the class has to be "Main" only if the class is public. */ 
class different_summands 
{ 
public static void main (String[] args) throws java.lang.Exception 
{ 
int n, counter =0; 
Scanner scan = new Scanner(System.in); 
n = scan.nextInt(); 
ArrayList<Integer> output = new ArrayList<>(); 
while(n >0) 
{ 
counter++; 
n = n- counter; 
if(n > counter) 
output.add(counter); 
else 
{output.add(n+ counter); 
break;} 
} 
System.out.println(output.size());
System.out.println();
for(int i=0; i < output.size(); i++) 
{ 
System.out.print(output.get(i)+ " " ); 
} 
} 
} 
 
 
