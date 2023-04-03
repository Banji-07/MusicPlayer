package model;

public class Music {
    private final String title;
    private final String artist;
    private final String album;
    private final float duration;
    private final Genre genre;
    private final int yearOfRelease;

    public Music(String title, String artist, String album, float duration, Genre genre, int yearOfRelease) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public float getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    @Override
    public String toString() {
        return "Music{" +
                title +
                " by " + artist +
                '}';
    }
}