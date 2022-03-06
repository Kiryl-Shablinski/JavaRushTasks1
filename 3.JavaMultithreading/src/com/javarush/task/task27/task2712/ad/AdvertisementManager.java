package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private List<Advertisement> advertisements;
    private long maxAmountPerOneDisplaying;
    private int maxDurationTime;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
       if(storage.list().size() == 0) throw new NoVideoAvailableException();
       List<Advertisement> advertiSementsWithHits = new ArrayList<>();
       for (Advertisement newAdverisements : storage.list()){

           if (newAdverisements.getHits()>0) advertiSementsWithHits.add(newAdverisements);
       }
       advertisements = advertiSementsWithHits;

       Collections.reverse(advertisements);
       makeBestAdverti(advertisements);
       sortAdverti(advertisements);
        VideoSelectedEventDataRow videoSelected = new VideoSelectedEventDataRow(advertisements,
                totalVideoAmount(advertisements), totalVideoDuration(advertisements));
        StatisticManager.getInstance().register(videoSelected);

       for (Advertisement advertisement : advertisements){
               ConsoleHelper.writeMessage(advertisement.toString());
               advertisement.revalidate();
       }
    }

    private int totalVideoAmount(List<Advertisement> advertisements){
        int totalAmount = 0;

        for (Advertisement adveti : advertisements){
           totalAmount += adveti.getAmountPerOneDisplaying();
        }

        return totalAmount;
    }

    private int totalVideoDuration(List<Advertisement> advertisements){
        int totalDuration = 0;

        for (Advertisement adveti : advertisements){
            totalDuration += adveti.getDuration();
        }

        return totalDuration;
    }

    public int calcDuration(List<Advertisement> advertisements){
        int sumDuration = 0;

        for(Advertisement adverti : advertisements){
            sumDuration+=adverti.getDuration();
        }
        return sumDuration;
    }

    public long calcPriceOneSeconds(List<Advertisement> advertisements){
        long sumPrice = 0;
        for (Advertisement adverti : advertisements){
            sumPrice += adverti.getAmountPerOneDisplaying();
        }
        return sumPrice;
    }

    private void checkList(List<Advertisement> advertisements){
        int calcDuration = calcDuration(advertisements);
        long calcPriceOneSeconds = calcPriceOneSeconds(advertisements);

        if (this.advertisements == null){
            if (calcDuration <= timeSeconds){
                this.advertisements = advertisements;
                maxAmountPerOneDisplaying = calcPriceOneSeconds;
                maxDurationTime = calcDuration;
            }
        }else if (calcDuration <= timeSeconds
                    && calcPriceOneSeconds > maxAmountPerOneDisplaying){
                this.advertisements = advertisements;
                maxAmountPerOneDisplaying = calcPriceOneSeconds;
                maxDurationTime = calcDuration;

        }else if (maxAmountPerOneDisplaying == calcPriceOneSeconds
                && calcDuration <= timeSeconds && calcDuration > maxDurationTime){
            this.advertisements = advertisements;
            maxDurationTime = calcDuration;

        }else if (maxAmountPerOneDisplaying == calcPriceOneSeconds
                 && maxDurationTime == calcDuration  && calcDuration <= timeSeconds
                && advertisements.size() < this.advertisements.size()){
            this.advertisements = advertisements;
        }
    }

    public void makeBestAdverti (List<Advertisement> adverti){
        if (!adverti.isEmpty()) {
            checkList(adverti);
        }
       for (Advertisement advertisement : adverti){
                List<Advertisement> newAdverti = new ArrayList<>(adverti);
                newAdverti.remove(advertisement);
                makeBestAdverti(newAdverti);
       }
    }

    public void sortAdverti(List<Advertisement> adverti){
        Collections.sort(adverti, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
               if (o1.getAmountPerOneDisplaying()==o2.getAmountPerOneDisplaying()){
                   return Long.compare(o1.getMaxAmountOneSecondDisplaying(), o2.getMaxAmountOneSecondDisplaying());
               }
                return Long.compare(o2.getAmountPerOneDisplaying(),o1.getAmountPerOneDisplaying());
            }
        });
    }
}
