import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BBB extends JFrame {
    private String[] competidores;
    private int[] votos;
    private JButton btnVotar;
    private JTextArea resultadoArea;

    public BBB(String[] competidores) {
        this.competidores = competidores;
        this.votos = new int[competidores.length];

        setTitle("Votação BBB 2024");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 5, 5);

        btnVotar = new JButton("Vote Aqui! ");
        btnVotar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                votar();
            }
        });
        panel.add(btnVotar, gbc);

        JButton btnVerVotos = new JButton("Ver quem sai!");
        btnVerVotos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirPosicoes();
            }
        });
        panel.add(btnVerVotos, gbc);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void votar() {
        String voto = JOptionPane.showInputDialog("Em quem você vota para sair da casa? ");
        for (int i = 0; i < competidores.length; i++) {
            if (voto.equalsIgnoreCase(competidores[i])) {
                votos[i]++;
                JOptionPane.showMessageDialog(this, "Voto computado para " + competidores[i] + "!");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Competidor não encontrado na lista.");
    }

    private void exibirPosicoes() {
        int maxVotosIndex = 0;
        for (int i = 1; i < votos.length; i++) {
            if (votos[i] > votos[maxVotosIndex]) {
                maxVotosIndex = i;
            }
        }

        JOptionPane.showMessageDialog(this,
                "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir " +
                        "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu " +
                        "\nconseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu " +
                        "vou conseguir te eliminar com alegria. Com " + votos[maxVotosIndex] + " votos, é você quem sai " +
                        competidores[maxVotosIndex] + "!!!",
                "Quem sai hoje", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[] competidores = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                        "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin", "Lucas Henrique",
                        "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral", "Maycon Cosmer", "MC Bin Laden",
                        "Michel Nogueira", "Nizam", "Raquele Cardozo", "Rodriguinho", "Thalyta Alves", "Vanessa Lopes",
                        "Vinicius Rodrigues", "Wanessa Camargo", "Yasmin Brunet"};
                new BBB(competidores);
            }
        });
    }
}
