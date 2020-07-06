import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    public static ArrayList<Service> getServices() {
        String r = execCommand("wmic service get Name,PathName,State");
        ArrayList<Service> l = new ArrayList<Service>();
        Scanner s = new Scanner(r);
        int counter = 0;
        while (s.hasNextLine()) {
            String read = s.nextLine();
            if (counter != 0 && read.length() != 0) {
                Service line = null;
                read.trim();
                String[] temp = read.split("\s{2,}"); // 拆分结果 split result
                if (temp.length == 3) {
                    if (temp[1].charAt(0) == ('\"'))
                        temp[1] = temp[1].replaceAll("\"", ""); // 去掉引号 remove quote marks
                    line = new Service(temp[0], temp[1], temp[2]);
                    l.add(line);
                } else if (temp.length == 2) { // 没有路径 no path
                    line = new Service(temp[0], "", temp[1]);
                    l.add(line);
                }
            }
            counter++; // 总服务数 total services count
        }
        s.close();
        return l;
    }

    private static String execCommand(String command) {
        String line = "";
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()));) {
            while ((line = bufferedReader.readLine()) != null)
                sb.append(line + "\n");
        } catch (Exception e) {
            return "";
        }
        return sb.toString();
    }
}