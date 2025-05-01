package Logic.Class;

import Logic.Utils;

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
        this.setName(name);
        this.setBio(bio);
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
        if (Utils.validarSoloLetras(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("The name contains numbers or strange characters.");
        } 
    }
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        if (Utils.validarLetrasCaracteresPermitidos(bio)) {
            this.bio = bio;
        } else {
            throw new IllegalArgumentException("The bio contains numbers or strange characters.");
        }
    }
    
/*
* 
* -------------Methods---------------
* 
*/

    public void print() {
        System.out.println("-----Artist-----");
        System.out.println("Name: " + name);
        System.out.println("Bio: " + bio);    
    }
}
