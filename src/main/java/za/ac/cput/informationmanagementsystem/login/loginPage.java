/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.informationmanagementsystem.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import za.ac.cput.informationmanagementsystem.login.connection.DbConnection;



/**
 *
 * @author MICHEL MUEMBO ILUNGA
 */
public class loginPage extends JFrame implements ActionListener {
    
    Container contentsContainer = getContentPane();
    JPanel myPanel = new JPanel();
    ImageIcon logo = new ImageIcon("src/logo.png");
    JLabel myLabel = new JLabel();
    JButton btnLogin = new JButton("Login");
    JButton btnReset = new JButton("Reset");
    JTextField usernameField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username ");
    JLabel userPasswordLabel = new JLabel("Password ");
    JLabel messageLabel = new JLabel();
    String [] role = {"Admin", "Agent"};
    JComboBox myComboBox = new JComboBox(role);
    JLabel lblSystemLogo = new JLabel(new ImageIcon("src/logo.png"));


    // constructor

    loginPage() {

        DisplayPage();
        setLayoutManger();
        setBoundsAndOthers();
        addComponent();
    }

    // set text and logo page
    // try to fix this portion of code
    public void DisplayPage() {

        // set the title of the page
        myLabel.setText("INFROMATION MANAGEMENT SYSTEM");
        myLabel.setFont(new Font("Lato", Font.ITALIC, 30));
        myLabel.setForeground(Color.WHITE);
        myLabel.setHorizontalAlignment(JLabel.CENTER);
        myLabel.setVerticalAlignment(JLabel.TOP);

        // set image logo
        myLabel.setIcon(logo);
        // set the title of the page
    }

    // set layout manager method

    public void setLayoutManger() {

        contentsContainer.setLayout(null);

    }

    // set size and location method

    public void setBoundsAndOthers() {
       lblSystemLogo.setBounds(480,20,250,150);
        myComboBox.setBounds(225,240,250,30);
        usernameLabel.setBounds(140, 300, 100, 25);
        usernameLabel.setFont(new Font("Lato", Font.ITALIC, 15));
        usernameLabel.setForeground(Color.WHITE);

        userPasswordLabel.setBounds(140, 350, 100, 25);
        userPasswordLabel.setFont(new Font("Lato", Font.ITALIC, 15));
        userPasswordLabel.setForeground(Color.WHITE);

        messageLabel.setBounds(180, 500, 450, 35);
        messageLabel.setFont(new Font("Lato", Font.ITALIC, 25));

        usernameField.setBounds(225, 300, 250, 30);
        usernameField.setBackground(Color.GRAY);
        usernameField.setFont(new Font("Lato", Font.CENTER_BASELINE, 20));
        usernameField.setForeground(new Color(19, 22, 54));
        usernameField.setCaretColor(new Color(19, 22, 54));
        usernameField.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));

        userPasswordField.setBounds(225, 350, 250, 30);
        userPasswordField.setBackground(Color.GRAY);
        userPasswordField.setFont(new Font("Lato", Font.CENTER_BASELINE, 20));
        userPasswordField.setForeground(new Color(19, 22, 54));
        userPasswordField.setCaretColor(new Color(19, 22, 54));
        userPasswordField.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));


        btnLogin.setBounds(240, 400, 100, 35);
        btnLogin.setFocusable(false);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.addActionListener(this);

        btnReset.setBounds(360, 400, 100, 35);
        btnReset.setFocusable(false);
        btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(this);

    }

    // adding component method

    public void addComponent() {
        contentsContainer.add(lblSystemLogo);
        contentsContainer.add(myLabel);
        contentsContainer.add(myComboBox);
        contentsContainer.add(usernameLabel);
        contentsContainer.add(userPasswordLabel);
        contentsContainer.add(messageLabel);
        contentsContainer.add(usernameField);
        contentsContainer.add(userPasswordField);
        contentsContainer.add(btnLogin);
        contentsContainer.add(btnReset);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // reset field if reset button was clicked
        if (e.getSource() == btnReset) {
            usernameField.setText("");
            userPasswordField.setText("");
        }
        // login btn was clicked

        if (e.getSource() == btnLogin) {
            // create connection
            try {
                try (Connection conn = DbConnection.DbConnection()) {
                    String username = usernameField.getText();
                    String password = userPasswordField.getText();
                    String userRole = (String) myComboBox.getSelectedItem();
                    java.sql.Statement statement = conn.createStatement();
                    // query
                    
                    String sql = "Select * from employees where emp_username ='" + username + "' and password='" + password + "' and  emp_role ='" + userRole + "'";
                    ResultSet result = statement.executeQuery(sql);
                    if (result.next()) {
                        dispose();
                        // create a new window
                        if("Admin".equals(userRole)){
                            // open admin dashboard if user is an admin
                          Dashboard admin_page = new Dashboard();
                            admin_page.setTitle("INFROMATION MANAGEMENT SYSTEM");
                            admin_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                            admin_page.setSize(700, 700);
                            admin_page.setResizable(false);
                            admin_page.getContentPane().setBackground(new Color(19, 22, 54));

                            ImageIcon logo = new ImageIcon("src/logo.png");
                            admin_page.setIconImage(logo.getImage());
                            
                            admin_page.show();
                        }else if("Agent".equals(userRole)){
                            // open agent dashboard if user is an agent
                            AgentDashboard agent_dashboard = new AgentDashboard();
                            agent_dashboard.show();
                        }
                        
                        
                   }
                    // validations
                        
                    // set textfield red border if empty error (if login failed)
                    else if (usernameField.getText().trim().isEmpty()) {

                             Border border = BorderFactory.createLineBorder(Color.RED, 2);
                             usernameField.setBorder(border);
                             messageLabel.setText("username Field Required * ");
                             messageLabel.setForeground(Color.red);
                             
                             
                             usernameField.addMouseListener(new MouseAdapter(){
                             
                             // if user click again to the field it should remove the border and label message
                             @Override
                             public void mouseClicked(MouseEvent e){
                                 Border borderChange = BorderFactory.createLineBorder(Color.WHITE, 2);
                                    usernameField.setBorder(borderChange);
                                    messageLabel.setVisible(false);
                                }
                             });
                      
                             usernameField.setBorder(border);
                    }
                    else if(userPasswordField.getText().trim().isEmpty()){
                             Border border = BorderFactory.createLineBorder(Color.RED, 2);
                             userPasswordField.setBorder(border);
                             messageLabel.setText("password Field Required * ");
                             messageLabel.setForeground(Color.red);
                             
                             
                             userPasswordField.addMouseListener(new MouseAdapter(){
                             
                             // if user click again to the field it should remove the border and label message
                             @Override
                             public void mouseClicked(MouseEvent e){
                                    Border borderChange = BorderFactory.createLineBorder(Color.WHITE, 2);
                                    userPasswordField.setBorder(borderChange);
                                    messageLabel.setVisible(false);
                                }
                             });
                      
                             userPasswordField.setBorder(border);
                        }
                        
                    else{
                     
                        messageLabel.setText("Wrong Username Or Password");
                        messageLabel.setForeground(Color.red);
                    }
                    // close connection
                }


            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }

        }
    }
    
    
     public static void main(String[] args) {
        // extension for login page

        loginPage login = new loginPage();
       

        // create the interface

        login.setTitle("INFROMATION MANAGEMENT SYSTEM");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        login.setSize(700, 700);
        login.setResizable(false);
        login.getContentPane().setBackground(new Color(19, 22, 54));
        
        ImageIcon logo = new ImageIcon("src/logo.png");
        login.setIconImage(logo.getImage());
        login.setVisible(true);
        
      

    }
  
}
