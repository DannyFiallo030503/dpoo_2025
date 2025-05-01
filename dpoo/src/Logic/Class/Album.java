package Logic.Class;

import java.util.ArrayList;

import Logic.Utils;

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
        if (Utils.validarSoloLetras(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("The title contains numbers or strange characters.");
        }
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

    public Song searchSong(String title) {
        Song song = null;

        for (int i = 0; i < songs.size() && song == null; i++) {
            if (songs.get(i).getTitle() == title) {
                song = songs.get(i);
            }
        }

        return song;
    }
    
    public int searchSongPos(String title) {
        int pos = -1;

        for (int i = 0; i < songs.size() && pos == -1; i++) {
            if (songs.get(i).getTitle() == title) {
                pos = i;
            }
        }

        return pos;
    }

    public boolean addSong(Song song) {
        boolean adding = false;
        Song s = this.searchSong(song.getTitle());

        if (s != null) {
            songs.add(song);
            adding = true;
        }

        return adding;
    }

    public Song deleteSong(String title) {
        return songs.remove(this.searchSongPos(title));
    }
    
    public double totalSize() {
        double totalSize = 0;

        for (Song s : songs) {
            totalSize += s.calculateSize();
        }

        return totalSize;
    }
}
