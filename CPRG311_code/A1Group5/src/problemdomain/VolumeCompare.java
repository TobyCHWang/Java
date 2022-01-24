package problemdomain;

import java.util.Comparator;

public class VolumeCompare implements Comparator<Shape> {
	@Override
	public int compare(Shape shape1, Shape shape2){
		if( shape1.calcVolume() > shape2.calcVolume() ){
			return 100;
		}
		else if( shape1.calcVolume() < shape2.calcVolume() ){
			return -100;
		}
		else {
			return 0;
		}
	}

}
