package ru.GeekBrains;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws MyArraySizeException,MyArrayDataException
    {
        tryArray();



    }
   private static void tryArray() throws MyArraySizeException, MyArrayDataException
   {
       // 2 массива для проверки работы программы
     //  String myArr[][] = new String[4][4];
       //       for (int i = 0; i < myArr.length; i++)
//       {
//           for (int j = 0; j < myArr[i].length; j++)
//           {
//               myArr[i][j] = j + "1";
//           }
//       }
//       System.out.print(Arrays.deepToString(myArr));
       String myArr[][] ={{"1","2","3","4"},{"F","2","3","4"},{"1","2","3","4"},{"1","Where","3","4"}};
       System.out.print(Arrays.deepToString(myArr));


            if (myArr.length == 4 && myArr[0].length==4)
            {
                System.out.println("Массив правильного размера");
            }
            else
                {
                    throw new MyArraySizeException("Размер массива не соответствует ожиданию(4х4)");
                }
        int sum = 0;
       for (int i = 0; i < myArr.length; i++)
       {
           for (int j = 0; j < myArr[i].length; j++)
           {
               try
               {
                   sum += Integer.parseInt(myArr[i][j]);
               }
               catch (NumberFormatException e)
               {
                   throw new MyArrayDataException("Ячейка не была переведена в int: " + e);
               }
           }

       }
       System.out.println(sum);





   }
}
