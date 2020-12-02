import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {
    JPanel myPanel=new JPanel();
    JLabel label_txt=new JLabel();
    JLabel label_plane=new JLabel();
    JLabel label_background=new JLabel();
    int CELL=64;
    //构造方法
    public App() {


        myPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
   if (e.getKeyCode()==e.VK_UP){
    label_plane.setBounds(label_plane.getX(),label_plane.getY()-1,CELL,CELL);

}
                if (e.getKeyCode()==e.VK_DOWN){
                    label_plane.setBounds(label_plane.getX(),label_plane.getY()+1,CELL,CELL);

                }

                if (e.getKeyCode()==e.VK_LEFT){
                    label_plane.setBounds(label_plane.getX()-1,label_plane.getY(),CELL,CELL);

                }
                if (e.getKeyCode()==e.VK_RIGHT){
                    label_plane.setBounds(label_plane.getX()+1,label_plane.getY(),CELL,CELL);

                }


            }
        });
    }


    //显示窗体方法
    void go(){
        label_txt.setText("这是一个Label标签。");
        label_txt.setBounds(0,0,200,30);
        myPanel.add(label_txt);

        java.net.URL imgURL = App.class.getResource("img/plane0.png");
        label_plane.setIcon(new ImageIcon(imgURL));
        label_plane.setBounds(100,100,CELL,CELL);

        myPanel.add(label_plane);


        java.net.URL imgURL1 = App.class.getResource("img/background2.png");
        label_background.setIcon(new ImageIcon(imgURL1));
        label_background.setBounds(0,0,1748,986);
        myPanel.add(label_background);

        myPanel.setLayout(null);
        JFrame frame = new JFrame("一个小程序");
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,512,720);
        //frame.pack();
        frame.setVisible(true);
        myPanel.setFocusable(true);//键盘监听必须加panel面板的焦点获取才可以
    }
    public static void main(String[] args) {
        new App().go();
    }
}
//120201.方向控制图片移动.App.java
