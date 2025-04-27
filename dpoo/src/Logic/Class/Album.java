package Logic.Class;

import java.util.ArrayList;

public class Album {
/*
* 
* -------------Attribute---------------
* 
*/
    private String title;
    private ArrayList<Song> songs;
    
/*
* 
* -------------Constructors---------------
* 
*/
    public Album(String title, ArrayList<Song> songs) {
        this.setTitle(title);
        this.setSongs(songs);
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
    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    
/*
* 
* -------------Methods---------------
* 
*/
}
