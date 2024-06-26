package sana_hotel.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setTitle("Welcome");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(500, 500);

        // Create a custom JPanel with the background image
        BackgroundPanel backgroundPanel = new BackgroundPanel("bc_h.jpg");

        // Set layout manager of the content pane to BorderLayout
        this.setLayout(new BorderLayout());

        // Add the background panel to the CENTER position
        this.add(backgroundPanel, BorderLayout.CENTER);

        ImageIcon imageIcon = new ImageIcon("dew.jpeg");
        this.setIconImage(imageIcon.getImage());

        // Create a JPanel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3,1));

        JButton b1 = new JButton("client");
        JButton b2 = new JButton("chambre");
        JButton b3 = new JButton("reservation");

        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);

        // Create a GridBagConstraints to center the buttonPanel in backgroundPanel
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
        backgroundPanel.setLayout(new GridBagLayout());
        backgroundPanel.add(buttonPanel, gridBagConstraints);

        this.setVisible(true);
    }

    // Custom JPanel class to paint the background image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
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

    public static void main(String[] args) {
        new MainFrame();
    }
}



