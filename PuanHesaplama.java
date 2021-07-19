
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PuanHesaplama {
    
    // Tahta üzerindeki taşları bir ArrayList'e ekler ve bu listeyi döndürür.
    public static ArrayList<String> tahtaBilgileri(String tahta){
        ArrayList<ArrayList> listeler = new ArrayList<ArrayList>();
        ArrayList<String> tahtaBilgi = new ArrayList<String>();
        try(Scanner scan = new Scanner(new BufferedReader(new FileReader(tahta)))){
            
            while(scan.hasNextLine()){
                String tahtaBilgisi = scan.nextLine();
                String[] bilgi = tahtaBilgisi.split(" ");
                for(int i=0;i<bilgi.length;i++){
                    tahtaBilgi.add(bilgi[i]);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Açılırken Bir Hata İle Karşılaşıldı.");
        }
        return tahtaBilgi;
    }
    // Gönderilen tahtadaki her bir renk taş için toplam puanları
    public static double tahtaPuanHesapla(ArrayList<String> tahta,String renk){
        double total = 0;
        for(int i=0;i<tahta.size();i++){
            if(tahta.get(i).startsWith("p")){
                if(tahta.get(i).endsWith("s")&& renk.equals("s"))
                    total+=1;
                if(tahta.get(i).endsWith("b")&& renk.equals("b"))
                    total+=1;
            }
            else if(tahta.get(i).startsWith("a")){
                if(tahta.get(i).endsWith("s")&& renk.equals("s"))
                    total+=3;
                if(tahta.get(i).endsWith("b")&& renk.equals("b"))
                    total+=3;
            }
            else if(tahta.get(i).startsWith("f")){
                if(tahta.get(i).endsWith("s")&& renk.equals("s"))
                    total+=3;
                if(tahta.get(i).endsWith("b")&& renk.equals("b"))
                    total+=3;
            }
            else if(tahta.get(i).startsWith("k")){
                if(tahta.get(i).endsWith("s")&& renk.equals("s"))
                    total+=5;
                if(tahta.get(i).endsWith("b")&& renk.equals("b"))
                    total+=5;
            }
            else if(tahta.get(i).startsWith("v")){
                if(tahta.get(i).endsWith("s")&& renk.equals("s"))
                    total+=9;
                if(tahta.get(i).endsWith("b")&& renk.equals("b"))
                    total+=9;
            }
            else if(tahta.get(i).startsWith("s")){
                if(tahta.get(i).endsWith("s")&& renk.equals("s"))
                    total+=100;
                if(tahta.get(i).endsWith("b")&& renk.equals("b"))
                    total+=100;
            }
            else
                total+=0;
        }
        return total;
    }
    /*
        bu metot tehdit renkteki taşların tehdit puanlarını hesaplar.
    */
    public static double tasTehditPuani(ArrayList<String> tahta,ArrayList<ArrayList> liste,String tehditRenk){
        double tehditPuan =0;
        for(int i=0;i<liste.size();i++){
            for(int j=0;j<liste.get(i).size();j++){
                int konum = (int) liste.get(i).get(j)-1;
                if(tahta.get(konum).equals("p"+tehditRenk))
                    tehditPuan+=0.5;
                else if(tahta.get(konum).equals("a"+tehditRenk))
                    tehditPuan+=1.5;
                else if(tahta.get(konum).equals("f"+tehditRenk))
                    tehditPuan+=1.5;
                else if(tahta.get(konum).equals("k"+tehditRenk))
                    tehditPuan+=2.5;
                else if(tahta.get(konum).equals("v"+tehditRenk))
                    tehditPuan+=4.5;
                else if(tahta.get(konum).equals("s"+tehditRenk))
                    tehditPuan+=50;
            }
        }
        return tehditPuan;
    }
    /*  List1 ve list2 karşılaştırılacak listeler
        List3 methodun döndürmesi istenen liste
        a_a metodu ile piyon-piyon ve at-at arasında (siyah ve beyaz renk için) 
        ortak tehdit ettikleri bir taş varsa bu taşı listeden çıkarır.
        b_b metodu ise piyon-at,piyon-vezir ve at-vezir arasıdna ortak tehdit
        ortak tehdit ettikleri bir taş varsa bu taşı listeden çıkarır.
    */
    public static ArrayList<ArrayList> a_a(ArrayList<ArrayList> list1){
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list1.get(i).size();j++){
                for(int a=i+1;a<list1.size();a++){
                    for(int b=0;b<list1.get(a).size();b++){
                        if(list1.get(i).get(j)==list1.get(a).get(b)){
                            list1.get(a).remove(list1.get(a).get(b));
                        }
                    }
                }
            }
        }
        return list1;
    }
    public static ArrayList<ArrayList> a_b(ArrayList<ArrayList> list1,ArrayList<ArrayList> list2,ArrayList<ArrayList> list3){
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list1.get(i).size();j++){
                for(int a=0;a<list2.size();a++){
                    for(int b=0;b<list2.get(a).size();b++){
                        if(list1.get(i).get(j)==list2.get(a).get(b)){
                            list2.get(a).remove(list2.get(a).get(b));
                        }
                    }
                }
            }
        }
        return list3;
    }
    // Tahta üzerindeki taşların siyah ve beyaz renge göre tehdit puanlarını hesaplar.
    public static double tehditHesapla(String tahtaNo,ArrayList<ArrayList> piyonKonum,ArrayList<ArrayList> atKonum,ArrayList<ArrayList> vezirKonum,String tasRenk, String tehditRenk){
        ArrayList<String> tahta = tahtaBilgileri(tahtaNo);
        ArrayList<ArrayList> piyon_Konum = new ArrayList<ArrayList>();
        ArrayList<ArrayList> at_Konum = new ArrayList<ArrayList>();
        ArrayList<ArrayList> vezir_Konum = new ArrayList<ArrayList>();
        double totalTahtaPuani = tahtaPuanHesapla(tahta, tehditRenk);
        double tehditPuan =0;
        piyon_Konum=a_a(piyonKonum);
        at_Konum=a_a(atKonum);
        at_Konum=a_b(piyonKonum, atKonum, atKonum);
        vezir_Konum = a_b(piyonKonum, vezirKonum, vezirKonum);
        vezir_Konum = a_b(atKonum, vezirKonum, vezirKonum);
        double puan1=tasTehditPuani(tahta, piyon_Konum, tehditRenk);
        double puan2=tasTehditPuani(tahta, at_Konum, tehditRenk);
        double puan3=tasTehditPuani(tahta, vezir_Konum,tehditRenk);
        return totalTahtaPuani-(puan1+puan2+puan3);
    }
}
