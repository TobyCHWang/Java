package problemdomain;

public class Cylinder extends Shape {
	private double radius;
	
	
	public Cylinder(double height) {
		super(height);
		// TODO Auto-generated constructor stub
	}

	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	@Override
	public double calcVolume() {
		return (Math.PI*Math.pow(this.radius, 2)*getHeight());
	}

	@Override
	public double calcBaseArea() {
		return (Math.PI*Math.pow(this.radius, 2));
	}
}
