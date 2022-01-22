package problemdomain;

public abstract class Prism extends Shape {
	private double side;
	
	protected Prism() {
		super();
	}

	protected Prism(double height, double side) {
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
		return this.calcBaseArea() * super.getHeight();
	}

	public abstract double calcBaseArea();

}
