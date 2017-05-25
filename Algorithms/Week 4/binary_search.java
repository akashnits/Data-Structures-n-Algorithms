
/*Author - Akash
Data Structures and Algotithms
*/
import java.util.*;
public class binary_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] sorted_array = new int[n];
		for(int i=0; i<n; i++)
		{
			sorted_array[i]= scan.nextInt();
		}
		int n_key = scan.nextInt();
		int[] key = new int[n_key];
		for(int j=0; j<n_key; j++)
		{
			key[j]= scan.nextInt();
		}
		
		scan.close();	
		for(int a=0; a< n_key; a++)
		{
		System.out.print((search(sorted_array, 0, n-1, key[a]) + " "));
		}
			
	}
	
	public static int search(int[] sorted_array, int l, int r, int key)
	{
		
		int mid = (l+r)/2;
		
		if(sorted_array[mid] == key)
		{
			return mid;
		}
		
		if (l >= r)
			return -1;
		
		if(sorted_array[mid] > key)
			return search(sorted_array, l, mid, key); 
		else
			return search(sorted_array, mid+1, r, key);
	}
}
