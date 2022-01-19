package problemdomain;

public class TriangularPrism extends Prism{

	public TriangularPrism(double height, double side) {
		super(height, side);
		// TODO Auto-generated constructor stub
	}

	public TriangularPrism(double height) {
		super(height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcVolume() {
		// TODO Auto-generated method stub
		return calcBaseArea()*super.getHeight();
	}

	@Override
	public double calcBaseArea() {
		// TODO Auto-generated method stub
		return ((Math.pow(super.getSide(), 2))*(Math.sqrt(3)))/4;
	}

}
