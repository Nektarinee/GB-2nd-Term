package ru.GeekBrains;

public class Robot implements Participants
{
    String name = "R2D2";

    int RunningTrackDistance = 3500;
    int wallHeight = 10;
    int maxRobotJumpHeight = 10;
    int maxRobotRunDistance = 50;
    @Override
    public void jump()
    {
        if (maxRobotJumpHeight>=wallHeight)
        {
            System.out.println("Робот смог перепрыгнуть");
        }
        else
        {
            System.out.println("Робот не смог перепрыгнуть");
        }

    }

    @Override
    public void run()
    {
        if (maxRobotRunDistance>= RunningTrackDistance)
    {
        System.out.println("Робот смогл пробежать");
    }
    else
    {
        System.out.println("Робот не смог пробежать");
    }


    }
}
