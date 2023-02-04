package CN.UI.FunctionUI;

import CN.UI.IntroduceUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Map;
/**
 * @version 3.2.x
 * @author chenpuhao
 * @Date 2023/2/4
 */
public class UserUI extends JFrame {
    static String result;
    static void readAppointedLineNumber(File sourceFile, int lineNumber)
            throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if((lines - lineNumber) == 0) {
                result = s;
            }
        }
        reader.close();
        in.close();
    }
    static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }
    public UserUI() throws IOException {
        //获取屏幕大小
        Dimension getDesktopSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((getDesktopSize.width - 300) / 2, (getDesktopSize.height - 500) / 2, 300, 500);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //用户姓名
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");
        File folderPath = new File("C:\\Users\\" + userName + "\\.DesktopAide\\user");
        File filePath = new File(folderPath + "\\user.da");
        readAppointedLineNumber(filePath, 1);
        JLabel UserName = new JLabel("欢迎用户:"+result);
        JLabel userData = new JLabel("您目前已经种植出以下植物（单击查看更多信息）");
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(2,1));
        jp.add(UserName);
        jp.add(userData);
        filePath = new File(folderPath + "\\success.da");
        int total = getTotalLines(filePath);
        JScrollPane jsp = new JScrollPane();
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JPanel success = new JPanel();
        jsp.setViewportView(success);
        success.setLayout(new GridLayout(total,1));
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    filePath));
            String line = reader.readLine();
            while (line != null) {
                ImageIcon img = new ImageIcon("Icon/MainUI/plant/success/"+line);
                JButton jb = new JButton(img);
                success.add(jb);
                String finalLine = line;
                jb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(finalLine.equals("0.png")){
                            UI0 ui = new UI0();
                            ui.setVisible(true);
                        } else if (finalLine.equals("1.png") ){
                            UI1 ui = new UI1();
                            ui.setVisible(true);
                        }else if (finalLine.equals("2.png") ){
                            UI2 ui = new UI2();
                            ui.setVisible(true);
                        }else if (finalLine.equals("3.png") ){
                            UI3 ui = new UI3();
                            ui.setVisible(true);
                        }else if (finalLine.equals("4.png") ){
                            UI4 ui = new UI4();
                            ui.setVisible(true);
                        }else if (finalLine.equals("5.png") ){
                            UI5 ui = new UI5();
                            ui.setVisible(true);
                        }else if (finalLine.equals("6.png") ){
                            UI6 ui = new UI6();
                            ui.setVisible(true);
                        }else if (finalLine.equals("7.png") ){
                            UI7 ui = new UI7();
                            ui.setVisible(true);
                        }else if (finalLine.equals("8.png") ){
                            UI8 ui = new UI8();
                            ui.setVisible(true);
                        }else if (finalLine.equals("9.png") ){
                            UI9 ui = new UI9();
                            ui.setVisible(true);
                        }else if (finalLine.equals("10.png") ){
                            UI10 ui = new UI10();
                            ui.setVisible(true);
                        }else if (finalLine.equals("11.png") ){
                            UI11 ui = new UI11();
                            ui.setVisible(true);
                        }
                    }
                });
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(jp,BorderLayout.NORTH);
        this.add(jsp);
    }


}
