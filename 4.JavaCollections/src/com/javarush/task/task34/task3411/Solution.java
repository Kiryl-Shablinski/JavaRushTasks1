package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char from, char to, char buffer, int numRings) {

       if(numRings != 0){
           //рекурсивно опускаемся до нижного диска, поочередно меняя башни для переноса

           moveRing(from,buffer,to, numRings - 1);
           System.out.println(String.format("from %s to %s", from, to));

           moveRing(buffer,to,from, numRings - 1);
       }
       //напишите тут ваш код
    }
}