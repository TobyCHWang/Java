package problemdomain;

public class Cone extends Shape {
	private double radius;
	
	public Cone() {
		super();
	}

	public Cone(double height, double radius) {
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
		return (1.0 / 3) * Math.PI * radius * radius * super.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * radius * radius;
	}

}
