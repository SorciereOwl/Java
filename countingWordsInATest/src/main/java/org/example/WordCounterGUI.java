package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterGUI extends JFrame implements ActionListener {
    JLabel textLabel, wordCountLabel, charCountLabel, charNoSpaceCountLabel;
    JTextField inputTextField;

    WordCounterGUI() {
        textLabel = new JLabel("Введите текст:");
        textLabel.setBounds(50,50,200,30);

        inputTextField = new JTextField();
        inputTextField.setBounds(50,100,300,30);

        wordCountLabel = new JLabel("Счётчик слов: 0");
        wordCountLabel.setBounds(50,150,200,30);

        charCountLabel = new JLabel("Количество символов (с пробелами): 0");
        charCountLabel.setBounds(50,200,300,30);

        charNoSpaceCountLabel = new JLabel("Количество символов (без пробелами): 0");
        charNoSpaceCountLabel.setBounds(50,250,300,30);

        JButton countButton = new JButton("Посчитать");
        countButton.setBounds(200,300,100,30);
        countButton.addActionListener(this);

        add(textLabel);
        add(inputTextField);
        add(wordCountLabel);
        add(charCountLabel);
        add(charNoSpaceCountLabel);
        add(countButton);

        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Посчитать")) {
            String text = inputTextField.getText();
            int wordCount = text.split("\\s+").length;
            int charCountWithSpace = text.length();
            int charCountNoSpace = text.replace(" ", "").length();

            wordCountLabel.setText("Счётчик слов: " + wordCount);
            charCountLabel.setText("Количество символов (с пробелами): " + charCountWithSpace);
            charNoSpaceCountLabel.setText("Количество символов (без пробелами): " + charCountNoSpace);
        }
    }

    public static void main(String[] args) {
        new WordCounterGUI();
    }
}