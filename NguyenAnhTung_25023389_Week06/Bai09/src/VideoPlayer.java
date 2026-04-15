class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo(String file) {
        System.out.println("Đang phát video: " + file + " với độ phân giải 4K");
    }
}