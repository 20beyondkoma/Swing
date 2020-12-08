public class Find {
    public static void arrayFindValue(int array[][],int value){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j]==value) {
                    System.out.println("R_zero："+value+"坐标在：第"+i+"行第"+j+"列");
                    if ((i-1)<0){
                        System.out.println("上方超出边界");
                    }else {
                        System.out.println("R_up："+array[i-1][j]+"坐标为:行"+(i-1)+"列"+j);
                    }
                    if ((i+1)>array.length-1){
                        System.out.println("下方超出边界");
                    }else {
                        System.out.println("R_down："+array[i+1][j]+"坐标为:行"+(i+1)+"列"+j);
                    }
                    if ((j-1)<0){
                        System.out.println("左方超出边界");
                    }else {
                        System.out.println("R_left："+array[i][j-1]+"坐标为:行"+i+"列"+(j-1));
                    }
                    if ((j+1)>array[0].length-1){
                        System.out.println("右方超出边界");
                    }else {
                        System.out.println("R_right："+array[i][j+1]+"坐标为:行"+i+"列"+(j+1));
                    }
                    System.out.println();
                }
            }
        }
    }
}
