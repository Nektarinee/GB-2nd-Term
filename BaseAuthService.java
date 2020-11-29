package chat.auth;

import chat.User;

import java.util.List;


public class BaseAuthService
{
    private static final List<User> clients = List.of(
            new User("user1","11111","Boris"),
            new User("user2","22222","Timofei"),
            new User("user3","33333","Nikita")

    );

    public String getUserNameByLoginAndPassword(String login, String password)
    {

        for (User client :clients )
        {
            if (client.getLogin().equals(login) & client.getPassword().equals(password))
            {
                return client.getUsername();
            }
        }
        return null;
    }
}
