package view;

import com.documentsystem.model.Businesspartner;
import com.documentsystem.model.City;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BusinessPartnerTableModel extends AbstractTableModel {

    private List<Businesspartner> bp;
    private final String[] columns = new String[]{"BpID", "Name", "City", "Account Number", "Address", "zip"}; //zip

    public BusinessPartnerTableModel(List<Businesspartner> bp) {
        this.bp = bp;
    }

    @Override
    public int getRowCount() {
        if (bp == null) {
            return 0;
        }
        return bp.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Businesspartner pp = (Businesspartner) bp.get(row);
        switch (column) {
            case 0:
                return pp.getBpID();
            case 1:
                return pp.getName();
            case 2:
                return pp.getCity().getCityName();
            case 3:
                return pp.getAccountNumber();
            case 4:
                return pp.getAddress();
            case 5:
                return pp.getCity().getZip();

        }

        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

//  @Override
//  public void setValueAt(Object aValue, int row, int column)
//  {
//    Businesspartner pp = bp.get(row);
//    switch (column) {
//    case 0: 
//      pp.setBpID(Integer.parseInt((String)aValue));
//      break;
//    
//    case 1: 
//      pp.setName((String)aValue);
//      break;
//    case 3: 
//      pp.setCity((City)aValue);
//       break;
//    case 4: 
//      pp.setAccountNumber((String)aValue);
//      break;
//    case 5: 
//      pp.setAddress((String)aValue);
//      break;
//    
//    
//    }
//    
//    fireTableCellUpdated(row, column);
//  }
    public Businesspartner getPartner(int row) {
        return bp.get(row);
    }

    public void addRow() {
        bp.add(new Businesspartner());
        System.out.println("New Business Partner added!");
        fireTableDataChanged();
    }

    public void deleteRow(int row) {
        bp.remove(row);
        System.out.println("Row deleted!");
        fireTableDataChanged();
    }

    public List<Businesspartner> getPartners() {
        return bp;
    }
}
