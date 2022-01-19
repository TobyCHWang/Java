package problemdomain;

public abstract class Shape{
	private double height;
	
	
	public Shape(double height) {
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
}
