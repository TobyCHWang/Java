package problemdomain;

import java.util.Comparator;



public class AreaCompare implements Comparator<Shape> {
	
	@Override
	public int compare(Shape shape1, Shape shape2){
		if( shape1.calcBaseArea() > shape2.calcBaseArea() ){
			return 100;
		}
		else if( shape1.calcBaseArea() < shape2.calcBaseArea() ){
			return -100;
		}
		else {
			return 0;
		}
	}
}
