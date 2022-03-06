package com.javarush.task.task20.task2027;


import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list =new ArrayList<>(detectAllWords(crossword, "home", "same", "ful","kerpo"));

        for (Word text : list){
            System.out.println(text);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String text : words){
            boolean finish=false;

                for (int x = 0; x < crossword.length; x++) {
                    for (int y = 0; y < crossword[x].length; y++) {
                        if (crossword[x][y] ==text.charAt(0)) {
                            Word result = serch(x, y, text, crossword);
                            if (result != null) {
                                list.add(result);
                                finish = true;
                                break;
                            }
                        }

                    }
                    if (finish) break;
                }
          //  }

        }
        return list;
    }

    public static Word serch (int crossX, int crossY, String word, int[][] crossword){
        for (int x=-1; x<=1; x++ ){
            for (int y=-1; y<=1; y++){

                if(x==0 && y==0) continue;

                Coordinate end = serchWord(crossX,crossY,x,y,word.toCharArray(),crossword);
                if (end!=null){
                  Word wordResult = new Word(word);
                  wordResult.setEndPoint(end.y,end.x);
                  wordResult.setStartPoint(crossY,crossX);
                  return wordResult;
                }
            }
        }


    return  null;
    }

   public static Coordinate serchWord(int crossX, int crossY,int dirX, int dirY, char[] word, int [][] crossword){
        int curientX=crossX;
        int curientY = crossY;



            for (int i = 0; i < word.length; i++) {
                try {
                   if (crossword[curientX][curientY] == word[i]) {
                       if (i==word.length-1){
                           return new Coordinate(curientX,curientY);
                       }
                       curientX+=dirX;
                       curientY+=dirY;
                    }else break;
                } catch (ArrayIndexOutOfBoundsException o) {
                    break;

                }
            }
        return null;
    }

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y){

            this.x=x;
            this.y = y;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
