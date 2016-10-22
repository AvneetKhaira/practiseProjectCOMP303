package utilities;

import java.io.File;

import javax.swing.JFileChooser;

public class ClickableObjects {

	public static void main(String[] args) {
		System.out.println("Displaying the application.");
	}
	
	public static File openFile(){
		JFileChooser fileChooser = new JFileChooser();
		File fileSelectedOnClick = null;
		int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          fileSelectedOnClick =  selectedFile;
          System.out.println(fileSelectedOnClick.getName());
        }
        return fileSelectedOnClick;
	}

}
