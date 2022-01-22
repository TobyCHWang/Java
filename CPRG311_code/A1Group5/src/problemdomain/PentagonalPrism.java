package problemdomain;

public class PentagonalPrism extends Prism {

	public PentagonalPrism() {
		super();
	}

	public PentagonalPrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return (5 * super.getSide() * super.getSide() * Math.tan(Math.toRadians(54))) / 4;
	}

}
