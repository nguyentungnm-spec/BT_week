public class Main {
    public static void main(String[] args) {
        // Mô phỏng hiển thị theo yêu cầu bài tập
        System.out.println("Trước khi sửa:");
        System.out.println("\nError: show() in DataManager cannot implement show() in IData; "
                + "attempting to assign weaker access privileges; was public");

        System.out.println("---------------------------");

        System.out.println("Sau khi sửa:");
        DataManager dm = new DataManager();
        dm.show();
    }
}

interface IData {
    void show();
}

class DataManager implements IData {
    // Đã sửa lỗi bằng cách thêm public
    public void show() {
        System.out.println("\tShow Data");
    }
}