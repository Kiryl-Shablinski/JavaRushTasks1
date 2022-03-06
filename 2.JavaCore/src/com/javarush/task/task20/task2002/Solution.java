package com.javarush.task.task20.task2002;



import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("C:\\Users\\kirya\\Documents\\Java Core\\Level 10\\Читаем и пишем в файл JavaRush.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
          User user =new User();
            user.setFirstName("Kiryl");
            user.setLastName("Shablinsky");
           // SimpleDateFormat sdf =new SimpleDateFormat("dddd MM yyyy");
            user.setBirthDate(new Date(1985, Calendar.JULY,29));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            javaRush.users.add(user);

            User user1 = new User();
            user1.setFirstName("Iryna");
            user1.setLastName("Shablinskaya");
           user1.setBirthDate(new Date(1990,Calendar.JUNE,29));
            user1.setMale(false);
            user1.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user1);



            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject) && javaRush.hashCode()==loadedObject.hashCode());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
           String usersYes =users.size()!=0 ? "yes" : "no";
            writer.println(usersYes);
           if (users.size()!=0){
                for (User tmp : users){
                    writer.println(tmp.getFirstName());
                    writer.println(tmp.getLastName());
                    writer.println(tmp.getBirthDate().getTime());
                    writer.println(tmp.isMale());
                    writer.println(tmp.getCountry());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader fIn =new BufferedReader(new InputStreamReader(inputStream));
            if (fIn.readLine().equals("yes")){

            while (fIn.ready()){
                    User user = new User();

                    user.setFirstName(fIn.readLine());
                    user.setLastName(fIn.readLine());
                 //  SimpleDateFormat sdf =new SimpleDateFormat("dddd MM yyyy");
                 //  String date =fIn.readLine();
                Date date = new Date(Long.parseLong(fIn.readLine()));
                user.setBirthDate(date);
                    user.setMale(Boolean.parseBoolean(fIn.readLine()));
                    user.setCountry(User.Country.valueOf(fIn.readLine()));

                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
