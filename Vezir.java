
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vezir extends Ortak{

    public Vezir(String tahta) {
        super(tahta);
    }
    /*
        tehditYonleri fonksiyonu ile vezirin bulunduğu konuma göre hareket
        edebilecği tüm karelerin bilgisi (4a,5g,8e, vb.) bulunur
    */
    @Override
    ArrayList tehditYonleri(String tasRenk){
        int k=7;
        String[] array1 = {"1","2","3","4","5","6","7","8"}; //k
        String[] array2 = {"a","b","c","d","e","f","g","h"}; //i
        
        ArrayList<String> sag_ust = new ArrayList<String>();
        ArrayList<String> yukari = new ArrayList<String>();
        ArrayList<String> sol_ust = new ArrayList<String>();
        ArrayList<String> sag_alt = new ArrayList<String>();
        ArrayList<String> sol_alt = new ArrayList<String>();
        ArrayList<String> asagi = new ArrayList<String>();
        ArrayList<String> sag = new ArrayList<String>();
        ArrayList<String> sol = new ArrayList<String>();
        ArrayList<ArrayList> yonler = new ArrayList<ArrayList>();
        
        ArrayList<String> sag_ust_s = new ArrayList<String>();
        ArrayList<String> yukari_s = new ArrayList<String>();
        ArrayList<String> sol_ust_s = new ArrayList<String>();
        ArrayList<String> sag_alt_s = new ArrayList<String>();
        ArrayList<String> sol_alt_s = new ArrayList<String>();
        ArrayList<String> asagi_s = new ArrayList<String>();
        ArrayList<String> sag_s = new ArrayList<String>();
        ArrayList<String> sol_s = new ArrayList<String>();
        
        ArrayList<String> bilgiler2 = new ArrayList<String>();
        String[] bilgiler={};
        
        try(Scanner scan = new Scanner(new FileReader(getTahta()))){
            while(scan.hasNextLine()){
                String bilgi = scan.nextLine();
                bilgiler = bilgi.split(" ");
                for(int i=0;i<bilgiler.length;i++){
                    bilgiler2.add(array1[k]+array2[i]+"-"+bilgiler[i]);
                    if(bilgiler[i].startsWith(tasRenk)){
                        // Sag Ust Capraz
                        if(!((k==7)||(i==7))){
                            int k2=k;
                            int i2=i;
                            if(tasRenk.equals("vb")){
                                while(!(k2==7 || i2==7)){
                                    sag_ust.add(array1[k2+1]+array2[i2+1]);
                                    k2++;
                                    i2++;
                                }
                            }
                            if(tasRenk.equals("vs")){
                                while(!(k2==7 || i2==7)){
                                    sag_ust_s.add(array1[k2+1]+array2[i2+1]);
                                    k2++;
                                    i2++;
                                }
                            }
                        }
                        // Sol Ust Capraz
                        if(!((k==7)||i==0)){
                            int k2=k;
                            int i2=i;
                            if(tasRenk.equals("vb")){
                            while(!(k2==7 || i2==0)){
                                sol_ust.add(array1[k2+1]+array2[i2-1]);
                                k2++;
                                i2--;
                            }
                            }
                            if(tasRenk.equals("vs")){
                            while(!(k2==7 || i2==0)){
                                sol_ust_s.add(array1[k2+1]+array2[i2-1]);
                                k2++;
                                i2--;
                            }
                            }
                        }
                        // Sag Alt Capraz
                        if(!((i==7)||(k==0))){
                            int k2=k;
                            int i2=i;
                            if(tasRenk.equals("vb")){
                            while(!(k2==0 || i2==7)){
                                sag_alt.add(array1[k2-1]+array2[i2+1]);
                                k2--;
                                i2++;
                            }
                            }
                            if(tasRenk.equals("vs")){
                            while(!(k2==0 || i2==7)){
                                sag_alt_s.add(array1[k2-1]+array2[i2+1]);
                                k2--;
                                i2++;
                            }
                            }
                        }
                        // Sol Alt Capraz
                        if(!((i==0)||k==0)){
                            int k2=k;
                            int i2=i;
                            if(tasRenk.equals("vb")){
                            while(!(k2==0 || i2==0)){
                                sol_alt.add(array1[k2-1]+array2[i2-1]);
                                k2--;
                                i2--;
                            }
                            }
                            if(tasRenk.equals("vs")){
                            while(!(k2==0 || i2==0)){
                                sol_alt_s.add(array1[k2-1]+array2[i2-1]);
                                k2--;
                                i2--;
                            }
                            }
                        }
                        // Yukari
                        if(k!=7){
                            int k2=k;
                            if(tasRenk.equals("vb")){
                            while(!(k2==7)){
                                yukari.add(array1[k2+1]+array2[i]);
                                k2++;
                            }
                            }
                            if(tasRenk.equals("vs")){
                            while(!(k2==7)){
                                yukari_s.add(array1[k2+1]+array2[i]);
                                k2++;
                            }
                            }
                        }
                        // Asagi
                        if(k!=0){
                            int k2=k;
                            if(tasRenk.equals("vb")){
                            while(k2!=0){
                                asagi.add(array1[k2-1]+array2[i]);
                                k2--;
                            }
                            }
                            
                            if(tasRenk.equals("vs")){
                            while(k2!=0){
                                asagi_s.add(array1[k2-1]+array2[i]);
                                k2--;
                            }
                            }
                        }
                        // Sag
                        if(i!=7){
                            int i2=i;
                            if(tasRenk.equals("vb")){
                            while(i2!=7){
                                sag.add(array1[k]+array2[i2+1]);
                                i2++;
                            }
                            }
                            if(tasRenk.equals("vs")){
                            while(i2!=7){
                                sag_s.add(array1[k]+array2[i2+1]);
                                i2++;
                            }
                            }
                        }
                        // Sol
                        if(i!=0){
                            int i2=i;
                            if(tasRenk.equals("vb")){
                            while(i2!=0){
                                sol.add(array1[k]+array2[i2-1]);
                                i2--;
                            }
                            }
                            if(tasRenk.equals("vs")){
                            while(i2!=0){
                                sol_s.add(array1[k]+array2[i2-1]);
                                i2--;
                            }
                            }
                        }
                    }
                }
                k--;
            }
            /*
                vezirin siyah veya beyaz olması duruma göre hareket edileceğii tüm 
                kareler için tehdit ettiği bir taşın olup olmadığını eğer varsa
                bu taşın tahtadaki konumunun alınması için hesapla fonksiyonuna
                içerisindeki verileri gönderir.
            */
            if(tasRenk.equals("vb")){
                yonler.add(hesapla(bilgiler2, sag_ust,"b","s"));
                yonler.add(hesapla(bilgiler2, sol_ust,"b","s"));
                yonler.add(VezirAsagiYon(bilgiler2, sag_alt,"s"));
                yonler.add(hesapla(bilgiler2, sol_alt,"b","s"));
                yonler.add(hesapla(bilgiler2, yukari,"b","s"));
                yonler.add(VezirAsagiYon(bilgiler2, asagi,"s"));
                yonler.add(VezirAsagiYon(bilgiler2, sag,"s"));
                yonler.add(VezirAsagiYon(bilgiler2, sol,"s"));
            }
            if(tasRenk.equals("vs")){
                yonler.add(VezirAsagiYon(bilgiler2, sag_ust_s,"b"));
                yonler.add(hesapla(bilgiler2, sol_ust_s,"s","b"));
                yonler.add(VezirAsagiYon(bilgiler2, sag_alt_s,"b"));
                yonler.add(VezirAsagiYon(bilgiler2, sol_alt_s,"b"));
                yonler.add(hesapla(bilgiler2, yukari_s,"s","b"));
                yonler.add(VezirAsagiYon(bilgiler2, asagi_s,"b"));
                yonler.add(VezirAsagiYon(bilgiler2, sag_s,"b"));
                yonler.add(VezirAsagiYon(bilgiler2, sol_s,"b"));
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya Açılırken bir hata oluştu.");
        }
        return yonler;
    }
    /* 
        VezirAsagiYon metodu tahtaya göre vezirin aşağı yönde gidebileceği
        kareleri bulan metottur. 
    */
    @Override
    ArrayList VezirAsagiYon(ArrayList<String> bilgiler2,ArrayList<String> arrayList_Sag,String tehditRenk) {
        String tas="";
        ArrayList<Integer> konum = new ArrayList<Integer>();
        ArrayList<Integer> tasKonum = new ArrayList<Integer>();
        for(int i=0;i<bilgiler2.size();i++){
            for(int j=0;j<arrayList_Sag.size();j++){
                if(bilgiler2.get(i).startsWith(arrayList_Sag.get(j))){
                        konum.add(bilgiler2.indexOf(bilgiler2.get(i))+1);
                }
            }
        }  
        if(tehditRenk.equals("b")){
            int i=0;
            while(i<arrayList_Sag.size()){
                if(bilgiler2.get(konum.get(i)-1).endsWith("s")){
                    break;
                }
                else if(bilgiler2.get(konum.get(i)-1).endsWith("--"))
                    i++;
                else if(bilgiler2.get(konum.get(i)-1).endsWith("b")){
                    tas = bilgiler2.get(konum.get(i)-1);
                    break;
                }
            }
        }
        if(tehditRenk.equals("s")){
            int i=0;
            while(i<arrayList_Sag.size()){
                if(bilgiler2.get(konum.get(i)-1).endsWith("s")){
                    tas = bilgiler2.get(konum.get(i)-1);
                    break;
                }
                else if(bilgiler2.get(konum.get(i)-1).endsWith("--"))
                    i++;
                else if(bilgiler2.get(konum.get(i)-1).endsWith("b"))
                    break;
        }
        }
        double tehditPuan=0.0;
        for(int j=0;j<bilgiler2.size();j++){
            if(bilgiler2.get(j).startsWith(tas) && tas!=""){
                if(bilgiler2.get(j).endsWith("p"+tehditRenk))
                    tasKonum.add(bilgiler2.indexOf(bilgiler2.get(j))+1);
                if(bilgiler2.get(j).endsWith("a"+tehditRenk))
                    tasKonum.add(bilgiler2.indexOf(bilgiler2.get(j))+1);
                if(bilgiler2.get(j).endsWith("f"+tehditRenk))
                    tasKonum.add(bilgiler2.indexOf(bilgiler2.get(j))+1);
                if(bilgiler2.get(j).endsWith("k"+tehditRenk))
                    tasKonum.add(bilgiler2.indexOf(bilgiler2.get(j))+1);               
                if(bilgiler2.get(j).endsWith("v"+tehditRenk))
                    tasKonum.add(bilgiler2.indexOf(bilgiler2.get(j))+1);               
                if(bilgiler2.get(j).endsWith("s"+tehditRenk))
                    tasKonum.add(bilgiler2.indexOf(bilgiler2.get(j))+1);
            }
        }
        return tasKonum;
    }
    public static String vezirHesapla(ArrayList<String> bilgiler2, ArrayList<String> arrayList_1,String tehditRenk){
        /*
        arrayList1->Vezirin gidebileceği yönlerden birini listesi
        tehditRenk-> Vezirin tehdit edeceği taş rengi(siyah veya beyaz)
        vezirRengi-> İşlem yapılmış vezirin rengi
        */
        String tas="";
        ArrayList<Integer> konum = new ArrayList<Integer>();
        for(int i=0;i<bilgiler2.size();i++){
            for(int j=0;j<arrayList_1.size();j++){
                if(bilgiler2.get(i).startsWith(arrayList_1.get(j))){
                        konum.add(bilgiler2.indexOf(bilgiler2.get(i))+1);
                }
            }
        }
        if(tehditRenk.equals("b")){
            int i=arrayList_1.size()-1;
            while(i>=0){
                if(bilgiler2.get(konum.get(i)-1).endsWith("s")){
                    break;
                }
                else if(bilgiler2.get(konum.get(i)-1).endsWith("--"))
                    i--;
                else if(bilgiler2.get(konum.get(i)-1).endsWith("b")){
                    tas = bilgiler2.get(konum.get(i)-1);
                    break;
                }
            }
        }
        if(tehditRenk.equals("s")){
            int i=arrayList_1.size()-1;
            while(i>=0){
                if(bilgiler2.get(konum.get(i)-1).endsWith("s")){
                    tas = bilgiler2.get(konum.get(i)-1);
                    break;
                }
                else if(bilgiler2.get(konum.get(i)-1).endsWith("--"))
                    i--;
                else if(bilgiler2.get(konum.get(i)-1).endsWith("b"))
                    break;
        }
        }
        return tas;
    }

    @Override
    ArrayList hesapla(ArrayList<String> bilgiler2, ArrayList<String> arrayList_1,String tasRenk,String tehditRenk) {
        double tehditPuan=0.0;
        ArrayList<Integer> konum = new ArrayList<Integer>();
        String tas = vezirHesapla(bilgiler2, arrayList_1,tehditRenk);
        for(int i=0;i<bilgiler2.size();i++){
            if(bilgiler2.get(i).startsWith(tas) && tas!=""){
                if(bilgiler2.get(i).endsWith("p"+tehditRenk))
                    konum.add(bilgiler2.indexOf(bilgiler2.get(i))+1);
                if(bilgiler2.get(i).endsWith("a"+tehditRenk))
                    konum.add(bilgiler2.indexOf(bilgiler2.get(i))+1);
                if(bilgiler2.get(i).endsWith("f"+tehditRenk))
                    konum.add(bilgiler2.indexOf(bilgiler2.get(i))+1);
                if(bilgiler2.get(i).endsWith("k"+tehditRenk))
                    konum.add(bilgiler2.indexOf(bilgiler2.get(i))+1);              
                if(bilgiler2.get(i).endsWith("v"+tehditRenk))
                    konum.add(bilgiler2.indexOf(bilgiler2.get(i))+1);               
                if(bilgiler2.get(i).endsWith("s"+tehditRenk))
                    konum.add(bilgiler2.indexOf(bilgiler2.get(i))+1);
            }
        }
        return konum;
    }

}
