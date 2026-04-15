import java.util.*;
public class Main {
  public static void main(String[] args) {
    // Khởi tạo 3 cấu trúc dữ liệu
    List<Book> arrayList = new ArrayList<>();
    Map<String, Book> hashMap = new HashMap<>();
    Map<String, Book> treeMap = new TreeMap<>();

    // 1. Thêm sách
    Book b1 = new Book("B001", "Java Programming", "Author A", 2020);
    Book b2 = new Book("B005", "Data Structures", "Author B", 2018);
    Book b3 = new Book("B003", "Algorithms", "Author C", 2021);
    Book b4 = new Book("B002", "Web Design", "Author D", 2019);
    Book b5 = new Book("B004", "AI Basics", "Author E", 2022);

    Book[] books = {b1, b2, b3, b4, b5};
    for (Book b : books) {
      arrayList.add(b);
      hashMap.put(b.getId(), b);
      treeMap.put(b.getId(), b);
    }

    // 2. Tìm kiếm (Ví dụ tìm ID B003)
    String searchId = "B003";

    // ArrayList search
    for (Book b : arrayList) {
      if (b.getId().equals(searchId)) { /* Found */ }
    }
    // Map search (Rất nhanh)
    Book foundInHash = hashMap.get(searchId);

    // 3. Xóa sách (Ví dụ xóa B002)
    String removeId = "B002";
    arrayList.removeIf(b -> b.getId().equals(removeId));
    hashMap.remove(removeId);
    treeMap.remove(removeId);

    // 4. In danh sách
    System.out.println("--- ArrayList (Thứ tự thêm vào) ---");
    arrayList.forEach(System.out::println);

    System.out.println("\n--- HashMap (Thứ tự ngẫu nhiên) ---");
    hashMap.values().forEach(System.out::println);

    System.out.println("\n--- TreeMap (Sắp xếp theo ID) ---");
    treeMap.values().forEach(System.out::println);
  }
}