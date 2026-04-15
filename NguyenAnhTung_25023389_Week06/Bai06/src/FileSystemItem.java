// 1. Định nghĩa Interface chung
interface FileSystemItem {
    void print(String indent);
    String getName();
    // Phương thức bổ trợ để lấy đường dẫn logic cho Shortcut
    String getPath(String parentPath);
}