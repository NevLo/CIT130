package phones;

public class device {
    
    private String processor;
    private int[] color;
    private boolean hasCamera;
    private int ram;
    
    public void displayDevice(){
        System.out.println("Processor: " + processor);
        System.out.println("Color: " + color[0] + ", "  + color[1] + ", " + color[2]);
        System.out.println("Camera?: " + hasCamera);
        System.out.println("Ram: " + ram + "MBs");
      
    }
    
    
    public void setProcessor(String s){
        this.processor = s;
    }
    public void setColor(int[] c){
        if(c[0] > 255 || c[1] > 255 || c[2] > 255){
            System.out.println("INVALID COLOR");
        }else{
            color = c;
        }
    }
    public void setHasCamera(boolean t){
        hasCamera = t;
    }
    public void setRam(int r){
        ram = r;
    }
    
    public String getProcessor(){
        return processor;
    }
    public int[] getColor(){
        return color;
    }
    public boolean getHasCamera(){
        return hasCamera;
    }
    public int getRam(){
        return ram;
    }
    
    
    
}
