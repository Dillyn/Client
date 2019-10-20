package test_gui.co.za.views;

import test_gui.co.za.domain.members.Member;
import test_gui.co.za.services.MemberService;
import test_gui.co.za.services.impli.MemberServiceImpli;
import test_gui.co.za.util.AppUtil;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterMember extends JFrame{
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JButton createButton;
    private JButton cancelButton;
    private JPanel panelMain;
    private AppUtil util = new AppUtil();

    private MemberServiceImpli memberServiceImpli = new MemberServiceImpli();




    public RegisterMember() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String firstName;
                String lastName;

                if ((util.isStringOnlyAlphabet(firstNameTextField.getText()) == true) && (util.isStringOnlyAlphabet(lastNameTextField.getText()) == true)) {
                    firstName = firstNameTextField.getText().toUpperCase();
                    lastName = lastNameTextField.getText().toUpperCase();


                    Member member = memberServiceImpli.save((new Member(null, firstName, lastName))); // saving member

                    if (member != null) {
                        JOptionPane.showMessageDialog(null, util.getRecordsAdded(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE); //add
                    } else
                        JOptionPane.showMessageDialog(null, util.getRecordsFilled() + "\nFirstname and Lastname must contain alphabet characters only", "INFO", JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, util.getRecordsNotAdded() + "\nMember code already exist", "ERROR", JOptionPane.ERROR_MESSAGE); //not added
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
        RegisterMember registerMember = new RegisterMember();
        registerMember.intialize();
    }

    public void intialize(){
        JFrame frame = new JFrame(("RegisterMember"));
        frame.setContentPane(new RegisterMember().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

   /* public Object createMember(){

    } */
}
