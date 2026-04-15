public class Main {
    public static void main(String[] args) {
        // Giả sử tham số cấu hình nhận từ môi trường hoặc người dùng
        // Bạn có thể thay "win" thành "mac" để kiểm tra
        String config = "win";

        UIFactory factory;

        // Logic chọn Factory dựa trên tham số
        if (config.equalsIgnoreCase("win")) {
            factory = new WindowsFactory();
        } else if (config.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
        } else {
            System.out.println("Hệ điều hành không hỗ trợ.");
            return;
        }

        // Tạo và render các thành phần mà không cần quan tâm Factory cụ thể là gì
        Button btn = factory.createButton();
        Checkbox cb = factory.createCheckbox();

        btn.render();
        cb.render();
    }
}