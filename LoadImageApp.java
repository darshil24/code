/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.nio.Buffer;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component {
    private static final int WINDOW_HEIGHT = 768;
    private static final int WINDOW_WIDTH = 1366;

    private static final String title ="Tiger Zone 0.0.1";
    private static BufferedImage ICON;
    protected static final String[] s =new String[24];
    public static Image icon;
    BufferedImage possible_move,img2;
    public static BufferedImage [] tiles = new  BufferedImage[24];

    public void paint(Graphics g) {
//        g.drawImage(img, 0, 0, null);
//        g.drawImage(img2,920,920,null);
        g.drawImage(tiles[0],0,0,null);
        g.drawImage(tiles[1],105,0,null);
        g.drawImage(tiles[2],205,105,null);
        g.drawImage(possible_move,305,105,null);
        g.drawImage(possible_move,205,205,null);
    }

    public LoadImageApp() {
        initialize_jpgs();
        loadImages();


    }

    private void loadImages() {
        try {
            ICON=ImageIO.read(new File("C:\\Users\\Darshil\\IdeaProjects\\java\\src\\code\\icon.png"));
            possible_move = ImageIO.read(new File("C:\\Users\\Darshil\\IdeaProjects\\java\\src\\code\\possible_move.jpg"));
            img2 = ImageIO.read(new File("C:\\Users\\Darshil\\IdeaProjects\\java\\src\\code\\strawberry.jpg"));
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
        f.setIconImage(ICON);
        f.setTitle(title);
        f.pack();
        f.setResizable(true);
        f.setVisible(true);

    }
}
