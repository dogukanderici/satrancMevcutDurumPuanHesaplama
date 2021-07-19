# Satranç-Mevcut Durum Puan Hesaplaması
## İÇİNDEKİLER
1. [Projenin Amacı](#baslik1)
2. [Taşların Puanlanması](#baslik2)
3. [Sonuçlar](#baslik3)
4. [Yazarlar](#baslik4)


## Projenin Amacı <a name="baslik1"></a>
Bu çalışma satranç tahtası üzerindeki (siyah-beyaz) taşların mevcut puan durumlarının hesaplanmasını içermektedir. 
## Taşların Puanlanması <a name="baslik2"></a>
Taşların puanlanması siyah ve beyaz taşlar için aynıdır.Mevcut durum puan hesaplaması bir taşın tehdit altında olup olmadığının
kontrolü, o taşı tehdit eden karşı renkten bir veya birden fazla taş olması durumunda oluşmaktadır. Tablo 1'de satranç taşları ve puan karşılıkları verilmiştir. Eğer bir taş
tehdit edilmiyorsa tablo 1'deki puan karşılığını alır. Eğer bir taş tehdit ediliyorsa tablo 2'de gösterilen puanı alır. Bu puan tehdit altında olmadığı durumda aldığı puanın
yarısıdır. (1a karesinin her zaman sol altta yer alacağı varsayılmıştır.)

Tablo 1 - Tehdit altında olmayan satranç taşlarının puan karşılığı

| Taş | Puan |
| --- | --- |
| Piyon | 1 |
| At | 3 |
| Fil | 3 |
| Kale | 5 |
| Vezir | 9 |
| Şah | 100 |

Tablo 2 - Tehdit altındaki satranç taşının puan karşılığı

| Taş | Puan |
| --- | --- |
| Piyon | 0.5 |
| At | 1.5 |
| Fil | 1.5 |
| Kale | 2.5 |
| Vezir | 4.5 |
| Şah | 50 |

Şekil 2'de örnek bir satranç tahtası durumu ve puan hesaplaması verilmiştir. 

![alt text](https://images.chesscomfiles.com/uploads/v1/images_users/tiny_mce/CHESScom/phphK5JVu.png)

Beyaz = (3x2)+(3x2)+(5x2)+(8x1)+9+100 = 139
Siyah = (3x2)+(3x2)+(5x2)+(8x1)+9+100 = 139 olarak hesaplanır.

Satranç taşalrının konumu bir .txt dosyasında programa gönderilmiştir.
## Sonuçlar <a name="baslik3"></a>
Programın sonuçları sonuçlar.txt isimli bir dosyaya kaydedilmektedir. Şekil 2'de verilmiş olan örenk durumun çıktısı aşağıda verilmiştir.

| Tahta Adı | Sonuçlar | |
| --- | --- | --- |
| board4.txt | Siyah:139 | Beyaz:139 |

## Yazarlar <a name="baslik4"></a>
   - Doğukan Derici
