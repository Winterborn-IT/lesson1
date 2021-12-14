package lesson8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    static final int WINDOWS_POS_X = GameWindow.WINDOWS_POS_X + 50;
    static final int WINDOWS_POS_Y = GameWindow.WINDOWS_POS_Y + 50;
    static final int WINDOWS_WIDTH = 400;
    static final int WINDOWS_HEIGHT = 300;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;


    private GameWindow gameWindow;
    private JSlider slFieldSize;
    private JSlider slWinningLength;
    private JButton btnNewGame;


    public SettingWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBounds(WINDOWS_POS_X, WINDOWS_POS_Y, WINDOWS_WIDTH, WINDOWS_HEIGHT);
        setTitle("Tic Tac Toe Settings");
        setLayout(new GridLayout(5, 1));

        add(new Label("Field size: "));
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setPaintTicks(true);
        add(slFieldSize);

        add(new Label("Dots to win: "));
        slWinningLength = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE,MIN_FIELD_SIZE);
        slWinningLength.setMajorTickSpacing(1);
        slWinningLength.setPaintLabels(true);
        slWinningLength.setPaintTicks(true);
        add(slWinningLength);

        slFieldSize.addChangeListener(e -> slWinningLength.setMaximum(slFieldSize.getValue()));

        JButton btnNewGame = new JButton("Start new Game");
        add(btnNewGame);

        btnNewGame.addActionListener(e -> {
            int size = slFieldSize.getValue();
            int winningLength = slWinningLength.getValue();

            Logic.SIZE = size;
            Logic.DOTS_TO_WIN = winningLength;
            Logic.initMap();
            Logic.gameFinished = false;

            gameWindow.startNewGame(size, winningLength);
            setVisible(false);
        });

        setVisible(false);
    }
}
