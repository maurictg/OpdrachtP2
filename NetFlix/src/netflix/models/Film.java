package netflix.models;

public class Film extends Program{

    private int ageIndication;

    public Film(String title, int lengthInMinutes, int ageIndication){
        super(title, lengthInMinutes);
        this.ageIndication = ageIndication;
    }

}
