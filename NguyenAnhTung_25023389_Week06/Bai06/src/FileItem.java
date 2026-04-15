// 2. Lớp FileItem (Tệp tin)
class FileItem implements FileSystemItem {
    private String name;
    private int size;

    public FileItem(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + "KB)");
    }

    @Override
    public String getPath(String parentPath) {
        return parentPath + "/" + name;
    }
}