
package code;

import javafx.scene.image.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.nio.Buffer;
import javax.imageio.*;
import javax.swing.*;
import java.lang.Math;

import javax.swing.plaf.nimbus.State;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component implements MouseListener,MouseWheelListener {
    private static final int WINDOW_HEIGHT = 768;
    private static final int WINDOW_WIDTH = 1366;
 protected Graphics2D g2d;
    private static final String title ="Tiger Zone 0.0.1";
    private static BufferedImage ICON;
    protected static final String[] s =new String[24];
    public static Image icon;
    public static BufferedImage possible_move,img2;
    public static BufferedImage [] tiles = new  BufferedImage[24];

    public void  init(){

        System.out.println("mouseListener");
    }
    public void paint(Graphics g) {


//        g.drawImage(img, 0, 0, null);
        //g2d.drawImage(tiles[0],null,0,0);
        g.drawImage(img2,0,0,null);
        g.drawImage(tiles[(int)(Math.random()*24)],0,0,null);
//        g.drawImage(tiles[1],105,0,null);
//        g.drawImage(tiles[2],75,105,null);
//
//        g.drawImage(possible_move,305,105,null);
//        g.drawImage(possible_move,205,205,null);
    }

    public LoadImageApp() {
        addMouseListener(this);
        addMouseWheelListener(this);
        initialize_jpgs();
        loadImages();




    }

    private void loadImages() {
        try {
            ICON=ImageIO.read(new File("C:\\Users\\Darshil\\IdeaProjects\\java\\src\\code\\icon.png"));
            possible_move = ImageIO.read(new File("C:\\Users\\Darshil\\IdeaProjects\\java\\src\\code\\possible_move.jpg"));
            img2 = ImageIO.read(new File("C:\\Users\\Darshil\\IdeaProjects\\java\\src\\code\\woo2.jpg"));
            for (int i =0;i<24;i++){
                tiles[i] = ImageIO.read(new File("C:\\Users\\Darshil\\IdeaProjects\\java\\src\\code\\"+i+".jpg"));
            }

        } catch (IOException e) {
        }
    }

    private void initialize_jpgs() {
        for (int i=1;i<24;i++){
            s[i]= "C:\\Users\\Darshil\\IdeaProjects\\java\\src\\code\\"+i+".jpg";
        }
    }

    public Dimension getPreferredSize() {
        if (possible_move == null) {
            return new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT);
        } else {
            return new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT);
        }
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Load Image Sample");

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(new LoadImageApp());
      //  f.setSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        f.setIconImage(ICON);
        f.setTitle(title);

        f.pack();
        f.setResizable(true);
        f.setVisible(true);
        System.out.println("hello");


    }


    public void repaint(int x, int y, BufferedImage tile) {

        possible_move.createGraphics().drawImage(possible_move,null,x,y);
        System.out.println("tile printed: " +x+","+y);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        repaint();
        paint(possible_move.getGraphics(),e.getX(),e.getY());
        System.out.println("tile printed: " +e.getX()+","+e.getY());


    }

    private void paint(Graphics graphics, int x, int y) {
        graphics.drawImage(tiles[0],x,y,null);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.print("mousewheel: "+ e.getPreciseWheelRotation());
    }
}
