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
public class king extends piece
{
    king(int cl,int x,int y,int t)
  {
	super(cl,x,y,t);
  }
  
  
public int move(piece p,int r,int c,boolean es ) // check validity 
  {//System.out.println("IN KING");
     if((Math.abs(p.x-r)==1&&Math.abs(p.y-c)==1)&&(es==false))
     {//System.out.println("CASE 1");
     return 0;}
     else if( (Math.abs(p.x-r)==1) && (Math.abs(p.y-c) ==1) && (es==true) )
     {//System.out.println("CASE 2");
     return 1;}
     else if((Math.abs(p.x-r)==1) &&(p.y==c)&&(es==false))
     { // System.out.println("CASE 3"); 
     return 0;}
     else if((Math.abs(p.x-r)==1) &&(p.y==c)&&(es==true))
     { //System.out.println("CASE 4");
     return 1;}
     else if((Math.abs(p.y-c)==1) &&(p.x==r)&&(es==false))
     {  //System.out.println("CASE 5");
         return 0;}
     else if((Math.abs(p.y-c)==1) &&(p.x==r)&&(es==true))
     { //System.out.println("CASE 6"); 
             return 1;}
    else 
     {//System.out.println("CASE .....");
    return -1;}
  }
   public void set(piece p,int r,int c)
  {
  p.x=r;
  p.y=c;
  if(p.colour==0)
  {
	  p.kax=r;
	  p.kay=c;
  }
  else
  {
	  p.kbx=r;
	  p.kby=c;
  }
  }
    
}
