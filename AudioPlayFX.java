import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayFX
{
	
	//inicjacja panelu JavaFX - nie zadziala bez tego
	static{
	    JFXPanel fxPanel = new JFXPanel();
	}
	
	public static void odtworzDzwiek()
	{
		String musicFile = "tada.wav";

		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
				
			mediaPlayer.setCycleCount(3);
			mediaPlayer.play();
			
	}
	
}

