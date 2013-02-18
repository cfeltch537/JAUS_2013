
package src;

import framework.transport.OS.JrSignal;
import sun.misc.Signal;
import sun.misc.SignalHandler;
import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static Logger logger = Logger.getLogger("IGVC2013_Component_log");

	// Create a static signal to catch interrupts
	private static JrSignal exit_signal = new JrSignal();
	private static boolean exit = false;

	static SignalHandler handler = new SignalHandler()
	{
        public void handle(Signal signal)
        {
			exit = true;
        }
	};
	
	public static void main(String[] args)
	{
		try
		{
			//Instantiate Component and wait until Jaus Address Set
			new JausGUI();
	    	JausGUI.main(null);
	    	JausGUI.addOutputText("USER ACTION REQUIRED: Set JAUS Address");
	    	JausGUI.socket.connect();
	    	//while(!JausGUI.AddressSet){ }
	    	// Instantiate the component and start it.
	    	IGVC2013_Component cmpt = new IGVC2013_Component(Integer.parseInt(JausGUI.textSubsytemID.getText()), Short.parseShort(JausGUI.textNodeID.getText()), Short.parseShort(JausGUI.textComponentID.getText()));
//			// Catch exit signals
//        	Signal.handle(new Signal("INT"), handler);
//        	Signal.handle(new Signal("TERM"), handler);
//        	Signal.handle(new Signal("ABRT"), handler);
	
			// Start the component and the services
			cmpt.startComponent();
	
			while(!exit)
			{
				// Throttle
				Thread.sleep(1);
			}

			// Shutdown the component and threads, then exit the program.
			cmpt.shutdownComponent();
			System.exit(0);

		}
		catch( Exception e)
		{
			logger.log(Level.SEVERE, null, e);
		}
	}
}
