
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class CustomerDetails extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JButton search , print;
    JTable table;
    
    CustomerDetails(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(200,150);

        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            JScrollPane sp = new JScrollPane(table);
            add(sp);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        print = new JButton("Print");  
        add(print,"South");
        print.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
     
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        
    }
    
    public static void main(String args[]){
        new CustomerDetails();
    }
}