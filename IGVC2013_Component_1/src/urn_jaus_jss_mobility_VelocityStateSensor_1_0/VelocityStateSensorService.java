
package src.urn_jaus_jss_mobility_VelocityStateSensor_1_0;

import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;
import framework.Service;
import framework.JausUtils;
import framework.transport.JausRouter;
import framework.internalEvents.*;
import src.urn_jaus_jss_core_Transport_1_0.TransportService;
import src.urn_jaus_jss_core_Events_1_0.EventsService;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.Messages.*;


public class VelocityStateSensorService extends Service{

		public VelocityStateSensor_ReceiveFSM pVelocityStateSensor_ReceiveFSM;
	public VelocityStateSensor_SendFSM pVelocityStateSensor_SendFSM;


	public VelocityStateSensorService(JausRouter jausRouter , TransportService pTransportService, EventsService pEventsService)
	{

	pVelocityStateSensor_ReceiveFSM = new VelocityStateSensor_ReceiveFSM(pTransportService.pTransport_ReceiveFSM, pEventsService.pEvents_ReceiveFSM);
	pVelocityStateSensor_ReceiveFSM.setHandler(ieHandler, jausRouter);
	pVelocityStateSensor_ReceiveFSM.setupNotifications();
	pVelocityStateSensor_SendFSM = new VelocityStateSensor_SendFSM(pTransportService.pTransport_SendFSM, pEventsService.pEvents_SendFSM);
	pVelocityStateSensor_SendFSM.setHandler(ieHandler, jausRouter);
	pVelocityStateSensor_SendFSM.setupNotifications();


	}
	
	public void run(){

		// Perform any entry actions specified by the start state.

		

		// Kick off  receive loop...
		super.run();
	}

	//	This is the function that will process an event either generated
	//  by the service, sent to it by another service on the same component,
	//  or as a message sent by a different component. 
	public synchronized boolean processTransitions(InternalEvent ie)
	{
	    boolean done = false;

		// Invoke the FSM transition for this event.
			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVelocityState.ID)
					{
						QueryVelocityState msg = new QueryVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pVelocityStateSensor_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

	

	    return done;
	}


	//	This is the function that will check for default transitions if
	//  no other transitions were satisfied. 
	//
	public synchronized boolean defaultTransitions(InternalEvent ie)
	{
	    boolean done = false;

		// Invoke the FSM transition for this event.
			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVelocityState.ID)
					{
						QueryVelocityState msg = new QueryVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_ReceiveFSM.context.QueryVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateEvent.ID)
					{
						CreateEvent msg = new CreateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_ReceiveFSM.context.CreateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == UpdateEvent.ID)
					{
						UpdateEvent msg = new UpdateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_ReceiveFSM.context.UpdateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CancelEvent.ID)
					{
						CancelEvent msg = new CancelEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_ReceiveFSM.context.CancelEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEvents.ID)
					{
						QueryEvents msg = new QueryEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_ReceiveFSM.context.QueryEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventOccurred") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					EventOccurred casted_ie = (EventOccurred) ie;
						pVelocityStateSensor_ReceiveFSM.context.EventOccurredTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventError") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					EventError casted_ie = (EventError) ie;
						pVelocityStateSensor_ReceiveFSM.context.EventErrorTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Send") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					Send casted_ie = (Send) ie;
						pVelocityStateSensor_ReceiveFSM.context.SendTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastLocal") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					BroadcastLocal casted_ie = (BroadcastLocal) ie;
						pVelocityStateSensor_ReceiveFSM.context.BroadcastLocalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastGlobal") == 0 && (ie.getSource().compareTo("VelocityStateSensor_ReceiveFSM") != 0))
				{
					BroadcastGlobal casted_ie = (BroadcastGlobal) ie;
						pVelocityStateSensor_ReceiveFSM.context.BroadcastGlobalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVelocityState.ID)
					{
						QueryVelocityState msg = new QueryVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_SendFSM.context.QueryVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateEvent.ID)
					{
						CreateEvent msg = new CreateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_SendFSM.context.CreateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == UpdateEvent.ID)
					{
						UpdateEvent msg = new UpdateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_SendFSM.context.UpdateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CancelEvent.ID)
					{
						CancelEvent msg = new CancelEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_SendFSM.context.CancelEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEvents.ID)
					{
						QueryEvents msg = new QueryEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pVelocityStateSensor_SendFSM.context.QueryEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventOccurred") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					EventOccurred casted_ie = (EventOccurred) ie;
						pVelocityStateSensor_SendFSM.context.EventOccurredTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventError") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					EventError casted_ie = (EventError) ie;
						pVelocityStateSensor_SendFSM.context.EventErrorTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Send") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					Send casted_ie = (Send) ie;
						pVelocityStateSensor_SendFSM.context.SendTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastLocal") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					BroadcastLocal casted_ie = (BroadcastLocal) ie;
						pVelocityStateSensor_SendFSM.context.BroadcastLocalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastGlobal") == 0 && (ie.getSource().compareTo("VelocityStateSensor_SendFSM") != 0))
				{
					BroadcastGlobal casted_ie = (BroadcastGlobal) ie;
						pVelocityStateSensor_SendFSM.context.BroadcastGlobalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

	

	    return done;
			}

}



