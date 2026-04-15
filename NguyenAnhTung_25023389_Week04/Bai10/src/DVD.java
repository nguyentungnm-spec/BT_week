class DVD extends MediaItem {
    private String director;
    private int duration;

    public DVD(String id, String title, String director, int duration) {
        super(id, title);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        System.out.println("Đĩa DVD: " + getTitle() + " - Đạo diễn: " + director + " - Thời lượng: " + duration + " phút");
    }
}