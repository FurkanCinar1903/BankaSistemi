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

            if (secim == 1) {

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
            }

            else if (secim == 2) {

                if (hesaplar.size() == 0) {
                    System.out.println("Henüz hesap yok!");
                } else {
                    for (int i = 0; i < hesaplar.size(); i++) {
                        hesaplar.get(i).hesapBilgisi();
                    }
                }
            }

            else if (secim == 3) {

                System.out.print("Hesap numarası: ");
                int numara = scanner.nextInt();

                Hesaplar hesap = null;

                for (int i = 0; i < hesaplar.size(); i++) {
                    if (hesaplar.get(i).getNumara() == numara) {
                        hesap = hesaplar.get(i);
                    }
                }

                if (hesap == null) {
                    System.out.println("Hesap bulunamadı!");
                } else {
                    System.out.print("Yatırılacak miktar: ");
                    double para = scanner.nextDouble();

                    if (hesap.paraYatir(para)) {
                        System.out.println("Para yatırıldı!");
                        System.out.println("Yeni bakiye: " + hesap.getBakiye());
                    } else {
                        System.out.println("İşlem yapılamadı!");
                    }
                }
            }

            else if (secim == 4) {

                System.out.print("Hesap numarası: ");
                int numara = scanner.nextInt();

                Hesaplar hesap = null;

                for (int i = 0; i < hesaplar.size(); i++) {
                    if (hesaplar.get(i).getNumara() == numara) {
                        hesap = hesaplar.get(i);
                    }
                }

                if (hesap == null) {
                    System.out.println("Hesap bulunamadı!");
                } else {
                    System.out.print("Çekilecek miktar: ");
                    double para = scanner.nextDouble();

                    if (hesap.paraCek(para)) {
                        System.out.println("Para çekildi!");
                        System.out.println("Kalan bakiye: " + hesap.getBakiye());
                    } else {
                        System.out.println("İşlem yapılamadı!");
                    }
                }
            }

            else if (secim == 5) {

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

                    if (gonderen.paraGonder(alici, para)) {
                        System.out.println("Transfer başarılı!");
                    } else {
                        System.out.println("Transfer yapılamadı!");
                    }
                }
            }

            else if (secim == 6) {

                System.out.print("Hesap numarası: ");
                int numara = scanner.nextInt();

                Hesaplar hesap = null;

                for (int i = 0; i < hesaplar.size(); i++) {
                    if (hesaplar.get(i).getNumara() == numara) {
                        hesap = hesaplar.get(i);
                    }
                }

                if (hesap == null) {
                    System.out.println("Hesap bulunamadı!");
                } else {
                    hesap.hesapBilgisi();
                }
            }

            else if (secim == 0) {
                System.out.println("Çıkış yapıldı!");
                break;
            }

            else {
                System.out.println("Hatalı seçim!");
            }
        }

        scanner.close();
    }
}