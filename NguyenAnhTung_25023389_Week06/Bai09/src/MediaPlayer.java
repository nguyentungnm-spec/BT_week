class MediaPlayer {
    private final AudioPlayable audioPlayer;
    private final VideoPlayable videoPlayer;

    // Phụ thuộc được truyền từ bên ngoài vào (Dependency Injection)
    public MediaPlayer(AudioPlayable audio, VideoPlayable video) {
        this.audioPlayer = audio;
        this.videoPlayer = video;
    }

    public void startAudio(String fileName) {
        audioPlayer.playAudio(fileName);
    }

    public void startVideo(String fileName) {
        videoPlayer.playVideo(fileName);
    }
}