
package src.urn_jaus_jss_mobility_ListManager_1_0;

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
import src.urn_jaus_jss_mobility_ListManager_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.*;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementList.Body.ElementList;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementList.Body.ElementList.ElementListRec;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.SetElement.Body.SetElementSeq.ElementList.ElementRec;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.ReportLocalWaypoint;

import src.urn_jaus_jss_core_Transport_1_0.Transport_ReceiveFSM;
import src.urn_jaus_jss_core_Events_1_0.Events_ReceiveFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportAuthority;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportControl;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportTimeout;
import src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM;


public class ListManager_ReceiveFSM extends StateMachine{
	protected boolean running;
	Transport_ReceiveFSM pTransport_ReceiveFSM;
	Events_ReceiveFSM pEvents_ReceiveFSM;
	AccessControl_ReceiveFSM pAccessControl_ReceiveFSM;
	Management_ReceiveFSM pManagement_ReceiveFSM;
    ListManager_ReceiveFSMContext context;
    public static LinkedList<ElementRec> backupLinkedList = new LinkedList<ElementRec>();
    //This linked list should be populated if for some reason the judges SetMessage request gets directed here
	Short requestIDaccepted;
	
	public ListManager_ReceiveFSM(Transport_ReceiveFSM pTransport_ReceiveFSM, Events_ReceiveFSM pEvents_ReceiveFSM, AccessControl_ReceiveFSM pAccessControl_ReceiveFSM, Management_ReceiveFSM pManagement_ReceiveFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new ListManager_ReceiveFSMContext(this);
	this.pTransport_ReceiveFSM = pTransport_ReceiveFSM;
	this.pEvents_ReceiveFSM = pEvents_ReceiveFSM;
	this.pAccessControl_ReceiveFSM = pAccessControl_ReceiveFSM;
	this.pManagement_ReceiveFSM = pManagement_ReceiveFSM;
}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Standby", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Init", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Failure", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Shutdown", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA_Emergency", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled_StateA", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_Controlled_StateB_Standby", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_Controlled_StateB_Ready", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_Controlled_StateB_Emergency", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_Controlled_StateB", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready_Controlled", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving_Ready", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "Management_ReceiveFSM");
		pManagement_ReceiveFSM.registerNotification("Receiving", ieHandler, "InternalStateChange_To_ListManager_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "Management_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Standby", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Init", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Failure", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Shutdown", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA_Emergency", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled_StateA", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled_StateA", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_NotControlled", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Standby", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Ready", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB_Emergency", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled_StateB", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_Controlled_StateB", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready_Controlled", "ListManager_ReceiveFSM");
		registerNotification("Receiving_Ready", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving_Ready", "ListManager_ReceiveFSM");
		registerNotification("Receiving", pManagement_ReceiveFSM.getHandler(), "InternalStateChange_To_Management_ReceiveFSM_Receiving", "ListManager_ReceiveFSM");

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
// 		NOT IMPLEMENTED****************
//			ReportElement reMsg = new ReportElement();
//			//Instantiate Message
//			// Fill body with Controller and AuthorityCode
//			sendJausMessage(rcMsg,source);
//			// Send message to source
//			JausGUI.addOutputText("LM: SENT: ReportElement Message (Dest: " + sourceString + "; ControllingComp:" + controllingComp + "; AuthorityCode: " + currentAuthorityCode +  ")");
		}else if(arg0.equals("ReportElementList")){ //Implemented but not required by IGVC JAUS Comp
			ReportElementList relMsg = new ReportElementList();
			String elementListString = new String("");
			//Instantiate Message
			ElementList localWaypointList = new ElementList();
			for(int i=0; i < src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.localWaypointLinkedList.size(); i++){
				ElementListRec temp = new ElementListRec();
				temp.setElementUID(src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.localWaypointLinkedList.get(i).getElementUID());
				elementListString = elementListString + src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.localWaypointLinkedList.get(i).getElementUID()+" , ";
				localWaypointList.addElement(temp);
			}
			relMsg.getBody().setElementList(localWaypointList);
			//Fill body with list and fill String with UID values for debugging
			sendJausMessage(relMsg,source);
			// Send message to source
			JausGUI.addOutputText("LM: SENT: ReportElementList Message (Dest: " + sourceString + "; Element List: " + elementListString + ")");
		}else if(arg0.equals("ReportElementCount")){ 
			ReportElementCount recMsg = new ReportElementCount();
			//Instantiate message
			src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementCount.Body.ElementCountRec ecr = new src.urn_jaus_jss_mobility_ListManager_1_0.Messages.ReportElementCount.Body.ElementCountRec();
			ecr.setElementCount(src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.localWaypointLinkedList.size());
			recMsg.getBody().setElementCountRec(ecr);
			//Fill body
			sendJausMessage(recMsg,source);
			//Send Message to source
			JausGUI.addOutputText("LM: SENT: ReportElementCount Message  (Dest: " + sourceString + "; Count: "+ src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.localWaypointLinkedList.size() +")");
		}else if(arg0.equals("ConfirmElementRequest")){ 
			ConfirmElementRequest cerMsg = new ConfirmElementRequest();
			//Instantiate message
			cerMsg.getBody().getRequestIDRec().setRequestID(requestIDaccepted);
			//Fill body
			sendJausMessage(cerMsg,source);
			//Send Message to source
			JausGUI.addOutputText("LM: SENT: ConfirmElementRequest Message  (Dest: " + sourceString + "; RequestID: "+ requestIDaccepted + ")");
		}
//		else if(arg0.equals("RejectElementRequest")){ 
////	 	NOT IMPLEMENTED****************
//		}
		else{
			JausGUI.addOutputText("LM: INVALID ARGUMENT arg0 (" + arg0 + ") in SendAction(String arg0, Receive.Body.ReceiveRec transportData)");
			//If arg0 not found error message is sent
		}
}

public void deleteElementAction()
{
	//NOT IMPLEMENTED
}

public void setElementAction(SetElement msg)
{
//	JausGUI.addOutputText("LM: Entered SetElementAction");
// THIS SHOULD NEVER BE ENTERED THE ONLY REASON THE LIST MANAGER SERVICE IS USED IS TO BE
// INHERITED BY THE LOCAL WAYPOINT DRIVER SERVICE
	
// Maybe: we can implement is just in case the message is decoded incorrectly and sent here, but that  shouldn't happen
}



	public boolean elementExists(DeleteElement msg)
{
	/// Insert User Code HERE
	return true;
}

public boolean elementExists(QueryElement msg)
{
	/// Insert User Code HERE
	return true;
}

public boolean isControllingClient(Receive.Body.ReceiveRec transportData)
{
	//// By default, inherited guards call the parent function.
	//// This can be replaced or modified as needed.
	return pAccessControl_ReceiveFSM.isControllingClient(transportData );
}

public boolean isElementSupported(SetElement msg)
{
//	if(src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.isElementSupported(msg)){
//		JausGUI.addOutputText("LM: Message SUPPORTED");
//	}else{
//		JausGUI.addOutputText("LM: Message NOT SUPPORTED!!!");
//	}
//	return src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.isElementSupported(msg);
	return true;
}

public boolean isValidElementRequest(SetElement msg)
{
//	Integer nextUID;
//	Integer previousUID;
//	Integer validCompCounter = 0;
//	for(int i = 0; i < msg.getBody().getSetElementSeq().getElementList().getNumberOfElements();i++){
//		nextUID = msg.getBody().getSetElementSeq().getElementList().getElement(i).getNextUID();
//		previousUID = msg.getBody().getSetElementSeq().getElementList().getElement(i).getPreviousUID();
//		for(int j = 0; j < localWaypointList.getNumberOfElements(); j++){
//			if(previousUID.equals(localWaypointList.getElement(j).getElementUID())){
//				if(nextUID.equals(localWaypointList.getElement(j+1).getElementUID())){
//					validCompCounter = validCompCounter + 1;
//				}
//			}
//		}
//	}
//	if(validCompCounter.equals(msg.getBody().getSetElementSeq().getElementList().getNumberOfElements())){
//		JausGUI.addOutputText("LM: Valid Element Request ");
//		return true;
//	}else{
//		JausGUI.addOutputText("LM: INVALID Element Request ");
//		return false;
//	}
	return true;
}


}

