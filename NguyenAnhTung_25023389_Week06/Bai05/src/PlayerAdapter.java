// Adapter
class PlayerAdapter implements Player {
    private OldPlayer oldPlayer;

    public PlayerAdapter(OldPlayer oldPlayer) {
        this.oldPlayer = oldPlayer;
    }

    @Override
    public void play(String name) {
        oldPlayer.playFile(name); // Chuyển đổi lời gọi
    }
}