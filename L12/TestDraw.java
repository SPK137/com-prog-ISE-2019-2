
public class TestDraw {
	public static void main(String[] args) {
		L12 nestedClassObj = new L12();
		L12.Triangle head = nestedClassObj.new Triangle(7, '#');
		L12.Square body = nestedClassObj.new Square(15, '%');
		L12.DoubleRightTriangle legs = nestedClassObj.new DoubleRightTriangle(7, '&'); 
		head.draw(1,0);
		body.draw();
		legs.drawDoubleTriangle(1);
	}
}
