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
            in.append(bufferedReader.readLine());//Читаем строки в StringBuilder
        }
        reader.close();
        bufferedReader.close();
        if (in.indexOf("<") != 0) {
            in.delete(0, in.indexOf("<"));//удоляем лишнее в начале файла
        }
        String st = in.toString();
        if (!st.equals("")) {
            Pattern outpatternStart = Pattern.compile("<" + args[0] + "(.*?)>");//Pattern для поиска начала тега
            Pattern outpatternEnd = Pattern.compile("</" + args[0] + ">");//Pattern для поиска конца тега
            Matcher outMstcherStart = outpatternStart.matcher(st);
            Matcher outMstcherEnd = outpatternEnd.matcher(st);
            ArrayList<Integer> StarinexsStart = new ArrayList<>();//лист начадьых индексов начал тегов
            ArrayList<Integer> EndinexsEnd = new ArrayList<>();//лист конечных индексов начал тегов
            ArrayList<Integer> StarinexsEnd = new ArrayList<>();//лист начадьых индексов концов тегов
            ArrayList<Integer> EndinexsStart = new ArrayList<>();//лист конечных индексов концов тегов
            while (outMstcherStart.find()) {
                StarinexsStart.add(outMstcherStart.start());//заполнение листа начадьых индексов начал тегов
                StarinexsEnd.add(outMstcherStart.end());//заполнение листа конечных индексов начал тегов
            }
            while (outMstcherEnd.find()) {
                EndinexsStart.add(outMstcherEnd.start());//заполнение листа начадьых индексов концов тегов
                EndinexsEnd.add(outMstcherEnd.end());//запонение листа конечных индексов концов тегов
            }
            int indexMax = (StarinexsEnd.size() + StarinexsStart.size() + EndinexsEnd.size() + EndinexsStart.size()) / 4;
            //вычисление сриндегс размера листов
            for (int i = 0; i < indexMax; i++) { //поиск внутриннихтегов и вывод на эран
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
