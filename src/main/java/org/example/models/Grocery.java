package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
  private static final ArrayList<String> groceryList = new ArrayList<>();

  public static void startGrocery() {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    while (!exit) {
      System.out.println("\nSeçenekler:");
      System.out.println("0 - Çıkış");
      System.out.println("1 - Ürün ekle");
      System.out.println("2 - Ürün çıkar");
      System.out.print("Seçiminizi yapın: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Buffer temizleme

      switch (choice) {
        case 0:
          exit = true;
          break;
        case 1:
          System.out.print("Eklemek istediğiniz ürün(ler)i girin (örnek: domates, elma, muz): ");
          String itemsToAdd = scanner.nextLine();
          addItems(itemsToAdd);
          break;
        case 2:
          System.out.print("Çıkarmak istediğiniz ürün(ler)i girin (örnek: domates, elma, muz): ");
          String itemsToRemove = scanner.nextLine();
          removeItems(itemsToRemove);
          break;
        default:
          System.out.println("Geçersiz seçim!");
      }
    }
    scanner.close();
  }

  public static void addItems(String input) {
    List<String> items = Arrays.asList(input.split("\\s*,\\s*")); // Boşlukları temizleyerek bölüyoruz
    for (String item : items) {
      if (!checkItemIsInList(item)) {
        groceryList.add(item);
      }
    }
    printSorted();
  }

  public static void removeItems(String input) {
    List<String> items = Arrays.asList(input.split("\\s*,\\s*"));
    groceryList.removeAll(items);
    printSorted();
  }

  public static boolean checkItemIsInList(String product) {
    return groceryList.contains(product);
  }

  public static void printSorted() {
    Collections.sort(groceryList);
    System.out.println("Güncellenmiş Liste: " + groceryList);
  }
}
