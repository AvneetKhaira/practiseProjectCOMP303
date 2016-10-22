package ServletPackage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import utilities.ClickableObjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebServlet("/Browse")
public class Browse extends HttpServlet{
	
String[] huffmanCode = {"100","0010","0011","1111","1110","1100","1011","1010","0110","0101","11011",
            "01111","01001","01000","00011","00010","00001","00000","110101","011101",
            "011100","1101001","110100011","110100001","110100000","1101000101","11010001000"}; 

String[] ascii_value = {"32","97","98","99","100","101","102","103","104","105","106","107","108","109","110",
                    "111","112","113","114","115","116","117","118","119","120","121","122"};
String letters = " abcdefghijklmnopqrstuvwxyz";
char[] letter = letters.toCharArray();
int[] occurence = new int [27];
float [] frequency = new float [27];
int totalSum = 0;	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		try {
			File filedir = new File(ClickableObjects.openFile());
			
			//Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(
					   new InputStreamReader(
			                      new FileInputStream(filedir), StandardCharsets.UTF_8));
			String line = null;
			while ((line = br.readLine()) != null) {
				char[] charText =line.toCharArray();
				for(int i = 0; i<letter.length; i++){
				      
				      for(int c =0; c < charText.length; c++){
				        //letter is found in text
				        if(charText[c] == letter[i]){
				        	occurence[i]+=1;
				        }
				      }
				    
				  	}
				  
				    for(int g = 0; g< occurence.length; g++){
				    	totalSum += occurence[g];
				    }
				   for(int t = 0; t< occurence.length; t++){
				       frequency[t] = (float)occurence[t]/totalSum;
				    }
				    
				      for(int b = 0; b< occurence.length; b++){
				    	System.out.println(letter[b]+"\t"+occurence[b]+"\t"+frequency[b]);
				    }
			}
		 
			br.close();
		} 
		catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage()); //prints exception
        } 
        //Input/Output exception
        catch (IOException ex)
        {
            System.out.println(ex.getMessage()); //prints exception
        }
		
	}
}