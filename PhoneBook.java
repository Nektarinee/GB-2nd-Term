package ru.geekbrains.Train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook
{
    private HashMap<String, String> phoneBook = new HashMap<>();

    public void addToPb(String surname, String phoneNumber)
    {
        phoneBook.put(surname,phoneNumber);
    }
    public void get(String surname)
    {
       surname = phoneBook.getOrDefault(surname, null);
        System.out.println( phoneBook.get(surname)+ "--> " + surname);
    }





}
