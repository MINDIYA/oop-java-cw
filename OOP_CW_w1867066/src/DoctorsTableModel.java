
import javax.swing.table.AbstractTableModel;
import java.util.List;
//create DoctorsTableModel class and extends it with AbstractTableModel
public class DoctorsTableModel extends AbstractTableModel {
    //defining variables
    private List<Doctor> doctors;
    private final String[] columnNames = {"Name", "Surname", "Date of Birth", "Mobile Number", "Medical License Number", "Specialisation"};
    //create constructor
    public DoctorsTableModel(List<Doctor> doctors) {
        this.doctors = doctors;
    }
    //create updateDoctors method
    public void updateDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
        fireTableDataChanged();
    }
    //create getDoctorAt method
    public Doctor getDoctorAt(int row) {
        return this.doctors.get(row);
    }

    @Override
    public int getRowCount() {
        return this.doctors.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doctor doctor = this.doctors.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return doctor.getName();
            case 1:
                return doctor.getSurname();
            case 2:
                return doctor.getDateOfBirth();
            case 3:
                return doctor.getMobileNumber();
            case 4:
                return doctor.getMedicalLicenseNumber();
            case 5:
                return doctor.getSpecialisation();
            default:
                return null;
        }
    }
}
