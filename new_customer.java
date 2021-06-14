package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class new_customer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    new_customer(){
        this.setLocation(350,200);
        this.setSize(650,600);
        
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(9,2,10,10));
        p.setBackground(Color.WHITE);
        
        this.l1=new JLabel("Name");
        this.t1=new JTextField();
        p.add(this.l1);
        p.add(this.t1);
        
        this.l2=new JLabel("Meter No");
        this.t2=new JTextField();
        p.add(this.l2);
        p.add(this.t2);
        
        this.l3=new JLabel("Address");
        this.t3=new JTextField();
        p.add(this.l3);
        p.add(this.l3);
        
        this.l4=new JLabel("City");
        this.t4=new JTextField();
        p.add(this.l4);
        p.add(this.l4);
        
        this.l5=new JLabel("State");
        this.t5=new JTextField();
        p.add(this.l5);
        p.add(this.t5);
        
        this.l6=new JLabel("Email");
        this.t6=new JTextField();
        p.add(this.l6);
        p.add(this.t6);
        
        this.l7=new JLabel("Phone Number");
        this.t7=new JTextField();
        p.add(this.l7);
        p.add(this.l7);
        
        this.b1=new JButton("Submit");
        this.b2=new JButton("Cancel");
        this.b1.setBackground(Color.BLACK);
        this.b1.setForeground(Color.WHITE);
        this.b2.setBackground(Color.BLACK);
        this.b2.setForeground(Color.WHITE);
        p.add(this.b1);
        p.add(this.b2);
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        
        this.setLayout(new BorderLayout());
        this.add(p,"Center");
    }
    
    public void actionPerformed(ActionEvent ae){
        String a=t1.getText();
        String b=t2.getText();
        String c=t3.getText();
        String d=t4.getText();
        String e=t5.getText();
        String f=t6.getText();
        String g=t7.getText();
        String q1 = "insert into emp values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
        try{
            conn c1=new conn();
            c1.s.executeUpdate(q1);
            JOptionPane.showMessageDialog((Component)null,"Employee Created");
            this.setVisible(false);
        }catch(Exception var11){
            var11.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new new_customer().setVisible(true);
    }
}
