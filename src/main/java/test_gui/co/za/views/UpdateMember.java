package test_gui.co.za.views;

import test_gui.co.za.domain.members.Member;
import test_gui.co.za.services.impli.MemberServiceImpli;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateMember {
    private JPanel panelMain;
    private JTextField idTextfield;
    private JTextField firstNameTextfield;
    private JTextField lastNameTextField;
    private JButton updateButton;
    private JButton returnToMainMenuButton;
    JTable table;
    private JLabel lblHead;
    JFrame frame = new JFrame(("UpdateMember"));
    private MemberServiceImpli service = new MemberServiceImpli();
    Member member;


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
        updateMember.validID();
        updateMember.setText();

        //firstNameTextfield.setText(member.getFirstName());
        // lastNameTextField.setText(member.getLastName());

    }


    public void intialize() {

        frame.setContentPane(new UpdateMember().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();


    }

    public void setText() {
        String cheese = "cheese";

    }

    /*public JTable populatTable() {
        String[] columnNames = {"id",
                "firstName",
                "lastName"};


        List<String[]> rows = new ArrayList<String[]>();
        List<Member> members = service.findAll();
        for (Member s : members) {
            rows.add(new String[]{"" + s.getId(), s.getFirstName(), s.getLastName()});
        }
        TableModel tableModel = new DefaultTableModel(rows.toArray(new Object[][]{}), columnNames);
        JTable table1 = new JTable(tableModel);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table1), BorderLayout.CENTER);

        frame.add(table1.getTableHeader(), BorderLayout.NORTH);

        frame.setVisible(true);
        frame.setSize(200, 200);

        return table1;
    }

    public JTable createTable() {
        return table = populatTable();
    }*/


    public void validID() {
        Member member;
        Integer id = 0;


        do {

            try {
                id = Integer.parseInt(JOptionPane.showInputDialog("please enter VALID Member ID"));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Please Enter a valid ID NUMBER");

            }
            if (id == JOptionPane.CANCEL_OPTION) {
                MainMenu mainMenu = new MainMenu();
                member = new Member(0, "asdf", "asfd");
                mainMenu.setVisible(true);
            } else {
                member = service.findById(id);
                lastNameTextField.setText(member.getLastName());

                frame.setVisible(true);
                lastNameTextField.setText(member.getLastName());
            }
        }

        while (member == null);
        {

        }

    }

    public void load(Member member){
        idTextfield.setText(member.getId().toString());
        firstNameTextfield.setText(member.getFirstName());
        lastNameTextField.setText(member.getLastName());

    }
}

