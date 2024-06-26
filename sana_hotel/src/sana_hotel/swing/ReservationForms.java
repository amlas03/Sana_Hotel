package sana_hotel.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import sana_hotel.beans.Reservation;
import sana_hotel.database.Clientdb;
import sana_hotel.database.Reservationdb;

public class ReservationForms extends JPanel implements ActionListener{
	
	private List<LabeledTextField> ltf=new ArrayList<>();
	private Buttons b;
	private JComboBox jours;
	private JComboBox mois;
	private JComboBox annees;
	
	public ReservationForms(Reservation c) {
		
	    JLabel date=new JLabel("Date ");
	    date.setFont(new Font("Century SchoolBook",Font.BOLD,15));
	    date.setForeground(new Color(255, 255, 0));
		date.setBorder(new EmptyBorder(0,0,0,90));
	    
		String[] jours= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
		this.jours=new JComboBox<>(jours);
		this.jours.setBackground(new Color(176, 140, 197));

		
		String[] mois= {"1","2","3","4","5","6","7","8","9","10","11","12"};
		this.mois=new JComboBox<>(mois);
		this.mois.setBackground(new Color(176, 140, 197));

		
		String[] annees= {"2023","2024","2025","2026","2027","2028","2029","2030"};
		this.annees=new JComboBox<>(annees);
		this.annees.setBackground(new Color(176, 140, 197));
		
		JPanel combo=new JPanel();
		combo.add(date);
		combo.add(this.jours);
		combo.add(this.mois);
		combo.add(this.annees);
		combo.setOpaque(false);
		
		setSize(500,600);
		BackgroundPanel ba=new BackgroundPanel("purple.jpg");
		this.add(ba);
		JPanel p=new JPanel();
		p.setOpaque(false);
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.add(combo);
		for(int i=0; i<c.getNum(); i++) {
			LabeledTextField l=new LabeledTextField(c.getLabel(i), c.getCol(i), 150);
			ltf.add(l);
			p.add(l);
		}
		JPanel pp=new JPanel();
		pp.setOpaque(false);
		pp.setLayout(new BorderLayout());
		pp.add(p,BorderLayout.CENTER);
		b=new Buttons(new String[]{"Reserver","Reset","Exit"});
		pp.add(b,BorderLayout.SOUTH);
		for(int i=0; i<3; i++) {
			b.addMouseHoverEffect(b.getButton(i));
			b.addMousePressEffect(b.getButton(i));
			b.getButton(i).addActionListener(this);
			
		}
		ba.add(pp);
		ba.setPreferredSize(getSize());
		
		this.mois.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDays();
            }
        });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateDays();
	   String actionCommand = e.getActionCommand();
	    switch (actionCommand) {
	        case "Reserver":
	            handleReservation();
	            break;
	        case "Reset":
	            resetForm();
	            break;
	        case "Exit":
	            exitForm();
	            break;
		    }
		}
		
	private void handleReservation() {
	    String selectedDate = annees.getSelectedItem() + "-" + mois.getSelectedItem() + "-" + jours.getSelectedItem();
	    int clientId = getClientIdFromForm(); 
	    int roomNumber = getRoomNumberFromForm();
	    int numberOfDays = getNumberOfDaysFromForm(); 

	    try {
	        Reservationdb reservationdb = new Reservationdb();
	        reservationdb.writeReservation(clientId, roomNumber, selectedDate, numberOfDays);
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	}

	private void handleOccupation() {
	   
	    String selectedDate = annees.getSelectedItem() + "-" + mois.getSelectedItem() + "-" + jours.getSelectedItem();

	    
	    int roomNumber = getRoomNumberFromForm(); 
	    int numberOfDays = getNumberOfDaysFromForm(); 

	    try {
	        Reservationdb reservationdb = new Reservationdb();
	        reservationdb.writeOccupation(roomNumber, selectedDate, numberOfDays);
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
	}
	private int getClientIdFromForm() {
	    
	    String clientIdText = ltf.get(0).getText();
	    try {
	        return Integer.parseInt(clientIdText);
	    } catch (NumberFormatException e) {
	       
	        e.printStackTrace();
	        return -1; 
	    }
	}

	private int getRoomNumberFromForm() {
	    
	    String roomNumberText = ltf.get(1).getText();
	    try {
	        return Integer.parseInt(roomNumberText);
	    } catch (NumberFormatException e) {
	        
	        e.printStackTrace();
	        return -1; 
	    }
	}

	private int getNumberOfDaysFromForm() {
	   
	    String numberOfDaysText = ltf.get(2).getText();
	    try {
	        return Integer.parseInt(numberOfDaysText);
	    } catch (NumberFormatException e) {
	       
	        e.printStackTrace();
	        return -1; 
	    }
	}
	private void resetForm() {
	  
	    for (LabeledTextField textField : ltf) {
	        textField.setText("");
	    }
	    
	    jours.setSelectedIndex(0);
	    mois.setSelectedIndex(0);
	    annees.setSelectedIndex(0);
	}

	private void exitForm() {
	    
	    JFrame frame = (JFrame) getTopLevelAncestor();
	    frame.dispose();
	}


	
	
	public void updateDays() {
		int selectedMonthIndex = mois.getSelectedIndex();
        int daysInMonth = 0;

        // Vérifie le mois sélectionné et ajuste le nombre de jours en conséquence
        switch (selectedMonthIndex) {
            case 0: // January
            case 2: // March
            case 4: // May
            case 6: // July
            case 7: // August
            case 9: // October
            case 11: // December
                daysInMonth = 31;
                break;
            case 3: // April
            case 5: // June
            case 8: // September
            case 10: // November
                daysInMonth = 30;
                break;
            case 1: // February
                int selectedYear = Integer.parseInt((String) annees.getSelectedItem());
                daysInMonth = (selectedYear % 4 == 0 && (selectedYear % 100 != 0 || selectedYear % 400 == 0)) ? 29 : 28;
                break;
        }

        // Met à jour le modèle du JComboBox des jours
        String[] updatedDays = new String[daysInMonth];
        for (int i = 1; i <= daysInMonth; i++) {
            updatedDays[i - 1] = String.valueOf(i);
        }
        DefaultComboBoxModel<String> daysModel = new DefaultComboBoxModel<>(updatedDays);
        jours.setModel(daysModel);
    }
	}