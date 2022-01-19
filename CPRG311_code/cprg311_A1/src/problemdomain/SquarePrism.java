package problemdomain;

public class SquarePrism extends Prism {
	
	
	public SquarePrism(double height, double side) {
		super(height, side);
		
	}

	public SquarePrism(double height) {
		super(height);
		
	}

	@Override
	public double calcVolume() {
		
		return (Math.pow(super.getSide(), 2))*getHeight();
	}

	@Override
	public double calcBaseArea() {
		
		return Math.pow(super.getSide(), 2);
	}

}
