package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/* 
MVC - простая версия
*/

public class Solution {
    public static void main(String[] args) {
       View view = new View();
     // new Solution().fireShowDataEvent();
       view.fireShowDataEvent();
    }

    //Model
   /* public List<String> getData() {
        List<String> data = new ArrayList<String>() {{
            add("First string");
            add("Second string");
            add("Third string");
        }};
        return data;
    }



  // View
    public void fireShowDataEvent() {
        System.out.println(onShowDataList());
    }


// Service
  /*  public List<String> getStringDataList() {
        return getData();
    }


 //Controller
  /*  public List<String> onShowDataList() {
        return getStringDataList();
    }

   */


}
