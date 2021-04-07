package Client.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private String userName;
    private String password;
    private String ajajaja;
    private User user = new User("name", "123");


    @Test
    void setPassword(){
        String newPassword = "123";
        user.setPassword(newPassword);
        assertTrue(user.getPassword().equals("123"));
    }

    @Test
    void testEquals()
    {
        User user1 = new User("name", "123");
        assertTrue(user.equals(user1));
    }


}