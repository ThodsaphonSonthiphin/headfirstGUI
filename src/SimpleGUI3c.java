
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SimpleGUI3c {
    JFrame jFrame;
    JLabel label;
    LabelListener myLabelListener;
    ColorListener myColorListener;

    public static void main(String[] args){

        SimpleGUI3c simpleGUI3c = new SimpleGUI3c();

        simpleGUI3c.go();

    }

    public void go(){
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change label");

        myLabelListener = new LabelListener();

        labelButton.addActionListener(myLabelListener);

        JButton colorButton = new JButton("Change drawing color");

        myColorListener = new ColorListener();
        colorButton.addActionListener(myColorListener);

        label = new JLabel("I am a label");




        MyDrawPanel myDrawPanel = new MyDrawPanel();

        jFrame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        jFrame.getContentPane().add(BorderLayout.CENTER,myDrawPanel);
        jFrame.getContentPane().add(BorderLayout.EAST,labelButton);
        jFrame.getContentPane().add(BorderLayout.WEST,label);

        jFrame.setSize(300,300);
        jFrame.setVisible(true);


    }



    class LabelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Ouch!");

        }
    }

    class ColorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.repaint();

        }
    }
}


class MyDrawPanel extends JPanel{

    private boolean detect = false;

    private void toggle(){
        if(detect == false){
            detect = true;
        }else {
            detect = false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        Image myImage = new ImageIcon("Stark.jpg").getImage();
//        Image myImage2 = new ImageIcon("Stark2.jpg").getImage();
//
//        if(detect == true){
//            g.drawImage(myImage,0,0,this);
//        }else {
//            g.drawImage(myImage2,0,0,this);
//        }
//
//        toggle();




        g.fillRect(0,0,this.getWidth(),this.getHeight());

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red,green,blue);

        g.setColor(randomColor);
        g.fillOval(70,70,100,100);


    }
}
