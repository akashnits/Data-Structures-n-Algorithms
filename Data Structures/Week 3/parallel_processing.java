/* package whatever; // don't place package name! */ 
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
/* Name of the class has to be "Main" only if the class is public. */ 
class parallel_processing 
{ 
    private static Threads[] th; 
    private static int noth; 
    public static void main (String[] args) throws java.lang.Exception 
    { 
        int nojb; 
        Scanner scan = new Scanner(System.in); 
        noth = scan.nextInt(); 
        nojb = scan.nextInt(); 
        th = new Threads[noth]; 
         
        int[] jobDuration = new int[nojb]; 
        for(int j=0; j < nojb; j++){ 
            jobDuration[j]= scan.nextInt(); 
        } 
        for(int i=0; i< noth; i++){ 
            th[i]= new parallel_processing().new Threads(i, jobDuration[i]); 
            System.out.println(th[i].getName() + " " + "0"); 
        } 
         
        if(noth > 1){ 
        for(int k = (noth/2 -1); k>=0; k--){ 
            siftDown(k); 
        } 
        } 
         
         
        for(int l=0; l< (nojb-noth); l++){ 
            Threads t = getMin(); 
            System.out.println(t.getName() + " " + t.getDuration()); 
            th[0].setDuration(th[0].getDuration() + jobDuration[l+noth]); 
            siftDown(0); 
        } 
    } 
        public static Threads getMin(){ 
            return th[0]; 
        } 
         
        public static void siftDown(int z){ 
            int minIndex= z; 
            int lChild, rChild; 
            lChild = 2*z+1; 
            rChild= 2*z +2; 
            if(lChild < noth){ 
                if(th[minIndex].getDuration() > th[lChild].getDuration() || (th[minIndex].getDuration() == th[lChild].getDuration()) && th[lChild].getName() < th[minIndex].getName()){ 
                minIndex= lChild; 
            } 
        } 
            if(rChild < noth ){ 
                if(th[minIndex].getDuration() > th[rChild].getDuration() || (th[minIndex].getDuration() == th[rChild].getDuration()) && th[rChild].getName() < th[minIndex].getName()){ 
                minIndex= rChild; 
            } 
            } 
             
            if(z != minIndex){ 
                Threads temp = th[minIndex]; 
                th[minIndex]= th[z]; 
                th[z]= temp; 
                siftDown(minIndex); 
            } 
            } 
     
     class Threads{ 
        private  int name; 
        private  long duration; 
  
        Threads(int name, long duration){ 
            this.name = name; 
            this.duration = duration; 
        } 
         
        public  void setName(int name){ 
            this.name = name; 
        } 
        public  void setDuration(long duration){ 
            this.duration = duration; 
        } 
        public  int getName(){ 
            return this.name; 
        } 
        public  long getDuration(){ 
            return this.duration; 
        } 
    } 
} 