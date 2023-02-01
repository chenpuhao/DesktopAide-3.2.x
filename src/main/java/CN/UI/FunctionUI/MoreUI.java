package CN.UI.FunctionUI;

import CN.UI.FunctionPanel.CollationPanel;
import CN.UI.FunctionPanel.qqPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoreUI extends JFrame {
   public MoreUI(){
       //获取桌面大小
       Dimension getScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
       //基本设置
       this.setBounds((getScreenSize.width-600)/2,(getScreenSize.height-500)/2,600,500);
       this.setDefaultCloseOperation(HIDE_ON_CLOSE);
       this.setResizable(false);
       this.setType(JFrame.Type.UTILITY);
       JPanel moreUIPanel = new JPanel();
       moreUIPanel.setLayout(new BorderLayout());
       ImageIcon title = new ImageIcon("Icon/MoreUI/favicon.png");
       this.setIconImage(title.getImage());
       JPanel leftSetting = new JPanel();
       leftSetting.setLayout(new GridLayout(2,1));
       //添加整理的设置
       ImageIcon collationImage = new ImageIcon("Icon/MoreUI/collation.png");
       JButton collation = new JButton("整理设置");
       collation.setIcon(collationImage);
       collation.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               moreUIPanel.removeAll();
               moreUIPanel.setLayout(new BorderLayout());
               moreUIPanel.add(leftSetting,BorderLayout.WEST);
               CollationPanel collationPanel = new CollationPanel();
               moreUIPanel.add(collationPanel,BorderLayout.CENTER);
               MoreUI.this.revalidate();
               MoreUI.this.repaint();
           }
       });
       leftSetting.add(collation);
       //添加QQ机器人设置
       ImageIcon qqImage = new ImageIcon("Icon/MoreUI/qq.png");
       JButton qq = new JButton("QQ机器人设置");
       qq.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               moreUIPanel.removeAll();
               moreUIPanel.setLayout(new BorderLayout());
               moreUIPanel.add(leftSetting,BorderLayout.WEST);
               qqPanel qqpanel = new qqPanel();
               moreUIPanel.add(qqpanel,BorderLayout.CENTER);
               MoreUI.this.revalidate();
               MoreUI.this.repaint();
           }
       });
       qq.setIcon(qqImage);
       leftSetting.add(qq);
       moreUIPanel.add(leftSetting,BorderLayout.WEST);
       this.add(moreUIPanel);
   }
}
