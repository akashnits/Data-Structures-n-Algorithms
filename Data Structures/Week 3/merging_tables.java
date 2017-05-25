import java.io.*; 
import java.util.Arrays; 
import java.util.Locale; 
import java.util.StringTokenizer; 
  
public class merging_tables { 
    private final InputReader reader; 
    private final OutputWriter writer; 
  
    public merging_tables(InputReader reader, OutputWriter writer) { 
        this.reader = reader; 
        this.writer = writer; 
    } 
  
    public static void main(String[] args) { 
        InputReader reader = new InputReader(System.in); 
        OutputWriter writer = new OutputWriter(System.out); 
        new merging_tables(reader, writer).run(); 
        writer.writer.flush(); 
    } 
  
    class Table { 
        Table parent; 
        int rank; 
        int numberOfRows; 
  
        Table(int numberOfRows) { 
            this.numberOfRows = numberOfRows; 
            rank = 0; 
            parent = this; 
        } 
        Table getParent() { 
            // find super parent and compress path 
            if(parent != this) 
                parent= parent.getParent(); 
            return parent; 
        } 
        public void setParent(Table parent){ 
            this.parent= parent; 
        } 
        public int getRank(){ 
            return this.rank; 
        } 
        public void setRank(int rank){ 
            this.rank= rank; 
        } 
        public int getNumberOfRows(){ 
            return this.numberOfRows; 
        } 
        public void setNumberOfRows(int numberOfRows){ 
            this.numberOfRows= numberOfRows; 
        } 
    } 
  
    int maximumNumberOfRows = -1; 
  
    void merge(Table destination, Table source) { 
        Table realDestination = destination.getParent(); 
        Table realSource = source.getParent(); 
        if (realDestination == realSource) { 
            return; 
        } 
        if(realSource.getRank() > realDestination.getRank()){ 
            realDestination.setParent(realSource); 
            realSource.setNumberOfRows(realSource.getNumberOfRows() + realDestination.getNumberOfRows()); 
            realDestination.setNumberOfRows(0); 
            if(realSource.getNumberOfRows() > maximumNumberOfRows){ 
                maximumNumberOfRows= realSource.getNumberOfRows(); 
            } 
        }else{ 
            realSource.setParent(realDestination); 
            realDestination.setNumberOfRows(realDestination.getNumberOfRows() + realSource.getNumberOfRows()); 
            realSource.setNumberOfRows(0); 
            if(realDestination.getNumberOfRows() > maximumNumberOfRows){ 
                maximumNumberOfRows= realDestination.getNumberOfRows(); 
            } 
        } 
        if(realSource.getRank() == realDestination.getRank()){ 
            realDestination.setRank(realDestination.getRank()+1); 
        } 
    } 
  
    public void run() { 
        int n = reader.nextInt(); 
        int m = reader.nextInt(); 
        Table[] tables = new Table[n]; 
        for (int i = 0; i < n; i++) { 
            int numberOfRows = reader.nextInt(); 
            tables[i] = new Table(numberOfRows); 
            maximumNumberOfRows = Math.max(maximumNumberOfRows, numberOfRows); 
        } 
        for (int i = 0; i < m; i++) { 
            int destination = reader.nextInt() - 1; 
            int source = reader.nextInt() - 1; 
            merge(tables[destination], tables[source]); 
            writer.printf("%d\n", maximumNumberOfRows); 
        } 
    } 
  
  
    static class InputReader { 
        public BufferedReader reader; 
        public StringTokenizer tokenizer; 
  
        public InputReader(InputStream stream) { 
            reader = new BufferedReader(new InputStreamReader(stream), 32768); 
            tokenizer = null; 
        } 
  
        public String next() { 
            while (tokenizer == null || !tokenizer.hasMoreTokens()) { 
                try { 
                    tokenizer = new StringTokenizer(reader.readLine()); 
                } catch (IOException e) { 
                    throw new RuntimeException(e); 
                } 
            } 
            return tokenizer.nextToken(); 
        } 
  
        public int nextInt() { 
            return Integer.parseInt(next()); 
        } 
  
        public double nextDouble() { 
            return Double.parseDouble(next()); 
        } 
  
        public long nextLong() { 
            return Long.parseLong(next()); 
        } 
    } 
  
    static class OutputWriter { 
        public PrintWriter writer; 
  
        OutputWriter(OutputStream stream) { 
            writer = new PrintWriter(stream); 
        } 
  
        public void printf(String format, Object... args) { 
            writer.print(String.format(Locale.ENGLISH, format, args)); 
        } 
    } 
} 
 