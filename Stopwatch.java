import java.util.Timer;
import java.util.TimerTask;

//wersja modyfikowana

public class Stopwatch
{
	private static int	pozostalyCzas;
	private static String sekundy;
	
	private static Timer	timer;
	
	private static int opoznienie = 1000;
	private static int czasWms = 1000;
	
	
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
	
	public static void pobierzCzas()
	{
		
		
		int getTimerGodziny = Integer.parseInt(PomodoroCustomTimer.txtGodziny.getText());
		int getTimerMinuty = Integer.parseInt(PomodoroCustomTimer.txtMinuty.getText());
		int getTimerSekundy = Integer.parseInt(PomodoroCustomTimer.txtSekundy.getText());
		
		pozostalyCzas = (getTimerGodziny*3600) + (getTimerMinuty*60) + getTimerSekundy;
		//System.out.println("Pozostaly czas: "+pozostalyCzas + " sekund");
		
	}
	
	public static void ustawCzas()
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
			
/*	public static int getLicznikCzasu()
	{
		return pozostalyCzas;
	}

	public static void setLicznikCzasu(int licznikCzasu)
	{
		Stopwatch.pozostalyCzas = licznikCzasu;
	}

	public static String getSekundy()
	{
		return sekundy;
	}

	public static void setSekundy(String sekundy)
	{
		Stopwatch.sekundy = sekundy;
	}*/

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
		
		if (pozostalyCzas == 1)
		{
			timer.cancel();
			
			AudioPlayFX.odtworzDzwiek();
			//System.out.println("koniec czasu");
		}
		//System.out.println(pozostalyCzas);
		
		return --pozostalyCzas;
		
	}
}