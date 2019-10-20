package test_gui.co.za.views;

import test_gui.co.za.domain.members.Member;
import test_gui.co.za.services.impli.MemberServiceImpli;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;

public class ReadAll {
    private JPanel panelMain;
    private JPanel south;
    JFrame frame = new JFrame(("ReadAll"));
    JButton update = new JButton("Refresh Table");
    JButton mainMenu = new JButton("Return to Main Menu");

    private MemberServiceImpli service = new MemberServiceImpli();

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
        ReadAll readAll = new ReadAll();
        readAll.intialize();

        //firstNameTextfield.setText(member.getFirstName());
        // lastNameTextField.setText(member.getLastName());

    }

    public void intialize() {

        frame.setContentPane(new ReadAll().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        populateTable();

    }


    public void populateTable() {
        String[] columnNames = {"id",
                "Firstname",
                "Lastname"};


        List<String[]> rows = new ArrayList<String[]>();
        List<Member> members = service.findAll();
        for (Member s : members) {
            rows.add(new String[]{"" + s.getId(), s.getFirstName(), s.getLastName()});
        }
        TableModel tableModel = new DefaultTableModel(rows.toArray(new Object[][]{}), columnNames);
        JTable table1 = new JTable(tableModel);
        table1.setEnabled(false);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table1), BorderLayout.CENTER);

        /*south.add(update);
        south.add(mainMenu);*/

        frame.add(table1.getTableHeader(), BorderLayout.NORTH);
        frame.add(mainMenu, BorderLayout.SOUTH, 2);

        frame.setSize(200, 200);

    }
}
