package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class redirect extends JFrame implements ActionListener {
    JTextField text1;
    JTextField text2;
    JButton again;
    JButton exit;
    redirect(){
        this.setLayout(new GridLayout(3, 2));
        this.setLocation(400, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("16:9 calculator");

        text1 = new JTextField();
        text1.setEditable(false);
        text1.setBackground(null);
        text1.setForeground(Color.BLACK);
        text1.setSelectedTextColor(Color.RED);
        text1.setSelectionColor(Color.cyan);
        text1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        text1.setText("Result:");

        text2 = new JTextField();
        text2.setEditable(false);
        text2.setBackground(null);
        text2.setForeground(Color.BLACK);
        text2.setSelectedTextColor(Color.RED);
        text2.setSelectionColor(Color.cyan);
        text2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        text2.setText("Width: " + Lib.width + " Height: " + Lib.height);

        again = new JButton("Continue");
        again.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
        again.addActionListener(this);

        exit = new JButton("Exit");
        exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
        exit.addActionListener(this);

        this.add(text1);
        this.add(text2);
        this.add(again);
        this.add(exit);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == again){
            this.dispose();
            new GUI();
        }
        if(e.getSource() == exit) System.exit(0);
    }
}
