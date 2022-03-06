package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fIn1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedReader fIn2 = new BufferedReader(new FileReader(bufferedReader.readLine()));

        bufferedReader.close();
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Отслеживаем изменения\\file1.txt
        //C:\\Users\\kirya\\Documents\\Java Core\\Level 9\\Отслеживаем изменения\\file2.txt

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (fIn1.ready()){
            list1.add(fIn1.readLine());
        }

        fIn1.close();

        while (fIn2.ready()){
            list2.add(fIn2.readLine());
        }

        fIn2.close();

        for (int i1=0, i2=0; i1<list1.size()|| i2<list2.size();){
            String line1="", line2="";
            if (i1<list1.size()) line1=list1.get(i1);
            if (i2<list2.size()) line2= list2.get(i2);

            if (line1.isEmpty() && !line2.isEmpty()){
                lines.add(new LineItem(Type.ADDED,line2));
                i2++;
            }

            if (!line1.isEmpty() && line2.isEmpty()){
                lines.add(new LineItem(Type.REMOVED,line1));
                i1++;
            }

            if (!line1.isEmpty()&& !line2.isEmpty()){

                if (line1.equals(line2)){
                    lines.add(new LineItem(Type.SAME, line1));
                    i1++;
                    i2++;
                }else{
                    String line_next="";
                    if (i1+1<list1.size()){
                        line_next=list1.get(i1+1);

                        if(line_next.equals(line2)){
                            lines.add(new LineItem(Type.REMOVED,line1));
                            i1++;

                        }else{
                            if (i2+1<list2.size()){
                                line_next=list2.get(i2+1);
                                lines.add(new LineItem(Type.ADDED,line2));
                                i2++;
                            }

                        }
                    }else{
                        if (i2<list2.size()){
                            line_next=list2.get(i2+1);
                            if (line1.equals(line_next)) {
                                lines.add(new LineItem(Type.ADDED, line2));
                                i2++;
                            }


                        }
                    }

                }

            }


        }
        for (LineItem lineItem : lines){
            System.out.println(lineItem.type + " " + lineItem.line);
        }


    }





    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
