package sana_hotel.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LabeledTextField extends JPanel{
	
	public LabeledTextField(String s, int col, int labelwidth) {
		JLabel l=new JLabel(s);
		l.setFont(new Font("Century SchoolBook",Font.BOLD,15));
		l.setForeground(new Color(255, 255, 0));
		JTextField tf=new JTextField(col);
		l.setBorder(new EmptyBorder(0,0,0,-50));
		add(l); add(tf);
		this.setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		((JLabel)this.getComponent(0)).setPreferredSize(new Dimension(labelwidth,60));
	}
	
	public String getText() {
		return ((JTextField)this.getComponent(1)).getText();
	}
	
	public void setText(String s) {
		((JTextField)this.getComponent(1)).setText(s);
	}
	
}

