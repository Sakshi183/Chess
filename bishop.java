/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.*;
import java.io.*;

public class bishop extends piece
{
     bishop(int cl,int x,int y,int t)
  {
	super(cl,x,y,t);
  }
  
  public int  move(piece p,int r,int c,boolean es ) // check validity 
  { 
    if(Math.abs(p.x-r)==Math.abs(p.y-c)&&(es==true))
    return 1;
     else if(Math.abs(p.x-r)==Math.abs(p.y-c)&&(es==false))
    return 0;
    else 
    return -1;
  }
  public void set(piece p,int r,int c)
  {
  p.x=r;
  p.y=c;
  }
}
