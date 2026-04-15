public class Main {
    public static void main(String[] args) {
        // Bước 1: Khởi tạo các player cụ thể
        AudioPlayable myAudio = new AudioPlayer();
        VideoPlayable myVideo = new VideoPlayer();

        // Bước 2: Truyền các đối tượng này vào MediaPlayer (DIP)
        MediaPlayer myMediaSystem = new MediaPlayer(myAudio, myVideo);

        // Bước 3: Vận hành hệ thống
        myMediaSystem.startAudio("Chung_Ta_Cua_Tuong_Lai.mp3");
        myMediaSystem.startVideo("Review_Phim_Hay.mp4");
    }
}