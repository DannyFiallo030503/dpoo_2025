package Logic.Abstract;

import Logic.Utils;
import Logic.Enum.SolidDisc;
import Logic.Interface.PricingStrategy;

public abstract class MusicalProduct implements PricingStrategy {
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
        this.setPrice(price);
        this.setMediaType(mediaType);
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
        if (Utils.validarRangoDouble(price, 1, 10000)) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("The minimum price must be 1 and the maximum is around 10,000.");
        }
        
    }
    public SolidDisc getMediaType() {
        return mediaType;
    }

    public void setMediaType(SolidDisc mediaType) {
        this.mediaType = mediaType;
    }

/*
* 
* -------------Methods---------------
* 
*/
    @Override
    public double calculatePrice() {
        return price;
    }

    public void print() {
        System.out.println("Price: " + this.price);
        System.out.println("Media Type: " + this.mediaType);
    }

}
