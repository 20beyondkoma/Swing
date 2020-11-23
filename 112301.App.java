import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("输入一个数，将为你输出随机坐标");


        while (true){
            Scanner scanner = new Scanner(System.in);
            int user_inp = scanner.nextInt();
            if (user_inp == 1) {
                //方法一
//                 int x = (int) (Math.random() * 100 % 100);
//                int y = (int) (Math.random() * 100 % 100);

//                System.out.println("x随机坐标"+x);
//                System.out.println("y随机坐标"+y);
                //方法二
                System.out.println("x随机坐标"+(int) (Math.random() * 100 % 100) +
                  "\n"  + "y随机坐标"+(int) (Math.random() * 100 % 100));

            }else {
                System.out.println("错误代码，无法输入坐标");
            }

        }


    }

}
