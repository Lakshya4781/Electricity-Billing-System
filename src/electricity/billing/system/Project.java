package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{
    String atype,meter;
    Project(String atype,String meter){
        this.atype = atype;
        this.meter = meter;
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        
        master.setForeground(Color.BLUE);
        
        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newCustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newCustomer.setIcon (new ImageIcon(image1));
        newCustomer.setMnemonic('D');
        newCustomer.addActionListener(this);
        newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        master.add(newCustomer);
        
        
        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerDetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerDetails.setIcon (new ImageIcon(image2));
        customerDetails.setMnemonic('M');
        customerDetails.addActionListener(this);
        customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        master.add(customerDetails);
        
        JMenuItem depositeDetails = new JMenuItem("Deposite Details");
        depositeDetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositeDetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositeDetails.setIcon (new ImageIcon(image3));
        depositeDetails.setMnemonic('N');
        depositeDetails.addActionListener(this);
        depositeDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        master.add(depositeDetails);
        
        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculateBill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculateBill.setIcon (new ImageIcon(image4));
        calculateBill.setMnemonic('B');
        calculateBill.addActionListener(this);
        calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        master.add(calculateBill);
        
        
        JMenu info = new JMenu("Information");
    
        info.setForeground(Color.RED);
        
        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon (new ImageIcon(image5));
        updateinfo.setMnemonic('T');
        updateinfo.addActionListener(this);
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
        info.add(updateinfo);
        
        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon (new ImageIcon(image6));
        viewinfo.setMnemonic('U');
        viewinfo.addActionListener(this);
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        info.add(viewinfo);
        
        JMenu user = new JMenu("User");
        
        user.setForeground(Color.BLUE);
        
        JMenuItem payBills = new JMenuItem("Pay Bill");
        payBills.setFont(new Font("monospaced",Font.PLAIN,12));
        payBills.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        payBills.setIcon (new ImageIcon(image7));
        payBills.setMnemonic('W');
        payBills.addActionListener(this);
        payBills.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        user.add(payBills);
        
        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billDetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billDetails.setIcon (new ImageIcon(image8));
        billDetails.setMnemonic('Q');
        billDetails.addActionListener(this);
        billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        user.add(billDetails);
        
        JMenu report = new JMenu("Report");
        
        report.setForeground(Color.RED);
        
        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced",Font.PLAIN,12));
        generateBill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generateBill.setIcon (new ImageIcon(image9));
        generateBill.setMnemonic('I');
        generateBill.addActionListener(this);
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
        report.add(generateBill);
        
    
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon (new ImageIcon(image10));
        notepad.setMnemonic('A');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        utility.add(notepad);
        
        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        Calculator.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Calculator.setIcon (new ImageIcon(image12));
        Calculator.setMnemonic('C');
        Calculator.addActionListener(this);
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        utility.add(Calculator);
        
        
        JMenu sexit = new JMenu("Exit");
        
        sexit.setForeground(Color.RED);
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon (new ImageIcon(image11));
        exit.setMnemonic('I');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
        sexit.add(exit);
        
        setLayout(new FlowLayout());
        
        if(atype.equals("Admin")){
        mb.add(master);}else{
        
        mb.add(info);
        mb.add(user);
        mb.add(report);
        }
        
        mb.add(utility);
        mb.add(sexit);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        }else if(msg.equals("Deposite Details")){
            new DepositeDetails();
        }else if(msg.equals("Customer Details")){
            new CustomerDetails();
        }else if(msg.equals("Calculate Bill")){
            new CalculateBill();
        }else if(msg.equals("View Information")){
            new ViewInformation(meter);
        }else if(msg.equals("Update Information")){
            new UpdateInformation(meter);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meter);
        }else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(msg.equals("Exit")){
                    setVisible(false);
                    new Login();
        }else if(msg.equals("Pay Bill")){
            new PayBill(meter);
        }else if (msg.equals("Generate Bill")){
            new GenerateBill(meter);
        }
        
        
    }
    
    
    
    public static void main (String args[]){
        new Project("","");
    }
}
