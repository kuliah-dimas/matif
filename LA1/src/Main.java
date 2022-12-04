import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    int[] himpunanA = new int[100];
    int[] himpunanB = new int[100];
    int jumlahAnggotaA, jumlahAnggotaB;

    public void dataAnggota() {
        System.out.print("Masukkan banyak anggota himpunan A : ");
        jumlahAnggotaA = input.nextInt();
        System.out.println("Anggota himpunan A");
        for (int i = 1; i <= jumlahAnggotaA; i++) {
            System.out.print("Anggota " + i + " : ");
            himpunanA[i] = input.nextInt();
        }
        System.out.print("Masukkan banyak anggota himpunan B : ");
        jumlahAnggotaB = input.nextInt();
        System.out.println("Anggota himpunan B");
        for (int i = 1; i <= jumlahAnggotaB; i++) {
            System.out.print("Anggota " + i + " : ");
            himpunanB[i] = input.nextInt();
        }
    }

    public void tampilAnggota() {
        System.out.print("Anggota himpunan A = { ");
        for (int i = 1; i <= jumlahAnggotaA; i++) {
            System.out.print(himpunanA[i] + "  ");
        }
        System.out.println("}");
        System.out.print("Anggota himpunan B = { ");
        for (int i = 1; i <= jumlahAnggotaB; i++) {
            System.out.print(himpunanB[i] + "  ");
        }
        System.out.println("}");
    }

    public void himpunanGabungan() {
        System.out.print("Himpunan gabungan A U B: { ");
        for (int i = 1; i <= jumlahAnggotaA; i++) {
            System.out.print(himpunanA[i] + "  ");
        }
        for (int i = 1; i <= jumlahAnggotaB; i++) {
            boolean adaSama = false;
            for (int j = 1; j <= jumlahAnggotaA; j++) {
                if (himpunanB[i] == himpunanA[j])
                    adaSama = true;
            }
            if (adaSama == false) {
                System.out.print(himpunanB[i] + "  ");
            }
        }
        System.out.println("}");
    }

    public void himpunanIrisan() {
        System.out.print("Himpunan irisan A n B : { ");
        for (int i = 1; i <= jumlahAnggotaB; i++) {
            boolean adaSama = false;
            for (int j = 1; j <= jumlahAnggotaA; j++) {
                if (himpunanB[i] == himpunanA[j])
                    adaSama = true;
            }
            if (adaSama == true) {
                System.out.print(himpunanB[i] + "  ");
            }
        }
        System.out.println(" }");
    }

    public static void main(String args[]) {
        Main bilangan = new Main();
        bilangan.dataAnggota();
        bilangan.tampilAnggota();
        bilangan.himpunanGabungan();
        bilangan.himpunanIrisan();
    }
}