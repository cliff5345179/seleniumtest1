import java.io.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class reportwriter {
    private String result;

    public void writerTxt(String result) {
        this.result = result;
        BufferedWriter fw = null;

            File file = new File("log.txt");
            try {
                fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指點編碼格式，以免讀取時中文字符異常
                fw.append(result);
                fw.newLine();
                fw.flush(); // 全部寫入緩存中的內容
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }

    }