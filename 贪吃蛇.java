StartGames.java



package pkg;

import javax.swing.*;

public class StartGames {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //绘制一个静态窗口 JFrame
        JFrame frame = new JFrame("贪吃蛇");
        frame.setBounds(10,10,900,720);//设置界面大小
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//让游戏能够关闭
        //面板Jpanel  可以加入到JFrame
        frame.add(new GamePanel());

        frame.setVisible(true);//让窗口可以显示出来
    }

}


GamePanel.java


package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
public class GamePanel extends JPanel implements KeyListener, ActionListener{

    int lenth;//长度
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];
    String fx;//RLUD左右上下
    Boolean isStart = false;//游戏开始没有
    Timer timer = new Timer(200,this);

    //定义一个食物
    int foodx;
    int foody;
    Random random = new Random();
    //死亡判断
    boolean isFail = false;
    //积分系统
    int score;
    //构造器
    public GamePanel() {
        init();
        //获取键盘的监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();//让时间动起来
    }
    //初始化
    public void init() {
        lenth = 3;
        snakeX[0] =100;snakeY[0] = 100;
        snakeX[1] =75;snakeY[1] = 100;
        snakeX[2] =50;snakeY[2] = 100;
        fx = "R";

        foodx = 25+25*random.nextInt(34);
        foody = 75+25*random.nextInt(24);

        score = 0;
    }
    //画板 ：画界面，画蛇
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);//背景颜色
        //绘制头部
        Data.header.paintIcon(this, g, 25, 11);

        //绘制游戏区域
        g.fillRect(25, 75, 850, 600);

        //画蛇
        if(fx.equals("R"))
        {
            Data.right.paintIcon(this,g, snakeX[0], snakeY[0]);
        }
        else if(fx.equals("L"))
        {
            Data.left.paintIcon(this,g, snakeX[0], snakeY[0]);
        }
        else if(fx.equals("U"))
        {
            Data.up.paintIcon(this,g, snakeX[0], snakeY[0]);
        }
        else if(fx.equals("D"))
        {
            Data.down.paintIcon(this,g, snakeX[0], snakeY[0]);
        }


        for(int i=1;i<lenth;i++)
        {
            Data.body.paintIcon(this,g, snakeX[i], snakeY[i]);//蛇的身体长度通过lenth控制
        }
        //画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度："+lenth, 750, 35);
        g.drawString("分数："+score, 750, 50);
        //画食物
        Data.food.paintIcon(this, g, foodx, foody);

        //游戏提示，是否开始
        if(isStart == false)
        {
            //画一个文字
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("按下空格开始游戏", 300, 300);
        }
        //失败提醒
        if(isFail)
        {
            //画一个文字
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("游戏失败,按下空格重新开始游戏", 200, 300);
        }
    }
    //接受键盘的输入:监听
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //键盘按下，弹起
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //键盘按下，未释放
        //获取按下的键盘是哪个键
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_SPACE)
        {
            if(isFail)//失败，游戏再来一次
            {
                isFail = false;
                init();//初始化游戏
            }
            else//暂停游戏
            {
                isStart = !isStart;
            }
            repaint();//刷新界面
        }
        //键盘控制走向
        if (keyCode==KeyEvent.VK_UP)
        {
            fx="U";
        }else if (keyCode==KeyEvent.VK_DOWN)
        {
            fx="D";
        }else if (keyCode==KeyEvent.VK_LEFT)
        {
            fx="L";
        }else if (keyCode==KeyEvent.VK_RIGHT)
        {
            fx="R";
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //释放某个键
    }
    //定时器：监听事件，帧
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //如果游戏处于开始转态，并且游戏没有结束
        if(isStart && isFail==false)
        {
            for(int i=lenth-1;i>0;i--)//除了脑袋身体都往前移动
            {
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }
            //通过控制方向让头部移动
            if(fx.equals("R"))
            {
                snakeX[0]=snakeX[0]+25;
                if(snakeX[0]>850){ snakeX[0]=25; }
            }else if (fx.equals("L"))
            {
                snakeX[0]=snakeX[0]-25;
                if(snakeX[0]<25){ snakeX[0]=850; }
            }else if (fx.equals("U"))
            {
                snakeY[0]=snakeY[0]-25;
                if(snakeY[0]<75){ snakeY[0]=650; }
            }else if (fx.equals("D"))
            {
                snakeY[0]=snakeY[0]+25;
                if(snakeY[0]>650){ snakeY[0]=75; }
            }
            //如果小蛇的头和food坐标重合
            if(snakeX[0] == foodx && snakeY[0]==foody)
            {
                lenth++;
                score += 10;
                //重新生成food
                foodx = 25+25*random.nextInt(34);
                foody = 75+25*random.nextInt(24);
            }
            //结束panduan
            for(int i=1;i<lenth;i++)
            {
                if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i])
                    isFail = true;
            }

            repaint();
        }
        timer.start();//让时间动起来
    }



}

Data.java

package pkg;

import java.net.*;
import javax.swing.*;

//存放外部数据
public class Data {
    //头部的图片 URL：定位图片的地址 ImageIcon：图片
    public static URL headerURL = Data.class.getResource("/img/h.png");
    public static ImageIcon header = new ImageIcon(headerURL);
    public static URL upURL = Data.class.getResource("/img/up.png");
    public static URL downURL = Data.class.getResource("/img/down.png");
    public static URL leftURL = Data.class.getResource("/img/left.png");
    public static URL rightURL = Data.class.getResource("/img/right.png");
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);
    public static URL bodyURL = Data.class.getResource("/img/body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);
    public static URL foodURL = Data.class.getResource("/img/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);

}




