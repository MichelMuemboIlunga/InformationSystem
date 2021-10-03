/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.informationmanagementsystem.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import za.ac.cput.informationmanagementsystem.login.connection.DbConnection;

/**
 *
 * @author MICHEL MUEMBO ILUNGA
 */
public class SelectHouseToUpdate extends JFrame implements ActionListener {
    
    private JPanel panelNorth;
    private JPanel panelSouth;
    private JPanel panelEast;
    
    private JLabel lblSelectHouse;
    private JLabel lblHouseOwner;
   
    private JLabel lblPrice;
    private JLabel lblHouseStatus;
    private JLabel RecordMessage;
    
    private JComboBox SelectHouse;
    private JButton GetAddress;
    private JTextField OwnerField;
  
    private JTextField PriceField;
    private JTextArea RecordMessageField;
    
    private JPanel HouseStstus;
    private JRadioButton radBtnAvailable;
    private JRadioButton radBtnRent;
    private ButtonGroup btnGroupHouse;

    private JButton btnAdd;
    private JButton btnView;
    private JButton btnEXit;

    private JFrame frame;

    SelectHouseToUpdate(){
    

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the size of the frame or window and the application title
        this.setSize(1000, 800);
        this.setTitle("Admin Add House");

        // change icon for the app instead of java icon use logo icon
        ImageIcon ic = new ImageIcon("src/icons.svg");
        this.setIconImage(ic.getImage());

        this.setVisible(true);

        // instantiating
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();

        // set Panel North
        panelNorth.setBackground(new Color(19, 22, 54));
        panelNorth.setPreferredSize(new Dimension(100,100));

        // set The title
        JLabel title = new JLabel("Update House ", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Serif", Font.BOLD, 50));
        title.setPreferredSize(new Dimension(500,90));

        // set the image
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/logo.png").getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT));
        JLabel labelImage = new JLabel();
        labelImage.setIcon(imageIcon);

        panelNorth.add(labelImage);
        panelNorth.add(title);

        /* Form Section */

        // creating a panel GridBagLayout where content will be

        JPanel newPanelContent = new JPanel(new GridBagLayout());
        newPanelContent.setBackground(Color.GRAY);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);


        // set border for the panel
        newPanelContent.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Information management Dashboard"));
        newPanelContent.setForeground(Color.BLUE);

        // add the panel to this frame
        add(newPanelContent);

        
        lblSelectHouse = new JLabel("Select house Address: ");
        lblSelectHouse.setFont(new Font("Arial", Font.PLAIN, 20));
        lblSelectHouse.setForeground(Color.WHITE);
        
        SelectHouse = new JComboBox();
        SelectHouse.setPreferredSize(new Dimension(250,30));
        SelectHouse.setFont(new Font("Arial", Font.PLAIN, 20));
        
        GetAddress = new JButton("Get Addresses");
        GetAddress.setBackground(new Color(19, 22, 54));
        GetAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        GetAddress.setForeground(Color.WHITE);
        GetAddress.setCursor(new Cursor(Cursor.HAND_CURSOR));
        GetAddress.addActionListener(this);
        
        // positioning ID Field and label
        
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanelContent.add(lblSelectHouse, constraints);
        
        constraints.gridx = 1;
        newPanelContent.add(SelectHouse, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        newPanelContent.add(GetAddress, constraints);
        
                
        lblHouseOwner = new JLabel("House Owner: ");
        lblHouseOwner.setFont(new Font("Arial", Font.PLAIN, 20));
       
        lblHouseOwner.setForeground(Color.WHITE);
        OwnerField = new JTextField();
        OwnerField.setPreferredSize(new Dimension(250,30));
        OwnerField.setFont(new Font("Arial", Font.PLAIN, 20));
    
    
        // positioning ID Field and label
        constraints.gridx = 0;
        constraints.gridy = 2;
        newPanelContent.add(lblHouseOwner, constraints);

        constraints.gridx = 1;
        newPanelContent.add(OwnerField, constraints);

        
      
    
    
       

        // price
        lblPrice = new JLabel("House price: ");
        lblPrice.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPrice.setForeground(Color.WHITE);
        PriceField = new JTextField();
        PriceField.setPreferredSize(new Dimension(250,30));
        PriceField.setFont(new Font("Arial", Font.PLAIN, 20));
    
        // positioning last Name Field and label
        constraints.gridx = 0;
        constraints.gridy = 4;
        newPanelContent.add(lblPrice, constraints);

        constraints.gridx = 1;
        newPanelContent.add(PriceField, constraints);

       

        /* show record message */

        // Records label
        RecordMessage = new JLabel("House Description: ");
        RecordMessage.setFont(new Font("Arial", Font.PLAIN, 20));
        RecordMessage.setForeground(Color.WHITE);
        // Records text area
        RecordMessageField = new JTextArea(5,15);
        RecordMessageField.setFont(new Font("Arial", Font.PLAIN, 20));
        RecordMessageField.setForeground(Color.RED);
        RecordMessageField.setSize(300, 400);
        RecordMessageField.setEditable(true);
        
         HouseStstus = new JPanel();

        // positioning radio btn and label
        constraints.gridx = 0;
        constraints.gridy = 8;
        newPanelContent.add(RecordMessage, constraints);

        constraints.gridx = 1;
        newPanelContent.add(RecordMessageField, constraints);
        
        lblHouseStatus = new JLabel("House Status: ");
        lblHouseStatus.setFont(new Font("Arial", Font.PLAIN, 20));
        lblHouseStatus.setForeground(Color.WHITE);
        
        constraints.gridx = 0;
        constraints.gridy = 9;
        newPanelContent.add(lblHouseStatus, constraints);
        
        radBtnAvailable = new JRadioButton("Available");
        radBtnRent = new JRadioButton("Rented");
        btnGroupHouse = new ButtonGroup();
        btnGroupHouse.add(radBtnAvailable);
        btnGroupHouse.add(radBtnRent);
        
        HouseStstus = new JPanel();
        HouseStstus.add(radBtnAvailable);
        HouseStstus.add(radBtnRent);
        
        constraints.gridx = 1;
        constraints.gridy = 9;
        newPanelContent.add(HouseStstus, constraints);

        // buttons

        btnAdd = new JButton("Select House");
        btnAdd.setBackground(new Color(19, 22, 54));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(btnAdd.getFont().deriveFont(20.0f));

        btnAdd.addActionListener(this);
        
        
        btnView = new JButton("Update House");
        btnView.setBackground(new Color(19, 22, 54));
        btnView.setForeground(Color.WHITE);
        btnView.setFont(btnView.getFont().deriveFont(20.0f));
        
        btnView.addActionListener(this);

      

        btnEXit = new JButton("Exit");
        btnEXit.setBackground(new Color(19, 22, 54));
        btnEXit.setForeground(Color.WHITE);
        btnEXit.setFont(btnEXit.getFont().deriveFont(20.0f));

        btnEXit.addActionListener(this);

        // set the south panel
        panelSouth.setLayout(new GridLayout(1, 3));
        panelSouth.setPreferredSize(new Dimension(100,50));

        panelSouth.add(btnAdd);
        panelSouth.add(btnView);
        panelSouth.add(btnEXit);
        this.add(panelNorth,BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);
        
        
        


    }
    
      // alert box 
    public void ConfirmAlert(){
        
                ImageIcon icon = new ImageIcon("src/images/lock64.png");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setSize(new Dimension(200, 64));
		panel.setLayout(null);

		JLabel label1 = new JLabel("Great! A new house has been added.");
		label1.setVerticalAlignment(SwingConstants.BOTTOM);
		label1.setBounds(0, 0, 200, 32);
		label1.setFont(new Font("Arial", Font.BOLD, 10));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label1);

		JLabel label2 = new JLabel("Do you want To add more or to view?");
		label2.setVerticalAlignment(SwingConstants.TOP);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Arial", Font.BOLD, 10));
		label2.setBounds(0, 32, 200, 32);
		panel.add(label2);

		UIManager.put("OptionPane.minimumSize", new Dimension(300, 120));
		int input = JOptionPane.showConfirmDialog(null, panel, "Admin Rights Confirmation",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon);

		
		System.out.println(input);
                
                if(input == 0){
                    
                    UpdateHouses update_house = new UpdateHouses();
                    
                    update_house.setTitle("INFROMATION MANAGEMENT SYSTEM");
                    update_house.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                    update_house.setSize(700, 700);
                    update_house.setResizable(true);
                    update_house.getContentPane().setBackground(new Color(19, 22, 54));
                    update_house.setForeground(Color.WHITE);

                    ImageIcon logo = new ImageIcon("src/logo.png");
                    update_house.setIconImage(logo.getImage());
          
                    update_house.show();

                }else if(input == 1 || input == 2){
                     dispose();
                }
    
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Get Addresses")){
            
             try (Connection conn = DbConnection.DbConnection()) {
                    
                  
                     java.sql.Statement statement = conn.createStatement();
                     String Query = "SELECT house_address FROM house";
                      
                     
                     ResultSet result = statement.executeQuery(Query);

                         
                     while(result.next()){
                             String venueName = result.getString("house_address");
                             
                             SelectHouse.addItem(venueName);
                                             
                     
                     }

                        
                    } catch (SQLException ex) {
                Logger.getLogger(SelectHouseToUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(e.getActionCommand().equals("Select House")){
             try (Connection conn = DbConnection.DbConnection()) {
                    
                     String addressVal = (String) SelectHouse.getSelectedItem();
                     java.sql.Statement statement = conn.createStatement();
                     String Query = "SELECT house_owner, house_price, house_description, house_status FROM house "
                             + "WHERE house_address ='" + addressVal + "' ";
                      
                     
                     ResultSet result = statement.executeQuery(Query);

                         
                     while(result.next()){
                           
                             String houseOwner = result.getString("house_owner");
                             String housePrice = result.getString("house_price");
                             String houseDescription = result.getString("house_description");
                             String houseStatus = result.getString("house_status");
                             
                             OwnerField.setText(houseOwner);
                             PriceField.setText(housePrice);
                             RecordMessageField.setText(houseDescription);
                             if("Available".equals(houseStatus)){
                                 radBtnAvailable.setSelected(true);
                             }else if("Rented".equals(houseStatus)){
                                 radBtnRent.setSelected(true);
                             }

                     }

                        
                    } catch (SQLException ex) {
                Logger.getLogger(SelectHouseToUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getActionCommand().equals("Update House")){
            // update records
                try (Connection conn = DbConnection.DbConnection()) {
                    
                    if(radBtnAvailable.isSelected()){
                    String HouseAddres = (String) SelectHouse.getSelectedItem();
                    String HouseOwner = OwnerField.getText();
                    int HousePrice =  Integer.parseInt(PriceField.getText());
                    String HouseMessage = RecordMessageField.getText();
                    String houseStatus = radBtnAvailable.getText();
                    
                    
                     // validations
                        
                    // set textfield red border if empty error (if login failed)
                    if (OwnerField.getText().trim().isEmpty() || PriceField.getText().trim().isEmpty() || RecordMessageField.getText().trim().isEmpty()) {
                         Border border = BorderFactory.createLineBorder(Color.RED, 2);
                         
                         JOptionPane.showMessageDialog(null, "Please Fill Up All The field","Error",JOptionPane.ERROR_MESSAGE);
                    }else{
                        // update data to table
                    
                    java.sql.Statement statement = conn.createStatement();
                     PreparedStatement prep;
                  
                        String sql = 
                                "UPDATE house SET house_owner =?, house_price =?, house_description =?, house_status=? "
                                + "WHERE house_address =?";
                    
                              
                        prep = conn.prepareStatement(sql);
           
                        prep.setString(1, HouseOwner);
                        prep.setInt(2, HousePrice);
                        prep.setString(3, HouseMessage);
                        prep.setString(4, houseStatus);
                        prep.setString(5, HouseAddres);
                        
                        prep.execute();
                        
                        // confirm alert
                        
                        ConfirmAlert();
                        
                    }
                  }else if(radBtnRent.isSelected()){
                            
                        String HouseAddres = (String) SelectHouse.getSelectedItem();
                        String HouseOwner = OwnerField.getText();
                        int HousePrice =  Integer.parseInt(PriceField.getText());
                        String HouseMessage = RecordMessageField.getText();
                        String houseStatus = radBtnRent.getText();
                       
                    
                      
                     // validations
                        
                    // set textfield red border if empty error (if login failed)
                    if (OwnerField.getText().trim().isEmpty() || PriceField.getText().trim().isEmpty() || RecordMessageField.getText().trim().isEmpty()) {
                         Border border = BorderFactory.createLineBorder(Color.RED, 2);
                         
                         JOptionPane.showMessageDialog(null, "Please Fill Up All The field","Error",JOptionPane.ERROR_MESSAGE);
                    }else{
                        // update data to table
                    
                    java.sql.Statement statement = conn.createStatement();
                     PreparedStatement prep;
                  
                        String sql = 
                                "UPDATE house SET house_owner =?, house_price =?, house_description =?, house_status=? "
                                + "WHERE house_address =?";
                    
                              
                        prep = conn.prepareStatement(sql);
           
                        prep.setString(1, HouseOwner);
                        prep.setInt(2, HousePrice);
                        prep.setString(3, HouseMessage);
                        prep.setString(4, houseStatus);
                        prep.setString(5, HouseAddres);
                        
                        prep.execute();
                        
                        // confirm alert
                        
                        ConfirmAlert();
                  }
                }

                } catch (SQLException sqlException) {
                  JOptionPane.showMessageDialog(null,sqlException.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

                }
           
        }else if(e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
        
    }      
    
}
