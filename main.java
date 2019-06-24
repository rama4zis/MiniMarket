import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class main
{
  public static void main(String[] args) {
    new App();
  }
}

class CustomJButton extends JButton
{
  private Font font = new Font("sansserif", Font.PLAIN, 14);;

  public CustomJButton(String buttonName)
  {
    this.setText(buttonName);
    this.setFont(font);
    this.setForeground(Color.BLACK);
    this.setPreferredSize(new Dimension(115, 50));
  }
}

class App extends JFrame
{
  JFrame f;
  JPanel Menupanel = new JPanel();
  JPanel sList = new JPanel();
  JTabbedPane tbPan = new JTabbedPane(); // Untuk Parent Panel
  JPanel tPanel1 = new JPanel(); // Panel 1 untuk Makanan

  JPanel tPanel2 = new JPanel(); // Panel 2 Untuk Minuman
  DefaultListModel strukModel = new DefaultListModel();
  int TotalBelanja = 0;
  JLabel lTotal = new JLabel("Total : ");

  App(){
    Layout("Mini Market");
  }

  public void Layout(String title){
    f = new JFrame();
    f.setTitle(title);
    f.setSize(800, 600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    // f.setLocation(null);

    // f.setLayout(new GridLayout(0, 2));
    f.setLayout(new GridLayout(0, 2));
    struk();
    menu();
  }

  public void menu(){
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5,5,5,5); // Untuk setting Gap

    // untuk Menupanel
    Menupanel.setBackground(Color.BLUE);
    Menupanel.setLayout(new BorderLayout());

    // Pembayaran Panel (BuyPanel)
    JPanel bPanel = new JPanel();
    bPanel.setLayout(new GridBagLayout());
    // bPanel.setBackground(Color.BLACK);


    // Inisial Kebutuhan
    JButton bBayar;
    JLabel lUang = new JLabel("Uang ");
    JTextField bUang = new JTextField();
    bUang.setPreferredSize(new Dimension(135, 25));

    bBayar = new JButton("Bayar");

    gbc.gridx = 0;
    gbc.gridy = 0;
    // gbc.gridwidth = 1;
    bPanel.add(lUang, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    bPanel.add(bUang, gbc);
    gbc.gridwidth = 1;
    gbc.gridx = 3;
    gbc.gridy = 0;
    bPanel.add(bBayar, gbc);

    pMakanan();
    pMinuman();
    // tPanel1.add(bPanel);

    tbPan.add("Makanan", tPanel1);
    tbPan.add("Minuman", tPanel2);

    // Tambahkan semua ke Menupanel
    Menupanel.add(tbPan, BorderLayout.CENTER);
    Menupanel.add(bPanel, BorderLayout.SOUTH);
    f.add(Menupanel);

    bBayar.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int uang = Integer.parseInt(bUang.getText());
        int kembalian = uang - TotalBelanja;
        if (TotalBelanja == 0) {
          JOptionPane.showMessageDialog(null, "Belum Ada barang");
        }else{
          if(kembalian >= 0){
            JOptionPane.showMessageDialog(null, "Kembalian Anda Rp. " + kembalian);
          }else{
            JOptionPane.showMessageDialog(null, "Maaf Uang Anda Kurang");
          }
        }

      }
    });
  }

  public void pMakanan(){
    tPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
    // Panel Untuk Pembelian Makanan
    JPanel pmaPanel = new JPanel();

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL; // Ratakan posisi horizontal
    gbc.insets = new Insets(5,5,5,5); // Untuk setting Gap
    pmaPanel.setLayout(new GridBagLayout());
    pmaPanel.setBackground(Color.GREEN);

    CustomJButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    bt1 = new CustomJButton("Indomie");
    bt2 = new CustomJButton("Tango");
    bt3 = new CustomJButton("Timtam");
    bt4 = new CustomJButton("Mochi");
    bt5 = new CustomJButton("Hamtaro");
    bt6 = new CustomJButton("Citatos");
    bt7 = new CustomJButton("Taro");
    bt8 = new CustomJButton("Kuachi");
    bt9 = new CustomJButton("Lays");

    gbc.gridx = 0;
    gbc.gridy = 0;
    // gbc.gridwidth = 3;
    pmaPanel.add(bt1, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    pmaPanel.add(bt2, gbc);
    gbc.gridx = 2;
    gbc.gridy = 0;
    pmaPanel.add(bt3, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    pmaPanel.add(bt4, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    pmaPanel.add(bt5, gbc);
    gbc.gridx = 2;
    gbc.gridy = 1;
    pmaPanel.add(bt6, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    pmaPanel.add(bt7, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    pmaPanel.add(bt8, gbc);
    gbc.gridx = 2;
    gbc.gridy = 2;
    pmaPanel.add(bt9, gbc);

    tPanel1.add(pmaPanel);

    // ============= Listener BTN ==========
    bt1.addActionListener(new ActionListener() {
      // Object o = event.getSource();
      public void actionPerformed(ActionEvent e){
        String text = bt1.getText();
        int harga = 5000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt2.getText();
        int harga = 3500;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt3.getText();
        int harga = 4000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt4.getText();
        int harga = 8000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt5.getText();
        int harga = 2000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt6.getText();
        int harga = 10000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt7.getText();
        int harga = 5000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt8.getText();
        int harga = 6000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt9.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt9.getText();
        int harga = 4500;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });

  }

  public void pMinuman(){
    tPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
    // Panel Untuk Pembelian Makanan
    JPanel pmiPanel = new JPanel();

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5,5,5,5); // Untuk setting Gap
    pmiPanel.setLayout(new GridBagLayout());
    pmiPanel.setBackground(Color.GREEN);

    CustomJButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    bt1 = new CustomJButton("Aqua");
    bt2 = new CustomJButton("Pocari");
    bt3 = new CustomJButton("Fanta");
    bt4 = new CustomJButton("Coca - Cola");
    bt5 = new CustomJButton("Fruit");
    bt6 = new CustomJButton("Frestea");
    bt7 = new CustomJButton("Lemon Tea");
    bt8 = new CustomJButton("Ale - Ale");
    bt9 = new CustomJButton("Sprite");

    gbc.gridx = 0;
    gbc.gridy = 0;
    // gbc.gridwidth = 3;
    pmiPanel.add(bt1, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    pmiPanel.add(bt2, gbc);
    gbc.gridx = 2;
    gbc.gridy = 0;
    pmiPanel.add(bt3, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    pmiPanel.add(bt4, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    pmiPanel.add(bt5, gbc);
    gbc.gridx = 2;
    gbc.gridy = 1;
    pmiPanel.add(bt6, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    pmiPanel.add(bt7, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    pmiPanel.add(bt8, gbc);
    gbc.gridx = 2;
    gbc.gridy = 2;
    pmiPanel.add(bt9, gbc);

    tPanel2.add(pmiPanel);

    // ============= Listener BTN ==========
    bt1.addActionListener(new ActionListener() {
      // Object o = event.getSource();
      public void actionPerformed(ActionEvent e){
        String text = bt1.getText();
        int harga = 1500;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt2.getText();
        int harga = 5500;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt3.getText();
        int harga = 6000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt4.getText();
        int harga = 6000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt5.getText();
        int harga = 3000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt6.getText();
        int harga = 4500;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt7.getText();
        int harga = 7500;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt8.getText();
        int harga = 2500;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
    bt9.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        String text = bt9.getText();
        int harga = 6000;
        strukModel.addElement(text + "\t Rp. " + harga);
        TotalBelanja += harga;
        lTotal.setText("Total : " + TotalBelanja);
      }
    });
  }

  public void struk(){
    sList.setLayout(new BorderLayout());
    // sList.setBackground(Color.RED);


    // strukModel.addElement("Debbie Scott");
    // strukModel.addElement("Scott Hommel");
    // strukModel.addElement("Sharon Zakhour");
    JList list = new JList(strukModel);
    JScrollPane listScrollPane = new JScrollPane(list);

    JPanel pbtnStruk = new JPanel(); // parent btn
    pbtnStruk.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL; // Ratakan posisi horizontal
    gbc.insets = new Insets(5,5,5,5); // Untuk setting Gap
    // JButton btDel = new JButton("Delete");
    JButton btClear = new JButton("Clear");
    gbc.gridx = 0;
    gbc.gridy = 0;
    pbtnStruk.add(lTotal, gbc);
    // gbc.gridx = 0;
    // gbc.gridy = 1;
    // pbtnStruk.add(btDel, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    pbtnStruk.add(btClear, gbc);


    sList.add(listScrollPane, BorderLayout.CENTER);
    sList.add(pbtnStruk, BorderLayout.SOUTH);

    f.add(sList);


    // ============== FOR LISTENER ===========
    // btDel.addActionListener(new ActionListener(){
    //   public void actionPerformed(ActionEvent e) {
    //     int index = list.getSelectedIndex(); // List select index
    //     int size = strukModel.getSize(); // Total Pada List
    //     if(index != -1){
    //       strukModel.remove(index);
    //     }
    //
    //     // if(size == 0){
    //     //   btDel.setEnabled(false);
    //     // }else{
    //     //   btDel.setEnabled(true);
    //     // }
    //
    //   }
    // });
    btClear.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        strukModel.removeAllElements();
        int size = strukModel.getSize(); // Total Pada List
        // if(size == 0){
        //   btClear.setEnabled(false);
        // }else{
        //   btClear.setEnabled(true);
        // }
        lTotal.setText("Total : ");
        TotalBelanja = 0;
      }
    });
  }

}
