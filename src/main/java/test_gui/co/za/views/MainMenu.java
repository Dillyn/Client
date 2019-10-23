package test_gui.co.za.views;

import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame{
    private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JPanel panelMain;


    /**
     * Launch the application.
     */
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
      MainMenu mainMenu = new MainMenu();
      mainMenu.intialize();
}



  public MainMenu() {

       // intialize();
      createButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              RegisterMember registerMember = new RegisterMember();
             registerMember.intialize();

          }
      });
      readButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              ReadAll readAll = new ReadAll();
              readAll.intialize();
          }
      });
      updateButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              UpdateMember updateMember = new UpdateMember();
              updateMember.intialize();
          }
      });
      deleteButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              DeleteMember deleteMember = new DeleteMember();
              deleteMember.invalidate();
          }
      });
  }

    public void intialize(){
        JFrame frame = new JFrame(("MainMenu"));
        frame.setContentPane(new MainMenu().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        setLocationRelativeTo(null);
        setBounds(100, 100, 290, 400);

    }
}
