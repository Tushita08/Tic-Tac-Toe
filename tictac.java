//@author - Tushita Rathore , 2015108


import java.awt.FlowLayout ;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;
import java.awt.* ;
import javax.swing.JFrame ;
import javax.swing.JLabel ; 
import javax.swing.* ;
import java.util.*;


public class tictac extends JFrame{	


	public static void main(String args[])
	{
		tictac frame = new tictac();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,300);
		frame.setVisible(true);
		frame.pack();
	}


	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panell = new JPanel();
	JPanel panelr = new JPanel();
	JButton button1,button2,button3,button4,button5,button6,button7,button8,button9;
	
	private String option = "" ;

	public int count=0,flag = 0 ;

	JTextField output;
	grid gridgame ;
	String fn ,sn;
	JButton b1;
	JButton b2;
	JButton t1,t2,t3,t4,t5;
	int chk=0,rowchk = 0 ;
	public tictac()
	{
		//super("THE GAME");
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
		
		JLabel label1 = new JLabel("      Tic-Tac-Toe         ");
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);


		
		b1 = new JButton("Start Game");
		b1.setAlignmentX(Component.CENTER_ALIGNMENT);

		b2 = new JButton("Exit");
		b2.setAlignmentX(Component.CENTER_ALIGNMENT);


		panel1.add(label1); 
		panel1.add(Box.createRigidArea(new Dimension(0, 40)));
		panel1.add(b1);
		panel1.add(Box.createRigidArea(new Dimension(0, 40)));
		panel1.add(b2);

		add(panel1);

		panell.setLayout(new BoxLayout(panell, BoxLayout.Y_AXIS));
		panell.setBorder(new EmptyBorder(new Insets(50, 0, 50, 50)));

		panelr.setLayout(new BoxLayout(panelr, BoxLayout.Y_AXIS));
		panelr.setBorder(new EmptyBorder(new Insets(50, 0, 50, 50)));

		
		
		
		thehandler handler = new thehandler();
		b1.addActionListener(handler);
		b2.addActionListener(handler);


	}

	

	private class thehandler implements ActionListener{
		public void actionPerformed(ActionEvent event)
		{
			String str = "";

			if(event.getSource()==b1)
			{
				start();
				gridgame = new grid();
				gridgame.setLayout(new GridLayout(3,3));
				panelr.add(gridgame);
				
				panelr.add(Box.createRigidArea(new Dimension(0, 40)));
				output = new JTextField();
				panelr.add(output);

				panel2.add(panell);
				panel2.add(panelr);

				setContentPane(panel2);
				revalidate();



			}
			else if(event.getSource()==b2)
			{
				System.exit(0);
			}

		}
	}


	public void start()
	{
		
		t1 = new JButton("User1-User2 game");
		t1.setAlignmentX(Component.CENTER_ALIGNMENT);

		t2 = new JButton("User v/s Computer");
		t2.setAlignmentX(Component.CENTER_ALIGNMENT);

		t3 = new JButton("Computer v/s AI bot");
		t3.setAlignmentX(Component.CENTER_ALIGNMENT);

		t4 = new JButton("User v/s AI bot");
		t4.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		t5 = new JButton("Exit");
		t5.setAlignmentX(Component.CENTER_ALIGNMENT);

		panell.add(t1);
		panell.add(Box.createRigidArea(new Dimension(0, 40)));
		panell.add(t2);
		panell.add(Box.createRigidArea(new Dimension(0, 40)));
		panell.add(t3);
		panell.add(Box.createRigidArea(new Dimension(0, 40)));
		panell.add(t4);
		panell.add(Box.createRigidArea(new Dimension(0, 40)));
		panell.add(t5);

		add(panell);

		inhandler handle = new inhandler();
		t1.addActionListener(handle);
		t2.addActionListener(handle);
		t3.addActionListener(handle);
		t4.addActionListener(handle);
		t5.addActionListener(handle);



	}

	

	private class inhandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			String str = "";

			if(e.getSource()==t1)
			{
				chk=1;
				gridgame.reset();
				fn = JOptionPane.showInputDialog("First User");
				sn = JOptionPane.showInputDialog("Second User");
				t1.setForeground(Color.RED);
				output.setText(fn+"'s turn");

				
			}
			else if(e.getSource()==t5)
			{
				chk = 5;
				System.exit(0);
			}
			else if(e.getSource()==t2)
			{
				chk = 2;
				String fn = JOptionPane.showInputDialog("First User");
			}
			else if(e.getSource()==t3)
			{
				chk = 3;
				//timer	
			}
			else if(e.getSource()==t4)
			{
				chk = 4;
				String fn = JOptionPane.showInputDialog("First User");
			}

			System.out.println(chk);

		}
	}

//Inner class grid	

public class grid extends JPanel{

	//setLayout(new GridLayout(3,3));



	board brd = new board();
	

	public grid()
	{
		button1 = new JButton("");
		button2 = new JButton("");
		button3 = new JButton("");
		button4 = new JButton("");
		button5 = new JButton("");
		button6 = new JButton("");
		button7 = new JButton("");
		button8 = new JButton("");
		button9 = new JButton("");
		

		add(button1);
		button1.setPreferredSize(new Dimension(70,70));
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);

		eventbutton manage = new eventbutton();
		button1.addActionListener(manage);
		button2.addActionListener(manage);
		button3.addActionListener(manage);
		button4.addActionListener(manage);
		button5.addActionListener(manage);
		button6.addActionListener(manage);
		button7.addActionListener(manage);
		button8.addActionListener(manage);
		button9.addActionListener(manage);
		

	}

	public void reset()
	{
		button1.setText("");
		button1.setEnabled(true);
		button2.setText("");
		button2.setEnabled(true);
		button3.setText("");
		button3.setEnabled(true);
		button4.setText("");
		button4.setEnabled(true);
		button5.setText("");
		button5.setEnabled(true);
		button6.setText("");
		button6.setEnabled(true);
		button7.setText("");
		button7.setEnabled(true);
		button8.setText("");
		button8.setEnabled(true);
		button9.setText("");
		button9.setEnabled(true);

		button1.setBackground(null);
		button2.setBackground(null);
		button3.setBackground(null);
		button4.setBackground(null);
		button5.setBackground(null);
		button6.setBackground(null);
		button7.setBackground(null);
		button8.setBackground(null);
		button9.setBackground(null);


	}
}

//----------------------------------------action listener for user-user----------------------------------

	private class eventbutton implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{


			if(chk==1)
			{

				if(count == 0 || count == 2 || count == 4 || count == 6 || count == 8)
				{
					option = "X";
				}
				else if(count == 1 || count == 3 || count == 5 || count == 7)
				{
					option = "O";
				}
				count++;
				
				if(a.getSource() == button1)
				{
					button1.setText(option);
					button1.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn +"'s turn ");
					}

				}
				else if(a.getSource() == button2)
				{
					button2.setText(option);
					button2.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn+"'s turn ");
					}
				}
				else if(a.getSource() == button3)
				{
					button3.setText(option);
					button3.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn+"'s turn ");
					}
				}
				else if(a.getSource() == button4)
				{
					button4.setText(option);
					button4.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn+"'s turn ");
					}
				}
				else if(a.getSource() == button5)
				{
					button5.setText(option);
					button5.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn+"'s turn ");
					}
				}
				else if(a.getSource() == button6)
				{
					button6.setText(option);
					button6.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn+"'s turn ");
					}
				}
				else if(a.getSource() == button7)
				{
					button7.setText(option);
					button7.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn+"'s turn ");
					}
				}
				else if(a.getSource() == button8)
				{
					button8.setText(option);
					button8.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn+"'s turn ");
					}
				}
				else if(a.getSource() == button9)
				{
					button9.setText(option);
					button9.setEnabled(false);
					if(count%2==0)
					{
						output.setText(fn+"'s turn");
					}
					else if(count%2==1)
					{
						output.setText(sn+"'s turn ");
					}
				}

				int f = checkState();

				//System.out.println(f);
				if(f==2 && count%2==0)
				{
					output.setText(sn + "(O) Wins !");
					color();
					t1.setForeground(null);
					count=0;
					
				}
				else if(f==2 && count%2==1)
				{
					output.setText(fn + "(X) Wins !");
					color();
					count=0;
					t1.setForeground(null);
					
				}
				else if(f==1)
				{
					output.setText("Its a Tie!");
					t1.setForeground(null);
					//reset();
					count=0;
				}

			}
		}
	}

	

//-----------------------------computers turn ----------------------------------------------------
	public void putcomp()
	{
		Random x = new Random();
		Random y = new Random();

		int x1= x.nextInt(3);
		int y1= y.nextInt(3);
		while(x1<3 && y1<3)
		{
			x1= x.nextInt(3);
			y1= y.nextInt(3);
		}

		if(checkState()==0)
		{

			if(x1==0 && y1==0)
			{
				button1.setText("O");
				button1.setEnabled(false);
			}
			else if(x1==0 && y1==1)
			{
				button2.setText("O");
				button2.setEnabled(false);
			}
			else if(x1==0 && y1==2)
			{
				button3.setText("O");
				button3.setEnabled(false);
			}
			else if(x1==1 && y1==0)
			{
				button4.setText("O");
				button4.setEnabled(false);
			}
			else if(x1==1 && y1==1)
			{
				button5.setText("O");
				button5.setEnabled(false);
			}
			else if(x1==1 && y1==2)
			{
				button6.setText("O");
				button6.setEnabled(false);
			}
			else if(x1==2 && y1==2)
			{
				button9.setText("O");
				button9.setEnabled(false);
			}
			else if(x1==2 && y1==1)
			{
				button8.setText("O");
				button8.setEnabled(false);
			}
			else if(x1==2 && y1==0)
			{
				button7.setText("O");
				button7.setEnabled(false);
			}
		}
	}

//------------------------------------	CHECKSTATE FOR GRID-------------------------------------------------

	public int checkState()
	{
		flag = 3;
		if(button1.getText() =="" || button2.getText() == "" || button3.getText() == "" || button4.getText() =="" || button5.getText() =="" || button6.getText() =="" || button7.getText() =="" || button8.getText() =="" || button9.getText() =="" )
		{
			flag=0;
			rowchk=1;
		}


		//horizontal + vertical +diagonal
		if( button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "")
		{
			flag = 2 ;
			rowchk=1;
		}
		else if( button4.getText() == button5.getText() && button5.getText() == button6.getText() && button6.getText() != "")
		{
			flag = 2;
			rowchk=2;
		}
		else if( button7.getText() == button8.getText() && button8.getText() == button9.getText() && button9.getText() != "")
		{
			flag = 2 ;
			rowchk=3;
		}

		if( button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "")
		{
			flag = 2 ;
			rowchk=4;
		}
		else if( button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "")
		{
			flag = 2 ;
			rowchk=5;
		}
		else if( button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "")
		{
			flag = 2 ;
			rowchk=6;
		}


		if( button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "")

		{
			flag = 2 ;
			rowchk=7;
		}
		else if( button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "")
		{
			flag = 2 ;
			rowchk=8;
		}
//tie checking
		if(flag==3)
		{
			flag = 1;
			//tie;
		}	

		return flag;
	}
//-------------------------------set color for tiles-----------------------------------------------------
	public void color()
	{
		if (checkState()==2)
		{
			if(rowchk==1)
			{
				button1.setBackground(Color.blue);
				button2.setBackground(Color.blue);
				button3.setBackground(Color.blue);
			}
			else if(rowchk==2)
			{
				button4.setBackground(Color.blue);
				button5.setBackground(Color.blue);
				button6.setBackground(Color.blue);
			}
			else if(rowchk==3)
			{
				button7.setBackground(Color.blue);
				button8.setBackground(Color.blue);
				button9.setBackground(Color.blue);
			}
			else if(rowchk==4)
			{
				button1.setBackground(Color.blue);
				button4.setBackground(Color.blue);
				button7.setBackground(Color.blue);
			}
			else if(rowchk==5)
			{
				button2.setBackground(Color.blue);
				button5.setBackground(Color.blue);
				button8.setBackground(Color.blue);
			}
			else if(rowchk==6)
			{
				button3.setBackground(Color.blue);
				button6.setBackground(Color.blue);
				button9.setBackground(Color.blue);
			}
			else if(rowchk==7)
			{
				button1.setBackground(Color.blue);
				button5.setBackground(Color.blue);
				button9.setBackground(Color.blue);
			}
			else if(rowchk==8)
			{
				button3.setBackground(Color.blue);
				button5.setBackground(Color.blue);
				button7.setBackground(Color.blue);
			}
		}
	}

	





}