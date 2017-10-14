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
public class pawn extends piece {
      public int fm;
  pawn(int cl,int x,int y,int t)
  {  
     super(cl,x,y,t);
     this.fm=0;
  }
  
  
  public int move(piece p,int r,int c,boolean es) // check validity 
  {
  if(p.colour==0)
  { 
	  if((r-p.x==2||r-p.x==1)&&(c==p.y)&&fm==0&&es==false) //default place
	{ this.fm=1;
	 return 0;
	}
	else if((p.y==c)&&(r-p.x==1)&&(es==false)) //normal move
     return 0;	
	else if( (r-p.x==1)&&(Math.abs(c-p.y)==1)&&(es==true)) //kill
     return 1;
     else 
	return -1;
	
  }
  else
  {
	if((p.x-r==2||p.x-r==1)&&(c==p.y)&&fm==0&&es==false) //default place
	{ this.fm=1;
	return 0;
	}
	else if((p.y==c)&&(p.x-r==1)&&(es==false)) //normal move
     return 0;	
	else if( (p.x-r==1)&&(Math.abs(p.y-c)==1)&&(es==true)) //kill
     return 1;
     else 
	return -1;
	  
  }
	
    
  }
  public void set(piece p,int r,int c)
  {
  p.x=r;
  p.y=c;
  }
    
}
