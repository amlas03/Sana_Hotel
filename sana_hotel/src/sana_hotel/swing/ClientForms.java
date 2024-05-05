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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import sana_hotel.beans.Client;
import sana_hotel.database.Clientdb;

public class ClientForms extends JPanel implements ActionListener{
	
	private List<LabeledTextField> ltf;
	private Buttons bo;
	private JLabel labell;
	
	
	public ClientForms(Client c) {
		ltf=new ArrayList<>();
		JPanel label=new JPanel();
		label.setOpaque(false);
		JLabel ID=new JLabel("ID ");
		ID.setFont(new Font("Century SchoolBook",Font.BOLD,13));
		ID.setForeground(new Color(255, 255, 0));
		ID.setBorder(new EmptyBorder(0,0,0,70));
		ID.setOpaque(false);
		label.add(ID);
		labell=new JLabel();
		labell.setForeground(new Color(255, 255, 0));
		Clientdb cd=new Clientdb();
		
		try {
			labell.setText(cd.getID());
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		label.add(labell);
		setSize(500, 600);
		BackgroundPanel ba=new BackgroundPanel("purple.jpg");
		add(ba);
		JPanel p=new JPanel();
		//p.setOpaque(false);
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.add(label);
		for(int i=0; i<c.getNum(); i++) {
			LabeledTextField l=new LabeledTextField(c.getLabel(i), c.getCol(i), 150);
			ltf.add(l);
			p.add(l);
		}
		p.setOpaque(false);
		JPanel pp=new JPanel();
		pp.setOpaque(false);
		pp.setLayout(new BorderLayout());
		pp.add(p,BorderLayout.CENTER);
		bo=new Buttons(new String[]{"Save","Reset","Exit"});
		
		for(int i=0; i<3; i++) {
			bo.getButton(i).addActionListener(this);
		}
		
		pp.add(bo,BorderLayout.SOUTH);
		for(int i=0; i<3; i++) {
			bo.addMouseHoverEffect(bo.getButton(i));
			bo.addMousePressEffect(bo.getButton(i));
		}
		ba.add(pp);
		ba.setPreferredSize(getSize());
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bo.getButton(0)) {
			Clientdb cd=new Clientdb();
			
			List<String> s=new ArrayList<>();
			
			for(int i=0; i<ltf.size(); i++) {
				s.add(ltf.get(i).getText());
			}
			try {
			cd.write(s);
			}catch(SQLException sq) {
				sq.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				labell.setText(cd.getID());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==bo.getButton(1)) {
			for(int i=0; i<ltf.size(); i++) {
				ltf.get(i).setText("");
			}
		}
		
		if(e.getSource()==bo.getButton(2)) {
			System.exit(0);
		}
		
	}
	
	
}