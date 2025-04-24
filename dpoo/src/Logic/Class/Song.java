package Logic.Class;

import java.util.ArrayList;

public class Song {
/*
* 
* -------------Attributes---------------
* 
*/
    private String title;
    private String genre;
    private int duration;
    private Artist author;
    private Artist performer;
    private ArrayList<Artist> collaborators;
    private Album album;
    private double fileSize;
    
/*
* 
* -------------Constructors---------------
* 
*/
    public Song(String title, String genre, int duration, Artist author, Artist performer,
            ArrayList<Artist> collaborators, Album album, double fileSize) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.author = author;
        this.performer = performer;
        this.collaborators = collaborators;
        this.album = album;
        this.fileSize = fileSize;
    }

/*
* 
* -------------Gets and Sets---------------
* 
*/
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public Artist getAuthor() {
        return author;
    }
    public void setAuthor(Artist author) {
        this.author = author;
    }
    public Artist getPerformer() {
        return performer;
    }
    public void setPerformer(Artist performer) {
        this.performer = performer;
    }
    public ArrayList<Artist> getCollaborators() {
        return collaborators;
    }
    public void setCollaborators(ArrayList<Artist> collaborators) {
        this.collaborators = collaborators;
    }
    public Album getAlbum() {
        return album;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
    public double getFileSize() {
        return fileSize;
    }
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

}
