package javaapplication8;
import java.util.Scanner;
public class JavaApplication8 {
static int flag=0;
static piece kd=null;
static board b;
static int ex,ey;
static int q=2;
static int ch,j,k,i,chance=2;
static player p1=new player();
static player p2= new player();
public static void main(String args[])
{
	Scanner scan = new Scanner(System.in);
	//BOARD INITIALISATION
int i,j,k,ch;
i=0;
int test=0;
 chance=0;
p1.initialize(0);
// palce pieces of p1
b.a[0][0]=p1.ra1;
b.a[0][7]=p1.ra2;
b.a[0][1]=p1.kna1;
b.a[0][6]=p1.kna2;
b.a[0][2]=p1.ba1;
b.a[0][5]=p1.ba2;
b.a[0][4]=p1.ka;
b.a[0][3]=p1.qa;
for(i=0;i<8;i++)
{
	b.a[1][i]=p1.pa[i];
}

p2.initialize(1);
//place pieces of second player
b.a[7][0]=p2.ra1;
b.a[7][7]=p2.ra2;
b.a[7][1]=p2.kna1;
b.a[7][6]=p2.kna2;
b.a[7][2]=p2.ba1;
b.a[7][5]=p2.ba2;
b.a[7][3]=p2.qa;
b.a[7][4]=p2.ka;
for(i=0;i<8;i++)
{
	b.a[6][i]=p2.pa[i];
}
int x1=-1,y1=-1,x2=-1,y2=-1;
String s1;
     String s2;
     String s3;
     String s4;
     char c1;
      int i1=-1;
printb();
System.out.println("CHANCE IS OF PLAYER "+q);
chance=0;
System.out.println("ENTER INITIAL POSITIONS:");
s1=scan.next();
s2=scan.next();
System.out.println("ENTER FINAL POSITIONS");
s3=scan.next();
s4=scan.next();
//if(check()==true)
//System.out.println("IN CHECK IN FIRST MOVE");
chance++;
while(test!=1)
{  
    if(48>s1.charAt(0)||s1.charAt(0)>57)
{System.out.println("INVALID PLACES !!!!!");chance++;}
   
else if(48>s2.charAt(0)||s2.charAt(0)>57)
{ System.out.println("INVALID PLACES !!!!!");chance++;}
  
else if(48>s3.charAt(0)||s3.charAt(0)>57)
{ System.out.println("INVALID PLACES !!!!!"); chance++;
}
   
else if(48>s4.charAt(0)||s4.charAt(0)>57)
{System.out.println("INVALID PLACES !!!!!");chance++;}
else
    
{ y1=s2.charAt(0) - 48;
         x2=s3.charAt(0) - 48;
    x1=s1.charAt(0) - 48;
          y2=s4.charAt(0) - 48;
        
  
    
    if((x1<0)||(x1>=8)||(y1<0)||(y1>=8)||(x2<0)||(x2>=8)||(y2<0)||(y2>=8))
    { System.out.println("INVALID PLACES !!!!!");
       
        chance++;
    }
    else if(b.a[x1][y1]==null)
    { System.out.println("there is no object at this place");
       
        chance++;
    }
    else if(b.a[x1][y1].colour!=q-1)
    {
        System.out.println("THIS IS NOT YOUR PIECE");
        chance++;
    }
    else  
    {     
        move2n(x1,y1,x2,y2);
    }
}  
 //chance++;  
printb();
chance++;
 q=chance%2;
 q++;
System.out.println("CHANCE IS OF PLAYER"+q);

if(check()==true)
{System.out.println("YOU ARE IN A CHECK initial check before move");
if(checkmate()==true)
{  System.out.println("CHECKMATE !!!!!!!!!!!!"); test=1; break;}
else
    System.out.println("NO CHECKMATE");
}
System.out.println("ENTER INITIAL POSITIONS:");
s1=scan.next();
s2=scan.next();
System.out.println("ENTER FINAL POSITIONS");
s3=scan.next();
s4=scan.next();
        }

}

//MOVE
public static void move2(int x,int y,int r ,int c)
{ int c1=-1,c2=-1;
  boolean e = false;
  
	if(b.a[r][c]!=null)               //check if final position is empty
	{
	 c1=b.a[x][y].colour;
	 c2=b.a[r][c].colour;
	if(c1!=c2)                        //check enemy
	{
		e=true;
	}
	else 
	{ //System.out.println("THIS MOVE IS INVALID CONTAINS A PIECE OF YOURS");
		return;
	}
   }
   
   if(q==1)
   {
      if(leap(b.a[x][y],r,c)==true)
      { 
        ch =   p1.move1(b.a[x][y],r,c,e);
        if(ch==-1)
        {//System.out.println("invalid not legal");
            flag=0;
          return;
        }
	else if(ch==0)
	{
		p1.set1(b.a[x][y],r,c);
		updateb(x,y,r,c);
	}
	else
	{
		p1.set1(b.a[x][y],r,c);
		kill(r,c);
		updateb(x,y,r,c);
	}
      }

      else
      {
          return;
       }
    }
  else
  {
      if(leap(b.a[x][y],r,c)==true)
         { 
            ch =p2.move1(b.a[x][y],r,c,e);
            if(ch==-1)
            {
                flag=0;
                return;
            }
            else if(ch==0)
	     { 
		p2.set1(b.a[x][y],r,c);
		updateb(x,y,r,c);
	     }
	    else
	   {
	 	p2.set1(b.a[x][y],r,c);
		kill(r,c);
		updateb(x,y,r,c);
	   }
         }

     else
      {

          return;
      }
   }
   if(check()==true)
   {
       revert(x,y,r,c);
   }
   else 
   { 
       flag=1;
   }
}
//move for player
public static void move2n(int x,int y,int r ,int c)
{ int c1=-1,c2=-1;
  boolean e = false;
	if(b.a[r][c]!=null)               //check if final position is empty
	{
	 c1=b.a[x][y].colour;            //check enemy
	 c2=b.a[r][c].colour;
         if(c1!=c2)                       
	{
		e=true;
	}
	else 
	{ System.out.println("THIS MOVE IS INVALID CONTAINS A PIECE OF YOURS");
           chance++;
		return;
	}
   }
   
   if(q==1)                                  //player1 
   {
      if(leap(b.a[x][y],r,c)==true)
      { 
        ch =   p1.move1(b.a[x][y],r,c,e);
        if(ch==-1)
        {
            System.out.println("invalid move");
           chance++;
          return;
        }
	else if(ch==0)
	{
		p1.set1(b.a[x][y],r,c);
		updateb(x,y,r,c);
	}
	else
	{
		p1.set1(b.a[x][y],r,c);
		kill(r,c);
		updateb(x,y,r,c);
	}
      }

      else
      {
	  System.out.println("THERE IS A LEAP ");
          chance++;
          return;
       }
    }
  else
  {                                    //player2
      if(leap(b.a[x][y],r,c)==true)
         {    
             ch =   p2.move1(b.a[x][y],r,c,e);
       
            if(ch==-1)
            {System.out.println("invalid not legal");
            chance++;
            }
            else if(ch==0)
	     { 
		p2.set1(b.a[x][y],r,c);
		updateb(x,y,r,c);
	     }
	    else
	   {
	 	p2.set1(b.a[x][y],r,c);
		kill(r,c);
		updateb(x,y,r,c);
	   }
         }

     else
      {
	  System.out.println("THERE IS A LEAP. SO INVALID MOVE");
          chance++;
          return;
      }
  }
   if(check()==true)                     //in case there remains a check...revert
   {  //printb();
       revert(x,y,r,c);
       chance++;
   }
   else 
   {  flag=1;
       //System.out.println("YOU ARE NOt IN CHECK RIGHT NOW");
}
}
public static boolean c2(int e,int f)        //returns false if all 16 pieces ofp2 can't move there
{ int u,v;
flag=0;         if(p2.qa.alive==true)
               {
                u = p2.qa.x;    //QUEEN
		v = p2.qa.y;
                move2(u,v,e,f);
               
                if(flag==1)
                {   revert(u,v,e,f);
                    return true;
                }
               }
             if(p2.ra1.alive==true)
             {
	        u = p2.ra1.x;    //rooks
		v = p2.ra1.y;
		move2(u,v,e,f);
           
                if(flag==1)
                {    revert(u,v,e,f);
                    return true;
                }
             }
             if(p2.ra2.alive==true)
             {
	        u = p2.ra2.x;    
		v = p2.ra2.y;
		move2(u,v,e,f);
             
                if(flag==1)
                {   revert(u,v,e,f);
                    return true;
                }
             }
             if(p2.kna1.alive==true)
             {
	        u = p2.kna1.x;   //KNIGHTS
		v = p2.kna1.y;
		move2(u,v,e,f);
           
                if(flag==1)
                {    revert(u,v,e,f); 
                    return true;
                }
             }
             if(p2.kna2.alive==true)
             {
	        u = p2.kna2.x;    
		v = p2.kna2.y;
		move2(u,v,e,f);
         
                if(flag==1)
                {       revert(u,v,e,f); 
                    return true;
                }
             }
             if(p2.ba1.alive==true)
             {
	        u = p2.ba1.x;    //BISHOPS
		v = p2.ba1.y;
		move2(u,v,e,f);
              
                if(flag==1)
                {  revert(u,v,e,f); 
                    return true;
                }
             }
             if(p2.ba2.alive==true)
             {
	        u = p2.ba2.x;    
		v = p2.ba2.y;
		move2(u,v,e,f);
             
                if(flag==1)
                {   revert(u,v,e,f); 
                    return true;
                }
             }
	    for(k=0;k<8;k++)
		{
                    if(p2.pa[k].alive==true)
                    {
		u = p2.pa[k].x;    //pawn
		v = p2.pa[k].y;
		move2(u,v,e,f);
             
                if(flag==1)
                {   revert(u,v,e,f); 
                    return true;
                }
                    }
		}  
            return false;
}
public static boolean c1(int e,int f)        //returns false if all 16 pieces ofp2 can't move there
{     flag=0;
      int u,v;
               if(p1.qa.alive==true)
               {
                u = p1.qa.x;    //QUEEN
		v = p1.qa.y;
		move2(u,v,e,f);
               
                if(flag==1)
                { revert(u,v,e,f);
                    return true;
                }
               }
               if(p1.ra1.alive==true)
               {
	         u = p1.ra1.x;    //rooks
		 v = p1.ra1.y;
		move2(u,v,e,f);
               
                if(flag==1)
                { revert(u,v,e,f);
                    return true;
                }
               }
               if(p1.ra2.alive==true)
               {
	        u = p1.ra2.x;    
		v = p1.ra2.y;
		move2(u,v,e,f);
                
                if(flag==1)
                {revert(u,v,e,f);
                    return true;
                }
               }
               if(p1.kna1.alive==true)
               {
	        u = p1.kna1.x;    //KNIGHTS
		v = p1.kna1.y;
		move2(u,v,e,f);
               
                if(flag==1)
                { revert(u,v,e,f);
                    return true;
                }
               }
               if(p1.kna2.alive==true)
               {
	        u = p1.kna2.x;    
		v = p1.kna2.y;
		move2(u,v,e,f);
              
                if(flag==1)
                {  revert(u,v,e,f);
                    return true;
                }
               }
               if(p1.ba1.alive==true)
               {
	        u = p1.ba1.x;    //BISHOPS
		v = p1.ba1.y;
		move2(u,v,e,f);
                
                if(flag==1)
                {revert(u,v,e,f);
                    return true;
                }
               }
               if(p1.ba2.alive==true)
               {
	        u = p1.ba2.x;    
		v = p1.ba2.y;
		move2(u,v,e,f);
                
                if(flag==1)
                {revert(u,v,e,f);
                    return true;
                }
               }
	    for(k=0;k<8;k++)
		{
                    if(p1.pa[k].alive==true)
                    {
		u = p1.pa[k].x;    //pawn
		v = p1.pa[k].y;
		move2(u,v,e,f);
                
                if(flag==1)
                {revert(u,v,e,f);
                    return true;
                }
                    }
		}
            
            return false;
}
//KILL KILL.......
public static void kill(int r,int c)
{
	b.a[r][c].alive=false;
        kd = b.a[r][c];
        System.out.println("THE KILlED HAS PIECE TYPE :"+b.a[r][c].type+"and colour"+b.a[r][c].colour);
	b.a[r][c]=null;
}

//UPDATE BOARD FUNCTION
public static void updateb(int x,int y,int r,int c)
{
	b.a[r][c]=b.a[x][y];
       // System.out.println("NOW THE PIECE AT "+r+":"+c+" HAS type: "+b.a[r][c].type+"and colour:"+b.a[r][c].colour);
	b.a[x][y]=null;
       //if(b.a[x][y]!=null)
        //System.out.println("WARNING !!!!!!!! THERE IS A PIECE AT "+x+":"+y);
	
}
// REVERT A MOVE 
public static void revert(int xi,int yi,int xf,int yf)
{
    b.a[xi][yi]=b.a[xf][yf];
    if(q==1)
    {
     p1.set1(b.a[xi][yi],xi,yi);   //update piece1
    }
    else
    {
       p2.set1(b.a[xi][yi],xi,yi);  
    }
     //System.out.println("AFTER REVERT PIECE AT "+xi+":"+yi+"is"+b.a[xi][yi].type+":"+b.a[xi][yi].colour);
    if(kd!=null)         //in case a piece was killed
  {
      //System.out.println("PIECE KILLED INITIALLY");
      kd.alive=true;
      b.a[xf][yf]=kd;
     //System.out.println("AFTER REVERT PIECE AT "+xf+":"+yf+"is"+b.a[xf][yf].type+":"+b.a[xf][yf].colour);
      kd=null;
       if(q==1)
    {
     p1.set1(b.a[xf][yf],xf,yf);   //update piece2
    }
    else
    {
       p2.set1(b.a[xf][yf],xf,yf);  
    }
  }
    else                     //in case it was empty
  {
      b.a[xf][yf]=null;
  }
  
}
//CHECHMATE FUNCTION 
public static boolean checkmate()
{
    kd=null;
    if(moveking()==false)  //if king can move anywhere
        return false;
    if(killchecker()==true)  
        return false;   //checker can be killed
    if(leap2(b.a[ex][ey].type)==true)    //if any piece can come in leap
        return false;
    
    return true;
}
//PRINTING BOARD
public static void printb()
{  int y=0,k=0;
	int i,j=0;
        for(i=0;i<8;i++)
            System.out.print("     "+i);
        System.out.println();
	for(i=0;i<8;i++)
	{  System.out.print(i+"   ");
           
		for(j=0;j<8;j++)
		{ 
			if(b.a[i][j]==null)
				System.out.print("--    ");
			else
			{ switch(b.a[i][j].colour)
                        {
                            case 0 :System.out.print("b");
                                    break;
                            case 1 :System.out.print("w");
                        }
				switch(b.a[i][j].type)
				{
					case 1:
					System.out.print("p    ");
					break;
					case 2:
					System.out.print("k    ");
					break;
					case 3:
					System.out.print("q    ");
					break;
					case 4:
					System.out.print("r    ");
					break;
					case 5:
					System.out.print("b    ");
					break;
					case 6:
					System.out.print("n    ");
					break;
					
				}
			}
		}
                //y=1;
		System.out.println("");
                System.out.println();
	}
}

//LEAP CHECKER
public static boolean leap(piece p,int r,int c)
{
	int tr = p.type;
	boolean t=true;
	switch(tr)
	{
		case 1:   //PAWN
	
		{
		 if(Math.abs(c-p.y)==2)
               {
			 if(c>p.y)
			 {
			 if(b.a[p.x][p.y+1]!=null)
			 t=false;
			 }
			 else
			 {
				 if(b.a[p.x][p.y-1]!=null)
					 t=false;
			 }
		 }
        		 
		}
		break;
		case 2:          //KING
		break;
		case 3:          //QUEEN
		{
			if(Math.abs(p.x-r)==Math.abs(p.y-c))
			{
				if(r>p.x)
				{
					if(c>p.y)
					{
					k=p.y+1;	//RD
					 for(j=p.x+1;j<r;j++,k++)
                                        { 
				       if(b.a[j][k]!=null)
					   {t= false ; break;}
					 }				 
						
					}
					else
					{
						//Ld
						k= p.y-1;
						for(j=p.x+1;j<r;j++,k--)
						{
							if(b.a[j][k]!=null)
							{
								t= false ; break;
							}
						}
					}
				}
				else
				{
					if(c>p.y)
					{
						//ru
						j= p.x-1;
						for(k=p.y+1;k<c;k++,j--)
						{
							if(b.a[j][k]!=null)
							{
								t=false;
								break;
							}
						}
					}
					else{
						
						//Lu
						k=p.y-1;
						for(j=p.x-1;j>r;j--,k--)
						{
							if(b.a[j][k]!=null)
							{
								t=false;
								break;
							}
						}
					}
				}
				
			}
			
			else if(p.x==r)
			{
				if(p.y<c)
				{
					//up
					for(j=p.y+1;j<c;j++)
					{if(b.a[p.x][j]!=null)
						{	t=false;
						break;
						}
					}
				}
				else
				{
					//downy
					for(j=p.y-1;j>c;j--)
					{
						if(b.a[p.x][j]!=null)
						{	t=false;
						break;
						}
					}
				}
			}
			else 
			{
				if(p.x<r)
				{  
			      //right
				  for(j=p.x+1;j<r;j++)
				  {
					  if(b.a[j][p.y]!=null)
					  {
						  t=false;
						break;
						  
					  }
				  }
					
				}
				else
				{
					//left
					for(j=p.x-1;j>r;j--)
				  {
					  if(b.a[j][p.y]!=null)
					  {
						  t=false;
						break;
						  
					  }
				  }
					
				}
			}
			
		}
		break;
		case 4:           //ROOK
		{
			if(p.x==r)
			{
				if(p.y<c)
				{
					//up
					for(j=p.y+1;j<c;j++)
					{if(b.a[p.x][j]!=null)
						{	t=false;
						break;
						}
					}
				}
				else
				{
					//downy
					for(j=p.y-1;j>c;j--)
					{
						if(b.a[p.x][j]!=null)
						{	t=false;
						break;
						}
					}
				}
			}
			else 
			{
				if(p.x<r)
				{  
			      //right
				  for(j=p.x+1;j<r;j++)
				  {
					  if(b.a[j][p.y]!=null)
					  {
						 t=false;
						break;
						  
					  }
				  }
					
				}
				else
				{
					//left
					for(j=p.x-1;j>r;j--)
				  {
					  if(b.a[j][p.y]!=null)
					  {
						  t=false;
						break;
						  
					  }
				  }
					
				}
			}
		}
		break;
		case 5:                           //BISHOP
		{
                    if(r>p.x)
				{
					if(c>p.y)
					{
					k=p.y+1;	//RD
					 for(j=p.x+1;j<r;j++,k++)
                                        { 
				       if(b.a[j][k]!=null)
					   {t= false ; break;}
					 }				 
						
					}
					else
					{
						//Ld
						k= p.y-1;
						for(j=p.x+1;j<r;j++,k--)
						{
							if(b.a[j][k]!=null)
							{
								t= false ; break;
							}
						}
					}
				}
				else
				{
					if(c>p.y)
					{
						//ru
						j= p.x-1;
						for(k=p.y+1;k<c;k++,j--)
						{
							if(b.a[j][k]!=null)
							{
								t=false;
								break;
							}
						}
					}
					else{
						
						//Lu
						k=p.y-1;
						for(j=p.x-1;j>r;j--,k--)
						{
							if(b.a[j][k]!=null)
							{
								t=false;
								break;
							}
						}
					}
				}
			
			
		}
		break;
		case 6:          //KNIGHT
		break;		
	}
	return t;
}


public static boolean check()
{int kx,ky;
int u,v,k;
	if(q==2)
	{   //ka,qa,ra1,ra2,kna1,kna2,ba1,ba2,kb,qb,rb1,rb2,knb1,knb2,bb1,bb2;
		kx=p2.ka.kbx;  //WHITE KING....
	        ky=p2.ka.kby;
                if(p1.ka.alive==true)
                {
                    u=p1.ka.kax;
                    v=p1.ka.kay;
                   if(helpchecker(u,v,kx,ky)==true)
		{ 
                    ex=u;
                    ey=v;
		return true;
		} 
                }
		if(p1.qa.alive==true)
                {    
                u = p1.qa.x;    //QUEEN
		v = p1.qa.y;
               
		if(helpchecker(u,v,kx,ky)==true)
		{ 
                    ex=u;
                    ey=v;
		return true;
		}
                }
	         if(p1.ra1.alive==true)
                 {
                u = p1.ra1.x;    //rooks
		 v = p1.ra1.y;
		if(helpchecker(u,v,kx,ky)==true)
		{ ex=u;
                  ey=v;
		 return true;
		}
                 }
                 if(p1.ra2.alive==true)
                 {
	        u = p1.ra2.x;    
		v = p1.ra2.y;
		if(helpchecker(u,v,kx,ky)==true)
		{   ex=u;
                    ey=v;
		 return true ;
	 	}
                 }
                 if(p1.kna1.alive==true)
                 {
	        u = p1.kna1.x;    //KNIGHTS
		v = p1.kna1.y;
		if(helpchecker(u,v,kx,ky)==true)
		{   ex=u;
                    ey=v;
		 return true;
		}
                 }
                 if(p1.kna2.alive==true)
                 {
	        u = p1.kna2.x;    
		v = p1.kna2.y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                    ex=u;
                    ey=v;
		 return true ;
		}
                 }
                 if(p1.ba1.alive==true)
                 { u = p1.ba1.x;    //BISHOPS
		v = p1.ba1.y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                     ex=u;
                    ey=v;
		 return true ;
		}}
                 if(p1.ba2.alive==true)
                 {
	        u = p1.ba2.x;    
		v = p1.ba2.y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                     ex=u;
                    ey=v;
		 return true;
		}
                 }
	    for(k=0;k<8;k++)
		{
                    if(p1.pa[k].alive==true)
                    {
		u = p1.pa[k].x;    //pawn
		v = p1.pa[k].y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                     ex=u;
                     ey=v;
		 return true;
		}
                    }
		}
			
	}
	
	else
	{
		//ka,qa,ra1,ra2,kna1,kna2,ba1,ba2,kb,qb,rb1,rb2,knb1,knb2,bb1,bb2;
		kx=p1.ka.kax;  //BLACK KING....
	        ky=p1.ka.kay;
                if(p2.ka.alive==true)
                {
                    u=p2.ka.kbx;
                    v=p2.ka.kby;
                    if(helpchecker(u,v,kx,ky)==true)
		{    ex=u;
                     ey=v;
		return true;
		}
                    
                }
		if(p2.qa.alive==true)
                {
                u = p2.qa.x;    //QUEEN
		v = p2.qa.y;
		if(helpchecker(u,v,kx,ky)==true)
		{    ex=u;
                     ey=v;
		return true;
		}
                }
                if(p2.ra1.alive==true)
                {
	        u = p2.ra1.x;    //rooks
		v = p2.ra1.y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                    ex=u;
                     ey=v;
		 return true;
		}
                }
                if(p2.ra2.alive==true)
                {
	        u = p2.ra2.x;    
		v = p2.ra2.y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                    ex=u;
                     ey=v;
		 return true ;
		}
                }
                if(p2.kna1.alive==true)
                {
	        u = p2.kna1.x;    //KNIGHTS
		v = p2.kna1.y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                    ex=u;
                     ey=v;
		 return true ;
		}
                }
                if(p2.kna1.alive==true)
                {
	        u = p2.kna2.x;    
		v = p2.kna2.y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                    ex=u;
                     ey=v;
		 return true;
		}
                }
                if(p2.ba1.alive==true)
                {
	        u = p2.ba1.x;    //BISHOPS
		v = p2.ba1.y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                    ex=u;
                     ey=v;
		 return true ;
		}
                }
                if(p2.ba2.alive==true)
                {
	        u = p2.ba2.x;    
		v = p2.ba2.y;
		
		if(helpchecker(u,v,kx,ky)==true)
		{
                    ex=u;
                     ey=v;
		 return true;
		}
                }
	    for(k=0;k<8;k++)
		{
                    if(p2.pa[k].alive==true)
                    {
		u = p2.pa[k].x;    //pawn
		v = p2.pa[k].y;
		if(helpchecker(u,v,kx,ky)==true)
		{
                    ex=u;
                     ey=v;
		 return true;
		}
                    }
		}
	}
        return false;
}
public static boolean helpchecker(int xi,int yi,int kx,int ky)    //for every piece if move is legal
{
	boolean value = false;
	int c1;
	if(q==1)
	c1=p1.move1(b.a[xi][yi],kx,ky,true);
        else
	c1=p2.move1(b.a[xi][yi],kx,ky,true);
	if(c1==1)
	{   if(leap(b.a[xi][yi],kx,ky)==true)
			 value = true;
	}
	 return value;
		 
}
//checkmate

//1.move king-all possible
//check==false
//king kill
public static boolean moveking()    //returns false if valid move is there
{ System.out.println("IN FUNCTION MOVE KING.....");
   flag=0;
   int kx,ky;
    if(q==2)
    {
        kx=p2.ka.kbx;  //WHITE KING....
        ky=p2.ka.kby;
    }   
else
    {
        kx=p1.ka.kax;  //BLACK KING....
	ky=p1.ka.kay;
    }
//CHECKS WHETHER KING CAN MOVE TO THE 8 adjacent places...
        if(kx-1>=0)
        {
            move2(kx,ky,kx-1,ky);
           
           if(flag==1)
           {
            revert(kx,ky,kx-1,ky);
            return false;
           }
        }
        //r
        if(kx+1<=7)
        { move2(kx,ky,kx+1,ky);
          if(flag==1)
          {revert(kx,ky,kx+1,ky);
              return false;
          
           }
        }
        
        //u
        if(ky-1>=0)
        {
           move2(kx,ky,kx,ky-1);
           
          if(flag==1)
          {revert(kx,ky,kx,ky-1);
              return false;
          
           }
        }
        //d
        if(ky+1<=7)
        {
           move2(kx,ky,kx,ky+1);
         
          if(flag==1)
          {  revert(kx,ky,kx,ky+1);
              return false;
          
           }
        }
        //lu
        if(kx-1>=0&&ky-1>=0)
        {
            move2(kx,ky,kx-1,ky-1);
             
          if(flag==1)
          {revert(kx,ky,kx-1,ky-1);
              return false;
          
           }
        }
        //ld
        if(kx-1>=0&&ky+1<=7)
        {
            move2(kx,ky,kx-1,ky+1);
            
         if(flag==1)
          {revert(kx,ky,kx-1,ky+1);
              return false;
          
           }
        }
        //ru
        if(kx+1<=7&&ky-1>=0)
        {
            move2(kx,ky,kx+1,ky-1);
            
          if(flag==1)
          {revert(kx,ky,kx+1,ky-1);
              return false;
          
           }
        }
        //rd
         if(kx+1<=7&&ky+1<=7)
        {
            move2(kx,ky,kx+1,ky+1);
            
          if(flag==1)
          {revert(kx,ky,kx+1,ky+1);
              return false;
          
           }
        }
         return true; 
    }

   public static boolean killchecker() 
 //returns true if checker can be killed
{int u,v;
System.out.println("THERE IN FUNCTION KILL CHECKER");       //to test if any of 16 pieces can kill the checker
flag=0;
    if(q==2)   //player b
    {
        if(c2(ex,ey)==true)
            return true;
		
	}
      else
    {
          if(c1(ex,ey)==true)
            return true;		
        
    }
return false;
}

 public static boolean leap2(int t)    //true if object can come in leap of king and checker..
   { int kx,ky;
      int e,f,u,v;
       flag=0;
       System.out.println("IN function leap2........");
  switch(t)
   {
       //rook
  case 4:
  {//rook player 2
       if(q==2)
     {
        kx=p2.ka.kbx;  //WHITE KING....
        ky=p2.ka.kby;
        if(ex>kx&&ky==ey)
        { e=kx+1;
          f=ey;
            for(i=e;i<ex;i++,e++)
            {
                if(c2(e,f)==true)
                    return true;
            }
         }
        if(ex<kx&&ky==ey)
        {
            e=ex+1;
            f=ey;
            for(i=e;i<kx;i++,e++)
            {
	        if(c2(e,f)==true)
                    return true;
            } 
        }
       //left
       if(ex==kx&&ey<ky)
       { e=ex;
         f=ey+1;
        for(i=f;i<ky;i++,f++)
            {
	   if(c2(e,f)==true)
             return true;     
           } 
       }
       //right
       if(ex==kx&&ey>ky)
       {e=ex;
         f=ky+1;
          for(i=f;i<ey;i++,f++)
            {
               if(c2(e,f)==true)
                return true;
            }
        }
    }
     
     //ROOK PLAYER 1
     else
     {
         kx=p1.ka.kax;  //BLACK KING....
	 ky=p1.ka.kay;
          if(ex>kx&&ky==ey)
         { e=kx+1;
          f=ey;
            for(i=e;i<ex;i++,e++)
            {
             if(c1(e,f)==true)
                 return true;
            }
         }
          if(ex<kx&&ky==ey)
        {
            e=ex+1;
            f=ey;
            for(i=e;i<kx;i++,e++)
            {
                if(c1(e,f)==true)
                 return true; 
            } 
                
         }
    if(ex==kx&&ey<ky)
       { e=ex;
         f=ey+1;
        for(i=f;i<ky;i++,f++)
            {      
               if(c1(e,f)==true)
                 return true;          
            }
       }
       
    
    if(ex==kx&&ey>ky)
       {e=ex;
         f=ky+1;
          for(i=f;i<ey;i++,f++)
            {
               if(c1(e,f)==true)
                 return true;                
            }
       }
   }
 }
  break;
//BISHOP
  case 5:
  {   //bishop player 2
        if(q==2)
        {     
        kx=p2.ka.kbx;  //WHITE KING....
        ky=p2.ka.kby;
         if(kx>ex)
	    {
		if(ky>ey)
                {
		  f=ey+1;	//RD
		   for(e=ex+1;e<kx;e++,f++)
                    {                  
                      if(c2(e,f)==true)                      
                     return true;
		     }                	      
		}				 
						
		else
		{
		 //Ld
		   f= ey-1;
		   for(e=ex+1;e<kx;e++,f--)
		   {
		     if(c2(e,f)==true)                      
                     return true;
                       
		   }
		}
	   }
      else
       {
	 if(ky>ey)
	  {			//ru
             e= ex-1;
	     for(f=ey+1;f<ky;f++,e--)
	    {			//all pieces valid move in either and chech stopped
               if(c2(e,f)==true)                      
                     return true;
	    }
          }
	 else
         {
		//Lu
	   f=ey-1;
	   for(e=ex-1;e>kx;e--,f--)
	    {
	      	if(c2(e,f)==true)                      
                     return true;		
	    }
	  }
        }
        }
        
        
    else
    {
            //player 1 BISHOP 
         kx=p1.ka.kax;  //BLACK KING....
	 ky=p1.ka.kay;
         
          if(kx>ex)
	    {
		if(ky>ey)
                {
		  f=ey+1;	//RD
		  for(e=ex+1;e<kx;e++,f++)
                    {                  
                      if(c1(e,f)==true)                      
                     return true;
                   
                     }
                }
          
                else
		{
		 //Ld
		   f= ey-1;
		   for(e=ex+1;e<kx;e++,f--)
		   {
                    if(c1(e,f)==true)                      
                     return true;
                    }
                 
                }
            }
               
           else
           {
	       if(ky>ey)
                {
						//ru
                 e= ex-1;
                 for(f=ey+1;f<ky;f++,e--)
        	 {  
                    if(c1(e,f)==true)                      
                     return true;
                 }
        
                }
           
                else
                 {
		//Lu
                  f=ey-1;
                   for(e=ex-1;e>kx;e--,f--)
                   {
                    if(c1(e,f)==true)                      
                     return true;
                  
		    }
                 }
            
             }    
          
         }       
    
    }
break;  
 //Queen.......
 
  case 3:
  {//player 2 queen
      if(q==2)
      {    kx=p2.ka.kbx;  //WHITE KING....
           ky=p2.ka.kby;
        if(Math.abs(ex-kx)==Math.abs(ey-ky))
	 {//LikE BISHOP...
        
            if(kx>ex)
                {
                    if(ky>ey)
                    {
                         f=ey+1;	//RD
                        for(e=ex+1;e<kx;e++,f++)
                         {                  
                                            
                            if(c2(e,f)==true)                      
                                return true;
                         }				 
                    }
                    else
                    {
                    //Ld
                         f= ey-1;
                         for(e=ex+1;e<kx;e++,f--)
                        {
                            if(c2(e,f)==true)                      
                             return true;
                        }
                    }
                 }
           else
                {
                    if(ky>ey)
                    {
                        e= ex-1;
                        for(f=ey+1;f<ky;f++,e--)
                        {
			   if(c2(e,f)==true)                      
                                return true;
                         }
                    }
                    else
                    {
                	//Lu
                        f=ey-1;
                        for(e=ex-1;e>kx;e--,f--)
                        {
	      		  if(c2(e,f)==true)                      
                           return true;		
                        }
                    }
                 }
         }
	else
      {
         kx=p2.ka.kbx;  //WHITE KING....
         ky=p2.ka.kby;
            if(ex>kx&&ky==ey)
            {   e=kx+1;
                f=ey;
                for(i=e;i<ex;i++,e++)
                {
                
                    if(c2(e,f)==true)                      
                    return true;
		}   
            }

        if(ex<kx&&ky==ey)
        {
            e=ex+1;
            f=ey;
            for(i=e;i<kx;i++,e++)
            {
               if(c2(e,f)==true)                      
                return true;

             }
        }
       //left
       if(ex==kx&&ey<ky)
       { e=ex;
         f=ey+1;
        for(i=f;i<ky;i++,f++)
            {
                if(c2(e,f)==true)                      
                return true;
		} 
           
       }
       //right
       if(ex==kx&&ey>ky)
       {e=ex;
         f=ky+1;
          for(i=f;i<ey;i++,f++)
            {
                if(c2(e,f)==true)                      
                 return true;
	    }
        }
   
      }
        
   }
 
 else
 { //player 1 queen...
     //like bishop
         kx=p1.ka.kax;  //BLACK KING....
	 ky=p1.ka.kay;
     if(Math.abs(ex-kx)==Math.abs(ey-ky))
	{//LikE BISHOP...
           if(kx>ex)
	    {
		if(ky>ey)
                {
		  f=ey+1;	//RD
		  for(e=ex+1;e<kx;e++,f++)
                    {                  
                       if(c1(e,f)==true)                      
                        return true;
		    } 
                   
                }
                
          
                else
		{
		 //Ld
		   f= ey-1;
		   for(e=ex+1;e<kx;e++,f--)
		   {
                            if(c1(e,f)==true)                      
                                return true;
                  
                   
                    }
                       
                       
                   }
                }
               
           else
           {
	   if(ky>ey)
	      {
						//ru
		e= ex-1;
                for(f=ey+1;f<ky;f++,e--)
                {     
                    if(c1(e,f)==true)                      
                     return true;
  
                }
        
             }
           
        else
        {
		//Lu
	f=ey-1;
	for(e=ex-1;e>kx;e--,f--)
	{
            
                if(c1(e,f)==true)                      
                return true;
            
        }    
          
        }
       }
        }
     else
     {
         kx=p1.ka.kax;  //BLACK KING....
	 ky=p1.ka.kay;
          if(ex>kx&&ky==ey)
         { e=kx+1;
          f=ey;
            for(i=e;i<ex;i++,e++)
            {
                 if(c1(e,f)==true)                      
                return true;
                
            }
         }
          
          if(ex<kx&&ky==ey)
        {
            e=ex+1;
            f=ey;
            for(i=e;i<kx;i++,e++)
            {
                if(c1(e,f)==true)                      
                return true;
                
                
            }
        }
    if(ex==kx&&ey<ky)
       { e=ex;
         f=ey+1;
        for(i=f;i<ky;i++,f++)
            {      
               if(c1(e,f)==true)                      
                 return true;          
              
            }
       }
    if(ex==kx&&ey>ky)
       {e=ex;
         f=ky+1;
          for(i=f;i<ey;i++,f++)
            {
                if(c1(e,f)==true)                      
                 return true;               
               
            }
       }
 
     }

 }
  }
  break;
   }
  return false;  
 }
   
}