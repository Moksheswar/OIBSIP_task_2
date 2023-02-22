import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Task1 extends JFrame{
	static int a,n;
	public static void main(String args[]){
		JFrame f1,f2;
		f1=new JFrame();
		f2=new JFrame();
		JLabel l1,l2,l3,l4,l5,l6,l7;
		l1=new JLabel("NUMBER GUESSING GAME");
		l2=new JLabel("*****RULES TO PLAY*****",JLabel.CENTER);
		l3=new JLabel("@ System will generate a random number(1-100).");
		l4=new JLabel("@ You have 3 chances to guess that number.");
		l5=new JLabel("@ Attempt 1 --> 100 points");
		l6=new JLabel("@ Attempt 2 --> 90 points");
		l7=new JLabel("@ Attempt 3 --> 80 points");
		l1.setBounds(100,20,400,30);
		l1.setFont(new Font("Courier",Font.BOLD,20));
		l1.setForeground(Color.red);
		l2.setBounds(50,70,300,20);
		l2.setFont(new Font("Courier",Font.BOLD,15));
		l3.setBounds(50,100,350,20);
		l4.setBounds(50,130,300,20);
		l5.setBounds(50,160,250,20);
		l6.setBounds(50,190,250,20);
		l7.setBounds(50,220,250,20);
		f1.add(l1); f1.add(l2); f1.add(l3); f1.add(l4); f1.add(l5); f1.add(l6); f1.add(l7);
		JButton b1=new JButton("PLAY");
		b1.setBounds(150,275,150,50);
		f1.add(b1);
		JButton b2=new JButton("GENERATE");
		b2.setBounds(150,200,200,50);
		f2.add(b2);
		JLabel l=new JLabel("*Generate the number*");
		l.setBounds(150,150,300,50);
		l.setFont(new Font("Courier-Bold",Font.BOLD,16));
		l.setForeground(Color.blue);
		f2.add(l);
		JLabel l8=new JLabel("*Number Generated Successfully*");
		l8.setBounds(125,150,300,50);
		l8.setFont(new Font("Courier-Bold",Font.BOLD,16));
		l8.setForeground(Color.blue);
		f2.add(l8);
		l8.setVisible(false);
		JButton b3=new JButton("ENTER");
		b3.setBounds(150,200,200,50);
		f2.add(b3);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				f1.setVisible(false);
				f2.setVisible(true);
				l8.setVisible(false);
				b3.setVisible(false);
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Random r=new Random();
				a=r.nextInt(100);
				System.out.println(a);
				b2.setVisible(false);
				l.setVisible(false);
				l8.setVisible(true);
				b3.setVisible(true);
			}
		});
		JLabel l9,l10;
		l9=new JLabel();
		l10=new JLabel();
		l9.setBounds(175,200,200,50);
		l10.setBounds(175,200,200,50);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				for(int i=0;i<3;i++){
					String s=JOptionPane.showInputDialog("Enter a number:");
					n=Integer.parseInt(s);
					if(n==a){
						JOptionPane.showMessageDialog(f2,"Congratulations!\nYou won the game.");
						l9.setText("YOU GOT "+(100-i*10)+" POINTS");
						b3.setVisible(false);
						l9.setVisible(true);
						l10.setVisible(false);
						break;
					}
					else if(n<a)
						JOptionPane.showMessageDialog(f2,"Your number is lesser than the generated number.\nTry again.");
					else if(n>a)
						JOptionPane.showMessageDialog(f2,"Your number is greater than the generated number.\nTry again.");
				}
				if(n!=a){
					l10.setText("YOU LOST THE GAME");
					b3.setVisible(false);
					l9.setVisible(false);
					l10.setVisible(true);
				}
			}
		});
		f2.add(l9);f2.add(l10);
		f2.setSize(500,500);
		f2.setLayout(null);
		f1.setSize(500,500);
		f1.setLayout(null);
		f1.setVisible(true);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}