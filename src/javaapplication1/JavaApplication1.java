package javaapplication1;

import java.io.BufferedReader;
import java.io.File;     // dosya okunmasını sağlayan kütüphaneyi import eder.
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) {

        OyunPenceresi pen = new OyunPenceresi();

        File Dosya = new File("C:/Users/HP/Documents/NetBeansProjects/JavaApplication1/Harita.txt");

        String str = "";
        String a = null;
        String[][] Matris = new String[11][14];
        int Sayac = 0;
        try {
            FileReader DosyaOku = new FileReader(Dosya);

            BufferedReader b = new BufferedReader(DosyaOku);
            for (int i = 0; i < 3; i++) {
                str = b.readLine();
                if (str.contains("KyloRen")) {
                    if (str.contains("A")) {
                        pen.getKapiBilgi()[0] = "A";
                    } else if (str.contains("B")) {
                        pen.getKapiBilgi()[0] = "B";
                    } else if (str.contains("C")) {
                        pen.getKapiBilgi()[0] = "C";
                    } else if (str.contains("D")) {
                        pen.getKapiBilgi()[0] = "D";
                    } else if (str.contains("E")) {
                        pen.getKapiBilgi()[0] = "E";
                    }
                } else if (str.contains("DarthVader")) {
                    if (str.contains("A")) {
                        pen.getKapiBilgi()[1] = "A";
                    } else if (str.contains("B")) {
                        pen.getKapiBilgi()[1] = "B";
                    } else if (str.contains("C")) {
                        pen.getKapiBilgi()[1] = "C";
                    } else if (str.contains("D")) {
                        pen.getKapiBilgi()[1] = "D";
                    } else if (str.contains("E")) {
                        pen.getKapiBilgi()[1] = "E";
                    }
                } else {
                    if (str.contains("A")) {
                        pen.getKapiBilgi()[2] = "A";
                    } else if (str.contains("B")) {
                        pen.getKapiBilgi()[2] = "B";
                    } else if (str.contains("C")) {
                        pen.getKapiBilgi()[2] = "C";
                    } else if (str.contains("D")) {
                        pen.getKapiBilgi()[2] = "D";
                    } else if (str.contains("E")) {
                        pen.getKapiBilgi()[2] = "E";
                    }
                }
            }

            while ((str = b.readLine()) != null) {

                if (str.contains("0")) {
                    Matris[Sayac] = str.split("\t", 15);
                    Sayac++;
                }

            }

            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 14; j++) {
                    System.out.print(Matris[i][j]);

                }
                System.out.println();
            }
            b.close();
        } catch (IOException e) {
            System.out.println("Dosya okunamadı");
            e.printStackTrace();
        }
        //Matris Çizimi
        pen.setHarita(Matris);
        pen.repaint();

        //Karakter Seçimi
        Scanner scan = new Scanner(System.in);
        int karakterTur = 0;
        while (true) {
            System.out.println("1-)LukeSkywalker");
            System.out.println("2-)MasterYoda");
            System.out.println("Hangi karakter olmak istersiniz: ");
            karakterTur = scan.nextInt();
            if (karakterTur > 0 && karakterTur < 3) {
                break;
            }
            System.out.println("0 ile 2 arası seçilmeli");
        }
        pen.setKarakter(karakterTur == 1 ? new LukeSkywalker() : new MasterYoda());
        pen.getKarakter().basaDon();
        OyunPenceresi.setSira(false);

        //Dusman Seçimi
        int dusmanSayisi = 0;
        while (true) {
            System.out.println("Kotu karakter sayisi: ");
            dusmanSayisi = scan.nextInt();
            if (dusmanSayisi > 0 && dusmanSayisi < 4) {
                break;
            }
            System.out.println("1 ile 3 arası seçilmeli");
        }
        pen.setKotuler(new Karakter[dusmanSayisi]);
        for (int i = 0; i < dusmanSayisi; i++) {
            System.out.println("1-)KyloRen");
            System.out.println("2-)DarthVader");
            System.out.println("3-)Stromtrooper");
            System.out.println("Karakter Tipini Seçiniz: ");
            int kotuTip = scan.nextInt();
            while (true) {
                if (dusmanSayisi > 0 && dusmanSayisi < 4) {
                    if (kotuTip == 1) {
                        pen.getKotuler()[i] = new KyloRen();
                        pen.getKotuler()[i].lokasyon = new Lokasyon(pen.getKapiBilgi()[0]);
                    } else if (kotuTip == 2) {
                        pen.getKotuler()[i] = new DarthVader();
                        pen.getKotuler()[i].lokasyon = new Lokasyon(pen.getKapiBilgi()[1]);
                    } else {
                        pen.getKotuler()[i] = new Stormtrooper();
                        pen.getKotuler()[i].lokasyon = new Lokasyon(pen.getKapiBilgi()[2]);
                    }

                    break;
                }
                System.out.println("1 ile 3 arası seçilmeli");
            }
        }

        //Karakter çizimi
        pen.karakterleriYukle();
        pen.repaint();

        //Oyun Döngüsü
        boolean bitis = false;
        OyunPenceresi.setSira(true);
        while (true) {
            while(OyunPenceresi.getSira()) System.out.print("");
            
            for (int i = 0; i < pen.getKotuler().length; i++) {
                pen.getKotuler()[i].djikstra(pen.getHarita(), pen.getKarakter().lokasyon);
                if (pen.getKotuler()[i].lokasyon.x == pen.getKarakter().lokasyon.x
                        && pen.getKotuler()[i].lokasyon.y == pen.getKarakter().lokasyon.y) {
                    pen.getKarakter().can--;
                    pen.getKarakter().basaDon();
                    for (int j = 0; j < dusmanSayisi; j++) {
                        if (pen.getKotuler()[j] instanceof KyloRen) {
                            pen.getKotuler()[j].lokasyon = new Lokasyon(pen.getKapiBilgi()[0]);
                        } else if (pen.getKotuler()[j] instanceof DarthVader) {
                            pen.getKotuler()[j].lokasyon = new Lokasyon(pen.getKapiBilgi()[1]);
                        } else {
                            pen.getKotuler()[j].lokasyon = new Lokasyon(pen.getKapiBilgi()[2]);
                        }
                    }
                }
            }
            if(pen.getKarakter().lokasyon.x ==13 && pen.getKarakter().lokasyon.y ==9) {
                bitis = true;
                break;
            }
            if (pen.getKarakter().can == 0) {
                bitis = false;
                break;
            }
            
            OyunPenceresi.setSira(true);
        }

        OyunPenceresi.setSira(false);
        if (bitis) {
            System.out.println("Oyunu kazandınız");
        } else {
            System.out.println("Kaybettiniz");
        }

    }
}
