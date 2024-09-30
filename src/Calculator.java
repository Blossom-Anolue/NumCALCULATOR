import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
     JFrame frame;
     JTextField textfield;
     JButton[] numberButtons = new JButton[10];
     JButton[] functionButtons = new JButton[9];
     JButton addButton,subButton,mulButton,divButton;
     JButton decButton,equalButton,deleteButton,clearButton, negButton;
     JPanel panel;

     Font myFont = new Font("Times New Roman", Font.BOLD, 30);
     double num1=0, num2=0, result=0;
     char operator;

    Calculator() {
        frame = new JFrame("My First Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,560);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        clearButton = new JButton("CLR");
        deleteButton = new JButton("DEL");
        negButton = new JButton("(-)");

        functionButtons[0]= addButton;
        functionButtons[1]= subButton;
        functionButtons[2]= mulButton;
        functionButtons[3]= divButton;
        functionButtons[4]= decButton;
        functionButtons[5]= equalButton;
        functionButtons[6]= clearButton;
        functionButtons[7]= deleteButton;
        functionButtons[8]= negButton;

        for(int i=0;i<9;i++){
           functionButtons[i].addActionListener(this);
           functionButtons[i].setFont(myFont);
           functionButtons[i].setFocusable(false);
        }

        deleteButton.setBounds(50,430,100,50);
        clearButton.setBounds(150,430,100,50);
        equalButton.setBounds(250,430,100,50);

        for(int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
         }

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.PINK); //I left the pink to help me see the grid

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(divButton);
        panel.add(negButton);


        frame.add(textfield);
        frame.setVisible(true);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(equalButton);
        frame.add(panel);
    }
        public static void main (String[]args){
           Calculator calc = new Calculator();

        }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i =0; i<10;i++){
            if (e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == addButton){
            num1=Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }

        if (e.getSource() == decButton){
            textfield.setText(textfield.getText());
        }

        if(e.getSource() == subButton){
            num1=Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }

        if(e.getSource() == mulButton){
            num1=Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }

        if(e.getSource() == divButton){
            num1=Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }

        if(e.getSource() == equalButton){
            num2=Double.parseDouble(textfield.getText());
            switch(operator) {
                case '+':  //Case for addition
                    result=num1+num2;
                    break;
                case '-':   //subtraction
                    result=num1-num2;
                    break;
                case '*':   //multiplication
                    result=num1*num2;
                    break;
                case '/':   //divisions
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource()==clearButton){
            textfield.setText("");
        }
        if(e.getSource() == deleteButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i =0; i<string.length()-1;i++){
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
            }

        }

    }
