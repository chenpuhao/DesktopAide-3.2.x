package CN.Function.Puppet;

import CN.UI.MainUI.MainUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * @version 3.2.x
 * @author chenpuhao
 * @Date 2023/2/4
 */
public class Puppet extends JFrame {
    static double X;
    static double Y;
    static double SX;
    static double SY;
    public Puppet(){
        this.setSize(250,180);
        ImageIcon puppetImage = new ImageIcon("Icon/Function/Puppet/1.png");
        JLabel puppet = new JLabel(puppetImage);
        this.add(puppet);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setType(JFrame.Type.UTILITY);
        this.setAlwaysOnTop(true);
    }

    public static void main(String[] args) {
        Puppet puppet = new Puppet();
        puppet.setVisible(true);
        while(true){
            PointerInfo pInfo = MouseInfo.getPointerInfo();
            Point p = pInfo.getLocation();
            puppet.setLocation((int) p.getX()-110, (int) p.getY());
        }
    }
}
