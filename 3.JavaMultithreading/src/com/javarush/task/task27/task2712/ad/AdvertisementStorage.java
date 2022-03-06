package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static final AdvertisementStorage instance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage(){
        Object someContent = new Object();
     videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
      videos.add(new Advertisement(someContent, "Second Video", 500, 10, 15 * 60));
      videos.add(new Advertisement(someContent, "второе Video", 400, 1, 10 * 60));

      /*
        add(new Advertisement(someContent, "1 Video", 5947, 110, 60));
        add(new Advertisement(someContent, "2 Video", 870, 55, 2 * 60));
        add(new Advertisement(someContent, "3 Video", 330, 24, 3 * 60));
        add(new Advertisement(someContent, "4 Video", 4020, 4, 20 * 60));
        add(new Advertisement(someContent, "5 Video", 2597, 248, 5 * 60));
        add(new Advertisement(someContent, "6 Video", 452, 45, 6 * 60));
        add(new Advertisement(someContent, "7 Video", 245, 12, 11 * 60));
        add(new Advertisement(someContent, "8 Video", 5454, 67, 8 * 60));
        add(new Advertisement(someContent, "9 Video", 4690, 530, 9 * 60));
        add(new Advertisement(someContent, "10 Video", 8954, 13, 10 * 60));
        add(new Advertisement(someContent, "11 Video", 3247, 231, 8*60));
        add(new Advertisement(someContent, "12 Video", 934, 59, 6 * 60));
        add(new Advertisement(someContent, "13 Video", 6954, 23, 7 * 60));
        add(new Advertisement(someContent, "14 Video", 456, 37, 8 * 60));
        add(new Advertisement(someContent, "15 Video", 4695, 15, 13 * 60));
        add(new Advertisement(someContent, "16 Video", 456, 36, 2 * 60));
        add(new Advertisement(someContent, "17 Video", 1354, 85, 3 * 60));
        add(new Advertisement(someContent, "18 Video", 425, 4, 5 * 60));
        add(new Advertisement(someContent, "19 Video", 4965, 130,  60));
        add(new Advertisement(someContent, "20 Video", 458, 5, 3 * 60));

        */
    }

    public List<Advertisement> list(){
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }

    public static AdvertisementStorage getInstance(){
       return instance;
    }
}
