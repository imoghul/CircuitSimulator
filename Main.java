import Features.Values;
// import Graphics.Mouse;
import Listeners.KeyListen;
import Listeners.MouseListen;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {

    // Graphical constants
    public static JFrame window = new JFrame("Circuit Solver");
    public static Main panel = new Main();
    public static Container c = window.getContentPane();
    public static Timer clock = new Timer(Values.timerSpeed, panel);
    // Fields

    public void paintComponent(Graphics g) {

    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] argv) throws Exception {
        Main.panel.setBackground(Color.black);
        Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.panel.addMouseListener(new MouseListen());
        JTextField textField = new JTextField();
        textField.addKeyListener(new KeyListen());
        window.add(textField);
        Main.window.setBounds(0, 0, Values.displayW, Values.displayH);
        Main.c.add(panel);
        Values.setup(Main.window, Main.c);
        Main.window.setVisible(true);
        Main.window.setResizable(true);
        Main.clock.start();
    }

    public static void update() {
        Values.displayW = Main.panel.getWidth();
        Values.displayH = Main.panel.getHeight();
        Values.mouse.update(MouseInfo.getPointerInfo().getLocation().x - Main.panel.getLocationOnScreen().x, MouseInfo.getPointerInfo().getLocation().y - Main.panel.getLocationOnScreen().y);
    }

}
