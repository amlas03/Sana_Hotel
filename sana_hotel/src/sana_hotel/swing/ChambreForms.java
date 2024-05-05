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

import sana_hotel.beans.Chambre;
import sana_hotel.database.Chambredb;
import sana_hotel.swing.BackgroundPanel;
import sana_hotel.swing.Buttons;
import sana_hotel.swing.LabeledTextField;

public class ChambreForms extends JPanel implements ActionListener{
	
	private List<LabeledTextField> ltf=new ArrayList<>();
	private Buttons b;
	
	
	public ChambreForms(Chambre c) {
		setSize(500, 500);
		BackgroundPanel ba=new BackgroundPanel("purple.jpg");
		this.add(ba);
		JPanel p=new JPanel();
		p.setOpaque(false);
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		for(int i=0; i<c.getNum(); i++) {
			LabeledTextField l=new LabeledTextField(c.getLabel(i), c.getCol(i), 200);
			ltf.add(l);
			p.add(l);
		}
		JPanel pp=new JPanel();
		pp.setOpaque(false);
		pp.setLayout(new BorderLayout());
		pp.add(p,BorderLayout.CENTER);
		Buttons bo=new Buttons(new String[]{"Save","Reset","Exit"});
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
        if (e.getSource() == b.getButton(0)) { 
            saveChambre();
        } else if (e.getSource() == b.getButton(1)) { 
            resetFields();
        } else if (e.getSource() == b.getButton(2)) { 
	        System.exit(0);
	        }
	    }

    private void saveChambre() {
        List<String> values = new ArrayList<>();
        for (LabeledTextField textField : ltf) {
            values.add(textField.getText());
	        }

        try {
            Chambredb chambredb = new Chambredb();
            chambredb.write(values);
            System.out.println("Chambre ajoutée avec succès !");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
	            
	        }
	    }

    private void resetFields() {
        for (LabeledTextField textField : ltf) {
            textField.setText("");
	        }
	    }
	}
	
	
