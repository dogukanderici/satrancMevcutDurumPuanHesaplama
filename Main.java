
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends PuanHesaplama{
    public static void dosyaYaz(String deger,String dosyaAdi){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi,true))){
            writer.write(deger);
        } catch (IOException ex) {
            System.out.println("Veriler Dosyaya Yazılırken Bir Hata Oluştu.");
        }
    }
    public static void main(String[] args) {
        
        Ortak ortak;
        Ortak ortak2;
        Ortak ortak3;
        PuanHesaplama hesap;
        Scanner scan = new Scanner(System.in);
        String tahtaAdi="";
        ArrayList<String> tahtalar = new ArrayList<String>(
                Arrays.asList("board1.txt","board2.txt","board3.txt","board4.txt")
        );
        String islemler = "\n     SATRANÇ TEHDİT PUAN HESAPLAMA UYGULAMASI    \n"
                + "1. Bulunan Tahtaları Göster\n"
                + "2. Bulunan Tahtaların Puanını Hesapla\n"
                + "3. Yeni Tahta Ekle\n"
                + "4. Tahta Sil\n"
                + "q. Çıkış\n";
        System.out.println(islemler);
        String dosyaBasliklar = "Tahta Dosya Adı    Sonuçlar\n";
        //dosyaYaz(dosyaBasliklar);
        while(true){
            System.out.print("İşleminizi Giriniz: ");
            String islem = scan.nextLine();
            if(islem.equals("q") || islem.equals("Q")){
                System.out.println("Programdan Çıkılıyor.");
                break;
            }
            else if(islem.equals("1")){
                System.out.print("Görüntülemek istediğiniz tahta adı:");
                String islem2 = scan.nextLine();
                System.out.println("");
                try(Scanner scan2 = new Scanner(new BufferedReader(new FileReader(islem2)))){
                    while(scan2.hasNextLine()){
                        String tahtaBilgisi = scan2.nextLine();
                        System.out.println(tahtaBilgisi);
                    }
                    System.out.println("");
                } 
                catch (FileNotFoundException ex) {
                    System.out.println("Aradığınız dosya bulunamadı. Lütfen tekrar deneyiniz.");
                }
            }
            else if(islem.equals("2")){
                String yazi = "Tahta Dosya Adi         Sonuçlar\n";
                System.out.print(yazi);
                dosyaYaz(yazi,"sonuçlar.txt");
                
                for(String s:tahtalar){
                    ortak = new Piyon(s);
                    ortak2 = new At(s);
                    ortak3 = new Vezir(s);
                    //double puan_tehdit_edilen_renk=tehditHesapla("tahta numrası",tehdit_eden_piyon_rengi, tehdit_eden_at_rengi,tehdit_eden_vezir_rengi, tehdit_edilen_tas_rengi);
        
                    double puan_beyaz=tehditHesapla(s,ortak.tehditYonleri("ps"),ortak2.tehditYonleri("as"),ortak3.tehditYonleri("vs"),"s","b");
                    double puan_siyah=tehditHesapla(s,ortak.tehditYonleri("pb"),ortak2.tehditYonleri("ab"),ortak3.tehditYonleri("vb"),"b","s");
                    System.out.print(s+"        "
                        + "      Siyah: "+puan_siyah+"     "
                        + "      Beyaz: "+puan_beyaz+"\n");
                    String tumDegerler = s+"        "
                        + "      Siyah: "+puan_siyah+"     "
                        + "      Beyaz: "+puan_beyaz+"\n";
                    dosyaYaz(tumDegerler,"sonuçlar.txt");
                }
                System.out.println("Yazma işleni tamamlandı. Veriler sonuçlar.txt dosyasına kaydedildi.");
            }
            else if(islem.equals("3")){
                
                
                System.out.println("Lütfen dosya kaydederken kısaltmaları kullanınız.\n"
                        + "ps -> piyon siyah    pb -> piyon beyaz\n"
                        + "as -> at siyah       ab -> at beyaz\n"
                        + "fs -> fil siyah      fb -> fil beyaz\n"
                        + "ks -> kale siyah     kb -> kale beyaz\n"
                        + "vs -> vezir siyah    vb -> vezir beyaz\n"
                        + "ss -> şah siyah      sb -> şah beyaz\n"
                        + "-- = boş kare\n"
                        + "Kısaltmaları aralarında boşluk bırakarak ve 8x8 kare olacak şekilde doldurunuz.\n\n"
                        + "Lütfen kaydedeceiğiniz koya adını giriniz: ");
                String dosyaAdi = scan.nextLine();
                File dosya = new File(System.getProperty("user.dir")+"\\"+dosyaAdi);
                System.out.println(System.getProperty("user.dir")+"\\"+dosyaAdi);
                if(!dosya.exists()){
                    tahtalar.add(dosyaAdi);
                    for(int i=0;i<8;i++){
                        String veri = scan.nextLine();
                        dosyaYaz(veri+"\n",dosyaAdi);
                    }
                    System.out.println("Yazma işlemi Tamamlandı.");
                
                    System.out.println("Dosya Görüntülemek için lütfen '1' basınız.");
                }

                else{
                    System.out.println("Bu dosya zaten kayıtlı. Lütfen farklı bir dosya adı giriniz.");
                }
            }                
            else if(islem.equals("4")){
                    System.out.println("Silmek İstediğiniz Dosya Adı: ");
                    String klasor = scan.nextLine();
                    File dosya2 = new File(System.getProperty("user.dir")+"\\"+klasor);
                    if(dosya2.exists()){
                        System.out.println("Silmek İstiyor musunuz? (e/h) ");
                        String onay = scan.nextLine();
                        if(onay.equals("e") || onay.equals("E")){
                            dosya2.delete();
                            tahtalar.remove(klasor);
                            System.out.println("Dosya Silindi.");
                        }
                        else
                            continue;
                            
                    }
                    else
                        System.out.println("Dosya Bulunamadı.");
                }
            
            else{
                System.out.println("GEÇERSİZ İŞLEM GİRDİNİZ. LÜTFEN TEKRRA DENEYİNİZ.");
            }
        }
    }
}
