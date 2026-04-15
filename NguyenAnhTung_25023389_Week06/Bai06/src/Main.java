// 5. Chương trình chính
public class Main {
    public static void main(String[] args) {
        // Tạo thư mục gốc
        Folder root = new Folder("root");

        // Cấp 1: Thư mục docs và file readme
        Folder docs = new Folder("docs");
        FileItem readme = new FileItem("readme.md", 4);
        root.addItem(docs);
        root.addItem(readme);

        // Cấp 2: Các file trong docs
        FileItem fileA = new FileItem("a.txt", 12);
        FileItem fileB = new FileItem("b.txt", 8);
        docs.addItem(fileA);
        docs.addItem(fileB);

        // Tạo Shortcut trỏ đến file a.txt
        Shortcut shortcutA = new Shortcut("a-shortcut", fileA, root);
        docs.addItem(shortcutA);

        // In toàn bộ cấu trúc cây
        root.print("");
    }
}