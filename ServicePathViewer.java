import java.io.*;
import java.util.*;

public class ServicePathViewer {
    public static void main(String[] strings) {
        String r = execCommand("wmic service get Name,PathName,State");
        LinkedList<String[]> l = new LinkedList<String[]>();
        Scanner s = new Scanner(r);
        int counter = 0;
        while (s.hasNextLine()) {
            String read = s.nextLine();
            if (counter != 0 && read.length() != 0) {
                String[] line = new String[3];
                read.trim();
                String[] temp = read.split("\s{2,}"); // 拆分结果
                if (temp.length == 3) {
                    if(temp[1].charAt(0) == '"'); // 去掉引号
                        temp[1].replaceAll("\"", "");
                    line = temp;
                    l.add(line);
                } else if (temp.length == 2) { // 没有路径
                    line[0] = temp[0];
                    line[1] = "";
                    line[2] = temp[1];
                    l.add(line);
                }
            }
            counter++; // 总服务数
        }
        s.close();
    }

    public static String execCommand(String command) {
        String line = "";
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()));) {
            while ((line = bufferedReader.readLine()) != null)
                sb.append(line + "\n");
        } catch (IOException e) {
            return "";
        }
        return sb.toString();
    }
}