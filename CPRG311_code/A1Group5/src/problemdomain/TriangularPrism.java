package problemdomain;

public class TriangularPrism extends Prism {

	public TriangularPrism() {
		super();
	}

	public TriangularPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return (super.getSide() * super.getSide() * Math.sqrt(3)) / 4;
	}

}
