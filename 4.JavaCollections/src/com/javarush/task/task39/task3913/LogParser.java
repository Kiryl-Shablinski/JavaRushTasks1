package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;


import java.io.*;

import java.nio.file.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private Path logDir;
    private  List<MyParserLog> listLog = new ArrayList<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
        getListLog();
    }

    public void  getListLog() {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(logDir)) {
                for (Path file : directoryStream) {
                        if (file.toString().toLowerCase().endsWith(".log")) {
                            try (BufferedReader bufferedReader = new BufferedReader
                                    (new FileReader(file.toFile()))) {
                                String tmpLog;
                                while ((tmpLog = bufferedReader.readLine()) != null) {
                                    String[] myLog = tmpLog.split("\t");
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                                    Date date = sdf.parse(myLog[2]);
                                    String[] eventString = myLog[3].split(" ");
                                    Event event = Event.valueOf(eventString[0]);
                                    Status status = Status.valueOf(myLog[4]);
                                    if (event.equals(Event.DONE_TASK) || event.equals(Event.SOLVE_TASK)) {
                                        int taskNumber = Integer.parseInt(eventString[1]);
                                        MyParserLog parserLog = new MyParserLog(myLog[0], myLog[1], date, event, taskNumber, status);
                                        listLog.add(parserLog);
                                    } else {
                                        MyParserLog parserLog = new MyParserLog(myLog[0], myLog[1], date, event, status);
                                        listLog.add(parserLog);
                                    }
                                }

                            }
                        }
                }
        }catch (IOException | ParseException e) {
                e.printStackTrace();
        }
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {

        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date, after, before))
                .map(MyParserLog::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {

        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date, after, before))
                .filter(x -> x.userName.equals(user))
                .map(MyParserLog::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {

        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.event.equals(event))
                .map(MyParserLog::getIp)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {

        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.status.equals(status))
                .map(MyParserLog::getIp)
                .collect(Collectors.toSet());
    }

    private  boolean dateAfterBefore(Date currientDate, Date after, Date before){
        if (after == null){
            after = new Date(0);
        }
        if (before == null){
            before = new Date(Long.MAX_VALUE);
        }
        return currientDate.after(after) && currientDate.before(before);
    }

    @Override
    public Set<String> getAllUsers() {
        return listLog.stream()
                .map(x -> x.userName)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return (int) listLog.stream()
               .filter(x -> dateAfterBefore(x.date, after,before))
               .map(x -> x.userName)
               .distinct()
               .count();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {

        return (int) listLog.stream()
                .filter(x -> x.userName.equals(user))
                .filter(x -> dateAfterBefore(x.date,after,before))
                .map(x -> x.event)
                .distinct()
                .count();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.ip.equals(ip))
                .map(MyParserLog::getUserName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.event.equals(Event.LOGIN))
                .map(MyParserLog::getUserName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.event.equals(Event.DOWNLOAD_PLUGIN))
                .map(MyParserLog::getUserName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.event.equals(Event.WRITE_MESSAGE))
                .map(MyParserLog::getUserName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.event.equals(Event.SOLVE_TASK))
                .map(MyParserLog::getUserName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.event.equals(Event.SOLVE_TASK))
                .filter(x -> x.taskNumber == task)
                .map(MyParserLog::getUserName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.event.equals(Event.DONE_TASK))
                .map(MyParserLog::getUserName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.event.equals(Event.DONE_TASK))
                .filter(x -> x.taskNumber == task)
                .map(MyParserLog::getUserName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {

        return listLog.stream()
                .filter(x -> x.userName.equals(user))
                .filter(x -> x.event.equals(event))
                .filter(x -> dateAfterBefore(x.date,after,before))
                .map(MyParserLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.status.equals(Status.FAILED))
                .map(MyParserLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.status.equals(Status.ERROR))
                .map(MyParserLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date, after,before))
                .filter(x -> x.userName.equals(user))
                .filter(x -> x.event.equals(Event.LOGIN))
                .map(MyParserLog::getDate)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date, after,before))
                .filter(x -> x.userName.equals(user))
                .filter(x -> x.taskNumber == task)
                .filter(x -> x.event.equals(Event.SOLVE_TASK))
                .map(MyParserLog::getDate)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date, after,before))
                .filter(x -> x.userName.equals(user))
                .filter(x -> x.taskNumber == task)
                .filter(x -> x.event.equals(Event.DONE_TASK))
                .map(MyParserLog::getDate)
                .sorted()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.userName.equals(user))
                .filter(x -> x.event.equals(Event.WRITE_MESSAGE))
                .map(MyParserLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return  listLog.stream()
                .filter(x -> dateAfterBefore(x.date,after,before))
                .filter(x -> x.userName.equals(user))
                .filter(x -> x.event.equals(Event.DOWNLOAD_PLUGIN))
                .map(MyParserLog::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.getDate(),after, before))
                .map(MyParserLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.getDate(),after, before))
                .filter(x -> x.ip.equals(ip))
                .map(MyParserLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return listLog.stream()
                .filter(x -> x.getUserName().equals(user))
                .filter(x -> dateAfterBefore(x.getDate(),after,before))
                .map(MyParserLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return listLog.stream()
                .filter(x -> x.getStatus().equals(Status.FAILED))
                .filter(x -> dateAfterBefore(x.getDate(),after,before))
                .map(MyParserLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return listLog.stream()
                .filter(x -> x.getStatus().equals(Status.ERROR))
                .filter(x -> dateAfterBefore(x.getDate(),after,before))
                .map(MyParserLog::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return (int) listLog.stream()
                .filter(x -> x.getTaskNumber() == task)
                .filter(x -> dateAfterBefore(x.getDate(), after, before))
                .filter(x -> x.getEvent().equals(Event.SOLVE_TASK)).count();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
     return (int) listLog.stream()
                .filter(x -> x.getTaskNumber() == task)
                .filter(x -> dateAfterBefore(x.getDate(), after, before))
                .filter(x -> x.getEvent().equals(Event.DONE_TASK)).count();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return listLog.stream()
                .filter(x -> dateAfterBefore(x.getDate(),after,before))
                .filter(x -> x.getEvent().equals(Event.SOLVE_TASK))
                .collect(Collectors.toMap(MyParserLog::getTaskNumber, x -> 1, Integer :: sum));
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
       return listLog.stream()
                .filter(x -> dateAfterBefore(x.getDate(),after,before))
               .filter(x -> x.getEvent().equals(Event.DONE_TASK))
                .collect(Collectors.toMap(MyParserLog::getTaskNumber, x -> 1, Integer :: sum));

    }

    @Override
    public Set<Object> execute(String query) {
      Set <Object> setQuery = new HashSet<>();
        switch (query) {
            case "get ip" :
                return new HashSet<>(getUniqueIPs(null, null));
            case "get user" :
                return new HashSet<>(getAllUsers());
            case "get date":
                return listLog.stream()
                        .map(MyParserLog::getDate)
                        .collect(Collectors.toSet());
            case "get event":
                return  new HashSet<>(getAllEvents(null, null));
            case "get status":
                return  listLog.stream()
                        .map(MyParserLog::getStatus)
                        .collect(Collectors.toSet());

        }
        return null;
    }


    class MyParserLog {
        private String ip;
        private String userName;
        private Date date;
        private Event event;
        private int taskNumber;
        private Status status;

        public String getIp() {
            return ip;
        }

        public Date getDate() {
            return date;
        }

        public MyParserLog(String ip, String userName, Date date, Event event, int taskNumber, Status status) {
            this.ip = ip;
            this.userName = userName;
            this.date = date;
            this.event = event;
            this.taskNumber = taskNumber;
            this.status = status;
        }

        public MyParserLog(String ip, String userName, Date date, Event event, Status status) {
            this.ip = ip;
            this.userName = userName;
            this.date = date;
            this.event = event;
            this.status = status;
        }

        public String getUserName() {
            return userName;
        }

        public Event getEvent() {
            return event;
        }

        public int getTaskNumber() {
            return taskNumber;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            if (taskNumber == 0){
                return ip + " " + userName + " " + date + " " + event + " " + status;
            }else
            return ip + " " + userName + " " + date + " " + event + " " + taskNumber + " " + status;
        }
    }
}