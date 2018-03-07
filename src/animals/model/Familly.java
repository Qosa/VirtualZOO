package animals.model;

import java.util.ArrayList;
import java.util.List;

public class Familly extends Type{
    //attributes
    String familly_name;
    String characteristic_signs;
    int approxNrOfLimbs;
    public List<Genre> genreList;

    //default constructor
    public Familly(){
        this.familly_name="";
        this.characteristic_signs="";
        this.approxNrOfLimbs=0;
        this.genreList=new ArrayList<Genre>();

    }

    //parameter constructor
    public Familly(String familly_name,String characteristic_signs,int approxNrOfLimbs) {
        this.familly_name = familly_name;
        this.characteristic_signs = characteristic_signs;
        this.approxNrOfLimbs = approxNrOfLimbs;
        this.genreList=new ArrayList<Genre>();
    }

    //methods
    public void setFamilly_name(String familly_name) {
        this.familly_name = familly_name;
    }

    public void setCharacteristic_signs(String characteristic_signs) {
        this.characteristic_signs = characteristic_signs;
    }

    public void setApproxNrOfLimbs(int approxNrOfLimbs) {
        this.approxNrOfLimbs = approxNrOfLimbs;
    }

    public String getFamilly_name() {
        return familly_name;
    }

    public String getCharacteristic_signs() {
        return characteristic_signs;
    }

    public int getApproxNrOfLimbs() {
        return approxNrOfLimbs;
    }

    public void addGenre(Genre obj){
        genreList.add(obj);
    }
}
