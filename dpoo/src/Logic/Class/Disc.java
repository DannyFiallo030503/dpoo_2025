package Logic.Class;

import java.util.ArrayList;

import Logic.Abstract.MusicalProduct;
import Logic.Enum.SolidDisc;
import Logic.Interface.MultimediaContent;

public class Disc extends MusicalProduct{
/*
* 
* -------------Attributes---------------
* 
*/
    private ArrayList<MultimediaContent> content;
    
/*
* 
* -------------Constructors---------------
* 
*/
    public Disc(double price, SolidDisc mediaType, ArrayList<MultimediaContent> content) {
        super(price, mediaType);
        this.content = content;
    }
/*
* 
* -------------Gets and Sets---------------
* 
*/
    public ArrayList<MultimediaContent> getContent() {
        return content;
    }

    public void setContent(ArrayList<MultimediaContent> content) {
        this.content = content;
    }
}
