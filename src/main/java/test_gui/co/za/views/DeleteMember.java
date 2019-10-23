package test_gui.co.za.views;

import org.springframework.web.bind.annotation.DeleteMapping;
import test_gui.co.za.domain.members.Member;
import test_gui.co.za.services.impli.MemberServiceImpli;
import test_gui.co.za.util.AppUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMember extends JFrame {
    private JPanel panelMain;
    private JTextField idTextField;
    private JButton deleteButton;
    private JButton returnToMainMenuButton;
    Integer id;
    MemberServiceImpli service = new MemberServiceImpli();
    private AppUtil util = new AppUtil();


    public static void main(String[] args) {
        DeleteMember delete = new DeleteMember();
        delete.intialize();

    }


    //action
    public DeleteMember() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!idTextField.getText().equals("")) {

                    try {
                        id = Integer.parseInt(idTextField.getText());
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Please Enter a valid ID NUMBER - refer to VIEW ALL MEMBERS FORM");
                        idTextField.setText("");
                    }


                    Member member = service.findById(id);
                    JFrame frame = new JFrame(("MainMenu"));
                    if (member != null) {
                        int n = JOptionPane.showConfirmDialog(
                                null, "Would you like to delete this member" + "\n" + member.toString(), "Are you sure?",
                                JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            service.delete(id);
                            idTextField.setText("");
                            JOptionPane.showMessageDialog(null, util.getDeleteRecord(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE); //Delete
                        } else if (n == JOptionPane.NO_OPTION) {
                            idTextField.setText("");
                        } else {
                            idTextField.setText("");
                        }

                    } else
                        JOptionPane.showMessageDialog(null, util.getNotExistRecord() + "\nPlease enter an existing member that you would like to delete", "ERROR", JOptionPane.ERROR_MESSAGE); //does not exist
                } else
                    JOptionPane.showMessageDialog(null, util.getRecordsFilled(), "INFO", JOptionPane.INFORMATION_MESSAGE);


            }
        });

        ///mainmenu button
        returnToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainMenu mainMenu = new MainMenu();
                mainMenu.intialize();
                dispose();

            }
        });
    }

    //init
    private void intialize() {
        pack();
        setVisible(true);
        setContentPane(new DeleteMember().panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 390, 170);


    }
}
