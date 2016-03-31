import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
//-----------------------------------------
public class PomodoroCustomTimer extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextField txtGodziny;
	public static JTextField txtMinuty;
	public static JTextField txtSekundy;
	

	
	private ButtonGroup jrbgPomodoroCustom;
	private ButtonGroup jrbgPomodoroCzas;
	
	private JRadioButton rdbtnPomodoro, rdbtnCustom;
	private JRadioButton rdbtnCzasPomodoro, rdbtnCzasShortBreak, rdbtnCzasLongBreak;
	
	private JButton btnStart, btnStop;
	private JButton btnInfo;
	
	private JLabel lblGodziny, lblMin, lblSec, lblPomodoroCount, lblPomodoroIlosc;


	
	//=========================================
	public PomodoroCustomTimer()
	{
		setResizable(false);
		setTitle("Pomodoro Custom Timer");
		setSize(180,225);
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//------------------------------------
		jrbgPomodoroCustom = new ButtonGroup();
		jrbgPomodoroCzas = new ButtonGroup();
		//------------------------------------
		
		rdbtnPomodoro = new JRadioButton("Pomodoro");
		rdbtnPomodoro.setSelected(true);
		rdbtnPomodoro.setBounds(10, 10, 80, 20);
		jrbgPomodoroCustom.add(rdbtnPomodoro);
		getContentPane().add(rdbtnPomodoro);
		rdbtnPomodoro.addActionListener(this);
		
		rdbtnCustom = new JRadioButton("Custom");
		rdbtnCustom.setBounds(100, 10, 70, 20);
		jrbgPomodoroCustom.add(rdbtnCustom);
		getContentPane().add(rdbtnCustom);
		rdbtnCustom.addActionListener(this);
		
		txtGodziny = new JTextField();
		txtGodziny.setHorizontalAlignment(SwingConstants.CENTER);
		txtGodziny.setText("00");
		txtGodziny.setBounds(10, 35, 30, 30);
		getContentPane().add(txtGodziny);
		txtGodziny.setColumns(10);
		//txtGodziny.setEnabled(true);
		txtGodziny.setEnabled(false);
		
		lblGodziny = new JLabel("h");
		lblGodziny.setBounds(40, 43, 15, 15);
		getContentPane().add(lblGodziny);
		
		txtMinuty = new JTextField();
		txtMinuty.setHorizontalAlignment(SwingConstants.CENTER);
		txtMinuty.setText("25");
		txtMinuty.setBounds(60, 35, 30, 30);
		getContentPane().add(txtMinuty);
		txtMinuty.setColumns(10);
		//txtMinuty.setEnabled(true);
		txtMinuty.setEnabled(false);
				
		lblMin = new JLabel("min");
		lblMin.setBounds(90, 43, 25, 15);
		getContentPane().add(lblMin);
		
		txtSekundy = new JTextField();
		txtSekundy.setHorizontalAlignment(SwingConstants.CENTER);
		txtSekundy.setText("00");
		txtSekundy.setBounds(115, 35, 30, 30);
		getContentPane().add(txtSekundy);
		txtSekundy.setColumns(10);
		//txtSekundy.setEnabled(true);
		txtSekundy.setEnabled(false);
		
		lblSec = new JLabel("sec");
		lblSec.setBounds(145, 43, 30, 15);
		getContentPane().add(lblSec);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(20, 75, 65, 25);
		getContentPane().add(btnStart);
		btnStart.addActionListener(this);
		
		btnStop = new JButton("Stop");
		btnStop.setBounds(95, 75, 65, 25);
		getContentPane().add(btnStop);
		btnStop.addActionListener(this);
		
		rdbtnCzasPomodoro = new JRadioButton("Pomodoro");
		rdbtnCzasPomodoro.setSelected(true);
		rdbtnCzasPomodoro.setBounds(10, 110, 90, 25);
		jrbgPomodoroCzas.add(rdbtnCzasPomodoro);
		getContentPane().add(rdbtnCzasPomodoro);
		rdbtnCzasPomodoro.addActionListener(this);
				
		rdbtnCzasShortBreak = new JRadioButton("Short Break");
		rdbtnCzasShortBreak.setBounds(10, 135, 90, 25);
		jrbgPomodoroCzas.add(rdbtnCzasShortBreak);
		getContentPane().add(rdbtnCzasShortBreak);
		rdbtnCzasShortBreak.addActionListener(this);
		
		rdbtnCzasLongBreak = new JRadioButton("Long Break");
		rdbtnCzasLongBreak.setBounds(10, 160, 90, 25);
		jrbgPomodoroCzas.add(rdbtnCzasLongBreak);
		getContentPane().add(rdbtnCzasLongBreak);
		rdbtnCzasLongBreak.addActionListener(this);
		
		lblPomodoroCount = new JLabel("Counter");
		lblPomodoroCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomodoroCount.setBounds(100, 115, 85, 15);
		getContentPane().add(lblPomodoroCount);
		
		lblPomodoroIlosc = new JLabel("0");
		lblPomodoroIlosc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomodoroIlosc.setBounds(130, 140, 20, 15);
		getContentPane().add(lblPomodoroIlosc);
		
		btnInfo = new JButton("i");
		btnInfo.setBounds(123, 160, 35, 25);
		getContentPane().add(btnInfo);
		btnInfo.addActionListener(this);
		
		//-----------------------------------------
		//LOOK And Feel -----------------------------
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		
		//-----------------------------------------
			
	}
	//-----------------------------------------	
	
	public void CzasDoSekund()
	{
		
	}
	
	//-----------------------------------------	
	public static void main(String[] args)
	{
		
		PomodoroCustomTimer app = new PomodoroCustomTimer();
		app.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==rdbtnCustom)
		{
			rdbtnCzasPomodoro.setEnabled(false);
			rdbtnCzasShortBreak.setEnabled(false);
			rdbtnCzasLongBreak.setEnabled(false);
			
			txtGodziny.setText("00");
			txtMinuty.setText("25");
			txtSekundy.setText("00");
			
			txtGodziny.setEnabled(true);
			txtMinuty.setEnabled(true);
			txtSekundy.setEnabled(true);
			
			Stopwatch.stopOdliczania();			
			
		}

		if(e.getSource()==rdbtnPomodoro)
		{
			rdbtnCzasPomodoro.setEnabled(true);
			rdbtnCzasShortBreak.setEnabled(true);
			rdbtnCzasLongBreak.setEnabled(true);
			
			txtGodziny.setText("00");
			txtMinuty.setText("25");
			txtSekundy.setText("00");
			
			txtGodziny.setEnabled(false);
			txtMinuty.setEnabled(false);
			txtSekundy.setEnabled(false);
			
			Stopwatch.stopOdliczania();
		}
		
		if(e.getSource()==rdbtnCzasPomodoro)
		{
			txtGodziny.setText("00");
			txtMinuty.setText("25");
			txtSekundy.setText("00");
		}
		
		if(e.getSource()==rdbtnCzasShortBreak)
		{
			txtGodziny.setText("00");
			txtMinuty.setText("05");
			txtSekundy.setText("00");
		}
		
		if(e.getSource()==rdbtnCzasLongBreak)
		{
			txtGodziny.setText("00");
			txtMinuty.setText("15");
			txtSekundy.setText("00");
		}
		
		if(e.getSource()==btnStart)
		{
			Stopwatch.startOdliczania();
		}
		if(e.getSource()==btnStop)
		{
			Stopwatch.stopOdliczania();
		}
		
		if(e.getSource()==btnInfo)
		{
			JOptionPane.showMessageDialog(null, "\u00a9 Kamil Zakrzewski, v0.8\nhttp://sites.google.com/site/kamilzprog/", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
