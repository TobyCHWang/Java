package problemdomain;

public class Test {

	public static void main(String[] args) {
		OctagonalPrism op = new OctagonalPrism();
		op.setHeight(5);
		op.setSide(5);
		System.out.printf("OP has %.2f volume and %.2f area%n", op.calcVolume(), op.calcBaseArea());
		
		PentagonalPrism pp = new PentagonalPrism(5, 5);
		System.out.printf("PP has %.2f volume and %.2f area%n", pp.calcVolume(), pp.calcBaseArea());
		
	}

}
