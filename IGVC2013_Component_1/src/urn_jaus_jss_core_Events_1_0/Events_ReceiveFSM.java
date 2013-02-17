
package src.urn_jaus_jss_core_Events_1_0;

import java.util.StringTokenizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import framework.transport.JausRouter;
import framework.transport.JausAddress;
import framework.internalEvents.*;
import framework.StateMachine;
import framework.messages.Message;
import statemap.*;
import src.urn_jaus_jss_core_Events_1_0.InternalEvents.*;
import src.urn_jaus_jss_core_Events_1_0.Messages.*;

import src.urn_jaus_jss_core_Transport_1_0.Transport_ReceiveFSM;


public class Events_ReceiveFSM extends StateMachine{
	protected boolean running;
	Transport_ReceiveFSM pTransport_ReceiveFSM;

    Events_ReceiveFSMContext context;

    
	
	public Events_ReceiveFSM(Transport_ReceiveFSM pTransport_ReceiveFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new Events_ReceiveFSMContext(this);

	this.pTransport_ReceiveFSM = pTransport_ReceiveFSM;
}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pTransport_ReceiveFSM.registerNotification("Receiving", ieHandler, "InternalStateChange_To_Events_ReceiveFSM_Receiving_Ready", "Transport_ReceiveFSM");
		registerNotification("Receiving_Ready", pTransport_ReceiveFSM.getHandler(), "InternalStateChange_To_Transport_ReceiveFSM_Receiving", "Events_ReceiveFSM");
		registerNotification("Receiving", pTransport_ReceiveFSM.getHandler(), "InternalStateChange_To_Transport_ReceiveFSM_Receiving", "Events_ReceiveFSM");

	}

	/// Access for debug purposes
	public String getStateName()
	{
		return context.getState().getName();
	}

	public void SendAction(String arg0, CancelEvent msg, Receive.Body.ReceiveRec transportData)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void SendAction(String arg0, CreateEvent msg, Receive.Body.ReceiveRec transportData)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void SendAction(String arg0, QueryEvents msg, Receive.Body.ReceiveRec transportData)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void SendAction(String arg0, UpdateEvent msg, Receive.Body.ReceiveRec transportData)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void cancelEventAction(CancelEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void createEventAction(CreateEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void sendEventAction()
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void sendRejectEventRequestAction()
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void updateEventAction(CreateEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}

public void updateEventAction(UpdateEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
}



	public boolean eventExists()
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
	return false;
}

public boolean eventExists(CancelEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
	return false;
}

public boolean eventExists(CreateEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
	return false;
}

public boolean eventExists(UpdateEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
	return false;
}

public boolean isSupported(CreateEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
	return false;
}

public boolean isSupported(UpdateEvent msg)
{
	//NOT IMPLEMENTED (Events Service not required for 2013 Competition)
	return false;
}


}

