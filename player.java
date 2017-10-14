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
public class player {
    //16 pieces;
 int i,k;
 piece ka,qa,ra1,ra2,kna1,kna2,ba1,ba2;
 piece p;
 pawn pa[]= new pawn[8];

 public void initialize (int cl)
 {
 if(cl==0)
 {
   ka = new king(cl,0,4,2);
   qa = new queen(cl,0,3,3);
  for(i=0;i<8;i++)
  {
   pa[i] = new pawn(cl,1,i,1);
  }

   ra1 = new rook(cl,0,0,4);
   ra2 = new rook(cl,0,7,4);
    kna1 = new knight(cl,0,1,6);
    kna2 = new knight(cl,0,6,6);
   ba1 = new bishop(cl,0,2,5);
  ba2 = new bishop(cl,0,5,5);
  
  
 }
 
 if(cl==1)
 {//WHITE
  //System.out.println("CREATING WHITE PIECES:");
   ka = new king(cl,7,4,2);
   qa = new queen(cl,7,3,3);
   //System.out.println("POSITION OF QUEEN WHITE IS:"+qb.x+":"+qb.y);
  for(i=0;i<8;i++)
  {
   pa[i] = new pawn(cl,6,i,1);
  }

    ra1 = new rook(cl,7,0,4);
  ra2 = new rook(cl,7,7,4);
  kna1 = new knight(cl,7,1,6);
   kna2 = new knight(cl,7,6,6);
   ba1 = new bishop(cl,7,2,5);
   ba2 = new bishop(cl,7,5,5);
 }
 
 }
 int move1 (piece obj , int r, int c,boolean es)
 {

  int ret =  obj.move(obj, r, c, es);
  return ret;
 }
 void set1(piece obj,int r,int c)
 {
	obj.set(obj,r,c);
 }
}
