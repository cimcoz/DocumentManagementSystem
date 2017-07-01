package logic;

import com.documentsystem.model.City;
import java.util.ArrayList;
import java.util.List;



public class CityCollection
{
  private List<City> lc;
  
  public CityCollection()
  {
    lc = new ArrayList();
  }
  
  public void addCity(City c) {
    lc.add(c);
  }
  
  public List<City> getCityList() {
    return lc;
  }
}
