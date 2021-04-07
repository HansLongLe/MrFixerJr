package Client.Model;

public class ModelFactory
{
    private DataModel model;

    public DataModel getDataModel()
    {
        if (model == null)
        {
            model = new DataModelManager();
        }
        return model;
    }
}
