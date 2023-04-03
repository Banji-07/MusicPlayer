import model.Music;
import model.MusicPlayer;

import java.util.List;

import static model.Genre.*;

public class Main {
    public static void main(String[] args) {
        Music circles = new Music("Circles", "Post Malone", "Hollywood's Bleeding", 3.35f, HipHop, 2019);
        Music congratulations = new Music("Rockstar", "Post Malone", "Beer Bongs and Bentleys", 3.38f, HipHop, 2017);
        Music lucidDreams = new Music("Lucid Dreams", "Juice WRLD", "GoodBye and Good Riddance", 4.00f, HipHop, 2018);
        Music sorry = new Music("Sorry", "Justin Bieber", "Purpose", 3.38f, DancePop, 2015);
        Music loveYourself = new Music("love yourself", "Justin Beiber", "Purpose ", 3.54f, Pop, 2015);
        Music bandit = new Music("Bandit", "Juice WRLD", "Goodbye and Good Riddance", 2.45f, HipHop, 2018);
        List<Music> musicList = List.of(circles, congratulations, lucidDreams, sorry); //a list of Music's ...
        MusicPlayer musicPlayer = new MusicPlayer(); //create an instance of the music player.
        musicPlayer.addMusicToQueue(musicList); //add the tracks in the list to the music queue.
        musicPlayer.removeMusic(); //remove the first track added to the queue
        musicPlayer.addMusic(circles); //add the "sorry" track also to the queue.
        musicPlayer.play(); //The play button of the music player
        musicPlayer.addMusic(loveYourself); //add the "love yourself" track to the music queue...
        musicPlayer.play();
        musicPlayer.lastPlayedTrack(); // print's the last played track to the console
        musicPlayer.clearMusicQueue(); //this clears the music player queue
        musicPlayer.playMusic(bandit);
    }
}