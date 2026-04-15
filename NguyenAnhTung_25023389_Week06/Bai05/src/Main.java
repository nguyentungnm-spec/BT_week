public class Main {
    public static void main(String[] args) {
        // 1. Kiểm tra Singleton
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Testing Singleton...");
        System.out.println("Are both loggers same? " + (logger1 == logger2));

        System.out.println("---");

        // 2. Kiểm tra Factory Method
        Export pdf = ExportFactory.getExport("PDF");
        pdf.exportFile();
        Export excel = ExportFactory.getExport("Excel");
        excel.exportFile();

        System.out.println("---");

        // 3. Kiểm tra Adapter
        OldPlayer oldSystem = new OldPlayer();
        Player adaptedPlayer = new PlayerAdapter(oldSystem);
        adaptedPlayer.play("music.mp3");

        System.out.println("---");

        // 4. Kiểm tra Prototype
        Configuration originalConfig = new Configuration("Dark Mode");
        Configuration copyConfig = originalConfig.clone();
        copyConfig.setTheme("Light Mode");

        System.out.println("Original Theme: " + originalConfig.getTheme());
        System.out.println("Cloned & Modified Theme: " + copyConfig.getTheme());
    }
}