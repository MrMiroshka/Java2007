package course1.homework8;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

/**
 * Домашнее задание №8 курс Java 1 (задача минимум)
 *
 * @author Miroshnichenko Igor
 * @version 1.8
 * created on 2022-01-29
 */
public class MinimumWindow extends JFrame {
    private int value;
    private JTextPane textPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel label;
    private long count;
    private SimpleAttributeSet keyWord;

    public MinimumWindow() {
        setBounds(500, 500, 500, 240);
        Dimension dorig = getSize();
        keyWord = new SimpleAttributeSet();

        //задаем минимальный размер окна
        AffineTransform at = getGraphicsConfiguration().getDefaultTransform();
        Dimension dmin = new Dimension((int) (dorig.width * at.getScaleX()), (int) (dorig.height * at.getScaleY()));
        setMinimumSize(dmin);

        setTitle("HOME WORK №8");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //шрифт
        Font font = new Font("Arial", Font.BOLD, 32);

        //общая верхняя панель
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        //кнопки увеличения и уменьшения
        createPanel1(font);
        createPanel3(font);
        //отображение числа
        createPanel2(font);
        //для вывода логов
        createPanel4(font);

        topPanel.add(panel1, BorderLayout.WEST);
        topPanel.add(panel2, BorderLayout.CENTER);
        topPanel.add(panel3, BorderLayout.EAST);


        //Добавление инфопанели
        //Будем показывать ошибку если значение счетчика по модулю >100
        add(panel4, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void append(String s, AttributeSet attribute) {
        try {
            Document doc = textPane.getDocument();
            doc.insertString(doc.getLength(), s,attribute);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void errorLog(){
        StyleConstants.setForeground(keyWord, Color.RED);
        StyleConstants.setBackground(keyWord, Color.YELLOW);
        StyleConstants.setBold(keyWord, true);
    }

    private void infoLog(){
        StyleConstants.setForeground(keyWord, Color.BLACK);
        StyleConstants.setBackground(keyWord, Color.WHITE);
        StyleConstants.setBold(keyWord, true);
    }

    private void validateRange() {
        if (Math.abs(value) > 100) {
            String str = ++count + ": "+ " ERROR - Value out of renage (>100 по модулю) \n";
            errorLog();
            append(str,keyWord);
        }
    }

    public static void main(String[] args) {
        new course1.homework8.MinimumWindow();
    }

    public void createPanel1(Font font) {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        panel1.add(decrementButton, BorderLayout.WEST);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                label.setText(String.valueOf(value));
                String str = ++count + ": "+ " INFO - Пользователь уменьшил значение на '1' \n";
                infoLog();
                append(str,keyWord);
                validateRange();
            }
        });


        JButton decrementButton10 = new JButton("<<");
        decrementButton10.setFont(font);
        panel1.add(decrementButton10, BorderLayout.EAST);

        decrementButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value -= 10;
                label.setText(String.valueOf(value));
                String str = ++count + ": "+ " INFO - Пользователь уменьшил значение на '10' \n";
                infoLog();
                append(str,keyWord);
                validateRange();
            }
        });
    }

    public void createPanel2(Font font) {
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        label = new JLabel(String.valueOf(value));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(label, BorderLayout.CENTER);
    }

    public void createPanel3(Font font) {
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        panel3.add(incrementButton, BorderLayout.EAST);

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                label.setText(String.valueOf(value));
                String str = ++count + ": "+ " INFO - Пользователь увеличил значение на '1' \n";
                infoLog();
                append(str,keyWord);
                validateRange();
            }
        });

        JButton incrementButton10 = new JButton(">>");
        incrementButton10.setFont(font);
        panel3.add(incrementButton10, BorderLayout.WEST);

        incrementButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value += 10;
                label.setText(String.valueOf(value));
                String str = ++count + ": "+ " INFO - Пользователь увеличил значение на '10' \n";
                infoLog();
                append(str,keyWord);
                validateRange();
            }
        });
    }

    public void createPanel4(Font font) {
        panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.setPreferredSize(new Dimension(400, 100));
        panel4.setMinimumSize(new Dimension(100, 50));

        panel4.add(new JLabel("Вывод логов:"), BorderLayout.NORTH);
        textPane = new JTextPane();
        textPane.setEditable(false);
        JScrollPane scroll = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel4.add(scroll, BorderLayout.CENTER);

    }
}
