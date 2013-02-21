package src;

import java.net.*;
import java.util.LinkedList;

import java.io.*;

import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.ReportLocalWaypoint;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.SetElement.Body.SetElementSeq.ElementList.ElementRec;

public class ClientSocket {//SocketClient
	//http://edn.embarcadero.com/article/31995
	//Sockets allow you the programmer to treat the network connection as you would any other I/O. 
	//(see your JBuilder help files or http://java.sun.com/j2se/1.5.0/docs/api/java/net/package-summary.html for more information). 
	
	
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket connection;
	private LinkedList<Object> setLocalPoseList = new LinkedList<Object>();
	private LinkedList<Object> setExecuteList = new LinkedList<Object>();
	private LinkedList<Object> setExecuteSpeed = new LinkedList<Object>();
	private Object[] RobData;
	private Object o;;
	
	ClientSocket(){}
	
//	public static void main()
//	{
//		/**Define a host **/
//		String host = "192.168.36.153";
//		/**Define a port**/
//		int port = 19998;
//
//		StringBuffer instr = new StringBuffer();
//		String TimeStamp;
//		System.out.println("SocketClient initialized");
//
//		try{//how to request a socket and establishing a connection
//			/**obtain an address object of the server*/
//			InetAddress address = InetAddress.getByName(host);
//			/**Establish a socket connection*/
//			Socket connection = new Socket(address, port);
//			/** Intatiate a BufferedOutputStream object*/
//			//BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
//			ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
////			OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
//			TimeStamp = new java.util.Date().toString();
//			String proccess = "Calling the Socet Server on "+ host + "port "+ port+" at "+TimeStamp+(char) 13;
//
//			oos.writeObject(proccess);
//			oos.flush();
//			
//			//osw.write(proccess);
//			
////			osw.flush();
//			//BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
//			ObjectInputStream ois  =  new ObjectInputStream(connection.getInputStream());
//			
//			/**Instantiate an InputStreamReader with the optional
//			 * character encoding.
//			 */
//
//			//InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");
//			Object o = ois.readObject();
//			
//			/**Read the socket's InputStream and append to a StringBuffer */
////			int c;
////			while ( (c = isr.read()) != 13)
////				instr.append( (char) c);
//
//			/** Close the socket connection. */
//			connection.close();
//			System.out.println(instr);
//		}
//		catch (IOException f) {
//			System.out.println("IOException: " + f);
//		}
//		catch (Exception g) {
//			System.out.println("Exception: " + g);
//		}
//	}
//	
// 
	public void connect()
	//String host,int port
	{
		/**Define a host **/
		String host = "192.168.35.235";
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
			
			System.out.println(instr);
		}
		catch (IOException f) {
			System.out.println("IOException: " + f);
		}
		catch (Exception g) {
			System.out.println("Exception: " + g);
		}
	}
	
	public void JausDataRequest()
	{
		try {
			Object[] messageID = new Object[] {4};
			
			oos.writeObject(messageID);
			oos.flush();
			
			o = ois.readObject();
			
			updateVariablesAndGUI(o);
		
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void SetLocalPoseRequest(Double x, Double y, Double yaw)
	{

		try {
			
			Integer messageID = 0;
		
			setLocalPoseList.add(messageID);
			setLocalPoseList.add(x);
			setLocalPoseList.add(y);
			setLocalPoseList.add(yaw);
			
			oos.writeObject(setLocalPoseList.toArray());
			oos.flush();
			
			o = ois.readObject();
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void ExecuteListRequest(LinkedList<ElementRec> waypointList, Double executeSpeed, Integer startElementPos)
	{
		ReportLocalWaypoint decodedWaypoint = new ReportLocalWaypoint();
		Integer messageID = 1;
		try {
			
			setExecuteList.add(messageID);
			
			for(int j=startElementPos; j<waypointList.size(); j++){
				decodedWaypoint.decode(waypointList.get(j).getElementData().getData(), 0);
				setExecuteList.add(new Object[] {waypointList.get(j).getElementUID(), decodedWaypoint.getBody().getLocalWaypointRec().getX(), decodedWaypoint.getBody().getLocalWaypointRec().getY()});
			}
			
			oos.writeObject(setExecuteList.toArray());
			oos.flush();
			
			o = ois.readObject();
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void SetSpeedRequest(Double executeSpeed)
	{

		Integer messageID = 2;
		try {
			
			setExecuteSpeed.add(messageID);
			setExecuteSpeed.add(executeSpeed);
			
			oos.writeObject(setExecuteSpeed.toArray());
			oos.flush();
			
			o = ois.readObject();
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public void Shutdown()
	{

		Object[] messageID = new Object[] {3};
		try {
			
			oos.writeObject(messageID);
			oos.flush();
			
			o = ois.readObject();
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
		public void close()
		{
			
			try {
				connection.close();
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		
		private void updateVariablesAndGUI(Object o){
			RobData = (Object[]) o;
			
			
			JausGUI.robot_x_position = (Double) RobData[0];
			JausGUI.robot_y_position = (Double) RobData[1];
			JausGUI.robot_yaw_position = (Double) RobData[2];
			JausGUI.robot_x_velocity = (Double) RobData[3];
			JausGUI.robot_omega = (Double) RobData[4];
			JausGUI.robot_desired_speed = (Double) RobData[5];
			JausGUI.robot_Active_Element_UID = (Integer) RobData[6];
			JausGUI.robot_LocalWaypoint_X = (Double) RobData[7];
			JausGUI.robot_LocalWaypoint_Y = (Double) RobData[8];
			
			JausGUI.updateRobotValues();
			
			System.out.println("-------------------------------------------");
			System.out.println("X Position:         " + RobData[0]);
			System.out.println("Y Position:         " + RobData[1]);
			System.out.println("YAW Position:       " + RobData[2]);
			System.out.println("X Velocity:         " + RobData[3]);
			System.out.println("Omega:              " + RobData[4]);
			System.out.println("Desired Speed:      " + RobData[5]);
			System.out.println("Active Element UID: " + RobData[6]);
			System.out.println("Local Waypoint X:   " + RobData[7]);
			System.out.println("Local Waypoint Y:   " + RobData[8]);
			
		}
	
}
//servers 

//client

//have it send to itself



