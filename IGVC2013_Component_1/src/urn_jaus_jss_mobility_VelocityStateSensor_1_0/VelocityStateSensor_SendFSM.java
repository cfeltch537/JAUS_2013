
package src.urn_jaus_jss_mobility_VelocityStateSensor_1_0;

import java.util.StringTokenizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import framework.transport.JausRouter;
import framework.transport.JausAddress;
import framework.internalEvents.*;
import framework.StateMachine;
import framework.messages.Message;
import statemap.*;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.Messages.*;

import src.urn_jaus_jss_core_Transport_1_0.Transport_SendFSM;
import src.urn_jaus_jss_core_Events_1_0.Events_SendFSM;


public class VelocityStateSensor_SendFSM extends StateMachine{
	protected boolean running;
	Transport_SendFSM pTransport_SendFSM;
	Events_SendFSM pEvents_SendFSM;

    VelocityStateSensor_SendFSMContext context;

    
	
	public VelocityStateSensor_SendFSM(Transport_SendFSM pTransport_SendFSM, Events_SendFSM pEvents_SendFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new VelocityStateSensor_SendFSMContext(this);

	this.pTransport_SendFSM = pTransport_SendFSM;
	this.pEvents_SendFSM = pEvents_SendFSM;
}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pEvents_SendFSM.registerNotification("Sending", ieHandler, "InternalStateChange_To_VelocityStateSensor_SendFSM_Sending", "Events_SendFSM");
		registerNotification("Sending", pEvents_SendFSM.getHandler(), "InternalStateChange_To_Events_SendFSM_Sending", "VelocityStateSensor_SendFSM");

	}

	/// Access for debug purposes
	public String getStateName()
	{
		return context.getState().getName();
	}

	

	
}

