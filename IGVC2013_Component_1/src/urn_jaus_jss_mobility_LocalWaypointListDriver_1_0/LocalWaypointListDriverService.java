
package src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0;

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
import src.urn_jaus_jss_core_Management_1_0.ManagementService;
import src.urn_jaus_jss_mobility_ListManager_1_0.ListManagerService;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.*;


public class LocalWaypointListDriverService extends Service{

		public LocalWaypointListDriver_ReceiveFSM pLocalWaypointListDriver_ReceiveFSM;
	public LocalWaypointListDriver_SendFSM pLocalWaypointListDriver_SendFSM;


	public LocalWaypointListDriverService(JausRouter jausRouter , TransportService pTransportService, EventsService pEventsService, AccessControlService pAccessControlService, ManagementService pManagementService, ListManagerService pListManagerService)
	{

	pLocalWaypointListDriver_ReceiveFSM = new LocalWaypointListDriver_ReceiveFSM(pTransportService.pTransport_ReceiveFSM, pEventsService.pEvents_ReceiveFSM, pAccessControlService.pAccessControl_ReceiveFSM, pManagementService.pManagement_ReceiveFSM, pListManagerService.pListManager_ReceiveFSM);
	pLocalWaypointListDriver_ReceiveFSM.setHandler(ieHandler, jausRouter);
	pLocalWaypointListDriver_ReceiveFSM.setupNotifications();
	pLocalWaypointListDriver_SendFSM = new LocalWaypointListDriver_SendFSM(pTransportService.pTransport_SendFSM, pEventsService.pEvents_SendFSM, pAccessControlService.pAccessControl_SendFSM, pManagementService.pManagement_SendFSM, pListManagerService.pListManager_SendFSM);
	pLocalWaypointListDriver_SendFSM.setHandler(ieHandler, jausRouter);
	pLocalWaypointListDriver_SendFSM.setupNotifications();


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
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ExecuteList.ID)
					{
						ExecuteList msg = new ExecuteList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ExecuteList.ID)
					{
						ExecuteList msg = new ExecuteList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Init") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_InitTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_FailureTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Shutdown") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_ShutdownTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_Emergency") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA_EmergencyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateA") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled_StateATransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_NotControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Standby") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_StandbyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateB") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled_StateBTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_Controlled") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready_ControlledTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_Ready") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving_ReadyTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_Receiving") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
						pLocalWaypointListDriver_ReceiveFSM.context.InternalStateChange_To_LocalWaypointListDriver_ReceiveFSM_ReceivingTransition(ie);
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						Receive.Body.ReceiveRec transportData = casted_ie.getBody().getReceiveRec();
						pLocalWaypointListDriver_ReceiveFSM.context.ReceiveTransition(msg, transportData);
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
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryLocalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryTravelSpeedTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ExecuteList.ID)
					{
						ExecuteList msg = new ExecuteList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.ExecuteListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryActiveElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.SetElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == DeleteElement.ID)
					{
						DeleteElement msg = new DeleteElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.DeleteElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElement.ID)
					{
						QueryElement msg = new QueryElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElementList.ID)
					{
						QueryElementList msg = new QueryElementList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryElementListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElementCount.ID)
					{
						QueryElementCount msg = new QueryElementCount();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryElementCountTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Shutdown.ID)
					{
						Shutdown msg = new Shutdown();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.ShutdownTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Standby.ID)
					{
						Standby msg = new Standby();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.StandbyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Resume.ID)
					{
						Resume msg = new Resume();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.ResumeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Reset.ID)
					{
						Reset msg = new Reset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.ResetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEmergency.ID)
					{
						SetEmergency msg = new SetEmergency();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.SetEmergencyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ClearEmergency.ID)
					{
						ClearEmergency msg = new ClearEmergency();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.ClearEmergencyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStatus.ID)
					{
						QueryStatus msg = new QueryStatus();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryStatusTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RequestControl.ID)
					{
						RequestControl msg = new RequestControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.RequestControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReleaseControl.ID)
					{
						ReleaseControl msg = new ReleaseControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.ReleaseControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryControl.ID)
					{
						QueryControl msg = new QueryControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAuthority.ID)
					{
						QueryAuthority msg = new QueryAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAuthority.ID)
					{
						SetAuthority msg = new SetAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.SetAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTimeout.ID)
					{
						QueryTimeout msg = new QueryTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateEvent.ID)
					{
						CreateEvent msg = new CreateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.CreateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == UpdateEvent.ID)
					{
						UpdateEvent msg = new UpdateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.UpdateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CancelEvent.ID)
					{
						CancelEvent msg = new CancelEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.CancelEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEvents.ID)
					{
						QueryEvents msg = new QueryEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_ReceiveFSM.context.QueryEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Initialized") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Initialized casted_ie = (Initialized) ie;
						pLocalWaypointListDriver_ReceiveFSM.context.InitializedTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Failure casted_ie = (Failure) ie;
						pLocalWaypointListDriver_ReceiveFSM.context.FailureTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Timeout") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Timeout casted_ie = (Timeout) ie;
						pLocalWaypointListDriver_ReceiveFSM.context.TimeoutTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventOccurred") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					EventOccurred casted_ie = (EventOccurred) ie;
						pLocalWaypointListDriver_ReceiveFSM.context.EventOccurredTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventError") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					EventError casted_ie = (EventError) ie;
						pLocalWaypointListDriver_ReceiveFSM.context.EventErrorTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Send") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					Send casted_ie = (Send) ie;
						pLocalWaypointListDriver_ReceiveFSM.context.SendTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastLocal") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					BroadcastLocal casted_ie = (BroadcastLocal) ie;
						pLocalWaypointListDriver_ReceiveFSM.context.BroadcastLocalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastGlobal") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_ReceiveFSM") != 0))
				{
					BroadcastGlobal casted_ie = (BroadcastGlobal) ie;
						pLocalWaypointListDriver_ReceiveFSM.context.BroadcastGlobalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryLocalWaypoint.ID)
					{
						QueryLocalWaypoint msg = new QueryLocalWaypoint();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryLocalWaypointTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTravelSpeed.ID)
					{
						QueryTravelSpeed msg = new QueryTravelSpeed();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryTravelSpeedTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ExecuteList.ID)
					{
						ExecuteList msg = new ExecuteList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.ExecuteListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryActiveElement.ID)
					{
						QueryActiveElement msg = new QueryActiveElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryActiveElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetElement.ID)
					{
						SetElement msg = new SetElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.SetElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == DeleteElement.ID)
					{
						DeleteElement msg = new DeleteElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.DeleteElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElement.ID)
					{
						QueryElement msg = new QueryElement();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryElementTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElementList.ID)
					{
						QueryElementList msg = new QueryElementList();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryElementListTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryElementCount.ID)
					{
						QueryElementCount msg = new QueryElementCount();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryElementCountTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Shutdown.ID)
					{
						Shutdown msg = new Shutdown();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.ShutdownTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Standby.ID)
					{
						Standby msg = new Standby();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.StandbyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Resume.ID)
					{
						Resume msg = new Resume();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.ResumeTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == Reset.ID)
					{
						Reset msg = new Reset();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.ResetTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetEmergency.ID)
					{
						SetEmergency msg = new SetEmergency();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.SetEmergencyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ClearEmergency.ID)
					{
						ClearEmergency msg = new ClearEmergency();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.ClearEmergencyTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryStatus.ID)
					{
						QueryStatus msg = new QueryStatus();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryStatusTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == RequestControl.ID)
					{
						RequestControl msg = new RequestControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.RequestControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == ReleaseControl.ID)
					{
						ReleaseControl msg = new ReleaseControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.ReleaseControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryControl.ID)
					{
						QueryControl msg = new QueryControl();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryControlTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryAuthority.ID)
					{
						QueryAuthority msg = new QueryAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == SetAuthority.ID)
					{
						SetAuthority msg = new SetAuthority();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.SetAuthorityTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryTimeout.ID)
					{
						QueryTimeout msg = new QueryTimeout();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryTimeoutTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CreateEvent.ID)
					{
						CreateEvent msg = new CreateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.CreateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == UpdateEvent.ID)
					{
						UpdateEvent msg = new UpdateEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.UpdateEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == CancelEvent.ID)
					{
						CancelEvent msg = new CancelEvent();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.CancelEventTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Receive") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Receive casted_ie = (Receive) ie;
					int id = (int) (casted_ie.getBody().getReceiveRec().getMessagePayload().getData().getShort() & 0xffff);
					if ( id == QueryEvents.ID)
					{
						QueryEvents msg = new QueryEvents();
						msg.decode(casted_ie.getBody().getReceiveRec().getMessagePayload().getData(), 0);
						pLocalWaypointListDriver_SendFSM.context.QueryEventsTransition();
						done = true;
					}
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Initialized") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Initialized casted_ie = (Initialized) ie;
						pLocalWaypointListDriver_SendFSM.context.InitializedTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Failure") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Failure casted_ie = (Failure) ie;
						pLocalWaypointListDriver_SendFSM.context.FailureTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Timeout") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Timeout casted_ie = (Timeout) ie;
						pLocalWaypointListDriver_SendFSM.context.TimeoutTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventOccurred") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					EventOccurred casted_ie = (EventOccurred) ie;
						pLocalWaypointListDriver_SendFSM.context.EventOccurredTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("EventError") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					EventError casted_ie = (EventError) ie;
						pLocalWaypointListDriver_SendFSM.context.EventErrorTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("Send") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					Send casted_ie = (Send) ie;
						pLocalWaypointListDriver_SendFSM.context.SendTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastLocal") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					BroadcastLocal casted_ie = (BroadcastLocal) ie;
						pLocalWaypointListDriver_SendFSM.context.BroadcastLocalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

			try
			{
				if ((done == false) && ie.getName().compareTo("BroadcastGlobal") == 0 && (ie.getSource().compareTo("LocalWaypointListDriver_SendFSM") != 0))
				{
					BroadcastGlobal casted_ie = (BroadcastGlobal) ie;
						pLocalWaypointListDriver_SendFSM.context.BroadcastGlobalTransition();
						done = true;
				}
			}
			catch (Exception e) {}

	

	    return done;
			}

}



