package Logic.Class;

public class VideoClip {
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

    public VideoClip(String resolution) {
        this.resolution = resolution;
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
}
