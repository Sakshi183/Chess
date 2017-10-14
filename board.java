/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication8;
import java.util.*;
import java.io.*;
/**
 *
 * @author shivanshsharma
 */
public class board {
    public static piece a[][] = new piece[8][8];
	board()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				a[i][j] = null;
				
			}
		}
	}
    
}
