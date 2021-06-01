package Features;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Point;

import Graphics.Mouse;


public class Values {

    public static int displayW = 1500, displayH = 1000, timerSpeed = 15;

    // Objects
    public static JToolBar toolBar = new JToolBar();
    public static JButton fileButton = new JButton("File");
    public static JButton editButton = new JButton("Edit");
    public static JPopupMenu filePopup = new JPopupMenu();
    public static JPopupMenu editPopup = new JPopupMenu();
    public static JMenuItem option1 = new JMenuItem("option 1");
    public static JMenuItem option2 = new JMenuItem("option 2");
    //
    public static Mouse mouse = new Mouse(Values.timerSpeed);

    public static void setup(Component window, Container container) {
        // toolbar options
        Values.toolBar.setRollover(true);
        Values.toolBar.setFloatable(false);
        container.add(Values.toolBar, BorderLayout.NORTH);

        // add toolbar buttons
        Values.toolBar.add(Values.fileButton);
        Values.toolBar.add(Values.editButton);

        // add buttons options to each toolbar
        Values.filePopup.add(option1);
        Values.filePopup.add(option2);

        // display pop ups
        Values.fileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.showPopup(window, e, Values.filePopup);
            }
        });
        Values.editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.showPopup(window, e, Values.editPopup);
            }
        });
        // action at each option
        Values.option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("option 1 clicked");
            }
        });
        Values.option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("option 2 clicked");
            }
        });


    }

    private static void showPopup(Component c, ActionEvent ae, JPopupMenu menu) {
        Component b = (Component)ae.getSource();
        Point p = b.getLocationOnScreen();
        menu.show(c, 0, 0);
        menu.setLocation(p.x, p.y + b.getHeight());
    }
}

