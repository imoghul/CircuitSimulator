package Features;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Point;
import java.awt.Image;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

import java.awt.geom.AffineTransform;

import Graphics.Mouse;
import Elements.Element;
import Elements.Node;

public class Values {

    public static int displayW = 1500, displayH = 1000, timerSpeed = 15;
    public static final int nodesW = 20, nodesH = 15;
    public static Color backgroundColor = Color.black;
    public static ArrayList<Element> elements = new ArrayList<>();
    public static ArrayList<Node> nodes = new ArrayList<>();;
    public enum CircuitElements {
        WIRE, RESISTOR, VOLTAGE_SOURCE, CURRENT_SOURCE, VCVS, VCCS, CCVS, CCCS, OPAMP;
    }
    public static CircuitElements currentItem;
    // Objects
    public static JToolBar toolBar = new JToolBar();
    //
    public static JButton fileButton = new JButton("File");
    public static JButton editButton = new JButton("Edit");
    public static JButton insertButton = new JButton("Insert");
    //
    public static JPopupMenu filePopup = new JPopupMenu();
    public static JPopupMenu editPopup = new JPopupMenu();
    public static JPopupMenu insertPopup = new JPopupMenu();
    //
    public static JMenuItem wireItem = new JMenuItem("Wire");
    public static JMenuItem resistorItem = new JMenuItem("Resistor");
    public static JMenuItem vSourceItem = new JMenuItem("Voltage Source");
    public static JMenuItem cSourceItem = new JMenuItem("Current Source");
    public static JMenuItem vcvsSourceItem = new JMenuItem("VCVS");
    public static JMenuItem vccsSourceItem = new JMenuItem("VCCS");
    public static JMenuItem ccvsSourceItem = new JMenuItem("CCVS");
    public static JMenuItem cccsSourceItem = new JMenuItem("CCCS");
    public static JMenuItem opampItem = new JMenuItem("Op Amp");
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
        Values.toolBar.add(Values.insertButton);

        // add buttons options to each toolbar popup
        Values.insertPopup.add(Values.wireItem);
        Values.insertPopup.add(Values.resistorItem);
        Values.insertPopup.add(Values.vSourceItem);
        Values.insertPopup.add(Values.cSourceItem);
        Values.insertPopup.add(Values.vcvsSourceItem);
        Values.insertPopup.add(Values.vccsSourceItem);
        Values.insertPopup.add(Values.ccvsSourceItem);
        Values.insertPopup.add(Values.cccsSourceItem);
        Values.insertPopup.add(Values.opampItem);

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
        Values.insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.showPopup(window, e, Values.insertPopup);
            }
        });

        // action at each option
        Values.wireItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.WIRE;
            }
        });
        Values.resistorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.RESISTOR;
            }
        });
        Values.vSourceItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.VOLTAGE_SOURCE;
            }
        });
        Values.cSourceItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.CURRENT_SOURCE;
            }
        });
        Values.vcvsSourceItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.VCVS;
            }
        });
        Values.vccsSourceItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.VCCS;
            }
        });
        Values.ccvsSourceItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.CCVS;
            }
        });
        Values.cccsSourceItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.CCCS;
            }
        });
        Values.opampItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Values.currentItem = CircuitElements.OPAMP;
            }
        });

        for(int i = 0 ; i < nodesW * nodesH; ++i) {
            nodes.add(new Node());
        }

    }

    private static void showPopup(Component c, ActionEvent ae, JPopupMenu menu) {
        Component b = (Component)ae.getSource();
        Point p = b.getLocationOnScreen();
        menu.show(c, 0, 0);
        menu.setLocation(p.x, p.y + b.getHeight());
    }
}

