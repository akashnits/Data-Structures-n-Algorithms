/*Author - Akash
Data Structures and Algotithms
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class largest_number
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n,j=1;
		boolean flag;
		
		Scanner scan = new Scanner(System.in);
		n= scan.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=0; i<n; i++)
		{
			a.add(scan.nextInt());
		}
		Collections.sort(a);
		Collections.reverse(a);
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(a.get(0));
		
		while(j < n)
		{
			int k=0;
			flag = false;
		 	int digit_to_insert = a.get(j);
		 	while(k < j)
		 	{
		 		flag = (insertion_to_left(digit_to_insert, answer.get(k)));
		 		if(flag)
		 		{
		 			answer.add(k, digit_to_insert);
		 			break;
		 		}
		 		k++;
		 	}
		 	if(!flag)
		 	{
		 		answer.add(digit_to_insert);
		 	}
		 	
		 	j++;
		}
		for(int y=0; y <n; y++)
		{
			System.out.print(answer.get(y)+ "");
		}
	}
	
	public static boolean insertion_to_left(int a, int b)
	{
		String first= a + "" + b;
		String second = b + "" + a;
		
		int sign = first.compareTo(second);
		return sign > 0? true: false;
	}
}