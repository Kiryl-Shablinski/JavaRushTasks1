package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = this.new StatisticStorage();
  //  private Set<Cook> cooks = new HashSet<>();
    private static Logger logger = Logger.getLogger(StatisticManager.class.getName());

    private StatisticManager(){}

    public static StatisticManager getInstance() {
        return instance==null ? instance = new StatisticManager() : instance;
    }

   public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    /*public void register(Cook cook){
        cooks.add(cook);
    }

     public Set<Cook> getCooks() {
        return cooks;
    }

    */

    public Map<String, Double> getStatisticForShowAdvertisement(){
        Map<String, Double> mapShowAdverisement = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat parserDate = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        Map<EventType,List<EventDataRow>> storageMap = statisticStorage.getStorage();
        List<EventDataRow> list = storageMap.get(EventType.SELECTED_VIDEOS);

        for(EventDataRow event : list){
            VideoSelectedEventDataRow videoSelectedEvent = (VideoSelectedEventDataRow) event;
            String date = parserDate.format(videoSelectedEvent.getDate());
            double amount = (double) videoSelectedEvent.getAmount() / 100;
             if (mapShowAdverisement.containsKey(date)){
                 mapShowAdverisement.put(date,mapShowAdverisement.get(date) + amount);
             }else{
                 mapShowAdverisement.put(date,amount);
             }
        }

        return mapShowAdverisement;
    }

    public Map<String, Map<String, Integer>> getStatisticCookingWork(){

        Map<String, Map<String, Integer>> mapCookedOrder = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat parser = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
       Map<EventType, List<EventDataRow>> storageMap = statisticStorage.getStorage();
       List<EventDataRow> listWorkingCook = storageMap.get(EventType.COOKED_ORDER);

       for (EventDataRow event : listWorkingCook){
           CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow) event;
           String date = parser.format(cookedOrder.getDate());
           String cookName  = cookedOrder.getCookName();
           int workingCook = cookedOrder.getTime();

           if (mapCookedOrder.containsKey(date)){
                Map<String, Integer> cookWorking = mapCookedOrder.get(date);
                if (cookWorking.containsKey(cookName)){
                    cookWorking.put(cookName, cookWorking.get(cookName)+ workingCook);

                }else{
                    cookWorking.put(cookName, workingCook);
                }
                mapCookedOrder.put(date,cookWorking);
           }else{
               Map<String, Integer> temp = new TreeMap<>();
               temp.put(cookName,workingCook);
               mapCookedOrder.put(date,temp);
           }

       }
        return mapCookedOrder;
    }


    private class StatisticStorage{
    private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
          for(EventType type : EventType.values()){
                 storage.put(type, new ArrayList<EventDataRow>());         }
        }

        private void put(EventDataRow data){
            if (storage.containsKey(data.getType())){
                storage.get(data.getType()).add(data);
            }
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
