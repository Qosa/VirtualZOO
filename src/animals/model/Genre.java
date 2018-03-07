package animals.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Genre extends Familly {
    //attributes
    Type TypeTest;
    String genreName;
    String dateOfDiscover;
    int nrOfLimbs;
    String nameOfFamousOne;
    File imagePath;

    //default constructor
    public Genre(){
        this.genreName="";
        this.dateOfDiscover="";
        this.nrOfLimbs=0;
        this.nameOfFamousOne="";
    }
    //parameter constructor
    public Genre(String genreName,String dateOfDiscover,int nrOfLimbs,String nameOfFamousOne, File imagePath) {
        this.genreName=genreName;
        this.dateOfDiscover=dateOfDiscover;
        this.nrOfLimbs=nrOfLimbs;
        this.nameOfFamousOne=nameOfFamousOne;
        this.imagePath=imagePath;
    }

    //methods
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void setDateOfDiscover(String dateOfDiscover) {
        this.dateOfDiscover = dateOfDiscover;
    }

    public void setNrOfLimbs(int nrOfLimbs) {
        this.nrOfLimbs = nrOfLimbs;
    }

    public void setNameOfFamousOne(String nameOfFamousOne) {
        this.nameOfFamousOne = nameOfFamousOne;
    }

    public void setImagePath(File imagePath) {
        this.imagePath = imagePath;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getDateOfDiscover() {
        return dateOfDiscover;
    }

    public int getNrOfLimbs() {
        return nrOfLimbs;
    }

    public String getNameOfFamousOne() {
        return nameOfFamousOne;
    }

    public File getImagePath() {
        return imagePath;
    }
}
