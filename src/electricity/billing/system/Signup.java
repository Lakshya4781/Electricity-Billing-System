
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    Choice accounttype;
    JTextField username,name,password,meter;
    Signup(){
        
        setSize(700,400);
        setLocation(450,200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30,30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,220),2),"Create-Account"));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(Color.white);
        add(panel);
        
        //
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.gray);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(heading);
        
        accounttype = new Choice();
        accounttype.add("Admin");
        accounttype.add("Customer");
        accounttype.setBounds(260,51,150,20);
        panel.add(accounttype);
        
        //
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100,90,140,20);
        lblmeternumber.setForeground(Color.gray);
        lblmeternumber.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblmeternumber);
        lblmeternumber.setVisible(false);
        
        meter = new JTextField();
        meter.setBounds(260,90,150,20);
        panel.add(meter);
        meter.setVisible(false);
        
        
        
        //
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100,130,140,20);
        lblusername.setForeground(Color.gray);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(260,130,150,20);
        panel.add(username);
        
        //
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setForeground(Color.gray);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblname);
        
        name = new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);
        
        //  AUTOMATIC NAME AA JAEGA
        meter.addFocusListener(new FocusListener(){
        @Override
        public void focusGained(FocusEvent fe){
           
        }
        @Override 
        public void focusLost(FocusEvent fe){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+ meter.getText()+"'");
                while(rs.next()){
                    name.setText(rs.getString("name"));
                }
            }catch(Exception e ){
                e.printStackTrace();
            }
        }
    });
        
        //
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100,210,140,20);
        lblpassword.setForeground(Color.gray);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(lblpassword);
        
        password = new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);
        
        
        accounttype.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                String user = accounttype.getSelectedItem();
                if(user.equals("Customer")){
                    lblmeternumber.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }else{
                    lblmeternumber.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
            
    });
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(90,260,150,25);
        panel.add(create);
        create.addActionListener(this);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(275,260,150,25);
        panel.add(back);
        back.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415,20,250,250);
        panel.add(image);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String atype = accounttype.getSelectedItem();
            String susername = username.getText();
            String spassword = password.getText();
            String sname = name.getText();
            String smeternumber = meter.getText();            
            
            try{
                Conn c  = new Conn();
                String query =null;
                if(atype.equals("Admin")){
                     query =    "insert into login values('"+smeternumber+"','"+susername+"','"+sname+"',"+ "'"+spassword+"','"+atype+"')";}else{
                    query = "update login set username = '"+susername+"',password = '"+spassword+"' , user = '"+atype+"' where meter_no ='"+smeternumber+"'";
                }
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
                
                
            }catch(Exception e ){
                e.printStackTrace();
            }
            
            
            
            
            
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();    
        }
     }
    public static void main(String args[]){
        new Signup();
    }
}
