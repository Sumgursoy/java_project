import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Önceden belirlenmiş PIN kodu
        String correctPin = "1234";
        String enteredPin;
        double balance = 1000.0;  // Başlangıç bakiyesi
        boolean loggedIn = false;

        // Kullanıcı giriş işlemi (while döngüsü ile)
        System.out.println("ATM'ye Hoşgeldiniz!");
        while (!loggedIn) {
            System.out.print("Lütfen PIN kodunu girin: ");
            enteredPin = scanner.nextLine();

            if (enteredPin.equals(correctPin)) {
                loggedIn = true;
                System.out.println("PIN kodu doğru. Giriş başarılı!");
            } else {
                System.out.println("Hatalı PIN. Tekrar deneyin.");
            }
        }

        // ATM işlemleri menüsü
        int choice;
        while (true) {
            // Menü gösterimi
            System.out.println("\nATM Menüsü:");
            System.out.println("1. Bakiye Görüntüleme");
            System.out.println("2. Para Yatırma");
            System.out.println("3. Para Çekme");
            System.out.println("4. Çıkış");
            System.out.print("Bir işlem seçin (1/2/3/4): ");
            choice = scanner.nextInt();

            if (choice == 1) {
                // Bakiye görüntüleme
                System.out.println("Mevcut Bakiyeniz: " + balance + " TL");
            }
            else if (choice == 2) {
                // Para yatırma
                System.out.print("Yatırmak istediğiniz tutarı girin: ");
                double deposit = scanner.nextDouble();
                if (deposit > 0) {
                    balance += deposit;
                    System.out.println(deposit + " TL hesabınıza yatırıldı.");
                } else {
                    System.out.println("Geçersiz tutar. Lütfen pozitif bir tutar girin.");
                }
            }
            else if (choice == 3) {
                // Para çekme
                System.out.print("Çekmek istediğiniz tutarı girin: ");
                double withdrawal = scanner.nextDouble();
                if (withdrawal <= balance) {
                    balance -= withdrawal;
                    System.out.println(withdrawal + " TL hesabınızdan çekildi.");
                } else {
                    System.out.println("Yetersiz bakiye. Çekmek istediğiniz tutar bakiyenizden fazla.");
                }
            }
            else if (choice == 4) {
                // Çıkış
                System.out.println("Çıkış yapılıyor. Hoşça kalın!");
                break;  // Programı sonlandırmak için döngüyü kırıyoruz
            }
            else {
                // Geçersiz işlem seçimi
                System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }

        scanner.close();  // Scanner'ı kapatıyoruz
    }
}
