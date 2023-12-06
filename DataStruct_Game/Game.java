import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private JButton button1, button2, button3;

    public static void main(String[] asd) {
        new Game();
    }

    public Game() {
        this.setSize(800, 500);
        this.setTitle("Word Scramble Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Load the background image
        URL backgroundUrl = getClass().getResource("sky.gif");
        ImageIcon backgroundIcon = new ImageIcon(backgroundUrl);

        // Create a custom panel to paint the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(null);

        // Create buttons with images and remove borders
        button1 = new JButton(new ImageIcon(getClass().getResource("play2.png")));
        button2 = new JButton(new ImageIcon(getClass().getResource("credit1.png")));
        button3 = new JButton(new ImageIcon(getClass().getResource("quit1.png")));

        // Set button properties to remove borders
        for (JButton button : new JButton[]{button1, button2, button3}) {
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setOpaque(false);
        }

        button1.setBounds(500, 120, button1.getIcon().getIconWidth(), button1.getIcon().getIconHeight());
        button2.setBounds(500, 200, button2.getIcon().getIconWidth(), button2.getIcon().getIconHeight());
        button3.setBounds(500, 280, button3.getIcon().getIconWidth(), button3.getIcon().getIconHeight());

        backgroundPanel.add(button1);
        backgroundPanel.add(button2);
        backgroundPanel.add(button3);

        // Load Title.png and add it to the left side
        URL titleUrl = getClass().getResource("Title.png");
        ImageIcon titleIcon = new ImageIcon(titleUrl);
        JLabel titleLabel = new JLabel(titleIcon);
        titleLabel.setBounds(100, 150, titleIcon.getIconWidth(), titleIcon.getIconHeight());
        backgroundPanel.add(titleLabel);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        this.setContentPane(backgroundPanel);
        this.setResizable(false);
        this.setVisible(true);
    }


    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button3) {
            System.exit(0);
        } else if (event.getSource() == button2) {
            Help ob = new Help();
            this.setVisible(false);
        } else if (event.getSource() == button1) {
            Level ob1 = new Level();
            this.setVisible(false);
        }
    }
}

class Help extends JFrame implements ActionListener {
    private QuitButton button;
    private JLabel helpLabel;

    public static void main(String[] asd) throws Exception {
        new Help();
    }

    public Help() {
        this.setSize(800, 500);
        this.setTitle("Help");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a custom panel with a background image
        ImagePanel panel = new ImagePanel("sky.gif");

        button = new QuitButton("quit2.png"); // Use custom QuitButton
        helpLabel = new JLabel();

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(createCreditLabel(), gbc);

        gbc.gridy = 1;
        panel.add(createTextPanel(), gbc);

        gbc.gridy = 2;
        panel.add(button, gbc);

        this.add(panel);
        button.addActionListener(this);
        this.setVisible(true);
    }

    private JLabel createCreditLabel() {
        JLabel creditLabel = new JLabel();
        creditLabel.setIcon(new ImageIcon("credit2.png")); // Change the image path to credit2.png
        creditLabel.setHorizontalAlignment(JLabel.CENTER);
        creditLabel.setFont(new Font("Fixedsys Regular", Font.PLAIN, 16));
        creditLabel.setForeground(Color.WHITE);
        return creditLabel;
    }

    private JPanel createTextPanel() {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        // Add formatted text with center alignment
        textPanel.add(createWhiteLabel("Embark on a thrilling linguistic adventure with our captivating game, ", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("Word Scramble! Immerse yourself in a world of letters as you unravel the ", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("hidden words within a chaotic jumble. Challenge your cognitive prowess ", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("and lexical skills as you rearrange the letters to form meaningful words, ", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("racing against time to conquer each level.", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("Blaise Lorenz T. Bernabe", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("Kricel Alvarado", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("Fritz Dolly Lorejas", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("Albert Lex Dela Cruz", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("Together, the UI team led by Blaise Lorenz Bernabe, with invaluable", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("contributions from Kricel Alvarado and Fritz Dolly Lorejas, has woven a", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("seamless tapestry of design and functionality, ensuring that Word ", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("Scramble delivers an immersive and visually stunning gaming", SwingConstants.CENTER));
        textPanel.add(createWhiteLabel("experience for players of all ages.", SwingConstants.CENTER));

        return textPanel;
    }

    private JLabel createWhiteLabel(String text, int alignment) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Fixedsys Regular", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setHorizontalAlignment(alignment);
        return label;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button) {
            this.setVisible(false);
            // Replace with appropriate code to handle quitting or launching the Game
        }
    }

    // Custom panel class with background image
    private class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(String imagePath) {
            this.backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Custom button class to show only the image without border
    private class QuitButton extends JButton {
        private Image buttonImage;

        public QuitButton(String imagePath) {
            this.buttonImage = new ImageIcon(imagePath).getImage();
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            this.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(buttonImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
