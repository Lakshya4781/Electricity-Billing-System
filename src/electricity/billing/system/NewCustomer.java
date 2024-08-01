
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener{
    JTextField tfname,tfaddress,tfcity,tfstate,tfemail,tfphoneNumber;
    JButton next,cancel;
    JLabel lblmeter;
    NewCustomer(){
        
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel  heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel  lblname = new JLabel("Customer Name");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);
        
        JLabel  lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100,120,100,20);
        p.add(lblmeternumber);
        
        lblmeter = new JLabel("Customer Name");
        lblmeter.setBounds(240,120,100,20);
        p.add(lblmeter);
        
        Random ran = new Random();
        long number = ran.nextLong() %1000000;
        lblmeter.setText(""+Math.abs(number));
        
        JLabel  lbladdress = new JLabel("Address");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);
        
        JLabel  lblcity = new JLabel("City");
        lblcity.setBounds(100,200,100,20);
        p.add(lblcity);
        
        tfcity = new JTextField();
        tfcity.setBounds(240,200,200,20);
        p.add(tfcity);
        
        JLabel  lblstate = new JLabel("State");
        lblstate.setBounds(100,240,100,20);
        p.add(lblstate);
        
        tfstate = new JTextField();
        tfstate.setBounds(240,240,200,20);
        p.add(tfstate);
        
        JLabel  lblemail = new JLabel("Email");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);
        
        JLabel  lblphNumber = new JLabel("Phone Number");
        lblphNumber.setBounds(100,320,100,20);
        p.add(lblphNumber);
        
        tfphoneNumber = new JTextField();
        tfphoneNumber.setBounds(240,320,200,20);
        p.add(tfphoneNumber);
        
        
        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        p.add(next);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        p.add(cancel);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        
        
       setLayout(new BorderLayout());
       add(p,"Center");
       ImageIcon i1=  new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
       Image i2 = i1.getImage().getScaledInstance(170, 300, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       add(image,"West");
        
        getContentPane().setBackground(Color.WHITE);
                
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphoneNumber.getText();
            
            String query1 = "insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"') ";
            String query2 = "insert into login values('"+meter+"','','"+name+"','','')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
                
                // frame
                new MeterInfo(meter); 
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    
    
    
    
    public static void main (String args[]){
        new NewCustomer();
    }
}
