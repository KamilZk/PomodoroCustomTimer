import java.io.IOException;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

public class Countdown
{
	private static int sec;
	private static Scanner sc;
	
	public static void main(String[] args) throws IOException
	{
		sc = new Scanner(System.in);
		LocalTime tTeraz = LocalTime.now();
		
		System.out.println("Pocz¹tek odliczania: " + tTeraz);
		
		System.out.println("Podaj czas (w sekundach):");
		sec = sc.nextInt();

		//Period czas = Period.(tTeraz, tTeraz.minusNanos(sec*100));
		System.out.println("Podany czas: " + sec);
		
	}

}
