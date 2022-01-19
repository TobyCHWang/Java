package problemdomain;

public class OctagonalPrism extends Prism {

	public OctagonalPrism(double height, double side) {
		super(height, side);
		
	}

	public OctagonalPrism(double height) {
		super(height);
		
	}

	@Override
	public double calcVolume() {
		
		return calcBaseArea()*getHeight();
	}

	@Override
	public double calcBaseArea() {
	
		return 2*(1+Math.sqrt(2))*Math.pow(getSide(), 2);
	}

}
