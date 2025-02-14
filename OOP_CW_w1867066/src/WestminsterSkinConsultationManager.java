
import java.io.*;//import package
import java.text.DateFormat;//import packages
import java.text.ParseException;//import package
import java.text.SimpleDateFormat;//import package
import java.util.*;//import package

public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    //describing the ArrayLists
    private static final int MAX_DOCTORS = 10;
    private static final String DOCTORS_FILE = "doctors.txt";
    private static final String CONSULTATIONS_FILE = "consultations.txt";
    private List<Doctor> doctors;
    private List<Consultation> consultations;

    //initializing ArrayLists
    public WestminsterSkinConsultationManager() {
        this.doctors = new ArrayList<>();
        this.consultations = new ArrayList<>();
    }



    public void addDoctor(Doctor doctor) {//defining method to add Doctors to "doctors" ArrayList.
        if (this.doctors.size() < MAX_DOCTORS) {
            this.doctors.add(doctor);
            System.out.println("Doctor added successfully.");
        } else {
            System.out.println("Error: Maximum number of doctors reached.");
        }
    }

    public void removeDoctor(Doctor doctor) {//defining method to remove Doctors from "doctors" ArrayList
        this.doctors.remove(doctor);
        System.out.println("Doctor removed successfully. Total number of doctors: " + this.doctors.size());
    }

    public List<Doctor> getDoctors() {//defining method to get Doctors List
        return this.doctors;
    }

    public void bookConsultation(Consultation consultation) {//defining method to book Consultation session
        this.consultations.add(consultation);
    }

    public void cancelConsultation(Consultation consultation) {//defining method to cancel book Consultation session
        this.consultations.remove(consultation);
    }

    public List<Consultation> getConsultations() {//defining method to get Consultations  List
        return this.consultations;
    }

    public void printDoctors() {//defining method to print Doctors List
        Collections.sort(this.doctors, (a, b) -> a.getSurname().compareTo(b.getSurname()));
        for (Doctor doctor : this.doctors) {
            System.out.println("Doctor's Full Name:"+doctor.getName() + " " + doctor.getSurname() + " "+" Doctor's Date of birth:" + doctor.getDateOfBirth() + " "+" Doctor's Mobile number:" + doctor.getMobileNumber() + " "+" Doctor's MedicalLicense Number:" + doctor.getMedicalLicenseNumber() + " "+" Doctor's Specialisation:" + doctor.getSpecialisation());
        }
    }

    public void saveData() {//defining method to save added Doctors  and  added consultation sessions to text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOCTORS_FILE))) {
            for (Doctor doctor : this.doctors) {
                writer.write(doctor.getName() + "," + doctor.getSurname() + "," + doctor.getDateOfBirth() + "," + doctor.getMobileNumber() + "," + doctor.getMedicalLicenseNumber() + "," + doctor.getSpecialisation() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + DOCTORS_FILE + ": " +e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONSULTATIONS_FILE))) {
            for (Consultation consultation : this.consultations) {
                writer.write(consultation.getDate() + "," + consultation.getTimeSlot() + "," + consultation.getCost() + "," + consultation.getNotes() + "," + consultation.getDoctor().getMedicalLicenseNumber() + "," + consultation.getPatient().getPatientId() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + CONSULTATIONS_FILE + ": " + e.getMessage());
        }
    }

    public void loadData() { //defining method to load data from text file
        try (BufferedReader reader = new BufferedReader(new FileReader(DOCTORS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                this.doctors.add(new Doctor(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file " + DOCTORS_FILE + ": " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(CONSULTATIONS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Doctor doctor = this.doctors.stream().filter(d -> d.getMedicalLicenseNumber().equals(parts[4])).findFirst().orElse(null);
                Patient patient = this.consultations.stream().map(Consultation::getPatient).filter(p -> p.getPatientId().equals(parts[5])).findFirst().orElse(null);
                this.consultations.add(new Consultation(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3], doctor, patient));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file " + CONSULTATIONS_FILE + ": " + e.getMessage());
        }
    }



    public void showMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while (running) {
                System.out.println("--------------Console Menu--------------");
                System.out.println("Enter  '1' to Add a new doctor");
                System.out.println("Enter  '2' to Delete a doctor");
                System.out.println("Enter  '3' to Print the list of the doctors");
                System.out.println("Enter  '4' to Save in a file");
                System.out.println("Enter  '6' to GUI");
                System.out.println("Enter  '5'Quite ");
                System.out.println("-------------------END-------------------");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1://calling addDoctor method

                        //getting  Name as the input
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        boolean valid = true;
                        for (int i = 0; i < name.length(); i++) {
                            char c = name.charAt(i);
                            if (!Character.isLetter(c)) {
                                valid = false;
                                break;
                            }
                        }

                        while (!valid) {
                            System.out.println("Error: Name must contain only letters.");
                            System.out.print("Enter name: ");
                            name = scanner.nextLine();

                            valid = true;
                            for (int i = 0; i < name.length(); i++) {
                                char c = name.charAt(i);
                                if (!Character.isLetter(c)) {
                                    valid = false;
                                    break;
                                }
                            }
                        }

                        //getting  surname as the input
                        System.out.print("Enter surname: ");
                        String surname = scanner.nextLine();
                        boolean SUvalid = true;
                        for (int i = 0; i < surname.length(); i++) {
                            char c = surname.charAt(i);
                            if (!Character.isLetter(c)) {
                                SUvalid = false;
                                break;
                            }
                        }

                        while (!SUvalid) {
                            System.out.println("Error: surname must contain only letters.");
                            System.out.print("Enter surname: ");
                            surname = scanner.nextLine();

                            SUvalid = true;
                            for (int i = 0; i < surname.length(); i++) {
                                char c = surname.charAt(i);
                                if (!Character.isLetter(c)) {
                                    SUvalid = false;
                                    break;
                                }
                            }
                        }

                        //getting  date of birth as the input
                        System.out.print("Enter date of birth Format 'dd/mm/yyy': ");
                        String dateOfBirth = scanner.nextLine();
                        DateFormat date = new SimpleDateFormat("dd/mm/yyy");
                        Date DOB = null;
                        while (DOB==null){
                            try {
                                DOB = date.parse(dateOfBirth);
                            } catch (ParseException e) {
                                System.out.println("Error:entered format not valid");
                                System.out.print("Enter date of birth Format 'dd/mm/yyy': ");
                                dateOfBirth = scanner.nextLine();

                                break;

                            }
                        }


                        //getting  mobile number as the input
                        System.out.print("Enter mobile number: ");
                        String mobileNumber = scanner.nextLine();
                        boolean Mvalid = true;
                        for (int i = 0; i < mobileNumber.length(); i++) {
                            char c = mobileNumber.charAt(i);
                            if (Character.isLetter(c)) {
                                Mvalid = false;
                                break;
                            }
                        }

                        while (!Mvalid) {
                            System.out.println("Error: mobile license number must contain only number.");
                            System.out.print("Enter mobile license number: ");
                            name = scanner.nextLine();

                            Mvalid = true;
                            for (int i = 0; i < mobileNumber.length(); i++) {
                                char c = mobileNumber.charAt(i);
                                if (!Character.isLetter(c)) {
                                    Mvalid = false;
                                    break;
                                }
                            }
                        }





                        //getting  medical license number as the input
                        System.out.print("Enter medical license number: ");
                        String medicalLicenseNumber = scanner.nextLine();
                        boolean Lvalid = true;
                        for (int i = 0; i < medicalLicenseNumber.length(); i++) {
                            char c = medicalLicenseNumber.charAt(i);
                            if (Character.isLetter(c)) {
                                Lvalid = false;
                                break;
                            }
                        }

                        while (!Lvalid) {
                            System.out.println("Error: medical license number must contain only number.");
                            System.out.print("Enter medical license number: ");
                            name = scanner.nextLine();

                            Lvalid = true;
                            for (int i = 0; i < medicalLicenseNumber.length(); i++) {
                                char c = medicalLicenseNumber.charAt(i);
                                if (!Character.isLetter(c)) {
                                    Lvalid = false;
                                    break;
                                }
                            }
                        }


                        //getting  specialisation as the input
                        System.out.print("Enter specialisation: ");
                        String specialisation = scanner.nextLine();

                        boolean pvalid = true;
                        for (int i = 0; i < specialisation.length(); i++) {
                            char s = specialisation.charAt(i);
                            if (!Character.isLetter(s)) {
                                pvalid = false;
                                break;
                            }
                        }

                        while (!pvalid) {
                            System.out.println("Error: specialisation must contain only letter. ");
                            System.out.print("Enter specialisation: ");
                            specialisation = scanner.nextLine();

                            pvalid = true;
                            for (int i = 0; i < specialisation.length(); i++) {
                                char s = specialisation.charAt(i);
                                if (!Character.isLetter(s)) {
                                    pvalid = false;
                                    break;
                                }
                            }
                        }



                        this.addDoctor(new Doctor(name, surname, dateOfBirth, mobileNumber, medicalLicenseNumber, specialisation));
                        break;//breaking the loop after executing
                    case 2://calling removeDoctor method
                        System.out.print("Enter medical license number: ");
                        medicalLicenseNumber = scanner.nextLine();
                        Doctor doctor = this.doctors.stream().filter(d -> d.getMedicalLicenseNumber().equals(medicalLicenseNumber)).findFirst().orElse(null);
                        if (doctor != null) {
                            this.removeDoctor(doctor);
                        } else {
                            System.out.println("Error: Doctor not found.");
                        }
                        break;//breaking the loop after executing
                    case 3:
                        this.printDoctors();//calling method
                        break;
                    case 4:
                        this.saveData();//calling method
                        break;
                    case 5:
                        running = false;
                        break;
                    case 6:
                        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();

                        SkinConsultationGUI GUI = new SkinConsultationGUI(manager);
                        GUI.setVisible(true);
                        break;//breaking the loop after executing
                    default:
                        System.out.println("Invalid choice.");//gets executed when an invalid number is entered

                }
            }
        } catch (InputMismatchException e) { //gets executed when input type is not a string
            System.out.println("Please enter a valid option.");
            showMenu();
        }
    }

    public static void main(String[] args) {//calling showMenu  and loadData methods
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.loadData();
        manager.showMenu();

    }

    public void addConsultation(Consultation consultation) {
    }

    public List<Doctor> getAvailableDoctors(String text, String text1) {
        return null;
    }

    public List<Consultation> getConsultationsForDoctor(Doctor doctor) {
        return null;
    }
}
