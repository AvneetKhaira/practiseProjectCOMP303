package ServletPackage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
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
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		try {
			FileInputStream fis = new FileInputStream(ClickableObjects.openFile());
			 
			//Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		 
			String line = null;
			while ((line = br.readLine()) != null) {
				response.setContentType("text/HTML");
				PrintWriter myOutput = response.getWriter();
				myOutput.println("<!DOCTYPE html>\n <html> \n"+
				"<head><title>Servlet Generating a HTML"+
				"</title></head>\n <body bgcolor=\"#fdf5e6\">\n"+
				"<h1>Test of a servlet Generating Text file </h1> \n"+
				"<p>" + line  + "</p>\n"+
				"</body></html>");
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