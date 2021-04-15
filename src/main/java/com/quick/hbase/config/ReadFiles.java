package com.quick.hbase.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFiles {
    public static ArrayList<String> work() throws Exception{
        ArrayList<String> list = new ArrayList<>();
        try {
            File inputFile = new File("/Users/a645661167/Downloads/aaa.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) throws Exception{
        ArrayList<String> list = work();
        for(String str:list){
            System.out.println(str);
        }
    }
}
