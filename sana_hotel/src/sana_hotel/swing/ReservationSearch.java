package sana_hotel.swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sana_hotel.beans.Reservation;
import sana_hotel.beans.attributsSearch;
import sana_hotel.database.Reservationdb;

public class ReservationSearch extends GeneralSearch implements ActionListener{
	

	public ReservationSearch(Reservation a) {
		super(a);
		b1.addActionListener(this);
		b2.addActionListener(this);
		search.addActionListener(this);

		
		//l=new JLabel("lol");
		// b.add(la);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			JOptionPane.showMessageDialog(null, "hi");
			Reservationdb rd=new Reservationdb();
			int i=Integer.parseInt(this.getText());
			try {
				la=new JLabel(rd.getReservationsByClientId(i)+"");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			p1.add(la);
		}
		
		if(e.getSource()==b1) {
			search=new RoundedButton("search : ID");
			search.setPreferredSize(new Dimension(120,40));
		}
		b.revalidate();
	    b.repaint();
	}
	
}
