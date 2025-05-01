package Logic.Class;

import java.util.ArrayList;

import Logic.Utils;
import Logic.Enum.SolidDisc;
import Logic.Interface.MultimediaContent;
import Logic.Interface.PricingStrategy;

public class RecordingService implements PricingStrategy {
/*
* 
* -------------Attributes---------------
* 
*/
    private double baseCost;
    private SolidDisc recordingMedia;
    private ArrayList<MultimediaContent> content; 

/*
* 
* -------------Constructors---------------
* 
*/
    public RecordingService(double baseCost) {
        this.setBaseCost(baseCost);
    }
    
    public RecordingService(double baseCost, SolidDisc reSolidDisc, ArrayList<MultimediaContent> content) {
        this.setBaseCost(baseCost);
        this.setRecordingMedia(reSolidDisc);
        this.setContent(content);
    }

/*
* 
* -------------Gets and Sets---------------
* 
*/
    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        if (Utils.validarRangoDouble(baseCost, 1, 10000)) {
            this.baseCost = baseCost;
        } else {
            throw new IllegalArgumentException();
        }
        
    }
    public double getDataCostPerGB() {
        double dataCostPerGB = 0;

        if (recordingMedia == SolidDisc.CD) {
            dataCostPerGB = 10;
        } else if (recordingMedia == SolidDisc.DVD) {
            dataCostPerGB = 20;
        }

        return dataCostPerGB;
    }

    public double getDataSizeGB() {
        return this.calculateSize();
    }
    
    public SolidDisc getRecordingMedia() {
        return recordingMedia;
    }

    public void setRecordingMedia(SolidDisc recordingMedia) {
        this.recordingMedia = recordingMedia;
    }

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
    public void print() {
            
    }

    public double calculateSize() {
        double total = 0;

        for (MultimediaContent m : content) {
            total += m.calculateSize();
        }

        return total;
    }

    @Override
    public double calculatePrice() {
        return this.getBaseCost() + (content.size() * 2) + (this.calculateSize() * this.getDataCostPerGB());
    }
}
