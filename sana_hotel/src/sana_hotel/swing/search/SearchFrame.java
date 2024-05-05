package sana_hotel.swing.search;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sana_hotel.beans.Chambre;
import sana_hotel.beans.Client;
import sana_hotel.beans.Reservation;
import sana_hotel.database.Reservationdb;
import sana_hotel.swing.BackgroundPanel;
import sana_hotel.swing.RoundedButton;
import sana_hotel.swing.WelcomeFrame;

public class SearchFrame extends JFrame implements ActionListener{
	
	RoundedButton b1,b2,b3; JButton b;
	JPanel p;
	BackgroundPanel backgroundPanel;
	
    public SearchFrame() {
        this.setTitle("Welcome");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        ImageIcon imageC = new ImageIcon("A.jpg");
        this.setIconImage(imageC.getImage());
        
        backgroundPanel=new BackgroundPanel("gradient.jpg");
        
        this.setLayout(new BorderLayout());
        
        this.add(backgroundPanel,BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,45,100)); // Use FlowLayout with center alignment
        JPanel buttonPanel1=new JPanel();
        buttonPanel1.setLayout(new BoxLayout(buttonPanel1,BoxLayout.Y_AXIS));
        b1 = new RoundedButton("    client     ");
        b2 = new RoundedButton("  chambre  ");
        b3 = new RoundedButton("reservation");
        
        b1.setBackground(new Color(176, 140, 197));
        b2.setBackground(new Color(176, 140, 197));
        b3.setBackground(new Color(176, 140, 197));
        
        JPanel ep=new JPanel();
        ep.setBorder(new EmptyBorder(0,0,10,0));
        ep.setBackground(new Color(65, 0, 80));
        ep.setVisible(true);
        JPanel ep1=new JPanel();
        ep1.setBorder(new EmptyBorder(0,0,10,0));
        ep1.setBackground(new Color(65, 0, 80));
        ep1.setVisible(true);
        JPanel ep2=new JPanel();
        ep2.setBorder(new EmptyBorder(0,0,10,0));
        ep2.setBackground(new Color(65, 0, 80));
        ep2.setVisible(true);
        buttonPanel1.add(ep2);
        buttonPanel1.add(b1);
        buttonPanel1.add(ep1);
        buttonPanel1.add(b2);
        buttonPanel1.add(ep);
        buttonPanel1.add(b3);
        buttonPanel1.setOpaque(false);
        buttonPanel.setBackground(new Color(65, 0, 80));
        buttonPanel.add(buttonPanel1);
        
        addMouseHoverEffect(b1);
        addMouseHoverEffect(b2);
        addMouseHoverEffect(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        JPanel back=new JPanel();
        back.setLayout(new FlowLayout(FlowLayout.LEFT));
        b=new JButton("Back");
        b.addActionListener(this);
        b.setFocusable(false);
        b.setBackground(new Color(176, 160, 197));
       // b.setForeground(new Color(215, 80, 102));
        back.add(b);
        back.setBackground(new Color(65, 0, 80));

        
        p=new JPanel();
        p.setLayout(new BorderLayout());
        p.add(buttonPanel,BorderLayout.CENTER);
        p.add(back,BorderLayout.NORTH);
        back.setBackground(new Color(65, 0, 80));
        

        // Add the buttonPanel to the WEST position with BorderLayout
      //  this.add(purple,BorderLayout.NORTH);
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(p, BorderLayout.WEST);

        this.setVisible(true);
    }

    
    
    private void addMouseHoverEffect(JButton button) {
		// TODO Auto-generated method stub
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
		backgroundPanel.removeAll();
		backgroundPanel.add(p, BorderLayout.WEST);
		
		if(e.getSource()==b1) {
			setTitle("Client search");
			ImageIcon imageC = new ImageIcon("C:\\Nada\\sana_hotel\\sana_hotel\\sana_hotel\\client.jpg\\");
	        this.setIconImage(imageC.getImage());
			ClientSearch cf=new ClientSearch(new Client());
			backgroundPanel.add(cf, BorderLayout.CENTER);
		}
		if(e.getSource()==b2) {
			setTitle("Chambre search");
			ImageIcon imageC = new ImageIcon("C:\\Nada\\sana_hotel\\sana_hotel\\sana_hotel\\room.png");
	        this.setIconImage(imageC.getImage());
			ChambreSearch cf=new ChambreSearch(new Chambre());
			backgroundPanel.add(cf, BorderLayout.CENTER);
		}
		if(e.getSource()==b3) {
			setTitle("Reservation search");
			ImageIcon imageC = new ImageIcon("C:\\Nada\\sana_hotel\\sana_hotel\\sana_hotel\\reser.png\\");
	        this.setIconImage(imageC.getImage());
			ReservationSearch cf=new ReservationSearch(new Reservation());
			backgroundPanel.add(cf, BorderLayout.CENTER);
					}
		
		if(e.getSource()==b) {
			new WelcomeFrame();
			this.dispose();
		}
		backgroundPanel.revalidate();
	    backgroundPanel.repaint();
	}

	
	public static void main(String[] args) {
        new SearchFrame();
    }
}

