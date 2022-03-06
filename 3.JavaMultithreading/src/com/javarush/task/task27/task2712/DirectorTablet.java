package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit(){
        Map<String, Double> map = StatisticManager.getInstance().getStatisticForShowAdvertisement();
        double totalAmount =0;

        for (Map.Entry<String,Double> entry : map.entrySet()){
            totalAmount += entry.getValue();
            ConsoleHelper.writeMessage(entry.getKey() + " - " + String.format("%.2f",entry.getValue()));
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f",totalAmount));

    }

    public void printCookWorkloading(){
        Map<String, Map<String,Integer>> map = StatisticManager.getInstance().getStatisticCookingWork();

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()){
            ConsoleHelper.writeMessage(entry.getKey());

            for (Map.Entry<String, Integer> entryCooks : entry.getValue().entrySet()){
                 ConsoleHelper.writeMessage(String.format("%s - %d min",entryCooks.getKey(),entryCooks.getValue()));
            }

        }

    }

    public void printActiveVideoSet(){
      List<Advertisement> activVideo = StatisticAdvertisementManager.getInstance().getactivAdvertiSement(true);

       activVideo.sort(Comparator.comparing(Advertisement::getName, String::compareToIgnoreCase));

        for (Advertisement advertiSement : activVideo) {
               ConsoleHelper.writeMessage(advertiSement.getName() + " - " + advertiSement.getHits());
           }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> arhivVideo = StatisticAdvertisementManager.getInstance().getactivAdvertiSement(false);

        Collections.sort(arhivVideo, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement advertiSement : arhivVideo) {
            ConsoleHelper.writeMessage(advertiSement.getName());
        }
    }

}
