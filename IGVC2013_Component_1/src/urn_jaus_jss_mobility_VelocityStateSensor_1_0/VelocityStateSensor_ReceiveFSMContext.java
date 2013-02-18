/*
 * ex: set ro:
 * DO NOT EDIT.
 * generated by smc (http://smc.sourceforge.net/)
 * from file : VelocityStateSensor_ReceiveFSMContext.sm
 */

package src.urn_jaus_jss_mobility_VelocityStateSensor_1_0;

import framework.internalEvents.*;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.InternalEvents.*;
import src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.Messages.*;
import java.io.PrintStream;

public class VelocityStateSensor_ReceiveFSMContext
    extends statemap.FSMContext
{
//---------------------------------------------------------------
// Member methods.
//

    public VelocityStateSensor_ReceiveFSMContext(VelocityStateSensor_ReceiveFSM owner)
    {
        super (VelocityStateSensor_ReceiveFSM_SM.Receiving_Ready);

        _owner = owner;
    }

    public VelocityStateSensor_ReceiveFSMContext(VelocityStateSensor_ReceiveFSM owner, VelocityStateSensor_ReceiveFSMState initState)
    {
        super (initState);

        _owner = owner;
    }

    public void enterStartState()
    {
        getState().Entry(this);
        return;
    }

    public void BroadcastGlobalTransition()
    {
        _transition = "BroadcastGlobalTransition";
        getState().BroadcastGlobalTransition(this);
        _transition = "";
        return;
    }

    public void BroadcastLocalTransition()
    {
        _transition = "BroadcastLocalTransition";
        getState().BroadcastLocalTransition(this);
        _transition = "";
        return;
    }

    public void CancelEventTransition()
    {
        _transition = "CancelEventTransition";
        getState().CancelEventTransition(this);
        _transition = "";
        return;
    }

    public void CreateEventTransition()
    {
        _transition = "CreateEventTransition";
        getState().CreateEventTransition(this);
        _transition = "";
        return;
    }

    public void EventErrorTransition()
    {
        _transition = "EventErrorTransition";
        getState().EventErrorTransition(this);
        _transition = "";
        return;
    }

    public void EventOccurredTransition()
    {
        _transition = "EventOccurredTransition";
        getState().EventOccurredTransition(this);
        _transition = "";
        return;
    }

    public void QueryEventsTransition()
    {
        _transition = "QueryEventsTransition";
        getState().QueryEventsTransition(this);
        _transition = "";
        return;
    }

    public void QueryVelocityStateTransition()
    {
        _transition = "QueryVelocityStateTransition";
        getState().QueryVelocityStateTransition(this);
        _transition = "";
        return;
    }

    public void ReceiveTransition()
    {
        _transition = "ReceiveTransition";
        getState().ReceiveTransition(this);
        _transition = "";
        return;
    }

    public void ReceiveTransition(QueryVelocityState msg, Receive.Body.ReceiveRec transportData)
    {
        _transition = "ReceiveTransition";
        getState().ReceiveTransition(this, msg, transportData);
        _transition = "";
        return;
    }

    public void SendTransition()
    {
        _transition = "SendTransition";
        getState().SendTransition(this);
        _transition = "";
        return;
    }

    public void UpdateEventTransition()
    {
        _transition = "UpdateEventTransition";
        getState().UpdateEventTransition(this);
        _transition = "";
        return;
    }

    public VelocityStateSensor_ReceiveFSMState getState()
        throws statemap.StateUndefinedException
    {
        if (_state == null)
        {
            throw(
                new statemap.StateUndefinedException());
        }

        return ((VelocityStateSensor_ReceiveFSMState) _state);
    }

    protected VelocityStateSensor_ReceiveFSM getOwner()
    {
        return (_owner);
    }

    public void setOwner(VelocityStateSensor_ReceiveFSM owner)
    {
        if (owner == null)
        {
            throw (
                new NullPointerException(
                    "null owner"));
        }
        else
        {
            _owner = owner;
        }

        return;
    }

//---------------------------------------------------------------
// Member data.
//

    transient private VelocityStateSensor_ReceiveFSM _owner;

    public static abstract class VelocityStateSensor_ReceiveFSMState
        extends statemap.State
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected VelocityStateSensor_ReceiveFSMState(String name, int id)
        {
            super (name, id);
        }

        protected void Entry(VelocityStateSensor_ReceiveFSMContext context) {}
        protected void Exit(VelocityStateSensor_ReceiveFSMContext context) {}

        protected void BroadcastGlobalTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void BroadcastLocalTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void CancelEventTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void CreateEventTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void EventErrorTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void EventOccurredTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void QueryEventsTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void QueryVelocityStateTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void ReceiveTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void ReceiveTransition(VelocityStateSensor_ReceiveFSMContext context, QueryVelocityState msg, Receive.Body.ReceiveRec transportData)
        {
            Default(context);
        }

        protected void SendTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void UpdateEventTransition(VelocityStateSensor_ReceiveFSMContext context)
        {
            Default(context);
        }

        protected void Default(VelocityStateSensor_ReceiveFSMContext context)
        {
            if (context.getDebugFlag() == true)
            {
                PrintStream str = 
                    context.getDebugStream();

                str.println(
                    "TRANSITION   : Default");
            }

            throw (
                new statemap.TransitionUndefinedException(
                    "State: " +
                    context.getState().getName() +
                    ", Transition: " +
                    context.getTransition()));
        }

    //-----------------------------------------------------------
    // Member data.
    //
    }

    /* package */ static abstract class VelocityStateSensor_ReceiveFSM_SM
    {
    //-----------------------------------------------------------
    // Member methods.
    //

    //-----------------------------------------------------------
    // Member data.
    //

        //-------------------------------------------------------
        // Constants.
        //
        public static final VelocityStateSensor_ReceiveFSM_SM_Receiving_Ready Receiving_Ready =
            new VelocityStateSensor_ReceiveFSM_SM_Receiving_Ready("VelocityStateSensor_ReceiveFSM_SM.Receiving_Ready", 0);
        public static final VelocityStateSensor_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE Internally_Generated_State_DO_NOT_USE =
            new VelocityStateSensor_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE("VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE", 1);
        private static final VelocityStateSensor_ReceiveFSM_SM_Default Default =
            new VelocityStateSensor_ReceiveFSM_SM_Default("VelocityStateSensor_ReceiveFSM_SM.Default", -1);

    }

    protected static class VelocityStateSensor_ReceiveFSM_SM_Default
        extends VelocityStateSensor_ReceiveFSMState
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected VelocityStateSensor_ReceiveFSM_SM_Default(String name, int id)
        {
            super (name, id);
        }
    //-----------------------------------------------------------
    // Member data.
    //
    }

    private static final class VelocityStateSensor_ReceiveFSM_SM_Receiving_Ready
        extends VelocityStateSensor_ReceiveFSM_SM_Default
    {
    //-------------------------------------------------------
    // Member methods.
    //

        private VelocityStateSensor_ReceiveFSM_SM_Receiving_Ready(String name, int id)
        {
            super (name, id);
        }

        protected void ReceiveTransition(VelocityStateSensor_ReceiveFSMContext context, QueryVelocityState msg, Receive.Body.ReceiveRec transportData)
        {
            VelocityStateSensor_ReceiveFSM ctxt = context.getOwner();

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Receiving_Ready");
            }
            VelocityStateSensor_ReceiveFSMState endState = context.getState();

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Receiving_Ready.ReceiveTransition(QueryVelocityState msg, Receive.Body.ReceiveRec transportData)");
            }

            context.clearState();
            try
            {
                ctxt.SendAction("ReportVelocityState", transportData);
            }
            finally
            {
                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Receiving_Ready.ReceiveTransition(QueryVelocityState msg, Receive.Body.ReceiveRec transportData)");
                }

                context.setState(endState);
            }
            return;
        }

    //-------------------------------------------------------
    // Member data.
    //
    }

    private static final class VelocityStateSensor_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE
        extends VelocityStateSensor_ReceiveFSM_SM_Default
    {
    //-------------------------------------------------------
    // Member methods.
    //

        private VelocityStateSensor_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE(String name, int id)
        {
            super (name, id);
        }

        protected void BroadcastGlobalTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.BroadcastGlobalTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.BroadcastGlobalTransition()");
            }

            return;
        }

        protected void BroadcastLocalTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.BroadcastLocalTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.BroadcastLocalTransition()");
            }

            return;
        }

        protected void CancelEventTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.CancelEventTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.CancelEventTransition()");
            }

            return;
        }

        protected void CreateEventTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.CreateEventTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.CreateEventTransition()");
            }

            return;
        }

        protected void EventErrorTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.EventErrorTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.EventErrorTransition()");
            }

            return;
        }

        protected void EventOccurredTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.EventOccurredTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.EventOccurredTransition()");
            }

            return;
        }

        protected void QueryEventsTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.QueryEventsTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.QueryEventsTransition()");
            }

            return;
        }

        protected void QueryVelocityStateTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.QueryVelocityStateTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.QueryVelocityStateTransition()");
            }

            return;
        }

        protected void ReceiveTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.ReceiveTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.ReceiveTransition()");
            }

            return;
        }

        protected void SendTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.SendTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.SendTransition()");
            }

            return;
        }

        protected void UpdateEventTransition(VelocityStateSensor_ReceiveFSMContext context)
        {

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("LEAVING STATE   : VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("ENTER TRANSITION: VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.UpdateEventTransition()");
            }

            if (context.getDebugFlag() == true)
            {
                PrintStream str = context.getDebugStream();

                str.println("EXIT TRANSITION : VelocityStateSensor_ReceiveFSM_SM.VelocityStateSensor_ReceiveFSM_SM.Internally_Generated_State_DO_NOT_USE.UpdateEventTransition()");
            }

            return;
        }

    //-------------------------------------------------------
    // Member data.
    //
    }
}

/*
 * Local variables:
 *  buffer-read-only: t
 * End:
 */