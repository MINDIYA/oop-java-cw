
import java.util.List;

//create SkinConsultationManager interface
public interface SkinConsultationManager {
    public void addDoctor(Doctor doctor);
    public void removeDoctor(Doctor doctor);
    public List<Doctor> getDoctors();
    public void bookConsultation(Consultation consultation);
    public void cancelConsultation(Consultation consultation);
    public List<Consultation> getConsultations();
}
