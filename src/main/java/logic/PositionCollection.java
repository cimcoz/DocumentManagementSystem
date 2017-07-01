package logic;

import com.documentsystem.model.Positions;
import java.util.ArrayList;
import java.util.List;



public class PositionCollection
{
  private List<Positions> lp;
  
  public PositionCollection()
  {
    lp = new ArrayList();
  }
  
  public void addPosition(Positions pos) {
    lp.add(pos);
  }
  
  public List<Positions> getPositionList() {
    return lp;
  }
}
