1. Lớp dữ liệu Book
Phần này định nghĩa cấu trúc của một đối tượng sách.

private String id;: Khai báo thuộc tính mã sách. Dùng private để đảm bảo tính đóng gói (encapsulation).

public Book(...): Đây là Constructor (hàm khởi tạo). Nó dùng để gán giá trị cho các thuộc tính ngay khi bạn tạo ra một đối tượng sách mới bằng từ khóa new.

public String getId(): Hàm Getter để lấy mã sách từ bên ngoài lớp, vì thuộc tính id đang để ở dạng private.

@Override public String toString(): Ghi đè phương thức mặc định của Java để khi bạn dùng lệnh System.out.println(book), nó sẽ in ra một chuỗi định dạng đẹp mắt thay vì mã hash khó hiểu.

2. Cài đặt hệ thống trong mainKhởi tạo các cấu trúc dữ liệuJavaList<Book> arrayList = new ArrayList<>();
Map<String, Book> hashMap = new HashMap<>();
Map<String, Book> treeMap = new TreeMap<>();
ArrayList: Một mảng động, lưu các đối tượng Book nối tiếp nhau.HashMap: Lưu trữ theo cặp Key - Value (Mã sách - Đối tượng sách). Không duy trì thứ tự.TreeMap: Giống HashMap nhưng các mã sách sẽ được tự động sắp xếp (thường là từ A-Z).Thêm sáchJavaarrayList.add(b);
hashMap.put(b.getId(), b);
treeMap.put(b.getId(), b);
add(b): Thêm phần tử vào cuối danh sách.put(key, value): Đẩy một cặp dữ liệu vào Map. Ở đây, ta lấy id làm chìa khóa để sau này tìm cho nhanh.Tìm kiếm sách theo IDVới ArrayList:Javafor (Book b : arrayList) {
    if (b.getId().equals(searchId)) { ... }
}
Dòng này chạy một vòng lặp từ đầu đến cuối mảng. Nó so sánh từng cái ID cho đến khi khớp. Nếu mảng có $n$ phần tử, nó có thể phải chạy $n$ lần (Độ phức tạp $O(n)$).Với Map (Hash/Tree):JavaBook found = hashMap.get(searchId);
Chỉ cần gọi hàm .get(). HashMap sẽ tính toán vị trí dựa trên mã ID và lấy ra ngay lập tức ($O(1)$).Xóa sáchJavaarrayList.removeIf(b -> b.getId().equals(removeId));
Đây là cách viết sử dụng Lambda Expression (Java 8+). Nó duyệt qua mảng, nếu cuốn sách nào có ID trùng với removeId thì sẽ bị xóa bỏ.JavahashMap.remove(removeId);
Xóa cực nhanh bằng cách tìm trực tiếp chìa khóa và loại bỏ cả cặp Key-Value.In danh sácharrayList.forEach(System.out::println);: Duyệt qua toàn bộ mảng và in từng cuốn theo thứ tự bạn đã thêm vào ban đầu.treeMap.values().forEach(...): Lấy toàn bộ giá trị (các cuốn sách) trong TreeMap và in ra. Bạn sẽ thấy danh sách này được tự động sắp xếp theo mã ID (ví dụ: B001, B002, B003...) dù lúc thêm vào bạn để thứ tự lộn xộn.

3. Tại sao phải dùng 3 loại này?
ArrayList: Dùng khi bạn chỉ muốn lưu danh sách đơn giản và thường xuyên truy cập theo số thứ tự (index).

HashMap: Dùng khi bạn có hàng triệu cuốn sách và muốn tìm một cuốn bất kỳ trong "nháy mắt".

TreeMap: Dùng khi bạn vừa muốn tìm nhanh, vừa muốn danh sách lúc nào cũng được sắp xếp ngăn nắp theo mã số.
