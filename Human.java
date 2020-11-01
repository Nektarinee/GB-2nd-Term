package ru.GeekBrains;

public class Human implements Participants
{
    String name = "Никита";


    int RunningTrackDistance = 3500;
    int wallHeight = 10;
    int maxHumanJumpHeight = 3;
    int maxHumanRunDistance = 3000;
    @Override
    public void jump()
    {
        if (maxHumanJumpHeight>=wallHeight)
        {
            System.out.println("Человек смог перепрыгнуть");
        }
        else
        {
            System.out.println("Человек не смог перепрыгнуть");
        }

    }

    @Override
    public void run()
    {
        if (maxHumanRunDistance>= RunningTrackDistance)
        {
            System.out.println("Человек смог пробежать");
        }
        else
        {
            System.out.println("Человек не смог пробежать");
        }


    }

}
