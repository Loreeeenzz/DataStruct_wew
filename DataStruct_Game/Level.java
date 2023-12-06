import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Level extends JFrame implements ActionListener {
    private JLabel label;
    private JButton button1, button2;
    private JPanel panel;

    public static void main(String[] wer) throws Exception {
        new Level();
    }

    public Level() {
        this.setSize(800, 500);
        this.setTitle("Select Level");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Create a panel with a background image
        panel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("sky.gif");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Set the label to "levels.png"
        label = new JLabel(new ImageIcon("levels.png"));
        // Set the position of the label manually
        label.setBounds(240, 50, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());

        // Set images for buttons
        ImageIcon noviceIcon = new ImageIcon("novice.png");
        ImageIcon proIcon = new ImageIcon("pro.png");

        // Create buttons with images and make them transparent
        button1 = new JButton(noviceIcon);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        button1.setBounds(320, 300, noviceIcon.getIconWidth(), noviceIcon.getIconHeight());

        button2 = new JButton(proIcon);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        button2.setBounds(320, 200, proIcon.getIconWidth(), proIcon.getIconHeight());

        panel.add(label);
        panel.add(button1);
        panel.add(button2);

        button1.addActionListener(this);
        button2.addActionListener(this);

        setContentPane(panel);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button1) {
            Play ob = new Play();
            this.setVisible(false);
        } else if (event.getSource() == button2) {
            Play2 ob = new Play2();
            this.setVisible(false);
        }
    }
}
