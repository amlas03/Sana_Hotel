package sana_hotel.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Buttons extends JPanel{
	
	private List<JButton> boutons=new ArrayList<>();
	
	public Buttons(String[] s) {
		JPanel p=new JPanel();
		p.setOpaque(false);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		for(int i=0; i<s.length; i++) {
			RoundedButton b=new RoundedButton(s[i]);
			b.setBackground(new Color(176, 160, 197));
			b.setFocusable(false);
			p.add(b);
			boutons.add(b);
		}
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setOpaque(false);
		add(p);
	}
	
	public JButton getButton(int i) {
		return boutons.get(i);
	}
	
	public void addMouseHoverEffect(JButton button) {
	    // Stocker la couleur d'origine du bouton
	    Color originalColor = button.getBackground();

	    button.addMouseListener(new MouseAdapter() {
	        
	        public void mouseEntered(MouseEvent e) {
	            // Modifier la couleur au survol de la souris
	            button.setBackground(originalColor.brighter());
	        }

	        
	        public void mouseExited(MouseEvent e) {
	            // Restaurer la couleur d'origine lorsque la souris quitte le bouton
	            button.setBackground(originalColor);
	        }
	    });
	}
	
	public void addMousePressEffect(JButton b) {
		Color originalColor=b.getBackground();
		b.getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if(b.getModel().isPressed()) {
					b.setBackground(Color.WHITE);
				}
				else {
					b.setBackground(originalColor);
				}
			}
		});
	}
	
}
