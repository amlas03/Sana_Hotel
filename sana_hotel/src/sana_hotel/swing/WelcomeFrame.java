package sana_hotel.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sana_hotel.swing.search.SearchFrame;

public class WelcomeFrame extends JFrame implements ActionListener{
	
	private JButton search;
	private JButton add;
	
	public WelcomeFrame() {
		this.setTitle("Welcome");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(700, 700);
        this.setVisible(true);
        setLocationRelativeTo(null);
        
        ImageIcon imageIcon = new ImageIcon("C:\\Nada\\sana_hotel\\sana_hotel\\sana_hotel\\A.jpg\\");
        this.setIconImage(imageIcon.getImage());
        
        
        search=new RoundedButton("Search"); 
        add=new RoundedButton("Add"); 
        
      //change the color of the buttons
        search.setBackground(Color.PINK);
        add.setBackground(Color.PINK);
        
        addMouseHoverEffect(search); search.addActionListener(this);
        addMouseHoverEffect(add); add.addActionListener(this);
        
        BackgroundPanel bp=new BackgroundPanel("pink1.jpg");
        bp.setLayout(new BorderLayout());
        
        this.add(bp);
        
        JPanel p=new JPanel(); p.add(search);  p.add(add); 
        p.setOpaque(false);
        
        bp.add(p,BorderLayout.CENTER);
        
        
	}
	
	public static void main(String[] args) {
		new WelcomeFrame();
	}
	
	 private void addMouseHoverEffect(JButton button) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			this.dispose();
			new SearchFrame();
		}
		if(e.getSource()==add) {
			this.dispose();
			new MainFrame2();
		}
	}
	
	
	
}
