import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FrameManager extends JFrame {

    // Main contents
    public JPanel gamePanel;
    public JPanel gridPanel;
    public ArrayList<JPanel> cells;

    private int gridWidth = 70;
    private int gridHeight = 50;
    private int cellSize = 10;

    // Status contents
    public JPanel statusPanel;
    public JTextArea logArea;

    // Action contents
    public JPanel actionPanel;

    public FrameManager(String title, int width, int height) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        cells = new ArrayList<>();
    }

    public void createFrameComponents() {
        // Game panel
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.BLACK);
        gamePanel.setPreferredSize(new Dimension(getSize().width - 200, getSize().height - 100));
        gamePanel.setLayout(new GridBagLayout());

        // Add 9x9 grid
        JPanel gridPanel = new JPanel(new GridLayout(gridWidth, gridHeight));
        gridPanel.setBackground(Color.CYAN);

        for (int i = 0; i < gridWidth * gridHeight; i++) {
            JPanel cell = new JPanel();
            cell.setBackground(Color.WHITE);
            cell.setPreferredSize(new Dimension(cellSize, cellSize));
            cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            cells.add(cell);
            gridPanel.add(cell);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;

        // Action panel
        actionPanel = new JPanel();
        actionPanel.setBackground(new Color(0, 128, 128));
        actionPanel.setPreferredSize(new Dimension(getSize().width, 100));

        // Status panel
        statusPanel = new JPanel();
        statusPanel.setBackground(Color.BLUE);
        statusPanel.setPreferredSize(
                new Dimension(200, getSize().height - actionPanel.getHeight()));
        statusPanel.setLayout(new BorderLayout());

        logArea = new JTextArea(1, 100);
        logArea.setEditable(false);
        logArea.setText("Welcome to the RPG Game!");

        gamePanel.add(gridPanel, gbc);
        statusPanel.add(logArea, BorderLayout.SOUTH);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        getContentPane().add(statusPanel, BorderLayout.EAST);
        getContentPane().add(actionPanel, BorderLayout.SOUTH);
    }

    public void tempSetPlayer() {
        cells.get(0).setBackground(Color.RED);
    }

    public void log(String message) {
        logArea.setText(message);
    }

}
