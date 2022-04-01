package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;

public class XmlParser {
	
	
	public XmlParser() throws FileNotFoundException{
		init();
	}
	
	
	private void loadFileAndParse(String filePath) throws FileNotFoundException {
		Scanner in=new Scanner(new File(filePath));
		while(in.hasNext()) {
			String eachline = in.nextLine();
			int leftSign=eachline.indexOf("<");
			String leftMod=eachline.substring(leftSign);
//			System.out.println(leftMod);
			if(leftMod.lastIndexOf("<")>0) {
				System.out.println("ERROR");
			}else {
				//> sign
				int rightSign=leftMod.indexOf(">");
				int spaceSign=leftMod.indexOf(" ");
//				System.out.println(leftMod);
				String rightModString;
				if (leftMod.charAt(rightSign-1)=='/') {
					if(leftMod.contains(" ")) {
						rightModString=leftMod.substring(0,spaceSign)+"/>";
					}else {
						rightModString=leftMod;
					}	
				}else {
					if(leftMod.contains(" ")) {
						rightModString=leftMod.substring(0,spaceSign)+">";
					}else {
						rightModString=leftMod;
					}	
				}
				System.out.println(rightModString);
				
			}
		}
			
		in.close();
	}
	
	public void init() throws FileNotFoundException {
		 Scanner input=new Scanner(System.in);
		 System.out.print("Enter your file path: ");
		 String line = input.nextLine();
		 loadFileAndParse(line);
	}
	
	
}
