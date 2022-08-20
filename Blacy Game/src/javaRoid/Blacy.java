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
import javax.imageio.ImageIO;

/**
 *
 * @author pc1
 * this class is for our snake
 */
public class Blacy implements KeyListener {
    
    /********************object from Game Class********************/
    private Game game;
    
    /***********************making blacy body**************************/
    BufferedImage head;
    BufferedImage body;

    /******************************Rectangle *******************************/
    public boolean collision(){
        return game.coinObject.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds(){
        return new Rectangle(blacyXLength[0],blacyYLength[0],head.getWidth(),head.getHeight());
    }
    /************************the move of our snake*******************/
    private int[] blacyXLength = new int [750];
    private int[] blacyYLength = new int [750];
    private int lengthOfBlacy = 3;

    //increase the length of blacy
    public void SetLengthOfBlacy (){
        lengthOfBlacy++;
    }
    private int location = 0;
    
    private boolean flag = true;
    private boolean up = false;
    private boolean down = false;
    private boolean right = true;
    private boolean left = false;

    /*********************getter & setter*****************************/
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    /************************paint********************************/
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(location==0) {
        
        //the first part in drawImage is the name of our Buffered object
        blacyXLength[0] = 200;
        blacyYLength[0] = 100;
        location++;
        }    
        
       if(right==true && flag){
           
           for(int r = lengthOfBlacy-1 ; r>=0 ; r--){
               blacyYLength[r+1] = blacyYLength[r];
           }
           for(int r = lengthOfBlacy ; r>=0 ; r-- ) {
               
               if(r==0){
                   blacyXLength[r] = blacyXLength[r] + 45;
               } else {
                   blacyXLength[r] = blacyXLength[r-1];
               } 
               if(blacyXLength[r]>625) {
                   game.SetGameOver(false);
                   //blacyXLength[r] = 25; -> unlimited move
                   // this part is usefull, when the blacy is crashing to the wall and then it will appear in this another part
               }
           }
       }
       
       for (int i=0; i<lengthOfBlacy ; i++){
           if(right && flag){
               if(i==0)
                   g2.drawImage(head, blacyXLength[i], blacyYLength[i], null);
               else
                    g2.drawImage(body, blacyXLength[i], blacyYLength[i], null);
           }
       }
       /*****************************key touch*******************************/
       if(right && !flag){
           for(int r = lengthOfBlacy-1 ; r>=0 ; r--){
               blacyYLength[r+1] = blacyYLength[r];
           }
           for(int r = lengthOfBlacy ; r>=0 ; r--){
               if(r==0){
                   blacyXLength[r] = blacyXLength[r]+45;
               } else {
                   blacyXLength[r] = blacyXLength[r-1];
               } if (blacyXLength[r] >620){
                   game.SetGameOver(false);
                   //blacyXLength[r] = 25;
               }
           }
       }
              if(left && !flag){
           for(int r = lengthOfBlacy-1 ; r>=0 ; r--){
               blacyYLength[r+1] = blacyYLength[r];
           }
           for(int r = lengthOfBlacy ; r>=0 ; r--){
               if(r==0){
                   blacyXLength[r] = blacyXLength[r]-45;
               } else {
                   blacyXLength[r] = blacyXLength[r-1];
               } if (blacyXLength[r]< -10){
                   game.SetGameOver(false);
                   //blacyXLength[r] = 850;
               }
           }
       }
                     if(down && !flag){
           for(int r = lengthOfBlacy-1 ; r>=0 ; r--){
               blacyXLength[r+1] = blacyXLength[r];
           }
           for(int r = lengthOfBlacy ; r>=0 ; r--){
               if(r==0){
                   blacyYLength[r] = blacyYLength[r]+45;
               } else {
                   blacyYLength[r] = blacyYLength[r-1];
               } if (blacyYLength[r] > 550 ){
                   game.SetGameOver(false);
                   //blacyYLength[r] = 75;
               }
           }
       }
                            if(up && !flag){
           for(int r = lengthOfBlacy-1 ; r>=0 ; r--){
               blacyXLength[r+1] = blacyXLength[r];
           }
           for(int r = lengthOfBlacy ; r>=0 ; r--){
               if(r==0){
                   blacyYLength[r] = blacyYLength[r]-45;
               } else {
                   blacyYLength[r] = blacyYLength[r-1];
               } if (blacyYLength[r] < -20){
                   game.SetGameOver(false);
                   //blacyYLength[r] = 625;
               }
           }
       }
    /*************************moving blacy**********************************/
    for(int i =0 ; i<lengthOfBlacy ; i++){
    if(i==0 && right && !flag){
        //draw right snake
        g2.drawImage(head, blacyXLength[i],blacyYLength[i],null);
    }
    if(i==0 && left && !flag){
        //draw left snake
        g2.drawImage(head,blacyXLength[i],blacyYLength[i],null);
    }
    if(i==0 && down && !flag){
        //draw down snake
        g2.drawImage(head,blacyXLength[i],blacyYLength[i],null);
    }
    if(i==0 && up && !flag){
        //draw up snake
        g2.drawImage(head,blacyXLength[i],blacyYLength[i],null);
    }
    if(i !=0 && !flag){
        //draw right snake
        g2.drawImage(body,blacyXLength[i],blacyYLength[i],null);
    }
}
    /************************accident************************************/
    for (int i = 1 ; i < lengthOfBlacy ; i++) {

        if (blacyXLength[i] == blacyXLength[0] && blacyYLength[i] == blacyYLength[0])
            game.SetGameOver(false);
    }
    
    }
    /************************constructor**************************/
    public Blacy(Game game) {
        this.game = game;
        
                //we have to read the Image of blacy
    try {
    head = ImageIO.read(new File("head.png"));
    body = ImageIO.read(new File("body.png"));
        } catch (Exception e){
    System.err.println("File not found !");
        }
    }
    
    /************************implemented methods*************************/
    @Override
    public void keyTyped(KeyEvent e) {
      //To change body of generated methods, choose Tools | Templates.
    }

    /*********************the moving of blacy*****************************/
    @Override
    public void keyPressed(KeyEvent e) {
        /**************right***************/
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !left){
            down = false;
            up = false;
            right = true;
        }
        /**************left***************/
        if(e.getKeyCode() == KeyEvent.VK_LEFT && !right){
            down = false;
            left = true;
            up = false;
        }
        /**************up***************/
        if(e.getKeyCode() == KeyEvent.VK_UP && !down){
            up = true;
            right = false;
            left = false;
        }
        /**************down***************/
        if(e.getKeyCode() == KeyEvent.VK_DOWN && !up){
            down = true;
            right = false;
            left = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
