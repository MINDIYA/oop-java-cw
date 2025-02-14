
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

// Create SkinConsultationGUI class
public class SkinConsultationGUI extends JFrame {
    //defining variables
    private WestminsterSkinConsultationManager manager;
    private DoctorsTableModel doctorsTableModel;
    private JTable doctorsTable;
    private JButton addDoctorButton;
    private JButton deleteDoctorButton;
    private JButton addConsultationButton;
    private JButton viewConsultationButton;
    // Create a class constructor for the SkinConsultationGUI class
    public SkinConsultationGUI(WestminsterSkinConsultationManager manager) {
        this.manager = manager;
        this.doctorsTableModel = new DoctorsTableModel(manager.getDoctors());
        this.doctorsTable = new JTable(this.doctorsTableModel);
        this.addDoctorButton = new JButton("Add Doctor");
        this.deleteDoctorButton = new JButton("Delete Doctor");
        this.addConsultationButton =new JButton("Add Consultation");
        this.viewConsultationButton = new JButton("View Consultation");


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.GRAY);
        buttonsPanel.add(this.addDoctorButton);
        buttonsPanel.add(this.deleteDoctorButton);
        buttonsPanel.add(this.addConsultationButton);
        buttonsPanel.add(this.viewConsultationButton);

        this.add(new JScrollPane(this.doctorsTable), BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        this.addDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDoctor();
            }
        });

        this.deleteDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDoctor();
            }
        });

        this.addConsultationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addConsultation();
            }
        });

        this.viewConsultationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewConsultation();
            }
        });

        this.setTitle("Skin Consultation Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);




    }
    //calling addDoctor method
    private void addDoctor() {
        //creating add doctor fields
        JTextField nameField = new JTextField(20);
        JTextField surnameField = new JTextField(20);
        JTextField dateOfBirthField = new JTextField(20);
        JTextField mobileNumberField = new JTextField(20);
        JTextField medicalLicenseNumberField = new JTextField(20);
        JTextField specialisationField = new JTextField(20);

        //creating add doctor panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.lightGray);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Name: "), constraints);
        constraints.gridx = 1;
        panel.add(nameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Surname: " ), constraints);
        constraints.gridx = 1;
        panel.add(surnameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Date of Birth: "), constraints);
        constraints.gridx = 1;
        panel.add(dateOfBirthField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Mobile Number: "), constraints);
        constraints.gridx = 1;
        panel.add(mobileNumberField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(new JLabel("Medical License Number: "), constraints);
        constraints.gridx = 1;
        panel.add(medicalLicenseNumberField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(new JLabel("Specialisation: "), constraints);
        constraints.gridx = 1;
        panel.add(specialisationField, constraints);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Doctor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Doctor doctor = new Doctor(nameField.getText(), surnameField.getText(), dateOfBirthField.getText(), mobileNumberField.getText(), medicalLicenseNumberField.getText(), specialisationField.getText());
            this.manager.addDoctor(doctor);
            this.doctorsTableModel.updateDoctors(this.manager.getDoctors());
        }
    }
    //calling deleteDoctor method
    private void deleteDoctor() {
        int row = this.doctorsTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a doctor to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Doctor doctor = this.doctorsTableModel.getDoctorAt(row);
        this.manager.removeDoctor(doctor);
        this.doctorsTableModel.updateDoctors(this.manager.getDoctors());
    }
    //calling addConsultation method
    private void addConsultation() {
        //creating addConsultation TextField
        JTextField dateField = new JTextField(20);
        JTextField timeField = new JTextField(20);
        JTextField patientNameField = new JTextField(20);
        JTextField patientSurnameField = new JTextField(20);
        JTextField patientDateOfBirthField = new JTextField(20);
        JTextField patientMobileNumberField = new JTextField(20);
        JTextField patientIdField = new JTextField(20);
        JTextField notesField = new JTextField(20);

        //creating addConsultation panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.lightGray);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Date: "), constraints);
        constraints.gridx = 1;
        panel.add(dateField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Time: "), constraints);
        constraints.gridx = 1;
        panel.add(timeField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Patient Name: "), constraints);
        constraints.gridx = 1;
        panel.add(patientNameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Patient Surname: "), constraints);
        constraints.gridx = 1;
        panel.add(patientSurnameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(new JLabel("Patient Date of Birth: "), constraints);
        constraints.gridx = 1;
        panel.add(patientDateOfBirthField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(new JLabel("Patient Mobile Number: "), constraints);
        constraints.gridx = 1;
        panel.add(patientMobileNumberField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(new JLabel("Patient ID: "), constraints);
        constraints.gridx = 1;
        panel.add(patientIdField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(new JLabel("Notes: "), constraints);
        constraints.gridx = 1;
        panel.add(notesField, constraints);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Consultation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            Patient patient = new Patient(patientNameField.getText(), patientSurnameField.getText(), patientDateOfBirthField.getText(), patientMobileNumberField.getText(), patientIdField.getText());
            String notes = notesField.getText();

            int cost = 15;
            String[] timeParts = timeField.getText().split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            if (hours > 0 || minutes > 0) {
                cost += 25 * (hours + minutes / 60);
            }
            Consultation consultation = new Consultation(dateField.getText(), timeField.getText(), cost, notes,null, patient);
            List<Doctor> availableDoctors = this.manager.getAvailableDoctors(dateField.getText(), timeField.getText());
            if (availableDoctors.isEmpty()) {
                JOptionPane.showMessageDialog(this, "There are no available doctors for the chosen date and time. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Random random = new Random();
            int index = random.nextInt(availableDoctors.size());
            Doctor doctor = availableDoctors.get(index);
            consultation.setDoctor(doctor);
            this.manager.addConsultation(consultation);
        }
    }
    //calling viewConsultation method
    private void viewConsultation() {
        int row = this.doctorsTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a doctor to view consultations.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Doctor doctor = this.doctorsTableModel.getDoctorAt(row);
        List<Consultation> consultations = this.manager.getConsultationsForDoctor(doctor);
        StringBuilder builder = new StringBuilder();
        for (Consultation consultation : consultations) {
            builder.append("Date: ").append(consultation.getDate()).append("\n");
            builder.append("Time: ").append(consultation.getTime()).append("\n");
            builder.append("Cost: ").append(consultation.getCost()).append("\n");
            String notes;

            builder.append("Patient: ").append(consultation.getPatient().getName()).append(" ").append(consultation.getPatient().getSurname()).append("\n\n");
        }
        JTextArea textArea = new JTextArea(builder.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(this, scrollPane, "Consultations for " + doctor.getName() + " " + doctor.getSurname(), JOptionPane.PLAIN_MESSAGE);
    }
}
