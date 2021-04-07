package Model;

import java.util.ArrayList;

public interface DataModel
{
User getUser();
ArrayList<Moderator> getModerators();
ArrayList<SimpleUser> getSimpleUser();
void addSimpleUser(SimpleUser simpleUser);

}
