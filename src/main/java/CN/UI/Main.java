package CN.UI;

import CN.Function.Growth.Growth;
import CN.UI.MainUI.MainUI;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);
        while (true) {
            ImageIcon petImage;
            Growth growth = new Growth();
            int growthInt = Integer.parseInt(growth.growth());
            if (growthInt == 100) {
                File folderPath = new File("Icon/MainUI/plant/success");
                File[] list = folderPath.listFiles();
                int fileCount = 0;
                assert list != null;
                for (File file : list) {
                    if (file.isFile()) {
                        fileCount++;
                    }
                }
                Random getSuccessPlant = new Random();
                int successPlantInt = getSuccessPlant.nextInt(fileCount-1);
                petImage = new ImageIcon(folderPath+"/"+successPlantInt+".png");
                MainUI.tablePet.setIcon(petImage);
                JOptionPane.showMessageDialog(null,"恭喜你种植成功，关闭此弹窗后将会进行下一轮的种植，种植记录可在用户界面查看","种植成功",JOptionPane.PLAIN_MESSAGE,petImage);
                Map<String, String> map = System.getenv();
                String userName = map.get("USERNAME");
                File path = new File("C:\\Users\\"+userName+"\\.DesktopAide\\growth");
                File filePath = new File(path+"\\growth.da");
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                fileOutputStream.write("0".getBytes(StandardCharsets.UTF_8));
                fileOutputStream.flush();
                fileOutputStream.close();
            } else if (growthInt < 100 && growthInt >=50) {
                petImage = new ImageIcon("Icon/MainUI/plant/growing/100of100.png");
            }else{
                petImage = new ImageIcon("Icon/MainUI/plant/growing/50of100.png");
            }
            MainUI.tablePet.setIcon(petImage);
            mainUI.revalidate();
            mainUI.repaint();
            Thread.sleep(1000);
        }
    }
}
