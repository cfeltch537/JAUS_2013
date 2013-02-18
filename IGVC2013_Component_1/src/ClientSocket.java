package src;

import java.net.*;

import java.io.*;

public class ClientSocket {//SocketClient
	//http://edn.embarcadero.com/article/31995
	//Sockets allow you the programmer to treat the network connection as you would any other I/O. 
	//(see your JBuilder help files or http://java.sun.com/j2se/1.5.0/docs/api/java/net/package-summary.html for more information). 
	
	
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	private Socket connection;
	
	ClientSocket(){}
	
	public static void main()
	{
		/**Define a host **/
		String host = "192.168.36.153";
		/**Define a port**/
		int port = 19998;

		StringBuffer instr = new StringBuffer();
		String TimeStamp;
		System.out.println("SocketClient initialized");

		try{//how to request a socket and establishing a connection
			/**obtain an address object of the server*/
			InetAddress address = InetAddress.getByName(host);
			/**Establish a socket connection*/
			Socket connection = new Socket(address, port);
			/** Intatiate a BufferedOutputStream object*/
			//BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
			ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
//			OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
			TimeStamp = new java.util.Date().toString();
			String proccess = "Calling the Socet Server on "+ host + "port "+ port+" at "+TimeStamp+(char) 13;

			oos.writeObject(proccess);
			oos.flush();
			
			//osw.write(proccess);
			
//			osw.flush();
			//BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
			ObjectInputStream ois  =  new ObjectInputStream(connection.getInputStream());
			
			/**Instantiate an InputStreamReader with the optional
			 * character encoding.
			 */

			//InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");
			Object o = ois.readObject();
			JausGUI.RobData = (double[]) o;
			System.out.println(JausGUI.RobData[0] + " " + JausGUI.RobData[1] + " " + JausGUI.RobData[2]+ " " + JausGUI.RobData[3]+ " " + JausGUI.RobData[4]);
			
			/**Read the socket's InputStream and append to a StringBuffer */
//			int c;
//			while ( (c = isr.read()) != 13)
//				instr.append( (char) c);

			/** Close the socket connection. */
			connection.close();
			System.out.println(instr);
		}
		catch (IOException f) {
			System.out.println("IOException: " + f);
		}
		catch (Exception g) {
			System.out.println("Exception: " + g);
		}
	}
	
 
	public void connect()
	//String host,int port
	{
		/**Define a host **/
		String host = "192.168.36.153";
		/**Define a port**/
		int port = 19998;

		StringBuffer instr = new StringBuffer();
		
		System.out.println("SocketClient initialized");

		try{//how to request a socket and establishing a connection
			/**obtain an address object of the server*/
			InetAddress address = InetAddress.getByName(host);
			/**Establish a socket connection*/
			connection = new Socket(address, port);

			this.oos = new ObjectOutputStream(connection.getOutputStream());
			this.ois =new ObjectInputStream(connection.getInputStream());
			/**Instantiate an InputStreamReader with the optional
			 * character encoding.
			 */

			
			/**Read the socket's InputStream and append to a StringBuffer */
//			int c;
//			while ( (c = isr.read()) != 13)
//				instr.append( (char) c);

			/** Close the socket connection. */
			
			System.out.println(instr);
		}
		catch (IOException f) {
			System.out.println("IOException: " + f);
		}
		catch (Exception g) {
			System.out.println("Exception: " + g);
		}
	}
	
	public void JausRequest()
	{
		Object o;
		try {
			String TimeStamp = new java.util.Date().toString();
			//String proccess = "Calling the Socet Server on "+ host + "port "+ port+" at "+TimeStamp+(char) 13;
			String proccess = "Rob Cody wants data@"+TimeStamp;
			oos.writeObject(proccess);
			oos.flush();
			
			o = ois.readObject();
			JausGUI.RobData = (double[]) o;
			System.out.println(JausGUI.RobData[0] + " " + JausGUI.RobData[1] + " " + JausGUI.RobData[2] + " " + JausGUI.RobData[3]+ " " + JausGUI.RobData[4]);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		public void close()
		{
			
			try {
				connection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
//servers 

//client

//have it send to itself



