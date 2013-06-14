
package src.urn_jaus_jss_mobility_LocalPoseSensor_1_0;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import framework.transport.JausRouter;
import framework.transport.JausAddress;
import framework.internalEvents.*;
import framework.StateMachine;
import framework.messages.Message;
import statemap.*;
import src.ClientSocket;
import src.JausGUI;
import src.urn_jaus_jss_mobility_LocalPoseSensor_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_LocalPoseSensor_1_0.Messages.*;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.Messages.ReportVelocityState.Body.ReportVelocityStateRec.TimeStamp;

import src.urn_jaus_jss_core_Transport_1_0.Transport_ReceiveFSM;
import src.urn_jaus_jss_core_Events_1_0.Events_ReceiveFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.AccessControl_ReceiveFSM;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportAuthority;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportControl;
import src.urn_jaus_jss_core_AccessControl_1_0.Messages.ReportTimeout;


public class LocalPoseSensor_ReceiveFSM extends StateMachine{
	protected boolean running;
	Transport_ReceiveFSM pTransport_ReceiveFSM;
	Events_ReceiveFSM pEvents_ReceiveFSM;
	AccessControl_ReceiveFSM pAccessControl_ReceiveFSM;

    LocalPoseSensor_ReceiveFSMContext context;

    public static Double LocalXreference = 0.00;
    public static Double LocalYreference = 0.00;
    public static Double LocalYAWreference = 0.00;
    DecimalFormat threeDec = new DecimalFormat("0.000");
    
    
	public LocalPoseSensor_ReceiveFSM(Transport_ReceiveFSM pTransport_ReceiveFSM, Events_ReceiveFSM pEvents_ReceiveFSM, AccessControl_ReceiveFSM pAccessControl_ReceiveFSM)
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new LocalPoseSensor_ReceiveFSMContext(this);

	this.pTransport_ReceiveFSM = pTransport_ReceiveFSM;
	this.pEvents_ReceiveFSM = pEvents_ReceiveFSM;
	this.pAccessControl_ReceiveFSM = pAccessControl_ReceiveFSM;
	JausGUI.textXref.setText(LocalXreference.toString());
	JausGUI.textYref.setText(LocalYreference.toString());
	JausGUI.textYawRef.setText(LocalYAWreference.toString());

}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{
		pAccessControl_ReceiveFSM.registerNotification("Receiving_Ready_NotControlled", ieHandler, "InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_NotControlled", "AccessControl_ReceiveFSM");
		pAccessControl_ReceiveFSM.registerNotification("Receiving_Ready_Controlled", ieHandler, "InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_Controlled", "AccessControl_ReceiveFSM");
		pAccessControl_ReceiveFSM.registerNotification("Receiving_Ready", ieHandler, "InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_NotControlled", "AccessControl_ReceiveFSM");
		pAccessControl_ReceiveFSM.registerNotification("Receiving", ieHandler, "InternalStateChange_To_LocalPoseSensor_ReceiveFSM_Receiving_Ready_NotControlled", "AccessControl_ReceiveFSM");
		registerNotification("Receiving_Ready_NotControlled", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_NotControlled", "LocalPoseSensor_ReceiveFSM");
		registerNotification("Receiving_Ready_Controlled", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready_Controlled", "LocalPoseSensor_ReceiveFSM");
		registerNotification("Receiving_Ready", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving_Ready", "LocalPoseSensor_ReceiveFSM");
		registerNotification("Receiving", pAccessControl_ReceiveFSM.getHandler(), "InternalStateChange_To_AccessControl_ReceiveFSM_Receiving", "LocalPoseSensor_ReceiveFSM");

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
		// JAUS Address of received message source
		
		if(arg0.equals("ReportLocalPose")){
			JausGUI.socket.JausDataRequest();
			ReportLocalPose rlpMsg = new ReportLocalPose();
			//Instantiate Message
			double x = JausGUI.robot_x_position;
			double y = JausGUI.robot_y_position;
			double yaw = JausGUI.robot_yaw_position;
			
			rlpMsg.getBody().getLocalPoseRec().setX(x); // ROB ROB ROB: This should be filled with actual change from local reference
			rlpMsg.getBody().getLocalPoseRec().setY(y);
			rlpMsg.getBody().getLocalPoseRec().setYaw(yaw);
//			src.urn_jaus_jss_mobility_LocalPoseSensor_1_0.Messages.ReportLocalPose.Body.LocalPoseRec.TimeStamp time = new src.urn_jaus_jss_mobility_LocalPoseSensor_1_0.Messages.ReportLocalPose.Body.LocalPoseRec.TimeStamp();
//			Calendar now = Calendar.getInstance();
//			// Instantiate "Calendar"
//			time.setDay(now.get(Calendar.DAY_OF_MONTH));
//			time.setHour(now.get(Calendar.HOUR_OF_DAY));
//			time.setMinutes(now.get(Calendar.MINUTE));
//			time.setSeconds(now.get(Calendar.SECOND));
//			time.setMilliseconds(now.get(Calendar.MILLISECOND));
//			//Fill TimeStamp
//			rlpMsg.getBody().getLocalPoseRec().setTimeStamp(time);
			// Fill body with change in x, y, yaw from reference
			sendJausMessage(rlpMsg, source);
			// Send message to source
			JausGUI.addOutputText("LPS: SENT: ReportLocalPose Message (Dest: " + sourceString + "; X: " + rlpMsg.getBody().getLocalPoseRec().getX() + "; Y: " + rlpMsg.getBody().getLocalPoseRec().getY());
			//+ "; Time Stamp (D:H:M:S:mS): "+time.getDay()+":"+time.getHour()+":"+time.getMinutes()+":"+time.getSeconds()+":"+time.getMilliseconds()+ ")");
		}else{
			JausGUI.addOutputText("LPS: INVALID ARGUMENT arg0 (" + arg0 + ") in SendAction(String arg0, Receive.Body.ReceiveRec transportData)");
			//If arg0 not found error message is sent
		}
}

public void updateLocalPoseAction(SetLocalPose msg)
{
		JausGUI.addOutputText("LPS: Pose");
		LocalXreference = msg.getBody().getLocalPoseRec().getX();
		LocalYreference = msg.getBody().getLocalPoseRec().getY();
		LocalYAWreference = msg.getBody().getLocalPoseRec().getYaw();
		JausGUI.textXref.setText(threeDec.format(LocalXreference));
		JausGUI.textYref.setText(threeDec.format(LocalYreference));
		JausGUI.textYawRef.setText(threeDec.format(LocalYAWreference));
		JausGUI.addOutputText("LPS: Pose Updated");
		JausGUI.socket.SetLocalPoseRequest(LocalXreference, LocalYreference, LocalYAWreference);
}


	public boolean isControllingClient(Receive.Body.ReceiveRec transportData)
{
	//// By default, inherited guards call the parent function.
	//// This can be replaced or modified as needed.
	return pAccessControl_ReceiveFSM.isControllingClient(transportData );
}


}

