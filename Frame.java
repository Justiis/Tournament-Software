import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Frame
  extends JFrame
{
  private JButton jButton1;
  private JButton jButton2;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JTextField op;
  private List list1;
  private JProgressBar progressBar;
  private JTextArea textArea;
  private JScrollPane scrollPane;
  private JButton btnNewButton_1;
  private JButton btnReportABug;
  
  public Frame()
  {
    super("Tournament Random 1v1 - by Justiis");
    getContentPane().setBackground(Color.DARK_GRAY);
    getContentPane().setFont(new Font("Tahoma", 0, 11));
    initComponents();
    setSize(1190, 625);
    setResizable(false);
    
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
  }
  
  private void initComponents()
  {
    String newline = "\n";
    this.jLabel1 = new JLabel();
    this.jLabel1.setForeground(Color.WHITE);
    this.jLabel1.setBackground(new Color(240, 240, 240));
    this.jLabel1.setFont(new Font("Times New Roman", 1, 15));
    this.op = new JTextField();
    this.op.setBackground(Color.LIGHT_GRAY);
    this.jButton1 = new JButton();
    this.jButton1.setBackground(Color.GRAY);
    this.jButton1.setFont(new Font("Times New Roman", 1, 14));
    this.jButton2 = new JButton();
    this.jButton2.setBackground(Color.GRAY);
    this.jButton2.setFont(new Font("Times New Roman", 1, 14));
    this.jButton2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Random rand = new Random();
        
        String randomElement = Frame.this.list1.getItem(rand.nextInt(Frame.this.list1.countItems()));
        String randomElement1 = Frame.this.list1.getItem(rand.nextInt(Frame.this.list1.countItems()));
        if (Frame.this.list1.countItems() % 2 != 0)
        {
          Frame.this.textArea.append("THE NUMBER MUST BE EVEN\n��������������������\n");
        }
        else
        {
          do
          {
            randomElement = Frame.this.list1.getItem(rand.nextInt(Frame.this.list1.countItems()));
            randomElement1 = Frame.this.list1.getItem(rand.nextInt(Frame.this.list1.countItems()));
          } while (randomElement == randomElement1);
          Frame.this.textArea.append(randomElement + "  VS  " + randomElement1 + "\n" + "��������������������" + "\n");
          
          Frame.this.list1.remove(randomElement);
          Frame.this.list1.remove(randomElement1);
        }
      }
    });
    this.jLabel2 = new JLabel();
    this.jLabel2.setForeground(Color.WHITE);
    this.jLabel2.setFont(new Font("Times New Roman", 1, 14));
    this.list1 = new List();
    this.list1.setFont(new Font("Dialog", 0, 12));
    this.list1.setBackground(Color.LIGHT_GRAY);
    this.jLabel3 = new JLabel();
    this.jLabel3.setForeground(Color.WHITE);
    this.jLabel3.setFont(new Font("Times New Roman", 1, 14));
    
    setDefaultCloseOperation(3);
    
    this.jLabel1.setText("IGN :");
    this.op.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Frame.this.jTextField1ActionPerformed(evt);
      }
    });
    this.jButton1.setText("Add Player");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        Frame.this.jButton1ActionPerformed(evt);
      }
    });
    this.jButton2.setText("Extract Duels");
    
    this.jLabel2.setText("PLAYERS LIST:");
    
    this.jLabel3.setText("DUELS:");
    
    this.progressBar = new JProgressBar();
    this.progressBar.setBackground(Color.BLACK);
    
    JButton btnNewButton = new JButton("SUPPORT \nCREATOR");
    btnNewButton.setFont(new Font("Sitka Small", 0, 15));
    btnNewButton.setBackground(Color.GRAY);
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Frame.this.setVisible(false);
        Frame.this.dispose();
        Credits s = new Credits();
        s.setVisible(true);
      }
    });
    JButton btnDelete = new JButton("DELETE");
    btnDelete.setBackground(Color.GRAY);
    btnDelete.setFont(new Font("Times New Roman", 1, 12));
    btnDelete.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        int index = Frame.this.list1.getSelectedIndex();
        if (index != -1) {
          Frame.this.list1.remove(index);
        }
      }
    });
    this.scrollPane = new JScrollPane();
    
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(new ImageIcon(Frame.class.getResource("/imgs/rfrf.png")));
    
    JButton btnDelete_1 = new JButton("Edit ");
    btnDelete_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        Frame.this.textArea.setEditable(true);
      }
    });
    btnDelete_1.setFont(new Font("Times New Roman", 1, 14));
    
    this.btnNewButton_1 = new JButton("NO edit");
    this.btnNewButton_1.setFont(new Font("Times New Roman", 1, 13));
    this.btnNewButton_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Frame.this.textArea.setEditable(false);
      }
    });
    this.btnReportABug = new JButton("REPORT A BUG!");
    this.btnReportABug.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Desktop broswer = Desktop.getDesktop();
        try
        {
          broswer.browse(new URI("https://t.me/LiteeStudios/27"));
        }
        catch (IOException localIOException) {}catch (URISyntaxException localURISyntaxException) {}
      }
    });
    this.btnReportABug.setBackground(Color.GRAY);
    this.btnReportABug.setFont(new Font("Sitka Small", 0, 15));
    
    GroupLayout layout = new GroupLayout(getContentPane());
    layout.setHorizontalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGap(24)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addComponent(this.progressBar, -1, -1, 32767)
      .addGroup(layout.createSequentialGroup()
      .addComponent(this.jLabel1)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.op, -2, 121, -2)
      .addGap(24)
      .addComponent(this.jButton1)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(this.jButton2)))
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addComponent(this.jLabel3, -2, 94, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(btnDelete_1, -2, 67, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(this.btnNewButton_1))
      .addComponent(this.scrollPane, -2, 284, -2))
      .addGap(101)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addGroup(layout.createSequentialGroup()
      .addGap(10)
      .addComponent(btnNewButton)
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
      .addComponent(this.btnReportABug, -2, 167, -2))
      .addComponent(lblNewLabel, -2, 440, -2))))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 238, 32767)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.jLabel2, -2, 185, -2)
      .addComponent(this.list1, -2, 138, -2)
      .addComponent(btnDelete))
      .addContainerGap()));
    
    layout.setVerticalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addGap(19)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.op, -2, 25, -2)
      .addComponent(this.jButton1, -1, 35, 32767)
      .addComponent(this.jButton2, -2, 35, -2)
      .addComponent(this.jLabel1, -2, 34, -2))
      .addGap(28)
      .addComponent(this.progressBar, -2, 19, -2)
      .addGap(18))
      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(btnDelete)
      .addGap(27)))
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
      .addGroup(layout.createSequentialGroup()
      .addComponent(this.jLabel3, -2, 38, -2)
      .addGap(10))
      .addGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addComponent(btnDelete_1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
      .addComponent(this.btnNewButton_1, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
      .addGap(18))
      .addGroup(layout.createSequentialGroup()
      .addComponent(this.jLabel2, -2, 26, -2)
      .addGap(18)))
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.scrollPane, -2, 385, -2)
      .addComponent(this.list1, -2, 381, -2)))
      .addGroup(layout.createSequentialGroup()
      .addComponent(lblNewLabel, -2, 363, -2)
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(btnNewButton, -2, 72, -2)
      .addComponent(this.btnReportABug, -2, 66, -2))
      .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
      .addGap(49)));
    
    this.textArea = new JTextArea();
    this.scrollPane.setViewportView(this.textArea);
    this.textArea.setFont(new Font("Microsoft YaHei UI Light", 1, 15));
    this.textArea.setTabSize(16);
    this.textArea.setBackground(Color.LIGHT_GRAY);
    this.textArea.setEditable(false);
    getContentPane().setLayout(layout);
    
    pack();
  }
  
  private void jTextField1ActionPerformed(ActionEvent evt) {}
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    this.list1.addItem(this.op.getText());
    this.op.setText("");
  }
  
  public static void main(String[] args)
  {
    try
    {
      UIManager.LookAndFeelInfo[] arrayOfLookAndFeelInfo;
      int j = (arrayOfLookAndFeelInfo = UIManager.getInstalledLookAndFeels()).length;
      for (int i = 0; i < j; i++)
      {
        UIManager.LookAndFeelInfo info = arrayOfLookAndFeelInfo[i];
        if ("Nimbus".equals(info.getName()))
        {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (UnsupportedLookAndFeelException ex)
    {
      Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
    }
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new Frame().setVisible(true);
      }
    });
  }
}
