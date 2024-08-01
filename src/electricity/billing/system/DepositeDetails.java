
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class DepositeDetails extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JButton search , print;
    JTable table;
    
    DepositeDetails(){
        super("Deposite Details");
        setSize(700,700);
        setLocation(400,100);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);   
        
        JLabel lblmeternumber = new JLabel("Search By Meter Number");
        lblmeternumber.setBounds(20,20,150,20);
        add(lblmeternumber);
        
        meternumber = new Choice();
        try{
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                meternumber.add(rs.getString("meter_no"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        meternumber.setBounds(180,20,150,20);
        add(meternumber);
        
        
        JLabel lblmonth = new JLabel("Search By Month");
        lblmonth.setBounds(380,20,120,20);
        add(lblmonth);
        
        cmonth = new Choice();
        cmonth.add("January");cmonth.add("February");cmonth.add("March");
        cmonth.add("April");cmonth.add("May");cmonth.add("June");
        cmonth.add("July");cmonth.add("August");cmonth.add("September");
        cmonth.add("October");cmonth.add("November");cmonth.add("December");
        cmonth.setBounds(510,20,150,20);
        add(cmonth);
        
        
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bill");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            JScrollPane sp = new JScrollPane(table);
            sp.setBounds(0,100,700,600);
            add(sp);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        add(search);
        search.addActionListener(this);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        add(print);
        print.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
            String query = "select * from bill where meter_no = '"+meternumber.getSelectedItem()+"'and month = '"+cmonth.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
    public static void main(String args[]){
        new DepositeDetails();
    }
}
