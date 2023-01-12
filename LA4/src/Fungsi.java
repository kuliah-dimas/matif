import java.util.Scanner;

public class Fungsi {
    int[] HimpunanA;
    int[] HimpunanB;
    int[] HimpunanRelasi;
    int[] HimpunanAsal;
    int jumlahHimpunanA, jumlahHimpunanB, jumlahRelasi;
    boolean satu2;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Fungsi Dimas = new Fungsi();
        Dimas.inputAnggota();
        Dimas.cetakHimpunan();
        Dimas.inputRelasi();
        Dimas.cekFungsi();
        Dimas.cetakRelasi();
    }

    public void inputAnggota() {
        System.out.println("=============================");
        System.out.print("Masukkan Jumlah Himpunan A: ");
        jumlahHimpunanA = input.nextInt();
        HimpunanA = new int[jumlahHimpunanA];
        for (int i = 0; i <= (jumlahHimpunanA - 1); i++) {
            System.out.print("Himpunan A yang ke " + (i + 1) + ": ");
            HimpunanA[i] = input.nextInt();
        }

        System.out.println("\n=============================\n");
        System.out.print("Masukkan Jumlah Himpunan B: ");
        jumlahHimpunanB = input.nextInt();
        HimpunanB = new int[jumlahHimpunanB];
        for (int i = 0; i <= (jumlahHimpunanB - 1); i++) {
            System.out.print("Himpunan B yang ke " + (i + 1) + ": ");
            HimpunanB[i] = input.nextInt();
        }
    }

    public void cetakHimpunan() {

        System.out.println("\n=============================\n");
        System.out.print("Anggota Himpunan A = { ");
        for (int i = 0; i <= (jumlahHimpunanA - 1); i++) {
            System.out.print(HimpunanA[i] + " ");
        }
        System.out.println(" }");

        System.out.print("Anggota Himpunan B = { ");
        for (int i = 0; i <= (jumlahHimpunanB - 1); i++) {
            System.out.print(HimpunanB[i] + " ");
        }
        System.out.println(" }");
    }

    public void inputRelasi() {
        System.out.println("\n=============================\n");
        int jumlahRelasiMaks = jumlahHimpunanA * jumlahHimpunanB;
        System.out.println("Relasi Maksimal adalah: " + jumlahRelasiMaks);
        System.out.print("");

        do {
            System.out.println("\n=============================\n");
            System.out.print("Masukkan Jumlah Relasi yang Terjadi: ");
            jumlahRelasi = input.nextInt();
        } while (jumlahRelasi > jumlahRelasiMaks);

        HimpunanRelasi = new int[jumlahRelasi];
        HimpunanAsal = new int[jumlahRelasi];
        System.out.println("Masukkan Relasi yang Terjadi");

        for (int i = 0; i <= (jumlahRelasi - 1); i++) {
            int[] temp = new int[jumlahRelasi];
            int[] temp2 = new int[jumlahRelasi];
            boolean SamaA = false;
            boolean SamaB = false;

            System.out.println("\n==========================\n");
            System.out.println("Relasi ke " + (i + 1) + " ");
            do {
                System.out.print("Masukkan Asal A: ");
                temp[i] = input.nextInt();
                System.out.print("Masukkan Tujuan B: ");
                temp2[i] = input.nextInt();


                for (int j = 0; j <= (jumlahHimpunanA - 1); j++) {
                    if (temp[i] == HimpunanA[j]) {
                        SamaA = true;
                        break;
                    }
                }

                for (int k = 0; k <= (jumlahHimpunanB - 1); k++) {
                    if (temp2[i] == HimpunanB[k]) {
                        SamaB = true;
                        break;
                    }
                }

                if (!SamaA || !SamaB) {
                    System.out.println("\n==========================\n");
                    System.out.println("Anggota Himpunan Tidak Terdapat di Himpunan A atau B");
                }

                if (SamaA && SamaB) {
                    HimpunanRelasi[i] = temp2[i];
                    HimpunanAsal[i] = temp[i];
                }
            } while (!SamaA || !SamaB);
        }
    }

    public void cekFungsi() {
        System.out.println("\n==========================\n");
        int jumlahAnggota = 0;
        boolean adaSama = false;
        for (int i = 0; i <= (jumlahHimpunanA - 1); i++) {
            for (int j = 0; j <= (jumlahRelasi - 1); j++) {
                if (HimpunanA[i] == HimpunanAsal[j]) {
                    jumlahAnggota++;
                }
            }
        }

        for (int i = 0; i <= (jumlahRelasi - 1); i++) {
            for (int j = i + 1; j <= (jumlahRelasi - 1); j++) {
                if (HimpunanAsal[i] == HimpunanAsal[j]) {
                    adaSama = true;
                    break;
                }
            }
        }

        if (jumlahAnggota == jumlahHimpunanA && !adaSama) {
            System.out.println("Relasi yang diinput adalah Fungsi");
            jumlahAnggota = 0;
            for (int i = 0; i <= (jumlahHimpunanB - 1); i++) {
                for (int j = 0; j <= (jumlahRelasi - 1); j++) {
                    if (HimpunanB[i] == HimpunanRelasi[j]) {
                        jumlahAnggota++;
                    }
                }
            }
        }

        for (int i = 0; i <= (jumlahRelasi - 1); i++) {
            for (int j = i+1; j <= (jumlahRelasi - 1); j++) {
                if (HimpunanRelasi[i] == HimpunanRelasi[j]) {
                    adaSama = true;
                    break;
                }
            }
        }

        if (jumlahAnggota == jumlahHimpunanB && !adaSama) {
            System.out.println("Fungsi yang diinput adalah Fungsi satu-satu");
            satu2 = true;
        } else {
            System.out.println("Relasi yang diinput bukan Fungsi, hanya Relasi biasa yang memiliki " + jumlahAnggota + " anggota");
        }

    }

    public void cetakRelasi() {
        System.out.print("Daerah Domain = { ");
        for (int i = 0; i <= (jumlahHimpunanA - 1); i++) {
            System.out.print(HimpunanA[i] + " ");
        }
        System.out.println("}");


        System.out.print("Daerah Kodomain = { ");
        for (int i = 0; i <= (jumlahHimpunanB - 1); i++) {
            System.out.print(HimpunanB[i] + " ");
        }
        System.out.println("}");

        System.out.print("Daerah Range adalah = { ");
        for (int i = 0; i <= (jumlahRelasi - 1); i++) {
            boolean adaSama = false;
            for (int j = i + 1; j <= jumlahRelasi-1; j++) {
                if (HimpunanRelasi[i] == HimpunanRelasi[j]) {
                    adaSama = true;
                }
                if (adaSama== false) {
                    System.out.print(HimpunanRelasi[i] + " ");
                }
            }
        }
        System.out.println("}");

        if (satu2) {
            System.out.println("\nFungsi Inverse nya adalah:");
            System.out.print("Daerah Domain = {");
            for (int i = 0; i <= jumlahHimpunanA - 1; i++) {
                System.out.print(HimpunanB[i]+ " ");
            }
            System.out.println("}");

            System.out.print("Daerah Kodomain = {");
            for (int i = 0; i <= jumlahHimpunanB - 1; i++) {
                System.out.print(HimpunanA[i]+ " ");
            }
            System.out.println("}");

            System.out.print("Daerah Range = {");
            for (int i = 0; i <= jumlahRelasi - 1; i++) {
                boolean adaSama = false;
                for (int j = i+1; j <= jumlahRelasi - 1; j++) {
                    if (HimpunanAsal[i] == HimpunanAsal[j]) {
                        adaSama = true;
                    }
                }

                if (adaSama == false) {
                    System.out.print(HimpunanAsal[i] + " ");
                }
            }

            System.out.print("}");
        }
    }
}