import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class Relasi {

    String[] himpunanA = new String[100];
    String[] himpunanB = new String[100];
    String[] himpunanHasil = new String[100];
    int jumlahAnggotaA;
    int jumlahAnggotaB;
    int jumlahRelasi;


    private String bacaKey() {
        Console console = System.console();
        return console.readLine();
    }

    public void inputAnggota() {
        out.print("Masukkan Jumlah Anggota Himpunan A: ");
        jumlahAnggotaA = Integer.parseInt(bacaKey());

        out.println("Anggota Himpunan A");
        for(int i = 1; i <= jumlahAnggotaA; i++) {
            out.print("Masukkan Anggota A Ke-" + i + ": ");
          himpunanA[i] =  bacaKey();
        }

        out.print("Masukkan Jumlah Anggota Himpunan B: ");
        jumlahAnggotaB = Integer.parseInt(bacaKey());

        out.println("Anggota Himpunan B");
        for(int i = 1; i <= jumlahAnggotaB; i++) {
            out.print("Masukkan Anggota B Ke-" + i + ": ");
            himpunanB[i] = bacaKey();
        }
    }

    public void inputRelasi() {
        int jmlRelasiMaks = jumlahAnggotaA * jumlahAnggotaB;
        out.println("Banyak Relasi Maksimal yang terjadi adalah: " + jmlRelasiMaks);

        do {
            out.print("Masukan Jumlah Relasi Yang Terjadi: ");
            jumlahRelasi = Integer.parseInt((bacaKey()));
        } while (jumlahRelasi > jmlRelasiMaks);

        for(int i = 1; i <= jumlahRelasi; i++) {
          String[] temp = new String[100];
          String[] temp2 = new String[100];
          boolean SamaA = false;
          boolean SamaB = false;

          out.println("Relasi ke " + i + ": ");
          do {
              out.print("Masukkan Asal A: ");
              temp[i] = bacaKey();
              out.print("Masukkan Tujuan B: ");
              temp2[i] = bacaKey();


              for(int j = 1; j <= jumlahAnggotaA; j++) {
                if (temp[i].equals(himpunanA[j])) {
                    SamaA = true;
                }
              }

              for(int k = 1; k <= jumlahAnggotaB; k++) {
                  if (temp2[i].equals(himpunanB[k])) {
                      SamaB = true;
                  }
              }

              if (!SamaA && !SamaB) {
                  out.println("Anggota Himpunan Tidak Terdapat di Himpunan A atau B");
              }

              if (SamaA && SamaB) {
                  himpunanHasil[i] = temp2[i];
              }

          } while (!SamaA || !SamaB);
        }
    }

    public void cetakRelasi() {
        out.println("Daerah Domain = {");
        for(int i = 1; i <= jumlahAnggotaA; i++) {
          out.print(himpunanA[i]+ " ");
        }
        out.println("}");

        out.println("Daerah Range = {");
        for(int i = 1; i <= jumlahRelasi; i++) {
            out.print(himpunanHasil[i]+ " ");
        }
        out.println("}");
    }


    public static void main(String[] args) {
        Relasi A = new Relasi();
        A.inputAnggota();
        A.inputRelasi();
        A.cetakRelasi();
    }
}
