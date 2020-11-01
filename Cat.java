package ru.GeekBrains;


public class Cat implements Participants
{
    int RunningTrackDistance = 3500;
    int wallHeight = 10;
    int maxCatJumpHeight = 25;
    int maxCatRunDistance = 2000;
    @Override
    public void jump()
    {
     if (maxCatJumpHeight>=wallHeight)
     {
         System.out.println("Кошка смогла перепрыгнуть");
     }
     else
         {
             System.out.println("Кошка не смогла перепрыгнуть");
         }
    }

    @Override
    public void run()
    {
        if (maxCatRunDistance>= RunningTrackDistance)
        {
            System.out.println("Кошка смогла пробежать");
        }
        else
            {
                System.out.println("Кошка не смогла пробежать");
            }

    }
    public void Cat{maxCatRunDistance,maxCatJumpHeight}
}
