package sana_hotel.swing;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class LoginPage extends JFrame implements ActionListener {
    JButton b1;
    JButton b3;
    JLabel l1, l2;
    JPasswordField t2;
    JTextField t1;

    public LoginPage() {
        setTitle("Authentification");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(470, 450);

        // Set the content pane with the BackgroundPanel
        BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Nada\\sana_hotel\\sana_hotel\\sana_hotel\\flower.jpg\\");
        this.add(backgroundPanel);

        ImageIcon imageIcon = new ImageIcon("C:\\Nada\\sana_hotel\\sana_hotel\\sana_hotel\\l.jpg\\");
        this.setIconImage(imageIcon.getImage());

        l1 = new JLabel("Username");
        l1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 18));
        l1.setForeground(Color.WHITE);
        t1 = new JTextField(); t1.setOpaque(false); t1.setBorder(new LineBorder(Color.WHITE));
        t1.setForeground(Color.WHITE);
        t1.setPreferredSize(new Dimension(150, 50));
        t1.setFont(new Font("Consolas", Font.PLAIN, 18));
        t1.setText("username");
        t1.setBorder(new RoundedBorder(15));

        l2 = new JLabel("Password");
        l2.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 18));
        l2.setForeground(Color.WHITE);
        t2 = new JPasswordField(); t2.setOpaque(false); t2.setBorder(new LineBorder(Color.WHITE));
        t2.setForeground(Color.WHITE);
        t2.setPreferredSize(new Dimension(150, 50));
        t2.setFont(new Font("Consolas", Font.PLAIN, 18));
        t2.setText("nada");
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
        

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        b1 = new RoundedButton("Login");

        b3 = new RoundedButton("Exit");

        // Set button font
        Font buttonFont = new Font("Century SchoolBook",Font.BOLD,15);
        b1.setFont(buttonFont);
        b1.setBackground(new Color(176, 160, 197));

        b3.setFont(buttonFont);     
        b3.setBackground(new Color(176, 160, 197));


        // Add mouse hover effect to buttons
        addMouseHoverEffect(b1);

        addMouseHoverEffect(b3);

        p.add(b1);

        p.add(b3);
        p.setBackground(new Color(0x0000FF));
        p.setOpaque(false);
        JPanel fp =new JPanel(new GridLayout(3,1));
        
        fp.add(p1);
        fp.add(p2);
        fp.add(p);
        
        fp.setBackground(new Color(0x000FF));
        
        fp.setOpaque(false);
        backgroundPanel.add(fp);
        

        setLocationRelativeTo(null);
        setVisible(true);
        b3.addActionListener(this);
        b1.addActionListener(this);
        b1.setFocusable(false);
        b3.setFocusable(false);
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

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error loading background image: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }


    // Custom border class for rounded borders
    private static class RoundedBorder extends AbstractBorder {
        private final int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(radius, radius, radius, radius);
            return insets;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage());
    }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			char[] s1= {'s','a','l','m','a'};
			if(t1.getText().equals("username") && Arrays.equals(t2.getPassword(),s1 )){
				System.out.println("Welcome");
				WelcomeFrame m=new WelcomeFrame();
				this.dispose();
				m.setVisible(true);}
			else {
				System.out.println("Please check your credentials");}}
		else if (e.getSource()==b3) {
			this.dispose();
		}}}



