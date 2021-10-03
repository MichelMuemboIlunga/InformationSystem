/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.informationmanagementsystem.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import za.ac.cput.informationmanagementsystem.login.connection.DbConnection;

/**
 *
 * @author MICHEL MUEMBO ILUNGA
 */
public class UpdateHouses extends JFrame implements ActionListener{
   
     JLabel label = new JLabel();
     JFrame frame = new JFrame();


       UpdateHouses()  {
        
        showJtable();
      
       }
       
    public void showJtable() {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        String sql = "SELECT * FROM house";

        Connection conn = null;
         try {
             conn = DbConnection.DbConnection();
         } catch (SQLException ex) {
             Logger.getLogger(UpdateHouses.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        Statement stmt = null;
         try {
             stmt = conn.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(UpdateHouses.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        ResultSet rs = null;
         try {
             rs = stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(UpdateHouses.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        ResultSetMetaData md = null;
         try {
             md = rs.getMetaData();
         } catch (SQLException ex) {
             Logger.getLogger(UpdateHouses.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        int columns = 0;
         try {
             columns = md.getColumnCount();
         } catch (SQLException ex) {
             Logger.getLogger(UpdateHouses.class.getName()).log(Level.SEVERE, null, ex);
         }
        for (int i = 1; i <= columns; i++) {
            try {
                columnNames.add(md.getColumnName(i));
            } catch (SQLException ex) {
                Logger.getLogger(UpdateHouses.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         try {
             while (rs.next()) {
                 ArrayList row = new ArrayList(columns);
                 for (int i = 1; i <= columns; i++) {
                     row.add(rs.getObject(i));
                 }
                 data.add(row);
             }} catch (SQLException ex) {
             Logger.getLogger(UpdateHouses.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();
        for (int i = 0; i < data.size(); i++) {
          ArrayList subArray = (ArrayList) data.get(i);
          Vector subVector = new Vector();
          for (int j = 0; j < subArray.size(); j++) {
            subVector.add(subArray.get(j));
          }
          dataVector.add(subVector);
        }
        for (int i = 0; i < columnNames.size(); i++)
          columnNamesVector.add(columnNames.get(i));
        JTable table = new JTable(dataVector, columnNamesVector) {
           
          public Class getColumnClass(int column) {
            for (int row = 0; row < getRowCount(); row++) {
              Object o = getValueAt(row, column);
              if (o != null) {
                return o.getClass();
              }
            }
            return Object.class;
          }
        };
        
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(new Color(19, 22, 54));
        table.setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(51,153,255));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        
        JPanel buttonPanel = new JPanel();
        

        JButton update = new JButton("Update record");
        update.setPreferredSize(new Dimension(40, 40));
        update.setFont(update.getFont().deriveFont(24.0f));
        update.setForeground(Color.WHITE);
        
        update.addActionListener(this);
        
        update.setBackground(new Color(51,153,255));
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(update,BorderLayout.SOUTH);
      }
        public void actionPerformed(ActionEvent e) {
        
         if(e.getActionCommand().equals("Update record")){
              SelectHouseToUpdate s_update = new SelectHouseToUpdate();
              s_update.setTitle("INFROMATION MANAGEMENT SYSTEM");
              s_update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
              s_update.setSize(700, 700);
              s_update.setResizable(false);
              s_update.getContentPane().setBackground(new Color(19, 22, 54));
        
              ImageIcon logo = new ImageIcon("src/logo.png");
              s_update.setIconImage(logo.getImage());
             
              s_update.show();
         }  
         
     }
  }

    
    
     

    
     


