package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calculate_bill extends JFrame implements ActionListener{
    
    JPanel p;
    JLabel l1,l2,l3,l4;
    Choice c1,c2;
    JButton b1,b2;
    JTextField t;
   
    calculate_bill(){
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(4,2,30,30));
        p.setBackground(Color.WHITE);
        l1=new JLabel("Calculate Electricity Bill");
        l2=new JLabel("Meter No");
        l3=new JLabel("Month");
        l4=new JLabel("Units Consumed");
        t=new JTextField();
        
        c1=new Choice();
        c1.add("1000");
        c1.add("1001");
        c1.add("1002");
        c1.add("1003");
        c1.add("1004");
        c1.add("1005");
        c1.add("1006");
        c1.add("1007");
        c1.add("1008");
        c1.add("1009");
        c1.add("1010");
        
        c2=new Choice();
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        
        b1=new JButton("Submit");
        b2=new JButton("Cancel");
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        l1.setFont(new Font("Senserif",0,26));
        l1.setHorizontalAlignment(0);
        
        p.add(l2);
        p.add(c1);
        p.add(l3);
        p.add(c2);
        p.add(l4);
        p.add(t);
        p.add(b1);
        p.add(b2);
        
        setLayout(new BorderLayout(30,30));
        add(l1,"North");
        add(p,"Center");
        add(l4,"West");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(650,500);
        this.setLocation(350,220);
    }
    
    public void actionPerformed(ActionEvent ae){
        String a=c1.getSelectedItem();
        String b=t.getText();
        String c=c2.getSelectedItem();
        int p1=Integer.parseInt(b);
        int p2=p1*7;
        int p3=p2+50+12+102+20+50;
        String q="insert into bill values('"+a+"','"+c+"','"+b+"','"+p3+"')";
        try{
            conn c1=new conn();
            c1.s.executeUpdate(q);
            JOptionPane.showMessageDialog((Component)null, "Bill Updated");
        }
        catch(Exception var10){
            var10.printStackTrace();
        }
    }
    public static void main(String args[]){
        new calculate_bill().setVisible(true);
    }
}