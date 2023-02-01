package CN.UI.MainUI;


import CN.UI.FunctionUI.MoreUI;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MainUI extends JFrame {
    //获取X和Y值
    public static double X;
    public static double Y;
    //收起按钮
    public static ImageIcon lockImage = new ImageIcon("Icon/MainUI/function/unlock.png");
    public static JButton lock = new JButton(lockImage);
    //判断是否收起
    public static Boolean isLocked = false;
    //判断左侧功能是否展开
    public static Boolean isRelease = false;

    public static Boolean isInEating = false;

    public MainUI(){
        //使用look and feel
        FlatDarkLaf.setup();
        FlatDarculaLaf.setup();
        FlatDarkFlatIJTheme.setup();
        //获取toolkit
        Dimension getScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //基本设置
        this.setBounds(getScreenSize.width-250,getScreenSize.height-220,230,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        this.setLayout(new BorderLayout());
        this.setType(JFrame.Type.UTILITY);
        //右侧功能界面
        JPanel function = new JPanel();
        function.setPreferredSize(new Dimension(30, 200));
        function.setBackground(new Color(0,0,0,0));
        function.setLayout(new BorderLayout());
        //移动按钮
        ImageIcon moveImage = new ImageIcon("Icon/MainUI/function/move.png");
        JLabel move = new JLabel(moveImage);
        move.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                X = e.getPoint().getX();
                Y = e.getPoint().getY();

            }
        });
        move.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                MainUI.this.setLocation((int) (e.getXOnScreen() - X - 200), (int) (e.getYOnScreen() - Y));

            }
        });
        //收起按钮
        lock.setContentAreaFilled(false);
        lock.setBorderPainted(false);
        //整理按钮
        ImageIcon collationImage = new ImageIcon("Icon/MainUI/function/collation.png");
        JButton collation = new JButton(collationImage);
        collation.setContentAreaFilled(false);
        collation.setBorderPainted(false);
        //更多按钮
        ImageIcon moreImage = new ImageIcon("Icon/MainUI/function/more.png");
        JButton more = new JButton(moreImage);
        more.setContentAreaFilled(false);
        more.setBorderPainted(false);
        more.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MoreUI moreUI = new MoreUI();
                moreUI.setVisible(true);
            }
        });
        //退出按钮
        ImageIcon exitImage = new ImageIcon("Icon/MainUI/function/exit.png");
        JButton exit = new JButton(exitImage);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        //将收起的整合到一起
        JPanel lockPanel = new JPanel();
        lockPanel.setBackground(new Color(0,0,0,0));
        lockPanel.setLayout(new GridLayout(3,1));
        lockPanel.add(collation);
        lockPanel.add(more);
        lockPanel.add(exit);
        //将收起和移动合并为一个Panel
        JPanel moveAndLock = new JPanel();
        moveAndLock.setLayout(new GridLayout(2,1));
        moveAndLock.setBackground(new Color(0,0,0,0));
        moveAndLock.add(move);
        moveAndLock.add(lock);
        //lock的监听函数
        lock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isLocked){
                    lockImage = new ImageIcon("Icon/MainUI/function/unlock.png");
                    lock.setIcon(lockImage);
                    function.add(lockPanel,BorderLayout.CENTER);
                    isLocked = false;
                }else{
                    lockImage = new ImageIcon("Icon/MainUI/function/lock.png");
                    lock.setIcon(lockImage);
                    function.remove(lockPanel);
                    isLocked = true;
                }
                MainUI.this.revalidate();
                MainUI.this.repaint();
            }
        });
        //将所有组件加入到function中
        function.add(moveAndLock,BorderLayout.NORTH);
        function.add(lockPanel,BorderLayout.CENTER);
        //将function加入到UI中
        this.add(function,BorderLayout.EAST);
        //添加桌宠
        ImageIcon tablePetImage = new ImageIcon("Icon/MainUI/table pets/Body.png");
        JButton tablePet = new JButton(tablePetImage);
        tablePet.setContentAreaFilled(false);
        tablePet.setBorderPainted(false);
        this.add(tablePet,BorderLayout.CENTER);
        //添加桌宠左侧选项卡
        JPanel petPanel = new JPanel();
        petPanel.setLayout(new GridLayout(3,1));
        petPanel.setBackground(new Color(0,0,0,0));
        //添加图标
        ImageIcon petEatImage = new ImageIcon("Icon/MainUI/action/eat.png");
        JButton petEat = new JButton(petEatImage);
        petEat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Toolkit toolkit =Toolkit.getDefaultToolkit();
                Random whatToEat = new Random();
                int eat = whatToEat.nextInt(5);
                ImageIcon eatImageIcon;
                if(eat == 0){
                    eatImageIcon = new ImageIcon("Icon/MainUI/food/hot dog.png");
                } else if (eat == 1) {
                    eatImageIcon = new ImageIcon("Icon/MainUI/food/ice.png");
                } else if (eat == 2) {
                    eatImageIcon = new ImageIcon("Icon/MainUI/food/meat.png");
                } else if (eat == 3) {
                    eatImageIcon = new ImageIcon("Icon/MainUI/food/spring roll.png");
                }else {
                    eatImageIcon = new ImageIcon("Icon/MainUI/food/taco.png");
                }
                Image eatImage = eatImageIcon.getImage();
                 Cursor cu =toolkit.createCustomCursor(eatImage,new Point(10,10),"eat");
                 MainUI.this.setCursor(cu);
                 isInEating = true;
            }
        });
        petEat.setContentAreaFilled(false);
        petEat.setBorderPainted(false);
        petPanel.add(petEat);
        ImageIcon petChatImage = new ImageIcon("Icon/MainUI/action/chat.png");
        JButton petChat = new JButton(petChatImage);
        petChat.setContentAreaFilled(false);
        petChat.setBorderPainted(false);
        petPanel.add(petChat);
        ImageIcon petUserImage = new ImageIcon("Icon/MainUI/action/user.png");
        JButton petUser = new JButton(petUserImage);
        petUser.setContentAreaFilled(false);
        petUser.setBorderPainted(false);
        petPanel.add(petUser);
        //给桌宠添加单击事件
        tablePet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isInEating) {
                    //noinspection deprecation
                    MainUI.this.setCursor(0);
                    isInEating = false;
                } else {
                    if (isRelease) {
                        MainUI.this.remove(petPanel);
                        isRelease = false;
                    } else {
                        MainUI.this.add(petPanel, BorderLayout.WEST);
                        isRelease = true;
                    }
                    MainUI.this.revalidate();
                    MainUI.this.repaint();
                }
            }
        });
    }
}
