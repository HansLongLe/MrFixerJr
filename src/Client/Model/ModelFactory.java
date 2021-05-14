package Client.Model;

public class ModelFactory
{
    private DataModel model;
    private User user;

    public DataModel getDataModel()
    {
        if (model == null)
        {
            model = new DataModelManager();
        }
        return model;
    }
    public User getUser(){
        if(user==null){
            user = new UserModelManager();
        }
        return user;
    }
}
