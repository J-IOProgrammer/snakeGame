/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaRoid;

import javax.swing.JFrame;

/**
 *
 * @author pc1
 */
public class MainCls extends JFrame {
    
    // sensitivity to the keyboard
    public MainCls(){
        Game game = new Game();
        addKeyListener(game);
        add(game);
        setTitle("Little Blacy");
        setSize(700,650);
        setLocationRelativeTo(null); // in the center of screen
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String []args){

        new MainCls(); // calling the constructor of our class
    }
}
