public class DesaturateIt{
	public static void main(String [] args){
		int [][][] rgb = Java101ImageUtil.getRGBArrayFromFile();
		if(rgb==null){return;}
		int [][][] gray = desaturate(rgb);
		Java101ImageUtil.showViewer(rgb,gray,"Desaturate It!");
	}
	public static int [][][] desaturate(int [][][] rgb){
		int[][][] gray = new int[rgb.length][rgb[0].length][3];
		int grayValue;
		for(int i = 0 ; i < rgb.length ;i++){
			for(int j = 0 ; j< rgb[0].length ; j++){
				grayValue = (int)( 0.2126*rgb[i][j][0] + 0.7152*rgb[i][j][1] + 0.0722*rgb[i][j][2]);
				gray[i][j][0]=grayValue;
				gray[i][j][1]=grayValue;
				gray[i][j][2]=grayValue;
			}
		}
		return gray;
	}
}