
package javaapplication1;

import java.awt.image.BufferedImage;



public class Karakter {
    
    BufferedImage resim;
    Lokasyon lokasyon = new Lokasyon();
    int can;
    
    public Karakter() {
        
    }
    
    public void djikstra(String[][] harita, Lokasyon karakterLokasyon) {
        hareketEt(1, harita);
    }
    
    public void basaDon() {
        lokasyon.x = 6;
        lokasyon.y = 5;
    }
    
    public int tamCanSayi() {
        return can;
    }
    
    public int yarimCanSayi() {
        return 0;
    }
    

    public void hareketEt(int yon, String[][] harita) {
        //sol 0
        //sağ 1
        //yukarı 2
        //aşağı 3
        if(yon == 0) {
            if(lokasyon.x != 0 && Integer.parseInt(harita[lokasyon.y][lokasyon.x-1]) != 0) {
                lokasyon.x--;
                OyunPenceresi.setSira(false);
            }
        }
        else if(yon == 1) {
            if(lokasyon.x != harita[0].length-1 && Integer.parseInt(harita[lokasyon.y][lokasyon.x+1]) != 0) {
                lokasyon.x++;
                OyunPenceresi.setSira(false);

            }
        }
        else if(yon == 2) {
            if(lokasyon.y != 0 && Integer.parseInt(harita[lokasyon.y-1][lokasyon.x]) != 0) {
                lokasyon.y--;
                OyunPenceresi.setSira(false);
            }
        }
        else {
            if(lokasyon.y != harita.length-1 && Integer.parseInt(harita[lokasyon.y+1][lokasyon.x]) != 0) {
                lokasyon.y++;
                OyunPenceresi.setSira(false);
            }
        }
    }

    
    
}
