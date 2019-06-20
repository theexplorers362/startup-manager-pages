/**
 * 
 * Class that contains UI elements and methods that directly interact with UI
 *
 */


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class Scheduler {

	private JFrame frmFlysRUs;
	JLabel lblPin;
	private static JPanel pneManagerArea;
	static Vector<Customer> customerContainer;
	private static JLabel lblManagerGreeting;
	private static JLabel lblDate;
	private static JComboBox<String> cmboManager;
	String managerPin = "10077";
	private static JTable tblReport;
	
	private static Map<String, Manager> managerContainer;
	
	String manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		//managers
		Manager felicia = new Manager("Felicia Aubert", "12345");
		Manager mario = new Manager("Mario Zarco", "12345");
		Manager pia = new Manager("Pia Wetzel", "12345");
		
		managerContainer = new HashMap<>();
		managerContainer.put(felicia.getName(), felicia);
		managerContainer.put(mario.getName(), mario);
		managerContainer.put(pia.getName(), pia);
		
		
		SQLConnectionManager connectionManager = new SQLConnectionManager();
		customerContainer = connectionManager.connectToDatabase();
		
	//	generateReport(customers);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scheduler window = new Scheduler();
					window.frmFlysRUs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Scheduler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlysRUs = new JFrame();
		frmFlysRUs.setFont(new Font("Arial", Font.PLAIN, 16));
		frmFlysRUs.setResizable(false);
		frmFlysRUs.setTitle("Fly's R US Airplane Scheduler");
		frmFlysRUs.setBounds(100, 100, 1200, 800);
		frmFlysRUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFlysRUs.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(83, 97, 1014, 618);
		frmFlysRUs.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel pneHome = new JPanel();
		layeredPane.add(pneHome, "name_1318973362793417");
		pneHome.setLayout(null);
		
		JPanel pnePinPad = new JPanel();
		pnePinPad.setLayout(null);
		pnePinPad.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		layeredPane.add(pnePinPad, "name_1934798070645031");
		
		JLabel lblManagerArea = new JLabel("Manager Area");
		lblManagerArea.setFont(new Font("Arial", Font.PLAIN, 25));
		lblManagerArea.setBounds(92, 11, 563, 47);
		pnePinPad.add(lblManagerArea);
		
		JButton buttonPinBack = new JButton("Back");
		buttonPinBack.setBackground(Color.WHITE);
		buttonPinBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPin.setText("");
				cmboManager.setSelectedIndex(0);
				pnePinPad.setVisible(false);
				pneHome.setVisible(true);
			}
		});
		buttonPinBack.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonPinBack.setBounds(774, 11, 230, 90);
		pnePinPad.add(buttonPinBack);
		
		JButton buttonPin1 = new JButton("1");
		buttonPin1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				addInputPin(buttonPin1.getText());
			}
		});
		buttonPin1.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin1.setBounds(344, 269, 65, 65);
		pnePinPad.add(buttonPin1);
		
		JButton buttonPin2 = new JButton("2");
		buttonPin2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				addInputPin(buttonPin2.getText());
			}
		});
		buttonPin2.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin2.setBounds(437, 269, 65, 65);
		pnePinPad.add(buttonPin2);
		
		JButton buttonPin3 = new JButton("3");
		buttonPin3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addInputPin(buttonPin3.getText());
			}
		});
		buttonPin3.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin3.setBounds(529, 269, 65, 65);
		pnePinPad.add(buttonPin3);
		
		JButton buttonPin4 = new JButton("4");
		buttonPin4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				addInputPin(buttonPin4.getText());
			}
		});
		buttonPin4.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin4.setBounds(344, 358, 65, 65);
		pnePinPad.add(buttonPin4);
		
		JButton buttonPin5 = new JButton("5");
		buttonPin5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addInputPin(buttonPin5.getText());
			}
		});
		buttonPin5.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin5.setBounds(437, 358, 65, 65);
		pnePinPad.add(buttonPin5);
		
		JButton buttonPin6 = new JButton("6");
		buttonPin6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addInputPin(buttonPin6.getText());
			}
		});
		buttonPin6.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin6.setBounds(529, 358, 65, 65);
		pnePinPad.add(buttonPin6);
		
		JButton buttonPin7 = new JButton("7");
		buttonPin7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addInputPin(buttonPin7.getText());
			}
		});
		buttonPin7.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin7.setBounds(344, 447, 65, 65);
		pnePinPad.add(buttonPin7);
		
		JButton buttonPin8 = new JButton("8");
		buttonPin8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addInputPin(buttonPin8.getText());
			}
		});
		buttonPin8.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin8.setBounds(437, 447, 65, 65);
		pnePinPad.add(buttonPin8);
		
		JButton buttonPin9 = new JButton("9");
		buttonPin9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addInputPin(buttonPin9.getText());
			}
		});
		buttonPin9.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin9.setBounds(529, 447, 65, 65);
		pnePinPad.add(buttonPin9);
		
		JButton buttonPin0 = new JButton("0");
		buttonPin0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addInputPin(buttonPin0.getText());
			}
		});
		buttonPin0.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonPin0.setBounds(344, 531, 65, 65);
		pnePinPad.add(buttonPin0);
		
		JButton btnPinDelete = new JButton("Delete");
		btnPinDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String pin = lblPin.getText();
				
				//if some number was entered, delete last value
				if(pin.length() > 0)
				{
					pin = pin.substring(0, pin.length() - 1);
					lblPin.setText(pin);
				}
				
				
			}
		});
		btnPinDelete.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPinDelete.setBounds(437, 531, 157, 65);
		pnePinPad.add(btnPinDelete);
		
		JButton btnPinEnter = new JButton("Enter");
		btnPinEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				//get the selected manager
				String selectedManager = cmboManager.getSelectedItem().toString();
				Manager manager = managerContainer.get(selectedManager);
				
				System.out.println("MAnager: " + selectedManager);
				
				//if manager selection is valid...
				if(manager != null)
				{
				String enteredPin = lblPin.getText();
				//compare entered pin to actual pin and grant access if they match
					if(manager.verifyPin(enteredPin))
					{
						
						pneManagerArea.setVisible(true);
						pnePinPad.setVisible(false);
						
						lblManagerGreeting.setText("Welcome, " + manager.getName());
						generateReport(customerContainer);
					}
					else
					{
						JOptionPane.showMessageDialog(frmFlysRUs,"Please try again", "Wrong Password for selected Manager", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(frmFlysRUs,"Please try again", "No Manager selected", JOptionPane.INFORMATION_MESSAGE);
				}
				
				lblPin.setText("");
				cmboManager.setSelectedIndex(0);
			}
		});
		btnPinEnter.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPinEnter.setBounds(622, 269, 78, 325);
		pnePinPad.add(btnPinEnter);
		
		lblPin = new JLabel("");
		lblPin.setBackground(Color.WHITE);
		lblPin.setFont(new Font("Arial", Font.PLAIN, 28));
		lblPin.setBounds(351, 196, 350, 50);
		pnePinPad.add(lblPin);
		
		JLabel lblSelectManager = new JLabel("Select Manager:");
		lblSelectManager.setFont(new Font("Arial", Font.PLAIN, 22));
		lblSelectManager.setBounds(92, 107, 167, 47);
		pnePinPad.add(lblSelectManager);
		
		cmboManager = new JComboBox();
		cmboManager.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmboManager.setModel(new DefaultComboBoxModel(new String[] {"", "Felicia Aubert", "Mario Zarco", "Pia Wetzel"}));
		cmboManager.setBounds(305, 115, 197, 39);
		
		pnePinPad.add(cmboManager);
		
		
		//Border properties
		Border borderTextField = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		
		
		
		JButton btnNewButton = new JButton("View existing Reservation");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewButton.setBounds(259, 500, 472, 91);
		pneHome.add(btnNewButton);
		
		
		JButton btnNewReservation = new JButton("New Reservation");
	
		btnNewReservation.setBackground(Color.WHITE);
		btnNewReservation.setFont(new Font("Arial", Font.PLAIN, 25));
		btnNewReservation.setBounds(259, 398, 472, 91);
		pneHome.add(btnNewReservation);
		
		JButton btnManagerAccess = new JButton("Manager Access");
		btnManagerAccess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnePinPad.setVisible(true);
				pneHome.setVisible(false);
			}
		});
		btnManagerAccess.setFont(new Font("Arial", Font.PLAIN, 25));
		btnManagerAccess.setBackground(Color.WHITE);
		btnManagerAccess.setBounds(775, 11, 230, 90);
		pneHome.add(btnManagerAccess);
		
		pneManagerArea = new JPanel();
		pneManagerArea.setLayout(null);
		pneManagerArea.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		layeredPane.add(pneManagerArea, "name_1938072566703303");
		
		lblManagerGreeting = new JLabel("Welcome, Manager");
		lblManagerGreeting.setFont(new Font("Arial", Font.PLAIN, 25));
		lblManagerGreeting.setBounds(92, 0, 563, 47);
		pneManagerArea.add(lblManagerGreeting);
		
		JButton buttonManagerAreaLogOut = new JButton("Log Out");
		buttonManagerAreaLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				pneManagerArea.setVisible(false);
				pneHome.setVisible(true);
			}
		});
		buttonManagerAreaLogOut.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonManagerAreaLogOut.setBackground(Color.WHITE);
		buttonManagerAreaLogOut.setBounds(774, 11, 230, 90);
		pneManagerArea.add(buttonManagerAreaLogOut);
		
		lblDate = new JLabel("Table Header");
		lblDate.setFont(new Font("Arial", Font.BOLD, 20));
		lblDate.setBounds(241, 75, 523, 47);
		pneManagerArea.add(lblDate);
		
	
		
	
		
	}
	
	
	//makes the entered pin visible in text field
	public void addInputPin(String someValue)
	{
		
		String pin = lblPin.getText();
		pin = pin + someValue;
		lblPin.setText(pin);
	
		
	}
	
	
	//Method generates report for managers
	public static void generateReport(Vector<Customer> someVector)
	{
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 994, 495);
		pneManagerArea.add(scrollPane);
		
		tblReport = new JTable();
		tblReport.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null, null},
			},
			new String[] {
				"Passenger", "Confirmation Number", "Destination", "Seat Number", "Meal ", "Departure ", "Arrival", "Luggage"
			}
		));
		
		
		DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
	
		Iterator<Customer> iter = someVector.iterator();

	
		while(iter.hasNext())
		{
		
			Customer customer = (Customer) iter.next();
			
			model.addRow(new Object[]{customer.getName(), customer.getConfirmationNumber(), customer.getDestination(), customer.getSeat(), customer.getBreakfast(), 
						customer.getDepartureTime(), customer.getArrivalTime(), customer.getLuggage()});
	
		}
		scrollPane.setViewportView(tblReport);
		DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy");
		Date date = new Date();
		
		lblDate.setText("Flys Are Us Passengers for " + dateFormat.format(date));
		
		
	}
}
