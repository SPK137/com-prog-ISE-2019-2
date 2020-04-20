import java.util.Scanner;

public class TriangleGenerator{

	static int width,height;
	static int[] backgroundColor = {0,109,255}; //blue
	static int[] triangleColor = {255,146,0}; //yellow

	public static void main(String[] args){
		generateMenu();
		boolean requirementMet = ( width+height >= 200 );
		if( requirementMet ){
			generateTriangle();
		}
	}

	private static void generateMenu(){
		var input = new Scanner(System.in);
		System.out.print("Please input the image's width:");
		width = input.nextInt();
		System.out.print("Please input the image's height:");
		height = input.nextInt();
	}

	private static void generateTriangle(){
		int[][][] rgb = new int[width][height][3];
		double slope = height/(width/2.0);
		for(int x = 0 ; x < width ; x++){
			for(int y = 0 ; y < height ; y++){
				if( ( y <= x*slope+1 && x <= width/2) || ( y <= height - (x-width/2)*slope+1 && x >= width/2) ){
					rgb[x][height-y-1]=triangleColor;
				}
				else{
					rgb[x][height-y-1]=backgroundColor;	
				}
			}
		}
		Java101ImageUtil.showViewer(rgb,"Triangle Picture");
	}
}
