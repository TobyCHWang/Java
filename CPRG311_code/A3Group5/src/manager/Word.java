package manager;

import java.io.Serializable;

public class Word implements Comparable<Word>,Serializable {
    
	private String value;
	private int lineNumber;
	private String fileName;
	
	
	
	/**
	 * 
	 */
	public Word() {
		super();
	}



	/**
	 * @param value
	 */
	public Word(String value, String fileName) {
		super();
		this.value = value;
		this.fileName=fileName;
		
	}

	
	public Word(String value, int lineNumber, String fileName) {
		super();
		this.value=value;
		this.lineNumber=lineNumber;
		this.fileName=fileName;
	}


	/**
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}



	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}


	

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}



	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}



	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}



	@Override
	public int compareTo(Word o) {
		if (this.getValue().compareTo(o.getValue())>0) {
			return 1;
		} else if (this.getValue().compareTo(o.getValue())<0) {
			return -1;
		} else
			return 0;
	}
	

}
