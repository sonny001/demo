package com.error.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ErrorDemo {

    public static void main(String[] args) {
        listError();
    }

    private static void listError(){
        String [] str={"1","2","3"};
        List<String> errorDemo= Arrays.asList(str);
        for (String param:errorDemo
        ) {
            System.out.println(param);
        }

        List<String> demo=new ArrayList<>(Arrays.asList(str));
        for (String param:demo
        ) {
            System.out.println(param);
        }
    }

    private static void delObj(){
        String [] str={"1","2","3"};
        List<String> demo=new ArrayList<>(Arrays.asList(str));
        for (String param:demo
        ) {
            System.out.println(param);
        }
        Iterator<String> iterator=demo.iterator();
    }

}
