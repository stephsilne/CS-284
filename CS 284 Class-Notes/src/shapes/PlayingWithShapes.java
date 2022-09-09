package shapes;

import fruit.Apple;

public class PlayingWithShapes {


	public static void printColor(Colorable r) {
		System.out.println("My color is "+r.getColor());
	}
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(1.7,7.2);
		Rectangle r3 = new Rectangle(1.7,7.2, "Yellow");
		
//		System.out.println(r1.getWidth()); // prints 0.0
//		r1.setWidth(3.4);
//		System.out.println(r1.getWidth()); // prints 3.4
//		
//		System.out.println(r2.getWidth()); // prints 1.7
//		
//		System.out.println(r2);
//		
//		System.out.println(r3.getColor()); // prints Yellow
//		
//		System.out.println(Rectangle.getNoOfRectangles()); // prints 2
//			
//		Circle c1 = new Circle(3.4);
//			
//		Apple a1 = new Apple("Red",0.5,"Fiji");
//	
//		printColor(r3);
//		printColor(c1);
//		printColor(a1);
//		
//		
//
////		System.out.println(c1.getRadius());
////		System.out.println(c1);
////		System.out.println(c1.getColor());
//		
//		Colorable[] ss = new Colorable[3];
//		
//		ss[0] = a1;
//		ss[1] = r3;
//		ss[2] = c1;
//	
//		
//		for (Colorable s:ss) {
//			printColor(s);
//		}
//		
//		Apple c = new Apple("Red",3.4,"Gala");
//	
//		System.out.println(c.getOrigin());
//		
//		printColor((Colorable) c);
		
		System.out.println(r3.getWidthAndHeight());
		System.out.println(r3.getWidthAndHeight().getFst());

		System.out.println(r3.getWidthAndColor());

	}
	
	
}
