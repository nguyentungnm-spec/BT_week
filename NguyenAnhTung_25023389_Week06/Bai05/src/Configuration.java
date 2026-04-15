class Configuration implements Prototype {
    private String theme;

    public Configuration(String theme) { this.theme = theme; }

    public void setTheme(String theme) { this.theme = theme; }
    public String getTheme() { return theme; }

    @Override
    public Configuration clone() {
        return new Configuration(this.theme);
    }
}