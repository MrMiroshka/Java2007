package course1.lesson8;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value;
    private JLabel infoLabel;

    public CounterApp() {
        setBounds(500, 500, 300, 120);
        setTitle("Counter APP");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //шрифт
        Font font = new Font("Arial", Font.BOLD, 32);

        //текстово поле (не редактируемое)
        JLabel label = new JLabel(String.valueOf(value));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label,BorderLayout.CENTER);

        //Добавление инфопанели
        //Будем показывать ошибку если значение счетчика по модулю >10
        //JLabel infoLabel = new JLabel(); или
        infoLabel = new JLabel();
        infoLabel.setBackground(Color.RED);
        add(infoLabel,BorderLayout.NORTH);

        //кнопки увеличения и уменьшения
        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton,BorderLayout.WEST);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton,BorderLayout.EAST);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                label.setText(String.valueOf(value));
                validateRange();
            }
        });

        setVisible(true);
    }

    private void validateRange(){
        if(Math.abs(value)>10){
            infoLabel.setText("Value out of renage");
        }else{
            infoLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new CounterApp();
    }
}
