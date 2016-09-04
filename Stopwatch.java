import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

//wersja modyfikowana

public class Stopwatch
{
	private static int	pozostalyCzas;
	
	private static Timer	timer;
	
	private static int opoznienie = 1000;
	private static int czasWms = 1000;
	
	private static int getTimerGodziny;
	private static int getTimerMinuty;
	private static int getTimerSekundy;
	
	
	
/*	public Stopwatch()
	{
		pobierzCzas();
		licznikCzasu();
		
	}*/
	
	public static void startOdliczania()
	{
		timer = new Timer();
		pobierzCzas();
		licznikCzasu();
	}
	
	public static void stopOdliczania()
	{
		if (timer!=null)
		{
		timer.cancel();
		}
		else
		{}
	}
	
	private static void pobierzCzas() 
	{
		
	    /*try 
	    {
	    	getTimerGodziny=Integer.parseInt(PomodoroCustomTimer.txtGodziny.getText());
	    } 
	    catch (NumberFormatException nfe)
	    {
	    	getTimerGodziny=11;
	        System.out.println("godz");
	    }
		
	    try 
	    {
	    	getTimerMinuty=Integer.parseInt(PomodoroCustomTimer.txtGodziny.getText());
	    } 
	    catch (NumberFormatException nfe)
	    {
	    	getTimerMinuty=22;
	    	System.out.println("min");
	    }*/
	    
/*	    try 
	    {
	    	getTimerSekundy = Integer.parseInt(PomodoroCustomTimer.txtGodziny.getText());
	    } 
	    catch (NumberFormatException e)
	    {
	    	//JOptionPane.showMessageDialog(null,"Input must be a number.");
	    	//getTimerSekundy=0;
	    	System.out.println("sek");
	    }*/
		
		
		getTimerGodziny = Integer.parseInt(PomodoroCustomTimer.txtGodziny.getText());
		getTimerMinuty = Integer.parseInt(PomodoroCustomTimer.txtMinuty.getText());
		getTimerSekundy = Integer.parseInt(PomodoroCustomTimer.txtSekundy.getText());
		
		getTimerGodziny=sprawdzCzas(getTimerGodziny);
		getTimerMinuty=sprawdzCzas(getTimerMinuty);
		getTimerSekundy=sprawdzCzas(getTimerSekundy);
		
		pozostalyCzas = (getTimerGodziny*3600) + (getTimerMinuty*60) + getTimerSekundy;
		//System.out.println("Pozostaly czas: "+pozostalyCzas + " sekund");
		
	}
	
	private static int sprawdzCzas(int pobranyCzas)
	{
		if (pobranyCzas < 0)
		{
			pobranyCzas=0;
		}
		else if (pobranyCzas > 59)
		{
			pobranyCzas=59;
		}
		return pobranyCzas;
	}
	
	
	private static void ustawCzas()
	{
		int seconds = (int) (pozostalyCzas) % 60 ;
		int minutes = (int) ((pozostalyCzas / 60) % 60);
		int hours   = (int) ((pozostalyCzas / (60*60)) % 24);
		
		String setTimerGodziny = String.valueOf(hours);
		String setTimerMinuty = String.valueOf(minutes);
		String setTimerSekundy = String.valueOf(seconds);
		
		PomodoroCustomTimer.txtGodziny.setText(setTimerGodziny);
		PomodoroCustomTimer.txtMinuty.setText(setTimerMinuty);
		PomodoroCustomTimer.txtSekundy.setText(setTimerSekundy);
		
	}
			
	private static void licznikCzasu()
	{
		
		//timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{

			public void run()
			{
				licznikCzasuOdliczanie();
				ustawCzas();

			}
		}, opoznienie, czasWms);
	}
	
	private static final int licznikCzasuOdliczanie()
	{
		
		if (pozostalyCzas <= 1)
		{
			timer.cancel();
			
			AudioPlayFX.odtworzDzwiek();
			//System.out.println("koniec czasu");
		}
		//System.out.println(pozostalyCzas);
		
		return --pozostalyCzas;
		
	}
}