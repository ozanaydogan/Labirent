/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author HP
 */
public class KyloRen extends Karakter {

    public KyloRen() {

    }

    public void djikstra(String[][] harita, Lokasyon karakterLokasyon) {
        hareketEt(1, harita);
        hareketEt(3, harita);
    }
}
