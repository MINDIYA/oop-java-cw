import java.util.Date;
//create Consultation class
public class Consultation  {
    //defining variables
    private String date;
    private String timeSlot;
    private double cost;
    private String notes;
    private Doctor doctor;
    private Patient patient;
    //create Consultation class constructor
    public Consultation(String date, String timeSlot, double cost, String notes, Doctor doctor, Patient patient) {
        this.date = date;
        this.timeSlot = timeSlot;
        this.cost = cost;
        this.notes = notes;
        this.doctor = doctor;
        this.patient = patient;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = String.valueOf(date);
    }

    public String getTimeSlot() {
        return this.timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public char[] getTime() {
        return new char[0];
    }
}
