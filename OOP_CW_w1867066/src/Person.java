
import java.util.Date;//import package
// Create Person class
public class Person {
    //defining variables
    private String name;// private = restricted access
    private String surname;// private = restricted access
    private String dateOfBirth;// private = restricted access
    private String mobileNumber;// private = restricted access
    // Create a class constructor for the Person class with  parameters
    public Person(String name, String surname, String dateOfBirth, String mobileNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }
    // Getter
    public String getName() {
        return this.name;
    }
    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public String getSurname() {
        return this.surname;
    }
    // Setter
    public void setSurname(String surname) {
        this.surname = surname;
    }
    // Getter
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    // Setter
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = String.valueOf(dateOfBirth);
    }

    // Getter
    public String getMobileNumber() {
        return this.mobileNumber;
    }
    // Setter
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

class Doctor extends Person {
    //defining variables
    private String medicalLicenseNumber;// private = restricted access
    private String specialisation;// private = restricted access
    // Create a class constructor for the Doctor class with  parameters
    public Doctor(String name, String surname, String dateOfBirth, String mobileNumber, String medicalLicenseNumber, String specialisation) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialisation = specialisation;
    }
    // Getter
    public String getMedicalLicenseNumber() {
        return this.medicalLicenseNumber;
    }
    // Setter
    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }
    // Getter
    public String getSpecialisation() {
        return this.specialisation;
    }
    // Setter
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}

class Patient extends Person {
    //defining variable
    private String patientId;// private = restricted access
    // Create a class constructor for the Patient class with  parameters
    public Patient(String name, String surname, String dateOfBirth, String mobileNumber, String patientId) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.patientId = patientId;
    }
    // Getter
    public String getPatientId() {
        return this.patientId;
    }
    // Setter
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}



