package utilities;

import java.io.File;

import javax.swing.JFileChooser;

public class ClickableObjects {

	public static void main(String[] args) {
		System.out.println("Displaying the application.");
	}
	
	public static String openFile(){
		JFileChooser fileChooser = new JFileChooser();
		String fileSelectedOnClick = "";
		int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          fileSelectedOnClick =  selectedFile.getAbsolutePath();
          System.out.println(selectedFile.getName());
        }
        return fileSelectedOnClick;
	}

}
