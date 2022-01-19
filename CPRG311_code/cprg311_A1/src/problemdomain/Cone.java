package problemdomain;

public class Cone extends Shape {
	private double radius;

	
	public Cone(double height) {
		super(height);
		
	}

	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	@Override
	public double calcVolume() {
		
		return (1.0/3)*(Math.PI*Math.pow(this.radius, 2)*super.getHeight());
	}

	@Override
	public double calcBaseArea() {
		return (Math.PI*Math.pow(this.radius, 2));
	}

}
