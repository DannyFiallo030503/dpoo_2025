package Logic.Class;

public class RecordingService {
/*
* 
* -------------Attributes---------------
* 
*/
    private double baseCost;
    private double dataCostPerGB;
    private double dataSizeGB;

/*
* 
* -------------Constructors---------------
* 
*/
    public RecordingService(double baseCost, double dataCostPerGB, double dataSizeGB) {
        this.setBaseCost(baseCost);
        this.setDataCostPerGB(dataCostPerGB);
        this.setDataSizeGB(dataSizeGB);
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
        this.baseCost = baseCost;
    }
    public double getDataCostPerGB() {
        return dataCostPerGB;
    }
    public void setDataCostPerGB(double dataCostPerGB) {
        this.dataCostPerGB = dataCostPerGB;
    }
    public double getDataSizeGB() {
        return dataSizeGB;
    }

    public void setDataSizeGB(double dataSizeGB) {
        this.dataSizeGB = dataSizeGB;
    }
    
/*
* 
* -------------Methods---------------
* 
*/
}
