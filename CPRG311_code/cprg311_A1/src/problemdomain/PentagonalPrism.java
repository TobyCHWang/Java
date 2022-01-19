package problemdomain;

public class PentagonalPrism extends Prism {

	public PentagonalPrism(double height, double side) {
		super(height, side);
		
	}

	public PentagonalPrism(double height) {
		super(height);
		
	}

	@Override
	public double calcVolume() {
		
		return calcBaseArea()*getHeight();
	}

	@Override
	public double calcBaseArea() {
		double rad=Math.toRadians(54);
		
		return ((5*Math.pow(getSide(), 2))*Math.tan(rad))/4;
	}

}
