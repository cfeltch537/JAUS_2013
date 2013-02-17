
package src.urn_TestCOPServiceDef_1_0;

import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;
import framework.Service;
import framework.JausUtils;
import framework.transport.JausRouter;
import framework.internalEvents.*;
import src.urn_TestCOPServiceDef_1_0.InternalEvents.*;
import src.urn_TestCOPServiceDef_1_0.Messages.*;


public class TestCOPServiceDefService extends Service{

		public TestCOPServiceDef_ReceiveFSM pTestCOPServiceDef_ReceiveFSM;
	public TestCOPServiceDef_SendFSM pTestCOPServiceDef_SendFSM;


	public TestCOPServiceDefService(JausRouter jausRouter )
	{

	pTestCOPServiceDef_ReceiveFSM = new TestCOPServiceDef_ReceiveFSM();
	pTestCOPServiceDef_ReceiveFSM.setHandler(ieHandler, jausRouter);
	pTestCOPServiceDef_ReceiveFSM.setupNotifications();
	pTestCOPServiceDef_SendFSM = new TestCOPServiceDef_SendFSM();
	pTestCOPServiceDef_SendFSM.setHandler(ieHandler, jausRouter);
	pTestCOPServiceDef_SendFSM.setupNotifications();


	}
	
	public void run(){

		// Perform any entry actions specified by the start state.
	pTestCOPServiceDef_ReceiveFSM.serviceStartedAction();

		

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
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_TestCOPServiceDef_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
						pTestCOPServiceDef_ReceiveFSM.context.InternalStateChange_To_TestCOPServiceDef_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InitToReadyEventDef") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					InitToReadyEventDef casted_ie = (InitToReadyEventDef) ie;
						pTestCOPServiceDef_ReceiveFSM.context.InitToReadyEventDefTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_TestCOPServiceDef_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
						pTestCOPServiceDef_ReceiveFSM.context.InternalStateChange_To_TestCOPServiceDef_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryIdentification.ID)
					{
						QueryIdentification msg = new QueryIdentification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportIdentification.ID)
					{
						ReportIdentification msg = new ReportIdentification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportServices.ID)
					{
						ReportServices msg = new ReportServices();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportControl.ID)
					{
						ReportControl msg = new ReportControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStatus.ID)
					{
						ReportStatus msg = new ReportStatus();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVelocityState.ID)
					{
						ReportVelocityState msg = new ReportVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalPose.ID)
					{
						ReportLocalPose msg = new ReportLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RejectControl.ID)
					{
						RejectControl msg = new RejectControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmControl.ID)
					{
						ConfirmControl msg = new ConfirmControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmElementRequest.ID)
					{
						ConfirmElementRequest msg = new ConfirmElementRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportElementList.ID)
					{
						ReportElementList msg = new ReportElementList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportElementCount.ID)
					{
						ReportElementCount msg = new ReportElementCount();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportActiveElement.ID)
					{
						ReportActiveElement msg = new ReportActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportTravelSpeed.ID)
					{
						ReportTravelSpeed msg = new ReportTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalWaypoint.ID)
					{
						ReportLocalWaypoint msg = new ReportLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pTestCOPServiceDef_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_TestCOPServiceDef_ReceiveFSM_Receiving_Init") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
						pTestCOPServiceDef_ReceiveFSM.context.InternalStateChange_To_TestCOPServiceDef_ReceiveFSM_Receiving_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_TestCOPServiceDef_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
						pTestCOPServiceDef_ReceiveFSM.context.InternalStateChange_To_TestCOPServiceDef_ReceiveFSM_ReceivingTransition(ie);
						done = true;
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
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAccelerationState.ID)
					{
						QueryAccelerationState msg = new QueryAccelerationState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryAccelerationStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryActiveElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAddition.ID)
					{
						QueryAddition msg = new QueryAddition();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryAdditionTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmEventRequest.ID)
					{
						ConfirmEventRequest msg = new ConfirmEventRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ConfirmEventRequestTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateCommandEvent.ID)
					{
						CreateCommandEvent msg = new CreateCommandEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.CreateCommandEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateEvent.ID)
					{
						CreateEvent msg = new CreateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.CreateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Event.ID)
					{
						Event msg = new Event();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.EventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ExecuteList.ID)
					{
						ExecuteList msg = new ExecuteList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ExecuteListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CancelEvent.ID)
					{
						CancelEvent msg = new CancelEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.CancelEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ClearEmergency.ID)
					{
						ClearEmergency msg = new ClearEmergency();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ClearEmergencyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CommandEvent.ID)
					{
						CommandEvent msg = new CommandEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.CommandEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmControl.ID)
					{
						ConfirmControl msg = new ConfirmControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ConfirmControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmElementRequest.ID)
					{
						ConfirmElementRequest msg = new ConfirmElementRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ConfirmElementRequestTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmSensorConfiguration.ID)
					{
						ConfirmSensorConfiguration msg = new ConfirmSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ConfirmSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == DeleteElement.ID)
					{
						DeleteElement msg = new DeleteElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.DeleteElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAccelerationLimit.ID)
					{
						QueryAccelerationLimit msg = new QueryAccelerationLimit();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryAccelerationLimitTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAnalogVideoSensorCapabilities.ID)
					{
						QueryAnalogVideoSensorCapabilities msg = new QueryAnalogVideoSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryAnalogVideoSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAnalogVideoSensorConfiguration.ID)
					{
						QueryAnalogVideoSensorConfiguration msg = new QueryAnalogVideoSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryAnalogVideoSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAuthority.ID)
					{
						QueryAuthority msg = new QueryAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedActuatorForceTorques.ID)
					{
						QueryCommandedActuatorForceTorques msg = new QueryCommandedActuatorForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryCommandedActuatorForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedEndEffectorPose.ID)
					{
						QueryCommandedEndEffectorPose msg = new QueryCommandedEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryCommandedEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedEndEffectorVelocityState.ID)
					{
						QueryCommandedEndEffectorVelocityState msg = new QueryCommandedEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryCommandedEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedJointPositions.ID)
					{
						QueryCommandedJointPositions msg = new QueryCommandedJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryCommandedJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedJointVelocities.ID)
					{
						QueryCommandedJointVelocities msg = new QueryCommandedJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryCommandedJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedPanTiltJointPositions.ID)
					{
						QueryCommandedPanTiltJointPositions msg = new QueryCommandedPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryCommandedPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedPanTiltJointVelocities.ID)
					{
						QueryCommandedPanTiltJointVelocities msg = new QueryCommandedPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryCommandedPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryConfiguration.ID)
					{
						QueryConfiguration msg = new QueryConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryControl.ID)
					{
						QueryControl msg = new QueryControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElement.ID)
					{
						QueryElement msg = new QueryElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElementCount.ID)
					{
						QueryElementCount msg = new QueryElementCount();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryElementCountTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElementList.ID)
					{
						QueryElementList msg = new QueryElementList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryElementListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEndEffectorEffort.ID)
					{
						QueryEndEffectorEffort msg = new QueryEndEffectorEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryEndEffectorEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEndEffectorPose.ID)
					{
						QueryEndEffectorPose msg = new QueryEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEndEffectorSpecification.ID)
					{
						QueryEndEffectorSpecification msg = new QueryEndEffectorSpecification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryEndEffectorSpecificationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEndEffectorVelocityState.ID)
					{
						QueryEndEffectorVelocityState msg = new QueryEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEventTimeout.ID)
					{
						QueryEventTimeout msg = new QueryEventTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryEventTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEvents.ID)
					{
						QueryEvents msg = new QueryEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGeomagneticProperty.ID)
					{
						QueryGeomagneticProperty msg = new QueryGeomagneticProperty();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryGeomagneticPropertyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGlobalPathSegment.ID)
					{
						QueryGlobalPathSegment msg = new QueryGlobalPathSegment();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryGlobalPathSegmentTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGlobalPose.ID)
					{
						QueryGlobalPose msg = new QueryGlobalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryGlobalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGlobalVector.ID)
					{
						QueryGlobalVector msg = new QueryGlobalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryGlobalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGlobalWaypoint.ID)
					{
						QueryGlobalWaypoint msg = new QueryGlobalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryGlobalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryHeartbeatPulse.ID)
					{
						QueryHeartbeatPulse msg = new QueryHeartbeatPulse();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryHeartbeatPulseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryIdentification.ID)
					{
						QueryIdentification msg = new QueryIdentification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryIdentificationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryJointEfforts.ID)
					{
						QueryJointEfforts msg = new QueryJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryJointForceTorques.ID)
					{
						QueryJointForceTorques msg = new QueryJointForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryJointForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryJointPositions.ID)
					{
						QueryJointPositions msg = new QueryJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryJointVelocities.ID)
					{
						QueryJointVelocities msg = new QueryJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalPathSegment.ID)
					{
						QueryLocalPathSegment msg = new QueryLocalPathSegment();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryLocalPathSegmentTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalPose.ID)
					{
						QueryLocalPose msg = new QueryLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalVector.ID)
					{
						QueryLocalVector msg = new QueryLocalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryLocalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryLocalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryManipulatorSpecifications.ID)
					{
						QueryManipulatorSpecifications msg = new QueryManipulatorSpecifications();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryManipulatorSpecificationsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryMotionProfile.ID)
					{
						QueryMotionProfile msg = new QueryMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltJointEfforts.ID)
					{
						QueryPanTiltJointEfforts msg = new QueryPanTiltJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryPanTiltJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltJointPositions.ID)
					{
						QueryPanTiltJointPositions msg = new QueryPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltJointVelocities.ID)
					{
						QueryPanTiltJointVelocities msg = new QueryPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltMotionProfile.ID)
					{
						QueryPanTiltMotionProfile msg = new QueryPanTiltMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryPanTiltMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltSpecifications.ID)
					{
						QueryPanTiltSpecifications msg = new QueryPanTiltSpecifications();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryPanTiltSpecificationsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryRangeSensorCapabilities.ID)
					{
						QueryRangeSensorCapabilities msg = new QueryRangeSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryRangeSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryRangeSensorCompressedData.ID)
					{
						QueryRangeSensorCompressedData msg = new QueryRangeSensorCompressedData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryRangeSensorCompressedDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryRangeSensorConfiguration.ID)
					{
						QueryRangeSensorConfiguration msg = new QueryRangeSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryRangeSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryRangeSensorData.ID)
					{
						QueryRangeSensorData msg = new QueryRangeSensorData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryRangeSensorDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QuerySensorGeometricProperties.ID)
					{
						QuerySensorGeometricProperties msg = new QuerySensorGeometricProperties();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QuerySensorGeometricPropertiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryServiceList.ID)
					{
						QueryServiceList msg = new QueryServiceList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryServiceListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryServices.ID)
					{
						QueryServices msg = new QueryServices();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryServicesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStatus.ID)
					{
						QueryStatus msg = new QueryStatus();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryStatusTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStillImageData.ID)
					{
						QueryStillImageData msg = new QueryStillImageData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryStillImageDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStillImageSensorCapabilities.ID)
					{
						QueryStillImageSensorCapabilities msg = new QueryStillImageSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryStillImageSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStillImageSensorConfiguration.ID)
					{
						QueryStillImageSensorConfiguration msg = new QueryStillImageSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryStillImageSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QuerySubsystemList.ID)
					{
						QuerySubsystemList msg = new QuerySubsystemList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QuerySubsystemListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTime.ID)
					{
						QueryTime msg = new QueryTime();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryTimeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTimeout.ID)
					{
						QueryTimeout msg = new QueryTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryToolOffset.ID)
					{
						QueryToolOffset msg = new QueryToolOffset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryToolOffsetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryTravelSpeedTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVelocityCommand.ID)
					{
						QueryVelocityCommand msg = new QueryVelocityCommand();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryVelocityCommandTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVelocityState.ID)
					{
						QueryVelocityState msg = new QueryVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVisualSensorCapabilities.ID)
					{
						QueryVisualSensorCapabilities msg = new QueryVisualSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryVisualSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVisualSensorConfiguration.ID)
					{
						QueryVisualSensorConfiguration msg = new QueryVisualSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryVisualSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryWrenchEffort.ID)
					{
						QueryWrenchEffort msg = new QueryWrenchEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.QueryWrenchEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RegisterServices.ID)
					{
						RegisterServices msg = new RegisterServices();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.RegisterServicesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RejectControl.ID)
					{
						RejectControl msg = new RejectControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.RejectControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RejectElementRequest.ID)
					{
						RejectElementRequest msg = new RejectElementRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.RejectElementRequestTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RejectEventRequest.ID)
					{
						RejectEventRequest msg = new RejectEventRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.RejectEventRequestTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReleaseControl.ID)
					{
						ReleaseControl msg = new ReleaseControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReleaseControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAccelerationLimit.ID)
					{
						ReportAccelerationLimit msg = new ReportAccelerationLimit();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportAccelerationLimitTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAccelerationState.ID)
					{
						ReportAccelerationState msg = new ReportAccelerationState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportAccelerationStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportActiveElement.ID)
					{
						ReportActiveElement msg = new ReportActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportActiveElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAddition.ID)
					{
						ReportAddition msg = new ReportAddition();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportAdditionTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAnalogVideoSensorCapabilities.ID)
					{
						ReportAnalogVideoSensorCapabilities msg = new ReportAnalogVideoSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportAnalogVideoSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAnalogVideoSensorConfiguration.ID)
					{
						ReportAnalogVideoSensorConfiguration msg = new ReportAnalogVideoSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportAnalogVideoSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAuthority.ID)
					{
						ReportAuthority msg = new ReportAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedActuatorForceTorques.ID)
					{
						ReportCommandedActuatorForceTorques msg = new ReportCommandedActuatorForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportCommandedActuatorForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedEndEffectorPose.ID)
					{
						ReportCommandedEndEffectorPose msg = new ReportCommandedEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportCommandedEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedEndEffectorVelocityState.ID)
					{
						ReportCommandedEndEffectorVelocityState msg = new ReportCommandedEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportCommandedEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedJointPositions.ID)
					{
						ReportCommandedJointPositions msg = new ReportCommandedJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportCommandedJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedJointVelocities.ID)
					{
						ReportCommandedJointVelocities msg = new ReportCommandedJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportCommandedJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedPanTiltJointPositions.ID)
					{
						ReportCommandedPanTiltJointPositions msg = new ReportCommandedPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportCommandedPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedPanTiltJointVelocities.ID)
					{
						ReportCommandedPanTiltJointVelocities msg = new ReportCommandedPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportCommandedPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportConfiguration.ID)
					{
						ReportConfiguration msg = new ReportConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportControl.ID)
					{
						ReportControl msg = new ReportControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportElement.ID)
					{
						ReportElement msg = new ReportElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportElementCount.ID)
					{
						ReportElementCount msg = new ReportElementCount();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportElementCountTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportElementList.ID)
					{
						ReportElementList msg = new ReportElementList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportElementListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEndEffectorEffort.ID)
					{
						ReportEndEffectorEffort msg = new ReportEndEffectorEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportEndEffectorEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEndEffectorPose.ID)
					{
						ReportEndEffectorPose msg = new ReportEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEndEffectorSpecification.ID)
					{
						ReportEndEffectorSpecification msg = new ReportEndEffectorSpecification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportEndEffectorSpecificationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEndEffectorVelocityState.ID)
					{
						ReportEndEffectorVelocityState msg = new ReportEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEventTimeout.ID)
					{
						ReportEventTimeout msg = new ReportEventTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportEventTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEvents.ID)
					{
						ReportEvents msg = new ReportEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGeomagneticProperty.ID)
					{
						ReportGeomagneticProperty msg = new ReportGeomagneticProperty();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportGeomagneticPropertyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGlobalPathSegment.ID)
					{
						ReportGlobalPathSegment msg = new ReportGlobalPathSegment();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportGlobalPathSegmentTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGlobalPose.ID)
					{
						ReportGlobalPose msg = new ReportGlobalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportGlobalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGlobalVector.ID)
					{
						ReportGlobalVector msg = new ReportGlobalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportGlobalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGlobalWaypoint.ID)
					{
						ReportGlobalWaypoint msg = new ReportGlobalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportGlobalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportHeartbeatPulse.ID)
					{
						ReportHeartbeatPulse msg = new ReportHeartbeatPulse();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportHeartbeatPulseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportIdentification.ID)
					{
						ReportIdentification msg = new ReportIdentification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportIdentificationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportJointEfforts.ID)
					{
						ReportJointEfforts msg = new ReportJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportJointForceTorques.ID)
					{
						ReportJointForceTorques msg = new ReportJointForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportJointForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportJointPositions.ID)
					{
						ReportJointPositions msg = new ReportJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportJointVelocities.ID)
					{
						ReportJointVelocities msg = new ReportJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalPathSegment.ID)
					{
						ReportLocalPathSegment msg = new ReportLocalPathSegment();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportLocalPathSegmentTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalPose.ID)
					{
						ReportLocalPose msg = new ReportLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalVector.ID)
					{
						ReportLocalVector msg = new ReportLocalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportLocalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalWaypoint.ID)
					{
						ReportLocalWaypoint msg = new ReportLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportLocalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportManipulatorSpecifications.ID)
					{
						ReportManipulatorSpecifications msg = new ReportManipulatorSpecifications();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportManipulatorSpecificationsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportMotionProfile.ID)
					{
						ReportMotionProfile msg = new ReportMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltJointEfforts.ID)
					{
						ReportPanTiltJointEfforts msg = new ReportPanTiltJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportPanTiltJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltJointPositions.ID)
					{
						ReportPanTiltJointPositions msg = new ReportPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltJointVelocities.ID)
					{
						ReportPanTiltJointVelocities msg = new ReportPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltMotionProfile.ID)
					{
						ReportPanTiltMotionProfile msg = new ReportPanTiltMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportPanTiltMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltSpecifications.ID)
					{
						ReportPanTiltSpecifications msg = new ReportPanTiltSpecifications();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportPanTiltSpecificationsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportRangeSensorCapabilities.ID)
					{
						ReportRangeSensorCapabilities msg = new ReportRangeSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportRangeSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportRangeSensorCompressedData.ID)
					{
						ReportRangeSensorCompressedData msg = new ReportRangeSensorCompressedData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportRangeSensorCompressedDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportRangeSensorConfiguration.ID)
					{
						ReportRangeSensorConfiguration msg = new ReportRangeSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportRangeSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportRangeSensorData.ID)
					{
						ReportRangeSensorData msg = new ReportRangeSensorData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportRangeSensorDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportSensorGeometricProperties.ID)
					{
						ReportSensorGeometricProperties msg = new ReportSensorGeometricProperties();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportSensorGeometricPropertiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportServiceList.ID)
					{
						ReportServiceList msg = new ReportServiceList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportServiceListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportServices.ID)
					{
						ReportServices msg = new ReportServices();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportServicesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStatus.ID)
					{
						ReportStatus msg = new ReportStatus();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportStatusTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStillImageData.ID)
					{
						ReportStillImageData msg = new ReportStillImageData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportStillImageDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStillImageSensorCapabilities.ID)
					{
						ReportStillImageSensorCapabilities msg = new ReportStillImageSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportStillImageSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStillImageSensorConfiguration.ID)
					{
						ReportStillImageSensorConfiguration msg = new ReportStillImageSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportStillImageSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportSubsystemList.ID)
					{
						ReportSubsystemList msg = new ReportSubsystemList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportSubsystemListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportTime.ID)
					{
						ReportTime msg = new ReportTime();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportTimeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportTimeout.ID)
					{
						ReportTimeout msg = new ReportTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportToolOffset.ID)
					{
						ReportToolOffset msg = new ReportToolOffset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportToolOffsetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportTravelSpeed.ID)
					{
						ReportTravelSpeed msg = new ReportTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportTravelSpeedTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVelocityCommand.ID)
					{
						ReportVelocityCommand msg = new ReportVelocityCommand();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportVelocityCommandTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVelocityState.ID)
					{
						ReportVelocityState msg = new ReportVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVisualSensorCapabilities.ID)
					{
						ReportVisualSensorCapabilities msg = new ReportVisualSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportVisualSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVisualSensorConfiguration.ID)
					{
						ReportVisualSensorConfiguration msg = new ReportVisualSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportVisualSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportWrenchEffort.ID)
					{
						ReportWrenchEffort msg = new ReportWrenchEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ReportWrenchEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RequestControl.ID)
					{
						RequestControl msg = new RequestControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.RequestControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Reset.ID)
					{
						Reset msg = new Reset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ResetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Resume.ID)
					{
						Resume msg = new Resume();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ResumeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAccelerationLimit.ID)
					{
						SetAccelerationLimit msg = new SetAccelerationLimit();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetAccelerationLimitTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetActuatorForceTorques.ID)
					{
						SetActuatorForceTorques msg = new SetActuatorForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetActuatorForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAnalogVideoSensorConfiguration.ID)
					{
						SetAnalogVideoSensorConfiguration msg = new SetAnalogVideoSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetAnalogVideoSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAuthority.ID)
					{
						SetAuthority msg = new SetAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEmergency.ID)
					{
						SetEmergency msg = new SetEmergency();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetEmergencyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEndEffectorEffort.ID)
					{
						SetEndEffectorEffort msg = new SetEndEffectorEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetEndEffectorEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEndEffectorPose.ID)
					{
						SetEndEffectorPose msg = new SetEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEndEffectorVelocityState.ID)
					{
						SetEndEffectorVelocityState msg = new SetEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetGeomagneticProperty.ID)
					{
						SetGeomagneticProperty msg = new SetGeomagneticProperty();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetGeomagneticPropertyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetGlobalPose.ID)
					{
						SetGlobalPose msg = new SetGlobalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetGlobalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetGlobalVector.ID)
					{
						SetGlobalVector msg = new SetGlobalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetGlobalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetGlobalWaypoint.ID)
					{
						SetGlobalWaypoint msg = new SetGlobalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetGlobalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetJointEfforts.ID)
					{
						SetJointEfforts msg = new SetJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetJointPositions.ID)
					{
						SetJointPositions msg = new SetJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetJointVelocities.ID)
					{
						SetJointVelocities msg = new SetJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalPose.ID)
					{
						SetLocalPose msg = new SetLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalVector.ID)
					{
						SetLocalVector msg = new SetLocalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetLocalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalWaypoint.ID)
					{
						SetLocalWaypoint msg = new SetLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetLocalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetMotionProfile.ID)
					{
						SetMotionProfile msg = new SetMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetPanTiltJointEfforts.ID)
					{
						SetPanTiltJointEfforts msg = new SetPanTiltJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetPanTiltJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetPanTiltJointPositions.ID)
					{
						SetPanTiltJointPositions msg = new SetPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetPanTiltJointVelocities.ID)
					{
						SetPanTiltJointVelocities msg = new SetPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetPanTiltMotionProfile.ID)
					{
						SetPanTiltMotionProfile msg = new SetPanTiltMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetPanTiltMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetRangeSensorConfiguration.ID)
					{
						SetRangeSensorConfiguration msg = new SetRangeSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetRangeSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetStillImageSensorConfiguration.ID)
					{
						SetStillImageSensorConfiguration msg = new SetStillImageSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetStillImageSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetTime.ID)
					{
						SetTime msg = new SetTime();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetTimeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetToolOffset.ID)
					{
						SetToolOffset msg = new SetToolOffset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetToolOffsetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetTravelSpeed.ID)
					{
						SetTravelSpeed msg = new SetTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetTravelSpeedTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetVelocityCommand.ID)
					{
						SetVelocityCommand msg = new SetVelocityCommand();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetVelocityCommandTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetVisualSensorConfiguration.ID)
					{
						SetVisualSensorConfiguration msg = new SetVisualSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetVisualSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetWrenchEffort.ID)
					{
						SetWrenchEffort msg = new SetWrenchEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.SetWrenchEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Shutdown.ID)
					{
						Shutdown msg = new Shutdown();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.ShutdownTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Standby.ID)
					{
						Standby msg = new Standby();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.StandbyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == UpdateEvent.ID)
					{
						UpdateEvent msg = new UpdateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_ReceiveFSM.context.UpdateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InitToReadyEventDef") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_ReceiveFSM") != 0))
				{
					InitToReadyEventDef casted_ie = (InitToReadyEventDef) ie;
						pTestCOPServiceDef_ReceiveFSM.context.InitToReadyEventDefTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAccelerationState.ID)
					{
						QueryAccelerationState msg = new QueryAccelerationState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryAccelerationStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryActiveElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAddition.ID)
					{
						QueryAddition msg = new QueryAddition();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryAdditionTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmEventRequest.ID)
					{
						ConfirmEventRequest msg = new ConfirmEventRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ConfirmEventRequestTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateCommandEvent.ID)
					{
						CreateCommandEvent msg = new CreateCommandEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.CreateCommandEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateEvent.ID)
					{
						CreateEvent msg = new CreateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.CreateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Event.ID)
					{
						Event msg = new Event();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.EventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ExecuteList.ID)
					{
						ExecuteList msg = new ExecuteList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ExecuteListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CancelEvent.ID)
					{
						CancelEvent msg = new CancelEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.CancelEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ClearEmergency.ID)
					{
						ClearEmergency msg = new ClearEmergency();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ClearEmergencyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CommandEvent.ID)
					{
						CommandEvent msg = new CommandEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.CommandEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmControl.ID)
					{
						ConfirmControl msg = new ConfirmControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ConfirmControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmElementRequest.ID)
					{
						ConfirmElementRequest msg = new ConfirmElementRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ConfirmElementRequestTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ConfirmSensorConfiguration.ID)
					{
						ConfirmSensorConfiguration msg = new ConfirmSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ConfirmSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == DeleteElement.ID)
					{
						DeleteElement msg = new DeleteElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.DeleteElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAccelerationLimit.ID)
					{
						QueryAccelerationLimit msg = new QueryAccelerationLimit();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryAccelerationLimitTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAnalogVideoSensorCapabilities.ID)
					{
						QueryAnalogVideoSensorCapabilities msg = new QueryAnalogVideoSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryAnalogVideoSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAnalogVideoSensorConfiguration.ID)
					{
						QueryAnalogVideoSensorConfiguration msg = new QueryAnalogVideoSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryAnalogVideoSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAuthority.ID)
					{
						QueryAuthority msg = new QueryAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedActuatorForceTorques.ID)
					{
						QueryCommandedActuatorForceTorques msg = new QueryCommandedActuatorForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryCommandedActuatorForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedEndEffectorPose.ID)
					{
						QueryCommandedEndEffectorPose msg = new QueryCommandedEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryCommandedEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedEndEffectorVelocityState.ID)
					{
						QueryCommandedEndEffectorVelocityState msg = new QueryCommandedEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryCommandedEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedJointPositions.ID)
					{
						QueryCommandedJointPositions msg = new QueryCommandedJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryCommandedJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedJointVelocities.ID)
					{
						QueryCommandedJointVelocities msg = new QueryCommandedJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryCommandedJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedPanTiltJointPositions.ID)
					{
						QueryCommandedPanTiltJointPositions msg = new QueryCommandedPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryCommandedPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryCommandedPanTiltJointVelocities.ID)
					{
						QueryCommandedPanTiltJointVelocities msg = new QueryCommandedPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryCommandedPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryConfiguration.ID)
					{
						QueryConfiguration msg = new QueryConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryControl.ID)
					{
						QueryControl msg = new QueryControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElement.ID)
					{
						QueryElement msg = new QueryElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElementCount.ID)
					{
						QueryElementCount msg = new QueryElementCount();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryElementCountTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElementList.ID)
					{
						QueryElementList msg = new QueryElementList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryElementListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEndEffectorEffort.ID)
					{
						QueryEndEffectorEffort msg = new QueryEndEffectorEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryEndEffectorEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEndEffectorPose.ID)
					{
						QueryEndEffectorPose msg = new QueryEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEndEffectorSpecification.ID)
					{
						QueryEndEffectorSpecification msg = new QueryEndEffectorSpecification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryEndEffectorSpecificationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEndEffectorVelocityState.ID)
					{
						QueryEndEffectorVelocityState msg = new QueryEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEventTimeout.ID)
					{
						QueryEventTimeout msg = new QueryEventTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryEventTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEvents.ID)
					{
						QueryEvents msg = new QueryEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGeomagneticProperty.ID)
					{
						QueryGeomagneticProperty msg = new QueryGeomagneticProperty();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryGeomagneticPropertyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGlobalPathSegment.ID)
					{
						QueryGlobalPathSegment msg = new QueryGlobalPathSegment();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryGlobalPathSegmentTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGlobalPose.ID)
					{
						QueryGlobalPose msg = new QueryGlobalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryGlobalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGlobalVector.ID)
					{
						QueryGlobalVector msg = new QueryGlobalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryGlobalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryGlobalWaypoint.ID)
					{
						QueryGlobalWaypoint msg = new QueryGlobalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryGlobalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryHeartbeatPulse.ID)
					{
						QueryHeartbeatPulse msg = new QueryHeartbeatPulse();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryHeartbeatPulseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryIdentification.ID)
					{
						QueryIdentification msg = new QueryIdentification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryIdentificationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryJointEfforts.ID)
					{
						QueryJointEfforts msg = new QueryJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryJointForceTorques.ID)
					{
						QueryJointForceTorques msg = new QueryJointForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryJointForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryJointPositions.ID)
					{
						QueryJointPositions msg = new QueryJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryJointVelocities.ID)
					{
						QueryJointVelocities msg = new QueryJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalPathSegment.ID)
					{
						QueryLocalPathSegment msg = new QueryLocalPathSegment();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryLocalPathSegmentTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalPose.ID)
					{
						QueryLocalPose msg = new QueryLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalVector.ID)
					{
						QueryLocalVector msg = new QueryLocalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryLocalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryLocalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryManipulatorSpecifications.ID)
					{
						QueryManipulatorSpecifications msg = new QueryManipulatorSpecifications();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryManipulatorSpecificationsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryMotionProfile.ID)
					{
						QueryMotionProfile msg = new QueryMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltJointEfforts.ID)
					{
						QueryPanTiltJointEfforts msg = new QueryPanTiltJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryPanTiltJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltJointPositions.ID)
					{
						QueryPanTiltJointPositions msg = new QueryPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltJointVelocities.ID)
					{
						QueryPanTiltJointVelocities msg = new QueryPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltMotionProfile.ID)
					{
						QueryPanTiltMotionProfile msg = new QueryPanTiltMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryPanTiltMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryPanTiltSpecifications.ID)
					{
						QueryPanTiltSpecifications msg = new QueryPanTiltSpecifications();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryPanTiltSpecificationsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryRangeSensorCapabilities.ID)
					{
						QueryRangeSensorCapabilities msg = new QueryRangeSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryRangeSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryRangeSensorCompressedData.ID)
					{
						QueryRangeSensorCompressedData msg = new QueryRangeSensorCompressedData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryRangeSensorCompressedDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryRangeSensorConfiguration.ID)
					{
						QueryRangeSensorConfiguration msg = new QueryRangeSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryRangeSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryRangeSensorData.ID)
					{
						QueryRangeSensorData msg = new QueryRangeSensorData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryRangeSensorDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QuerySensorGeometricProperties.ID)
					{
						QuerySensorGeometricProperties msg = new QuerySensorGeometricProperties();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QuerySensorGeometricPropertiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryServiceList.ID)
					{
						QueryServiceList msg = new QueryServiceList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryServiceListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryServices.ID)
					{
						QueryServices msg = new QueryServices();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryServicesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStatus.ID)
					{
						QueryStatus msg = new QueryStatus();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryStatusTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStillImageData.ID)
					{
						QueryStillImageData msg = new QueryStillImageData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryStillImageDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStillImageSensorCapabilities.ID)
					{
						QueryStillImageSensorCapabilities msg = new QueryStillImageSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryStillImageSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStillImageSensorConfiguration.ID)
					{
						QueryStillImageSensorConfiguration msg = new QueryStillImageSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryStillImageSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QuerySubsystemList.ID)
					{
						QuerySubsystemList msg = new QuerySubsystemList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QuerySubsystemListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTime.ID)
					{
						QueryTime msg = new QueryTime();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryTimeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTimeout.ID)
					{
						QueryTimeout msg = new QueryTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryToolOffset.ID)
					{
						QueryToolOffset msg = new QueryToolOffset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryToolOffsetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryTravelSpeedTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVelocityCommand.ID)
					{
						QueryVelocityCommand msg = new QueryVelocityCommand();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryVelocityCommandTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVelocityState.ID)
					{
						QueryVelocityState msg = new QueryVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVisualSensorCapabilities.ID)
					{
						QueryVisualSensorCapabilities msg = new QueryVisualSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryVisualSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryVisualSensorConfiguration.ID)
					{
						QueryVisualSensorConfiguration msg = new QueryVisualSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryVisualSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryWrenchEffort.ID)
					{
						QueryWrenchEffort msg = new QueryWrenchEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.QueryWrenchEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RegisterServices.ID)
					{
						RegisterServices msg = new RegisterServices();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.RegisterServicesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RejectControl.ID)
					{
						RejectControl msg = new RejectControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.RejectControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RejectElementRequest.ID)
					{
						RejectElementRequest msg = new RejectElementRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.RejectElementRequestTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RejectEventRequest.ID)
					{
						RejectEventRequest msg = new RejectEventRequest();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.RejectEventRequestTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReleaseControl.ID)
					{
						ReleaseControl msg = new ReleaseControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReleaseControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAccelerationLimit.ID)
					{
						ReportAccelerationLimit msg = new ReportAccelerationLimit();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportAccelerationLimitTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAccelerationState.ID)
					{
						ReportAccelerationState msg = new ReportAccelerationState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportAccelerationStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportActiveElement.ID)
					{
						ReportActiveElement msg = new ReportActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportActiveElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAddition.ID)
					{
						ReportAddition msg = new ReportAddition();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportAdditionTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAnalogVideoSensorCapabilities.ID)
					{
						ReportAnalogVideoSensorCapabilities msg = new ReportAnalogVideoSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportAnalogVideoSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAnalogVideoSensorConfiguration.ID)
					{
						ReportAnalogVideoSensorConfiguration msg = new ReportAnalogVideoSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportAnalogVideoSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportAuthority.ID)
					{
						ReportAuthority msg = new ReportAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedActuatorForceTorques.ID)
					{
						ReportCommandedActuatorForceTorques msg = new ReportCommandedActuatorForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportCommandedActuatorForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedEndEffectorPose.ID)
					{
						ReportCommandedEndEffectorPose msg = new ReportCommandedEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportCommandedEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedEndEffectorVelocityState.ID)
					{
						ReportCommandedEndEffectorVelocityState msg = new ReportCommandedEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportCommandedEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedJointPositions.ID)
					{
						ReportCommandedJointPositions msg = new ReportCommandedJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportCommandedJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedJointVelocities.ID)
					{
						ReportCommandedJointVelocities msg = new ReportCommandedJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportCommandedJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedPanTiltJointPositions.ID)
					{
						ReportCommandedPanTiltJointPositions msg = new ReportCommandedPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportCommandedPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportCommandedPanTiltJointVelocities.ID)
					{
						ReportCommandedPanTiltJointVelocities msg = new ReportCommandedPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportCommandedPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportConfiguration.ID)
					{
						ReportConfiguration msg = new ReportConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportControl.ID)
					{
						ReportControl msg = new ReportControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportElement.ID)
					{
						ReportElement msg = new ReportElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportElementCount.ID)
					{
						ReportElementCount msg = new ReportElementCount();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportElementCountTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportElementList.ID)
					{
						ReportElementList msg = new ReportElementList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportElementListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEndEffectorEffort.ID)
					{
						ReportEndEffectorEffort msg = new ReportEndEffectorEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportEndEffectorEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEndEffectorPose.ID)
					{
						ReportEndEffectorPose msg = new ReportEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEndEffectorSpecification.ID)
					{
						ReportEndEffectorSpecification msg = new ReportEndEffectorSpecification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportEndEffectorSpecificationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEndEffectorVelocityState.ID)
					{
						ReportEndEffectorVelocityState msg = new ReportEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEventTimeout.ID)
					{
						ReportEventTimeout msg = new ReportEventTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportEventTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportEvents.ID)
					{
						ReportEvents msg = new ReportEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGeomagneticProperty.ID)
					{
						ReportGeomagneticProperty msg = new ReportGeomagneticProperty();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportGeomagneticPropertyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGlobalPathSegment.ID)
					{
						ReportGlobalPathSegment msg = new ReportGlobalPathSegment();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportGlobalPathSegmentTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGlobalPose.ID)
					{
						ReportGlobalPose msg = new ReportGlobalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportGlobalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGlobalVector.ID)
					{
						ReportGlobalVector msg = new ReportGlobalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportGlobalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportGlobalWaypoint.ID)
					{
						ReportGlobalWaypoint msg = new ReportGlobalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportGlobalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportHeartbeatPulse.ID)
					{
						ReportHeartbeatPulse msg = new ReportHeartbeatPulse();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportHeartbeatPulseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportIdentification.ID)
					{
						ReportIdentification msg = new ReportIdentification();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportIdentificationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportJointEfforts.ID)
					{
						ReportJointEfforts msg = new ReportJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportJointForceTorques.ID)
					{
						ReportJointForceTorques msg = new ReportJointForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportJointForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportJointPositions.ID)
					{
						ReportJointPositions msg = new ReportJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportJointVelocities.ID)
					{
						ReportJointVelocities msg = new ReportJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalPathSegment.ID)
					{
						ReportLocalPathSegment msg = new ReportLocalPathSegment();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportLocalPathSegmentTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalPose.ID)
					{
						ReportLocalPose msg = new ReportLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalVector.ID)
					{
						ReportLocalVector msg = new ReportLocalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportLocalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportLocalWaypoint.ID)
					{
						ReportLocalWaypoint msg = new ReportLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportLocalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportManipulatorSpecifications.ID)
					{
						ReportManipulatorSpecifications msg = new ReportManipulatorSpecifications();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportManipulatorSpecificationsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportMotionProfile.ID)
					{
						ReportMotionProfile msg = new ReportMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltJointEfforts.ID)
					{
						ReportPanTiltJointEfforts msg = new ReportPanTiltJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportPanTiltJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltJointPositions.ID)
					{
						ReportPanTiltJointPositions msg = new ReportPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltJointVelocities.ID)
					{
						ReportPanTiltJointVelocities msg = new ReportPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltMotionProfile.ID)
					{
						ReportPanTiltMotionProfile msg = new ReportPanTiltMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportPanTiltMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportPanTiltSpecifications.ID)
					{
						ReportPanTiltSpecifications msg = new ReportPanTiltSpecifications();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportPanTiltSpecificationsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportRangeSensorCapabilities.ID)
					{
						ReportRangeSensorCapabilities msg = new ReportRangeSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportRangeSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportRangeSensorCompressedData.ID)
					{
						ReportRangeSensorCompressedData msg = new ReportRangeSensorCompressedData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportRangeSensorCompressedDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportRangeSensorConfiguration.ID)
					{
						ReportRangeSensorConfiguration msg = new ReportRangeSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportRangeSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportRangeSensorData.ID)
					{
						ReportRangeSensorData msg = new ReportRangeSensorData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportRangeSensorDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportSensorGeometricProperties.ID)
					{
						ReportSensorGeometricProperties msg = new ReportSensorGeometricProperties();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportSensorGeometricPropertiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportServiceList.ID)
					{
						ReportServiceList msg = new ReportServiceList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportServiceListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportServices.ID)
					{
						ReportServices msg = new ReportServices();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportServicesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStatus.ID)
					{
						ReportStatus msg = new ReportStatus();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportStatusTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStillImageData.ID)
					{
						ReportStillImageData msg = new ReportStillImageData();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportStillImageDataTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStillImageSensorCapabilities.ID)
					{
						ReportStillImageSensorCapabilities msg = new ReportStillImageSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportStillImageSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportStillImageSensorConfiguration.ID)
					{
						ReportStillImageSensorConfiguration msg = new ReportStillImageSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportStillImageSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportSubsystemList.ID)
					{
						ReportSubsystemList msg = new ReportSubsystemList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportSubsystemListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportTime.ID)
					{
						ReportTime msg = new ReportTime();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportTimeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportTimeout.ID)
					{
						ReportTimeout msg = new ReportTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportToolOffset.ID)
					{
						ReportToolOffset msg = new ReportToolOffset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportToolOffsetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportTravelSpeed.ID)
					{
						ReportTravelSpeed msg = new ReportTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportTravelSpeedTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVelocityCommand.ID)
					{
						ReportVelocityCommand msg = new ReportVelocityCommand();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportVelocityCommandTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVelocityState.ID)
					{
						ReportVelocityState msg = new ReportVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVisualSensorCapabilities.ID)
					{
						ReportVisualSensorCapabilities msg = new ReportVisualSensorCapabilities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportVisualSensorCapabilitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportVisualSensorConfiguration.ID)
					{
						ReportVisualSensorConfiguration msg = new ReportVisualSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportVisualSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReportWrenchEffort.ID)
					{
						ReportWrenchEffort msg = new ReportWrenchEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ReportWrenchEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RequestControl.ID)
					{
						RequestControl msg = new RequestControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.RequestControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Reset.ID)
					{
						Reset msg = new Reset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ResetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Resume.ID)
					{
						Resume msg = new Resume();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ResumeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAccelerationLimit.ID)
					{
						SetAccelerationLimit msg = new SetAccelerationLimit();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetAccelerationLimitTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetActuatorForceTorques.ID)
					{
						SetActuatorForceTorques msg = new SetActuatorForceTorques();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetActuatorForceTorquesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAnalogVideoSensorConfiguration.ID)
					{
						SetAnalogVideoSensorConfiguration msg = new SetAnalogVideoSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetAnalogVideoSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAuthority.ID)
					{
						SetAuthority msg = new SetAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEmergency.ID)
					{
						SetEmergency msg = new SetEmergency();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetEmergencyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEndEffectorEffort.ID)
					{
						SetEndEffectorEffort msg = new SetEndEffectorEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetEndEffectorEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEndEffectorPose.ID)
					{
						SetEndEffectorPose msg = new SetEndEffectorPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetEndEffectorPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEndEffectorVelocityState.ID)
					{
						SetEndEffectorVelocityState msg = new SetEndEffectorVelocityState();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetEndEffectorVelocityStateTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetGeomagneticProperty.ID)
					{
						SetGeomagneticProperty msg = new SetGeomagneticProperty();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetGeomagneticPropertyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetGlobalPose.ID)
					{
						SetGlobalPose msg = new SetGlobalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetGlobalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetGlobalVector.ID)
					{
						SetGlobalVector msg = new SetGlobalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetGlobalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetGlobalWaypoint.ID)
					{
						SetGlobalWaypoint msg = new SetGlobalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetGlobalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetJointEfforts.ID)
					{
						SetJointEfforts msg = new SetJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetJointPositions.ID)
					{
						SetJointPositions msg = new SetJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetJointVelocities.ID)
					{
						SetJointVelocities msg = new SetJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalPose.ID)
					{
						SetLocalPose msg = new SetLocalPose();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetLocalPoseTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalVector.ID)
					{
						SetLocalVector msg = new SetLocalVector();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetLocalVectorTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetLocalWaypoint.ID)
					{
						SetLocalWaypoint msg = new SetLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetLocalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetMotionProfile.ID)
					{
						SetMotionProfile msg = new SetMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetPanTiltJointEfforts.ID)
					{
						SetPanTiltJointEfforts msg = new SetPanTiltJointEfforts();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetPanTiltJointEffortsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetPanTiltJointPositions.ID)
					{
						SetPanTiltJointPositions msg = new SetPanTiltJointPositions();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetPanTiltJointPositionsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetPanTiltJointVelocities.ID)
					{
						SetPanTiltJointVelocities msg = new SetPanTiltJointVelocities();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetPanTiltJointVelocitiesTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetPanTiltMotionProfile.ID)
					{
						SetPanTiltMotionProfile msg = new SetPanTiltMotionProfile();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetPanTiltMotionProfileTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetRangeSensorConfiguration.ID)
					{
						SetRangeSensorConfiguration msg = new SetRangeSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetRangeSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetStillImageSensorConfiguration.ID)
					{
						SetStillImageSensorConfiguration msg = new SetStillImageSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetStillImageSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetTime.ID)
					{
						SetTime msg = new SetTime();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetTimeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetToolOffset.ID)
					{
						SetToolOffset msg = new SetToolOffset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetToolOffsetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetTravelSpeed.ID)
					{
						SetTravelSpeed msg = new SetTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetTravelSpeedTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetVelocityCommand.ID)
					{
						SetVelocityCommand msg = new SetVelocityCommand();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetVelocityCommandTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetVisualSensorConfiguration.ID)
					{
						SetVisualSensorConfiguration msg = new SetVisualSensorConfiguration();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetVisualSensorConfigurationTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetWrenchEffort.ID)
					{
						SetWrenchEffort msg = new SetWrenchEffort();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.SetWrenchEffortTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Shutdown.ID)
					{
						Shutdown msg = new Shutdown();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.ShutdownTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Standby.ID)
					{
						Standby msg = new Standby();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.StandbyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == UpdateEvent.ID)
					{
						UpdateEvent msg = new UpdateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pTestCOPServiceDef_SendFSM.context.UpdateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InitToReadyEventDef") == 0 && (ie.getSource().compareTo("TestCOPServiceDef_SendFSM") != 0))
				{
					InitToReadyEventDef casted_ie = (InitToReadyEventDef) ie;
						pTestCOPServiceDef_SendFSM.context.InitToReadyEventDefTransition();
						done = true;
				}
			}
			catch (Exception e) {}

	

	    return done;
			}

}



