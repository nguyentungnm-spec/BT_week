// 4. Lớp Shortcut (Lối tắt)
class Shortcut implements FileSystemItem {
    private String name;
    private FileSystemItem target;
    private Folder rootRef; // Tham chiếu đến root để tính toán đường dẫn

    public Shortcut(String name, FileSystemItem target, Folder rootRef) {
        this.name = name;
        this.target = target;
        this.rootRef = rootRef;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void print(String indent) {
        // Giả sử đường dẫn bắt đầu từ root (không có parent của root)
        String targetPath = rootRef.getFullPath(target, "");
        System.out.println(indent + "Shortcut: " + name + " -> " + targetPath);
    }

    @Override
    public String getPath(String parentPath) {
        return parentPath + "/" + name;
    }
}