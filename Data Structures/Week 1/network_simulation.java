import java.io.IOException; 
import java.util.ArrayDeque; 
import java.util.ArrayList; 
import java.util.Deque; 
import java.util.Scanner; 
  
class Request { 
    public Request(int arrival_time, int process_time) { 
        this.arrival_time = arrival_time; 
        this.process_time = process_time; 
    } 
  
    public int arrival_time; 
    public int process_time; 
} 
  
class Response { 
    public Response(boolean dropped, int start_time) { 
        this.dropped = dropped; 
        this.start_time = start_time; 
    } 
  
    public boolean dropped; 
    public int start_time; 
} 
  
class Buffer { 
    public Buffer(int size) { 
        this.size_ = size; 
        this.finish_time_ = new ArrayDeque<Integer>(); 
    } 
  
    public Response Process(Request request) { 
        // write your code here 
        Response response; 
        network_simulation.finish_time = network_simulation.finish_time + request.process_time; 
        while(finish_time_.peek() != null && finish_time_.peek() <= request.arrival_time){ 
                     finish_time_.poll(); 
                } 
                // try to add incoming packet to the queue and output the startTime of it's processing if successful  
                if(finish_time_.size() == size_){ 
                     network_simulation.finish_time = network_simulation.finish_time - request.process_time; 
                     response = new Response(true, 0); 
                } 
                else if(finish_time_.size() == 0 ){ 
                    finish_time_.offer(network_simulation.finish_time); 
                     response = new Response(false, request.arrival_time); 
                } 
                else{ 
                     response = new Response(false, finish_time_.peekLast()); 
                    finish_time_.offer(network_simulation.finish_time); 
                } 
        return response; 
    } 
  
    private int size_; 
    private Deque<Integer> finish_time_; 
} 
  
class network_simulation { 
    public static int finish_time; 
    private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException { 
        int requests_count = scanner.nextInt(); 
        ArrayList<Request> requests = new ArrayList<Request>(); 
        for (int i = 0; i < requests_count; ++i) { 
            int arrival_time = scanner.nextInt(); 
            int process_time = scanner.nextInt(); 
            requests.add(new Request(arrival_time, process_time)); 
        } 
        return requests; 
    } 
  
    private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) { 
        ArrayList<Response> responses = new ArrayList<Response>(); 
        for (int i = 0; i < requests.size(); ++i) { 
            responses.add(buffer.Process(requests.get(i))); 
        } 
        return responses; 
    } 
  
    private static void PrintResponses(ArrayList<Response> responses) { 
        for (int i = 0; i < responses.size(); ++i) { 
            Response response = responses.get(i); 
            if (response.dropped) { 
                System.out.println(-1); 
            } else { 
                System.out.println(response.start_time); 
            } 
        } 
    } 
  
    public static void main(String[] args) throws IOException { 
        Scanner scanner = new Scanner(System.in); 
  
        int buffer_max_size = scanner.nextInt(); 
        Buffer buffer = new Buffer(buffer_max_size); 
  
        ArrayList<Request> requests = ReadQueries(scanner); 
        finish_time= requests.get(0).arrival_time; 
        ArrayList<Response> responses = ProcessRequests(requests, buffer); 
        PrintResponses(responses); 
    } 
} 
 