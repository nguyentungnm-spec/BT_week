import java.util.ArrayList;
import java.util.List;
// 3. Lớp Folder (Thư mục)
class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addItem(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public String getName() { return name; }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem item : children) {
            item.print(indent + "  ");
        }
    }

    @Override
    public String getPath(String parentPath) {
        return parentPath + "/" + name;
    }

    // Hàm hỗ trợ tìm đường dẫn đầy đủ của một đối tượng trong cây (dùng cho Shortcut)
    public String getFullPath(FileSystemItem target, String currentPath) {
        String path = currentPath + "/" + this.name;
        if (this == target) return path;

        for (FileSystemItem item : children) {
            if (item == target) return path + "/" + item.getName();
            if (item instanceof Folder) {
                String found = ((Folder) item).getFullPath(target, path);
                if (found != null) return found;
            }
        }
        return null;
    }
}