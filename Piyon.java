import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Piyon extends Ortak{
    public Piyon(String tahta) {
        super(tahta);
    }
    
    /*  hesapla metodu ile piyonun tehdit ettiği taşların tahta
        üzerindeki tüm karelerin tahta üzerindeki tüm taşların bilgisinin 
        yer aldığı listeden konumunu alır.
    */
    @Override
    ArrayList hesapla(ArrayList<String> bilgiler2, ArrayList<String> arrayList_1,String tasRenk,String tehditRenk) {
        double siyahPiyonTehditAlti=0.0;
        ArrayList<Integer> konum = new ArrayList<Integer>();
        // arrayList1-> Taşın Hareket Yönü
        for(int i=0;i<bilgiler2.size();i++){
            for(int j=0;j<arrayList_1.size();j++){
                if(bilgiler2.get(i).startsWith((arrayList_1.get(j)))){
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
        }
        return konum;
    }
    /*
        tehditYonleri fonksiyonu ile piyonun bulunduğu konuma göre hareket
        edebilecği tüm karelerin bilgisi (4a,5g,8e, vb.) bulunur
    */
    @Override
    ArrayList tehditYonleri(String tasRenk) {
        int k=7;
        String[] array1 = {"1","2","3","4","5","6","7","8"}; //k
        String[] array2 = {"a","b","c","d","e","f","g","h"}; //i
        ArrayList<String> sag_ust_b = new ArrayList<String>();
        ArrayList<String> sol_ust_b = new ArrayList<String>();
        ArrayList<String> sag_alt_s = new ArrayList<String>();
        ArrayList<String> sol_alt_s = new ArrayList<String>();
        ArrayList<String> bilgiler2 = new ArrayList<String>();
        ArrayList<ArrayList> yonler = new ArrayList<ArrayList>();
        String[] bilgiler={};
        
        try(Scanner scan = new Scanner(new FileReader(getTahta()))){
            while(scan.hasNextLine()){
                String bilgi = scan.nextLine();
                bilgiler = bilgi.split(" ");
                for(int i=0;i<bilgiler.length;i++){
                    bilgiler2.add(array1[k]+array2[i]+"-"+bilgiler[i]);
                    if(bilgiler[i].startsWith("pb") && tasRenk.equals("pb")){
                        // Beyaz Piyon için Tahta Sağ Üst
                        
                        if(k!=7 && i!=7){
                            sag_ust_b.add(array1[k+1]+array2[i+1]);
                        }
                        if(k!=7 && i!=0){
                            sol_ust_b.add(array1[k+1]+array2[i-1]);
                        }
                        
                    }
                    if(bilgiler[i].startsWith("ps") && tasRenk.equals("ps")){
                        // Siyah Piyon için Tahta Sağ Alt
                        if(i!=7 && k!=0){
                            sag_alt_s.add(array1[k-1]+array2[i+1]);
                        }
                        // Siyah Piyon için Tahta Sol Alt
                        if(i!=0 && k!=0){
                            sol_alt_s.add(array1[k-1]+array2[i-1]);
                        }
                        
                    }
                }
                k--;
            }
            
            if(tasRenk.equals("pb")){
                yonler.add(hesapla(bilgiler2, sag_ust_b, "b", "s"));
                yonler.add(hesapla(bilgiler2, sol_ust_b, "b", "s"));
            }
            if(tasRenk.equals("ps")){
                yonler.add(hesapla(bilgiler2, sag_alt_s, "s", "b"));
                yonler.add(hesapla(bilgiler2, sol_alt_s, "s", "b"));
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadı.");
        }
        
        return yonler;
    }

    @Override
    ArrayList VezirAsagiYon(ArrayList<String> bilgiler2,ArrayList<String> arrayList_Sag,String tehditRenk) {
        
        return null;
        
    }
}
