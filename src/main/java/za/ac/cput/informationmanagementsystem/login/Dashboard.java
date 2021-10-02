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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author MICHEL MUEMBO ILUNGA
 */
public class Dashboard extends JFrame implements ActionListener{
     
     Container contentsContainer = getContentPane();
     JLabel myLabel = new JLabel();
     JFrame myFrame = new JFrame();
     JButton addNewHouse = new JButton("ADD NEW HOUSE");
     JButton addNewAgent = new JButton("ADD NEW AGENT");
     ImageIcon logo = new ImageIcon("src/logo.png");
     JLabel lblSystemLogo = new JLabel(new ImageIcon("src/logo.png"));

    Dashboard() {
        
        DisplayPage();
        setLayoutManger();
        setBoundsAndOthers();
        addComponent();
        
    }


    //        // create the interface
    public void DisplayPage() {

        // set the title of the page
       // set the title of the page
        myLabel.setText("INFROMATION MANAGEMENT SYSTEM");
        myLabel.setFont(new Font("Lato", Font.ITALIC, 30));
        myLabel.setForeground(Color.WHITE);
        myLabel.setHorizontalAlignment(JLabel.CENTER);
        myLabel.setVerticalAlignment(JLabel.TOP);

        // set image logo
        myLabel.setIcon(logo);

   
    }
    // set layout manager method

    public void setLayoutManger() {

        contentsContainer.setLayout(null);

    }
     // set size and location method

    public void setBoundsAndOthers() {
        
        lblSystemLogo.setBounds(480,20,250,150);
        myLabel.setHorizontalAlignment(JLabel.CENTER);
        myLabel.setVerticalAlignment(JLabel.CENTER);
        myLabel.setFont(new Font("Lato", Font.ITALIC, 35));
        myLabel.setForeground(Color.WHITE);
        myLabel.setBounds(230, 0, 610, 250);
        
        
        
        addNewHouse.setBounds(240, 300, 200, 35);
        addNewHouse.setFocusable(false);
        addNewHouse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addNewHouse.addActionListener(this);
        
        addNewAgent.setBounds(240, 350, 200, 35);
        addNewAgent.setFocusable(false);
        addNewAgent.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addNewAgent.addActionListener(this);

    }

    // adding component method

    public void addComponent() {
        //contentsContainer.add(myLabel);
        contentsContainer.add(lblSystemLogo);
        contentsContainer.add(addNewHouse);
        contentsContainer.add(addNewAgent);
        



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
          if (e.getSource() == addNewHouse){
              
             AdminHouseAdd admin_house = new AdminHouseAdd();
             admin_house.setTitle("INFROMATION MANAGEMENT SYSTEM");
             admin_house.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             admin_house.setSize(700, 700);
             admin_house.setResizable(true);
             admin_house.getContentPane().setBackground(new Color(19, 22, 54));

              ImageIcon logo = new ImageIcon("src/logo.png");
              admin_house.setIconImage(logo.getImage());
                            
              admin_house.show();               
          }
          if(e.getSource() == addNewAgent){
              AdminAgentAdd create_venue = new AdminAgentAdd();
              create_venue.show();
          }
           
            
             
                        
      
    }
    
}