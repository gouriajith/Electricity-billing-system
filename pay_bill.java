package Electricity;

import java.awt.*;
import javax.swing.*;

public class pay_bill extends JFrame{
    pay_bill(){
        JEditorPane j=new JEditorPane();
        j.setEditable(false);
        try{
            j.setPage("https://paytm.com/electricity-bill-payment");
        }catch(Exception var3){
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }
        JScrollPane sp=new JScrollPane(j);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(sp);
        this.setPreferredSize(new Dimension(800,600));
        this.setSize(800,800);
        this.setLocation(250,120);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new pay_bill().setVisible(true);
    }
    
}
