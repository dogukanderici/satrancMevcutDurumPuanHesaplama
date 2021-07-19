
import com.sun.swing.internal.plaf.basic.resources.basic;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Ortak {
    
    private String tahta;

    public Ortak(String tahta) {
        this.tahta = tahta;
    }

    public String getTahta() {
        return tahta;
    }

    public void setTahta(String tahta) {
        this.tahta = tahta;
    }
    /* 
        VezirAsagiYon metodu tahtaya göre vezirin aşağı yönde gidebileceği
        kareleri bulan metottur. 
    */
    abstract ArrayList VezirAsagiYon(ArrayList<String> bilgiler2,ArrayList<String> arrayList_Sag,String tehditRenk);
    /*
        tehditYonleri metodu piyon, at ve vezirin hareket edebilecekleri 
        kareleri hesaplayan metottur.
    */
    abstract ArrayList tehditYonleri(String tasRenk);
    /*
        hesapla metodu içerisine aldığı veriler ile piyon, at ve vezirin siyah
        ve beyaz renklerine göre ayrı ayrı puan hesaplayan metottur.
    */
    abstract ArrayList hesapla(ArrayList<String> bilgiler2, ArrayList<String> arrayList_1,String tasRenk,String tehditRenk);
    
}
