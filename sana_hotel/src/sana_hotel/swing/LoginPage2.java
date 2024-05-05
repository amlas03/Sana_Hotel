package sana_hotel.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LoginPage2 extends JFrame implements ActionListener{
    private JButton b1;
    private JButton b3;
    private JTextField t1;
    private JPasswordField t2;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public LoginPage2() {
        

        // Set the content pane with the BackgroundPanel
        BackgroundPanel backgroundPanel = new BackgroundPanel("bc_h.jpg");
        setSize(500, 500);
        this.add(backgroundPanel);

       ImageIcon imageIcon = new ImageIcon("l.jpg");
       this.setIconImage(imageIcon.getImage());

        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 18));
        l1.setForeground(new Color(0x000000));
        t1 = new JTextField();
        t1.setPreferredSize(new Dimension(150, 50));
        t1.setFont(new Font("Consolas", Font.PLAIN, 18));
        t1.setText("username");
        t1.setBorder(new RoundedBorder(15));

        JLabel l2 = new JLabel("Password");
        l2.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 18));
        l2.setForeground(new Color(0x000000));
        t2=new JPasswordField();
        t2.setPreferredSize(new Dimension(150, 50));
        t2.setFont(new Font("Consolas", Font.PLAIN, 18));
        t2.setText("salma");
        t2.setBorder(new RoundedBorder(15));

        JPanel p1 = new JPanel();
        
        p1.add(l1);
        p1.add(t1);
        
        p1.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        p1.setBackground(new Color(0x0000FF));
        p1.setOpaque(false);
        JPanel p2 = new JPanel();
        
        p2.add(l2);
        p2.add(t2);
        p2.setBackground(new Color(0x0000FF));
        p2.setOpaque(false);
        
        JPanel p3=new JPanel();
        p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
        p3.add(p1);
        p3.add(p2);
        p3.setBorder(new EmptyBorder(70,0,0,0));
        p3.setOpaque(false);

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        b1 = new RoundedButton("Login");

        b3 = new RoundedButton("Exit");

        // Set button font
        Font buttonFont = new Font("Century SchoolBook",Font.BOLD,15);
        b1.setFont(buttonFont);
        b1.setBackground(new Color(215, 80, 102));

        b3.setFont(buttonFont);     
        b3.setBackground(new Color(215, 80, 102));


        // Add mouse hover effect to buttons
        addMouseHoverEffect(b1);

        addMouseHoverEffect(b3);

        p.add(b1);
        p.add(b3);
        p.setBorder(new EmptyBorder(50,70,0,0));
        p.setBackground(new Color(0x0000FF));
        p.setOpaque(false);
        
        JPanel fp =new JPanel(new BorderLayout());
        
        fp.add(p3,BorderLayout.CENTER);
        fp.add(p,BorderLayout.SOUTH);
        
        fp.setBackground(new Color(0x000FF));
        
        fp.setOpaque(false);
        backgroundPanel.add(fp);
        backgroundPanel.setPreferredSize(getSize());
        
        b1.addActionListener(this);
        b3.addActionListener(this);

        setVisible(true);
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
		if(e.getSource()==b1) {
			if(t1.getText().equals("username") && new String(t2.getPassword()).equals("salma")) {
				new WelcomeFrame();
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null,"LOGIN FAILED");
			}
		}
		if(e.getSource()==b3) {
			System.exit(0);
		}
	}

}

