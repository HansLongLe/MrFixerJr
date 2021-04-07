package Model;

import Client.DataModel;
import Client.Model.DataModel;
import Client.Model.DataModelManager;

public class Modelfactory
{
  private DataModel model;
  public DataModel getDataModel(){
    if(model==null){
      model = new DataModelManager();
    }
    return model;
  }
}
