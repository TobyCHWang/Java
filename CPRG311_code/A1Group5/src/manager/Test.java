package manager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<String> commandArrayList=new ArrayList<String>();
		
		for(int i=0;i<3;i++) {
			commandArrayList.add(args[i]);
		}
		
		ShapeManger aManger=new ShapeManger(commandArrayList);
		
		
	    
		
	}

}
