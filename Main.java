package TUGAS1_PBO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String user, password;
        int menu_restaurant;
        int menu_orderan;

        Scanner scanner = new Scanner(System.in);
        Login user1 = new Login();
        Admin restaurant = new Admin();
        Admin menu = new Admin();
        boolean loggiedin = false;

        while (loggiedin == false){
            System.out.println("------- MASUK ---------");
            System.out.println("| Masukkan username : |");user = scanner.next();
            System.out.println("| Masukkan password : |");password = scanner.next();
            System.out.println("|_____________________|");

            if (user.equals(user1.getUsername_user()) && password.equals(user1.getPassword_user()) ||
                    user.equals(user1.getUsername_admin())&& password.equals(user1.getPassword_admin())) {
                int ulang;
                loggiedin = true;
                if (user.equals(user1.getPassword_user())) {
                    do {
                        System.out.println("---------- Menu Customer ----------");
                        System.out.println("| 1. Order                        |");
                        System.out.println("| 2. Lihat Orderan                |");
                        System.out.println("| 3. Login Ulang                  |");
                        System.out.println("| 4. Out                          |");
                        System.out.println("|Masukkan opsi yang anda inginkan:|");
                        menu_orderan = scanner.nextInt();
                        switch (menu_orderan) {
                            case 1:
                                restaurant.viewMenu();
                                break;
                            case 2:
                                restaurant.viewOrder();
                                break;
                            case 3:
                                loggiedin = false;
                                break;
                            case 4:
                                System.out.println("Anda Logout");
                                System.exit(0);
                                break;
                        }
                        String pesan = (loggiedin == false) ? "Login ulang ? (1 = Tidak/ 2 = Iya) : " : "Apakah anda ingin memilih menu lain? (1 = iya /2 = tidak) : ";
                        System.out.print(pesan);
                        ulang = scanner.nextInt();
                    } while (ulang == 1);
                } else if (user.equals(user1.getPassword_admin())) {
                    do {
                        restaurant.MenuAdmin();
                        System.out.println("Masukkan Opsi ");
                        menu_restaurant = scanner.nextInt();

                        switch (menu_restaurant) {
                            case 1:
                                restaurant.viewRestaurant();
                                break;
                            case 2:
                                restaurant.addRestaurant();
                                break;
                            case 3:
                                restaurant.removeRestaurant();
                                break;
                            case 4:
                                loggiedin = false;
                                break;
                            case 5:
                                System.out.println("Anda Berhasil OUT");
                                System.exit(0);
                                break;
                        }
                        String pesan = (loggiedin == false) ? "Login ulang ? (1 = Tidak/ 2 = Iya) : " : "Apakah anda ingin memilih menu lain? (1 = iya /2 = tidak) : ";
                        System.out.println(pesan);
                        ulang = scanner.nextInt();
                    } while (ulang == 1);
                }
            } else {
                System.out.println("*Username/Password Salah");
            }
        }
    }
}
