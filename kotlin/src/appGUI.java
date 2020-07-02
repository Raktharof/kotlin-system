import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import classes.Rectangle;
import classes.CNPJ;
import classes.DateTime;

public class appGUI {
    private JComboBox cmbInterRec1;
    private JComboBox cmbInterRec2;
    private JButton checkButton;
    private JComboBox cmbAOIRec1;
    private JComboBox cmbAOIRec2;
    private JButton calculateButton;
    private JTextField cnpj_txt;
    private JButton validateButton;
    private JPanel mainPanel;
    private JLabel checkText;
    private JLabel calculateText;
    private JLabel validateText;
    private JComboBox cmbDateTime;
    private JButton timeCheckButton;
    private JLabel timeText;


    public appGUI() {
        Rectangle recA = new Rectangle(3, 11, 5, 11);
        Rectangle recB = new Rectangle(7, 13, 2, 7);
        Rectangle recC = new Rectangle(10, 14, 10, 13);
        Rectangle[] recArray = {recA, recB, recC};

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstRec = cmbInterRec1.getSelectedIndex();
                int secondRec = cmbInterRec2.getSelectedIndex();
                if (recArray[firstRec].intersects(recArray[secondRec])){
                    checkText.setText("Os retângulos intersecionam");
                } else {
                    checkText.setText("Os retângulos NÃO intersecionam");
                }

            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int firstRec = cmbAOIRec1.getSelectedIndex();
                int secondRec = cmbAOIRec2.getSelectedIndex();

                int areaOfIntersection = recArray[firstRec].calculateIntersectArea(recArray[secondRec]);

                calculateText.setText("A Área de interseção é " + areaOfIntersection);
            }
        });
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CNPJ filledCNPJ = new CNPJ(cnpj_txt.getText());

                validateText.setText(filledCNPJ.checkFormatAndValue());
            }
        });
        timeCheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = new DateTime().getDateTimeByZone(cmbDateTime.getSelectedItem().toString());
                timeText.setText(date);
            }
        });
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new appGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1100,300);
        frame.setResizable(false);
    }
}
