package logic;

import com.documentsystem.model.Businesspartner;
import java.util.ArrayList;
import java.util.List;



public class PartnerCollection
{
  private List<Businesspartner> lp;
  
  public PartnerCollection()
  {
    lp = new ArrayList();
  }
  
  public void addBPartner(Businesspartner bp) {
    lp.add(bp);
  }
  
  public List<Businesspartner> getPartners() {
    return lp;
  }
  
   public List<Businesspartner> getPartnerListConditional() {
    return lp;
  }
}
