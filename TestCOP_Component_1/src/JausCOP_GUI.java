package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import src.urn_TestCOPServiceDef_1_0.Messages.ExecuteList;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryActiveElement;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryControl;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryElementCount;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryElementList;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryIdentification;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryLocalPose;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryLocalWaypoint;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryServices;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryServices.Body.NodeList;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryServices.Body.NodeList.NodeSeq;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryServices.Body.NodeList.NodeSeq.ComponentList;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryServices.Body.NodeList.NodeSeq.ComponentList.ComponentRec;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryServices.Body.NodeList.NodeSeq.NodeRec;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryStatus;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryTravelSpeed;
import src.urn_TestCOPServiceDef_1_0.Messages.QueryVelocityState;
import src.urn_TestCOPServiceDef_1_0.Messages.ReleaseControl;
import src.urn_TestCOPServiceDef_1_0.Messages.ReportIdentification;
import src.urn_TestCOPServiceDef_1_0.Messages.RequestControl;
import src.urn_TestCOPServiceDef_1_0.Messages.Resume;
import src.urn_TestCOPServiceDef_1_0.Messages.SetElement;
import src.urn_TestCOPServiceDef_1_0.Messages.SetElement.Body.SetElementSeq.ElementList;
import src.urn_TestCOPServiceDef_1_0.Messages.SetElement.Body.SetElementSeq.ElementList.ElementRec;
import src.urn_TestCOPServiceDef_1_0.Messages.SetElement.Body.SetElementSeq.ElementList.ElementRec.ElementData;
import src.urn_TestCOPServiceDef_1_0.Messages.SetLocalPose;
import src.urn_TestCOPServiceDef_1_0.Messages.SetLocalWaypoint;
import src.urn_TestCOPServiceDef_1_0.Messages.Standby;
import src.urn_TestCOPServiceDef_1_0.Messages.Shutdown;

import framework.internalEvents.InternalEvent;
import framework.internalEvents.InternalEventHandler;
import framework.transport.JausAddress;
import framework.StateMachine;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class JausCOP_GUI extends JFrame {

	private JPanel contentPane;
	public static JTextPane textOutputPane;
	public static JTextField textAuthority;
	public static JTextField textSubSystem;
	public static JTextField textNode;
	public static JTextField textComponent;
	public static JLabel lblAuthority;
	public static JButton btnReleaseControl;
	public static JButton btnRequestControl;
	public static Boolean RequestControl = false;
	public static Boolean ReleaseControl = false;
	public static Boolean JausAddressSet = false;
	public static Boolean QueryControl = false;
	public static Boolean HandleGUI = false;
	public static JTextField textDestSubSystem;
	public static JTextField textDestNode;
	public static JTextField textDestComp;
	public static JButton btnCopjausaddress;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblDestjausaddress;
	private JButton btnQuerycontrol;
	private JScrollPane scrollPane;
	private JButton btnClearoutputpane;
	private JButton btnQueryIdentification;
	private JButton btnQueryServices;
	private JButton btnQuerystatus;
	private JButton btnResume;
	private JButton btnStandby;
	private JButton btnShutdown;
	private JPanel panelDiscovery;
	private JPanel panelAccessControl;
	private JPanel panelManagement;
	private JPanel panelInitialization;
	private JButton btnQueryvelocity;
	private JPanel panelVelocityStateSensor;
	private JButton btnQuerylocalpose;
	private JButton btnSetelements;
	private JPanel panelListManager;
	private JButton btnQueryelementlist;
	private JButton btnQueryelementcount;
	private JLabel lblRequestid;
	private JTextField txtRequestID;
	private JButton btnExecuteList;
	private JButton btnQueryactiveelement;
	private JPanel panelLocalWaypointListDriver;
	private JButton btnQuerytravelspeed;
	private JButton btnQuerylocalwaypoint;
	private JLabel lblSpeed;
	private JTextField textExecuteSpeed;
	public static JTextField textQueryActiveElement;
	public static JTextField textQueryTravelSpeed;
	public static JTextField textQueryLocalWaypoint;
	private JLabel lblms;
	private JLabel lblUid;
	public static JTextField textExecuteUID;
	private JButton btnReportidentification;
	private JButton btnSetLocalPose;
	private JLabel lblXyyaw;
	private JTextField textLocalPoseSetX;
	private JTextField textLocalPoseSetY;
	private JTextField textLocalPoseSetYaw;
	private JLabel lblSetWaypoints;
	private JPanel panel;
	private JTextField lwpnY1;
	private JTextField lwpnX1;
	private JTextField lwpnX2;
	private JTextField lwpnY2;
	private JTextField lwpnX5;
	private JTextField lwpnY5;
	private JTextField lwpnX3;
	private JTextField lwpnY3;
	private JTextField lwpnX4;
	private JTextField lwpnY4;
	private JButton lwpnClear;
	private JButton lwpnSquare;
	public static DecimalFormat threeDec = new DecimalFormat("0.000");

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
					JausCOP_GUI frame = new JausCOP_GUI();
					frame.setVisible(true);
					frame.setIconImage(new ImageIcon("C:/JTS/JAUS_ICONS/York-College-Logo.gif").getImage());
					frame.setTitle("YCP IGVC 2013 - JAUS Common Operating Picture GUI");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JausCOP_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{338, 430, 203, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 26, 0, 0, 0, 0, 0, 123, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panelInitialization = new JPanel();
		panelInitialization.setBorder(new TitledBorder(null, "Local and Destination Address", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelInitialization = new GridBagConstraints();
		gbc_panelInitialization.fill = GridBagConstraints.BOTH;
		gbc_panelInitialization.insets = new Insets(0, 0, 5, 5);
		gbc_panelInitialization.gridx = 0;
		gbc_panelInitialization.gridy = 1;
		contentPane.add(panelInitialization, gbc_panelInitialization);
		GridBagLayout gbl_panelInitialization = new GridBagLayout();
		gbl_panelInitialization.columnWidths = new int[]{39, 50, 0, 35, 0, 35, 0};
		gbl_panelInitialization.rowHeights = new int[]{0, 0, 0};
		gbl_panelInitialization.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelInitialization.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelInitialization.setLayout(gbl_panelInitialization);
		
		btnCopjausaddress = new JButton("Set COPJausAddress");
		GridBagConstraints gbc_btnCopjausaddress = new GridBagConstraints();
		gbc_btnCopjausaddress.insets = new Insets(0, 0, 5, 5);
		gbc_btnCopjausaddress.gridx = 0;
		gbc_btnCopjausaddress.gridy = 0;
		panelInitialization.add(btnCopjausaddress, gbc_btnCopjausaddress);
		
		textSubSystem = new JTextField();
		GridBagConstraints gbc_textSubSystem = new GridBagConstraints();
		gbc_textSubSystem.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSubSystem.insets = new Insets(0, 0, 5, 5);
		gbc_textSubSystem.gridx = 1;
		gbc_textSubSystem.gridy = 0;
		panelInitialization.add(textSubSystem, gbc_textSubSystem);
		textSubSystem.setHorizontalAlignment(SwingConstants.CENTER);
		textSubSystem.setText("42");
		textSubSystem.setColumns(5);
		
		label = new JLabel(".");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		panelInitialization.add(label, gbc_label);
		
		textNode = new JTextField();
		GridBagConstraints gbc_textNode = new GridBagConstraints();
		gbc_textNode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNode.insets = new Insets(0, 0, 5, 5);
		gbc_textNode.gridx = 3;
		gbc_textNode.gridy = 0;
		panelInitialization.add(textNode, gbc_textNode);
		textNode.setHorizontalAlignment(SwingConstants.CENTER);
		textNode.setText("1");
		textNode.setColumns(3);
		
		label_1 = new JLabel(".");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 4;
		gbc_label_1.gridy = 0;
		panelInitialization.add(label_1, gbc_label_1);
		
		textComponent = new JTextField();
		GridBagConstraints gbc_textComponent = new GridBagConstraints();
		gbc_textComponent.fill = GridBagConstraints.HORIZONTAL;
		gbc_textComponent.insets = new Insets(0, 0, 5, 0);
		gbc_textComponent.gridx = 5;
		gbc_textComponent.gridy = 0;
		panelInitialization.add(textComponent, gbc_textComponent);
		textComponent.setHorizontalAlignment(SwingConstants.CENTER);
		textComponent.setText("1");
		textComponent.setColumns(3);
		
		lblDestjausaddress = new JLabel("DESTJausAddress");
		GridBagConstraints gbc_lblDestjausaddress = new GridBagConstraints();
		gbc_lblDestjausaddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDestjausaddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblDestjausaddress.gridx = 0;
		gbc_lblDestjausaddress.gridy = 1;
		panelInitialization.add(lblDestjausaddress, gbc_lblDestjausaddress);
		lblDestjausaddress.setHorizontalAlignment(SwingConstants.CENTER);
		
		textDestSubSystem = new JTextField();
		GridBagConstraints gbc_textDestSubSystem = new GridBagConstraints();
		gbc_textDestSubSystem.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDestSubSystem.insets = new Insets(0, 0, 0, 5);
		gbc_textDestSubSystem.gridx = 1;
		gbc_textDestSubSystem.gridy = 1;
		panelInitialization.add(textDestSubSystem, gbc_textDestSubSystem);
		textDestSubSystem.setHorizontalAlignment(SwingConstants.CENTER);
		textDestSubSystem.setText("65535");
		textDestSubSystem.setColumns(5);
		
		label_2 = new JLabel(".");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 1;
		panelInitialization.add(label_2, gbc_label_2);
		
		textDestNode = new JTextField();
		GridBagConstraints gbc_textDestNode = new GridBagConstraints();
		gbc_textDestNode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDestNode.insets = new Insets(0, 0, 0, 5);
		gbc_textDestNode.gridx = 3;
		gbc_textDestNode.gridy = 1;
		panelInitialization.add(textDestNode, gbc_textDestNode);
		textDestNode.setHorizontalAlignment(SwingConstants.CENTER);
		textDestNode.setText("255");
		textDestNode.setColumns(3);
		
		label_3 = new JLabel(".");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 1;
		panelInitialization.add(label_3, gbc_label_3);
		
		textDestComp = new JTextField();
		GridBagConstraints gbc_textDestComp = new GridBagConstraints();
		gbc_textDestComp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDestComp.gridx = 5;
		gbc_textDestComp.gridy = 1;
		panelInitialization.add(textDestComp, gbc_textDestComp);
		textDestComp.setHorizontalAlignment(SwingConstants.CENTER);
		textDestComp.setText("255");
		textDestComp.setColumns(3);
		btnCopjausaddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JausAddressSet = true;
				btnCopjausaddress.setEnabled(false);
				textSubSystem.setEditable(false);
				textNode.setEditable(false);
				textComponent.setEditable(false);
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridheight = 9;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textOutputPane = new JTextPane();
		textOutputPane.setText("Gui Initialized...\r\nUSER ACTION REQUIRED: Set COP Jaus Address!");
		scrollPane.setViewportView(textOutputPane);
		textOutputPane.setEditable(false);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{91, 83, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblSetWaypoints = new JLabel("Local Waypoint List (X,Y) (meters)");
		GridBagConstraints gbc_lblSetWaypoints = new GridBagConstraints();
		gbc_lblSetWaypoints.gridwidth = 2;
		gbc_lblSetWaypoints.insets = new Insets(0, 0, 5, 0);
		gbc_lblSetWaypoints.gridx = 0;
		gbc_lblSetWaypoints.gridy = 0;
		panel.add(lblSetWaypoints, gbc_lblSetWaypoints);
		
		lwpnX1 = new JTextField();
		lwpnX1.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnX1.setText("-");
		GridBagConstraints gbc_lwpnX1 = new GridBagConstraints();
		gbc_lwpnX1.insets = new Insets(0, 0, 5, 5);
		gbc_lwpnX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnX1.gridx = 0;
		gbc_lwpnX1.gridy = 1;
		panel.add(lwpnX1, gbc_lwpnX1);
		lwpnX1.setColumns(10);
		
		lwpnY1 = new JTextField();
		lwpnY1.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnY1.setText("-");
		GridBagConstraints gbc_lwpnY1 = new GridBagConstraints();
		gbc_lwpnY1.insets = new Insets(0, 0, 5, 0);
		gbc_lwpnY1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnY1.gridx = 1;
		gbc_lwpnY1.gridy = 1;
		panel.add(lwpnY1, gbc_lwpnY1);
		lwpnY1.setColumns(10);
		
		lwpnX2 = new JTextField();
		lwpnX2.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnX2.setText("-");
		GridBagConstraints gbc_lwpnX2 = new GridBagConstraints();
		gbc_lwpnX2.insets = new Insets(0, 0, 5, 5);
		gbc_lwpnX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnX2.gridx = 0;
		gbc_lwpnX2.gridy = 2;
		panel.add(lwpnX2, gbc_lwpnX2);
		lwpnX2.setColumns(10);
		
		lwpnY2 = new JTextField();
		lwpnY2.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnY2.setText("-");
		GridBagConstraints gbc_lwpnY2 = new GridBagConstraints();
		gbc_lwpnY2.insets = new Insets(0, 0, 5, 0);
		gbc_lwpnY2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnY2.gridx = 1;
		gbc_lwpnY2.gridy = 2;
		panel.add(lwpnY2, gbc_lwpnY2);
		lwpnY2.setColumns(10);
		
		lwpnX3 = new JTextField();
		lwpnX3.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnX3.setText("-");
		GridBagConstraints gbc_lwpnX3 = new GridBagConstraints();
		gbc_lwpnX3.insets = new Insets(0, 0, 5, 5);
		gbc_lwpnX3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnX3.gridx = 0;
		gbc_lwpnX3.gridy = 3;
		panel.add(lwpnX3, gbc_lwpnX3);
		lwpnX3.setColumns(10);
		
		lwpnY3 = new JTextField();
		lwpnY3.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnY3.setText("-");
		GridBagConstraints gbc_lwpnY3 = new GridBagConstraints();
		gbc_lwpnY3.insets = new Insets(0, 0, 5, 0);
		gbc_lwpnY3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnY3.gridx = 1;
		gbc_lwpnY3.gridy = 3;
		panel.add(lwpnY3, gbc_lwpnY3);
		lwpnY3.setColumns(10);
		
		lwpnX4 = new JTextField();
		lwpnX4.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnX4.setText("-");
		GridBagConstraints gbc_lwpnX4 = new GridBagConstraints();
		gbc_lwpnX4.insets = new Insets(0, 0, 5, 5);
		gbc_lwpnX4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnX4.gridx = 0;
		gbc_lwpnX4.gridy = 4;
		panel.add(lwpnX4, gbc_lwpnX4);
		lwpnX4.setColumns(10);
		
		lwpnY4 = new JTextField();
		lwpnY4.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnY4.setText("-");
		GridBagConstraints gbc_lwpnY4 = new GridBagConstraints();
		gbc_lwpnY4.insets = new Insets(0, 0, 5, 0);
		gbc_lwpnY4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnY4.gridx = 1;
		gbc_lwpnY4.gridy = 4;
		panel.add(lwpnY4, gbc_lwpnY4);
		lwpnY4.setColumns(10);
		
		lwpnX5 = new JTextField();
		lwpnX5.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnX5.setText("-");
		GridBagConstraints gbc_lwpnX5 = new GridBagConstraints();
		gbc_lwpnX5.insets = new Insets(0, 0, 5, 5);
		gbc_lwpnX5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnX5.gridx = 0;
		gbc_lwpnX5.gridy = 5;
		panel.add(lwpnX5, gbc_lwpnX5);
		lwpnX5.setColumns(10);
		
		lwpnY5 = new JTextField();
		lwpnY5.setHorizontalAlignment(SwingConstants.CENTER);
		lwpnY5.setText("-");
		GridBagConstraints gbc_lwpnY5 = new GridBagConstraints();
		gbc_lwpnY5.insets = new Insets(0, 0, 5, 0);
		gbc_lwpnY5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnY5.gridx = 1;
		gbc_lwpnY5.gridy = 5;
		panel.add(lwpnY5, gbc_lwpnY5);
		lwpnY5.setColumns(10);
		
		lwpnClear = new JButton("Clear");
		GridBagConstraints gbc_lwpnClear = new GridBagConstraints();
		gbc_lwpnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnClear.insets = new Insets(0, 0, 0, 5);
		gbc_lwpnClear.gridx = 0;
		gbc_lwpnClear.gridy = 6;
		panel.add(lwpnClear, gbc_lwpnClear);
		lwpnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lwpnX1.setText("-");
				lwpnY1.setText("-");
				lwpnX2.setText("-");
				lwpnY2.setText("-");
				lwpnX3.setText("-");
				lwpnY3.setText("-");
				lwpnX4.setText("-");
				lwpnY4.setText("-");
				lwpnX5.setText("-");
				lwpnY5.setText("-");
			}
		});
		
		lwpnSquare = new JButton("Square");
		GridBagConstraints gbc_lwpnSquare = new GridBagConstraints();
		gbc_lwpnSquare.fill = GridBagConstraints.HORIZONTAL;
		gbc_lwpnSquare.gridx = 1;
		gbc_lwpnSquare.gridy = 6;
		panel.add(lwpnSquare, gbc_lwpnSquare);
		lwpnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lwpnX1.setText("5");
				lwpnY1.setText("5");
				lwpnX2.setText("5");
				lwpnY2.setText("-5");
				lwpnX3.setText("-5");
				lwpnY3.setText("-5");
				lwpnX4.setText("-5");
				lwpnY4.setText("5");
				lwpnX5.setText("0");
				lwpnY5.setText("0");
			}
		});
		
		panelDiscovery = new JPanel();
		panelDiscovery.setBorder(new TitledBorder(null, "Discovery Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDiscovery = new GridBagConstraints();
		gbc_panelDiscovery.fill = GridBagConstraints.BOTH;
		gbc_panelDiscovery.insets = new Insets(0, 0, 5, 5);
		gbc_panelDiscovery.gridx = 0;
		gbc_panelDiscovery.gridy = 2;
		contentPane.add(panelDiscovery, gbc_panelDiscovery);
		GridBagLayout gbl_panelDiscovery = new GridBagLayout();
		gbl_panelDiscovery.columnWidths = new int[]{97, 0, 0};
		gbl_panelDiscovery.rowHeights = new int[]{26, 0, 0};
		gbl_panelDiscovery.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDiscovery.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelDiscovery.setLayout(gbl_panelDiscovery);
		
		btnQueryIdentification = new JButton("*QueryIdentification*");
		GridBagConstraints gbc_btnQueryIdentification = new GridBagConstraints();
		gbc_btnQueryIdentification.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQueryIdentification.insets = new Insets(0, 0, 5, 5);
		gbc_btnQueryIdentification.gridx = 0;
		gbc_btnQueryIdentification.gridy = 0;
		panelDiscovery.add(btnQueryIdentification, gbc_btnQueryIdentification);
		
		btnReportidentification = new JButton("ReportIdentification");
		btnReportidentification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				ReportIdentification riMsg = new ReportIdentification();
				//Instantiate Message
				riMsg.getBody().getReportIdentificationRec().setQueryType((short) 4); //This reports only the component configuration (for testing purposes)
				riMsg.getBody().getReportIdentificationRec().setType(60001);
				riMsg.getBody().getReportIdentificationRec().setIdentification("York College of Pennsylvania IGVC Robot JAUS Component");
				//Fill Body
				framework.StateMachine.sendJausMessage(riMsg, dest);
				//Send Message
				addOutputText("SENT: ReportIdentification Message (Dest: " + dest + "; QueryType: 4; Type: 60001 (Component); Identification: 'York College of Pennsylvania IGVC Robot JAUS Component')");
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		GridBagConstraints gbc_btnReportidentification = new GridBagConstraints();
		gbc_btnReportidentification.insets = new Insets(0, 0, 5, 0);
		gbc_btnReportidentification.gridx = 1;
		gbc_btnReportidentification.gridy = 0;
		panelDiscovery.add(btnReportidentification, gbc_btnReportidentification);
		
		btnQueryServices = new JButton("QueryServices");
		btnQueryServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				QueryServices qsMsg = new QueryServices();
				//Message Instantiated
				ComponentRec compRec = new ComponentRec();
				compRec.setComponentID(Short.parseShort(JausCOP_GUI.textDestComp.getText()));
				//ComponentRec instantiated and filled with destCompID
				ComponentList compList = new ComponentList();
				compList.addElement(compRec);
				//CompList added and filled
				NodeRec nodeRec = new NodeRec();
				nodeRec.setNodeID(Short.parseShort(JausCOP_GUI.textDestNode.getText()));
				//NodeRec Instantiated and filled
				NodeSeq nodeSeq = new NodeSeq();
				nodeSeq.setComponentList(compList);
				nodeSeq.setNodeRec(nodeRec);
				//NodeSeq instantiated and filled
				//SPECIAL NOTE: in requirements it states that seq, record and list all into the NodeList
				//but I'm 99.99% sure the list and record go into the sequence then into the node list
				NodeList nodeList = new NodeList();
				nodeList.addElement(nodeSeq);
				//NodeList instantiated and filled
				qsMsg.getBody().setNodeList(nodeList);
				framework.StateMachine.sendJausMessage(qsMsg, dest);
				//Message body filled and sent
				addOutputText("SENT: QueryServices Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				addOutputText("**Note: This query services implementaiton will be used by the server in the Jaus Competition");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		GridBagConstraints gbc_btnQueryServices = new GridBagConstraints();
		gbc_btnQueryServices.insets = new Insets(0, 0, 0, 5);
		gbc_btnQueryServices.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQueryServices.gridx = 0;
		gbc_btnQueryServices.gridy = 1;
		panelDiscovery.add(btnQueryServices, gbc_btnQueryServices);
		
		btnQueryIdentification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				QueryIdentification qiMsg = new QueryIdentification();
				//Message Instantiated
				qiMsg.getBody().getQueryIdentificationRec().setQueryType((short) 4);
				//Body FilledQueryType = 4 corresponds to a component query;
				framework.StateMachine.sendJausMessage(qiMsg, dest);
				addOutputText("SENT: QueryIdentification Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		
		panelAccessControl = new JPanel();
		panelAccessControl.setBorder(new TitledBorder(null, "AccessControl Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelAccessControl = new GridBagConstraints();
		gbc_panelAccessControl.fill = GridBagConstraints.BOTH;
		gbc_panelAccessControl.insets = new Insets(0, 0, 5, 5);
		gbc_panelAccessControl.gridx = 0;
		gbc_panelAccessControl.gridy = 3;
		contentPane.add(panelAccessControl, gbc_panelAccessControl);
		GridBagLayout gbl_panelAccessControl = new GridBagLayout();
		gbl_panelAccessControl.columnWidths = new int[]{150, 50, 0, 66, 0};
		gbl_panelAccessControl.rowHeights = new int[]{0, 0, 0};
		gbl_panelAccessControl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAccessControl.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelAccessControl.setLayout(gbl_panelAccessControl);
		
		btnQuerycontrol = new JButton("QueryControl");
		GridBagConstraints gbc_btnQuerycontrol = new GridBagConstraints();
		gbc_btnQuerycontrol.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuerycontrol.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuerycontrol.gridx = 0;
		gbc_btnQuerycontrol.gridy = 0;
		panelAccessControl.add(btnQuerycontrol, gbc_btnQuerycontrol);
		
		lblAuthority = new JLabel("Authority:");
		GridBagConstraints gbc_lblAuthority = new GridBagConstraints();
		gbc_lblAuthority.anchor = GridBagConstraints.EAST;
		gbc_lblAuthority.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthority.gridx = 1;
		gbc_lblAuthority.gridy = 0;
		panelAccessControl.add(lblAuthority, gbc_lblAuthority);
		
		textAuthority = new JTextField();
		GridBagConstraints gbc_textAuthority = new GridBagConstraints();
		gbc_textAuthority.anchor = GridBagConstraints.WEST;
		gbc_textAuthority.gridwidth = 2;
		gbc_textAuthority.insets = new Insets(0, 0, 5, 0);
		gbc_textAuthority.gridx = 2;
		gbc_textAuthority.gridy = 0;
		panelAccessControl.add(textAuthority, gbc_textAuthority);
		textAuthority.setHorizontalAlignment(SwingConstants.CENTER);
		textAuthority.setText("100");
		textAuthority.setColumns(3);
		
		btnRequestControl = new JButton("RequestControl");
		GridBagConstraints gbc_btnRequestControl = new GridBagConstraints();
		gbc_btnRequestControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRequestControl.insets = new Insets(0, 0, 0, 5);
		gbc_btnRequestControl.gridx = 0;
		gbc_btnRequestControl.gridy = 1;
		panelAccessControl.add(btnRequestControl, gbc_btnRequestControl);
		
		btnReleaseControl = new JButton("*ReleaseControl*");
		GridBagConstraints gbc_btnReleaseControl = new GridBagConstraints();
		gbc_btnReleaseControl.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReleaseControl.gridwidth = 3;
		gbc_btnReleaseControl.insets = new Insets(0, 0, 0, 5);
		gbc_btnReleaseControl.gridx = 1;
		gbc_btnReleaseControl.gridy = 1;
		panelAccessControl.add(btnReleaseControl, gbc_btnReleaseControl);
		btnReleaseControl.addActionListener(new ActionListener() { //*************************************************************************ReleaseControl
			public void actionPerformed(ActionEvent e) {
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				ReleaseControl rcMsg = new ReleaseControl();				
				//Instantiate Message
				//Set necessary Body fields
				framework.StateMachine.sendJausMessage(rcMsg, dest);
				//Send to Destination
				addOutputText("SENT: ReleaseControl Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});	
		btnRequestControl.addActionListener(new ActionListener() { //*************************************************************************RequestControl
			public void actionPerformed(ActionEvent e) {
				
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				RequestControl rcMsg = new RequestControl();
				//Instantiate Message
				rcMsg.getBody().getRequestControlRec().setAuthorityCode(Short.parseShort(JausCOP_GUI.textAuthority.getText()));
				//Set necessary Body fields
				framework.StateMachine.sendJausMessage(rcMsg, dest);
				//Send to Destination
				addOutputText("SENT: RequestControl Message (Authority : "+rcMsg.getBody().getRequestControlRec().getAuthorityCode()+"; Dest: "+dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		btnQuerycontrol.addActionListener(new ActionListener() { //*************************************************************************QueryControl
			public void actionPerformed(ActionEvent e) {							
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryControl qcMsg = new QueryControl();
				//Instantiate Message
				framework.StateMachine.sendJausMessage(qcMsg, dest);
				//Send to Destination
				addOutputText("SENT: QueryControl Message (Dest: "+dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		
		panelManagement = new JPanel();
		panelManagement.setBorder(new TitledBorder(null, "Management Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelManagement = new GridBagConstraints();
		gbc_panelManagement.fill = GridBagConstraints.BOTH;
		gbc_panelManagement.insets = new Insets(0, 0, 5, 5);
		gbc_panelManagement.gridx = 0;
		gbc_panelManagement.gridy = 4;
		contentPane.add(panelManagement, gbc_panelManagement);
		GridBagLayout gbl_panelManagement = new GridBagLayout();
		gbl_panelManagement.columnWidths = new int[]{150, 150, 0};
		gbl_panelManagement.rowHeights = new int[]{0, 0, 0};
		gbl_panelManagement.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelManagement.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelManagement.setLayout(gbl_panelManagement);
		
		btnQuerystatus = new JButton("QueryStatus");
		btnQuerystatus.addActionListener(new ActionListener() { //*************************************************************************QueryStatus
			public void actionPerformed(ActionEvent e) {
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryStatus qsMsg = new QueryStatus();				
				//Instantiate Message
				//Set necessary Body fields
				framework.StateMachine.sendJausMessage(qsMsg, dest);
				//Send to Destination
				addOutputText("SENT: QueryStatus Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		GridBagConstraints gbc_btnQuerystatus = new GridBagConstraints();
		gbc_btnQuerystatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuerystatus.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuerystatus.gridx = 0;
		gbc_btnQuerystatus.gridy = 0;
		panelManagement.add(btnQuerystatus, gbc_btnQuerystatus);
		
		
		btnResume = new JButton("Resume");
		btnResume.addActionListener(new ActionListener() { //*************************************************************************Resume
			public void actionPerformed(ActionEvent e) {
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				Resume rMsg = new Resume();				
				//Instantiate Message
				//Set necessary Body fields
				framework.StateMachine.sendJausMessage(rMsg, dest);
				//Send to Destination
				addOutputText("SENT: Resume Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		
		
		btnShutdown = new JButton("Shutdown");
		btnShutdown.addActionListener(new ActionListener() { //*************************************************************************Shutdown
			public void actionPerformed(ActionEvent e) {
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				Shutdown sMsg = new Shutdown();				
				//Instantiate Message
				//Set necessary Body fields
				framework.StateMachine.sendJausMessage(sMsg, dest);
				//Send to Destination
				addOutputText("SENT: Shutdown Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		GridBagConstraints gbc_btnShutdown = new GridBagConstraints();
		gbc_btnShutdown.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnShutdown.insets = new Insets(0, 0, 5, 0);
		gbc_btnShutdown.gridx = 1;
		gbc_btnShutdown.gridy = 0;
		panelManagement.add(btnShutdown, gbc_btnShutdown);
		GridBagConstraints gbc_btnResume = new GridBagConstraints();
		gbc_btnResume.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnResume.insets = new Insets(0, 0, 0, 5);
		gbc_btnResume.gridx = 0;
		gbc_btnResume.gridy = 1;
		panelManagement.add(btnResume, gbc_btnResume);
		
		btnStandby = new JButton("Standby");
		btnStandby.addActionListener(new ActionListener() { //*************************************************************************Standby
			public void actionPerformed(ActionEvent e) {
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				Standby sMsg = new Standby();				
				//Instantiate Message
				//Set necessary Body fields
				framework.StateMachine.sendJausMessage(sMsg, dest);
				//Send to Destination
				addOutputText("SENT: Standby Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
				//Clear last received message ID
			}
		});
		GridBagConstraints gbc_btnStandby = new GridBagConstraints();
		gbc_btnStandby.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStandby.gridx = 1;
		gbc_btnStandby.gridy = 1;
		panelManagement.add(btnStandby, gbc_btnStandby);
		
		
		
		
		panelVelocityStateSensor = new JPanel();
		panelVelocityStateSensor.setBorder(new TitledBorder(null, "VelocityState/LocalPoseSensor Services", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelVelocityStateSensor = new GridBagConstraints();
		gbc_panelVelocityStateSensor.fill = GridBagConstraints.BOTH;
		gbc_panelVelocityStateSensor.insets = new Insets(0, 0, 5, 5);
		gbc_panelVelocityStateSensor.gridx = 0;
		gbc_panelVelocityStateSensor.gridy = 5;
		contentPane.add(panelVelocityStateSensor, gbc_panelVelocityStateSensor);
		GridBagLayout gbl_panelVelocityStateSensor = new GridBagLayout();
		gbl_panelVelocityStateSensor.columnWidths = new int[]{0, 39, 40, 0, 0, 0};
		gbl_panelVelocityStateSensor.rowHeights = new int[]{0, 0, 0};
		gbl_panelVelocityStateSensor.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelVelocityStateSensor.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelVelocityStateSensor.setLayout(gbl_panelVelocityStateSensor);
		
		btnQueryvelocity = new JButton("QueryVelocityState");
		btnQueryvelocity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************QueryVelocityState
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryVelocityState qvsMsg= new QueryVelocityState();
				//Instantiate Message
				framework.StateMachine.sendJausMessage(qvsMsg, dest);
				//Send to Destination
				addOutputText("SENT: QueryVelocityState Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
			}
		});
		
		btnSetLocalPose = new JButton("SetLocalPose");
		btnSetLocalPose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************QueryVelocityState
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				SetLocalPose slpMsg= new SetLocalPose();
				//Instantiate Message
				slpMsg.getBody().getLocalPoseRec().setX(Double.parseDouble(textLocalPoseSetX.getText()));
				slpMsg.getBody().getLocalPoseRec().setY(Double.parseDouble(textLocalPoseSetY.getText()));
				slpMsg.getBody().getLocalPoseRec().setYaw(Double.parseDouble(textLocalPoseSetYaw.getText()));
				framework.StateMachine.sendJausMessage(slpMsg, dest);
				//Send to Destination
				addOutputText("SENT: SetLocalPose Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
			}
		});
		GridBagConstraints gbc_btnSetLocalPose = new GridBagConstraints();
		gbc_btnSetLocalPose.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetLocalPose.gridx = 0;
		gbc_btnSetLocalPose.gridy = 0;
		panelVelocityStateSensor.add(btnSetLocalPose, gbc_btnSetLocalPose);
		
		lblXyyaw = new JLabel("X,Y,Yaw:");
		GridBagConstraints gbc_lblXyyaw = new GridBagConstraints();
		gbc_lblXyyaw.anchor = GridBagConstraints.EAST;
		gbc_lblXyyaw.insets = new Insets(0, 0, 5, 5);
		gbc_lblXyyaw.gridx = 1;
		gbc_lblXyyaw.gridy = 0;
		panelVelocityStateSensor.add(lblXyyaw, gbc_lblXyyaw);
		
		textLocalPoseSetX = new JTextField();
		GridBagConstraints gbc_textLocalPoseSetX = new GridBagConstraints();
		gbc_textLocalPoseSetX.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLocalPoseSetX.insets = new Insets(0, 0, 5, 5);
		gbc_textLocalPoseSetX.gridx = 2;
		gbc_textLocalPoseSetX.gridy = 0;
		panelVelocityStateSensor.add(textLocalPoseSetX, gbc_textLocalPoseSetX);
		textLocalPoseSetX.setColumns(5);
		
		textLocalPoseSetY = new JTextField();
		GridBagConstraints gbc_textLocalPoseSetY = new GridBagConstraints();
		gbc_textLocalPoseSetY.insets = new Insets(0, 0, 5, 5);
		gbc_textLocalPoseSetY.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLocalPoseSetY.gridx = 3;
		gbc_textLocalPoseSetY.gridy = 0;
		panelVelocityStateSensor.add(textLocalPoseSetY, gbc_textLocalPoseSetY);
		textLocalPoseSetY.setColumns(5);
		
		textLocalPoseSetYaw = new JTextField();
		GridBagConstraints gbc_textLocalPoseSetYaw = new GridBagConstraints();
		gbc_textLocalPoseSetYaw.insets = new Insets(0, 0, 5, 0);
		gbc_textLocalPoseSetYaw.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLocalPoseSetYaw.gridx = 4;
		gbc_textLocalPoseSetYaw.gridy = 0;
		panelVelocityStateSensor.add(textLocalPoseSetYaw, gbc_textLocalPoseSetYaw);
		textLocalPoseSetYaw.setColumns(5);
		GridBagConstraints gbc_btnQueryvelocity = new GridBagConstraints();
		gbc_btnQueryvelocity.gridwidth = 2;
		gbc_btnQueryvelocity.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQueryvelocity.insets = new Insets(0, 0, 0, 5);
		gbc_btnQueryvelocity.gridx = 0;
		gbc_btnQueryvelocity.gridy = 1;
		panelVelocityStateSensor.add(btnQueryvelocity, gbc_btnQueryvelocity);
		
		btnQuerylocalpose = new JButton("QueryLocalPose");
		btnQuerylocalpose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************QueryVelocityState
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryLocalPose qlpMsg= new QueryLocalPose();
				//Instantiate Message
				framework.StateMachine.sendJausMessage(qlpMsg, dest);
				//Send to Destination
				addOutputText("SENT: QueryLocalPose Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
			}
		});
		GridBagConstraints gbc_btnQuerylocalpose = new GridBagConstraints();
		gbc_btnQuerylocalpose.gridwidth = 3;
		gbc_btnQuerylocalpose.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuerylocalpose.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuerylocalpose.gridx = 2;
		gbc_btnQuerylocalpose.gridy = 1;
		panelVelocityStateSensor.add(btnQuerylocalpose, gbc_btnQuerylocalpose);
		
		panelListManager = new JPanel();
		panelListManager.setBorder(new TitledBorder(null, "ListManager Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelListManager = new GridBagConstraints();
		gbc_panelListManager.fill = GridBagConstraints.BOTH;
		gbc_panelListManager.insets = new Insets(0, 0, 5, 5);
		gbc_panelListManager.gridx = 0;
		gbc_panelListManager.gridy = 6;
		contentPane.add(panelListManager, gbc_panelListManager);
		GridBagLayout gbl_panelListManager = new GridBagLayout();
		gbl_panelListManager.columnWidths = new int[]{150, 79, 0, 24, 0};
		gbl_panelListManager.rowHeights = new int[]{0, 0, 0};
		gbl_panelListManager.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelListManager.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelListManager.setLayout(gbl_panelListManager);
		
		btnSetelements = new JButton("SetElement(s)");
		btnSetelements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************SetElement
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				SetElement seMsg= new SetElement();
				//Instantiate Message
				seMsg.getBody().getSetElementSeq().getRequestIDRec().setRequestID(Short.parseShort(txtRequestID.getText()));
				//Fill RequestID field in Body
				ElementList elementList = new ElementList();
				//Create new elementList
				
				
//				ElementList elementList = new ElementList();
//				//Element List created to store ElementRecs
//				ElementRec element1 = new ElementRec();
//				ElementRec element2 = new ElementRec();
//				ElementRec element3 = new ElementRec();
//				ElementRec element4 = new ElementRec();
//				ElementRec element5 = new ElementRec();
//				//ElementRecords
//				SetLocalWaypoint setLocalWaypoint1 = new SetLocalWaypoint();
//				SetLocalWaypoint setLocalWaypoint2 = new SetLocalWaypoint();
//				SetLocalWaypoint setLocalWaypoint3 = new SetLocalWaypoint();
//				SetLocalWaypoint setLocalWaypoint4 = new SetLocalWaypoint();
//				SetLocalWaypoint setLocalWaypoint5 = new SetLocalWaypoint();
//				//Element Data will be SetLocalWaypoint message payload
//				element1.setElementUID(1);
//				element1.setPreviousUID(0);
//				element1.setNextUID(0);
//				setLocalWaypoint1.getBody().getLocalWaypointRec().setX(11);
//				setLocalWaypoint1.getBody().getLocalWaypointRec().setY(11);
//				//Element1 added
//				element2.setElementUID(2);
//				element2.setPreviousUID(1);
//				element2.setNextUID(0);
//				setLocalWaypoint2.getBody().getLocalWaypointRec().setX(12);
//				setLocalWaypoint2.getBody().getLocalWaypointRec().setY(-12);
//				//elementList.addElement(element2);
//				//Element2 added
//				element4.setElementUID(4);
//				element4.setPreviousUID(2);
//				element4.setNextUID(0);
//				setLocalWaypoint4.getBody().getLocalWaypointRec().setX(-14);
//				setLocalWaypoint4.getBody().getLocalWaypointRec().setY(14);
//				//elementList.addElement(element4);
//				//Element4 added
//				element3.setElementUID(3);
//				element3.setPreviousUID(2);
//				element3.setNextUID(4);
//				setLocalWaypoint3.getBody().getLocalWaypointRec().setX(-13);
//				setLocalWaypoint3.getBody().getLocalWaypointRec().setY(-13);
//				//elementList.addElement(element3);
//				//Element3 added
//				long bufsize; 
//				ByteBuffer buffer1;
//				ByteBuffer buffer2;
//				ByteBuffer buffer3;
//				ByteBuffer buffer4;
//				ElementData elementData1 = new ElementData();
//				ElementData elementData2 = new ElementData();
//				ElementData elementData3 = new ElementData();
//				ElementData elementData4 = new ElementData();
//				int pos;
//				//Instantiate byteBuffer
//				bufsize = setLocalWaypoint1.getSize();
//				buffer1 = ByteBuffer.allocate((int) bufsize);
//				buffer1.order(ByteOrder.LITTLE_ENDIAN);
//				buffer1.clear();
//				pos = 0; 
//				setLocalWaypoint1.encode(buffer1, pos);
//			
//				elementData1.set((short)0, buffer1.array().length, buffer1);
//				element1.setElementData(elementData1);
//				elementList.addElement(element1);
//				//Encode and add element1 data
//				bufsize = setLocalWaypoint2.getSize();
//				buffer2 = ByteBuffer.allocate((int) bufsize);
//				buffer2.order(ByteOrder.LITTLE_ENDIAN);
//				buffer2.clear();
//				pos = 0; 
//				setLocalWaypoint2.encode(buffer2, pos);
//				elementData2.set((short)0, buffer2.array().length, buffer2);
//				element2.setElementData(elementData2);
//				elementList.addElement(element2);
//				//Encode and add element2 data
//				bufsize = setLocalWaypoint4.getSize();
//				buffer4 = ByteBuffer.allocate((int) bufsize);
//				buffer4.order(ByteOrder.LITTLE_ENDIAN);
//				buffer4.clear();
//				pos = 0; 
//				setLocalWaypoint4.encode(buffer4, pos);
//				elementData4.set((short)0, buffer4.array().length, buffer4);
//				element4.setElementData(elementData4);
//				elementList.addElement(element4);
//				//Encode and add element4 data
//				bufsize = setLocalWaypoint3.getSize();
//				buffer3 = ByteBuffer.allocate((int) bufsize);
//				buffer3.order(ByteOrder.LITTLE_ENDIAN);
//				buffer3.clear();
//				pos = 0; 
//				setLocalWaypoint3.encode(buffer3, pos);
//				elementData3.set((short)0, buffer3.array().length, buffer3);
//				element3.setElementData(elementData3);
//				elementList.addElement(element3);
//				//Encode and add element3 data
//				//ElementData encoded and placed into message
//				seMsg.getBody().getSetElementSeq().setElementList(elementList);
//				//Element List added to Message Body
//				framework.StateMachine.sendJausMessage(seMsg, dest);
//				SetLocalWaypoint tempForGUI = new SetLocalWaypoint();
//				String containedWaypoint;
//				//Send to Destination
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(0).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 1: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(1).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 2: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(2).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 3: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(3).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 4: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(4).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 5: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(0).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 1: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(1).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 2: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(2).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 3: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(3).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 4: "+containedWaypoint);
//				tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(4).getElementData().getData(), 0);
//				containedWaypoint = "("+tempForGUI.getBody().getLocalWaypointRec().getX()+" , "+tempForGUI.getBody().getLocalWaypointRec().getY()+")";
//				addOutputText("Element 5: "+containedWaypoint);
				
				
				int currentUID = 1;
				
				for(int i=0;i<5;i++){
					if((i==0)&&!(lwpnX1.getText().equals("-"))&&!(lwpnY1.getText().equals("-"))){
						addWaypointToList(Double.parseDouble(lwpnX1.getText()), Double.parseDouble(lwpnY1.getText()), currentUID, 0, currentUID-1, elementList);
						addOutputText("Waypoint: " + (i+1) + "; Added as Element " + currentUID);
						currentUID++;
					}else if((i==1)&&!(lwpnX2.getText().equals("-"))&&!(lwpnY2.getText().equals("-"))){
						addWaypointToList(Double.parseDouble(lwpnX2.getText()), Double.parseDouble(lwpnY2.getText()), currentUID, 0, currentUID-1, elementList);
						addOutputText("Waypoint: " + (i+1) + "; Added as Element " + currentUID);
						currentUID++;
					}else if((i==2)&&!(lwpnX3.getText().equals("-"))&&!(lwpnY3.getText().equals("-"))){
						addWaypointToList(Double.parseDouble(lwpnX3.getText()), Double.parseDouble(lwpnY3.getText()), currentUID, 0, currentUID-1, elementList);
						addOutputText("Waypoint: " + (i+1) + "; Added as Element " + currentUID);
						currentUID++;
					}else if((i==3)&&!(lwpnX4.getText().equals("-"))&&!(lwpnY4.getText().equals("-"))){
						addWaypointToList(Double.parseDouble(lwpnX4.getText()), Double.parseDouble(lwpnY4.getText()), currentUID, 0, currentUID-1, elementList);
						addOutputText("Waypoint: " + (i+1) + "; Added as Element " + currentUID);
						currentUID++;
					}else if((i==4)&&!(lwpnX5.getText().equals("-"))&&!(lwpnY5.getText().equals("-"))){
						addWaypointToList(Double.parseDouble(lwpnX5.getText()), Double.parseDouble(lwpnY5.getText()), currentUID, 0, currentUID-1, elementList);
						addOutputText("Waypoint: " + (i+1) + "; Added as Element " + currentUID);
						currentUID++;
					}else{
						addOutputText("Waypoint:" + (i+1) + "; Not added");
					}
				}
				
				//ElementData encoded and placed into message
				seMsg.getBody().getSetElementSeq().setElementList(elementList);
				//Element List added to Message Body
				framework.StateMachine.sendJausMessage(seMsg, dest);
				SetLocalWaypoint tempForGUI = new SetLocalWaypoint();
				String containedWaypoint;
				//Send to Destination
				
				for(int i=0; i<seMsg.getBody().getSetElementSeq().getElementList().getNumberOfElements(); i++){
					tempForGUI.decode(seMsg.getBody().getSetElementSeq().getElementList().getElement(i).getElementData().getData(), 0);
					containedWaypoint = "("+threeDec.format(tempForGUI.getBody().getLocalWaypointRec().getX())+" , "+threeDec.format(tempForGUI.getBody().getLocalWaypointRec().getY())+")";
					addOutputText("Element" + (i+1) + ": " + containedWaypoint);
				}	
				
				addOutputText("SENT: SetElement Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
			}
		});
		GridBagConstraints gbc_btnSetelements = new GridBagConstraints();
		gbc_btnSetelements.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSetelements.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetelements.gridx = 0;
		gbc_btnSetelements.gridy = 0;
		panelListManager.add(btnSetelements, gbc_btnSetelements);
		
		btnQueryelementlist = new JButton("QueryElementList");
		btnQueryelementlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************QueryElementList
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryElementList qelMsg= new QueryElementList();
				//Instantiate Message
				framework.StateMachine.sendJausMessage(qelMsg, dest);
				//Send to Destination
				addOutputText("SENT: QueryElementList Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
		}});
		GridBagConstraints gbc_btnQueryelementlist = new GridBagConstraints();
		gbc_btnQueryelementlist.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQueryelementlist.gridwidth = 3;
		gbc_btnQueryelementlist.insets = new Insets(0, 0, 5, 5);
		gbc_btnQueryelementlist.gridx = 1;
		gbc_btnQueryelementlist.gridy = 0;
		panelListManager.add(btnQueryelementlist, gbc_btnQueryelementlist);
		
		btnQueryelementcount = new JButton("QueryElementCount");
		btnQueryelementcount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************Queryelementcount
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryElementCount qecMsg= new QueryElementCount();
				//Instantiate Message
				framework.StateMachine.sendJausMessage(qecMsg, dest);
				//Send to Destination
				addOutputText("SENT: Queryelementcount Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
		}});
		GridBagConstraints gbc_btnQueryelementcount = new GridBagConstraints();
		gbc_btnQueryelementcount.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQueryelementcount.insets = new Insets(0, 0, 0, 5);
		gbc_btnQueryelementcount.gridx = 0;
		gbc_btnQueryelementcount.gridy = 1;
		panelListManager.add(btnQueryelementcount, gbc_btnQueryelementcount);
		
		lblRequestid = new JLabel("RequestID:");
		GridBagConstraints gbc_lblRequestid = new GridBagConstraints();
		gbc_lblRequestid.insets = new Insets(0, 0, 0, 5);
		gbc_lblRequestid.gridx = 1;
		gbc_lblRequestid.gridy = 1;
		panelListManager.add(lblRequestid, gbc_lblRequestid);
		
		txtRequestID = new JTextField();
		txtRequestID.setText("01");
		txtRequestID.setHorizontalAlignment(SwingConstants.CENTER);
		txtRequestID.setColumns(3);
		GridBagConstraints gbc_txtRequestID = new GridBagConstraints();
		gbc_txtRequestID.insets = new Insets(0, 0, 0, 5);
		gbc_txtRequestID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRequestID.gridx = 2;
		gbc_txtRequestID.gridy = 1;
		panelListManager.add(txtRequestID, gbc_txtRequestID);
		
		panelLocalWaypointListDriver = new JPanel();
		panelLocalWaypointListDriver.setBorder(new TitledBorder(null, "LocalWaypointListDriver Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelLocalWaypointListDriver = new GridBagConstraints();
		gbc_panelLocalWaypointListDriver.fill = GridBagConstraints.BOTH;
		gbc_panelLocalWaypointListDriver.insets = new Insets(0, 0, 5, 5);
		gbc_panelLocalWaypointListDriver.gridx = 0;
		gbc_panelLocalWaypointListDriver.gridy = 7;
		contentPane.add(panelLocalWaypointListDriver, gbc_panelLocalWaypointListDriver);
		GridBagLayout gbl_panelLocalWaypointListDriver = new GridBagLayout();
		gbl_panelLocalWaypointListDriver.columnWidths = new int[]{150, 68, 63, 29, 0};
		gbl_panelLocalWaypointListDriver.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelLocalWaypointListDriver.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelLocalWaypointListDriver.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelLocalWaypointListDriver.setLayout(gbl_panelLocalWaypointListDriver);
		
		btnExecuteList = new JButton("ExecuteList");
		btnExecuteList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************btnExecuteList
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				ExecuteList elMsg= new ExecuteList();
				//Instantiate Message
				try{ 
				     Integer executeUID =  Integer.parseInt(textExecuteUID.getText());  
				     elMsg.getBody().getExecuteListRec().setElementUID(executeUID);
				}catch(Exception ie){  
					 
					//Nothing set speed only
				}
				//IF UID is specified fill, else assume only speed adjusment is wanted
				elMsg.getBody().getExecuteListRec().setSpeed(Double.parseDouble(textExecuteSpeed.getText()));
				framework.StateMachine.sendJausMessage(elMsg, dest);
				//Send to Destination
				addOutputText("SENT: ExecuteList Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+", Speed: "+textExecuteSpeed.getText()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
		}});
		GridBagConstraints gbc_btnExecuteList = new GridBagConstraints();
		gbc_btnExecuteList.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExecuteList.insets = new Insets(0, 0, 5, 5);
		gbc_btnExecuteList.gridx = 0;
		gbc_btnExecuteList.gridy = 0;
		panelLocalWaypointListDriver.add(btnExecuteList, gbc_btnExecuteList);
		
		lblSpeed = new JLabel("Speed (m/s):");
		GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
		gbc_lblSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpeed.gridx = 1;
		gbc_lblSpeed.gridy = 0;
		panelLocalWaypointListDriver.add(lblSpeed, gbc_lblSpeed);
		
		textExecuteSpeed = new JTextField();
		textExecuteSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		textExecuteSpeed.setText("0.00");
		GridBagConstraints gbc_textExecuteSpeed = new GridBagConstraints();
		gbc_textExecuteSpeed.fill = GridBagConstraints.HORIZONTAL;
		gbc_textExecuteSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_textExecuteSpeed.gridx = 2;
		gbc_textExecuteSpeed.gridy = 0;
		panelLocalWaypointListDriver.add(textExecuteSpeed, gbc_textExecuteSpeed);
		textExecuteSpeed.setColumns(3);
		
		textExecuteUID = new JTextField();
		textExecuteUID.setText("1");
		textExecuteUID.setHorizontalAlignment(SwingConstants.CENTER);
		textExecuteUID.setColumns(3);
		GridBagConstraints gbc_textExecuteUID = new GridBagConstraints();
		gbc_textExecuteUID.insets = new Insets(0, 0, 5, 0);
		gbc_textExecuteUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textExecuteUID.gridx = 3;
		gbc_textExecuteUID.gridy = 0;
		panelLocalWaypointListDriver.add(textExecuteUID, gbc_textExecuteUID);
		
		btnQueryactiveelement = new JButton("QueryActiveElement");
		btnQueryactiveelement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************Querytravelspeed
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryActiveElement qaeMsg= new QueryActiveElement();
				//Instantiate Message
				framework.StateMachine.sendJausMessage(qaeMsg, dest);
				//Send to Destination
				addOutputText("SENT: QueryActiveElement Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
		}});
		GridBagConstraints gbc_btnQueryactiveelement = new GridBagConstraints();
		gbc_btnQueryactiveelement.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQueryactiveelement.insets = new Insets(0, 0, 5, 5);
		gbc_btnQueryactiveelement.gridx = 0;
		gbc_btnQueryactiveelement.gridy = 1;
		panelLocalWaypointListDriver.add(btnQueryactiveelement, gbc_btnQueryactiveelement);
		
		textQueryActiveElement = new JTextField();
		textQueryActiveElement.setEditable(false);
		GridBagConstraints gbc_textQueryActiveElement = new GridBagConstraints();
		gbc_textQueryActiveElement.insets = new Insets(0, 0, 5, 5);
		gbc_textQueryActiveElement.fill = GridBagConstraints.HORIZONTAL;
		gbc_textQueryActiveElement.gridx = 1;
		gbc_textQueryActiveElement.gridy = 1;
		panelLocalWaypointListDriver.add(textQueryActiveElement, gbc_textQueryActiveElement);
		textQueryActiveElement.setColumns(5);
		
		btnQuerytravelspeed = new JButton("QueryTravelSpeed");
		btnQuerytravelspeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************Querytravelspeed
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryTravelSpeed qtsMsg= new QueryTravelSpeed();
				//Instantiate Message
				framework.StateMachine.sendJausMessage(qtsMsg, dest);
				//Send to Destination
				addOutputText("SENT: Querytravelspeed Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
		}});
		
		lblUid = new JLabel("UID (iff #)^");
		GridBagConstraints gbc_lblUid = new GridBagConstraints();
		gbc_lblUid.gridwidth = 2;
		gbc_lblUid.insets = new Insets(0, 0, 5, 0);
		gbc_lblUid.gridx = 2;
		gbc_lblUid.gridy = 1;
		panelLocalWaypointListDriver.add(lblUid, gbc_lblUid);
		GridBagConstraints gbc_btnQuerytravelspeed = new GridBagConstraints();
		gbc_btnQuerytravelspeed.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuerytravelspeed.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuerytravelspeed.gridx = 0;
		gbc_btnQuerytravelspeed.gridy = 2;
		panelLocalWaypointListDriver.add(btnQuerytravelspeed, gbc_btnQuerytravelspeed);
		
		textQueryTravelSpeed = new JTextField();
		textQueryTravelSpeed.setEditable(false);
		GridBagConstraints gbc_textQueryTravelSpeed = new GridBagConstraints();
		gbc_textQueryTravelSpeed.gridwidth = 2;
		gbc_textQueryTravelSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_textQueryTravelSpeed.fill = GridBagConstraints.HORIZONTAL;
		gbc_textQueryTravelSpeed.gridx = 1;
		gbc_textQueryTravelSpeed.gridy = 2;
		panelLocalWaypointListDriver.add(textQueryTravelSpeed, gbc_textQueryTravelSpeed);
		textQueryTravelSpeed.setColumns(5);
		
		btnQuerylocalwaypoint = new JButton("QueryLocalWaypoint");
		btnQuerylocalwaypoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//*********************************************************************QueryLocalWaypoint
				JausAddress dest = new JausAddress(Integer.parseInt(textDestSubSystem.getText()), Short.parseShort(textDestNode.getText()), Short.parseShort(textDestComp.getText()));
				//Set Destination ID based off of GUI
				QueryLocalWaypoint qlwMsg= new QueryLocalWaypoint();
				//Instantiate Message
				framework.StateMachine.sendJausMessage(qlwMsg, dest);
				//Send to Destination
				addOutputText("SENT: QueryLocalWaypoint Message (Dest: "+ dest.getSubsystemID() + "." + dest.getNodeID()+"."+dest.getComponentID()+")");
				//Print notification to GUI
				src.urn_TestCOPServiceDef_1_0.TestCOPServiceDef_ReceiveFSM.lastMsgID = null;
		}});
		
		lblms = new JLabel("(m/s)");
		GridBagConstraints gbc_lblms = new GridBagConstraints();
		gbc_lblms.anchor = GridBagConstraints.WEST;
		gbc_lblms.insets = new Insets(0, 0, 5, 0);
		gbc_lblms.gridx = 3;
		gbc_lblms.gridy = 2;
		panelLocalWaypointListDriver.add(lblms, gbc_lblms);
		GridBagConstraints gbc_btnQuerylocalwaypoint = new GridBagConstraints();
		gbc_btnQuerylocalwaypoint.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuerylocalwaypoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuerylocalwaypoint.gridx = 0;
		gbc_btnQuerylocalwaypoint.gridy = 3;
		panelLocalWaypointListDriver.add(btnQuerylocalwaypoint, gbc_btnQuerylocalwaypoint);
		
		textQueryLocalWaypoint = new JTextField();
		textQueryLocalWaypoint.setEditable(false);
		GridBagConstraints gbc_textQueryLocalWaypoint = new GridBagConstraints();
		gbc_textQueryLocalWaypoint.gridwidth = 3;
		gbc_textQueryLocalWaypoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_textQueryLocalWaypoint.gridx = 1;
		gbc_textQueryLocalWaypoint.gridy = 3;
		panelLocalWaypointListDriver.add(textQueryLocalWaypoint, gbc_textQueryLocalWaypoint);
		textQueryLocalWaypoint.setColumns(5);
		
		btnClearoutputpane = new JButton("ClearOutputPane");
		GridBagConstraints gbc_btnClearoutputpane = new GridBagConstraints();
		gbc_btnClearoutputpane.insets = new Insets(0, 0, 5, 5);
		gbc_btnClearoutputpane.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClearoutputpane.gridx = 1;
		gbc_btnClearoutputpane.gridy = 9;
		contentPane.add(btnClearoutputpane, gbc_btnClearoutputpane);
		btnClearoutputpane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOutputPane.setText(" ");
			}
		});
		
	}
	public static void setLED(JLabel led, String state) {
		if(state.equals("gray")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JTS/JAUS_ICONS/GrayLED.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); }
		else if(state.equals("greenOFF")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JTS/JAUS_ICONS/GreenLED_OFF.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); }
		else if(state.equals("greenON")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JTS/JAUS_ICONS/GreenLED_ON.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); }
		else if(state.equals("redOFF")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JTS/JAUS_ICONS/RedLED_OFF.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  }
		else if(state.equals("redON")){ led.setIcon(new ImageIcon(((new ImageIcon("C:/JTS/JAUS_ICONS/RedLED_ON.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  }
		else{ addOutputText("Attempting to set LED to to" + "'" + state + "'; Not a Valid state"); }
	}
	
	public static void addOutputText(String string) {
			textOutputPane.setText(textOutputPane.getText() + "\n" + string);
	}
	public static void addWaypointToList(Double x, Double y,  Integer elementUID, Integer nextUID, Integer prevUID, ElementList elementList){
		long bufsize; 
		ByteBuffer buffer;
		int pos;
		
		//Fill RequestID field in Body
		//Element List created to store ElementRecs
		ElementRec element = new ElementRec();
		//ElementRecords
		SetLocalWaypoint setLocalWaypoint = new SetLocalWaypoint();
		//Element Data will be SetLocalWaypoint message payload
		element.setElementUID(elementUID);
		element.setPreviousUID(prevUID);
		element.setNextUID(nextUID);
		setLocalWaypoint.getBody().getLocalWaypointRec().setX(x);
		setLocalWaypoint.getBody().getLocalWaypointRec().setY(y);
		//Element added
		ElementData elementData = new ElementData();
		//Instantiate byteBuffer
		bufsize = setLocalWaypoint.getSize();
		buffer = ByteBuffer.allocate((int) bufsize);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.clear();
		pos = 0; 
		setLocalWaypoint.encode(buffer, pos);
		elementData.set((short)0, buffer.array().length, buffer);
		element.setElementData(elementData);
		elementList.addElement(element);
		//Encode and add element data
	}

}
