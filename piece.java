/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author shivanshsharma
 */
public abstract class piece {
    
     public int colour; //black=0 white=1
 public int x,y;//position
 public static int kax=0 , kay=4; //position of black king
 public static int kbx=7 ,kby=4;
 //public static int ex,ey;
 public boolean alive;
 public int type;//pawn =1,king=2,queen=3,rook=4,bishop=5,knight=6
 piece(int cl,int x,int y , int t)
 {
 this.colour = cl;
 this.x=x;
 this.y=y;
 this.alive=true;
 this.type =t;   
 }
 public abstract int move(piece p,int r,int c,boolean es);   //check validity
 public abstract void set(piece p,int r,int c);      //updates x and y
}
