import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TelaPedido extends JFrame {
    public TelaPedido() {
        setTitle("Tela de Pedido");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblPizza = new JLabel("Escolha sua pizza:");
        lblPizza.setBounds(20, 20, 150, 25);
        JComboBox<String> comboPizza = new JComboBox<>();
        comboPizza.setBounds(20, 50, 240, 25);

        // Carregar sabores do banco
        try {
            Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sabor FROM pizza");

            while (rs.next()) {
                comboPizza.addItem(rs.getString("sabor"));
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar sabores: " + e.getMessage());
        }

        JButton btnPedir = new JButton("Fazer Pedido");
        btnPedir.setBounds(80, 100, 130, 30);

        btnPedir.addActionListener(e -> {
            String sabor = comboPizza.getSelectedItem().toString();
            JOptionPane.showMessageDialog(this, "Pedido de " + sabor + " realizado!");
        });

        add(lblPizza);
        add(comboPizza);
        add(btnPedir);
        setVisible(true);
    }
}