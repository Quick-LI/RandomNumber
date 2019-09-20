import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Frame {
    public JFrame frame;
    public JPanel panel;
    public JPanel panel2;
    public JPanel panel3;
    public JButton button;
    public JTextField textField;
    public JTextField textField2;
    public JLabel label;
    public JLabel label2;
    private int randomNum;
    private int randomValue;
    private Boolean isClick = false;
    private Random random;
    public void init(){
        frame = new JFrame();
        frame.setTitle("随机数");
        frame.setSize(450,150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        panel = new JPanel();
        label = new JLabel();
        label.setText("随机数范围");
        textField = new JTextField(5);
        panel.add(label);
        panel.add(textField);
        //
        panel2 = new JPanel();
        textField2 = new JTextField(5);
        label2 = new JLabel();
        label2.setText("随机数数量");
        panel2.add(label2);
        panel2.add(textField2);
        //
        panel3 = new JPanel();
        button = new JButton();
        button.setText("提交");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   isClick = true;
                   randomValue = Integer.parseInt(textField.getText());
                   randomNum = Integer.parseInt(textField2.getText());
                   random = new Random();
                   random.setPath("F:\\");
                   random.setFilename("123");
                   random.setFiletype(".txt");
                   ArrayList arrayList= random.Randomnum(randomValue,randomNum);
                   random.fileInputRandom(arrayList);
            }
        });
        panel3.add(button);
        //
        Box box = Box.createVerticalBox();
        box.add(panel);
        box.add(panel2);
        box.add(panel3);
        frame.setContentPane(box);
        frame.setVisible(true);
    }

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }

    public Boolean getClick() {
        return isClick;
    }

    public void setClick(Boolean click) {
        isClick = click;
    }
}
