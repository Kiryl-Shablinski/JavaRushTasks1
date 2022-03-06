package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {
    private static final StatisticAdvertisementManager  instance = new StatisticAdvertisementManager();
    private final AdvertisementStorage advertiStorage = AdvertisementStorage.getInstance();


    private StatisticAdvertisementManager(){
    }

    public static StatisticAdvertisementManager getInstance(){
        return instance;
    }

    public List<Advertisement> getactivAdvertiSement(boolean isActive){
        List<Advertisement> listActivVideo = new ArrayList<>();
        List<Advertisement> listArhivVideo = new ArrayList<>();
       for (Advertisement adverti : advertiStorage.list()) {
           if (adverti.getHits() > 0) {
               listActivVideo.add(adverti);
           } else if (adverti.getHits() == 0) {
               listArhivVideo.add(adverti);
           }
       }

      return  isActive ? listActivVideo : listArhivVideo ;
    }

}
