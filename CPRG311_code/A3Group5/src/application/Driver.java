package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import exceptions.TreeException;
import manager.WordTracker;

public class Driver {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, TreeException {
//		System.out.println(args[0]);
//		System.out.println(args[1]);
//		System.out.println(args[2]);
//		System.out.println(args[3]);
		String fileLocation=args[0];
		String order=args[1];
		String lineNum=args[2];
		String frequency=args[3];
		String file=args[4];
		String output=args[5];
		
		if(fileLocation!=null && order!=null && lineNum !=null && frequency!=null) {
			if(order.equals("-pf") && lineNum.equals("-pl")&& frequency.equals("-po")) {
				if(file.equals("-f")&& output!=null) {
					File fileName = new File(output); 
					FileOutputStream fos = new FileOutputStream(fileName);
					PrintStream ps = new PrintStream(fos);
					System.setOut(ps);
					new WordTracker(fileLocation);
				}else if(!file.equals("-f")&& output!=null) {
					System.out.println("Please enter -f command!");
				}else {
					new WordTracker(fileLocation);
				}
				
			}else if(!order.equals("-pf")) {
				System.out.println("Please enter -pf command!");
			}else if(!lineNum.equals("-pl")) {
				System.out.println("Please enter -pl command");
			}else if(!frequency.equals("-po")) {
				System.out.println("Please enter -po command");
			}else {
				System.out.println("Please enter correct command!");
			}
		}else {
			System.out.println("Please enter correct command!");
		}
		
		
		
	}

}
