import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {
    JPanel myPanel = new JPanel();
    JTextArea textArea_A = new JTextArea();
    JTextArea textArea_B = new JTextArea();

    //构造方法
    public App() {
        textArea_A.setText("这世界谁最有钱");
        textArea_A.setBounds(100,100,256,158);
        textArea_A.setBackground(Color.orange);
        myPanel.add(textArea_A);
        textArea_B.setBounds(100,300,256,128);
        textArea_B.setBackground(Color.yellow);
        myPanel.add(textArea_B);

        textArea_A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode()==KeyEvent.VK_ENTER){
                    if (textArea_A.getText().equals("李金花")){//正确答案李金花
                        textArea_B.append("回答正确");

                    }else {
                        textArea_B.append("回答错误，再猜\n");
                        textArea_A.setText("");

                    }


                }

            }
        });
    }

    //显示窗体方法
    void go() {
        JFrame frame = new JFrame("窗体123456");
        myPanel.setLayout(null);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 512, 720);
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new App().go();
    }
}
