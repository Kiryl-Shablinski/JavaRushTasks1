package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;

    public int getHits() {
        return hits;
    }

    private int hits;
    private int duration;
    private long amountPerOneDisplaying;
    private long maxAmountOneSecondDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
       amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
       maxAmountOneSecondDisplaying =  amountPerOneDisplaying * 1000 / duration;

    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public long getMaxAmountOneSecondDisplaying() {
        return maxAmountOneSecondDisplaying;
    }

    public void revalidate(){
        if (hits<=0) throw new UnsupportedOperationException();
        hits--;
    }

    @Override
    public String toString() {
       return name + " is displaying... " + amountPerOneDisplaying +
               ", " + maxAmountOneSecondDisplaying;
    }
}
