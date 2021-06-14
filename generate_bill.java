package Electricity;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class generate_bill extends JFrame implements ActionListener {
    JLabel l;
    JTextArea t;
    JButton b;
    Choice c1,c2;
    JPanel p;
    
    generate_bill(){
        setSize(500,900);
        setLayout(new BorderLayout());
        p=new JPanel();
        l=new JLabel("Generate Bill");
        c1=new Choice();
        c2=new Choice();
        
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
        
        t=new JTextArea(50,15);
        JScrollPane jsp=new JScrollPane(this.t);
        t.setFont(new Font("Senserif",2,18));
        b=new JButton("Generate Bill");
        p.add(this.l);
        p.add(this.c1);
        p.add(this.c2);
        add(this.p,"North");
        add(jsp,"Center");
        add(this.b,"South");
        b.addActionListener(this);
        setLocation(350,40);
             
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn c=new conn();
            String month=this.c2.getSelectedItem();
            t.setText("Electricity Bill For the Month");
            ResultSet rs=c.s.executeQuery("select * from emp where meter number="+this.c1.getSelectedItem());
            if(rs.next()){
                t.append("\n    Customer Name:     "+rs.getString("name"));
                t.append("\n    Meter No:          "+rs.getString("meter_number"));
                t.append("\n    Address:           "+rs.getString("address"));
                t.append("\n    State:             "+rs.getString("state"));
                t.append("\n    City:              "+rs.getString("city"));
                t.append("\n    Email:             " + rs.getString("email"));
                t.append("\n    Phone Number:      " + rs.getString("phone"));
                t.append("\n-------------------------------------------------------------");
                t.append("\n");
           }
           rs = c.s.executeQuery("select * from tax");
           if (rs.next()) {
               t.append("\n    Meter Location:    " + rs.getString("meter_location"));
               t.append("\n    Meter Type:        " + rs.getString("meter_type"));
               t.append("\n    Phase Code:        " + rs.getString("phase_code"));
               t.append("\n    Bill Type:         " + rs.getString("bill_type"));
               t.append("\n    Days:              " + rs.getString("days"));
               t.append("\n");
               t.append("---------------------------------------------------------------");
               t.append("\n\n");
               t.append("\n    Meter Rent:\t\t" + rs.getString("meter_rent"));
               t.append("\n    MCB Rent:  \t\t" + rs.getString("mcb_rent"));
               t.append("\n    Service Tax:\t" + rs.getString("service_rent"));
               t.append("\n    GST@9%:\t\t" + rs.getString("gst"));
               t.append("\n");
           }

           rs = c.s.executeQuery("select * from bill where meter_number=" + this.c1.getSelectedItem());
           if (rs.next()) {
               t.append("\n    Current Month :\t" + rs.getString("month"));
               t.append("\n    Units Consumed:\t" + rs.getString("units"));
               t.append("\n    Total Charges :\t" + rs.getString("amount"));
               t.append("\n---------------------------------------------------------------");
               t.append("\n    TOTAL PAYABLE :\t" + rs.getString("amount"));
           }
       } catch (Exception var5) {
           var5.printStackTrace();
       }

   }

   public static void main(String[] args) {
       new generate_bill().setVisible(true);
   }
}

