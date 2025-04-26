package Logic.Abstract;

import java.util.ArrayList;

import Logic.Class.Artist;
import Logic.Interface.MultimediaContent;

public abstract class MediaContentBase implements MultimediaContent{
/*
* 
* -------------Attributes---------------
* 
*/
    protected String title;
    protected String genre;
    protected int duration;
    protected Artist author;
    protected Artist performer;
    protected ArrayList<Artist> collaborators;
    protected double fileSize;

/*
* 
* -------------Constructors---------------
* 
*/
    public MediaContentBase(String title, String genre, int duration, Artist author, Artist performer,
            ArrayList<Artist> collaborators, double fileSize) {
        this.setTitle(title);
        this.setGenre(genre);
        this.setDuration(duration);
        this.setAuthor(author);
        this.setPerformer(performer);
        this.setCollaborators(collaborators);
        this.setFileSize(fileSize);
    }

/*
* 
* -------------Gets and seters---------------
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
    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }
    
/*
* 
* -------------Methods---------------
* 
*/

}
