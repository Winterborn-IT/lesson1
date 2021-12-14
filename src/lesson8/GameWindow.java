package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    static final int WINDOWS_POS_X = 500;
    static final int WINDOWS_POS_Y = 300;
    static final int WINDOWS_WIDTH = 500;
    static final int WINDOWS_HEIGHT = 550;

    private SettingWindow settingWindow;
    private BattleField battleField;

    public GameWindow() {
        setBounds(WINDOWS_POS_X, WINDOWS_POS_Y, WINDOWS_WIDTH, WINDOWS_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");

        settingWindow = new SettingWindow(this);
        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnNewGame = new JButton("Start new game");
        JButton btnExit = new JButton("Exit");
        panel.add(btnNewGame);
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);
        btnExit.setBackground(Color.MAGENTA);
        btnNewGame.setBackground(Color.CYAN);

        btnExit.addActionListener(e -> System.exit(0));

        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });

        setVisible(true);
    }

    void startNewGame(int size, int winningLength) {
        battleField.startNewGame(size, winningLength);
    }
}
