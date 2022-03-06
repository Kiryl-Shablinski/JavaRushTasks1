package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {

    public Human getPerson(int age){
        if (age > 0) {
            if (age < 13) return new KidBoy();
            if (age < 20) return new TeenBoy();
            return new Man();
        }
        return null;
    }
}