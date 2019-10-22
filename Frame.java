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
    public JTextField textField3;
    public JLabel label;
    public JLabel label2;
    private int randomNum;
    private int randomMinValue;
    private int randomMaxValue;
    private Boolean isClick = false;
    private Random random;
    //可视化界面
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
        textField.setText("最小值");
        textField2 = new JTextField(5);
        textField2.setText("最大值");
        panel.add(label);
        panel.add(textField);
        panel.add(textField2);
        //
        panel2 = new JPanel();
        textField3 = new JTextField(5);
        label2 = new JLabel();
        label2.setText("随机数数量");
        panel2.add(label2);
        panel2.add(textField3);
        //
        panel3 = new JPanel();
        button = new JButton();
        button.setText("提交");
        //添加监听
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   isClick = true;
                   //获取文本域中内容
                   randomMinValue = Integer.parseInt(textField.getText());
                   randomMaxValue = Integer.parseInt(textField2.getText());
                   randomNum = Integer.parseInt(textField3.getText());
                   random = new Random();
                   random.setPath("F:\\");
                   random.setFilename("123");
                   random.setFiletype(".txt");
                   ArrayList arrayList= random.Randomnum(randomMinValue,randomMaxValue,randomNum);
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

    public int getRandomMinValue() {
        return randomMinValue;
    }

    public void setRandomMinValue(int randomMinValue) {
        this.randomMinValue = randomMinValue;
    }

    public int getRandomMaxValue() {
        return randomMaxValue;
    }

    public void setRandomMaxValue(int randomMaxValue) {
        this.randomMaxValue = randomMaxValue;
    }

    public Boolean getClick() {
        return isClick;
    }

    public void setClick(Boolean click) {
        isClick = click;
    }
}
