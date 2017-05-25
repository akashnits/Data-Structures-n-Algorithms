/*Author - Akash
Data Structures and Algotithms
*/
import java.util.*;
public class inversions {
	
private static long count=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] arr = new long[n];
		for(int i=0; i<n; i++)
			arr[i]= scan.nextInt();
		scan.close();
		
		MergeSort(arr, 0, n-1);
		/*System.out.println();
		for(int f=0; f< n; f++)
		System.out.print(arr[f]+ " ");
		System.out.println();*/
		System.out.println(count);
	}
	
	public static void MergeSort(long arr[], int l, int r)
	{
		if(l>=r)
			return;
		int mid = (l+r)/2;
		MergeSort(arr, l, mid);
		MergeSort(arr, mid+1, r);
		Merge(arr, l, mid, r);
	}
	
	public static void Merge(long arr[], int l, int mid, int r)
	{
		int nL= mid - l+1;
		int nR= r- mid;
		long[] L= new long[nL];
		long[] R= new long[nR];
		
		for(int a=0; a<nL; a++)
			L[a]= arr[a+l];
		for(int b=0; b< nR; b++)
			R[b]= arr[mid+1+b];
		
		int m=0, n=0, k=l, p=0;
		while(m < nL && n < nR)
		{
			if(L[m] <= R[n])
			{
				arr[k]= L[m];
				m++;
			}
			else
			{
				arr[k]= R[n];
				count = count + (nL + n-p);
				//System.out.print(count + " ");
				n++;
			}
			k++;
			p++;
		}
		
		while(m < nL)
		{
			arr[k]= L[m];
			m++;
			k++;
		}
		while(n < nR)
		{
			arr[k]= R[n];
			n++;
			k++;
		}
	}

}
