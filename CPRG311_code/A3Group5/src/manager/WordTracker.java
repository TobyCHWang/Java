package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

import exceptions.TreeException;
import utilities.BSTree;
import utilities.Iterator;

public class WordTracker {
    private BSTree<Word> wordBsTree;
    private ArrayList<Word> arrayList;
	
	public WordTracker() throws IOException, ClassNotFoundException, TreeException {
		File f = new File("res/repository.ser");
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("res/repository.ser"));
			wordBsTree=(BSTree<Word>) ois.readObject();
			arrayList=(ArrayList<Word>) ois.readObject();
			loadFile();
			ois.close();
		}else {
			wordBsTree=new BSTree<>();
			arrayList=new ArrayList<>();
			loadFile();
		}

		
		
		
	}
	
	//read file
	private void loadFile() throws IOException, TreeException {
		String line;
		String[] aStrings;
		int lineNumberCounter = 0;
		String fileName;
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter file location: ");
		String fileLoc = input.nextLine();
		File file = new File(fileLoc);
		BufferedReader fin = new BufferedReader(new FileReader(file));
		fileName=file.getName();
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("res/repository.ser"));
		
		
		while ((line = fin.readLine()) != null) {
			lineNumberCounter++;
			aStrings=parseLine(line);
			for(int i=0;(i<aStrings.length)&&(aStrings[i]!=null);i++) {
				if(aStrings[i].equals("")) {
					continue;
				}else {
					wordBsTree.add(new Word(aStrings[i],fileName));
					arrayList.add(new Word(aStrings[i],lineNumberCounter));
					
				}	
			}
		}
		
		

		
		
		System.out.println(wordBsTree.contains(new Word("zigzag","textfile.txt")));
		
		
		
		oos.writeObject(wordBsTree);
		oos.writeObject(arrayList);
		
		
		Iterator<Word> arrayListIterator = wordBsTree.inorderIterator();
//		ArrayList<Integer> intArrayList=new ArrayList<>();
		while (arrayListIterator.hasNext()) {
			Word nextString=arrayListIterator.next();
		    int frequency=calFrequency(arrayList, nextString.getValue());
//		    int lineN=calline(arrayList, nextString);
//		    calLineNumber(arrayList, nextString, intArrayList);
			System.out.println(nextString.getValue()+" count: "+frequency);
			System.out.println(nextString.getFileName());
			calLineNumber(arrayList, nextString.getValue());
			
			
		}
		
		
		

		oos.close();
		fin.close();
	}
	
	//res/textfile.txt
	//parse line 
	private String[] parseLine(String line) {
		   String dashString=line.replace("-", " ");
		   String resultString=dashString.replaceAll("\\p{Punct}", "").trim();
		   String[] stringSet=resultString.split(" ");
		   return stringSet;
		}
	
	//frequency
	
	private int calFrequency(ArrayList<Word> arrayList, String s){
        int counter = 0;
        for (int i = 0; i < arrayList.size(); i++) {
        	 if (s.equals(arrayList.get(i).getValue())) {
             	counter++;
             }
        }
        
       return counter;
 }
	

	
	
	//line number
	private void calLineNumber(ArrayList<Word> arrayList, String s){
        ArrayList<Integer> aIntegers=new ArrayList<>();
        ArrayList<Integer> newArrayList=new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
        	 if (s.equals(arrayList.get(i).getValue())) {
        		aIntegers.add(arrayList.get(i).getLineNumber());
        		HashSet<Integer> set=new HashSet<>(aIntegers);
        		newArrayList=new ArrayList<>(set);
        		Collections.sort(newArrayList);
             }
        }
        
        for(int i=0; i<newArrayList.size();i++) {
        	System.out.println(newArrayList.get(i));
        }
        
 }
	
}
