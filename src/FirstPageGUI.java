import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class FirstPageGUI implements ActionListener{

    public FirstPageGUI(JFrame owner, ArrayList<Student> students, ArrayList<Profesor> teachers)
    {
        this.owner = owner;
        this.students = students;
        this.teachers = teachers;
        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);
        owner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public FirstPageGUI(JFrame owner)
    {
        this.owner = owner;
        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);
        owner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin)
        {
            mainPanel.setVisible(false);
            owner.setContentPane(new LoginGUI(owner).getLoginPanel());
            owner.setTitle("Login Form");
            owner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else
            if(e.getSource() == btnRegister)
            {
                mainPanel.setVisible(false);
                owner.setContentPane(new RegisterGUI(owner).getRegisterPanel());
                owner.setTitle("Register Form");
                owner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JButton btnLogin;
    private JButton btnRegister;
    private JFrame owner;
    public static ArrayList<Student> students;
    public static ArrayList<Profesor> teachers;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
