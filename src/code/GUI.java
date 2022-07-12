package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {
    GUI(){
        this.setLayout(new GridLayout(3, 2));
        this.setLocation(400, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("16:9 calculator");
        Lib.err = 0;
        Lib.width = 0;
        Lib.height = 0;

        Lib.side1 = new JTextField();
        Lib.side1.setEditable(false);
        Lib.side1.setBackground(null);
        Lib.side1.setForeground(Color.BLACK);
        Lib.side1.setSelectedTextColor(Color.RED);
        Lib.side1.setSelectionColor(Color.cyan);
        Lib.side1.setFont(new Font("Calibri", Font.BOLD, 18));
        Lib.side1.setText("Width:");

        Lib.side2 = new JTextField();
        Lib.side2.setEditable(false);
        Lib.side2.setBackground(null);
        Lib.side2.setForeground(Color.BLACK);
        Lib.side2.setSelectedTextColor(Color.RED);
        Lib.side2.setSelectionColor(Color.cyan);
        Lib.side2.setFont(new Font("Calibri", Font.BOLD, 18));
        Lib.side2.setText("Height:");

        Lib.text1 = new JTextField();
        Lib.text1.setEditable(true);
        Lib.text1.setBackground(null);
        Lib.text1.setForeground(Color.BLACK);
        Lib.text1.setSelectedTextColor(Color.RED);
        Lib.text1.setSelectionColor(Color.cyan);
        Lib.text1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        Lib.text2 = new JTextField();
        Lib.text2.setEditable(true);
        Lib.text2.setBackground(null);
        Lib.text2.setForeground(Color.BLACK);
        Lib.text2.setSelectedTextColor(Color.RED);
        Lib.text2.setSelectionColor(Color.cyan);
        Lib.text2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        Lib.submit = new JButton("Proceed");
        Lib.submit.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
        Lib.submit.addActionListener(this);

        Lib.exit = new JButton("Exit");
        Lib.exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
        Lib.exit.addActionListener(this);

        this.add(Lib.side1);
        this.add(Lib.text1);
        this.add(Lib.side2);
        this.add(Lib.text2);
        this.add(Lib.submit);
        this.add(Lib.exit);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Lib.submit){
            var width = Lib.text1.getText();
            var height = Lib.text2.getText();
                try{
                    Lib.width = Integer.parseInt(width);
                }catch (NumberFormatException b){
                    Lib.err = Lib.err + 1;
                    Lib.widthisNull = true;
                }
                try{
                    Lib.height = Integer.parseInt(height);
                }catch (NumberFormatException b){
                    Lib.err = Lib.err + 1;
                    Lib.heightIsNull = true;
                }
            if(Lib.err == 2) System.exit(0);
            else{
                if(Lib.widthisNull) Lib.width = Lib.height* 16/9;
                else if(Lib.heightIsNull) Lib.height = Lib.width * 9/16;
                this.dispose();
                new redirect();
            }
        }else if(e.getSource() == Lib.exit) System.exit(0);
    }
}
