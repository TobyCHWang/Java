package problemdomain;

public class Pyramid extends Shape {
	private double side;
	
	public Pyramid() {
		super();
	}

	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double calcVolume() {
		return (1.0 / 3) * side * side * super.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return side * side;
	}

}
