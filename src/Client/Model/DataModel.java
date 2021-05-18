package Client.Model;

import java.util.ArrayList;

public interface DataModel
{
    ArrayList<Moderator> allModerators();
    ArrayList<SimpleUser> allSimpleUsers();
    User getUser();
    String getType();
    void addSimpleUser(SimpleUser simpleUser);
    void addModerator(Moderator moderator);


}
