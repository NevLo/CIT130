
package arraytest1;

public class Auto {

    private String model;
    
    public Auto(){
        
    }
    public Auto(String model){
        this.model = model;
    }
    @Override
    public String toString(){
        return "";
    }

    public String getModel() {
       return model;
    }
    public void setModel(String model){
        this.model = model;
    }
}
