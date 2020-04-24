import java.lang.Math;

public class L12{

	public L12(){};

	public class Shape{
		protected int rows;
		protected char character;

		public Shape(){};
		public Shape(int x, char c){
			rows = x;
			character = c;
		}

		public int getRows(){return rows;}
		public void setRows(int x){this.rows = x;}
		public char getCharacter(){return character;}
		public void setCharacter(char character){this.character = character;}
		public String toString(){return "rows:"+rows+" character:"+character;}

	}

	public class Square extends Shape{

		public Square(int rows){
			this.rows = rows;
			this.character = '*';
		}
		public Square(int rows, char character){
			this.rows = rows;
			this.character = character;
		}

		public void draw(){
			for(int i=1 ; i<=rows ; i++){
				for(int j=1 ; j<=rows ; j++)
					System.out.print(character);
				System.out.println();
			}
		}

		public void draw(int x, int y){
			x++;	//adjusting x position
			y++;	//adjusting y position
			for(int i=1 ; i<=rows+y ; i++){
				if(i>=y){										//only prints character after y rows
					for(int j=1 ; j<=rows+x ; j++){
						if(j>=x)								//only prints character after x spaces
							System.out.print(character);
						else System.out.print(" ");				//otherwise prints whitespace
					}
				}
				System.out.println();							//moves to next line
			}
		}

		public int getArea(){return rows*rows;}
		public int getPerimeter(){return 4*rows;}
		public String toString(){return "Square: rows:"+rows+" character:"+character;}

	}

	public class RightTriangle extends Shape{

		private boolean isVerticalFlip;

		public RightTriangle(int rows){
			super.rows = rows;
			super.character = '%';
			isVerticalFlip = false;
		}
		public RightTriangle(int rows, char character){
			super.rows = rows;
			super.character = character;
			isVerticalFlip = false;
		}

		public void draw(){
			for(int i=1 ; i<=rows ; i++){
				if(isVerticalFlip){			          //when vertical flipped print some whitespaces first to push the triangle to the right
					for(int k=1; k<=rows-i ; k++)
						System.out.print(" ");
				}
				for(int j=1 ; j<=i ; j++){
					System.out.print(character);
				}
				System.out.println();
			}
		}

		public void draw(int x, int y){
			x++;
			y++;
			for(int i=1 ; i<=rows+y ; i++){
				if(i>=y){
					if(isVerticalFlip){
						for(int k=1; k<=rows-i ; k++)
							System.out.print(" ");
					}
					for(int j=1 ; j<=i+x ; j++){
						if(j>=x)
							System.out.print(character);
						else
							System.out.print(" ");
					}
				}
				System.out.println();
			}
		}

		public double getArea(){return 0.5*rows*rows;}
		public double getPerimeter(){return 2.0*rows+Math.sqrt(2.0*rows*rows);}
		public String toString(){return "RightTriangle: rows:"+rows+" character:"+character+" isVerticalFlip:"+isVerticalFlip;}
		public boolean isVerticalFlip(){return isVerticalFlip;}
		public void setVerticalFlip(boolean isVerticalFlip){this.isVerticalFlip = isVerticalFlip;}

	}

	public class Triangle extends Shape{

		private boolean isHorizontalFlip;

		public Triangle(int rows){
			super.rows = rows;
			super.character = '#';
			isHorizontalFlip = false;
		}
		public Triangle(int rows, char character){
			super.rows = rows;
			super.character = character;
			isHorizontalFlip = false;
		}

		public void draw(){
			if(isHorizontalFlip){
				for(int i= rows ; i>=1 ; i--){
					for(int k=1 ; k<=rows-i ;k++)
						System.out.print(" ");
					for(int j=1 ; j<=i ; j++){
						System.out.print(character+" ");
					}
					System.out.println();
				}
			}
			else{
				for(int i= 1 ; i<=rows ; i++){
					for(int k=1 ; k<=rows-i ;k++)
						System.out.print(" ");
					for(int j=1 ; j<=i ; j++){
						System.out.print(character+" ");
					}
					System.out.println();
				}
			}
		}

		public void draw(int x, int y){
			x++;
			y++;
			if(isHorizontalFlip){
				for(int i=rows+y-1 ; i>=1 ; i--){
					if(rows-i+1>=y){
						if(isHorizontalFlip()){
							for(int k=1; k<=rows-i ; k++)
								System.out.print(" ");
						}
						for(int j=1 ; j<=i+x-1 ; j++){
							if(j>=x)
								System.out.print(character+" ");
							else
								System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
			else{
				for(int i=1 ; i<=rows+y-1 ; i++){
					if(i>=y){
						for(int k=1 ; k<=rows-i ; k++)
							System.out.print(" ");
						for(int j=1 ; j<=i+x-1 ; j++){
							if(j>=x)
								System.out.print(character+" ");
							else
								System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
		}

		public double getArea(){return 0.5*rows*rows/Math.tan(60);}
		public double getPerimeter(){return 3*rows/Math.sin(60);}
		public String toString(){return "Square: rows:"+rows+" character:"+character+" isHorizontalFlip:"+isHorizontalFlip;}
		public boolean isHorizontalFlip(){return isHorizontalFlip;}
		public void setHorizontalFlip(boolean isHorizontalFlip){this.isHorizontalFlip = isHorizontalFlip;}

	}

	public class DoubleRightTriangle extends RightTriangle{

		public DoubleRightTriangle(int rows){ super(rows); }
		public DoubleRightTriangle(int rows, char character){ super(rows,character); }

		public void drawDoubleTriangle(int space){  //for the two triangle at the last part
			for(int i=1 ; i<=rows ; i++){
				//Left triangle
				for(int k=1; k<=rows-i ; k++)
					System.out.print(" ");
				for(int j=1 ; j<=i ; j++){
					System.out.print(character);
				}
				
				for(int index=1 ; index<=space ; index++)
					System.out.print(" ");
				
				//Right triangle
				for(int j=1 ; j<=i ; j++){
					System.out.print(character);
				}
				System.out.println();
			}
		}

	}

}
