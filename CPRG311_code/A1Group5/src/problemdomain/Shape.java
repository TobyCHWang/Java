package problemdomain;

import java.util.Comparator;



public abstract class Shape implements Comparable<Shape>{
	private double height;
	
	protected Shape() {
		super();
	}
	
	protected Shape(double height) {
		super();
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public abstract double calcVolume();
	
	public abstract double calcBaseArea();
	
	
	@Override
	public int compareTo(Shape that){
		if(this.height > that.height )
		{
			return 1;
		}
		else if( this.height < that.height )
		{
			return -1;
		}
		else // this.height == that.height
		{
			return 0;
		}
	}
}
	
	

