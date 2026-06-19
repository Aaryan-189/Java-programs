import javax.swing.*;
import java.awt.*;
public class SwingEditor extends JFrame {
    JTextPane textPane;
    public SwingEditor() {
        setTitle("Simple Word Editor");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textPane = new JTextPane();
        add(new JScrollPane(textPane), BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Open"));
        fileMenu.add(new JMenuItem("Save"));
        JMenu formatMenu = new JMenu("Format");
        JMenuItem boldItem = new JMenuItem("Bold");
        boldItem.addActionListener(e -> {
            textPane.setFont(textPane.getFont().deriveFont(Font.BOLD));
        });
        formatMenu.add(boldItem);
        menuBar.add(fileMenu);
        menuBar.add(formatMenu);
        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingEditor());
    }
}