
import java.util.Scanner;
import java.util.ArrayList;
import Hesaplar.Hesaplar;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Hesaplar> hesaplar = new ArrayList<>();

        // Test hesapları
        hesaplar.add(new Hesaplar("Ahmet Yılmaz", 1001, 2500));
        hesaplar.add(new Hesaplar("Ayşe Demir", 1002, 1500));
        hesaplar.add(new Hesaplar("Mehmet Kaya", 1003, 5000));

        while (true) {

            System.out.println("\n===== BANKA SİSTEMİ =====");
            System.out.println("1- Hesap Oluştur");
            System.out.println("2- Hesapları Listele");
            System.out.println("3- Para Yatır");
            System.out.println("4- Para Çek");
            System.out.println("5- Para Transfer Et");
            System.out.println("6- Hesap Ara");
            System.out.println("0- Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();

            switch (secim) {

                case 1:

                    scanner.nextLine();

                    System.out.print("Ad Soyad: ");
                    String isim = scanner.nextLine();

                    System.out.print("Hesap numarası: ");
                    int numara = scanner.nextInt();

                    boolean varMi = false;

                    for (int i = 0; i < hesaplar.size(); i++) {
                        if (hesaplar.get(i).getNumara() == numara) {
                            varMi = true;
                        }
                    }

                    if (varMi) {
                        System.out.println("Bu numara zaten kullanılıyor!");
                    } else {

                        System.out.print("Başlangıç bakiyesi: ");
                        double bakiye = scanner.nextDouble();

                        if (bakiye < 0) {
                            System.out.println("Negatif bakiye olamaz!");
                        } else {
                            hesaplar.add(new Hesaplar(isim, numara, bakiye));
                            System.out.println("Hesap oluşturuldu!");
                        }
                    }

                    break;

                case 2:

                    if (hesaplar.size() == 0) {
                        System.out.println("Henüz hesap yok!");
                    } else {
                        for (int i = 0; i < hesaplar.size(); i++) {
                            hesaplar.get(i).hesapBilgisi();
                        }
                    }

                    break;

                case 3:

                    System.out.print("Hesap numarası: ");
                    int yatirmaNo = scanner.nextInt();

                    Hesaplar yatirmaHesabi = null;

                    for (int i = 0; i < hesaplar.size(); i++) {
                        if (hesaplar.get(i).getNumara() == yatirmaNo) {
                            yatirmaHesabi = hesaplar.get(i);
                        }
                    }

                    if (yatirmaHesabi == null) {
                        System.out.println("Hesap bulunamadı!");
                    } else {

                        System.out.print("Yatırılacak miktar: ");
                        double para = scanner.nextDouble();

                        switch (Boolean.toString(yatirmaHesabi.paraYatir(para))) {

                            case "true":
                                System.out.println("Para yatırıldı!");
                                System.out.println("Yeni bakiye: " + yatirmaHesabi.getBakiye());
                                break;

                            case "false":
                                System.out.println("İşlem yapılamadı!");
                                break;
                        }
                    }

                    break;

                case 4:

                    System.out.print("Hesap numarası: ");
                    int cekmeNo = scanner.nextInt();

                    Hesaplar cekmeHesabi = null;

                    for (int i = 0; i < hesaplar.size(); i++) {
                        if (hesaplar.get(i).getNumara() == cekmeNo) {
                            cekmeHesabi = hesaplar.get(i);
                        }
                    }

                    if (cekmeHesabi == null) {
                        System.out.println("Hesap bulunamadı!");
                    } else {

                        System.out.print("Çekilecek miktar: ");
                        double para = scanner.nextDouble();

                        switch (Boolean.toString(cekmeHesabi.paraCek(para))) {

                            case "true":
                                System.out.println("Para çekildi!");
                                System.out.println("Kalan bakiye: " + cekmeHesabi.getBakiye());
                                break;

                            case "false":
                                System.out.println("İşlem yapılamadı!");
                                break;
                        }
                    }

                    break;

                case 5:

                    System.out.print("Gönderen hesap: ");
                    int gonderenNo = scanner.nextInt();

                    System.out.print("Alıcı hesap: ");
                    int aliciNo = scanner.nextInt();

                    Hesaplar gonderen = null;
                    Hesaplar alici = null;

                    for (int i = 0; i < hesaplar.size(); i++) {

                        if (hesaplar.get(i).getNumara() == gonderenNo) {
                            gonderen = hesaplar.get(i);
                        }

                        if (hesaplar.get(i).getNumara() == aliciNo) {
                            alici = hesaplar.get(i);
                        }
                    }

                    if (gonderen == null || alici == null) {
                        System.out.println("Hesap bulunamadı!");
                    } else {

                        System.out.print("Transfer miktarı: ");
                        double para = scanner.nextDouble();

                        switch (Boolean.toString(gonderen.paraGonder(alici, para))) {

                            case "true":
                                System.out.println("Transfer başarılı!");
                                break;

                            case "false":
                                System.out.println("Transfer yapılamadı!");
                                break;
                        }
                    }

                    break;

                case 6:

                    System.out.print("Hesap numarası: ");
                    int arananNo = scanner.nextInt();

                    Hesaplar arananHesap = null;

                    for (int i = 0; i < hesaplar.size(); i++) {
                        if (hesaplar.get(i).getNumara() == arananNo) {
                            arananHesap = hesaplar.get(i);
                        }
                    }

                    if (arananHesap == null) {
                        System.out.println("Hesap bulunamadı!");
                    } else {
                        arananHesap.hesapBilgisi();
                    }

                    break;

                case 0:

                    System.out.println("Çıkış yapıldı!");
                    scanner.close();
                    return;

                default:

                    System.out.println("Hatalı seçim!");
                    break;
            }
        }
    }
}
