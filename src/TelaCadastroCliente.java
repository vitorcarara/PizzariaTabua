import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TelaCadastroCliente extends JFrame {
    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 25);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 20, 160, 25);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 60, 80, 25);
        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(100, 60, 160, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 100, 100, 30);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String telefone = txtTelefone.getText();

            try {
                Connection conn = Conexao.conectar();
                String sql = "INSERT INTO cliente (nome, telefone) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, telefone);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                conn.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        add(lblNome);
        add(txtNome);
        add(lblTelefone);
        add(txtTelefone);
        add(btnSalvar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaCadastroCliente();
    }
}