import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TelaConsultaCliente extends JFrame {
    public TelaConsultaCliente() {
        setTitle("Consulta de Clientes");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JTextArea areaResultado = new JTextArea();
        areaResultado.setBounds(20, 20, 240, 160);
        areaResultado.setEditable(false);

        JButton btnCarregar = new JButton("Carregar");
        btnCarregar.setBounds(90, 190, 100, 30);

        btnCarregar.addActionListener(e -> {
            try {
                Connection conn = Conexao.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT nome, telefone FROM cliente");

                StringBuilder resultado = new StringBuilder();
                while (rs.next()) {
                    resultado.append("Nome: ").append(rs.getString("nome"))
                             .append(" | Tel: ").append(rs.getString("telefone"))
                             .append("\n");
                }

                areaResultado.setText(resultado.toString());
                conn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        add(areaResultado);
        add(btnCarregar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaConsultaCliente();
    }
}