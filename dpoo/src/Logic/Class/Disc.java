package Logic.Class;

import java.util.ArrayList;

import Logic.Abstract.MusicalProduct;
import Logic.Enum.SolidDisc;
import Logic.Interface.MultimediaContent;

public class Disc extends MusicalProduct {
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
        this.setContent(content);
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

/*
* 
* -------------Methods---------------
* 
*/
    @Override
    public void print() {
        System.out.println("-----Disc-----");
        super.print();
        for (MultimediaContent m : content) {
            System.out.println("Content: ");
            m.print();
        }
    }

    public MultimediaContent searchContent(String title) {
        MultimediaContent m = null;

        for (int i = 0; i < content.size() && m == null; i++) {
            if (content.get(i).getTitle() == title) {
                m = content.get(i);
            }
        }

        return m;
    }

    public int searchContentPos(String title) {
        int pos = -1;

        for (int i = 0; i < content.size() && pos == -1; i++) {
            if (content.get(i).getTitle() == title) {
                pos = i;
            }
        }

        return pos;
    }

    public boolean addContent(MultimediaContent content) {
        boolean adding = false;
        MultimediaContent cont = this.searchContent(content.getTitle());

        if (cont == null) {
            adding = true;
            this.content.add(content);
        }

        return adding;
    }

    public MultimediaContent deleteContent(String title) {
        return content.remove(this.searchContentPos(title));
    }
}
