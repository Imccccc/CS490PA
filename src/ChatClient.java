import java.io.*;
import java.net.*;

public class ChatClient { 
	  public class sender implements Runnable {
		  PrintWriter out;
		  int rate;
		  String userInput;
		  BufferedReader stdIn;
		  public sender(PrintWriter out, int heartbeat_rate, BufferedReader in){
			  this.out = out;
			  this.rate = heartbeat_rate;
			  this.stdIn = in;
		  }
		  
		  public void run(){
			  try{
		            while ((userInput = stdIn.readLine()) != null) {
		                out.println(userInput);
		            }
				  
			  }catch(Exception e){
				  System.err.println("卧槽，出大事了！！");
			  }
		  }
	  }
	
    public static void main(String[] args) throws IOException {
        
    	System.out.println("What is your User name?");
        String hostName = "http://localhost";
        int portNumber = 8080;
        int heartbeat_rate = 50;
        
        Socket echoSocket = new Socket(hostName, portNumber);
        PrintWriter out =
            new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in =
            new BufferedReader(
                new InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));
        String userInput;
        String username;
        String serverMessage;
        

        try{
            if((username = stdIn.readLine())!=null){ // Register the user 
            	out.println(username);
            	serverMessage = in.readLine();
            	if(serverMessage.compareTo("ERROR") == 0){ // check the server state
            		System.err.println("Username already be registed by other User!");
            		System.exit(1);
            	}
            }
            
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}