package problemdomain;

public class Cylinder extends Shape {
	private double radius;
	
	public Cylinder() {
		super();
	}
	
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcVolume() {
		return Math.PI * radius * radius * super.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * radius * radius;
	}

}
