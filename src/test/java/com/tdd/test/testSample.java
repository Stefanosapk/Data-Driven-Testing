package com.tdd.test;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

    public static void main(String[] args) throws IOException {

        dataDriven d = new dataDriven();

        //apothikeuw ta data se tupou arraylist gt erxontai hdh apothikeumena apo arraylist
        ArrayList data = d.getData("Costa");
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));

    }

}
