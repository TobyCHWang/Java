package problemdomain;

public class SquarePrism extends Prism {

	public SquarePrism() {
		super();
	}

	public SquarePrism(double height, double side) {
		super(height, side);
	}

	@Override
	public double calcBaseArea() {
		return super.getSide() * super.getSide();
	}

}
