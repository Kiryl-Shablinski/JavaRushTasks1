package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{

    public int getCountOfEggsPerMonth(){

        return countEggs=35;
    }

    public  String getDescription(){
        String text=super.getDescription()+" Моя страна - "+Country.RUSSIA+ ". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
        return text;
    }
}
