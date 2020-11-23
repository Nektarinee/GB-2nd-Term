package ru.GeekBrains;

import java.util.Arrays;

public class Main
{
    static final int size = 10000000;
    static final int h = size / 2;
    static final float[] data1 = new float[size];
    static final float[] data2 = new float[h];


    public static void main(String[] args) throws ArrayIndexOutOfBoundsException
    {
	    firstArray();
	    secondArray();

    }



    public static void firstArray()
    {
        Arrays.fill(data1,1.0f);
        long a = System.currentTimeMillis();
       // System.out.println(Arrays.toString(data1));
        for (int i = 0; i < data1.length; i++)
        {
            data1[i] = (float) (data1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время затраченное на цикл рассчёта : " + (System.currentTimeMillis() - a));
    }

    public static void secondArray() throws ArrayIndexOutOfBoundsException
    {
        long secOperationTime = System.currentTimeMillis();
        float arr1[] = new float[h];
        float arr2[] = new float[h];
        float commonArr [] = new float[size];
        System.arraycopy(data1,0,arr1,data1.length-h-1,h);
        System.arraycopy(data1,h+1,arr2,data1.length-1,h);
        Thread thread1 = new Thread();
        Thread thread2 = new Thread();
        thread1.start();
        for (int i = 0; i < arr1.length; i++)
        {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        thread2.start();
        for (int i = 0; i < arr2.length; i++)
        {
            arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        System.arraycopy(arr1, 0, commonArr, 0, h);
        System.arraycopy(arr2, 0, commonArr, h, h);
        System.out.println("Время затраченное на выполнение второй операции : " + (System.currentTimeMillis() - secOperationTime));





    }




}

