import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class At extends Ortak{

    public At(String tahta) {
        super(tahta);
    }
    
    /*  hesapla metodu ile atın tehdit ettiği taşların tahta
        üzerindeki tüm karelerin tahta üzerindeki tüm taşların bilgisinin 
        yer aldığı listeden konumunu alır.
    */
    @Override
    ArrayList hesapla(ArrayList<String> bilgiler2,ArrayList<String> arrayList_1,String tasRenk,String tehditRenk){
        double siyahAtTehditAlti = 0.0;
        ArrayList<Integer> konum = new ArrayList<Integer>();
        //arrayList_1-> Taşın Hareket Yönü
        // Beyaz At 2 ileri hareket ettiğinde Siyah için tehdit hesaplama
             for(int i=0;i<bilgiler2.size();i++){
                 for(int j=0;j<arrayList_1.size();j++){
                     if(bilgiler2.get(i).startsWith(arrayList_1.get(j))){
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
        
        ArrayList<String> ileri_2_sag = new ArrayList<String>();
        ArrayList<String> ileri_2_sol = new ArrayList<String>();
        ArrayList<String> geri_2_sag = new ArrayList<String>();
        ArrayList<String> geri_2_sol = new ArrayList<String>();
        ArrayList<String> sag_2_yukari = new ArrayList<String>();
        ArrayList<String> sag_2_asagi = new ArrayList<String>();
        ArrayList<String> sol_2_yukari = new ArrayList<String>();
        ArrayList<String> sol_2_asagi = new ArrayList<String>();
        ArrayList<ArrayList> yonler = new ArrayList<ArrayList>();
        
        ArrayList<String> bilgiler2 = new ArrayList<String>();
        String[] bilgiler={};
        
        try(Scanner scan = new Scanner(new FileReader(getTahta()))){
            
            while(scan.hasNextLine()){
                
                String bilgi = scan.nextLine();
                bilgiler = bilgi.split(" ");
                
                for(int i=0;i<bilgiler.length;i++){
                    bilgiler2.add(array1[k]+array2[i]+"-"+bilgiler[i]);
                    if(bilgiler[i].startsWith(tasRenk)){
                        // Beyaz At 2 ileri gidebileceği durum
                        if(!(k>=6)){
                            if(i!=7)
                                ileri_2_sag.add(array1[k+2]+array2[i+1]);
                            if(i!=0)
                                ileri_2_sol.add(array1[k+2]+array2[i-1]);
                        }
                        // Beyaz At 2 geri gidebileceği durum
                        if(!(k-2<0)){
                            if(i!=7)
                                geri_2_sag.add(array1[k-2]+array2[i+1]);
                            if(i!=0)
                                geri_2_sol.add(array1[k-2]+array2[i-1]);
                        }
                        // Beyaz At 2 sağa gidebileceği durum
                        if(!(i+2>=8)){
                            if(k!=7)
                                sag_2_yukari.add(array1[k+1]+array2[i+2]);
                            if(k!=0)
                                sag_2_asagi.add(array1[k-1]+array2[i+2]);
                        }
                        // Beyaz At 2 sola gidebileceği durum
                        if(!(i-2<=-1)){
                            if(k!=7)
                                sol_2_yukari.add(array1[k+1]+array2[i-2]);
                            if(k!=0)
                                sol_2_asagi.add(array1[k-1]+array2[i-2]);
                        }
                    }
                }
                k--;
            }
            /*
                atın siyah veya beyaz olması duruma göre hareket edileceğii tüm 
                kareler için tehdit ettiği bir taşın olup olmadığını eğer varsa
                bu taşın tahtadaki konumunun alınması için hesapla fonksiyonuna
                içerisindeki verileri gönderir.
            */
            if(tasRenk.equals("ab")){
                yonler.add(hesapla(bilgiler2, ileri_2_sag,"b","s"));
                yonler.add(hesapla(bilgiler2, ileri_2_sol,"b","s"));
                yonler.add(hesapla(bilgiler2, geri_2_sag,"b","s"));
                yonler.add(hesapla(bilgiler2, geri_2_sol,"b","s"));
                yonler.add(hesapla(bilgiler2, sag_2_yukari,"b","s"));
                yonler.add(hesapla(bilgiler2, sag_2_asagi,"b","s"));
                yonler.add(hesapla(bilgiler2, sol_2_yukari,"b","s"));
                yonler.add(hesapla(bilgiler2, sol_2_asagi,"b","s"));
            }
            if(tasRenk.equals("as")){
                yonler.add(hesapla(bilgiler2, ileri_2_sag,"s","b"));
                yonler.add(hesapla(bilgiler2, ileri_2_sol,"s","b"));
                yonler.add(hesapla(bilgiler2, geri_2_sag,"s","b"));
                yonler.add(hesapla(bilgiler2, geri_2_sol,"s","b"));
                yonler.add(hesapla(bilgiler2, sag_2_yukari,"s","b"));
                yonler.add(hesapla(bilgiler2, sag_2_asagi,"s","b"));
                yonler.add(hesapla(bilgiler2, sol_2_yukari,"s","b"));
                yonler.add(hesapla(bilgiler2, sol_2_asagi,"s","b"));
            }
            
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(At.class.getName()).log(Level.SEVERE, null, ex);
        }
        return yonler;
    }

    @Override
    ArrayList VezirAsagiYon(ArrayList<String> bilgiler2,ArrayList<String> arrayList_Sag,String tehditRenk) {
        
        return null;
        
    }

    
}
