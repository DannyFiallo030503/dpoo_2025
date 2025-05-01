package Logic.Abstract;

import java.util.ArrayList;

import Logic.Utils;
import Logic.Class.Artist;
import Logic.Interface.MultimediaContent;

public abstract class MediaContentBase implements MultimediaContent {
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
        if (Utils.validarSoloLetras(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("The title contains numbers or strange characters.");
        }

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (Utils.validarSoloLetras(genre)) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("The genre contains numbers or strange characters.");
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (Utils.validarRangoInt(duration, 1, 30000)) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("The duration cannot be less than 1 nor greater than 30000");
        }

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
        if (Utils.validarRangoDouble(fileSize, 0.1, Double.MAX_VALUE)) {
            this.fileSize = fileSize;
        } else {
            throw new IllegalArgumentException("The file size cannot be less than 0.1 nor greater than 1 T.");
        }

    }

    /*
     * 
     * -------------Methods---------------
     * 
     */
    @Override
    public void print() {
        System.out.println("-----MediaContentBase-----");
        System.out.println("Title: " + title);
        System.out.println("Gener: " + genre);
        System.out.println("Duration: " + duration);
        System.out.println("Autor: ");
        author.print();
        System.out.println("Performer: ");
        performer.print();
        System.out.println("Colaborators: ");
        for (Artist a : collaborators) {
            System.out.println("-----Colaborator-----");
            a.print();
        }
        System.out.println("File Size: " + fileSize);
    }

    @Override
    public Artist searchColaborator(String name) {
        Artist artist = null;

        for (int i = 0; i < collaborators.size() && artist == null; i++) {
            if (collaborators.get(i).getName() == name) {
                artist = collaborators.get(i);
            }
        }

        return artist;
    }

    @Override
    public int searchColaboratorPos(String name) {
        int artist = -1;

        for (int i = 0; i < collaborators.size() && artist == -1; i++) {
            if (collaborators.get(i).getName() == name) {
                artist = i;
            }
        }

        return artist;
    }

    @Override
    public boolean addColaborator(String name, String bio) {
        boolean adding = false;
        Artist artist = this.searchColaborator(name);

        if (artist == null) {
            collaborators.add(new Artist(name, bio));
            adding = true;
        }

        return adding;
    }

    @Override
    public Artist deleteColaborator(String name) {
        return collaborators.remove(this.searchColaboratorPos(name));
    }

    @Override
    public double calculateSize() {
        return fileSize;
    }
}
