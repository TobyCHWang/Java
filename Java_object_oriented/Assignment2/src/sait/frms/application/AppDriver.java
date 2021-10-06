package sait.frms.application;
/**
 * This class is for driver class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */

import sait.frms.gui.MainWindow;

import java.io.FileNotFoundException;
import java.io.IOException;

import sait.frms.gui.*;

/**
 * Application driver.
 * 
 */
public class AppDriver {

	/**
	 * Entry point to Java application.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		MainWindow mainWindow = new MainWindow();
		mainWindow.display();
	}

}
