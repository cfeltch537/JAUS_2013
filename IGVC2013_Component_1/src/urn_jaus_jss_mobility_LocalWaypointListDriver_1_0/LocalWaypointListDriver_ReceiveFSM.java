
package src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import framework.transport.JausRouter;
import framework.transport.JausAddress;
import framework.internalEvents.*;
import framework.StateMachine;
import framework.messages.Message;
import statemap.*;
import src.JausGUI;

import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.*;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.ReportLocalWaypoint.Body.LocalWaypointRec;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.SetElement.Body.SetElementSeq.ElementList.ElementRec;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.SetElement.Body.SetElementSeq.ElementList.ElementRec.ElementData;

import src.urn_jaus_jss_core_Transport_1_0.Transport_ReceiveFSM;
import src.urn_jaus_jss_core_Events_1_0.Events_ReceiveFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM;
import src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM;
import src.urn_jaus_jss_mobility_ListManager_1_0.ListManager_ReceiveFSM;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ConfirmElementRequest;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementCount;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementList;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementList.Body.ElementList;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementList.Body.ElementList.ElementListRec;


public class LocalWaypointListDriver_ReceiveFSM extends StateMachine{
	protected boolean running;
	Transport_ReceiveFSM pTransport_ReceiveFSM;
	Events_ReceiveFSM pEvents_ReceiveFSM;
	AccessControl_ReceiveFSM pAccessControl_ReceiveFSM;
	Management_ReceiveFSM pManagement_ReceiveFSM;
	static ListManager_ReceiveFSM pListManager_ReceiveFSM;

    LocalWaypointListDriver_ReceiveFSMContext context;
    
	
	public LocalWaypointListDriver_ReceiveFSM(Transport_ReceiveFSM pTransport_ReceiveFSM, Events_ReceiveFSM pEvents_ReceiveFSM, AccessControl_ReceiveFSM pAccessControl_ReceiveFSM, Management_ReceiveFSM pManagement_ReceiveFSM, ListManager_ReceiveFSM pListManager_ReceiveFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new LocalWaypointListDriver_ReceiveFSMContext(this);

	this.pTransport_ReceiveFSM = pTransport_ReceiveFSM;
	this.pEvents_ReceiveFSM = pEvents_ReceiveFSM;
	this.pAccessControl_ReceiveFSM = pAccessControl_ReceiveFSM;
	this.pManagement_ReceiveFSM = pManagement_ReceiveFSM;
	this.pListManager_ReceiveFSM = pListManager_ReceiveFSM;
}
	public static LinkedList<ElementRec> localWaypointLinkedList = new LinkedList<ElementRec>();
	public static Integer activeWaypointListPosition = 0;
	public static Short requestIDaccepted;
	public static Double executeSpeed = 0.0;
	public DecimalFormat threeDec = new DecimalFormat("0.000");

	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Standby", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Init", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Failure", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Shutdown", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Emergency", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_Controlled_StateB_Standby", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_Controlled_StateB_Ready", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_Controlled_StateB_Emergency", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_Controlled_StateB", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready_Controlled", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving_Ready", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "ListManager_ReceiveFSM");
		pListManager_ReceiveFSM.registerNotification("Receiving", ieHandler, "InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Standby", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Init", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Failure", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Shutdown", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Emergency", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Standby", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Ready", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Emergency", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving_Ready", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready", "LocalWaypointListDriver_ReceiveFSM");
		registerNotification("Receiving", pListManager_ReceiveFSM.getHandler(), "InternalStateChange_To_ListManager_ReceiveFSM_Receiving", "LocalWaypointListDriver_ReceiveFSM");

	}

	/// Access for debug purposes
	public String getStateName()
	{
		return context.getState().getName();
	}

	public void SendAction(String arg0, Receive.Body.ReceiveRec transportData)
{
		JausAddress source = new JausAddress(transportData.getSrcSubsystemID(), transportData.getSrcNodeID(), transportData.getSrcComponentID());
		String sourceString = source.getSubsystemID() + "." + source.getNodeID() + "." + source.getComponentID();
		// JAUS Address of received message source
	
		if(arg0.equals("ReportElement")){
			//NOT IMPLEMENTED****************
			JausGUI.addOutputText("LWD: ReportElement NOT SUPPORTED");
		}else if(arg0.equals("ReportElementList")){ 
			ReportElementList relMsg = new ReportElementList();
			String elementListString = new String("");
			//Instantiate Message
			ElementList localWaypointList = new ElementList();
			for(int i=0; i < localWaypointLinkedList.size(); i++){
				ElementListRec temp = new ElementListRec();
				temp.setElementUID(localWaypointLinkedList.get(i).getElementUID());
				elementListString = elementListString + localWaypointLinkedList.get(i).getElementUID()+" , ";
				localWaypointList.addElement(temp);
			}
			relMsg.getBody().setElementList(localWaypointList);
			//Fill body with list and fill String with UID values for debugging
			sendJausMessage(relMsg,source);
			// Send message to source
			JausGUI.addOutputText("LWD: SENT: ReportElementList Message (Dest: " + sourceString + "; Element List: " + elementListString + ")");
		}else if(arg0.equals("ReportElementCount")){ 
			ReportElementCount recMsg = new ReportElementCount();
			//Instantiate message
			src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementCount.Body.ElementCountRec ecr = new src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementCount.Body.ElementCountRec();
			ecr.setElementCount(localWaypointLinkedList.size());
			recMsg.getBody().setElementCountRec(ecr);
			//Fill body with WaypointList Size
			sendJausMessage(recMsg,source);
			//Send Message to source
			JausGUI.addOutputText("LWD: SENT: ReportElementCount Message  (Dest: " + sourceString + "Count: "+ localWaypointLinkedList.size() +")");
		}else if(arg0.equals("ConfirmElementRequest")){ 
			ConfirmElementRequest cerMsg = new ConfirmElementRequest();
			//Instantiate message
			cerMsg.getBody().getRequestIDRec().setRequestID(requestIDaccepted);
			//Fill body
			sendJausMessage(cerMsg,source);
			//Send Message to source
			JausGUI.addOutputText("LWD: SENT: ConfirmElementRequest Message  (Dest: " + sourceString + "RequestID: "+ requestIDaccepted + ")");
		}
		else if(arg0.equals("RejectElementRequest")){ 
			//NOT IMPLEMENTED****************
			JausGUI.addOutputText("LWD: RejectElementRequest NOT SUPPORTED");
		}
		else if(arg0.equals("ReportLocalWaypoint")){ 
			ReportLocalWaypoint rlwMsg = new ReportLocalWaypoint();
			//Instantiate message
			ReportLocalWaypoint current = new ReportLocalWaypoint();
			//LocalWaypointRec instantiated to hold Rec after decoding it from the ElementData
			current.decode(localWaypointLinkedList.get(activeWaypointListPosition).getElementData().getData(), 0);
			//Decode data into ReportLocalWaypoint
			rlwMsg.getBody().getLocalWaypointRec().setX(current.getBody().getLocalWaypointRec().getX());
			rlwMsg.getBody().getLocalWaypointRec().setY(current.getBody().getLocalWaypointRec().getY());
			//Fill body with necessary fields (X and Y)
			sendJausMessage(rlwMsg,source);
			//Send Message to source
			JausGUI.addOutputText("LWD: SENT: ReportLocalWaypoint Message  (Dest: " + sourceString + "Waypoint X Pos: "+ rlwMsg.getBody().getLocalWaypointRec().getX() + "Waypoint Y Pos: "+ rlwMsg.getBody().getLocalWaypointRec().getY() + ")");
		}else if(arg0.equals("ReportActiveElement")){ 
			ReportActiveElement raeMsg = new ReportActiveElement();
			//Instantiate message
			raeMsg.getBody().getActiveElementRec().setElementUID(localWaypointLinkedList.get(activeWaypointListPosition).getElementUID());
			//Fill body with necessary fields current waypoint element UID
			sendJausMessage(raeMsg,source);
			//Send Message to source
			JausGUI.addOutputText("LWD: SENT: ReportActiveElement Message  (Dest: " + sourceString + "Active Waypoint Element UID: "+ raeMsg.getBody().getActiveElementRec().getElementUID() + ")");
		}else if(arg0.equals("ReportTravelSpeed")){ 
			//NOTE: This message returns the COMMANDED TRAVEL SPEED not the current Travel Speed
			ReportTravelSpeed rtsMsg = new ReportTravelSpeed();
			//Instantiate message
			rtsMsg.getBody().getTravelSpeedRec().setSpeed(executeSpeed);
			//Fill body with necessary fields current waypoint element UID
			sendJausMessage(rtsMsg,source);
			//Send Message to source
			JausGUI.addOutputText("LWD: SENT: ReportTravelSpeed Message  (Dest: " + sourceString + " Execute Speed: "+rtsMsg.getBody().getTravelSpeedRec().getSpeed()+ ")");
		}else{
			JausGUI.addOutputText("LWD: INVALID ARGUMENT arg0 (" + arg0 + ") in SendAction(String arg0, Receive.Body.ReceiveRec transportData)");
			//If arg0 not found error message is sent
		}
}

public void executeWaypointListAction(ExecuteList msg)
{
	// Execute List
	Integer UID = msg.getBody().getExecuteListRec().getElementUID();
	for(int j=0; j<localWaypointLinkedList.size(); j++){
		if(UID.equals(localWaypointLinkedList.get(j).getElementUID())){
		//If Element exists
			activeWaypointListPosition = j;
		}
	}
	executeSpeed = msg.getBody().getExecuteListRec().getSpeed();
	JausGUI.textExecuteSpeed.setText(threeDec.format(executeSpeed));
	ReportLocalWaypoint currentWaypoint = new ReportLocalWaypoint();
	//LocalWaypointRec instantiated to hold Rec after decoding it from the ElementData
	currentWaypoint.decode(localWaypointLinkedList.get(activeWaypointListPosition).getElementData().getData(), 0);
	//Decode data into LocalWaypointRec
	JausGUI.textLocalWaypoint.setText("( "+threeDec.format(currentWaypoint.getBody().getLocalWaypointRec().getX())+" , "+threeDec.format(currentWaypoint.getBody().getLocalWaypointRec().getY())+" )");
	JausGUI.textActiveWaypoint.setText(localWaypointLinkedList.get(activeWaypointListPosition).getElementUID()+"");
	// Stuff will be done HERE
	JausGUI.setLED(JausGUI.led_ListExecute, "greenON");
	JausGUI.addOutputText("LWD: List Executing");
}

public void modifyTravelSpeedAction(ExecuteList msg)
{
	/// Modifies Travel Speed when Execute Message is sent with no UID;
	executeSpeed = msg.getBody().getExecuteListRec().getSpeed();
	//Do Something Maybe......
	JausGUI.textExecuteSpeed.setText(threeDec.format(executeSpeed));
	JausGUI.addOutputText("LWD: Travel Speed Modified");
	
}

public void resetTravelSpeedAction()
{
	/// Insert User Code HERE
}

public void setElementAction(SetElement msg)
{
	JausGUI.addOutputText("LWD: Entered SetElementAction");
	Integer nextUID; //UID of element intended to be after setElement (0 for tail element)
	Integer previousUID; //UID of element intended to be before setElement (0 for head element)
	Integer ownUID; // UID of current element needing to be set
	Integer ElementsSet = 0; // counter to keep track the number of elements set
	String containedWaypoint;
	ElementRec currentRec = new ElementRec();
	ReportLocalWaypoint tempForGUI = new ReportLocalWaypoint();
	for(int i = 0; i<msg.getBody().getSetElementSeq().getElementList().getNumberOfElements(); i++){
		requestIDaccepted = msg.getBody().getSetElementSeq().getRequestIDRec().getRequestID();
		nextUID = msg.getBody().getSetElementSeq().getElementList().getElement(i).getNextUID();
		previousUID = msg.getBody().getSetElementSeq().getElementList().getElement(i).getPreviousUID();
		currentRec = msg.getBody().getSetElementSeq().getElementList().getElement(i);
		ownUID = msg.getBody().getSetElementSeq().getElementList().getElement(i).getElementUID();
		if(previousUID.equals(0)&&nextUID.equals(0)&&localWaypointLinkedList.size()==0){
			//If Element intended to be head element
				localWaypointLinkedList.add(0, currentRec);
				ElementsSet++;
				//Set element as Element 1 (Only Element)
				tempForGUI.decode(localWaypointLinkedList.get(0).getElementData().getData(), 0);
				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
				JausGUI.addOutputText("LWD: UID " + ownUID + " Element 1 (Only Element); "+containedWaypoint);
		}else if(previousUID.equals(0)&&nextUID.equals(localWaypointLinkedList.get(0).getElementUID())){
		//If Element intended to be head element
			localWaypointLinkedList.add(0, currentRec);
			ElementsSet++;
			//Set element as first
			localWaypointLinkedList.get(1).setPreviousUID(ownUID);
			tempForGUI.decode(localWaypointLinkedList.get(0).getElementData().getData(), 0);
			containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
			JausGUI.addOutputText("LWD: UID " + ownUID + " set as Element 1 "+containedWaypoint);
		}else if(nextUID.equals(0)&&previousUID.equals(localWaypointLinkedList.get(localWaypointLinkedList.size()-1).getElementUID())){
		//If Element intended to be tail element
			localWaypointLinkedList.add(currentRec);
			ElementsSet++;
			//Set element as first
			localWaypointLinkedList.get(localWaypointLinkedList.size()-2).setNextUID(ownUID);
			tempForGUI.decode(localWaypointLinkedList.get(localWaypointLinkedList.size()-1).getElementData().getData(), 0);
			containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
			JausGUI.addOutputText("LWD: UID " + ownUID + " set as Element " + localWaypointLinkedList.size() +" "+containedWaypoint);
		}else{
			for(int j=0; j<localWaypointLinkedList.size(); j++){
				if(previousUID.equals(localWaypointLinkedList.get(j).getElementUID())&&nextUID.equals(localWaypointLinkedList.get(j+1).getElementUID())){
				//If Element intended to inserted into list
					localWaypointLinkedList.add(j+1, currentRec);
					ElementsSet++;
					//Set element as first
					localWaypointLinkedList.get(j).setNextUID(ownUID);
					localWaypointLinkedList.get(j+2).setPreviousUID(ownUID);
					Integer j_inc = j + 2;
					tempForGUI.decode(localWaypointLinkedList.get(j+1).getElementData().getData(), 0);
					containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
					JausGUI.addOutputText("LWD: UID " + ownUID + " set as Element " + j_inc + " " + containedWaypoint);
					
				}
			}
		}
		if(!ElementsSet.equals(localWaypointLinkedList.size())){
			JausGUI.addOutputText("LWD: OOPS not all local waypoint elements were set!!!");
		}
	}
}

public boolean elementExists(ExecuteList msg)
{
	//If element UID given in execute message exists in localWaypoint list return true, else false
	Integer UID = msg.getBody().getExecuteListRec().getElementUID();
	for(int j=0; j<localWaypointLinkedList.size(); j++){
		if(UID.equals(localWaypointLinkedList.get(j).getElementUID())){
		//If Element exists
			JausGUI.addOutputText("LWD: ELEMENT EXISTS ");
			return true;
		}
	}
	JausGUI.addOutputText("LWD: ELEMENT DOES NOT EXISTS ");
	return false;
}

public boolean elementSpecified(ExecuteList msg)
{
	if(msg.getBody().getExecuteListRec().isElementUIDValid()){
		JausGUI.addOutputText("LWD: ELEMENT UID IS VALID");
		return true;
	}else{
		JausGUI.addOutputText("LWD: ELEMENT UID IS NOT VALID ");
		return false;
	}
	
}

public boolean isControllingClient(Receive.Body.ReceiveRec transportData)
{
	//// By default, inherited guards call the parent function.
	//// This can be replaced or modified as needed.
	return pAccessControl_ReceiveFSM.isControllingClient(transportData );
}

public static boolean isElementSupported(SetElement msg)
{
	//// By default, inherited guards call the parent function.
	//// This can be replaced or modified as needed.

	//
	// NOTE! Messages and internal events passed as arguments
	// in guards must be cast to the correct (parent) type.  Even
	// though these types are exactly the same, they fall under different
	// namespaces.  Instead of simple casting, Java and C# requires us to
	// serialize the child type and deserialize as the parent type so
	// this code gets a little wonky.
	//
	long bufsize; ByteBuffer buffer; int pos;

	bufsize = msg.getSize();
	buffer = ByteBuffer.allocate((int) bufsize);
	buffer.order(ByteOrder.LITTLE_ENDIAN);
	buffer.clear();
	pos = 0; msg.encode(buffer, pos);
	src.urn_jaus_jss_mobility_ListManager_1_0.Messages.SetElement casted_msg = new src.urn_jaus_jss_mobility_ListManager_1_0.Messages.SetElement();
	pos = 0; casted_msg.decode(buffer, pos);

	return pListManager_ReceiveFSM.isElementSupported(casted_msg );
	//return true;
}

public boolean isValidElementRequest(SetElement msg)
{
	//// By default, inherited guards call the parent function.
	//// This can be replaced or modified as needed.

	//
	// NOTE! Messages and internal events passed as arguments
	// in guards must be cast to the correct (parent) type.  Even
	// though these types are exactly the same, they fall under different
	// namespaces.  Instead of simple casting, Java and C# requires us to
	// serialize the child type and deserialize as the parent type so
	// this code gets a little wonky.
	//
	long bufsize; ByteBuffer buffer; int pos;

	bufsize = msg.getSize();
	buffer = ByteBuffer.allocate((int) bufsize);
	buffer.order(ByteOrder.LITTLE_ENDIAN);
	buffer.clear();
	pos = 0; msg.encode(buffer, pos);
	src.urn_jaus_jss_mobility_ListManager_1_0.Messages.SetElement casted_msg = new src.urn_jaus_jss_mobility_ListManager_1_0.Messages.SetElement();
	pos = 0; casted_msg.decode(buffer, pos);

	return pListManager_ReceiveFSM.isValidElementRequest(casted_msg );
	//return true;
}

public boolean waypointExists(QueryLocalWaypoint msg)
{
	if(!activeWaypointListPosition.equals(0)){
		return true;
	}else{
		return false;
	}
}


}

