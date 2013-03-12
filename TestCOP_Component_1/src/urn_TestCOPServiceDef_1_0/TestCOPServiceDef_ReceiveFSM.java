
package src.urn_TestCOPServiceDef_1_0;

import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import framework.transport.JausRouter;
import framework.transport.JausAddress;
import framework.internalEvents.*;
import framework.internalEvents.Receive_1_0.Body.ReceiveRec;
import framework.internalEvents.Receive_1_0.Body.ReceiveRec.MessagePayload;
import framework.StateMachine;
import framework.messages.Message;
import statemap.*;
import src.JausCOP_GUI;
import src.urn_TestCOPServiceDef_1_0.InternalEvents.*;
import src.urn_TestCOPServiceDef_1_0.Messages.*;
import src.urn_TestCOPServiceDef_1_0.Messages.ConfirmControl.Body;



public class TestCOPServiceDef_ReceiveFSM extends StateMachine{
	protected boolean running;

    TestCOPServiceDef_ReceiveFSMContext context;
    DecimalFormat threeDec = new DecimalFormat("0.000");
    public static Long lastMsgID = null;			// The lasMsgID will be set after each instance of a NEW message
    String source = null;							// Its been seen that multiple response messages are coming from the server... May be expected behavior
    												// But for now these will be used to handle repeat messages; via informing the user only when a NEW message arrives
    												// 'NEW' meaning of different type of containing a different messageID; cannot compare entire messages
													// because the SequenceNumber will change in each response; two messages containing the same ID and different body are 
    												// never sent in response to a single query
	public TestCOPServiceDef_ReceiveFSM()
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new TestCOPServiceDef_ReceiveFSMContext(this);

}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{

	}

	/// Access for debug purposes
	public String getStateName()
	{
		return context.getState().getName();
	}

public void handleConfirmControlAction(ConfirmControl msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		Short ResponceCode = msg.getBody().getConfirmControlRec().getResponseCode();
		String responce = null;
		if(ResponceCode.equals((short) 0)){	responce = "'CONTROL_ACCEPTED'";
		}else if(ResponceCode.equals((short) 1)){	responce = "'NOT_AVAILABLE'";
		}else if(ResponceCode.equals((short) 2)){	responce = "'INSUFFICIENT_AUTHORITY'";
		}else{	responce = ResponceCode.toString() + "-> Unknown Responce Code";
		}
		//Handle Message Body Data
		JausCOP_GUI.addOutputText("RECIEVED: ConfirmControl Message (Source: " + source + "; Responce: "+ responce + ")");
		//Print message notification and data 
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleConfirmElementRequestAction(ConfirmElementRequest msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		JausCOP_GUI.addOutputText("RECIEVED: ConfirmElementRequest Message (Source: " + source + "; ResponceID: " + msg.getBody().getRequestIDRec().getRequestID()+")");
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleGUIactionsAction()
{
	//**********************************************************************
	// This should be removed from state machine during next COP Generation
	//**********************************************************************
}

public void handleQueryIdentificationAction(QueryIdentification msg, Receive.Body.ReceiveRec transportData)
{
	source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
	JausCOP_GUI.addOutputText("RECIEVED: QueryIdentification Message (Source: " + source + ")");
}

public void handleRejectControlAction(RejectControl msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		Short ResponceCode = msg.getBody().getRejectControlRec().getResponseCode();
		String responce = null;
		if(ResponceCode.equals((short) 0)){ 	responce = "'CONTROL_RELEASED'";
		}else if(ResponceCode.equals((short) 1)){	responce = "'NOT_AVAILABLE'";
		}else{	responce = ResponceCode.toString() + " -> Unknown Responce Code";}
		//Handle Message Body Data
		JausCOP_GUI.addOutputText("RECIEVED: RejectControl Message (Source: " + source + "; Responce: "+ responce + ")");
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}	
}

public void handleReportActiveElementAction(ReportActiveElement msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		JausCOP_GUI.textQueryActiveElement.setText(msg.getBody().getActiveElementRec().getElementUID()+"");
		JausCOP_GUI.addOutputText("RECIEVED: ReportActiveElementAction Message (Source: " + source + "; ElementUID: " + msg.getBody().getActiveElementRec().getElementUID());
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportControlAction(ReportControl msg, Receive.Body.ReceiveRec transportData)
{
	
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		String controller = msg.getBody().getReportControlRec().getSubsystemID()+"."+msg.getBody().getReportControlRec().getNodeID()+"."+msg.getBody().getReportControlRec().getComponentID();
		Short authority = msg.getBody().getReportControlRec().getAuthorityCode();
		//Handle Message Body Data
		JausCOP_GUI.addOutputText("RECIEVED: ReportControl Message (Source: " + source + "; Controller: "+ controller + "; AuthorityCode: " + authority.toString() + ")");
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportElementAction(ReportElementCount msg, Receive.Body.ReceiveRec transportData)
{//Should be named handleReportElementCountAction()...
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		JausCOP_GUI.addOutputText("RECIEVED: ReportElementCount Message (Source: " + source + "; Count: " + msg.getBody().getElementCountRec().getElementCount() + ")");
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportElementListAction(ReportElementList msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		String elementList = "";
		for(int i=0; i<msg.getBody().getElementList().getNumberOfElements(); i++){
			elementList = elementList + msg.getBody().getElementList().getElement(i).getElementUID() + ", ";
		}
		JausCOP_GUI.addOutputText("RECIEVED: ReportElementList Message (Source: " + source + "; ElementList: " + elementList + ")");
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportIdentificationAction(ReportIdentification msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		short queryType = msg.getBody().getReportIdentificationRec().getQueryType();
		int type = msg.getBody().getReportIdentificationRec().getType();
		String identification = msg.getBody().getReportIdentificationRec().getIdentification();
		//Handle Message Body Data
		JausCOP_GUI.addOutputText("RECIEVED: ReportIdentification Message (Source: " + source + "; QueryType: " + queryType + "; Type: "+type+"; ID: "+identification);
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportLocalPoseAction(ReportLocalPose msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		Double x = null;
		if(msg.getBody().getLocalPoseRec().isXValid()){
		x = msg.getBody().getLocalPoseRec().getX();
		}
		//Take x if available
		Double y = null;
		if(msg.getBody().getLocalPoseRec().isYValid()){
		y = msg.getBody().getLocalPoseRec().getY();
		}
		//Take Yaw if available
		Long day = null;
		Long hour = null;
		Long min = null;
		Long sec = null;
		Long msec = null;
		if(msg.getBody().getLocalPoseRec().isTimeStampValid()){
		day = msg.getBody().getLocalPoseRec().getTimeStamp().getDay();
		hour = msg.getBody().getLocalPoseRec().getTimeStamp().getHour();
		min = msg.getBody().getLocalPoseRec().getTimeStamp().getMinutes();
		sec = msg.getBody().getLocalPoseRec().getTimeStamp().getSeconds();
		msec = msg.getBody().getLocalPoseRec().getTimeStamp().getMilliseconds();
		}
		//Take xVel if available
		//Handle Message Body Data
		JausCOP_GUI.addOutputText("RECIEVED: ReportLocalPose Message (Source: " + source + "; X: " + threeDec.format(x) + "; Y: "+ threeDec.format(y) +"; Time Stamp (D:H:M:S:mS): "+day+":"+hour+":"+min+":"+sec+":"+msec+")");
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportLocalWaypointAction(ReportLocalWaypoint msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		JausCOP_GUI.textQueryLocalWaypoint.setText("( "+threeDec.format(msg.getBody().getLocalWaypointRec().getX())+" , "+threeDec.format(msg.getBody().getLocalWaypointRec().getY())+" )");
		JausCOP_GUI.addOutputText("RECIEVED: QueryLocalWaypoint Message (Source: " + source + "; X Position: " + msg.getBody().getLocalWaypointRec().getX()+ "; Y Position: " + msg.getBody().getLocalWaypointRec().getY());
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportServicesAction(ReportServices msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		JausCOP_GUI.addOutputText("RECIEVED: ReportServices Message ... Contents:");
		//Alert of recieved message; variable sized contents will print out next		
		for(int i = 0; i <= msg.getBody().getNodeList().getNumberOfElements(); i++){
			JausCOP_GUI.addOutputText("    Node ID: "+msg.getBody().getNodeList().getElement(i).getNodeRec().getNodeID());
			for(int j = 0; j <= msg.getBody().getNodeList().getElement(i).getComponentList().getNumberOfElements(); j++){
				JausCOP_GUI.addOutputText("        Comp ID: "+msg.getBody().getNodeList().getElement(i).getComponentList().getElement(i).getComponentRec().getComponentID()+"; Instance ID: "+msg.getBody().getNodeList().getElement(i).getComponentList().getElement(i).getComponentRec().getInstanceID());	
				for(int k = 0; k <= msg.getBody().getNodeList().getElement(i).getComponentList().getElement(j).getServiceList().getNumberOfElements(); k++){
					String uri = msg.getBody().getNodeList().getElement(i).getComponentList().getElement(j).getServiceList().getElement(k).getURI();
					short major = msg.getBody().getNodeList().getElement(i).getComponentList().getElement(j).getServiceList().getElement(k).getMajorVersionNumber();
					short minor = msg.getBody().getNodeList().getElement(i).getComponentList().getElement(j).getServiceList().getElement(k).getMinorVersionNumber();
					JausCOP_GUI.addOutputText("            Service: "+uri+" v"+major+"."+minor);					
				}
			}

		}
		//Handle Message Body Data; Print variable size contents to GUI
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportStatusAction(ReportStatus msg, Receive.Body.ReceiveRec transportData)
{
	String status = new String();
	Short msgStatus = msg.getBody().getReportStatusRec().getStatus();
	
	if(msgStatus.equals((short) 0)){
		status = "INIT";
	}else if(msgStatus.equals((short) 1)){
		status = "READY";
	}else if(msgStatus.equals((short) 2)){
		status = "STANDBY";
	}else if(msgStatus.equals((short) 3)){
		status = "SHUTDOWN";
	}else if(msgStatus.equals((short) 4)){
		status = "FAILURE";
	}else if(msgStatus.equals((short) 5)){
		status = "EMERGENCY";
	}
	
	JausCOP_GUI.addOutputText("RECIEVED: ReportStatus Message (Source: " + source + "; Status: " + status + "; Reserved: "+msg.getBody().getReportStatusRec().getReserved());
}

public void handleReportTravelSpeedAction(ReportTravelSpeed msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		JausCOP_GUI.textQueryTravelSpeed.setText(threeDec.format(msg.getBody().getTravelSpeedRec().getSpeed()));
		JausCOP_GUI.addOutputText("RECIEVED: ReportTravelSpeed Message (Source: " + source + "; ExecuteSpeed: " + msg.getBody().getTravelSpeedRec().getSpeed());
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void handleReportVelocityStateAction(ReportVelocityState msg, Receive.Body.ReceiveRec transportData)
{
	if(lastMsgID==null||!lastMsgID.equals(msg.getID())){ //Check that this message id not a repeat
		source = transportData.getSrcSubsystemID() + "." + transportData.getSrcNodeID()+"."+transportData.getSrcComponentID();
		//Set Source Address
		Double xVel = null;
		if(msg.getBody().getReportVelocityStateRec().isVelocity_XValid()){
		xVel = msg.getBody().getReportVelocityStateRec().getVelocity_X();
		}
		//Take xVel if available
		Double yawRate = null;
		if(msg.getBody().getReportVelocityStateRec().isYawRateValid()){
		yawRate = msg.getBody().getReportVelocityStateRec().getYawRate();
		}
		//Take Yaw if available
		Long day = null;
		Long hour = null;
		Long min = null;
		Long sec = null;
		Long msec = null;
		if(msg.getBody().getReportVelocityStateRec().isTimeStampValid()){
		day = msg.getBody().getReportVelocityStateRec().getTimeStamp().getDay();
		hour = msg.getBody().getReportVelocityStateRec().getTimeStamp().getHour();
		min = msg.getBody().getReportVelocityStateRec().getTimeStamp().getMinutes();
		sec = msg.getBody().getReportVelocityStateRec().getTimeStamp().getSeconds();
		msec = msg.getBody().getReportVelocityStateRec().getTimeStamp().getMilliseconds();
		}
		//Take xVel if available
		//Handle Message Body Data
		JausCOP_GUI.addOutputText("RECIEVED: ReportVelocityState Message (Source: " + source + "; X-Velovity: " + xVel + "; Yaw Rate: "+ yawRate +"; Time Stamp (D:H:M:S:mS): "+day+":"+hour+":"+min+":"+sec+":"+msec);
		//Print message notification and data
		lastMsgID = msg.getID();
		//Set Message ID to prevent duplicate notifications
	}
}

public void serviceInitializedAction()
{
	//Nothing Done
}

public void serviceStartedAction()
{
	JausCOP_GUI.addOutputText("COP Test Component started");
	ieHandler.invoke(new InitToReadyEventDef());
	JausCOP_GUI.addOutputText("Sent internal event to transition to Ready");
}

public boolean handleGUI()
{
	return true;
}

	
	
}

