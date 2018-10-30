
package phones;


public class Phones {

  
    public static void main(String[] args) {
        device iPhone = new device();
        buildDevice(iPhone);
        iPhone.displayDevice();
        
        
    }
    public static void buildDevice(device d){
        
        d.setProcessor("Potato");
        d.setColor(new int[]{200, 122, 140});
        d.setHasCamera(true);
        d.setRam(512);
    }
    public static void displayInfo(device d){
        
    }
    
    
    
    
}
