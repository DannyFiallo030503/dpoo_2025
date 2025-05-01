package Logic.Interface;

import Logic.Class.Artist;

public interface MultimediaContent {
    double calculateSize();
    void print();
    int searchColaboratorPos(String name);
    boolean addColaborator(String name, String bio);
    Artist deleteColaborator(String name);
    Artist searchColaborator(String name);
    String getTitle();
}
