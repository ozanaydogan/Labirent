package javaapplication1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class OyunPenceresi extends JFrame implements KeyListener {

    private String[] kapiBilgi = new String[3];
    private String[][] harita;
    private Karakter karakter;
    private Karakter kotuler[];
    BufferedImage tamCan;
    BufferedImage yarimCan;
    BufferedImage kupa;
    private static boolean sira = false;

    public OyunPenceresi() {

        setSize(900, 700);
        setResizable(false);
        setVisible(true);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void karakterleriYukle() {
        
        try {
            //karakter resim yükleme
            tamCan = ImageIO.read(new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/TamCan.jpg"));
            yarimCan = ImageIO.read(new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/YarimCan.jpg"));
            kupa = ImageIO.read(new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/kupa.png"));
            if( karakter instanceof MasterYoda ) {
                karakter.resim = ImageIO.read(new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/masteryoda.jpg"));
            }
            else {
                karakter.resim = ImageIO.read(new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/lukeskywalker.jpg"));
            }
            
            //duşman resim yükleme
            for(int i=0; i<kotuler.length; i++) {
                if( kotuler[i] instanceof KyloRen ) {
                    kotuler[i].resim = ImageIO.read(new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/kyloren.jpg"));
                }
                else if( kotuler[i] instanceof DarthVader) {
                    kotuler[i].resim = ImageIO.read(new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/darthvader.jpg"));
                }
                else {
                    kotuler[i].resim = ImageIO.read(new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/stormtrooper.jpg"));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Resim yükleme hatası");
        }
    }
    public void setKapiBilgi(String[] kapiBilgi) {
        this.kapiBilgi =kapiBilgi ;
    }
    
    public String[] getKapiBilgi() {
        return kapiBilgi;
    }

    public void setHarita(String[][] harita) {
        this.harita = harita;
    }
    
    public String[][] getHarita() {
        return harita;
    }

    public Karakter getKarakter() {
        return karakter;
    }

    public void setKarakter(Karakter karakter) {
        this.karakter = karakter;
    }

    public Karakter[] getKotuler() {
        return kotuler;
    }

    public void setKotuler(Karakter[] kotuler) {
        this.kotuler = kotuler;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 100; i < 700; i = i + 50) {
            g.drawLine(100, i, 800, i);

        }

        for (int i = 100; i < 850; i = i + 50) {
            g.drawLine(i, 100, i, 650);

        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 14; j++) {

                if (harita[i][j].equals("0")) {
                    g.fillRect(100 + ((j) * 50), 100 + ((i) * 50), 50, 50);
                }
            }

        }
        g.setColor(Color.yellow);
        g.fillRect(100+ (6 * 50), 100 + (5 *50) , 50, 50);
        g.fillRect(100+ (13 * 50), 100 + (9 *50) , 50, 50);
        g.drawImage(kupa, 100+ (14 * 50), 100 + (9 *50), null);
        
     karakterleriCiz(g);
    }
    
    public void karakterleriCiz(Graphics g) {
        
        if(karakter == null)
            return ;
        if(kotuler == null)
            return ;
        
        karakter.lokasyon.donustur();
        g.drawImage(karakter.resim, karakter.lokasyon.coordX, karakter.lokasyon.coordY, null);
        
        //Can çiz
        int tamCanSayi = karakter.tamCanSayi();
        int yarimCanSayi = karakter.yarimCanSayi();
        int canCoordX = this.getWidth()-160;
        for(int i=0; i<tamCanSayi; i++) {
            g.drawImage(tamCan, canCoordX, 50, null);
            canCoordX += 40;
        }
        for(int i=0; i<yarimCanSayi; i++) {
            g.drawImage(yarimCan, canCoordX, 50, null);
            canCoordX += 40;
        }
        
        for(int i=0;i<kotuler.length;i++)
        {
            if(kotuler[i] == null) return;
            kotuler[i].lokasyon.donustur();
            g.drawImage(kotuler[i].resim, kotuler[i].lokasyon.coordX, kotuler[i].lokasyon.coordY, null);
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(sira == false) return;
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            karakter.hareketEt(0, this.harita);
           
        } else if (key == KeyEvent.VK_RIGHT) {
            karakter.hareketEt(1, this.harita);
             
        } else if (key == KeyEvent.VK_UP) {
            karakter.hareketEt(2, this.harita);
             
        } else if (key == KeyEvent.VK_DOWN) {
            karakter.hareketEt(3, this.harita);
             
        }
        repaint();
    }

    public static boolean getSira() {
        return sira;
    }

    public static void setSira(boolean sira) {
        OyunPenceresi.sira = sira;
    }

}
