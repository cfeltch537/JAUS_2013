
package src.urn_jaus_jss_core_AccessControl_1_0;

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
import src.urn_jaus_jss_core_AccessControl_1_0.InternalEvents.*;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.*;

import src.urn_jaus_jss_core_Transport_1_0.Transport_ReceiveFSM;
import src.urn_jaus_jss_core_Events_1_0.Events_ReceiveFSM;


public class AccessControl_ReceiveFSM extends StateMachine{
	protected boolean running;
	Transport_ReceiveFSM pTransport_ReceiveFSM;
	Events_ReceiveFSM pEvents_ReceiveFSM;
    static AccessControl_ReceiveFSMContext context;
    public static Short defaultAuthorityCode = 10;						//Default Authority (will be 0 for competition)
    public static Short currentAuthorityCode = defaultAuthorityCode; 	//current = default on startup and after release of control
    public static Integer controllingSubsystemID = new Integer(0); 		//Initial controlling JausAddress '0' (Not Controlled)
    public static Short controllingNodeID = new Short((short) 0);		//Initial controlling JausAddress '0' (Not Controlled)
    public static Short controllingComponentID = new Short((short) 0);	//Initial controlling JausAddress '0' (Not Controlled)
    public static Short accessControlTimeout = new Short((short) 0); 	//A timeout of '0' indicated this feature is disabled

    
	
	public AccessControl_ReceiveFSM(Transport_ReceiveFSM pTransport_ReceiveFSM, Events_ReceiveFSM pEvents_ReceiveFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new AccessControl_ReceiveFSMContext(this);
		// Send initial authority, controlling component and timeout (should all be '0')
		
	this.pTransport_ReceiveFSM = pTransport_ReceiveFSM;
	this.pEvents_ReceiveFSM = pEvents_ReceiveFSM;
	JausGUI.addOutputText("AC: Current Authority Code: " + currentAuthorityCode);
	JausGUI.addOutputText("AC: Current Controlling Component: " + controllingSubsystemID + "." + controllingNodeID + "." + controllingComponentID);
	JausGUI.addOutputText("AC: Current Timout (0 == disabled): " + accessControlTimeout);
	
}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pEvents_ReceiveFSM.registerNotification("Receiving_Ready", ieHandler, "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Events_ReceiveFSM");
		pEvents_ReceiveFSM.registerNotification("Receiving", ieHandler, "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Events_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled", pEvents_ReceiveFSM.getHandler(), "InternalStateChange_To_Events_ReceiveFSM_Receiving_Ready", "AccessControl_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled", pEvents_ReceiveFSM.getHandler(), "InternalStateChange_To_Events_ReceiveFSM_Receiving_Ready", "AccessControl_ReceiveFSM");
		registerNotification("Receiving_Ready", pEvents_ReceiveFSM.getHandler(), "InternalStateChange_To_Events_ReceiveFSM_Receiving_Ready", "AccessControl_ReceiveFSM");
		registerNotification("Receiving", pEvents_ReceiveFSM.getHandler(), "InternalStateChange_To_Events_ReceiveFSM_Receiving", "AccessControl_ReceiveFSM");
	}

	/// Access for debug purposes
	public static String getStateName()
	{
		return context.getState().getName();
	}

	public void ResetTimerAction()
{
	/// Timer will not be used (NOT IMPLEMENTED)
}

public void SendAction(String arg0, Receive.Body.ReceiveRec transportData)
{
	//This send action reports Control, Authority, or Timeout length, in response to the corresponding Query
	
	JausAddress source = new JausAddress(transportData.getSrcSubsystemID(), transportData.getSrcNodeID(), transportData.getSrcComponentID());
	String sourceString = source.getSubsystemID() + "." + source.getNodeID() + "." + source.getComponentID();
	// JAUS Address of received message source
	
	if(arg0.equals("ReportControl")){
		ReportControl rcMsg = new ReportControl();
		String controllingComp = controllingSubsystemID + "." + controllingNodeID + "." + controllingComponentID;
		//Instantiate Message
		rcMsg.getBody().getReportControlRec().setSubsystemID(controllingSubsystemID);
		rcMsg.getBody().getReportControlRec().setNodeID(controllingNodeID);
		rcMsg.getBody().getReportControlRec().setComponentID(controllingComponentID);
		rcMsg.getBody().getReportControlRec().setAuthorityCode(currentAuthorityCode);
		// Fill body with Controller and AuthorityCode
		sendJausMessage(rcMsg,source);
		// Send message to source
		JausGUI.addOutputText("AC: SENT: ReportControl Message (Dest: " + sourceString + "; ControllingComp:" + controllingComp + "; AuthorityCode: " + currentAuthorityCode +  ")");
	}else if(arg0.equals("ReportAuthority")){ //Implemented but not required by IGVC JAUS Comp
		ReportAuthority raMsg = new ReportAuthority();
		//Instantiate Message
		raMsg.getBody().getReportAuthorityRec().setAuthorityCode(currentAuthorityCode);
		//Fill body with AuthorityCode
		sendJausMessage(raMsg,source);
		// Send message to source
		JausGUI.addOutputText("AC: SENT: ReportAuthority Message (Dest: " + sourceString + "; AuthorityCode: " + currentAuthorityCode + ")");
	}else if(arg0.equals("ReportTimout")){ // Not used by Jaus Competition; but still implemented
		ReportTimeout rtMsg = new ReportTimeout();
		//Instantiate message
		sendJausMessage(rtMsg,source);
		//Send Message to source
		JausGUI.addOutputText("AC: SENT:ReportTimout Message  (Dest: " + sourceString + ")");
	}else{
		JausGUI.addOutputText("AC: INVALID ARGUMENT arg0 (" + arg0 + ") in SendAction(String arg0, Receive.Body.ReceiveRec transportData)");
		//If arg0 not found error message is sent
	}
}

public void SendAction(String arg0, String arg1)
{
	/// Not Used
}

public void SendAction(String arg0, String arg1, Receive.Body.ReceiveRec transportData)
{
	JausAddress source = new JausAddress(transportData.getSrcSubsystemID(), transportData.getSrcNodeID(), transportData.getSrcComponentID());
	String sourceString = source.getSubsystemID() + "." + source.getNodeID() + "." + source.getComponentID();
	
	if(arg0.equals("RejectControl")){
		if(arg1.equals("CONTROL_RELEASED")){
			RejectControl rcMsg = new RejectControl();
			// Instantiate Message
			rcMsg.getBody().getRejectControlRec().setResponseCode((short) 0); // 0 = CONTROL RELEASED
			// Response Code = Control REleased
			sendJausMessage(rcMsg, source);
			// Message sent
			currentAuthorityCode = defaultAuthorityCode;
			JausGUI.label_Authority.setText(currentAuthorityCode.toString());
		    controllingSubsystemID = 0; 
		    controllingNodeID = 0;
		    controllingComponentID = 0;
		    JausGUI.label_ControllingJausAddress.setText(controllingSubsystemID + "." + controllingNodeID + "." + controllingComponentID);
		    //Reinitialize Controlling Component Address and AuthorityCode for Non-Controlled State
			JausGUI.addOutputText("AC: SENT: " + arg0 + " Message (Dest: " + sourceString + "; ResponseCode: " + arg1 + ")");
			JausGUI.setLED(JausGUI.led_Controlled, "greenOFF");
			//In NotControlled State; Controlled LED GreenOFF

		}else if(arg1.equals("NOT_AVAILABLE")){
			RejectControl rcMsg = new RejectControl();
			rcMsg.getBody().getRejectControlRec().setResponseCode((short) 1); 
			// Response Code 1 = NOT AVAILABLE (as of now, system is always available)
			sendJausMessage(rcMsg, source);
			// Message Sent
			JausGUI.addOutputText("AC: SENT: " + arg0 + " Message (Dest: " + sourceString + "; ResponseCode: " + arg1 + ")");
		}else{
			JausGUI.addOutputText("AC: INVALID ARGUMENT arg1 (" + arg1 + ") in SendAction(String arg0, String arg1, Receive.Body.ReceiveRec transportData); arg0 (" + arg0 + ")");
		}
	}else if(arg0.equals("ConfirmControl")){
		if(arg1.equals("INSUFFICIENT_AUTHORITY")){
			ConfirmControl ccMsg = new ConfirmControl();
			//Instantiate Message
			ccMsg.getBody().getConfirmControlRec().setResponseCode((short) 2); // 2 = INSUFFICIENT AUTHORITY
			//Fill Body
			sendJausMessage(ccMsg, source);
			//Send Message
			JausGUI.addOutputText("AC: SENT: " + arg0 + " (Dest: " + sourceString + "; ResponseCode: " + arg1 + ")");
		}else if(arg1.equals("NOT_AVAILABLE")){
			ConfirmControl ccMsg = new ConfirmControl();
			//Instantiate Message
			ccMsg.getBody().getConfirmControlRec().setResponseCode((short) 1); // 1 = NOT AVAILABLE
			//Fill response code
			sendJausMessage(ccMsg, source);
			//Send Message
			JausGUI.addOutputText("AC: SENT: " + arg0 + " (Dest: " + sourceString + "; ResponseCode: " + arg1 + ")");
		}else if(arg1.equals("CONTROL_ACCEPTED")){
			ConfirmControl ccMsg = new ConfirmControl();
			// Instantiate Message
			ccMsg.getBody().getConfirmControlRec().setResponseCode((short) 0); // 0 = CONTROL ACCEPTED
			//Fill response code
			sendJausMessage(ccMsg, source);
			//Send Message
			JausGUI.setLED(JausGUI.led_Controlled, "greenON");
			//In Controlled State; Controlled LED GreenON
			JausGUI.addOutputText("AC: SENT: " + arg0 + " (Dest: " + sourceString + "; ResponseCode: " + arg1 + ")");
		}else{
			JausGUI.addOutputText("AC: INVALID ARGUMENT arg1 (" + arg1 + ") in SendAction(String arg0, String arg1, Receive.Body.ReceiveRec transportData); arg0 (" + arg0 + ")");
			}
	}else{
		JausGUI.addOutputText("AC: INVALID ARGUMENT arg0 (" + arg0 + ") in SendAction(String arg0, String arg1, Receive.Body.ReceiveRec transportData)");
	}	
}

public void SetAuthorityAction(RequestControl msg)
{
	/// Set the current authority value of this service to the specified authority
	currentAuthorityCode = msg.getBody().getRequestControlRec().getAuthorityCode();
	JausGUI.label_Authority.setText(currentAuthorityCode.toString());
}

public void SetAuthorityAction(SetAuthority msg)
{
	/// Set the current authority value of this service to the specified authority
	// Set Authority msg is deprecated in 1.1, but 1.0 is being used to meet compliance with Jaus Mobility
	currentAuthorityCode = msg.getBody().getAuthorityRec().getAuthorityCode();
}

public void StoreAddressAction(Receive.Body.ReceiveRec transportData)
{
	// Store the JAUS ID of the client that sent the message that caused this action to be executed ()
	 controllingSubsystemID = transportData.getSrcSubsystemID();
     controllingNodeID = transportData.getSrcNodeID();
     controllingComponentID = transportData.getSrcComponentID();
     JausGUI.label_ControllingJausAddress.setText(controllingSubsystemID + "." + controllingNodeID + "." + controllingComponentID);
}

public void initAction()
{
	//Nothing
}


	public boolean isAuthorityValid(SetAuthority msg)
{
	/// This guard is used only by the SetAuthority Message, which is deprecated in version 1.1
	if(defaultAuthorityCode<msg.getBody().getAuthorityRec().getAuthorityCode() && currentAuthorityCode>= msg.getBody().getAuthorityRec().getAuthorityCode()){
		return true;
	}
	return false;
}

public boolean isControlAvailable()
{
	//True if this service or services related to this service are not engaged in other operations that
	//would prevent this service from performing its actions.
	// For temporary purposes we will assume our system is always available
	return true;
}

public boolean isControllingClient(Receive.Body.ReceiveRec transportData)
{	   
	//True if query source is controlling component
	if(transportData.getSrcComponentID()==controllingComponentID && transportData.getSrcNodeID()==controllingNodeID && transportData.getSrcSubsystemID()==controllingSubsystemID){
		return true;
	}
	return false;
}

public boolean isCurrentAuthorityLess(RequestControl msg)
{
	if(currentAuthorityCode<msg.getBody().getRequestControlRec().getAuthorityCode()){ // Current Authority code less than requester
		return true;	
	}else{
		return false;
	}
}

public boolean isDefaultAuthorityGreater(RequestControl msg)
{
	if(defaultAuthorityCode>msg.getBody().getRequestControlRec().getAuthorityCode()){ // Default Authority code greater than requester
		return true;	
	}else{
		return false;
	}
}


}

