package Logic.Abstract;

import Logic.Enum.SolidDisc;

public abstract class MusicalProduct {
/*
* 
* -------------Attributes---------------
* 
*/
    protected double price;
    protected SolidDisc mediaType;
    
/*
* 
* -------------Constructures---------------
* 
*/
    public MusicalProduct(double price, SolidDisc mediaType) {
        this.price = price;
        this.mediaType = mediaType;
    }
    
/*
* 
* -------------Gets and Sets---------------
* 
*/
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public SolidDisc getMediaType() {
        return mediaType;
    }
    public void setMediaType(SolidDisc mediaType) {
        this.mediaType = mediaType;
    }
}
