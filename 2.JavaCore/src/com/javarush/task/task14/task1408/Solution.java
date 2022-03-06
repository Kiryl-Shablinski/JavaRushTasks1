package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
       hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
                    Hen hen=null;
                if (country.equals(Country.BELARUS))
                    return hen=new BelarusianHen();

                else if(country.equals(Country.MOLDOVA))
                       return hen=new MoldovanHen();

                else if (country.equals(Country.RUSSIA))
                       return hen=new RussianHen();

                else if (country.equals(Country.UKRAINE))
                      return hen=new UkrainianHen();




            return hen;
        }
    }


}
