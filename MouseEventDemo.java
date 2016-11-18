package code;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Darshil on 11/13/2016.
 */
public class MouseEventDemo implements MouseListener {
    public MouseEventDemo() {

    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed; # of clicks: "

                );
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released; # of clicks: "
               );
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered");
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited");
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked (# of clicks:");
    }
}
