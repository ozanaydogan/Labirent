/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

public class DarthVader extends Karakter {

    public DarthVader() {

    }
    
    public void djikstra(String[][] harita, Lokasyon karakterLokasyon) {
        hareketEt(1, harita);
    }

    public void hareketEt(int yon, String[][] harita) {
        //sol 0
        //sağ 1
        //yukarı 2
        //aşağı 3
        if (yon == 0) {
            if (lokasyon.x != 0) {
                lokasyon.x--;
                OyunPenceresi.setSira(false);
            }
        } else if (yon == 1) {
            if (lokasyon.x != harita[0].length - 1) {
                lokasyon.x++;
                OyunPenceresi.setSira(false);

            }
        } else if (yon == 2) {
            if (lokasyon.y != 0) {
                lokasyon.y--;
                OyunPenceresi.setSira(false);
            }
        } else {
            if (lokasyon.y != harita.length - 1) {
                lokasyon.y++;
                OyunPenceresi.setSira(false);
            }
        }
    }

}
