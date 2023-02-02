package CN.Function.Growth;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Map;

public class Growth {
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
    public String growth() throws IOException {

        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");
        File folderPath = new File("C:\\Users\\"+userName+"\\.DesktopAide\\growth");
        File filePath = new File(folderPath+"\\growth.da");
        if(!folderPath.exists()) {
            folderPath.mkdirs();
        }
        if(!filePath.exists()){
            filePath.createNewFile();
        }
        int needReadLine = 1;
        readAppointedLineNumber(filePath,needReadLine);
        return result;
    }

    public static void main(String[] args) throws IOException {
        Growth growth = new Growth();
        System.out.println(growth.growth());
    }
}
