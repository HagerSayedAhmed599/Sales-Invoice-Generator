package test;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project extends JFrame implements ActionListener {
    String[] columns = new String[] {
            "No", "Data", "Customer", "Total"
    };

    //actual data for the table in a 2d array
    Object[][] data = new Object[][] {
            {"", "21/4/2000", "Ahmed", "3000" },
            {"", "3/7/2021", "Mohamed", "600" },
            {"", "23/6/1999", "Reham", "4500" },
    };
    final JTable table1 = new JTable(data, columns);
    String[] columns1 = new String[] {
            "No", "Item Name", "Item Price", "Count","Item Total"
    };

    //actual data for the table in a 2d array
    Object[][] data1 = new Object[][] {
            {"", "rice", "20", "2" ,"400"},
            {"", "Cola", "50", "6" ,"100"},
            {"", "oil", "100", "1" ,"350"},
    };
    final JTable table2 = new JTable(data1,columns1);
    private void createUI() {
        setLayout(new BorderLayout());
        JMenuBar mb;
        JMenu fileMenu;
        JMenuItem load;
        JMenuItem save;
        JLabel n=new JLabel("Invoice Table");
        n.setBounds(10, 0, 150, 20);
        add(n);
        // tabelspanel
        JPanel tblPnl = new JPanel(new BorderLayout());
        JPanel lefttable = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightpanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        mb=new JMenuBar();
        fileMenu=new JMenu("File");
        load=new JMenuItem("Load File");
        load.addActionListener(this);
        load.setActionCommand("L");
        save=new JMenuItem("Save");
        save.addActionListener(this);
        save.setActionCommand("S");
        setJMenuBar(mb);
        mb.add(fileMenu);
        fileMenu.add(load);
        fileMenu.add(save);
        //rightpanel.setBounds(1050,70,200,50);
        JPanel bottombtnleft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightbtnleft = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel lbltxt = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel lbltxt1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel ll=new JLabel("Invoice Number      23");
        ll.setBounds(500,8,150,20);
        add(ll);
        JLabel l=new JLabel("Invoice date");
        l.setBounds(500, 30, 150, 20);
        add(l);
        JTextField t=new JTextField(20);
        t.setBounds(600,30,150,20);
        add(t);
        JLabel l1=new JLabel("Customer Name");
        l1.setBounds(500,60,150,20);
        add(l1);
        JTextField t1=new JTextField(20);
        t1.setBounds(600,60,150,20);
        add(t1);
        JLabel ll1=new JLabel("Invoice Total         350.50");
        ll1.setBounds(500,80,150,20);
        add(ll1);
        //lbltxt1.add(new JLabel("Customer Name"));
        //lbltxt1.add(new JTextField(20));
        bottombtnleft.add(new JButton("Create New Invoice"));
        bottombtnleft.add(new JButton("Delete Invoice"));
        rightbtnleft.add(new JButton("Save"));
        rightbtnleft.add(new JButton("Cancel"));
        lefttable.add(table1);
        rightpanel.add(table2);
        tblPnl.add(lefttable,BorderLayout.WEST);
        add(tblPnl, BorderLayout.CENTER);
        add(lbltxt,BorderLayout.NORTH);
        add(lbltxt1,BorderLayout.EAST);
        tblPnl.add(rightpanel,BorderLayout.EAST);
        add(bottombtnleft, BorderLayout.SOUTH);
        add(rightbtnleft,BorderLayout.NORTH);
        lefttable.add(new JScrollPane(table1));
        rightpanel.add(new JScrollPane(table2));






        setTitle("JTable Example.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(1400,600);
    }
    public static void main(String[] args) {
        Project s=new Project();
        s.createUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "L":
                loadFile();
                break;

            case "S":
                saveFile();
                break;
        }
    }
    private void loadFile(){
        JFileChooser fc=new JFileChooser();
        int result=fc.showOpenDialog(this);
        if(result==JFileChooser.APPROVE_OPTION){
            String path =fc.getSelectedFile().getPath();
            DefaultTableModel csv=new DefaultTableModel();
            FileInputStream fs=null;
            try {
               fs=new FileInputStream(path);
                int size = fs.available();
               byte[] b = new byte[size];
                fs.read(b);
                table1.getAutoCreateColumnsFromModel();

            }catch (FileNotFoundException e){
                e.printStackTrace();

            }catch (IOException e){
                e.printStackTrace();

            }

        }
    }
    void saveFile(){

    }
}
