
package src.urn_jaus_jss_mobility_LocalPoseSensor_1_0;

import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;
import framework.Service;
import framework.JausUtils;
import framework.transport.JausRouter;
import framework.internalEvents.*;
import src.urn_jaus_jss_core_Transport_1_0.TransportService;
import src.urn_jaus_jss_core_Events_1_0.EventsService;
import src.urn_jaus_jss_core_AccessControl_1_0.AccessControlService;
import src.urn_jaus_jss_mobility_LocalPoseSensor_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_LocalPoseSensor_1_0.Messages.*;


public class LocalPoseSensorService extends Service{

		public LocalPoseSensor_ReceiveFSM pLocalPoseSensor_ReceiveFSM;
	public LocalPoseSensor_SendFSM pLocalPoseSensor_SendFSM;


	public LocalPoseSensorService(JausRouter jausRouter , TransportService pTransportService, EventsService pEventsService, AccessControlService pAccessControlService)
	{

	pLocalPoseSensor_ReceiveFSM = new LocalPoseSensor_ReceiveFSM(pTransportService.pTransport_ReceiveFSM, pEventsService.pEvents_ReceiveFSM, pAccessControlService.pAccessControl_ReceiveFSM);
	pLocalPoseSensor_ReceiveFSM.setHandler(ieHandler, jausRouter);
	pLocalPoseSensor_ReceiveFSM.setupNotifications();
	pLocalPoseSensor_SendFSM = new LocalPoseSensor_SendFSM(pTransportService.pTransport_SendFSM, pEventsService.pEvents_SendFSM, pAccessControlService.pAccessControl_SendFSM);
	pLocalPoseSensor_SendFSM.setHandler(ieHandler, jausRouter);
	pLocalPoseSensor_SendFSM.setupNotifications();


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
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
						pLocalPoseSensor_ReceiveFSM.context.InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
						pLocalPoseSensor_ReceiveFSM.context.InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
						pLocalPoseSensor_ReceiveFSM.context.InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalPose.ID)
					{
						QueryLocalPose msg = new QueryLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalPoseSensor_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
						pLocalPoseSensor_ReceiveFSM.context.InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
						pLocalPoseSensor_ReceiveFSM.context.InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
						pLocalPoseSensor_ReceiveFSM.context.InternalStateChange_To_LocalPoseSensor_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalPose.ID)
					{
						QueryLocalPose msg = new QueryLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalPoseSensor_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalPose.ID)
					{
						SetLocalPose msg = new SetLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalPoseSensor_ReceiveFSM.context.ReceiveTransition(msg, transportData);
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
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalPose.ID)
					{
						SetLocalPose msg = new SetLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.SetLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalPose.ID)
					{
						QueryLocalPose msg = new QueryLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.QueryLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RequestControl.ID)
					{
						RequestControl msg = new RequestControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.RequestControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReleaseControl.ID)
					{
						ReleaseControl msg = new ReleaseControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.ReleaseControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryControl.ID)
					{
						QueryControl msg = new QueryControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.QueryControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAuthority.ID)
					{
						QueryAuthority msg = new QueryAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.QueryAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAuthority.ID)
					{
						SetAuthority msg = new SetAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.SetAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTimeout.ID)
					{
						QueryTimeout msg = new QueryTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.QueryTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateEvent.ID)
					{
						CreateEvent msg = new CreateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.CreateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == UpdateEvent.ID)
					{
						UpdateEvent msg = new UpdateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.UpdateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CancelEvent.ID)
					{
						CancelEvent msg = new CancelEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.CancelEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEvents.ID)
					{
						QueryEvents msg = new QueryEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_ReceiveFSM.context.QueryEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Timeout") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Timeout casted_ie = (Timeout) ie;
						pLocalPoseSensor_ReceiveFSM.context.TimeoutTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventOccurred") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					EventOccurred casted_ie = (EventOccurred) ie;
						pLocalPoseSensor_ReceiveFSM.context.EventOccurredTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventError") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					EventError casted_ie = (EventError) ie;
						pLocalPoseSensor_ReceiveFSM.context.EventErrorTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Send") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					Send casted_ie = (Send) ie;
						pLocalPoseSensor_ReceiveFSM.context.SendTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastLocal") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					BroadcastLocal casted_ie = (BroadcastLocal) ie;
						pLocalPoseSensor_ReceiveFSM.context.BroadcastLocalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastGlobal") == 0 && (ie.getSource().compareTo("LocalPoseSensor_ReceiveFSM") != 0))
				{
					BroadcastGlobal casted_ie = (BroadcastGlobal) ie;
						pLocalPoseSensor_ReceiveFSM.context.BroadcastGlobalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalPose.ID)
					{
						SetLocalPose msg = new SetLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.SetLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalPose.ID)
					{
						QueryLocalPose msg = new QueryLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.QueryLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RequestControl.ID)
					{
						RequestControl msg = new RequestControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.RequestControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReleaseControl.ID)
					{
						ReleaseControl msg = new ReleaseControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.ReleaseControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryControl.ID)
					{
						QueryControl msg = new QueryControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.QueryControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAuthority.ID)
					{
						QueryAuthority msg = new QueryAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.QueryAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAuthority.ID)
					{
						SetAuthority msg = new SetAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.SetAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTimeout.ID)
					{
						QueryTimeout msg = new QueryTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.QueryTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateEvent.ID)
					{
						CreateEvent msg = new CreateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.CreateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == UpdateEvent.ID)
					{
						UpdateEvent msg = new UpdateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.UpdateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CancelEvent.ID)
					{
						CancelEvent msg = new CancelEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.CancelEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEvents.ID)
					{
						QueryEvents msg = new QueryEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalPoseSensor_SendFSM.context.QueryEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Timeout") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Timeout casted_ie = (Timeout) ie;
						pLocalPoseSensor_SendFSM.context.TimeoutTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventOccurred") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					EventOccurred casted_ie = (EventOccurred) ie;
						pLocalPoseSensor_SendFSM.context.EventOccurredTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventError") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					EventError casted_ie = (EventError) ie;
						pLocalPoseSensor_SendFSM.context.EventErrorTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Send") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					Send casted_ie = (Send) ie;
						pLocalPoseSensor_SendFSM.context.SendTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastLocal") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					BroadcastLocal casted_ie = (BroadcastLocal) ie;
						pLocalPoseSensor_SendFSM.context.BroadcastLocalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastGlobal") == 0 && (ie.getSource().compareTo("LocalPoseSensor_SendFSM") != 0))
				{
					BroadcastGlobal casted_ie = (BroadcastGlobal) ie;
						pLocalPoseSensor_SendFSM.context.BroadcastGlobalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

	

	    return done;
			}

}



