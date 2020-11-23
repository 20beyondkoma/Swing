public class App2 {

    public static void main(String[] args) throws InterruptedException {

       while (true){

           Thread.sleep(1000);

           System.out.println("x随机坐标"+(int) (Math.random() * 100 % 100) +
                   "\n"  + "y随机坐标"+(int) (Math.random() * 100 % 100)+"\n");

       }



    }
}
