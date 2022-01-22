package problemdomain;

public class OctagonalPrism extends Prism {

	public OctagonalPrism() {
		super();
	}

	public OctagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * super.getSide() * super.getSide();
	}

}
