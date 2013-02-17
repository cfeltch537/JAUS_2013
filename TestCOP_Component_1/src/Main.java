
package src;

import framework.transport.OS.JrSignal;
import sun.misc.Signal;
import sun.misc.SignalHandler;
import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static Logger logger = Logger.getLogger("TestCOP_Component_log");

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
			new JausCOP_GUI();
			JausCOP_GUI.main(null);
			while(!JausCOP_GUI.JausAddressSet){	}
			// Instantiate the component and start it once JausAddress is set
	    	TestCOP_Component cmpt = new TestCOP_Component(Integer.parseInt(JausCOP_GUI.textSubSystem.getText()), Short.parseShort(JausCOP_GUI.textNode.getText()), Short.parseShort(JausCOP_GUI.textComponent.getText()));
	    	JausCOP_GUI.addOutputText("Common Operating Point initialized");
	    	JausCOP_GUI.addOutputText("COP Jaus Address set to "+JausCOP_GUI.textSubSystem.getText()+"."+JausCOP_GUI.textNode.getText()+"."+JausCOP_GUI.textComponent.getText());
			// Catch exit signals
        	//Signal.handle(new Signal("INT"), handler);
        	//Signal.handle(new Signal("TERM"), handler);
        	//Signal.handle(new Signal("ABRT"), handler);
	
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
