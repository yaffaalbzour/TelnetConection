//java socket client example
import java.io.*;
import java.net.*;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class TelnetClientConnection{
	
	private static Socket s;
	@DataProvider
	public static Object[] provideCommand(){
		return new Object[] {"show version"};
	}
	@Test(dataProvider="provideCommand")
    public static void CreateConnection(String cmd) throws IOException {
        s = new Socket();
        PrintWriter s_out = null;
        BufferedReader s_in = null;
        try {
        	s.connect(new InetSocketAddress("10.63.10.222" , 23));
                       
        //writer for socket
            s_out = new PrintWriter( s.getOutputStream(), true);
            
            //reader for socket
           
            s_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            }catch (UnknownHostException e){
            System.err.println("Don't know about host : ");
            System.exit(1);
        }  
        //Send message to server
       sendCmd(s_out, "en");
       //sendEnter(s_out);
       sendCmd(s_out, "cisco");
      // sendEnter(s_out);
       System.out.println("***Connected***"); 
        // 
       sendCmd(s_out, cmd);
       sendEnter(s_out); //sendEnter(s_out); sendEnter(s_out);
	    //Get response from server
       System.out.println("**Message sent**");
	    String response =s_in.readLine();
	    response = s_in.readLine();
	    response = s_in.readLine();
	    response = s_in.readLine();
	    int tries =0;
	    
	    		while ((response= s_in.readLine()) != null) {
	    	
//	    while ( s_in.readLine() !=null) { 
	    	//if(s_in.readLine() !=null) {System.out.print(tries);}
	    	System.out.println(response);
//	    	System.out.println(s_in.readLine());
	    	response = s_in.readLine();
	    	
	    	tries++;
	    	
	    	
	    	//
	    	//sendCmd(s_out,"show run");
	   }
	    System.out.println("yafa123");
    }
	/*Hint counter = 0;
	while (!(output.contains("--More--") || counter<20)) {
		
		output  = getOutputfromdevice();
		counter++;
		
	}*/
	
	public static void sendEnter(PrintWriter s_out){
		String cmd = "\n";
        s_out.print( cmd );
	}
	public static void sendCmd(PrintWriter s_out, String cmd) {
		s_out.println( cmd );
	}
}