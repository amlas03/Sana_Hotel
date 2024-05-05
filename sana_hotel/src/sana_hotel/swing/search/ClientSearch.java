package sana_hotel.swing.search;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sana_hotel.beans.Client;
import sana_hotel.database.Clientdb;
import sana_hotel.database.Reservationdb;
import sana_hotel.swing.BackgroundPanel;
import sana_hotel.swing.RoundedButton;

public class ClientSearch extends GeneralSearch implements ActionListener {
	static Client c = new Client();
    public ClientSearch(Client a) {
    	super(a);
        b1.setText(c.searchElements(0));
        b2.setText(c.searchElements(1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Clear existing components
        //b.removeAll();
        if (e.getSource() == b1) {
        	//l.setText("Saisir un Id");
        	
				JOptionPane.showMessageDialog(null, "hi");
				Clientdb cd=new Clientdb();
				int i=Integer.parseInt(l.getText());
				try {
					la=new JLabel(cd.searchById(i).toString());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();}
				l.setVisible(true);
				p1.add(la);}
        	if (e.getSource() == b2) {
            	l.setText("Saisir un Nom");
            	if(e.getSource()==search) {
    				JOptionPane.showMessageDialog(null, "hi");
    				Clientdb cd=new Clientdb();
    				String n=this.getText();
    				List<Client> noms =new ArrayList<>();
    				List<JLabel> s =new ArrayList<>();
    				try {
    					noms =cd.searchByName(n);
    					for(int i=0; i<noms.size();i++) {
    						s.get(i).setText((noms.get(i).toString()));}
    				} catch (ClassNotFoundException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();}
    				for(int i=0;i<s.size();i++) {
    					p1.add(s.get(i));}}}
                // Revalidate and repaint the panel
                b.revalidate();
                b.repaint();}


    public static void main(String args[]) {
        new ClientSearch(c);
    }
}
