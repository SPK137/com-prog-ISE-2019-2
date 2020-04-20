public class WhitePatchGenerator{

	public static void main(String[] args){
		int[][][] whitePatchRGB = new int[64][128][3];

		for(int i = 0; i < 64 ; i++){
			for(int j =0 ; j < 128; j++){
				whitePatchRGB[i][j][0]=255;
				whitePatchRGB[i][j][1]=255;
				whitePatchRGB[i][j][2]=255;
			}
		}
		Java101ImageUtil.showViewer(whitePatchRGB,"A patch of white pixels 64x128 version");
	}

}