package pkg;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    JPanel myPanel=new JPanel();
    JLabel label_txt=new JLabel();
    List<JLabel> label_list=new ArrayList<>();
    int array_2d[][]={
            {1,2,3},
            {4,5,6}
//            {7,8,9},
//            {10,11,0}
    };
    int cnt=0;
    int cell=128;
    //构造方法
    public App() {
        for (int i=0;i<=5;i++){
            label_list.add(new JLabel());
            java.net.URL imgURL = App.class.getResource("img/nezha_"+String.valueOf(i)+".png");
            label_list.get(i).setIcon(new ImageIcon(imgURL));

        }
for (int row=0;row<array_2d.length;row++){

    for (int cloumn=0;cloumn<array_2d[0].length;cloumn++){

        label_list.get(cnt).setBounds(cloumn*cell,row*cell,cell,cell);
        myPanel.add(label_list.get(cnt));
   cnt++;
    }
}









    }
    //显示窗体方法 120902.显示哪吒上半身.App.java
    void go(){
        label_txt.setText("这是一个Label标签。");
        label_txt.setBounds(0,0,200,30);
        myPanel.add(label_txt);



        myPanel.setLayout(null);
        JFrame frame = new JFrame("一个小程序");
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1024,720);
        //frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new App().go();
    }
}
