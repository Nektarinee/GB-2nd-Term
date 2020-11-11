package ru.geekbrains.Train;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static final String[] myArr =
            {
                    "a","b","c","d","a","a","e","b","c","b","f","h","c","b","a","b","c","a","a","b"
            };

    public static void main(String[] args)
    {
        Map<String,Integer> coincidenceOfWords = new HashMap<>();
        for (String word:myArr)
        {
         Integer coincidence = coincidenceOfWords.getOrDefault(word,0);
         coincidenceOfWords.put(word, coincidence+1);
        }
        for (String word : coincidenceOfWords.keySet())
        {
            Integer coincidence = coincidenceOfWords.get(word);
            System.out.println(word + "-> " + coincidence);
        }



        PhoneBook one = new PhoneBook();
        one.addToPb("Lupanov", "+7(777)777-77-77");
        one.addToPb("Tsvetkov", "+8(888)888-88-88");
        one.addToPb("Lupanov", "+9(999)999-99-99");
        one.addToPb("Smirnov", "+0(000)000-00-00");
        one.get("Lupanov");

    }
}
