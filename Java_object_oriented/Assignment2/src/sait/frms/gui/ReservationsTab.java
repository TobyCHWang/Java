package sait.frms.gui;
/**
 * This class is for reservation tab class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sait.frms.exception.InvalidCitizenshipException;
import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

/**
 * Holds the components for the reservations tab.
 * 
 */
public class ReservationsTab extends TabBase {
	/**
	 * Instance of reservation manager.
	 */
	private ReservationManager reservationManager;

	private DefaultListModel<Reservation> reserveModel;

	private JList<Reservation> reservationsList;
	private JPanel panelEast;
	private JPanel panelBottom;
	private JLabel codeLabel;
	private JLabel flightLabel;
	private JLabel airlineLabel;
	private JLabel costLabel;
	private JLabel nameLabel;
	private JLabel titleMessageUpadateJLabel;
	private JLabel titleMessageSearchJLabel;
	private JLabel citizenshipLabel;
	private JLabel statusLabel;
	private JLabel codeSearchLabel;
	private JLabel airlineSearchLabel;
	private JLabel nameSearchLabel;
	private JTextField codeField;
	private JTextField flightField;
	private JTextField airlineField;
	private JTextField codeSearchField;
	private JTextField airlineSearchField;
	private JTextField nameSearchField;
	private JTextField costField;
	private JTextField nameField;
	private JTextField citizenshipField;
	private JComboBox statuBox;
	private String[] status = { "Active", "Inactive" };
	private static final String BINARY_FILE = "res/reservations.bin";

	/**
	 * Creates the components for reservations tab.
	 * @throws IOException 
	 */
	public ReservationsTab(ReservationManager reservationManager) throws IOException {
		this.reservationManager = reservationManager;
		panel.setLayout(new BorderLayout());

		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		JPanel centerPanel = createCenterPanel();
		centerPanel.setSize(new Dimension(300, 300));
		centerPanel.setBorder(new EmptyBorder(10, 20, 40, 10));
		panel.add(centerPanel, BorderLayout.CENTER);

		bulidUpdatePanel();
		bulidSearchPanel();
		panel.add(panelEast, BorderLayout.EAST);
		panel.add(panelBottom, BorderLayout.SOUTH);

	}
	
	/**
	 * Creates the center panel.
	 * 
	 * @return JPanel that goes in center.
	 */

	private JPanel createCenterPanel() throws IOException {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());
		reserveModel = new DefaultListModel<>();
		reservationsList = new JList<>(reserveModel);

		// User can only select one item at a time.
		reservationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.reservationsList);

		reservationsList.addListSelectionListener(new MyListSelectionListener());

		panel.add(scrollPane);

		return panel;
	}
	
	/**
	 * select to find out and show value
	 * 
	 * 
	 */

	private class MyListSelectionListener implements ListSelectionListener {
		/**
		 * Called when user selects an item in the JList.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if (e.getValueIsAdjusting() == false) {
				if (reservationsList.getSelectedIndex() != -1) {
			Reservation listValueReservation=reservationsList.getSelectedValue();
			String reservationCodeString=listValueReservation.getCode();
			codeField.setText(reservationCodeString);
			String flightCodeString=listValueReservation.getFlightcode();
			flightField.setText(flightCodeString);
			//airline not read
			String airlineString=listValueReservation.getFlightcode();
			String twoCharacterString=airlineString.substring(0, 2);
			if(twoCharacterString.equals("OA")){
				airlineField.setText("Otto Airlines");
			}
			if(twoCharacterString.equals("CA")){
				airlineField.setText("Conned Air");
			}
			if(twoCharacterString.equals("TB")){
				airlineField.setText("Try a Bus Airways");
			}
			if(twoCharacterString.equals("VA")){
				airlineField.setText("Vertical Airways");
			}
			
			double cost=listValueReservation.getCost();
			String costString=String.valueOf(cost);
			costField.setText(costString);
			String nameString=listValueReservation.getName();
			nameField.setText(nameString);
			String citizenshipString=listValueReservation.getCitizenship();
			citizenshipField.setText(citizenshipString);
			//active not read
			Boolean isBoolean=listValueReservation.isActive();
			if (!isBoolean) {
				statuBox.setSelectedItem("Inactive");
			}else {
				statuBox.setSelectedItem("Active");
			}
				}
				}
		}

	}

	/**
	 * Creates the south panel.
	 * 
	 * @return JPanel that goes in south.
	 */
	private void bulidSearchPanel() {
		// TODO Auto-generated method stub
		panelBottom = new JPanel();
		panelBottom.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		titleMessageSearchJLabel = new JLabel("Search", SwingConstants.CENTER);
		titleMessageSearchJLabel.setFont(new Font("serif", Font.PLAIN, 25));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		panelBottom.add(titleMessageSearchJLabel, gbc);

		codeSearchLabel = new JLabel("Code:",SwingConstants.RIGHT);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth=1;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.insets = new Insets(0, 1, 0, 0);
		panelBottom.add(codeSearchLabel, gbc);

		codeSearchField = new JTextField(60);
		gbc.gridx = 1;
		codeSearchField.addActionListener(new FindReservationListener());
		panelBottom.add(codeSearchField, gbc);

		airlineSearchLabel = new JLabel("Airline:",SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelBottom.add(airlineSearchLabel, gbc);

		airlineSearchField = new JTextField(60);
		gbc.gridx = 1;
		airlineSearchField.addActionListener(new FindReservationListener());
		panelBottom.add(airlineSearchField, gbc);

		nameSearchLabel = new JLabel("Name:",SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelBottom.add(nameSearchLabel, gbc);

		nameSearchField = new JTextField(60);
		gbc.gridx = 1;
		nameSearchField.addActionListener(new FindReservationListener());
		panelBottom.add(nameSearchField, gbc);

		JButton buttonFindReservation = new JButton("Find Reservations");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelBottom.add(buttonFindReservation, gbc);
		buttonFindReservation.addActionListener(new FindReservationListener());

	}
	
	/**
	 * Creates the east panel.
	 * 
	 * @return JPanel that goes in east.
	 */
	
	private void bulidUpdatePanel() {
		// TODO Auto-generated method stub
		panelEast = new JPanel();
		panelEast.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		titleMessageUpadateJLabel = new JLabel("Reserve", SwingConstants.CENTER);
		titleMessageUpadateJLabel.setFont(new Font("serif", Font.PLAIN, 25));
		titleMessageUpadateJLabel.setBorder(new EmptyBorder(30, 30, 30, 30));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelEast.add(titleMessageUpadateJLabel, gbc);

		codeLabel = new JLabel("Code:",SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelEast.add(codeLabel, gbc);

		codeField = new JTextField(20);
		codeField.setEditable(false);
		gbc.gridx = 1;
		codeField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		codeField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(codeField, gbc);

		flightLabel = new JLabel("Flight:",SwingConstants.RIGHT);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelEast.add(flightLabel, gbc);

		flightField = new JTextField(20);
		flightField.setEditable(false);
		gbc.gridx = 1;
		flightField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		flightField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(flightField, gbc);

		airlineLabel = new JLabel("Airline:",SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelEast.add(airlineLabel, gbc);

		airlineField = new JTextField(20);
		airlineField.setEditable(false);
		gbc.gridx = 1;
		airlineField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		airlineField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(airlineField, gbc);

		costLabel = new JLabel("Cost:",SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelEast.add(costLabel, gbc);

		costField = new JTextField(20);
		costField.setEditable(false);
		gbc.gridx = 1;
		costField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		costField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(costField, gbc);

		nameLabel = new JLabel("Name:",SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panelEast.add(nameLabel, gbc);

		nameField = new JTextField(20);
		gbc.gridx = 1;
		panelEast.add(nameField, gbc);

		citizenshipLabel = new JLabel("Citizenship:",SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panelEast.add(citizenshipLabel, gbc);

		citizenshipField = new JTextField(20);
		gbc.gridx = 1;
		panelEast.add(citizenshipField, gbc);

		statusLabel = new JLabel("Status:",SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 7;
		panelEast.add(statusLabel, gbc);

		statuBox = new JComboBox(status);
		gbc.gridx = 1;
		panelEast.add(statuBox, gbc);

		JButton buttonUpdateButton = new JButton("Updated");
		buttonUpdateButton.addActionListener(new UpdateInformation());
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.insets = new Insets(30, 0, 0, 0);
		panelEast.add(buttonUpdateButton, gbc);
		

	}
	

	/**
	 * Creates the north panel.
	 * 
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() {
		JPanel panel = new JPanel();

		JLabel title = new JLabel("Reservations", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		panel.add(title);

		return panel;
	}
	private class FindReservationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String codeString=	codeSearchField.getText();
			String airlineString=airlineSearchField.getText();
			String nameString=nameSearchField.getText();
			try {
				reservationsList.removeAll();
				reserveModel.removeAllElements();
				ReservationManager findReservationManager=new ReservationManager();
				ArrayList<Reservation> findreseReservations=findReservationManager.findReservations(codeString, airlineString, nameString);
				for(int i=0;i<findreseReservations.size();i++) {
					String codeStringSearch=findreseReservations.get(i).getCode();
					Reservation aReservation=findReservationManager.findReservationByCode(codeStringSearch);
					reserveModel.addElement(aReservation);
					
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			codeSearchField.setText("");
			airlineSearchField.setText("");
			nameSearchField.setText("");
		}
}
	
	/**
	 * Creates the east panel.
	 * 
	 * 
	 */
	private class UpdateInformation implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Reservation listValueRerservation=reservationsList.getSelectedValue();
			String reservationCodeString=listValueRerservation.getCode();
			String flightCodeString=listValueRerservation.getFlightcode();
			String airlineString=listValueRerservation.getFlightcode();
			String twoCharacterString=airlineString.substring(0, 2);
			if(twoCharacterString.equals("OA")){
				airlineString="Otto Airlines";
			}
			if(twoCharacterString.equals("CA")){
				airlineString="Conned Air";
			}
			if(twoCharacterString.equals("TB")){
				airlineString="Try a Bus Airways";
			}
			if(twoCharacterString.equals("VA")){
				airlineString="Vertical Airways";
			}
			double cost=listValueRerservation.getCost();
			String costString=String.valueOf(cost);
			
			boolean active=listValueRerservation.isActive();
			String statuString=(String) statuBox.getSelectedItem();
			
			String updateCitizenship=citizenshipField.getText();
			String updateName=nameField.getText();
			if(updateCitizenship == null || updateCitizenship.isEmpty()||updateName == null || updateName.isEmpty()) {
				System.out.println("Error");
				return;
			}
			Reservation aReservation=new Reservation(reservationCodeString,flightCodeString,airlineString,updateName,updateCitizenship,cost,active);
			if(statuString.equalsIgnoreCase("Inactive")) {
				active=false;
				try {
					FlightManager aFlightManager=new FlightManager();
					System.out.println(flightCodeString);
					Flight aFlight=aFlightManager.findFlightByCode(flightCodeString);
					int a=aFlight.getSeats()+1;
					//flight seat
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
			try {
				FileOutputStream test = new FileOutputStream(BINARY_FILE,true);
				DataOutputStream outputStream = new DataOutputStream(test);
				String reservationCode = String.format("%-7s", reservationCodeString);
				outputStream.writeUTF(reservationCode);
				// 7bytes + 2bytes = 9bytes
				String flightCode = String.format("%-7s", flightCodeString);
				outputStream.writeUTF(flightCode);
				// 2bytes + 2bytes = 4bytes
				String reserveAirline = String.format("%-2s",airlineString);
				outputStream.writeUTF(reserveAirline);
				// 50bytes + 2bytes = 52bytes name
				String reserveName = String.format("%-50s", updateName);
				outputStream.writeUTF(reserveName);
				// 50bytes + 2bytes = 52bytes
				String reserveCitizenship = String.format("%-50s", updateCitizenship);
				outputStream.writeUTF(reserveCitizenship);
				// 8 bytes
				outputStream.writeDouble(cost);
				// 1 byte
				outputStream.writeBoolean(active);
				outputStream.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		}
	}

