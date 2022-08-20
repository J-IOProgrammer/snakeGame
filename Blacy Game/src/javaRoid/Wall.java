package javaRoid;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class Wall {
    private BufferedImage wallImage;
    private Game game;
    Random rand = new Random();

    private int x1 = rand.nextInt(500);
    private int y1 = rand.nextInt(500);

    public void paint (Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(wallImage,x1,y1,null);
    }

    /********************Rectangle*************************************/
    public boolean collision() {
        return game.blacyObject.getBounds().intersects(getBounds());
    }
    public boolean Collision2() {
        return game.coinObject.getBounds().intersects(getBounds());
    }
    public Rectangle getBounds(){
        return new Rectangle(x1,y1,wallImage.getWidth(),wallImage.getHeight());
    }

    /******************************constructor**********************************/
    public Wall(Game game) {
        this.game = game;
        try {
            wallImage = ImageIO.read(new File("tnt.png"));
        }catch(Exception e){
            System.err.println("File not found");
        }
    }
}
