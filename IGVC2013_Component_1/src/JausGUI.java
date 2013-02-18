package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.ReportLocalWaypoint;
import src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages.ReportLocalWaypoint.Body.LocalWaypointRec;

public final class JausGUI extends JFrame {

	
	private JPanel contentPane;
	
	public static JTextPane textOutputPane;
	public static JLabel led_Controlled;				//LED: GreenON = controlled, GreenOFF = not controlled (rejected/released), Gray = default
	public static JLabel label_ControllingJausAddress;	// Displays JA of controlling comp. 0's when uncontrolled
	public static JLabel label_Authority;
	public static JTextField textSubsytemID;
	public static JTextField textNodeID;
	public static JTextField textComponentID;
	public static Boolean AddressSet = false;
	private JButton btnClearoutputpane;
	private JButton btnSetAddress;
	public static JTextField txtManagementState;
	public static JButton btnUpdateMgtState;
	private JPanel panelManagement;
	private JPanel panelInitialization;
	private JPanel panelAccessControl;
	public static JTextField txtXvelocity;
	public static JTextField txtYaw;
	private JTextField txtTimeStamp;
	private JLabel lblXvelocity;
	private JLabel lblYaw;
	private JLabel lblTimeStamp;
	private JPanel panelVelocityState;
	private JButton btnCheckTime;
	private JLabel lblXref;
	private JLabel lblYref;
	private JLabel lblYawref;
	private JLabel lblChangeX;
	private JLabel lblChangeY;
	private JLabel lblChangeYaw;
	public static JTextField textXref;
	public static JTextField textYref;
	public static JTextField textYawRef;
	public static JTextField textdeltaX;
	public static JTextField textdeltaY;
	public static JTextField textdeltaYaw;
	private JPanel panelLocalPoseSensor;
	private JLabel lblExecutelist;
	private JPanel panelWaypointNavigation;
	public static JLabel led_ListExecute;
	private JLabel lblLocalWaypoint;
	public static JTextField textLocalWaypoint;
	private JLabel lblActiveElement;
	public static JTextField textActiveWaypoint;
	private JLabel lblSpeed;
	public static JTextField textExecuteSpeed;
	private JButton btnNextWp;
	private JButton btnPeriodicQueryidentification;
	private JPanel panelDiscovery;
	private JLabel lblReportidentificationRecieved;
	public static JLabel led_ReportedIdentification;
	public static Boolean periodicQuery;
	Thread t = new PeriodicQuery();
	public static ClientSocket socket = new ClientSocket();
	public static double[] RobData = new double[] { 0,0,0,0,0 };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JausGUI frame = new JausGUI();
					frame.setVisible(true);
					frame.setIconImage(new ImageIcon("C:/JAUS_ICONS/York-College-Logo.gif").getImage());
					frame.setTitle("YCP IGVC 2013 - JAUS Server GUI");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JausGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 530);
		contentPane =  new JPanel();
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{40, 0, 0};
		gbl_contentPane.rowHeights = new int[]{20, 35, 0, 14, 30, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridheight = 8;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textOutputPane = new JTextPane();
		textOutputPane.setEditable(false);
		scrollPane.setViewportView(textOutputPane);
		textOutputPane.setText("GUI Initialized...\r\nUSER ACTION REQUIRED: Set Server Jaus Address!");
		
		panelInitialization = new JPanel();
		panelInitialization.setBorder(new TitledBorder(null, "Initialization", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelInitialization = new GridBagConstraints();
		gbc_panelInitialization.fill = GridBagConstraints.BOTH;
		gbc_panelInitialization.insets = new Insets(0, 0, 5, 5);
		gbc_panelInitialization.gridx = 0;
		gbc_panelInitialization.gridy = 1;
		contentPane.add(panelInitialization, gbc_panelInitialization);
		GridBagLayout gbl_panelInitialization = new GridBagLayout();
		gbl_panelInitialization.columnWidths = new int[]{40, 28, 50, 0, 50, 0, 50, 0};
		gbl_panelInitialization.rowHeights = new int[]{35, 0};
		gbl_panelInitialization.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelInitialization.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelInitialization.setLayout(gbl_panelInitialization);
		
		btnSetAddress = new JButton("Set Address");
		GridBagConstraints gbc_btnSetAddress = new GridBagConstraints();
		gbc_btnSetAddress.gridwidth = 2;
		gbc_btnSetAddress.insets = new Insets(0, 0, 0, 5);
		gbc_btnSetAddress.gridx = 0;
		gbc_btnSetAddress.gridy = 0;
		panelInitialization.add(btnSetAddress, gbc_btnSetAddress);
		btnSetAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSetAddress.setEnabled(false);
				textSubsytemID.setEditable(false);
			}
		});
		
		textSubsytemID = new JTextField();
		GridBagConstraints gbc_textSubsytemID = new GridBagConstraints();
		gbc_textSubsytemID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSubsytemID.insets = new Insets(0, 0, 0, 5);
		gbc_textSubsytemID.gridx = 2;
		gbc_textSubsytemID.gridy = 0;
		panelInitialization.add(textSubsytemID, gbc_textSubsytemID);
		textSubsytemID.setHorizontalAlignment(SwingConstants.CENTER);
		textSubsytemID.setText("111");
		textSubsytemID.setColumns(4);
		
		JLabel label = new JLabel(".");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		panelInitialization.add(label, gbc_label);
		
		textNodeID = new JTextField();
		GridBagConstraints gbc_textNodeID = new GridBagConstraints();
		gbc_textNodeID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNodeID.insets = new Insets(0, 0, 0, 5);
		gbc_textNodeID.gridx = 4;
		gbc_textNodeID.gridy = 0;
		panelInitialization.add(textNodeID, gbc_textNodeID);
		textNodeID.setEditable(false);
		textNodeID.setHorizontalAlignment(SwingConstants.CENTER);
		textNodeID.setText("1");
		textNodeID.setColumns(4);
		
		JLabel label_1 = new JLabel(".");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 0;
		panelInitialization.add(label_1, gbc_label_1);
		
		textComponentID = new JTextField();
		GridBagConstraints gbc_textComponentID = new GridBagConstraints();
		gbc_textComponentID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textComponentID.gridx = 6;
		gbc_textComponentID.gridy = 0;
		panelInitialization.add(textComponentID, gbc_textComponentID);
		textComponentID.setEditable(false);
		textComponentID.setHorizontalAlignment(SwingConstants.CENTER);
		textComponentID.setText("1");
		textComponentID.setColumns(4);
		btnSetAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddressSet = true;
				btnSetAddress.setEnabled(false);
			}
		});
		
		panelDiscovery = new JPanel();
		panelDiscovery.setBorder(new TitledBorder(null, "DiscoveryService", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDiscovery = new GridBagConstraints();
		gbc_panelDiscovery.fill = GridBagConstraints.BOTH;
		gbc_panelDiscovery.insets = new Insets(0, 0, 5, 5);
		gbc_panelDiscovery.gridx = 0;
		gbc_panelDiscovery.gridy = 2;
		contentPane.add(panelDiscovery, gbc_panelDiscovery);
		GridBagLayout gbl_panelDiscovery = new GridBagLayout();
		gbl_panelDiscovery.columnWidths = new int[]{40, 0, 54, 0};
		gbl_panelDiscovery.rowHeights = new int[]{0, 0};
		gbl_panelDiscovery.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDiscovery.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelDiscovery.setLayout(gbl_panelDiscovery);
		
		btnPeriodicQueryidentification = new JButton("Periodic QueryIdentification");
		btnPeriodicQueryidentification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				periodicQuery = true;
			    t.start(); //Start Thread to send Query for Identification every 5 seconds
			addOutputText(src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM.getStateName());
			}
		});
		GridBagConstraints gbc_btnPeriodicQueryidentification = new GridBagConstraints();
		gbc_btnPeriodicQueryidentification.insets = new Insets(0, 0, 0, 5);
		gbc_btnPeriodicQueryidentification.anchor = GridBagConstraints.WEST;
		gbc_btnPeriodicQueryidentification.gridx = 0;
		gbc_btnPeriodicQueryidentification.gridy = 0;
		panelDiscovery.add(btnPeriodicQueryidentification, gbc_btnPeriodicQueryidentification);
		
		
		
		lblReportidentificationRecieved = new JLabel("ReportIdentification Recieved:");
		GridBagConstraints gbc_lblReportidentificationRecieved = new GridBagConstraints();
		gbc_lblReportidentificationRecieved.insets = new Insets(0, 0, 0, 5);
		gbc_lblReportidentificationRecieved.gridx = 1;
		gbc_lblReportidentificationRecieved.gridy = 0;
		panelDiscovery.add(lblReportidentificationRecieved, gbc_lblReportidentificationRecieved);
		
		led_ReportedIdentification = new JLabel("");
		setLED(led_ReportedIdentification, "gray");
		GridBagConstraints gbc_led_ReportedIdentification = new GridBagConstraints();
		gbc_led_ReportedIdentification.gridx = 2;
		gbc_led_ReportedIdentification.gridy = 0;
		panelDiscovery.add(led_ReportedIdentification, gbc_led_ReportedIdentification);
		
		panelAccessControl = new JPanel();
		panelAccessControl.setBorder(new TitledBorder(null, "AccessControl Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelAccessControl = new GridBagConstraints();
		gbc_panelAccessControl.fill = GridBagConstraints.BOTH;
		gbc_panelAccessControl.insets = new Insets(0, 0, 5, 5);
		gbc_panelAccessControl.gridx = 0;
		gbc_panelAccessControl.gridy = 3;
		contentPane.add(panelAccessControl, gbc_panelAccessControl);
		GridBagLayout gbl_panelAccessControl = new GridBagLayout();
		gbl_panelAccessControl.columnWidths = new int[]{40, 46, 0, 62, 50, 50, 25, 0};
		gbl_panelAccessControl.rowHeights = new int[]{14, 0};
		gbl_panelAccessControl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAccessControl.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelAccessControl.setLayout(gbl_panelAccessControl);
		
		JLabel lblControlled = new JLabel("Controlled:");
		GridBagConstraints gbc_lblControlled = new GridBagConstraints();
		gbc_lblControlled.insets = new Insets(0, 0, 0, 5);
		gbc_lblControlled.gridx = 0;
		gbc_lblControlled.gridy = 0;
		panelAccessControl.add(lblControlled, gbc_lblControlled);
		lblControlled.setHorizontalAlignment(SwingConstants.CENTER);
		
		led_Controlled = new JLabel("");
		GridBagConstraints gbc_led_Controlled = new GridBagConstraints();
		gbc_led_Controlled.insets = new Insets(0, 0, 0, 5);
		gbc_led_Controlled.gridx = 1;
		gbc_led_Controlled.gridy = 0;
		panelAccessControl.add(led_Controlled, gbc_led_Controlled);
		setLED(led_Controlled, "gray");
		
		JLabel lblBy = new JLabel("Address:");
		GridBagConstraints gbc_lblBy = new GridBagConstraints();
		gbc_lblBy.insets = new Insets(0, 0, 0, 5);
		gbc_lblBy.gridx = 2;
		gbc_lblBy.gridy = 0;
		panelAccessControl.add(lblBy, gbc_lblBy);
		lblBy.setHorizontalAlignment(SwingConstants.CENTER);
		
		label_ControllingJausAddress = new JLabel("---.-.-");
		GridBagConstraints gbc_label_ControllingJausAddress = new GridBagConstraints();
		gbc_label_ControllingJausAddress.insets = new Insets(0, 0, 0, 5);
		gbc_label_ControllingJausAddress.gridx = 3;
		gbc_label_ControllingJausAddress.gridy = 0;
		panelAccessControl.add(label_ControllingJausAddress, gbc_label_ControllingJausAddress);
		label_ControllingJausAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblAuthority = new JLabel("Authority:");
		GridBagConstraints gbc_lblAuthority = new GridBagConstraints();
		gbc_lblAuthority.insets = new Insets(0, 0, 0, 5);
		gbc_lblAuthority.gridx = 4;
		gbc_lblAuthority.gridy = 0;
		panelAccessControl.add(lblAuthority, gbc_lblAuthority);
		lblAuthority.setHorizontalAlignment(SwingConstants.CENTER);
		
		label_Authority = new JLabel("---");
		label_Authority.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_label_Authority = new GridBagConstraints();
		gbc_label_Authority.insets = new Insets(0, 0, 0, 5);
		gbc_label_Authority.gridx = 5;
		gbc_label_Authority.gridy = 0;
		panelAccessControl.add(label_Authority, gbc_label_Authority);
		
		panelManagement = new JPanel();
		panelManagement.setBorder(new TitledBorder(null, "Management Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelManagement = new GridBagConstraints();
		gbc_panelManagement.fill = GridBagConstraints.BOTH;
		gbc_panelManagement.insets = new Insets(0, 0, 5, 5);
		gbc_panelManagement.gridx = 0;
		gbc_panelManagement.gridy = 4;
		contentPane.add(panelManagement, gbc_panelManagement);
		GridBagLayout gbl_panelManagement = new GridBagLayout();
		gbl_panelManagement.columnWidths = new int[]{40, 28, 50, 0, 50, 0, 50, 25, 0, 0};
		gbl_panelManagement.rowHeights = new int[]{0, 0};
		gbl_panelManagement.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelManagement.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelManagement.setLayout(gbl_panelManagement);
		
		btnUpdateMgtState = new JButton("Update State");
		btnUpdateMgtState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("Management_ReceiveFSM_SM.Receiving_Ready_NotControlled_StateA_Init".equals(src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM.getStateName())){
					txtManagementState.setText("INIT (NC)");
				}else if("Management_ReceiveFSM_SM.Receiving_Ready_Controlled_StateB_Ready".equals(src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM.getStateName())){
					txtManagementState.setText("READY (C)");
				}else if("Management_ReceiveFSM_SM.Receiving_Ready_Controlled_StateB_Standby".equals(src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM.getStateName())){
					txtManagementState.setText("STANDBY (C)");
				}else if("Management_ReceiveFSM_SM.Receiving_Ready_NotControlled_StateA_Standby".equals(src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM.getStateName())){
					txtManagementState.setText("STANDBY (NC)");
				}else if("Management_ReceiveFSM_SM.Receiving_Ready_NotControlled_StateA_Shutdown".equals(src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM.getStateName())){
					txtManagementState.setText("SHUTDOWN (NC)");
				}
			addOutputText(src.urn_jaus_jss_core_Management_1_0.Management_ReceiveFSM.getStateName());
			}
		});
		GridBagConstraints gbc_btnUpdateMgtState = new GridBagConstraints();
		gbc_btnUpdateMgtState.gridwidth = 2;
		gbc_btnUpdateMgtState.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateMgtState.gridx = 0;
		gbc_btnUpdateMgtState.gridy = 0;
		panelManagement.add(btnUpdateMgtState, gbc_btnUpdateMgtState);
		
		txtManagementState = new JTextField();
		GridBagConstraints gbc_txtManagementState = new GridBagConstraints();
		gbc_txtManagementState.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtManagementState.gridwidth = 5;
		gbc_txtManagementState.insets = new Insets(0, 0, 0, 5);
		gbc_txtManagementState.gridx = 2;
		gbc_txtManagementState.gridy = 0;
		panelManagement.add(txtManagementState, gbc_txtManagementState);
		txtManagementState.setEditable(false);
		txtManagementState.setHorizontalAlignment(SwingConstants.CENTER);
		txtManagementState.setText("*ManagementState");
		txtManagementState.setColumns(7);
		
		
		panelVelocityState = new JPanel();
		panelVelocityState.setBorder(new TitledBorder(null, "VelocityStateSensor Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelVelocityState = new GridBagConstraints();
		gbc_panelVelocityState.fill = GridBagConstraints.BOTH;
		gbc_panelVelocityState.insets = new Insets(0, 0, 5, 5);
		gbc_panelVelocityState.gridx = 0;
		gbc_panelVelocityState.gridy = 5;
		contentPane.add(panelVelocityState, gbc_panelVelocityState);
		GridBagLayout gbl_panelVelocityState = new GridBagLayout();
		gbl_panelVelocityState.columnWidths = new int[]{28, 50, 50, 0, 0};
		gbl_panelVelocityState.rowHeights = new int[]{0, 0, 0};
		gbl_panelVelocityState.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelVelocityState.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelVelocityState.setLayout(gbl_panelVelocityState);
		
		txtXvelocity = new JTextField();
		GridBagConstraints gbc_txtXvelocity = new GridBagConstraints();
		gbc_txtXvelocity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXvelocity.insets = new Insets(0, 0, 5, 5);
		gbc_txtXvelocity.gridx = 0;
		gbc_txtXvelocity.gridy = 0;
		panelVelocityState.add(txtXvelocity, gbc_txtXvelocity);
		txtXvelocity.setHorizontalAlignment(SwingConstants.CENTER);
		txtXvelocity.setText("0");
		txtXvelocity.setColumns(4);
		
		txtYaw = new JTextField();
		GridBagConstraints gbc_txtYaw = new GridBagConstraints();
		gbc_txtYaw.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYaw.insets = new Insets(0, 0, 5, 5);
		gbc_txtYaw.gridx = 1;
		gbc_txtYaw.gridy = 0;
		panelVelocityState.add(txtYaw, gbc_txtYaw);
		txtYaw.setHorizontalAlignment(SwingConstants.CENTER);
		txtYaw.setText("0");
		txtYaw.setColumns(4);
		
		txtTimeStamp = new JTextField();
		GridBagConstraints gbc_txtTimeStamp = new GridBagConstraints();
		gbc_txtTimeStamp.gridwidth = 2;
		gbc_txtTimeStamp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTimeStamp.insets = new Insets(0, 0, 5, 5);
		gbc_txtTimeStamp.gridx = 2;
		gbc_txtTimeStamp.gridy = 0;
		panelVelocityState.add(txtTimeStamp, gbc_txtTimeStamp);
		txtTimeStamp.setEditable(false);
		txtTimeStamp.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeStamp.setText("*TIME (for VelRep, LocPose)");
		txtTimeStamp.setColumns(6);
		
		lblXvelocity = new JLabel("X-Velocity (m/s)");
		GridBagConstraints gbc_lblXvelocity = new GridBagConstraints();
		gbc_lblXvelocity.insets = new Insets(0, 0, 0, 5);
		gbc_lblXvelocity.gridx = 0;
		gbc_lblXvelocity.gridy = 1;
		panelVelocityState.add(lblXvelocity, gbc_lblXvelocity);
		
		lblYaw = new JLabel("Yaw Rate\r\n(Rad/s)");
		GridBagConstraints gbc_lblYaw = new GridBagConstraints();
		gbc_lblYaw.insets = new Insets(0, 0, 0, 5);
		gbc_lblYaw.gridx = 1;
		gbc_lblYaw.gridy = 1;
		panelVelocityState.add(lblYaw, gbc_lblYaw);
		
		lblTimeStamp = new JLabel("Time (D.H.M.S.mS)");
		GridBagConstraints gbc_lblTimeStamp = new GridBagConstraints();
		gbc_lblTimeStamp.insets = new Insets(0, 0, 0, 5);
		gbc_lblTimeStamp.gridx = 2;
		gbc_lblTimeStamp.gridy = 1;
		panelVelocityState.add(lblTimeStamp, gbc_lblTimeStamp);
		
		btnCheckTime = new JButton("Check Time");
		GridBagConstraints gbc_btnCheckTime = new GridBagConstraints();
		gbc_btnCheckTime.gridx = 3;
		gbc_btnCheckTime.gridy = 1;
		panelVelocityState.add(btnCheckTime, gbc_btnCheckTime);
		btnCheckTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date dNow = new Date( );
			    SimpleDateFormat ft = new SimpleDateFormat ("d.H.m.s.S");
			    //Time (D.H.M.S.mS)
				txtTimeStamp.setText(ft.format(dNow));
			}
		});
		
		panelLocalPoseSensor = new JPanel();
		panelLocalPoseSensor.setBorder(new TitledBorder(null, "LocalPoseSensor Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelLocalPoseSensor = new GridBagConstraints();
		gbc_panelLocalPoseSensor.fill = GridBagConstraints.BOTH;
		gbc_panelLocalPoseSensor.insets = new Insets(0, 0, 5, 5);
		gbc_panelLocalPoseSensor.gridx = 0;
		gbc_panelLocalPoseSensor.gridy = 6;
		contentPane.add(panelLocalPoseSensor, gbc_panelLocalPoseSensor);
		GridBagLayout gbl_panelLocalPoseSensor = new GridBagLayout();
		gbl_panelLocalPoseSensor.columnWidths = new int[]{65, 65, 47, 65, 65, 0, 0};
		gbl_panelLocalPoseSensor.rowHeights = new int[]{0, 0, 0};
		gbl_panelLocalPoseSensor.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelLocalPoseSensor.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelLocalPoseSensor.setLayout(gbl_panelLocalPoseSensor);
		
		textXref = new JTextField();
		textXref.setEditable(false);
		GridBagConstraints gbc_textXref = new GridBagConstraints();
		gbc_textXref.fill = GridBagConstraints.HORIZONTAL;
		gbc_textXref.insets = new Insets(0, 0, 5, 5);
		gbc_textXref.gridx = 0;
		gbc_textXref.gridy = 0;
		panelLocalPoseSensor.add(textXref, gbc_textXref);
		textXref.setColumns(5);
		
		textYref = new JTextField();
		textYref.setEditable(false);
		GridBagConstraints gbc_textYref = new GridBagConstraints();
		gbc_textYref.fill = GridBagConstraints.HORIZONTAL;
		gbc_textYref.insets = new Insets(0, 0, 5, 5);
		gbc_textYref.gridx = 1;
		gbc_textYref.gridy = 0;
		panelLocalPoseSensor.add(textYref, gbc_textYref);
		textYref.setColumns(5);
		
		textYawRef = new JTextField();
		textYawRef.setEditable(false);
		GridBagConstraints gbc_textYawRef = new GridBagConstraints();
		gbc_textYawRef.fill = GridBagConstraints.HORIZONTAL;
		gbc_textYawRef.insets = new Insets(0, 0, 5, 5);
		gbc_textYawRef.gridx = 2;
		gbc_textYawRef.gridy = 0;
		panelLocalPoseSensor.add(textYawRef, gbc_textYawRef);
		textYawRef.setColumns(5);
		
		textdeltaX = new JTextField();
		textdeltaX.setHorizontalAlignment(SwingConstants.CENTER);
		textdeltaX.setText("0.0");
		GridBagConstraints gbc_textdeltaX = new GridBagConstraints();
		gbc_textdeltaX.fill = GridBagConstraints.HORIZONTAL;
		gbc_textdeltaX.insets = new Insets(0, 0, 5, 5);
		gbc_textdeltaX.gridx = 3;
		gbc_textdeltaX.gridy = 0;
		panelLocalPoseSensor.add(textdeltaX, gbc_textdeltaX);
		textdeltaX.setColumns(5);
		
		textdeltaY = new JTextField();
		textdeltaY.setHorizontalAlignment(SwingConstants.CENTER);
		textdeltaY.setText("0.0");
		GridBagConstraints gbc_textdeltaY = new GridBagConstraints();
		gbc_textdeltaY.fill = GridBagConstraints.HORIZONTAL;
		gbc_textdeltaY.insets = new Insets(0, 0, 5, 5);
		gbc_textdeltaY.gridx = 4;
		gbc_textdeltaY.gridy = 0;
		panelLocalPoseSensor.add(textdeltaY, gbc_textdeltaY);
		textdeltaY.setColumns(5);
		
		textdeltaYaw = new JTextField();
		textdeltaYaw.setEnabled(false);
		GridBagConstraints gbc_textdeltaYaw = new GridBagConstraints();
		gbc_textdeltaYaw.fill = GridBagConstraints.HORIZONTAL;
		gbc_textdeltaYaw.insets = new Insets(0, 0, 5, 0);
		gbc_textdeltaYaw.gridx = 5;
		gbc_textdeltaYaw.gridy = 0;
		panelLocalPoseSensor.add(textdeltaYaw, gbc_textdeltaYaw);
		textdeltaYaw.setColumns(5);
		
		lblXref = new JLabel("X-Ref (m)");
		GridBagConstraints gbc_lblXref = new GridBagConstraints();
		gbc_lblXref.insets = new Insets(0, 0, 0, 5);
		gbc_lblXref.gridx = 0;
		gbc_lblXref.gridy = 1;
		panelLocalPoseSensor.add(lblXref, gbc_lblXref);
		
		lblYref = new JLabel("Y-Ref (m)");
		GridBagConstraints gbc_lblYref = new GridBagConstraints();
		gbc_lblYref.insets = new Insets(0, 0, 0, 5);
		gbc_lblYref.gridx = 1;
		gbc_lblYref.gridy = 1;
		panelLocalPoseSensor.add(lblYref, gbc_lblYref);
		
		lblYawref = new JLabel("Yaw-Ref (rad)");
		GridBagConstraints gbc_lblYawref = new GridBagConstraints();
		gbc_lblYawref.insets = new Insets(0, 0, 0, 5);
		gbc_lblYawref.gridx = 2;
		gbc_lblYawref.gridy = 1;
		panelLocalPoseSensor.add(lblYawref, gbc_lblYawref);
		
		lblChangeX = new JLabel("\u0394"+ "X (m)");
		GridBagConstraints gbc_lblChangeX = new GridBagConstraints();
		gbc_lblChangeX.insets = new Insets(0, 0, 0, 5);
		gbc_lblChangeX.gridx = 3;
		gbc_lblChangeX.gridy = 1;
		panelLocalPoseSensor.add(lblChangeX, gbc_lblChangeX);
		
		lblChangeY = new JLabel("\u0394Y (m)");
		GridBagConstraints gbc_lblChangeY = new GridBagConstraints();
		gbc_lblChangeY.insets = new Insets(0, 0, 0, 5);
		gbc_lblChangeY.gridx = 4;
		gbc_lblChangeY.gridy = 1;
		panelLocalPoseSensor.add(lblChangeY, gbc_lblChangeY);
		
		lblChangeYaw = new JLabel("\u0394Yaw (rad)");
		GridBagConstraints gbc_lblChangeYaw = new GridBagConstraints();
		gbc_lblChangeYaw.gridx = 5;
		gbc_lblChangeYaw.gridy = 1;
		panelLocalPoseSensor.add(lblChangeYaw, gbc_lblChangeYaw);
		
		panelWaypointNavigation = new JPanel();
		panelWaypointNavigation.setBorder(new TitledBorder(null, "LocalWaypointListDriver", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelWaypointNavigation = new GridBagConstraints();
		gbc_panelWaypointNavigation.fill = GridBagConstraints.BOTH;
		gbc_panelWaypointNavigation.insets = new Insets(0, 0, 5, 5);
		gbc_panelWaypointNavigation.gridx = 0;
		gbc_panelWaypointNavigation.gridy = 7;
		contentPane.add(panelWaypointNavigation, gbc_panelWaypointNavigation);
		GridBagLayout gbl_panelWaypointNavigation = new GridBagLayout();
		gbl_panelWaypointNavigation.columnWidths = new int[]{40, 42, 0, 83, 0, 47, 0};
		gbl_panelWaypointNavigation.rowHeights = new int[]{0, 0, 0};
		gbl_panelWaypointNavigation.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelWaypointNavigation.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelWaypointNavigation.setLayout(gbl_panelWaypointNavigation);
		
		lblExecutelist = new JLabel("ExecuteList");
		GridBagConstraints gbc_lblExecutelist = new GridBagConstraints();
		gbc_lblExecutelist.insets = new Insets(0, 0, 5, 5);
		gbc_lblExecutelist.gridx = 0;
		gbc_lblExecutelist.gridy = 0;
		panelWaypointNavigation.add(lblExecutelist, gbc_lblExecutelist);
		
		led_ListExecute = new JLabel("");
		GridBagConstraints gbc_led_ListExecute = new GridBagConstraints();
		gbc_led_ListExecute.insets = new Insets(0, 0, 5, 5);
		gbc_led_ListExecute.gridx = 1;
		gbc_led_ListExecute.gridy = 0;
		panelWaypointNavigation.add(led_ListExecute, gbc_led_ListExecute);
		setLED(led_ListExecute, "gray");
		
		lblSpeed = new JLabel("Execute Speed:");
		GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
		gbc_lblSpeed.anchor = GridBagConstraints.EAST;
		gbc_lblSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpeed.gridx = 2;
		gbc_lblSpeed.gridy = 0;
		panelWaypointNavigation.add(lblSpeed, gbc_lblSpeed);
		
		textExecuteSpeed = new JTextField();
		textExecuteSpeed.setColumns(3);
		GridBagConstraints gbc_textExecuteSpeed = new GridBagConstraints();
		gbc_textExecuteSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_textExecuteSpeed.fill = GridBagConstraints.HORIZONTAL;
		gbc_textExecuteSpeed.gridx = 3;
		gbc_textExecuteSpeed.gridy = 0;
		panelWaypointNavigation.add(textExecuteSpeed, gbc_textExecuteSpeed);
		
		lblActiveElement = new JLabel("Active UID:");
		GridBagConstraints gbc_lblActiveElement = new GridBagConstraints();
		gbc_lblActiveElement.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblActiveElement.insets = new Insets(0, 0, 5, 5);
		gbc_lblActiveElement.gridx = 4;
		gbc_lblActiveElement.gridy = 0;
		panelWaypointNavigation.add(lblActiveElement, gbc_lblActiveElement);
		
		textActiveWaypoint = new JTextField();
		GridBagConstraints gbc_textActiveWaypoint = new GridBagConstraints();
		gbc_textActiveWaypoint.insets = new Insets(0, 0, 5, 0);
		gbc_textActiveWaypoint.gridx = 5;
		gbc_textActiveWaypoint.gridy = 0;
		panelWaypointNavigation.add(textActiveWaypoint, gbc_textActiveWaypoint);
		textActiveWaypoint.setColumns(3);
		
		btnNextWp = new JButton("Next Waypoint");
		btnNextWp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.activeWaypointListPosition++;
				//Increments Active Waypoint
				DecimalFormat threeDec = new DecimalFormat("0.000");
				ReportLocalWaypoint currentWaypoint = new ReportLocalWaypoint();
				//LocalWaypointRec instantiated to hold Rec after decoding it from the ElementData
				currentWaypoint.decode(src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.localWaypointLinkedList.get(src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.activeWaypointListPosition).getElementData().getData(), 0);
				//Decode data into LocalWaypointRec
				textLocalWaypoint.setText("( "+threeDec.format(currentWaypoint.getBody().getLocalWaypointRec().getX())+" , "+threeDec.format(currentWaypoint.getBody().getLocalWaypointRec().getY())+" )");
				textActiveWaypoint.setText(src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.localWaypointLinkedList.get(src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.LocalWaypointListDriver_ReceiveFSM.activeWaypointListPosition).getElementUID()+"");
			}
		});
		GridBagConstraints gbc_btnNextWp = new GridBagConstraints();
		gbc_btnNextWp.gridwidth = 2;
		gbc_btnNextWp.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNextWp.insets = new Insets(0, 0, 0, 5);
		gbc_btnNextWp.gridx = 0;
		gbc_btnNextWp.gridy = 1;
		panelWaypointNavigation.add(btnNextWp, gbc_btnNextWp);
		
		lblLocalWaypoint = new JLabel("Waypoint (X, Y):");
		GridBagConstraints gbc_lblLocalWaypoint = new GridBagConstraints();
		gbc_lblLocalWaypoint.insets = new Insets(0, 0, 0, 5);
		gbc_lblLocalWaypoint.anchor = GridBagConstraints.EAST;
		gbc_lblLocalWaypoint.gridx = 2;
		gbc_lblLocalWaypoint.gridy = 1;
		panelWaypointNavigation.add(lblLocalWaypoint, gbc_lblLocalWaypoint);
		
		textLocalWaypoint = new JTextField();
		textLocalWaypoint.setEditable(false);
		textLocalWaypoint.setText("(---,---)");
		GridBagConstraints gbc_textLocalWaypoint = new GridBagConstraints();
		gbc_textLocalWaypoint.gridwidth = 3;
		gbc_textLocalWaypoint.insets = new Insets(0, 0, 0, 5);
		gbc_textLocalWaypoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLocalWaypoint.gridx = 3;
		gbc_textLocalWaypoint.gridy = 1;
		panelWaypointNavigation.add(textLocalWaypoint, gbc_textLocalWaypoint);
		textLocalWaypoint.setColumns(4);
		
		btnClearoutputpane = new JButton("ClearOutputPane");
		GridBagConstraints gbc_btnClearoutputpane = new GridBagConstraints();
		gbc_btnClearoutputpane.gridx = 1;
		gbc_btnClearoutputpane.gridy = 8;
		contentPane.add(btnClearoutputpane, gbc_btnClearoutputpane);
		btnClearoutputpane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOutputPane.setText(" ");
			}
		});
	} 

	public static void setLED(JLabel led, String state) {
		if(state.equals("gray")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JAUS_ICONS/GrayLED.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); }
		else if(state.equals("greenOFF")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JAUS_ICONS/GreenLED_OFF.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); }
		else if(state.equals("greenON")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JAUS_ICONS/GreenLED_ON.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); }
		else if(state.equals("redOFF")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JAUS_ICONS/RedLED_OFF.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  }
		else if(state.equals("redON")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JAUS_ICONS/RedLED_ON.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  }
		else{ addOutputText("Attempting to set LED to to" + "'" + state + "'; Not a Valid state"); }
	} 
	
	public static void addOutputText(String string) {
		textOutputPane.setText(textOutputPane.getText() + "\n" + string);
	}
	
}
