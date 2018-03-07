package animals.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Type implements Serializable{
    //attributes
    public String name;
    int approx_amount;
    String body_descrption;
    public List<Familly> famillyList;

    //default constructor
    public Type(){
        this.name="";
        this.approx_amount=0;
        this.body_descrption="";
        this.famillyList=new ArrayList<Familly>();
    }

    //parameter constructor
    public Type(String name,int approx_amount,String body_descrption){
        this.name=name;
        this.approx_amount=approx_amount;
        this.body_descrption=body_descrption;
        this.famillyList=new ArrayList<Familly>();
    }
    //methods
    public void setName(String name) {
        this.name = name;
    }

    public void setApprox_amount(int approx_amount) {
        this.approx_amount = approx_amount;
    }

    public void setBody_descrption(String body_descrption) {
        this.body_descrption = body_descrption;
    }

    public String getName() {
        return name;
    }

    public int getApprox_amount() {
        return approx_amount;
    }

    public String getBody_descrption() {
        return body_descrption;
    }

    public void addFamilly(Familly obj){
        famillyList.add(obj);
    }
}
