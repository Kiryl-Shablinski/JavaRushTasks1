package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {



    public int getCountOfEggsPerMonth(){
        countEggs=38;
        return countEggs;
    }

    public  String getDescription() {
        String text = super.getDescription()+" Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return text;
    }
}
