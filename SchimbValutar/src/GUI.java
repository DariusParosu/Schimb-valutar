import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    String[] date = {"RON", "USD", "EUR", "GBP"};
    float nrIntrodus;
    String monedaDeIntrare;
    String monedaRezultanta;

    JFrame frame;
    JPanel panel;
    JLabel primulLabel;
    JTextField textField;
    JComboBox<String> primulComboBox;
    JLabel alDoileaLabel;
    JComboBox<String> alDoileaComboBox;
    JButton button;
    static JLabel rezultatLabel;


    public GUI() {
        frame = new JFrame("Schimb Valutar");
        frame.setSize(480, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        primulLabel = new JLabel("Aplicatie pentru schimbul valutar");
        primulLabel.setBounds(150, 20, 225, 25);
        panel.add(primulLabel);

        textField = new JTextField();
        textField.setBounds(10, 80, 75, 25);
        panel.add(textField);

        primulComboBox = new JComboBox<>(date);
        primulComboBox.setBounds(85, 80, 50, 25);
        panel.add(primulComboBox);

        alDoileaLabel = new JLabel("In");
        alDoileaLabel.setBounds(150, 80, 25, 25);
        panel.add(alDoileaLabel);

        alDoileaComboBox =new JComboBox<>(date);
        alDoileaComboBox.setBounds(170, 80, 50, 25);
        panel.add(alDoileaComboBox);

        button = new JButton("Enter");
        button.setBounds(10, 130, 75, 25);
        button.addActionListener(this);
        panel.add(button);

        rezultatLabel = new JLabel("");
        rezultatLabel.setBounds(10, 170, 150, 25);
        panel.add(rezultatLabel);

        frame.setVisible(true);
    }

    public static void AfisareRezultat(float rezultat, String monedaRezultanta) {
        rezultatLabel.setText("Rezultat: " + rezultat + " " + monedaRezultanta);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nrIntrodus = Float.parseFloat(textField.getText());
        monedaDeIntrare = primulComboBox.getSelectedItem().toString();
        monedaRezultanta = alDoileaComboBox.getSelectedItem().toString();
        new Main(nrIntrodus, monedaDeIntrare, monedaRezultanta);
    }
}
