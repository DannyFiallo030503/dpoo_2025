package Logic.Class;

import java.util.ArrayList;

import Logic.Abstract.MediaContentBase;

public class VideoClip extends MediaContentBase {
/*
 * 
 * -------------Attributes---------------
 * 
 */
    private String resolution;
    
/*
 * 
 * -------------Constructors---------------
 * 
 */
public VideoClip(String title, String genre, int duration, Artist author, Artist performer,
        ArrayList<Artist> collaborators, double fileSize, String resolution) {
    super(title, genre, duration, author, performer, collaborators, fileSize);
    this.setResolution(resolution);
}

/*
 * 
 * -------------Gets and Sets---------------
 * 
 */

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    
/*
* 
* -------------Methods---------------
* 
*/
    @Override
    public double calculateSize() {
        return super.calculateSize();
    }

    @Override
    public void print() {
        super.print();
    }
}
