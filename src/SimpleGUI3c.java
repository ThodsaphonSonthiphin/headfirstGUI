import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleGUI3c implements ActionListener {
    JFrame jFrame;
    public static void main(String[] args){

        SimpleGUI3c simpleGUI3c = new SimpleGUI3c();

        simpleGUI3c.go();

    }

    public void go(){
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("click me");

        button.addActionListener(this);

        MyDrawPanel myDrawPanel = new MyDrawPanel();

        jFrame.getContentPane().add(BorderLayout.SOUTH,button);
        jFrame.getContentPane().add(BorderLayout.CENTER,myDrawPanel);

        jFrame.setSize(300,300);
        jFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {



        jFrame.repaint();


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
