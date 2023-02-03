package CN.UI.FunctionUI;

import javax.swing.*;
import java.awt.*;

public class UserUI extends JFrame {
    public UserUI(){
        //获取屏幕大小
        Dimension getDesktopSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((getDesktopSize.width-300)/2,(getDesktopSize.height-500)/2,300,500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        //用户姓名

    }

    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        userUI.setVisible(true);
    }
}
