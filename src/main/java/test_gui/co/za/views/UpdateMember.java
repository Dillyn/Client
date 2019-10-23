package test_gui.co.za.views;

import test_gui.co.za.domain.members.Member;
import test_gui.co.za.services.impli.MemberServiceImpli;
import test_gui.co.za.util.AppUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMember {
    private JPanel panelMain;
    private JTextField idTextField;
    private JTextField firstNameTextfield;
    private JTextField lastNameTextField;
    private JButton updateButton;
    private JButton returnToMainMenuButton;
    JTable table;
    private JLabel lblHead;
    JFrame frame = new JFrame(("UpdateMember"));
    MemberServiceImpli service = new MemberServiceImpli();
    AppUtil util = new AppUtil();
    Integer id;

    Member member;


    public UpdateMember() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName;
                String lastName;

                if ((util.isStringOnlyAlphabet(firstNameTextfield.getText()) == true) && (util.isStringOnlyAlphabet(lastNameTextField.getText()) == true && !idTextField.getText().equals(""))) {
                    firstName = firstNameTextfield.getText().toUpperCase();
                    lastName = lastNameTextField.getText().toUpperCase();

                    try {
                        id = Integer.parseInt(idTextField.getText());
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Please Enter a valid ID NUMBER. NUMBERS ONLY");
                        idTextField.setText("");
                    }

                    member = service.findById(id);
                    if (member == null) {
                        JOptionPane.showMessageDialog(null, "Member does not exist");
                        idTextField.setText("");
                        firstNameTextfield.setText("");
                        lastNameTextField.setText("");

                    } else if (member != null) {
                        int n = JOptionPane.showConfirmDialog(
                                null, "Would you like to update this member" + "\n" + member.toString(), "Are you sure?",
                                JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            Member member = service.update((new Member(id, firstName, lastName))); // saving member
                            idTextField.setText("");
                            firstNameTextfield.setText("");
                            lastNameTextField.setText("");
                            JOptionPane.showMessageDialog(null, util.getRecordsUpdated(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE); //update
                        } else if (n == JOptionPane.NO_OPTION) {
                            idTextField.setText("");
                            firstNameTextfield.setText("");
                            lastNameTextField.setText("");
                        }

                    } else if ((util.isStringOnlyAlphabet(firstNameTextfield.getText()) == false) || (util.isStringOnlyAlphabet(lastNameTextField.getText()) == false))
                        JOptionPane.showMessageDialog(null, util.getRecordsFilled() + "\nFirstname and Lastname must contain alphabet characters only" +
                                "\nPlease Enter a valid ID NUMBER - refer to VIEW ALL MEMBERs FORM", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(null, util.getNoBlankFields() + "\nPLEASE ENTER VALID DETAILS" +"\nID MUST BE AN EXITING NUMBER"+"\nFIRSTNAME AND LASTNAME MUST CONTAIN ALPHABET ONLY", "ERROR", JOptionPane.ERROR_MESSAGE); //not added
                //
            }
        });
    }

    public static void main(String[] args) {
       /* EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu frame = new MainMenu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/
        UpdateMember updateMember = new UpdateMember();
        updateMember.intialize();


        //firstNameTextfield.setText(member.getFirstName());
        // lastNameTextField.setText(member.getLastName());

    }


    public void intialize() {
        frame.setVisible(true);
        frame.setContentPane(new UpdateMember().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBounds(100, 100, 390, 210);


    }

}

