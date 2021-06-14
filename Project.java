package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    Project(){
        super("Electricity Billing System");
        
        JMenuBar mb=new JMenuBar();
        JMenu customer=new JMenu("Customer");
        JMenuItem c1=new JMenuItem("New Customer");
        JMenuItem c2=new JMenuItem("Customer Details");
        JMenuItem c3=new JMenuItem("Deposit Details");
        customer.setForeground(Color.BLUE);
        
        c1.setFont(new Font("monospaced",Font.PLAIN,12));
        c1.setBackground(Color.WHITE);
        c2.setFont(new Font("monospaced",Font.PLAIN,12));
        c2.setBackground(Color.WHITE);
        c3.setFont(new Font("monospaced",Font.PLAIN,12));
        c3.setBackground(Color.WHITE);
        
        c1.addActionListener(this);
        c2.addActionListener(this);
        c3.addActionListener(this);
        
        JMenu user=new JMenu("User");
        JMenuItem u1=new JMenuItem("Pay Bill");
        JMenuItem u2=new JMenuItem("Calculate Bill");
        JMenuItem u3=new JMenuItem("Last Bill");
        customer.setForeground(Color.RED);
        
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        u1.setBackground(Color.WHITE);
        u2.setFont(new Font("monospaced",Font.PLAIN,12));
        u2.setBackground(Color.WHITE);
        u3.setFont(new Font("monospaced",Font.PLAIN,12));
        u3.setBackground(Color.WHITE);
        
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        
        JMenu report=new JMenu("Report");
        JMenuItem r1=new JMenuItem("Generate Bill");
        report.setForeground(Color.BLUE);
        
        r1.setFont(new Font("monospaced",Font.PLAIN,12));
        r1.setBackground(Color.WHITE);
        
        r1.addActionListener(this);
        
        JMenu exit=new JMenu("Exit");
        JMenuItem ex=new JMenuItem("Exit");
        exit.setForeground(Color.BLUE);
        ex.setFont(new Font("monospaced",0,12));
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        
        customer.add(c1);
        customer.add(c2);
        customer.add(c3);
        
        user.add(u1);
        user.add(u2);
        user.add(u3);
        
        report.add(r1);
        
        exit.add(ex);
        
        mb.add(customer);
        mb.add(user);
        mb.add(report);
        mb.add(exit);
        
        this.setJMenuBar(mb);        
        this.setFont(new Font("Senserif",Font.BOLD,16));
        this.setLayout(new FlowLayout());
        this.setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("New Customer")){
            new new_customer().setVisible(true);
        }
        else if(msg.equals("Calculate Bill")){
            new calculate_bill().setVisible(true);
        }
        else if(msg.equals("Pay Bill")){
            new pay_bill().setVisible(true);
        }
        else if(msg.equals("Exit")){
            System.exit(0);
        }
        else if(msg.equals("Generate Bill")){
            new generate_bill().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Project().setVisible(true);
    }
    
}
