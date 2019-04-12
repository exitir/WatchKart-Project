package com.turvoassignment.ecommerce.wristwatch.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.turvoassignment.ecommerce.wristwatch.models.Address;
import com.turvoassignment.ecommerce.wristwatch.models.FlashSale;
import com.turvoassignment.ecommerce.wristwatch.models.ResponseEnum;
import com.turvoassignment.ecommerce.wristwatch.models.Time;
import com.turvoassignment.ecommerce.wristwatch.models.User;
import com.turvoassignment.ecommerce.wristwatch.models.Watch;
import com.turvoassignment.ecommerce.wristwatch.models.WatchKart;
import com.turvoassignment.ecommerce.wristwatch.response.FlashSaleRegistrationServiceResponse;

public class WatchKartUtil {

    public static void initializeTheWatchKartCompany(WatchKart wk) {
        initializeTheWatchKartUsers(wk);
        initializeTheWatchKartWatches(wk);
        initializeTheWatchKartFlashSale(wk);

    }

    private static void initializeTheWatchKartUsers(WatchKart wk) {

        User user1 = new User();
        user1.setUserid("654231Rahul"); // userid=ssn+firstname
        user1.setPassword("rahul@123");
        user1.setSsn("654231");
        user1.setFirstName("Rahul");
        user1.setLastName("Roy");
        user1.setEmail("rahulroy@bollywood.com");
        user1.setPhone("9872342343");
        Address add1 = new Address();
        add1.setAddrLine1("Bollywood city");
        add1.setAddrLine1("Bollywood Road");
        add1.setCity("Mumbai");
        add1.setLandmark("GateWay of India");
        add1.setState("Maharashtra");
        add1.setZip("234234");
        user1.setAddress(add1);

        User user2 = new User();
        user2.setUserid("64566Salman"); // userid=ssn+firstname
        user2.setPassword("salman@123");
        user2.setSsn("64566");
        user2.setFirstName("Salman");
        user2.setLastName("Khan");
        user2.setEmail("salman@bollywood.com");
        user2.setPhone("8734565423");
        Address add2 = new Address();
        add2.setAddrLine1("Bandra");
        add2.setAddrLine1("Boxoffice road");
        add2.setCity("Mumbai");
        add2.setLandmark("Juhu");
        add2.setState("Maharashtra");
        add2.setZip("654756");
        user2.setAddress(add2);

        User admin = new User();
        admin.setUserid("71807Irfan"); // userid=ssn+firstname
        admin.setPassword("Irfan@123");
        admin.setSsn("71807");
        admin.setFirstName("Irfan");
        admin.setLastName("Ansari");
        admin.setAdminUser(true);

        wk.getUsers().add(user1);
        wk.getUsers().add(user2);
        wk.getUsers().add(admin);

    }

    private static void initializeTheWatchKartWatches(WatchKart wk) {

        Watch watch1 = new Watch();
        watch1.setWatchId("rolex001");
        watch1.setBrand("Rolex");
        watch1.setPrice(1000); // assumption: USD
        watch1.setStockAvailable(275);

        Watch watch2 = new Watch();
        watch2.setWatchId("timex001");
        watch2.setBrand("Timex");
        watch2.setPrice(700); // assumption : USD
        watch2.setStockAvailable(275);

        Watch watch3 = new Watch();
        watch3.setWatchId("gshock001");
        watch3.setBrand("GShock");
        watch3.setPrice(400); // assumption : USD
        watch3.setStockAvailable(275);

        wk.getWatchs().add(watch1);
        wk.getWatchs().add(watch2);
        wk.getWatchs().add(watch3);

    }

    private static void initializeTheWatchKartFlashSale(WatchKart wk) {

        FlashSale flashSale = new FlashSale();
        flashSale.setFlashSaleId("BLKFRI");
        flashSale.setDate(new Date(2019, 03, 10));
        flashSale.setTimeStart(new Time(8, 00, 00)); // 24 hour format
        flashSale.setDuration(4);// hours
        List<String> watchesOnSale = new ArrayList<String>();
        watchesOnSale.add("rolex001");
        watchesOnSale.add("gshock001");
        flashSale.setWatchIdsOnSale(watchesOnSale);
        List<String> registeredUserForSale = new ArrayList<String>();
        registeredUserForSale.add("654231Rahul");
        registeredUserForSale.add("64566Salman");

        List<FlashSale> flashSales = new ArrayList<FlashSale>();
        flashSales.add(flashSale);
        wk.setFlashSales(flashSales);

    }



}
