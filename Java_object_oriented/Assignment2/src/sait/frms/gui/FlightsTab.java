package sait.frms.gui;
/**
 * This class is for flight tab class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

/**
 * Holds the components for the flights tab.
 * 
 */
public class FlightsTab extends TabBase {
	/**
	 * Instance of flight manager.
	 */
	private FlightManager flightManager;

	/**
	 * Instance of reservation manager.
	 */
	private ReservationManager reservationManager;

	/**
	 * List of flights.
	 */
	private JList<Flight> flightsList;

	private DefaultListModel<Flight> flightsModel;
	private JPanel panelEast;
	private JPanel panelBottom;
	private JLabel flightMessageLabel;
	private JLabel airlineLabel;
	private JLabel dayLabel;
	private JLabel timeLabel;
	private JLabel costLabel;
	private JLabel nameLabel;
	private JLabel citizenshipLabel;
	private JLabel titleMessageJLabel;
	private JLabel titleMessageJLabelFind;
	private JLabel fromLabel;
	private JLabel toLabel;
	private JLabel dayDropJLabel;
	private JTextField flightField;
	private JTextField airlineField;
	private JTextField dayField;
	private JTextField timeField;
	private JTextField costField;
	private JTextField nameField;
	private JTextField citizenshipField;
	private JComboBox fromBox;
	private JComboBox toBox;
	private JComboBox dayBox;
	private String fromselection;
	private String toselection;
	private String dayselection;
	

	private String[] fromPlace = { "YYC","YEG","YUL","YOW","YYZ","YVR","YWG","ATL","PEK","DXB","HKG","LHR","HND","ORD","PVG","CDG","AMS","DEL","FRA","DFW"};

	private String[] toPlace = { "YYC","YEG","YUL","YOW","YYZ","YVR","YWG","ATL","PEK","DXB","HKG","LHR","HND","ORD","PVG","CDG","AMS","DEL","FRA","DFW" };

	private String[] day = { "Any","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};

	/**
	 * Creates the components for flights tab.
	 */
	/**
	 * Creates the components for flights tab.
	 * 
	 * @param flightManager      Instance of FlightManager.
	 * @param reservationManager Instance of ReservationManager
	 */
	public FlightsTab(FlightManager flightManager, ReservationManager reservationManager) {
		this.flightManager = flightManager;
		this.reservationManager = reservationManager;
		
		panel.setLayout(new BorderLayout());

		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = createCenterPanel();
		centerPanel.setSize(new Dimension(400, 300));
		centerPanel.setBorder(new EmptyBorder(0, 10, 40, 20));
		panel.add(centerPanel, BorderLayout.CENTER);

		buildSelectedPanel();
		buildReservedPanel();
		panel.add(panelEast, BorderLayout.EAST);

		// panel.add(panelBottom, BorderLayout.SOUTH);
		panel.add(panelBottom, BorderLayout.SOUTH);

	}
	
	/**
	 * Creates the south panel.
	 * 
	 * @return JPanel that goes in south.
	 */

	private void buildSelectedPanel() {
		panelBottom = new JPanel();
		panelBottom.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		titleMessageJLabelFind = new JLabel("Flight Finder", SwingConstants.CENTER);
		titleMessageJLabelFind.setFont(new Font("serif", Font.PLAIN, 29));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		panelBottom.add(titleMessageJLabelFind, gbc);

		fromLabel = new JLabel("From:", SwingConstants.RIGHT);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth=1;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.insets = new Insets(0, 1, 0, 0);
		panelBottom.add(fromLabel, gbc);

		fromBox = new JComboBox(fromPlace);
		fromBox.setPreferredSize(new Dimension(640, 20));
		gbc.gridx = 1;
		fromBox.addActionListener(new ComboBoxListener());
		panelBottom.add(fromBox, gbc);

		toLabel = new JLabel("To:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelBottom.add(toLabel, gbc);

		toBox = new JComboBox(toPlace);
		toBox.addActionListener(new ComboBoxListener());
		gbc.gridx = 1;
		/*toBox.addActionListener(new ComboBoxListener());*/
		panelBottom.add(toBox, gbc);

		dayLabel = new JLabel("Day:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelBottom.add(dayLabel, gbc);

		dayBox = new JComboBox(day);
		dayBox.addActionListener(new ComboBoxListener());
		gbc.gridx = 1;
		/*dayBox.addActionListener(new ComboBoxListener());*/
		panelBottom.add(dayBox, gbc);

		JButton buttonFindFlight = new JButton("Find Flights");
		buttonFindFlight.addActionListener(new FlightButtonListener());
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelBottom.add(buttonFindFlight, gbc);

	}
	
	/**
	 * Creates the east panel.
	 * 
	 * @return JPanel that goes in east.
	 */

	private void buildReservedPanel() {

		panelEast = new JPanel();
		panelEast.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		titleMessageJLabel = new JLabel("Reserve", SwingConstants.CENTER);
		titleMessageJLabel.setFont(new Font("serif", Font.PLAIN, 29));
		titleMessageJLabel.setBorder(new EmptyBorder(30, 30, 30, 30));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelEast.add(titleMessageJLabel, gbc);

		flightMessageLabel = new JLabel("Flight:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelEast.add(flightMessageLabel, gbc);

		flightField = new JTextField(20);
		flightField.setEditable(false);
		gbc.gridx = 1;
		flightField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		flightField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(flightField, gbc);

		airlineLabel = new JLabel("Airline:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelEast.add(airlineLabel, gbc);

		airlineField = new JTextField(20);
		airlineField.setEditable(false);
		gbc.gridx = 1;
		airlineField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		airlineField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(airlineField, gbc);

		dayLabel = new JLabel("Day:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelEast.add(dayLabel, gbc);

		dayField = new JTextField(20);
		dayField.setEditable(false);
		gbc.gridx = 1;
		dayField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		dayField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(dayField, gbc);

		timeLabel = new JLabel("Time:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelEast.add(timeLabel, gbc);

		timeField = new JTextField(20);
		timeField.setEditable(false);
		gbc.gridx = 1;
		timeField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		timeField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(timeField, gbc);

		costLabel = new JLabel("Cost:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panelEast.add(costLabel, gbc);

		costField = new JTextField(20);
		costField.setEditable(false);
		gbc.gridx = 1;
		costField.setBackground(UIManager.getColor("TextField.inactiveBackground")); 
		costField.setBorder(new LineBorder(Color.cyan,1));
		panelEast.add(costField, gbc);

		nameLabel = new JLabel("Name:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panelEast.add(nameLabel, gbc);

		nameField = new JTextField(20);
		gbc.gridx = 1;
		panelEast.add(nameField, gbc);

		citizenshipLabel = new JLabel("Citizenship:", SwingConstants.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 7;
		panelEast.add(citizenshipLabel, gbc);

		citizenshipField = new JTextField(20);
		gbc.gridx = 1;
		panelEast.add(citizenshipField, gbc);

		JButton buttonReserveButton = new JButton("Reserve");
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.insets = new Insets(30, 0, 0, 0);
		panelEast.add(buttonReserveButton, gbc);
		buttonReserveButton.addActionListener(new ShowMessageListener());
	}
	
	/**
	 * Creates the north panel.
	 * 
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() {
		JPanel panel = new JPanel();

		JLabel title = new JLabel("Flights", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 29));
		panel.add(title);

		return panel;
	}

	/**
	 * Creates the center panel.
	 * 
	 * @return JPanel that goes in center.
	 */
	private JPanel createCenterPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());

		flightsModel = new DefaultListModel<>();
		flightsList = new JList<>(flightsModel);
		

		// User can only select one item at a time.
		flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.flightsList);

		flightsList.addListSelectionListener(new MyListSelectionListener());

		panel.add(scrollPane);
		
		
		return panel;
	}
	
	/**
	 * get combo box select item.
	 * 
	 * 
	 */
	private class ComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			fromselection = (String) fromBox.getSelectedItem();
			toselection = (String) toBox.getSelectedItem();
			dayselection = (String) dayBox.getSelectedItem();
			
		}

	}
	
	/**
	 * find flight.
	 * 
	 * 
	 */
	private class FlightButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				flightsList.removeAll();
				flightsModel.removeAllElements();
				FlightManager findFlight=new FlightManager();
				ArrayList<Flight> findFlifgArrayList=findFlight.findFlights(fromselection, toselection, dayselection);
				for(int i=0;i<findFlifgArrayList.size();i++) {
					String codeString=findFlifgArrayList.get(i).getCode();
					Flight aFlight=findFlight.findFlightByCode(codeString);
					flightsModel.addElement(aFlight);
				}
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
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
				if (flightsList.getSelectedIndex() != -1) {
			Flight listValueFlight=flightsList.getSelectedValue();
			String flightcode=listValueFlight.getCode();
			flightField.setText(flightcode);
			/*String twoCharacterString=flightcode.substring(0, 2);
			String airliString = null;
			if(twoCharacterString.equals("OA")){
				airliString="Otto Airlines";
			}
			if(twoCharacterString.equals("CA")){
				airliString="Conned Air";
			}
			if(twoCharacterString.equals("TB")){
				airliString="Try a Bus Airways";
			}
			if(twoCharacterString.equals("VA")){
				airliString="Vertical Airways";
			}*/
			String airliString=listValueFlight.getAirlineName();
			if(airliString.equals("OA")){
				airliString="Otto Airlines";
			}
			if(airliString.equals("CA")){
				airliString="Conned Air";
			}
			if(airliString.equals("TB")){
				airliString="Try a Bus Airways";
			}
			if(airliString.equals("VA")){
				airliString="Vertical Airways";
				}
			airlineField.setText(airliString);
			String dayString=listValueFlight.getWeekday();
			dayField.setText(dayString);
			String timeString=listValueFlight.getTime();
			timeField.setText(timeString);
			double cost=listValueFlight.getCostPerSeat();
			String costString=String.valueOf(cost);
			costField.setText(costString);
		}
				}
			}

	}
	
	/**
	 * reserve button.
	 * 
	 * 
	 */
	
	private class ShowMessageListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Flight listValueFlight=flightsList.getSelectedValue();
			String nameString=nameField.getText();
			String citizenshipString=citizenshipField.getText();
			ReservationManager aManager = null;
			try {
				aManager = new ReservationManager();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			Reservation reservation = null;
			try {
				reservation = aManager.makeReservation(listValueFlight, nameString, citizenshipString);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String reserverstionCodeString=reservation.getCode();
			JOptionPane.showMessageDialog(null, "Reservation created. Your code is "+reserverstionCodeString);
			nameField.setText("");
			citizenshipField.setText("");
		}
		
	
	
}
	}