
package src.urn_jaus_jss_mobility_ListManager_1_0;

import java.util.StringTokenizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import framework.transport.JausRouter;
import framework.transport.JausAddress;
import framework.internalEvents.*;
import framework.StateMachine;
import framework.messages.Message;
import statemap.*;
import src.urn_jaus_jss_mobility_ListManager_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_ListManager_1_0.Messages.*;

import src.urn_jaus_jss_core_Transport_1_0.Transport_SendFSM;
import src.urn_jaus_jss_core_Events_1_0.Events_SendFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_SendFSM;
import src.urn_jaus_jss_core_Management_1_0.Management_SendFSM;


public class ListManager_SendFSM extends StateMachine{
	protected boolean running;
	Transport_SendFSM pTransport_SendFSM;
	Events_SendFSM pEvents_SendFSM;
	AccessControl_SendFSM pAccessControl_SendFSM;
	Management_SendFSM pManagement_SendFSM;

    ListManager_SendFSMContext context;

    
	
	public ListManager_SendFSM(Transport_SendFSM pTransport_SendFSM, Events_SendFSM pEvents_SendFSM, AccessControl_SendFSM pAccessControl_SendFSM, Management_SendFSM pManagement_SendFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new ListManager_SendFSMContext(this);

	this.pTransport_SendFSM = pTransport_SendFSM;
	this.pEvents_SendFSM = pEvents_SendFSM;
	this.pAccessControl_SendFSM = pAccessControl_SendFSM;
	this.pManagement_SendFSM = pManagement_SendFSM;
}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pManagement_SendFSM.registerNotification("Sending", ieHandler, "InternalStateChange_To_ListManager_SendFSM_Sending", "Management_SendFSM");
		registerNotification("Sending", pManagement_SendFSM.getHandler(), "InternalStateChange_To_Management_SendFSM_Sending", "ListManager_SendFSM");

	}

	/// Access for debug purposes
	public String getStateName()
	{
		return context.getState().getName();
	}

	

	
}

