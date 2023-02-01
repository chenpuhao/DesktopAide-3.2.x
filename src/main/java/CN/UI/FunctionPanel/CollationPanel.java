package CN.UI.FunctionPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class CollationPanel extends JPanel {
    public CollationPanel(){
        this.setLayout(new BorderLayout());
        //定义组件
        //桌面路径
        JPanel path = new JPanel();
        path.setLayout(new GridLayout(4,1));
        JLabel desktopPath = new JLabel("选择您的桌面路径:");
        ButtonGroup pathButtonGroup = new ButtonGroup();
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");
        JRadioButton desktop = new JRadioButton("C:\\Users\\" + userName + "\\Desktop");
        JRadioButton oneDrive = new JRadioButton("C:\\Users\\" + userName + "\\OneDrive\\Desktop");
        JRadioButton other  = new JRadioButton("其他:");
        pathButtonGroup.add(desktop);
        pathButtonGroup.add(oneDrive);
        pathButtonGroup.add(other);
        JTextField otherTxt = new JTextField();
        JPanel otherPanel = new JPanel();
        otherPanel.setLayout(new BorderLayout());
        otherPanel.add(other,BorderLayout.WEST);
        otherPanel.add(otherTxt,BorderLayout.CENTER);
        path.add(desktopPath);
        path.add(desktop);
        path.add(oneDrive);
        path.add(otherPanel);
        //配置后缀
        JPanel methodPanel = new JPanel();
        methodPanel.setLayout(new BorderLayout());
        JLabel method = new JLabel("配置所需整理的文件后缀");
        JTextArea methodArea = new JTextArea();
        JScrollPane methodJSP = new JScrollPane(methodArea);
        JPanel methodCheck = new JPanel();
        methodCheck.setLayout(new GridLayout(1,2));
        JButton methodSave = new JButton("保存");
        JButton methodClean = new JButton("清空");
        methodCheck.add(methodSave);
        methodCheck.add(methodClean);
        methodPanel.add(method,BorderLayout.NORTH);
        methodPanel.add(methodJSP,BorderLayout.CENTER);
        methodPanel.add(methodCheck,BorderLayout.SOUTH);
        this.add(path,BorderLayout.NORTH);
        this.add(methodPanel,BorderLayout.CENTER);
    }
}
