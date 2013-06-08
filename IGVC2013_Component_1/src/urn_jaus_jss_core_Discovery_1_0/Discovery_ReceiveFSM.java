
package src.urn_jaus_jss_core_Discovery_1_0;

import java.util.StringTokenizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import framework.transport.JausRouter;
import framework.transport.JausAddress;
import framework.internalEvents.*;
import framework.internalEvents.Receive_1_0.Body.ReceiveRec;
import framework.StateMachine;
import framework.messages.Message;
import statemap.*;
import src.JausGUI;
import src.urn_jaus_jss_core_Discovery_1_0.InternalEvents.*;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.*;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportConfiguration.Body.NodeList.NodeSeq;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportConfiguration.Body.NodeList.NodeSeq.ComponentList.ComponentRec;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq.ComponentList;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq.ComponentList.ComponentSeq;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq.ComponentList.ComponentSeq.ServiceList;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq.ComponentList.ComponentSeq.ServiceList.ServiceRec;
import src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq.NodeRec;

import src.urn_jaus_jss_core_Transport_1_0.Transport_ReceiveFSM;
import src.urn_jaus_jss_core_Events_1_0.Events_ReceiveFSM;


public class Discovery_ReceiveFSM extends StateMachine{
	protected boolean running;
	Transport_ReceiveFSM pTransport_ReceiveFSM;
	Events_ReceiveFSM pEvents_ReceiveFSM;

    Discovery_ReceiveFSMContext context;

    
	
	public Discovery_ReceiveFSM(Transport_ReceiveFSM pTransport_ReceiveFSM, Events_ReceiveFSM pEvents_ReceiveFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new Discovery_ReceiveFSMContext(this);

	this.pTransport_ReceiveFSM = pTransport_ReceiveFSM;
	this.pEvents_ReceiveFSM = pEvents_ReceiveFSM;
}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pEvents_ReceiveFSM.registerNotification("Receiving_Ready", ieHandler, "InternalStateChange_To_Discovery_ReceiveFSM_Receiving_Ready", "Events_ReceiveFSM");
		pEvents_ReceiveFSM.registerNotification("Receiving", ieHandler, "InternalStateChange_To_Discovery_ReceiveFSM_Receiving_Ready", "Events_ReceiveFSM");
		registerNotification("Receiving_Ready", pEvents_ReceiveFSM.getHandler(), "InternalStateChange_To_Events_ReceiveFSM_Receiving_Ready", "Discovery_ReceiveFSM");
		registerNotification("Receiving", pEvents_ReceiveFSM.getHandler(), "InternalStateChange_To_Events_ReceiveFSM_Receiving", "Discovery_ReceiveFSM");

	}

	/// Access for debug purposes
	public String getStateName()
	{
		return context.getState().getName();
	}

	public void PublishServicesAction(RegisterServices msg, Receive.Body.ReceiveRec transportData)
{
	/// Services Not Needed
}

public void SendAction(String arg0, Receive.Body.ReceiveRec transportData)
{
	JausAddress source = new JausAddress(transportData.getSrcSubsystemID(), transportData.getSrcNodeID(), transportData.getSrcComponentID());
	String sourceString = source.getSubsystemID() + "." + source.getNodeID() + "." + source.getComponentID();
	// Determine source from transportData
	
	if(arg0.equals("ReportIdentification")){ //Does not specify ENUM (Sys, Sub, Node, Comp); JUST FOR TESTING PURPOSES: Assume Component
//		 ReportIdentification riMsg = new ReportIdentification();
//		 //Instantiate Message
//		 riMsg.getBody().getReportIdentificationRec().setQueryType((short) 4); //This reports only the component configuration (for testing purposes)
//		 riMsg.getBody().getReportIdentificationRec().setType(60001);
//		 riMsg.getBody().getReportIdentificationRec().setIdentification("York College of Pennsylvania IGVC Robot JAUS Component");
//		 //Fill Body
//		 sendJausMessage(riMsg, source);
//		 //Send Message
//		JausGUI.addOutputText("DSC: SENT: "+arg0+" Message (Dest: " + sourceString + "; QueryType: 4; Type: 60001 (Component); Identification: 'York College of Pennsylvania IGVC Robot JAUS Component')");
//		JausGUI.addOutputText("DSC: NOTE* " +arg0+ "ONLY FOR TESTING PURPOSES");
//		//In JAUS Competition the CLIENT (this) will QueryIdentification; Not ReportIdentification
//		//This will be tested against; 
	}else if(arg0.equals("ReportConfiguration")){
//		ReportConfiguration rcMsg = new ReportConfiguration();
//		//Instantiate Message
//		ComponentRec compRec = new ComponentRec();
//		compRec.setComponentID((short) 1);
//		compRec.setInstanceID((short) 0);
//		NodeSeq nodeSeq = new NodeSeq();									// Not used by Competition
//		nodeSeq.getNodeRec().setNodeID((short) 1);							// NOT YET TESTED
//		nodeSeq.getComponentList().setElement(0, compRec);
//		rcMsg.getBody().getNodeList().setElement(0, nodeSeq);
//		//Fill Body
//		sendJausMessage(rcMsg, source);
//		//Send Messages
		JausGUI.addOutputText("ERROR: " +arg0+ " NOT IMPLEMENTED IN THIS BUILD");
	}else if(arg0.equals("ReportSubsystemList")){
// 		Not used by Competition
// 		No implementation as of now... obviously
		JausGUI.addOutputText("ERROR: " +arg0+ " NOT IMPLEMENTED IN THIS BUILD");
	}else if(arg0.equals("ReportServices")){
		//This service is deprecated in v1.1
		ReportServices rsMsg = new ReportServices();
		//Instantiate Message
		//Core Services Implemented (Transport, AccessControl, Discovery, Management)
		ServiceRec transportSR = new ServiceRec();
		ServiceRec accessControlSR = new ServiceRec();
		ServiceRec discoverySR = new ServiceRec();
		ServiceRec managementSR = new ServiceRec();
			//Create ServiceRec
		transportSR.setURI("urn:jaus:jss:core:Transport");
		accessControlSR.setURI("urn:jaus:jss:core:AccessControl");
		discoverySR.setURI("urn:jaus:jss:core:Discovery");
		managementSR.setURI("urn:jaus:jss:core:Management");
			// Set URIs
		transportSR.setMajorVersionNumber((short) 1);
		accessControlSR.setMajorVersionNumber((short) 1);
		discoverySR.setMajorVersionNumber((short) 1);
		managementSR.setMajorVersionNumber((short) 1);
			// Set Major Version Numbers
		transportSR.setMinorVersionNumber((short) 0);
		accessControlSR.setMinorVersionNumber((short) 0);
		discoverySR.setMinorVersionNumber((short) 0);
		managementSR.setMinorVersionNumber((short) 0);
			// Set Minor Version Numbers
		//Mobility Services Implemented (ListManager, Velocity State Sensor, Local Pose Sensor, Local Waypoint Driver)
		ServiceRec listManagerSR = new ServiceRec();
		ServiceRec velocityStateSensorSR = new ServiceRec();
		ServiceRec localPoseSensorSR = new ServiceRec();
		ServiceRec localWaypointDriver = new ServiceRec();
			// Create ServiceRecs
		listManagerSR.setURI("urn:jaus:jss:mobility:ListManager");
		velocityStateSensorSR.setURI("urn:jaus:jss:mobility:VelocityStateSensor");
		localPoseSensorSR.setURI("urn:jaus:jss:mobility:LocalPoseSensor");
		localWaypointDriver.setURI("urn:jaus:jss:mobility:LocalWaypointListDriver");
			// Set URI
		listManagerSR.setMajorVersionNumber((short)1);
		velocityStateSensorSR.setMajorVersionNumber((short)1);
		localPoseSensorSR.setMajorVersionNumber((short)1);
		localWaypointDriver.setMajorVersionNumber((short)1);
			//Set Major Version Number
		listManagerSR.setMinorVersionNumber((short)0);
		velocityStateSensorSR.setMinorVersionNumber((short)0);
		localPoseSensorSR.setMinorVersionNumber((short)0);
		localWaypointDriver.setMinorVersionNumber((short)0);
			//Set Minor Version Number
		// Created ServiceRecords for each of the services
		ServiceList serviceList = new ServiceList();
		serviceList.addElement(transportSR);
		serviceList.addElement(accessControlSR);
		serviceList.addElement(discoverySR);
		serviceList.addElement(managementSR);
		serviceList.addElement(listManagerSR);
		serviceList.addElement(velocityStateSensorSR);
		serviceList.addElement(localPoseSensorSR);
		serviceList.addElement(localWaypointDriver);
		//All Service Records added to Service List
		src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq.ComponentList.ComponentSeq.ComponentRec componentRec = new src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq.ComponentList.ComponentSeq.ComponentRec();
			//This ComponentRec must be called explicitly due to the addition ComponentRec used in the ReportConfiguration Message 
		componentRec.setComponentID(Short.parseShort(JausGUI.textComponentID.getText()));
		componentRec.setInstanceID((short) 0);
		//Component Record instantiated, Comp ID set, Instance ID = 0 (non-legacy)
		ComponentSeq compSeq = new ComponentSeq();
		compSeq.setComponentRec(componentRec);
		compSeq.setServiceList(serviceList);
		//ComponentSeq instantiated and filled with CompRec and ServiceList
		ComponentList compList = new ComponentList();
		compList.addElement(compSeq);
		//ComponentList Instantiated and filled
		NodeRec nodeRec = new NodeRec();
		nodeRec.setNodeID(Short.parseShort(JausGUI.textNodeID.getText()));
		//NodeRec instantiated and filled
		src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq nodeSeq = new src.urn_jaus_jss_core_Discovery_1_0.Messages.ReportServices.Body.NodeList.NodeSeq();
		nodeSeq.setNodeRec(nodeRec);
		nodeSeq.setComponentList(compList);
		//NodeSeq instantiated and filled
		NodeList nodeList = new NodeList();
		nodeList.addElement(nodeSeq);
		//NodeList instantiated and filled
		rsMsg.getBody().setNodeList(nodeList);
		//Message Body filled
		sendJausMessage(rsMsg, source);
		JausGUI.addOutputText("DSC: SENT: "+arg0+" Message (Dest: " + sourceString + ")");
	}
}

public void handleReportIdentificationAction(ReportIdentification msg, Receive.Body.ReceiveRec transportData)
{
	JausGUI.periodicQuery = false;
	JausGUI.setLED(JausGUI.led_ReportedIdentification, "greenON");
	JausGUI.addOutputText("DSC: ReportIdentification Message Recieved (Source: " + transportData.getSrcComponentID() + "." + transportData.getSrcNodeID() + "." + transportData.getSrcComponentID()+ ")");
}


public void ReplyToQueryIdentification(QueryIdentification msg, ReceiveRec transportData) {
	JausAddress source = new JausAddress(transportData.getSrcSubsystemID(), transportData.getSrcNodeID(), transportData.getSrcComponentID());
	String sourceString = source.getSubsystemID() + "." + source.getNodeID() + "." + source.getComponentID();
	Integer queryType = (int) msg.getBody().getQueryIdentificationRec().getQueryType();
	// Determine source from transportData
	
	if(queryType.equals(1)){ //System Identification
		ReportIdentification riMsg = new ReportIdentification();
		//Instantiate Message
		riMsg.getBody().getReportIdentificationRec().setQueryType((short) 1); 
		riMsg.getBody().getReportIdentificationRec().setType(10001);
		riMsg.getBody().getReportIdentificationRec().setIdentification("YCP IGVC Robot 2013- Robot Downey Jr.");
		//Fill Body
		sendJausMessage(riMsg, source);
		//Send Message
		JausGUI.addOutputText("DSC: SENT: ReportMessage (Dest: " + sourceString + "; QueryType: 1");
		JausGUI.addOutputText("DSC: NOTE* ReportMessage ONLY FOR TESTING PURPOSES");
		//In JAUS Competition the CLIENT (this) will QueryIdentification; Not ReportIdentification
		//This will be tested against; 
	}else if(queryType.equals(2)){
		ReportIdentification riMsg = new ReportIdentification();
		//Instantiate Message
		riMsg.getBody().getReportIdentificationRec().setQueryType((short) 2);
		riMsg.getBody().getReportIdentificationRec().setType(60001);
		riMsg.getBody().getReportIdentificationRec().setIdentification("YCP IGVC Robot 2013- Subsystem");
		//Fill Body
		sendJausMessage(riMsg, source);
		//Send Message
		JausGUI.addOutputText("DSC: SENT: ReportMessage (Dest: " + sourceString + "; QueryType: 2");
		JausGUI.addOutputText("DSC: NOTE* ReportMessage ONLY FOR TESTING PURPOSES");
		//In JAUS Competition the CLIENT (this) will QueryIdentification; Not ReportIdentification
		//This will be tested against; 
	}else if(queryType.equals(3)){
		ReportIdentification riMsg = new ReportIdentification();
		//Instantiate Message
		riMsg.getBody().getReportIdentificationRec().setQueryType((short) 3); 
		riMsg.getBody().getReportIdentificationRec().setType(40001);
		riMsg.getBody().getReportIdentificationRec().setIdentification("YCP IGVC Robot 2013 - Node 1");
		//Fill Body
		sendJausMessage(riMsg, source);
		//Send Message
		JausGUI.addOutputText("DSC: SENT: ReportMessage (Dest: " + sourceString + "; QueryType: 3");
		JausGUI.addOutputText("DSC: NOTE* ReportMessae ONLY FOR TESTING PURPOSES");
		//In JAUS Competition the CLIENT (this) will QueryIdentification; Not ReportIdentification
		//This will be tested against; 
	}else if(queryType.equals(4)){
		ReportIdentification riMsg = new ReportIdentification();
		//Instantiate Message
		riMsg.getBody().getReportIdentificationRec().setQueryType((short) 4); 
		riMsg.getBody().getReportIdentificationRec().setType(60001);
		riMsg.getBody().getReportIdentificationRec().setIdentification("YCP IGVC Robot 2013 - JAUS Component 1");
		//Fill Body
		sendJausMessage(riMsg, source);
		//Send Message
		JausGUI.addOutputText("DSC: SENT: ReportAMessage (Dest: " + sourceString + "; QueryType: 4");
		JausGUI.addOutputText("DSC: NOTE* ReportMessage ONLY FOR TESTING PURPOSES");
		//In JAUS Competition the CLIENT (this) will QueryIdentification; Not ReportIdentification
		//This will be tested against; 
	}
}



	
}

