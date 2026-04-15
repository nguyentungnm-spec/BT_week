

1. LỖI XUẤT HIỆN KHI BIÊN DỊCH (TRƯỚC KHI SỬA)
Trình biên dịch sẽ báo lỗi tại dòng khai báo hàm show() trong lớp DataManager:
"show() in DataManager cannot implement show() in IData; 
attempting to assign weaker access privileges; was public"
Dịch nôm na: Bạn đang cố gắng gán một quyền truy cập yếu hơn (default) 
cho một phương thức vốn dĩ là công khai (public).

2. GIẢI THÍCH TẠI SAO
- Trong Interface (IData): Mọi phương thức khai báo không có modifier 
  đều được Java mặc định là 'public abstract'.
- Trong Class (DataManager): Khi bạn viết 'void show()', Java hiểu đây 
  là mức truy cập 'Default' (chỉ dùng được trong cùng package).
- QUY TẮC VÀNG: Khi ghi đè (Override), phương thức ở lớp con KHÔNG ĐƯỢC 
  phép có quyền truy cập hẹp hơn phương thức ở lớp cha/interface.
  (Sơ đồ quyền từ rộng đến hẹp: public > protected > default > private).
3. CÁCH SỬA LỖI
Thêm từ khóa 'public' vào trước hàm show() trong lớp DataManager.

----------------------- CODE HOÀN CHỈNH -----------------------

interface IData {
    void show(); // Mặc định là public abstract
}

class DataManager implements IData {
    // SỬA LỖI: Thêm từ khóa public ở đây
    @Override
    public void show() { 
        System.out.println("Show Data");
    }
}

---------------------------------------------------------------

4. KẾT QUẢ OUTPUT (SAU KHI SỬA)

Show Data

