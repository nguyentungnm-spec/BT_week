1. Kết quả dòng (A) là 10 hay 20? Tại sao?
Kết quả: 20

Giải thích:
Đây là minh chứng của cơ chế Dynamic Binding (Liên kết động) trong Java:

Về mặt lý thuyết: Khi bạn thực hiện MathUtils m = new AdvancedMath();, biến m có kiểu dữ liệu là MathUtils (lớp cha) nhưng đối tượng thực tế được tạo ra trong bộ nhớ là AdvancedMath (lớp con).

Khi chạy (Runtime): Java sẽ kiểm tra xem lớp con có Override phương thức đó không. Vì AdvancedMath đã override hàm sum(int, int), nên máy ảo Java (JVM) sẽ ưu tiên gọi hàm của lớp con.

Logic: 5 + 5 + 10 = 20.
2. Dòng (B) có lỗi không? Tại sao không gọi được?
Kết quả: Có lỗi biên dịch (Compile-time error).

Giải thích:
Lỗi này xảy ra do cách trình biên dịch (Compiler) kiểm tra cú pháp:

Kiểu của biến quyết định quyền truy cập: Biến m được khai báo là kiểu MathUtils. Trình biên dịch sẽ nhìn vào lớp MathUtils để xem có hàm nào nhận hai tham số double hay không.

Vấn đề: Trong lớp MathUtils chỉ có hàm sum(int, int). Hàm sum(double, double) chỉ xuất hiện ở lớp AdvancedMath.

Tại sao đối tượng là AdvancedMath mà không gọi được? Mặc dù đối tượng thực tế có khả năng tính double, nhưng vì bạn đang dùng "lăng kính" của MathUtils để nhìn đối tượng đó, bạn chỉ thấy được những gì MathUtils có.