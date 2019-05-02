import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Conversion {
    JFrame frame;
    JButton run;
    JComboBox select;
    JTextField input;
    JPanel panel;
    JLabel conversion,  finish;
    String user = "0";

    int selection;
    double factor, convert;

    String[] selections = {"Meters to Feet", "Feet to Meters",
            "Gallons to Liters", "Liters to Gallons",
            "Pounds to Kilos", "Kilos to Pounds"};
    double[] factors = {3.281, 0.3048, 4.546, 0.2641, 0.453, 2.205};


    public Conversion(){

        frame = new JFrame("Converter");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));

        panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        conversion = new JLabel("Select your conversion type: ");
        conversion.setAlignmentY(JLabel.TOP);
        panel.add(conversion);

        select = new JComboBox(selections);
        select.setSelectedIndex(0);
        panel.add(select);

        JLabel help = new JLabel("Input your numerical data to convert");
        panel.add(help);

        input = new JTextField(10);
        panel.add(input);

        run = new JButton("Click to Convert");
        run.addActionListener(this::actionPerformed);
        panel.add(run);

        finish = new JLabel();
        finish.setAlignmentY(JLabel.BOTTOM);
        panel.add(finish);

        frame.setContentPane(panel);
        frame.setVisible(true);

    }

    private static void runGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        Conversion window = new Conversion();
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> runGUI());
    }

    private void actionPerformed(ActionEvent event) {
        selection = select.getSelectedIndex();
        user = input.getText();
        convert = Double.parseDouble(user);
        factor = convert * factors[selection];
        finish.setText(String.valueOf(factor));
    }
}