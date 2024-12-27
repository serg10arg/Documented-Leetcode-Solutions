import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class KMPVisualizer extends JFrame {

    private String text;
    private String pattern;
    private ArrayList<Integer> matches;

    public KMPVisualizer(String text, String pattern, ArrayList<Integer> matches) {
        this.text = text;
        this.pattern = pattern;
        this.matches = matches;

        setTitle("KMP Algorithm Visualization");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTextAndPattern(g);
            }
        };

        add(panel);
    }

    private void drawTextAndPattern(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 20));

        // Dibuja el texto
        g.drawString(text, 50, 100);

        // Dibuja el patrón debajo del texto
        g.drawString(pattern, 50, 150);

        // Resalta coincidencias
        for (int match : matches) {
            g.setColor(Color.RED);
            g.drawString(pattern, 50 + match * 20, 150); // Ajusta según el tamaño de fuente
            g.setColor(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        FirstOccurrenceKMP solution = new FirstOccurrenceKMP();

        String text = "sadbutsad";
        String pattern = "sad";

        ArrayList<Integer> result = new ArrayList<>();

        int index = solution.strStr(text, pattern);

        if (index != -1) {
            result.add(index); // Agrega el índice donde se encontró el patrón
        }

        SwingUtilities.invokeLater(() -> {
            KMPVisualizer visualizer = new KMPVisualizer(text, pattern, result);
            visualizer.setVisible(true);
        });
    }
}
