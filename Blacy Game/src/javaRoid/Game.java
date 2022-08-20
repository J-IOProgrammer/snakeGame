/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaRoid;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author pc1
 * this class is our kernel of the game
 */
public class Game extends JPanel implements Runnable,KeyListener{

    private BufferedImage backImage;
    private BufferedImage gameOverImage;
    private boolean gameOver = true;

    /***************************set Game Over******************************/
    public void SetGameOver (boolean gameOver){
    this.gameOver = gameOver;
    }

    /***********************Blacy Object***********************************/
    Blacy blacyObject = new Blacy(this);
    Player playerObject = new Player(this);
    coin coinObject = new coin();
    //what is the this? this is our object from Game Class
    Wall wallObject = new Wall(this);


    /************************************Thread***************************/
    Thread BlacyThread;
    /*
    when the game is starts, this method will run byself.
    */
    @Override
    public void addNotify(){
        super.addNotify(); //  it point to father class of addNotify
        BlacyThread = new Thread(this); // a new object
        BlacyThread.start();
    }
    /***********************************paint*********************************/
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        // lubricate lines of geometric shapes
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /*****************************background********************************/
        setBackground(Color.BLACK);
        g2.drawImage(backImage,0,0,null);

        blacyObject.paint(g2);
        coinObject.paint(g2);
        wallObject.paint(g2);

        //score
        g2.setColor(Color.white);
        Font font = new Font("arial" , Font.BOLD , 20);
        g2.setFont(font);
        g2.drawString("Score = " , 30 , 50);
        g2.drawString(""+playerObject.getScore(),130,50);
        g2.drawString(""+ playerObject.getScore(),130,50);

        /****************************game over*************************************/
        if(!gameOver){
            g2.drawImage(gameOverImage , 0 , 0 , null);
        }
    }

    /******************************constructor************************************************/
    public Game() {
        try {
            gameOverImage = ImageIO.read(new File("GameOver.jpg"));
            backImage = ImageIO.read(new File("backImage.jpg"));
        } catch(Exception e){
            System.err.println("File not found");
        }
    }
    
    /*
    we can draw shapes
    */
    /****************************** move***************************************/
    public void move(){
        playerObject.getCoinPos();
        playerObject.getCoin();
        playerObject.CoinVsWall();
        playerObject.BlacyVsWall();
    }
    
    /*******************run************************/
    @Override
    public void run() {
        
        while(gameOver){
            repaint(); //this method is for calling the paint method in Game Class
            move();
            try {
                // we want a delay
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        blacyObject.setFlag(false);
       blacyObject.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
