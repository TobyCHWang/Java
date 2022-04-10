package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import exceptions.TreeException;
import utilities.BSTree;
import utilities.Iterator;

public class WordTrackerno {
	
	
	public WordTrackerno() throws IOException, TreeException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter file location: ");
		String fileLoc = input.nextLine();
		loadFile(fileLoc);
	}

	private void loadFile(String fileLoc) throws IOException, TreeException {
		ArrayList<Word> bsTree = new ArrayList<>();
		//attribute
		File file = new File(fileLoc);
		BufferedReader fin = new BufferedReader(new FileReader(file));
		String line;
		
//		ArrayList<Word> arrayListWords=new ArrayList<>();
		String[] aStrings;
		ArrayList<String> arrayList = new ArrayList<>();
		ArrayList<String> arrayListIterator = new ArrayList<>();
		
		int frequency;
		long lineNumberCounter = 1;
		List<Long> lineNumbers = new ArrayList<>();
		long count = 0;
		

		while ((line = fin.readLine()) != null) {
			
			if(line.equals("")) {
				continue;
			}else {
				lineNumberCounter++;
				aStrings=parseLine(line);
//				bsTree.add(new Word(line));
				createBsTree(aStrings, bsTree);
				
				createaArrayList(aStrings, arrayList); 
				test("A", aStrings, lineNumberCounter, lineNumbers, count);	
			}				
        }
		
		System.out.println(bsTree.size());
		
//		//line number
//				for(int i=0;i<lineNumbers.size();i++) {
//					System.out.println(lineNumbers.get(i));
//				}
		
		
		//res/textfile.txt
		//iterator
//		getInOrder(bsTree, arrayListIterator);
		
		
		
		
		//frequency
		for(int i=0;i<arrayListIterator.size();i++) {
			frequency=search(arrayList.toArray(), arrayListIterator.get(i));
			System.out.println(arrayListIterator.get(i)+ " count: "+frequency);
		}
		
		fin.close();
		
	}
	
	
	
	//
	private ArrayList<Long> test(String input,String[] words,long lineNumberCounter,List<Long> lineNumbers,long count) {
		 
		for (String word : words) {
             // Search for the given word
             if (word.trim().equals(input)) {
                 count++; // If Present increase the count by one
                 lineNumbers.add(lineNumberCounter);
             }
         }
		 return (ArrayList<Long>) lineNumbers;
     }
		
	
	
	
	
	private ArrayList<String> getInOrder(BSTree<String> bsTree, ArrayList<String> arrayList){
		Iterator<String> it = bsTree.inorderIterator();
		it.next();
		while (it.hasNext()) {
		  String nextString=it.next();	
		  arrayList.add(nextString);
		}
		return arrayList;
	}
	
//line
	private String[] parseLine(String line) {
	   String dashString=line.replace("-", " ");
	   String resultString=dashString.replaceAll("\\p{Punct}", "").trim();
	   String[] stringSet=resultString.split(" ");
	   return stringSet;
	}
	
////	create Tree
	private ArrayList<Word> createBsTree(String[] aStrings, ArrayList<Word> bsTree){
		for(int i=0;(i<aStrings.length)&&(aStrings[i]!=null);i++) {
//			bsTree.add(new Word(aStrings[i]));
			
		}
		
		return bsTree;
	}
	
//	create arratlist
	private ArrayList<String> createaArrayList(String[] aStrings, ArrayList<String> arrayList){
		for(int i=0;(i<aStrings.length)&&(aStrings[i]!=null);i++) {
			arrayList.add(aStrings[i]);
		}
		return arrayList;
	}
		
	//search 
	private int search(Object[]arr, String s){
        int counter = 0;
        for (int j = 0; j < arr.length; j++) {
        	 if (s.equals(arr[j])) {
             	counter++;
             }
        }
        
       return counter;
 }
	
	
	
	
	
	
	
}
