package com.javarush.task.task39.task3913;



import java.nio.file.Paths;
import java.util.Date;


public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get(/*"c:/logs/"*/
                "C:\\Intel\\JavaRush_my_project\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs\\" ));
       

       // System.out.println(logParser.getNumberOfUniqueIPs(null, null));
      //  System.out.println(logParser.getUniqueIPs(null, new Date()));
      // System.out.println(logParser.getIPsForUser("Eduard Petrovich Morozko", null, new Date()));
       // System.out.println(logParser.getSolvedTaskUsers(null, null, 18));
       System.out.println("SetDate: " + logParser.getDatesForUserAndEvent(
            "Eduard Petrovich Morozko", Event.WRITE_MESSAGE,null, new Date()));
        System.out.println("Faled" + logParser.getDatesWhenSomethingFailed(null, new Date()));
        System.out.println("DateLogin: " + logParser.getDateWhenUserLoggedFirstTime(
                "Vasya Pupkin",null, new Date(Long.MAX_VALUE)));

        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(18, null,null));
    }

}
