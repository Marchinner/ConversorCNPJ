import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Application extends JFrame {
    private JPanel ApplicationPanel;
    private JTextField textFieldCNPJOld;
    private JButton converterButton;
    private JTextField textFieldCNPJNew;
    private JLabel JLabelDone;

    public Application() {
        ImageIcon img = null;

        java.net.URL imgURL = Application.class.getResource("icon.png");
        if (imgURL != null) {
            img = new ImageIcon(imgURL);
            setIconImage(img.getImage());
        } else {
            System.out.println("Ícone não encontrado!");
        }
        setTitle("Conversor CNPJ");
        add(ApplicationPanel);
        setPreferredSize(new Dimension(400, 100));
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setFocusable(true);
        requestFocus();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setIconImage(img.getImage());
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldCNPJOld.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ApplicationPanel, "O campo do CNPJ não pode estar em branco!");
                } else if (textFieldCNPJOld.getText().length() > 18 || textFieldCNPJOld.getText().length() < 18) {
                    JOptionPane.showMessageDialog(ApplicationPanel, "O número de CNPJ inserido é inválido!");
                    System.out.println(textFieldCNPJOld.getText().length());
                } else {
                    String newCNPJ = textFieldCNPJOld.getText();
                    newCNPJ = newCNPJ.replace("/", "");
                    newCNPJ = newCNPJ.replace(".", "");
                    newCNPJ = newCNPJ.replace("-", "");
                    textFieldCNPJNew.setText(newCNPJ);

                    StringSelection stringSelection = new StringSelection(newCNPJ);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);

                    textFieldCNPJOld.setText("");
                    textFieldCNPJOld.requestFocus();
                    JLabelDone.setText("CNPJ Convertido!");
                    JLabelDone.setForeground(Color.RED);
                }
            }
        });
        textFieldCNPJOld.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                JLabelDone.setText("");
            }
        });
    }
}
