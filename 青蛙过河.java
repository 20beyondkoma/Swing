import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App2 {
    JPanel myPanel=new JPanel();
    //    JLabel label_txt=new JLabel();
    JLabel label_frog=new JLabel();
    JLabel label_frog1=new JLabel();
    JLabel label_frog2=new JLabel();
    JLabel label_background=new JLabel();
    JTextArea JTextArea_A=new JTextArea();
    JTextArea JTextArea_B=new JTextArea();
    JLabel cores=new JLabel();

    int x1=350,y1=250,x2=320,y2=100,x3=530,y3=45,xx3=620,xxx3=710;

    int defen=0;
    //构造方法
    public App2() {

        myPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                JTextArea_A.append(String.valueOf(e.getKeyChar()));


            if(defen==0){
                if (label_frog.getX() == 200 && label_frog.getY() == 400 && JTextArea_A.getText().equals("hello")) {
                    label_frog.setBounds(x1, y1, 128, 128);
                    JTextArea_A.setText("");
                    cores.setText(String.valueOf("你的得分：" + defen));
                }

                if (label_frog.getX() == x1 && label_frog.getY() == y1 && JTextArea_A.getText().equals("world")) {
                    label_frog.setBounds(x2, y2, 128, 128);
                    JTextArea_A.setText("");
                    cores.setText(String.valueOf("你的得分：" + defen));
                }
                if (label_frog.getX() == x2 && label_frog.getY() == y2 && JTextArea_A.getText().equals("hi")) {
                    label_frog.setBounds(x3, y3, 128, 128);
                    JTextArea_A.setText("");
                    defen=1;
                    cores.setText(String.valueOf("你的得分：" + defen));
                }
            }


            if( defen==1){
                if (label_frog1.getX() == 100 && label_frog1.getY() == 400 && JTextArea_A.getText().equals("hello")) {
                    label_frog.setBounds(x3, y3, 128, 128);
                    label_frog1.setBounds(x1, y1, 128, 128);
                    JTextArea_A.setText("");
                    cores.setText(String.valueOf("你的得分：" + defen));
                }
                if (label_frog1.getX() == x1 && label_frog1.getY() == y1 && JTextArea_A.getText().equals("world")) {
                    label_frog1.setBounds(x2, y2, 128, 128);
                    label_frog.setBounds(x3, y3, 128, 128);
                    JTextArea_A.setText("");
                    cores.setText(String.valueOf("你的得分：" + defen));
                }
                if (label_frog1.getX() == x2 && label_frog1.getY() == y2 && JTextArea_A.getText().equals("hi")) {
                    label_frog1.setBounds(xx3, y3, 128, 128);
                    label_frog.setBounds(x3, y3, 128, 128);
                    JTextArea_A.setText("");
                    defen=2;
                    cores.setText(String.valueOf("你的得分：" + defen));
                }
            }

        if( defen==2){

            if (label_frog2.getX()==150 && label_frog2.getY()==400 && JTextArea_A.getText().equals("hello") ) {
                label_frog2.setBounds(x1, y1, 128, 128);
                label_frog1.setBounds(xx3, y3, 128, 128);
                label_frog.setBounds(x3, y3, 128, 128);
                JTextArea_A.setText("");
                cores.setText(String.valueOf("你的得分：" + defen));
            }
            if (label_frog2.getX()==x1 && label_frog2.getY()==y1 && JTextArea_A.getText().equals("world")) {
                label_frog2.setBounds(x2, y2, 128, 128);
                label_frog1.setBounds(xx3, y3, 128, 128);
                label_frog.setBounds(x3, y3, 128, 128);
                JTextArea_A.setText("");
                cores.setText(String.valueOf("你的得分：" + defen));
            }

            if (label_frog2.getX()==x2 && label_frog2.getY()==y2 && JTextArea_A.getText().equals("hi")) {
                label_frog1.setBounds(xx3, y3, 128, 128);
                label_frog.setBounds(x3, y3, 128, 128);
                label_frog2.setBounds(xxx3, y3, 128, 128);
                JTextArea_A.setText("");
               defen=3;
                cores.setText(String.valueOf("你的得分：" + defen));
            }
        }




            }

        });


    }
    //显示窗体方法
    void go(){





        cores.setText("你的得分：");
        cores.setBounds(10,20,100,50);

        myPanel.add(cores);

        java.net.URL imgURL1 = App.class.getResource("img/frog.png");
        label_frog.setIcon(new ImageIcon(imgURL1));
        label_frog.setBounds(200,400,128,128);
        myPanel.add(label_frog);

        java.net.URL imgURL2 = App.class.getResource("img/frog1.png");
        label_frog1.setIcon(new ImageIcon(imgURL2));
        label_frog1.setBounds(100,400,128,128);
        myPanel.add(label_frog1);

        java.net.URL imgURL3 = App.class.getResource("img/frog2.png");
        label_frog2.setIcon(new ImageIcon(imgURL3));
        label_frog2.setBounds(150,400,128,128);
        myPanel.add(label_frog2);


        JTextArea_A.setText("");
        JTextArea_A.setBounds(0,0,200,30);
         JTextArea_A.setVisible(false);
        myPanel.add(JTextArea_A);


        java.net.URL imgURL = App.class.getResource("img/background.png");
        label_background.setIcon(new ImageIcon(imgURL));
        label_background.setBounds(0,0,1024,600);
        myPanel.add(label_background);






        myPanel.setLayout(null);
        JFrame frame = new JFrame("一个小程序");
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1024,600);
        //frame.pack();
        frame.setVisible(true);
        myPanel.setFocusable(true);//键盘监听必须加panel面板的焦点获取才可以
    }
    public static void main(String[] args) {
        new App2().go();
    }
}
