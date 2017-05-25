/*Author - Akash
Data Structures and Algotithms
*/
 
 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
 
 
/* Name of the class has to be "Main" only if the class is public. */ 
class fractional_knapsack 
{ 
public static void main (String[] args) throws java.lang.Exception 
{ 
int n; 
double w_capacity, answer=0;
Scanner scan = new Scanner(System.in); 
n = scan.nextInt(); 
w_capacity = scan.nextDouble(); 
double[] ratio = new double[n]; 
HashMap<Double, Object> map = new HashMap<>();  
for(int i=0; i<n; i++) 
{ 
Item item = new Item(); 
item.setValue(scan.nextDouble()); 
item.setWeight(scan.nextDouble()); 
ratio[i] = item.getValue()/ item.getWeight(); 
map.put(ratio[i], item); 
} 

TreeMap<Double, Object> sorted_map = new TreeMap<Double, Object> (map);
Map<Double, Object> reverse_sorted = sorted_map.descendingMap();
/* for(Map.Entry m:  reverse_sorted.entrySet()) 
         {   
         System.out.println(m.getKey() +" "+ ((Item)m.getValue()).getValue() + " " + ((Item) m.getValue()).getWeight());   
         } */
         
         for(Map.Entry m: reverse_sorted.entrySet())
         {
         	double weight_of_item = ((Item) m.getValue()).getWeight();
         	
         	if(weight_of_item != 0 && w_capacity < weight_of_item)
         	{
         		answer = answer + w_capacity * (((Item) m.getValue()).getValue() / weight_of_item);
         		w_capacity =0;
         		break;
         	}
         	else
         	{
         		answer = answer + ((Item) m.getValue()).getValue();
         		w_capacity = w_capacity - weight_of_item;
         	}
         }
         
        
         System.out.println(answer);
}
}
 
 
class Item 
{ 
    private double value; 
    private double weight; 
     
    Item(){} 
     
     
    public void setValue(double v) 
    { 
    value = v; 
    } 
    public double getValue() 
    { 
    return this.value; 
    } 
     
    public void setWeight(double w) 
    { 
    weight = w; 
    } 
     
    public double getWeight() 
    { 
    return this.weight; 
    } 
}
