package pkg;

public class R {
	static void Lj(){
//		int a=100;
//		int b=1;
//		 System.out.println("a*b的结果"+a*b);
//		
		
		String boy_filePath="img/boy.gif";
		String grill_filePath="img/grill.gif";
		int [][]array2d= {
				{1,2,3},
				{4,5,6}
				}; 

		System.out.println(boy_filePath+"\n"+grill_filePath);
		for (int l = 0; l < array2d.length; l++) {
			
			for (int h = 0; h < array2d[0].length; h++) {
				System.out.print(array2d[l][h]+" ");
			}
			System.out.println();
		}
		
	 }

}
