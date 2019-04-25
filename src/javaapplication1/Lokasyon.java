
package javaapplication1;

public class Lokasyon {
    int x,y;
    int coordX, coordY;
    int genislik = 50;
    
    public Lokasyon() {
        x=0;
        y=0;
    }
    
    public Lokasyon(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Lokasyon(String kapi) {
        if(kapi.equals("A"))
        {
            this.x=0;
            this.y=5;
            
        }
        else if(kapi.equals("B"))
        {
            
            this.x=4;
            this.y=0;
        }
        else if(kapi.equals("C"))
        {
            this.x=12;
            this.y=0;
        }
        
        else if(kapi.equals("D"))
        {
            this.x=13;
            this.y=5;
        }
        else if(kapi.equals("E"))
        {
            this.x=4;
            this.y=10;
        }
        
    }
    
    public void donustur() {
        coordX = x*50 + 100;
        coordY = y*50 + 100;
    }
}
