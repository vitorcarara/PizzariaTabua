import javax.swing.*;

public class TelaLogin {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tela de Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(20, 20, 80, 25);
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 20, 160, 25);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 60, 80, 25);
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 60, 160, 25);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(100, 100, 100, 30);

        btnEntrar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());

            if (usuario.equals("admin") && senha.equals("123")) {
                JOptionPane.showMessageDialog(frame, "Login feito com sucesso!");
                new TelaPedido().setVisible(true);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Usuário ou senha incorretos.");
            }
        });

        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblSenha);
        frame.add(txtSenha);
        frame.add(btnEntrar);
        frame.setVisible(true);
    }
}