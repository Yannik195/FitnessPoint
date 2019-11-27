package de.yanniksimon.fitnesspoint.Helpers;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DummyData {

    public DummyData(){

    }

    public void addDummyData(FirebaseFirestore db){
        addUsers(db);
        addCities(db);
        addItems(db);
    }

    public void addUsers(FirebaseFirestore db){
        CollectionReference users = db.collection("users");

        Map<String, Object> user1 = new HashMap<>();
        user1.put("name", "Yannik");
        user1.put("lastname", "Simon");
        user1.put("age", 21);
        user1.put("dateOfBirth", "30.12.1997");
        user1.put("profession", "Student");
        users.document("user1").set(user1);

        Map<String, Object> user2 = new HashMap<>();
        user2.put("name", "Anne-Marie");
        user2.put("lastname", "Schulz");
        user2.put("age", 19);
        user2.put("dateOfBirth", "12.6.2000");
        user2.put("profession", "Florist");
        users.document("user2").set(user2);

        Map<String, Object> user3 = new HashMap<>();
        user3.put("name", "Sebastian");
        user3.put("lastname", "Neumann");
        user3.put("age", 20);
        user3.put("dateOfBirth", "9.3.1998");
        user3.put("profession", "Ingenieur");
        users.document("user3").set(user3);
    }

    public void addCities(FirebaseFirestore db){
        CollectionReference cities = db.collection("cities");

        Map<String, Object> data1 = new HashMap<>();
        data1.put("name", "San Francisco");
        data1.put("state", "CA");
        data1.put("country", "USA");
        data1.put("capital", false);
        data1.put("population", 860000);
        data1.put("regions", Arrays.asList("west_coast", "norcal"));
        cities.document("SF").set(data1);

        Map<String, Object> data2 = new HashMap<>();
        data2.put("name", "Los Angeles");
        data2.put("state", "CA");
        data2.put("country", "USA");
        data2.put("capital", false);
        data2.put("population", 3900000);
        data2.put("regions", Arrays.asList("west_coast", "socal"));
        cities.document("LA").set(data2);

        Map<String, Object> data3 = new HashMap<>();
        data3.put("name", "Washington D.C.");
        data3.put("state", null);
        data3.put("country", "USA");
        data3.put("capital", true);
        data3.put("population", 680000);
        data3.put("regions", Arrays.asList("east_coast"));
        cities.document("DC").set(data3);

        Map<String, Object> data4 = new HashMap<>();
        data4.put("name", "Tokyo");
        data4.put("state", null);
        data4.put("country", "Japan");
        data4.put("capital", true);
        data4.put("population", 9000000);
        data4.put("regions", Arrays.asList("kanto", "honshu"));
        cities.document("TOK").set(data4);

        Map<String, Object> data5 = new HashMap<>();
        data5.put("name", "Beijing");
        data5.put("state", null);
        data5.put("country", "China");
        data5.put("capital", true);
        data5.put("population", 21500000);
        data5.put("regions", Arrays.asList("jingjinji", "hebei"));
        cities.document("BJ").set(data5);
    }

    public void addItems(FirebaseFirestore db){
        CollectionReference items = db.collection("items");

        Map<String, Object> item1 = new HashMap<>();
        item1.put("name", "Schaufel");
        item1.put("price", 2);
        item1.put("inStock", 90);
        items.document("item1").set(item1);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("name", "Löffel");
        item2.put("price", 1);
        item2.put("inStock", 120);
        items.document("item2").set(item2);

        Map<String, Object> item3 = new HashMap<>();
        item3.put("name", "Wasser");
        item3.put("price", 5);
        item3.put("inStock", 12);
        items.document("item3").set(item3);

        Map<String, Object> item4 = new HashMap<>();
        item4.put("name", "Teppich");
        item4.put("price", 3);
        item4.put("inStock", 80);
        items.document("item4").set(item4);

    }
}
