import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;

import java.awt.geom.AffineTransform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Test extends JFrame {

    private BufferedImage img;

    Graphics2D g2dbf;

    BufferedImage bgImage;

    AffineTransform identityTrans = new AffineTransform();

    AffineTransform af = new AffineTransform();

    Timer timer;

    int rotation;

    Test() {
        setTitle("Test");
        setSize(840, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);



        try {
            img = ImageIO.read(new File("./symbols/resistor.png"));

        } catch(IOException e) {}

        bgImage = new BufferedImage(840, 680, BufferedImage.TYPE_INT_RGB);
        g2dbf = bgImage.createGraphics();

        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotation += 4;
                repaint();

                if(rotation > 360) rotation = 4;
            }
        });
        timer.start();
    }


    @Override
    public void paint(Graphics g) {
        g2dbf.setTransform(identityTrans);
        af.setToIdentity();
        af.translate(300, 200);
        af.rotate(Math.toRadians(rotation), img.getWidth(this) / 2, img.getHeight(this) / 2);
        g2dbf.drawImage(img, af, this);

        g.drawImage(bgImage, 0, 0, this);
    }

    public static void main(String[]args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });

    }

}