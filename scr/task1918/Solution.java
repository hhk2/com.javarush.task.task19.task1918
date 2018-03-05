package task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder in = new StringBuilder();
        while (bufferedReader.ready()) {
            in.append(bufferedReader.readLine());
        }
        reader.close();
        bufferedReader.close();
        if (in.indexOf("<") != 0) {
            in.delete(0, in.indexOf("<"));
        }
        String st = in.toString();
        if (!st.equals("")) {
            Pattern outpatternStart = Pattern.compile("<" + args[0] + "(.*?)>");
            Pattern outpatternEnd = Pattern.compile("</" + args[0] + ">");
            Matcher outMstcherStart = outpatternStart.matcher(st);
            Matcher outMstcherEnd = outpatternEnd.matcher(st);
            ArrayList<Integer> StarinexsStart = new ArrayList<>();
            ArrayList<Integer> EndinexsEnd = new ArrayList<>();
            ArrayList<Integer> StarinexsEnd = new ArrayList<>();
            ArrayList<Integer> EndinexsStart = new ArrayList<>();
            while (outMstcherStart.find()) {
                StarinexsStart.add(outMstcherStart.start());
                StarinexsEnd.add(outMstcherStart.end());
            }
            while (outMstcherEnd.find()) {
                EndinexsStart.add(outMstcherEnd.start());
                EndinexsEnd.add(outMstcherEnd.end());
            }
            int indexMax = (StarinexsEnd.size() + StarinexsStart.size() + EndinexsEnd.size() + EndinexsStart.size()) / 4;
            for (int i = 0; i < indexMax; i++) {
                {
                    Matcher inMattcher = outpatternStart.matcher(st.substring(StarinexsEnd.get(i), EndinexsStart.get(i)));
                    int countgrup = 0;
                    if (inMattcher.find()) countgrup++;
                    Matcher inMattcherE = outpatternEnd.matcher(st.substring(StarinexsEnd.get(i), EndinexsStart.get(i)));
                    if (inMattcherE.find()) countgrup--;
                    System.out.println(st.substring(StarinexsStart.get(i), EndinexsEnd.get(i + countgrup)));

                }

            }

        }
    }
}
