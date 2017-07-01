package view;

import com.documentsystem.model.Businesspartner;
import com.documentsystem.model.Positions;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.FileHandler;
import javax.swing.table.AbstractTableModel;


public class PositionsTableModel
  extends AbstractTableModel
{
  private List<Positions> pos;
  private final String[] columns = { "posID", "Position Name", "Description", "Business System" };
  
  public PositionsTableModel(List<Positions> pos)
  {
    this.pos = pos;
  }
  
  @Override
  public int getRowCount()
  {
    if (pos == null) {
      return 0;
    }
    return pos.size();
  }
  
  @Override
  public int getColumnCount()
  {
    return columns.length;
  }
  

  @Override
  public Object getValueAt(int row, int column)
  {
    Positions p = (Positions)pos.get(row);
    
    switch (column)
    {
    case 0: 
      return p.getPosID();
    case 1: 
      return p.getPosName();
    case 2: 
      return p.getPosDescription();
    case 3:
        return p.getBusinesspartner().getBpID();
    }
    return "n/a";
  }
  


  @Override
  public String getColumnName(int column)
  {
    return columns[column];
  }
  


  @Override
  public void setValueAt(Object aValue, int row, int column)
  {
    Positions p = (Positions)pos.get(row);
    switch (column)
    {
    case 0: 
      p.setPosID(Integer.parseInt((String)aValue));
      break;
    case 1: 
      p.setPosName((String)aValue);
      break;
    case 2: 
      p.setPosDescription((String)aValue);
    }
    
    
    fireTableCellUpdated(row, column);
  }
  
  public Positions getPosition(int row)
  {
    return pos.get(row);
  }
  
  public void addRow()
  {
    pos.add(new Positions());
    System.out.println("New Position Added!");
    fireTableDataChanged();
  }
  
  public void deleteRow(int row) {
    pos.remove(row);
    System.out.println("Row deleted!");
    fireTableDataChanged();
  }
  
  public List<Positions> getPositionList()
  {
    return pos;
  }
  
  
}
