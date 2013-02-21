
package src.urn_jaus_jss_mobility_VelocityStateSensor_1_0;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
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
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.Messages.*;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.Messages.ReportVelocityState.Body.ReportVelocityStateRec.TimeStamp;

import src.urn_jaus_jss_core_Transport_1_0.Transport_ReceiveFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.RejectControl;
import src.urn_jaus_jss_core_Events_1_0.Events_ReceiveFSM;


public class VelocityStateSensor_ReceiveFSM extends StateMachine{
	protected boolean running;
	Transport_ReceiveFSM pTransport_ReceiveFSM;
	Events_ReceiveFSM pEvents_ReceiveFSM;

    VelocityStateSensor_ReceiveFSMContext context;
    DecimalFormat threeDec = new DecimalFormat("0.000");

    
	
	public VelocityStateSensor_ReceiveFSM(Transport_ReceiveFSM pTransport_ReceiveFSM, Events_ReceiveFSM pEvents_ReceiveFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new VelocityStateSensor_ReceiveFSMContext(this);

	this.pTransport_ReceiveFSM = pTransport_ReceiveFSM;
	this.pEvents_ReceiveFSM = pEvents_ReceiveFSM;
}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pEvents_ReceiveFSM.registerNotification("Receiving_Ready", ieHandler, "InternalStateChange_To_VelocityStateSensor_ReceiveFSM_Receiving_Ready", "Events_ReceiveFSM");
		pEvents_ReceiveFSM.registerNotification("Receiving", ieHandler, "InternalStateChange_To_VelocityStateSensor_ReceiveFSM_Receiving_Ready", "Events_ReceiveFSM");
		registerNotification("Receiving_Ready", pEvents_ReceiveFSM.getHandler(), "InternalStateChange_To_Events_ReceiveFSM_Receiving_Ready", "VelocityStateSensor_ReceiveFSM");
		registerNotification("Receiving", pEvents_ReceiveFSM.getHandler(), "InternalStateChange_To_Events_ReceiveFSM_Receiving", "VelocityStateSensor_ReceiveFSM");

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

		if(arg0.equals("ReportVelocityState")){
			JausGUI.addOutputText(arg0 + " Message Recieved");
			
			JausGUI.socket.JausDataRequest();
			ReportVelocityState rvMsg = new ReportVelocityState();
			JausGUI.addOutputText("Recieved X Velocity: " + threeDec.format(JausGUI.robot_x_velocity) + "; Omega: " + threeDec.format(JausGUI.robot_omega));
//			// Instantiate Message
			rvMsg.getBody().getReportVelocityStateRec().setVelocity_X(JausGUI.robot_x_velocity);
			rvMsg.getBody().getReportVelocityStateRec().setYawRate(JausGUI.robot_omega);
			TimeStamp time = new TimeStamp();
			Calendar now = Calendar.getInstance();
			// Instantiate "Calendar"
			time.setDay(now.get(Calendar.DAY_OF_MONTH));
			time.setHour(now.get(Calendar.HOUR_OF_DAY));
			time.setMinutes(now.get(Calendar.MINUTE));
			time.setSeconds(now.get(Calendar.SECOND));
			time.setMilliseconds(now.get(Calendar.MILLISECOND));
			//Fill TimeStamp
			rvMsg.getBody().getReportVelocityStateRec().setTimeStamp(time);
			//Fill all body fields
			sendJausMessage(rvMsg, source);
			// Message sent
			JausGUI.addOutputText("VSS: SENT: " + arg0 + " Message (Dest: " + sourceString + "; X-Velocity: "+rvMsg.getBody().getReportVelocityStateRec().getVelocity_X()+"; Yaw Rate: "+rvMsg.getBody().getReportVelocityStateRec().getYawRate()+"; Time Stamp (D:H:M:S:mS): "+rvMsg.getBody().getReportVelocityStateRec().getTimeStamp().getDay()+":"+rvMsg.getBody().getReportVelocityStateRec().getTimeStamp().getHour()+":"+rvMsg.getBody().getReportVelocityStateRec().getTimeStamp().getMinutes()+":"+rvMsg.getBody().getReportVelocityStateRec().getTimeStamp().getSeconds()+":"+rvMsg.getBody().getReportVelocityStateRec().getTimeStamp().getMilliseconds()+")");
		} 
}



	
}

