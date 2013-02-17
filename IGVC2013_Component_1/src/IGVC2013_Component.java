
package src;

import framework.transport.JausRouter;
import framework.transport.JausAddress;
import java.util.ArrayList;
import framework.EventReceiver;
import framework.Service;
import framework.internalEvents.InternalEvent;
import src.urn_jaus_jss_core_Transport_1_0.TransportService;
import src.urn_jaus_jss_core_Events_1_0.EventsService;
import src.urn_jaus_jss_core_Discovery_1_0.DiscoveryService;
import src.urn_jaus_jss_core_AccessControl_1_0.AccessControlService;
import src.urn_jaus_jss_mobility_LocalPoseSensor_1_0.LocalPoseSensorService;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.VelocityStateSensorService;
import src.urn_jaus_jss_core_Management_1_0.ManagementService;
import src.urn_jaus_jss_mobility_ListManager_1_0.ListManagerService;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriverService;



class IGVC2013_Component extends EventReceiver
    {
	protected ArrayList<Service> serviceList = new ArrayList<Service>();
	JausRouter jausRouter;

	IGVC2013_Component(int subsystem, short node, short component)
    {
		jausRouter = new JausRouter(new JausAddress(subsystem, node, component), ieHandler);
		
	/// Instantiate services
		TransportService pTransportService = new TransportService(jausRouter);
		EventsService pEventsService = new EventsService(jausRouter, pTransportService);
		DiscoveryService pDiscoveryService = new DiscoveryService(jausRouter, pTransportService, pEventsService);
		AccessControlService pAccessControlService = new AccessControlService(jausRouter, pTransportService, pEventsService);
		LocalPoseSensorService pLocalPoseSensorService = new LocalPoseSensorService(jausRouter, pTransportService, pEventsService, pAccessControlService);
		VelocityStateSensorService pVelocityStateSensorService = new VelocityStateSensorService(jausRouter, pTransportService, pEventsService);
		ManagementService pManagementService = new ManagementService(jausRouter, pTransportService, pEventsService, pAccessControlService);
		ListManagerService pListManagerService = new ListManagerService(jausRouter, pTransportService, pEventsService, pAccessControlService, pManagementService);
		LocalWaypointListDriverService pLocalWaypointListDriverService = new LocalWaypointListDriverService(jausRouter, pTransportService, pEventsService, pAccessControlService, pManagementService, pListManagerService);


	/// Add all the Services for the Component
		serviceList.add(pTransportService);
		serviceList.add(pEventsService);
		serviceList.add(pDiscoveryService);
		serviceList.add(pAccessControlService);
		serviceList.add(pLocalPoseSensorService);
		serviceList.add(pVelocityStateSensorService);
		serviceList.add(pManagementService);
		serviceList.add(pListManagerService);
		serviceList.add(pLocalWaypointListDriverService);

	}

	public void startComponent()
    {
		jausRouter.start();
		this.start();

		for(int i = 0; i <serviceList.size(); i++)
        {
			serviceList.get(i).start();
		}
	}

	public void shutdownComponent()
    {
		for (int i=0; i<serviceList.size(); i++)
        {
			serviceList.get(i).stop();
		}
		this.stop();
		jausRouter.stop();
	}

	public void processInternalEvent(InternalEvent ie)
	{
		boolean done = false;
	
		//
		// When a component receives an internal event, it passes it
		// to the services to handling, children services first.  If the
		// event is not processed by normal transitions, it's passed
		// again to the services (children first) for default transitions.
		// A given event may only be processed by at most one service.
		//
		for (int i = serviceList.size(); i>0; i--)
		{
			if (!done) done = serviceList.get(i-1).processTransitions(ie);
		}
		for (int i = serviceList.size(); i>0; i--)
		{
			if (!done) done = serviceList.get(i-1).defaultTransitions(ie);
		}
	}

}
