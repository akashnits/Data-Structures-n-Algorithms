/*Author - Akash
Data Structures and Algotithms
*/
import java.util.*;
public class majority_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt();
		int[] arr = new int[n];
		for(int j=0;j<n;j++)
			arr[j]= scan.nextInt();
		scan.close();
		
		int i=0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(arr[i], 1);
		if(n == 1)
		{
			System.out.println(1);
			return;
		}
		while(i < n-1)
		{
			i++;
			int element = arr[i];
			for(Map.Entry<Integer, Integer> entry: map.entrySet())
			{
				int key = entry.getKey();
				int count = entry.getValue();
				map.remove(key);
				if(element == key)
				{
					map.put(element, count+1);
				}
				else if(entry.getValue() > 0 && element != entry.getKey())
				{
					map.put(key, count-1);
				}
				else if(entry.getValue() == 0 && element != entry.getKey())
				{
					map.put(element, 1);
				}
			}
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet())
		{
			if(entry.getValue() > 0)
			{
				int majority_ele = entry.getKey();
				int k=0;
				int count=0;
				while(k<n)
				{
					if(majority_ele == arr[k])
					{count++;}
					k++;
				}
				if(count > n/2)
					System.out.println(1);
				else
					System.out.println(0);
			}
			else
			System.out.print(0);
		}
	}

}
