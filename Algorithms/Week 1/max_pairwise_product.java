/*Author - Akash
Data Structures and Algotithms
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class max_pairwise_product
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		ArrayList<Long> list = new ArrayList<>();
		for(int i=0; i <n; i++)
		{
			list.add(i, scan.nextLong());
		}
		Collections.sort(list);
		
		
		System.out.println(list.get(n-1) * list.get(n-2));
	}
}