
package src.urn_TestCOPServiceDef_1_0;

import java.util.StringTokenizer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import framework.transport.JausRouter;
import framework.transport.JausAddress;
import framework.internalEvents.*;
import framework.StateMachine;
import framework.messages.Message;
import statemap.*;
import src.urn_TestCOPServiceDef_1_0.InternalEvents.*;
import src.urn_TestCOPServiceDef_1_0.Messages.*;



public class TestCOPServiceDef_SendFSM extends StateMachine{
	protected boolean running;

    TestCOPServiceDef_SendFSMContext context;

    
	
	public TestCOPServiceDef_SendFSM()
{

	/*
	 * If there are other variables, context must be constructed last so that all 
	 * class variables are available if an EntryAction of the InitialState of the 
	 * statemachine needs them. 
	 */
		context = new TestCOPServiceDef_SendFSMContext(this);

}

	
	/// Handle notifications on parent state changes
	public void setupNotifications()
	{

	}

	/// Access for debug purposes
	public String getStateName()
	{
		return context.getState().getName();
	}

	

	
}

