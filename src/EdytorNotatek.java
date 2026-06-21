import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EdytorNotatek extends JFrame {

    // Deklaracja komponentów
    private JLabel lblEdytorNotatek;
    private JTextField txtTrescNotatki;
    private JButton btnZapisz;
    private JButton btnWyczysc;
    private JLabel lblNotatka;
    private JLabel lblEtykietaStatusu;


    // Konstruktor
    public EdytorNotatek() {
        // Ustawienia okna
        setTitle("Edytor Notatek (BorderLayout)");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tworzymy panel z BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));

        // === NORTH – nagłówek aplikacji ===
        // Tworzenie komponentów
        lblEdytorNotatek = new JLabel("Edytor Notatek");
        // Dodawanie komponentów do panelu – kolejność dodawania = kolejność wyświetlania
        panel.add(lblEdytorNotatek, BorderLayout.NORTH);

        // === CENTER – pole do wpisywania notatki ===
        txtTrescNotatki = new JTextField(4);
        txtTrescNotatki.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTrescNotatki.setHorizontalAlignment(JTextField.LEFT);
        panel.add(txtTrescNotatki, BorderLayout.CENTER);

        // === SOUTH – pasek statusu ===
        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnZapisz = new JButton("Zapisz");
        btnWyczysc = new JButton("Wyczyść");
        lblEtykietaStatusu = new JLabel("-----------");
        panelSouth.add(btnZapisz);
        panelSouth.add(btnWyczysc);
        panelSouth.add(lblEtykietaStatusu);
        panel.add(panelSouth, BorderLayout.SOUTH);

        // === WEST – etykieta statusu ===
        lblNotatka = new JLabel("Notatka");
        panel.add(lblNotatka, BorderLayout.WEST);

        // Obsługa zdarzenia – przycisk "Zapisz"
        btnZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String notatka = txtTrescNotatki.getText().trim();
                if (!notatka.isEmpty()) {
                    lblEtykietaStatusu.setText("Status: Zapisano notatkę (" + notatka.length() + " znaków)");
                } else {
                    lblEtykietaStatusu.setText("Status: Błąd – notatka jest pusta!");
                }
            }
        });

        // Obsługa zdarzenia – przycisk "Wyczyść"
        btnWyczysc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTrescNotatki.setText("");
                lblEtykietaStatusu.setText("-----------");
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EdytorNotatek();
    }
}