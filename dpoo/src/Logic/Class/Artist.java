package Logic.Class;

public class Artist {
/*
* 
* -------------Attributes---------------
* 
*/
    private String name;
    private String bio;
    
/*
* 
* -------------Constructors---------------
* 
*/
    public Artist(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }
    
/*
* 
* -------------Gets and Sets---------------
* 
*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
}
