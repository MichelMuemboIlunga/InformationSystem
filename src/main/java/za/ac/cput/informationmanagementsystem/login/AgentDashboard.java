/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.informationmanagementsystem.login;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author MICHEL MUEMBO ILUNGA
 */
public class AgentDashboard extends JFrame {
      
    JLabel label = new JLabel();
    JFrame frame = new JFrame();

    AgentDashboard() {
        DisplayPage();
    }


// create the interface
    public void DisplayPage() {

        // set the title of the page
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setTitle("ANGRY FAST FOOD");
        this.setSize(1000, 800);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(19, 22, 54));

        ImageIcon food = new ImageIcon("src/Food.png");
        this.setIconImage(food.getImage());
        this.setVisible(true);

        label.setText("Welcome To Agent dashboard");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Lato", Font.ITALIC, 15));
        label.setForeground(Color.WHITE);

        this.add(label);
    }

}
