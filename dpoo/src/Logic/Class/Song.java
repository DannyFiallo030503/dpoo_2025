package Logic.Class;

import java.util.ArrayList;

import Logic.Abstract.MediaContentBase;

public class Song extends MediaContentBase {
/*
* 
* -------------Attributes---------------
* 
*/
    private Album album;

/*
* 
* -------------Constructors---------------
* 
*/
public Song(String title, String genre, int duration, Artist author, Artist performer,
        ArrayList<Artist> collaborators, double fileSize, Album album) {
    super(title, genre, duration, author, performer, collaborators, fileSize);
    this.setAlbum(album);
}
    
/*
* 
* -------------Gets and Sets---------------
* 
*/
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
/*
* 
* -------------Methods---------------
* 
*/
    @Override
    public double calculateSize() {
        return album.totalSize();
    }

    @Override
    public void print() {
        super.print();
    }

    public boolean isSongOfSameAlbum(Song song) {
        boolean isSOSA = false;
        Song s = album.searchSong(song.getTitle());

        if (s != null) {
            isSOSA = true;
        }

        return isSOSA;
    }
    
}
