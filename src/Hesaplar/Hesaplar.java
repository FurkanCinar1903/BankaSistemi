package Hesaplar;

public class Hesaplar {

    private String isim;
    private int numara;
    private double bakiye;
    private boolean aktif;

    public Hesaplar(String isim, int numara, double bakiye) {
        this.isim = isim;
        this.numara = numara;
        this.bakiye = bakiye;
        this.aktif = true;
    }

    public void hesapBilgisi() {

        String durumStr = "Aktif";

        if (aktif == false) {
            durumStr = "Pasif";
        }

        System.out.println(numara + " | " + isim + " | " + bakiye + " TL | " + durumStr);
    }

    public boolean paraYatir(double miktar) {

        if (aktif == false) {
            System.out.println("Hata: Hesap aktif değil!");
            return false;
        }

        if (miktar <= 0) {
            return false;
        }

        bakiye = bakiye + miktar;
        return true;
    }

    public boolean paraCek(double miktar) {

        if (aktif == false) {
            System.out.println("Hata: Hesap aktif değil!");
            return false;
        }

        if (miktar <= 0) {
            return false;
        }

        if (bakiye < miktar) {
            System.out.println("Yetersiz bakiye!");
            return false;
        }

        bakiye = bakiye - miktar;
        return true;
    }

    public boolean paraGonder(Hesaplar alici, double miktar) {

        if (alici == null) {
            System.out.println("Hata: Alıcı hesap bulunamadı!");
            return false;
        }

        if (aktif == false || alici.isAktif() == false) {
            System.out.println("Hata: Hesaplardan biri aktif değil!");
            return false;
        }

        if (miktar <= 0) {
            return false;
        }

        if (numara == alici.getNumara()) {
            System.out.println("Aynı hesaba transfer yapılamaz!");
            return false;
        }

        if (bakiye < miktar) {
            System.out.println("Yetersiz bakiye!");
            return false;
        }

        bakiye = bakiye - miktar;
        alici.bakiye = alici.bakiye + miktar;

        System.out.println("Gönderen Yeni Bakiye: " + bakiye + " TL");
        System.out.println("Alıcı Yeni Bakiye: " + alici.getBakiye() + " TL");

        return true;
    }

    public String getIsim() {
        return isim;
    }

    public int getNumara() {
        return numara;
    }

    public double getBakiye() {
        return bakiye;
    }

    public boolean isAktif() {
        return aktif;
    }
}