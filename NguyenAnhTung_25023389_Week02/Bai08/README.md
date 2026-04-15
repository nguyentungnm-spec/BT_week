==========================================================================
BÀI 2.8: OBJECT REFERENCE VÀ GARBAGE COLLECTION
==========================================================================

1. TRẢ LỜI CÂU HỎI LÝ THUYẾT:
--------------------------------------------------------------------------
Câu 1: Sau khi setMe(p) có bao nhiêu đối tượng Person tồn tại?
Trả lời: Có DUY NHẤT 01 đối tượng Person. 
Giải thích: Lệnh "new Person" chỉ xuất hiện 1 lần. Lệnh setMe(p) chỉ copy 
địa chỉ của đối tượng đó vào biến "me" nằm bên trong chính nó.

Câu 2: Sau dòng lệnh p = null, đối tượng có bị xóa ngay lập tức không?
Trả lời: KHÔNG xóa ngay lập tức.
Giải thích: 
- JVM không xóa đối tượng ngay khi mất tham chiếu để tránh tốn hiệu năng.
- Garbage Collector (GC) sẽ đợi đến khi bộ nhớ gần đầy hoặc theo chu kỳ 
  quét của nó mới tiến hành thu dọn.
- Trong trường hợp này, đối tượng rơi vào trạng thái "Island of Isolation" 
  (Đảo cô lập) - nghĩa là các đối tượng trỏ vòng quanh nhau nhưng không 
  còn biến nào từ Stack trỏ tới chúng.

Câu 3: Đối tượng Person có thể được truy cập lại không?
Trả lời: KHÔNG.
Giải thích: Vì biến p (sợi dây duy nhất nối từ Stack vào Heap) đã bị cắt 
đứt (null), nên ta không còn cách nào để lấy lại địa chỉ của đối tượng đó.

--------------------------------------------------------------------------
2. SƠ ĐỒ BỘ NHỚ (STACK VÀ HEAP):
--------------------------------------------------------------------------

THỜI ĐIỂM 1: Trước khi p = null
(Biến p đang quản lý đối tượng)

      STACK (Biến cục bộ)              HEAP (Vùng nhớ đối tượng)
   +-----------------------+        +------------------------------+
   |  p [ Địa chỉ 0x101 ]--|------->| Person Object (Địa chỉ 0x101)|
   +-----------------------+        | - name: "Hoàng"              |
                                    | - me: [ Địa chỉ 0x101 ]      |
                                    |        ^           |         |
                                    |        +-----------+         |
                                    |        (Tự trỏ chính nó)     |
                                    +------------------------------+

--------------------------------------------------------------------------

THỜI ĐIỂM 2: Sau khi p = null
(Mất kết nối, tạo thành "Đảo cô lập")

      STACK (Biến cục bộ)              HEAP (Vùng nhớ đối tượng)
   +-----------------------+        +------------------------------+
   |  p [ NULL ]           |        | Person Object (Địa chỉ 0x101)|
   +-----------------------+        | - name: "Hoàng"              |
        (Mất liên kết)              | - me: [ Địa chỉ 0x101 ]      |
                                    |        ^           |         |
                                    |        +-----------+         |
                                    |  <-- Đang chờ GC dọn dẹp --> |
                                    +------------------------------+

==========================================================================