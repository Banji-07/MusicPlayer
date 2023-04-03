package model;

import datastructures.Queue;
import datastructures.Stack;
import errors.QueueUnderFlowError;
import errors.StackOverFlowError;

import java.util.List;

public class MusicPlayer {
    private Music musicToBePlayed; //current music that's playing
    private final Queue musicQueue;
    private final Stack musicStack;

    private boolean playing;

    public MusicPlayer(int queueSize, int stackSize) { //a constructor in case the user want's custom values for the stack and queue
        musicQueue = new Queue(queueSize);
        musicStack = new Stack(stackSize);
    }

    public MusicPlayer() {  //No args constructor that uses the value 10 as the size for both the Queue and the Stack
        musicQueue = new Queue(10);
        musicStack = new Stack(10);
    }

    public void addMusic(Music music) { //this method simply adds a music track to the queue
        //add music to queue
        musicQueue.insert(music);
        System.out.println(music + " has been added to the queue.");
    }

    public void addMusicToQueue(List<Music> musicList) { //this method simply adds a list of Music tracks to the queue
        //add a list of music to the queue
        musicList.forEach(music -> addMusic(music));
    }

    public void removeMusic() {//remove the music at the head of the queue
        try {
            Music music = musicQueue.remove();
            System.out.println(music + " has been removed from the Queue.");
        } catch (QueueUnderFlowError queueUnderFlowError) {
            System.out.println("There is currently no Music in the Queue, So no music can be removed.");
        }
    }

    public void play() {
        try {
            run();
        } catch (StackOverFlowError stackOverFlowError) {
            System.out.println("The call stack size of the music player has been exceeded.");
        }
    }

    private void run() { //plays music loaded into the queue
        if (!musicQueue.isEmpty() && !playing) {
            musicToBePlayed = musicQueue.peekFront(); //get the music at the head...
            String artist = musicToBePlayed.getArtist(); //get the artist name
            String title = musicToBePlayed.getTitle(); //get the title
            float duration = musicToBePlayed.getDuration(); //duration in seconds
            playing = true; //set playing to true, meaning that the music player is currently playing music...
            musicStack.push(musicToBePlayed); //adds the music to the stack in other for the "lastPlayed" functionality to work properly.
            try {
                System.out.println("Music{" + title + " by " + artist + " is now Playing." + '}');
                Thread.sleep((int) duration * 1000L); //convert seconds to milliseconds and pauses the program for a short while...
                System.out.println("Music{" + title + " by " + artist + " has finished Playing." + '}');
                musicQueue.remove();
                playing = false;
                run(); //Recursion to call this same method again
            } catch (InterruptedException ignored) {
            }
        } else if (musicQueue.isEmpty()) {
            System.out.println("There is currently no Music in the Queue.");
            playing = false;
            musicToBePlayed = null;
        } else {
            musicToBePlayed = null;
            System.out.println("A new track can't be played.");
        }
    }

    public void playMusic(Music music) {
        //plays a particular music
        try {
            System.out.println("Music{" + music.getTitle() + " by " + music.getArtist() + " is now Playing." + '}');
            if (!musicStack.isFull())
                musicStack.push(music); //add the music to the stack
            Thread.sleep((int) music.getDuration() * 1000L); //convert seconds to milliseconds and pause execution here...
            System.out.println("Music{" + music.getTitle() + " by " + music.getArtist() + " has finished Playing." + '}');
        } catch (InterruptedException ignored) {
        }
    }

    public void clearMusicQueue() { //clear the music queue
        musicQueue.clear(); //
    }

    public void lastPlayedTrack() { //to get the last played song
        if (!musicStack.isEmpty()) {
            Music music = musicStack.peek();//return the music at the top of the stack if it exists
            System.out.println(music + " is the last played track.");
        }
    }
}
