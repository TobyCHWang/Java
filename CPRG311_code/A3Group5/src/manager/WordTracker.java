package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.TreeException;
import utilities.BSTree;
import utilities.Iterator;

public class WordTracker {
	
	public WordTracker() throws IOException, TreeException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter file location: ");
		String fileLoc = input.nextLine();
		loadFile(fileLoc);
	}

	private void loadFile(String fileLoc) throws IOException, TreeException {
		File file = new File(fileLoc);
		BufferedReader fin = new BufferedReader(new FileReader(file));
		String line;
		BSTree<String> bsTree = new BSTree<>();

		while ((line = fin.readLine()) != null) {
			if(line.equals("")) {
				continue;
			}else {
				String[] aStrings=parseLine(line);
				System.out.println(aStrings[0]);
				createBsTree(aStrings, bsTree);
				
				
		    }  
        }
		
//		//need to modify
//		Iterator<String> it = bsTree.preorderIterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		fin.close();
		
	}
	
//line
	private String[] parseLine(String line) {
	   String dashString=line.replace("-", " ");
	   String resultString=dashString.replaceAll("\\p{Punct}", "");
	   String[] stringSet=resultString.split(" ");
	   return stringSet;
	}
	
//	create Tree
	private BSTree<String> createBsTree(String[] aStrings, BSTree<String> bsTree){
		for(int i=0;(i<aStrings.length)&&(aStrings[i]!=null);i++) {
			bsTree.add(aStrings[i]);
		}
		return bsTree;
	}
	
	
	
}
