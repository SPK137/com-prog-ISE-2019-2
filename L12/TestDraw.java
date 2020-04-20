
public class TestDraw {
	public static void main(String[] args) {
		L12 nestedClassObj = new L12();
		L12.Triangle head = nestedClassObj.new Triangle(7, '#');
		L12.Square body = nestedClassObj.new Square(15, '%');
		L12.RightTriangle legs = nestedClassObj.new RightTriangle(7, '&'); 
		head.draw(8,0);
		head.setHorizontalFlip(true);
		head.draw(8,0);
		body.draw();
		legs.drawDoubleTriangle(2);
	}
}
