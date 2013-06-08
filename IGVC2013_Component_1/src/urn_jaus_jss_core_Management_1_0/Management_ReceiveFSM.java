
package src.urn_jaus_jss_core_Management_1_0;

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
import src.urn_jaus_jss_core_Management_1_0.InternalEvents.*;
import src.urn_jaus_jss_core_Management_1_0.Messages.*;

import src.urn_jaus_jss_core_Transport_1_0.Transport_ReceiveFSM;
import src.urn_jaus_jss_core_Events_1_0.Events_ReceiveFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ConfirmControl;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.RejectControl;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportAuthority;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportControl;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportTimeout;


public class Management_ReceiveFSM extends StateMachine{
	protected boolean running;
	Transport_ReceiveFSM pTransport_ReceiveFSM;
	Events_ReceiveFSM pEvents_ReceiveFSM;
	AccessControl_ReceiveFSM pAccessControl_ReceiveFSM;
	static String stateString;
    static Management_ReceiveFSMContext context;

    //SUPER IMPORTANT NOTE: This service WILL be implemented diffenently that in AS5710
    // The emergency State is not neccessary and there for will not be used...
	
	public Management_ReceiveFSM(Transport_ReceiveFSM pTransport_ReceiveFSM, Events_ReceiveFSM pEvents_ReceiveFSM, AccessControl_ReceiveFSM pAccessControl_ReceiveFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new Management_ReceiveFSMContext(this);

	this.pTransport_ReceiveFSM = pTransport_ReceiveFSM;
	this.pEvents_ReceiveFSM = pEvents_ReceiveFSM;
	this.pAccessControl_ReceiveFSM = pAccessControl_ReceiveFSM;
}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pAccessControl_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled", ieHandler, "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "AccessControl_ReceiveFSM");
		pAccessControl_ReceiveFSM.registerNotification("Receiving_Ready_Controlled", ieHandler, "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "AccessControl_ReceiveFSM");
		pAccessControl_ReceiveFSM.registerNotification("Receiving_Ready", ieHandler, "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "AccessControl_ReceiveFSM");
		pAccessControl_ReceiveFSM.registerNotification("Receiving", ieHandler, "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "AccessControl_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Standby", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Init", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Failure", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Shutdown", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Emergency", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Standby", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_Controlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Ready", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_Controlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Emergency", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_Controlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_Controlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_Controlled", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready", "Management_ReceiveFSM");
		registerNotification("Receiving", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving", "Management_ReceiveFSM");

	}

	/// Access for debug purposes
	public static String getStateName()
	{
		return context.getState().getName();
	}

	public void DeleteIDAction(Receive.Body.ReceiveRec transportData)
{
	/// Insert User Code HERE
}

public void SendAction(String arg0, Receive.Body.ReceiveRec transportData)
{
	JausAddress source = new JausAddress(transportData.getSrcSubsystemID(), transportData.getSrcNodeID(), transportData.getSrcComponentID());
	String sourceString = source.getSubsystemID() + "." + source.getNodeID() + "." + source.getComponentID();
	// JAUS Address of received message source

	//JausGUI.addOutputText("State: "+JausGUI.txtManagementState.getText()+")");
	
	if(arg0.equals("ReportStatus")){
		ReportStatus rsMsg = new ReportStatus();
		
    	JausGUI.addOutputText("StateString "+ stateString);

		//Instantiate Message
		if(stateString.equals("Initialize")){
			rsMsg.getBody().getReportStatusRec().setStatus((short) 0);
		}else if(stateString.equals("Ready")){
			rsMsg.getBody().getReportStatusRec().setStatus((short) 1);
		}else if(stateString.equals("Standby")){
			rsMsg.getBody().getReportStatusRec().setStatus((short) 2);
		}else if(stateString.equals("Shutdown")){
			rsMsg.getBody().getReportStatusRec().setStatus((short) 3);
		}else{
			JausGUI.addOutputText("MGT: ERROR: State: "+stateString+")");
		}// 4 and 5 (failure and emergency are not implemented)	
		 //Fill body with Controller and AuthorityCode

		sendJausMessage(rsMsg,source);
		// Send message to source
		JausGUI.addOutputText("MGT: SENT: ReportStatus Message (Dest: " + sourceString + "; Status:" + rsMsg.getBody().getReportStatusRec().getStatus() +  ")");
	}else{
		JausGUI.addOutputText("MGT:ERROR: arg0: " + arg0);
	}
	JausGUI.btnUpdateMgtState.doClick();
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
			src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM.currentAuthorityCode = src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM.defaultAuthorityCode;
			src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM.controllingSubsystemID = 0; 
			src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM.controllingNodeID = 0;
			src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM.controllingComponentID = 0;
		    JausGUI.label_ControllingJausAddress.setText(src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM.controllingSubsystemID + "." + src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM.controllingNodeID + "." + src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM.controllingComponentID);
		    //Reinitialize Controlling Component Address and AuthorityCode for Non-Controlled State
			JausGUI.addOutputText("MGT: SENT: " + arg0 + " Message (Dest: " + sourceString + "; ResponseCode: " + arg1 + ")");
			JausGUI.setLED(JausGUI.led_Controlled, "greenOFF");
			//In NotControlled State; Controlled LED GreenOFF
		}else{
			JausGUI.addOutputText("MGT: INVALID ARGUMENT arg1 (" + arg1 + ") in SendAction(String arg0, String arg1, Receive.Body.ReceiveRec transportData); arg0 (" + arg0 + ")");
			}
	}else{
		JausGUI.addOutputText("MGT: INVALID ARGUMENT arg0 (" + arg0 + ") in SendAction(String arg0, String arg1, Receive.Body.ReceiveRec transportData)");
	}	
}

public void StoreIDAction(Receive.Body.ReceiveRec transportData)
{
	//NOT IMPLEMENTED
	//EMERGENCY STATES NOT USED IN THIS BUILD
	// Store ID is used to store the source of emergency messages
}

public void initializeAction()
{
	ieHandler.invoke(new Initialized());
	//Standby is entered when initialized
}

void popWrapper_0f9fae233502305d99c64a59f0f80a4e(ClearEmergency msg, Receive.Body.ReceiveRec transportData)
{
//	String tempstr ="Receiving_Ready_NotControlled_StateA_Emergency";
//	String tempstr2 = context.peakTopStateStack();
//	StringTokenizer leafStateTOK = new StringTokenizer(tempstr,"_");
//	StringTokenizer stackStateTOK = new StringTokenizer(tempstr2,"_");
//	String currentLeafStateTOK;
//	String currentStackStateTOK;
//
//	if(tempstr2.compareTo("Receiving_Ready_NotControlled_StateA_Emergency") == 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();

}

void popWrapper_baf5fee6be943f3c815a84f544a0981e(ClearEmergency msg, Receive.Body.ReceiveRec transportData)
{
//	String tempstr ="Receiving_Ready_Controlled_StateB_Emergency";
//	String tempstr2 = context.peakTopStateStack();
//	StringTokenizer leafStateTOK = new StringTokenizer(tempstr,"_");
//	StringTokenizer stackStateTOK = new StringTokenizer(tempstr2,"_");
//	String currentLeafStateTOK;
//	String currentStackStateTOK;
//
//	if(tempstr2.compareTo("Receiving_Ready_Controlled_StateB_Emergency") == 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();
//	if(currentLeafStateTOK.compareTo(currentStackStateTOK) != 0)
//	{
//		DeleteIDAction(transportData);
//		return;
//	}
//	currentLeafStateTOK = leafStateTOK.nextToken();
//	currentStackStateTOK = stackStateTOK.nextToken();

}

	public boolean isControllingClient(Receive.Body.ReceiveRec transportData)
{
	//// By default, inherited guards call the parent function.
	//// This can be replaced or modified as needed.
	return pAccessControl_ReceiveFSM.isControllingClient(transportData );
}

public boolean isIDStored(Receive.Body.ReceiveRec transportData)
{
	//NOT IMPLEMENTED
	//EMERGENCY STATES NOT USED IN THIS BUILD
	return false;
}


}

