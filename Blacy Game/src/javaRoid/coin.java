package javaRoid;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class coin {

    Random rand = new Random();
    private Game game;
    private BufferedImage coinimg;
    private int Xpos;
    private int Ypos;

    public void XYRandom(){
        Xpos = rand.nextInt(600);
        Ypos = rand.nextInt(500);
    }

    /**************** paint function ***************************/
    public void paint (Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
    g2.drawImage(coinimg , Xpos , Ypos , null);
    }
    /*******************Rectangle************************************/
    public Rectangle getBounds(){
        return new Rectangle(Xpos,Ypos,coinimg.getWidth(),coinimg.getHeight());
    }
    /*************** load picture ********************************/

    public coin() {
        try {
            coinimg = ImageIO.read(new File("coin.png"));

        } catch (Exception e){
            System.err.println("file not found");
        }
    }
}
