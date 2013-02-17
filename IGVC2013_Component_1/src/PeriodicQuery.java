package src;
 


import src.urn_jaus_jss_core_Discovery_1_0.Messages.QueryIdentification;
import framework.transport.JausAddress;

public class PeriodicQuery extends Thread
{
    @Override
    public void run()
    {
        while(JausGUI.periodicQuery) {
        	QueryIdentification qiMsg = new QueryIdentification();
			//Message Instantiated
			qiMsg.getBody().getQueryIdentificationRec().setQueryType((short) 4);
			//Body FilledQueryType = 4 corresponds to a component query;
			framework.StateMachine.sendJausMessage(qiMsg, new JausAddress(65535, (short) 255,(short) 255));
			JausGUI.addOutputText("SENT: QueryIdentification MultiCasted");
			//Print notification to GUI
           try {
				Thread.sleep(5000);
           } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
           }
        }
    }

}








        	
