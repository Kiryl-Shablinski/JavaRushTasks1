package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/



import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
        IncomeData income = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "RU";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Kiryl";
            }

            @Override
            public String getContactLastName() {
                return "Shablinsky";
            }

            @Override
            public int getCountryPhoneCode() {
                return 7;
            }

            @Override
            public int getPhoneNumber() {
                return 297452077;
            }
        };

        IncomeDataAdapter adapter = new IncomeDataAdapter(income);

        System.out.println(adapter.getCompanyName());
        System.out.println(adapter.getCountryName());
        System.out.println(adapter.getName());
        System.out.println(adapter.getPhoneNumber());






    }

    public static class IncomeDataAdapter implements Customer, Contact{

        private IncomeData data;

        public IncomeDataAdapter (IncomeData data){
            this.data =data;

        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
           for (Map.Entry<String, String> pair :countries.entrySet()){
               if (pair.getKey().equals(data.getCountryCode())){
                   return pair.getValue();
               }

            }

           return null;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String fullNumber;
            String code = String.format("%d",data.getCountryPhoneCode());
            String number1 = String.format("%d",data.getPhoneNumber());
            if ((code.length()+number1.length())>=12){

                fullNumber= String.format("%1$10d", data.getPhoneNumber());
            }else{

             fullNumber = String.format("%1$010d",data.getPhoneNumber());
            }
          StringBuilder number = new StringBuilder();
           number.append("+").append(data.getCountryPhoneCode()).append("(").append(fullNumber.substring(0,3)).append(")").append(fullNumber.substring(3,6)).append("-").append(fullNumber.substring(6,8)).append("-").append(fullNumber.substring(8,10));
            return number.toString();
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}