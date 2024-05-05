package sana_hotel.swing.search;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sana_hotel.beans.Client;
import sana_hotel.beans.Reservation;
import sana_hotel.beans.attributsSearch;
import sana_hotel.database.Clientdb;
import sana_hotel.database.Reservationdb;
import sana_hotel.swing.RoundedButton;

public class ReservationSearch extends GeneralSearch implements ActionListener{
	
	RoundedButton bo = new RoundedButton("Occuper");
	JPanel p = new JPanel();
	List<Reservation> lr =new ArrayList<>();
	List<RoundedButton> lb =new ArrayList<>();
	public ReservationSearch(Reservation a) {
		super(a);
		b1.setText(a.searchElements(0));
		b2.setText(a.searchElements(1));
		b1.addActionListener(this);
		b2.addActionListener(this);
		search.addActionListener(this);
		bo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
        	l.setText("Saisir un Id");
        	if(e.getSource()==search) {
				JOptionPane.showMessageDialog(null, "hi");
				Reservationdb cd=new Reservationdb();
				int i=Integer.parseInt(this.getText());
				Reservation r =new Reservation();
				
				try {
					r = cd.getReservationsByClientId(i);
					la=new JLabel(r.toString());
					lr.clear();
					lr.add(r);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				p1.add(la);
				lb.clear();
				lb.add(bo);
				p1.add(bo);
				}}
        	if (e.getSource() == b2) {
            	l.setText("Saisir un Num");
            	if(e.getSource()==search) {
    				JOptionPane.showMessageDialog(null, "hi");
    				int i =Integer.parseInt(this.getText());
    				Reservationdb cd=new Reservationdb();
    				String n=this.getText();
    				List<Reservation> res =new ArrayList<>();
    				List<JLabel> s =new ArrayList<>();
    				try {
    					res = cd.getReservationsByRoomNumber(i);
    					for(int j=0; j<res.size();j++) {
    						s.get(i).setText((res.get(j).toString()));
    						lr.clear();
    						lr.add(res.get(i));}
    				} catch (ClassNotFoundException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();}
    				
    				p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
    				for(int j=0;j<s.size();j++) {
    					p.removeAll();
    					int m = j+1;
    					p.add(new JLabel(m+""));
    					p.add(s.get(j));
    					lb.clear();
    					lb.add(bo);
    					p.add(bo);    	
    					p1.add(p);}
    				if(e.getSource()==bo) {
    					Reservationdb rdb =new Reservationdb();
    					int k= lb.indexOf(bo);
    					
    					try {
							rdb.writeOccupation(lr.get(k).getChambre(), lr.get(k).getDate(), lr.get(k).getNbreJours());
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    					}}
    				}
                // Revalidate and repaint the panel
                b.revalidate();
                b.repaint();
	}
	
}
