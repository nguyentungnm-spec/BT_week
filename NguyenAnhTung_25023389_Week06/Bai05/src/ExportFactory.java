class ExportFactory {
    public static Export getExport(String type) {
        if (type.equalsIgnoreCase("PDF")) return new PdfExport();
        if (type.equalsIgnoreCase("Excel")) return new ExcelExport();
        return null;
    }
}