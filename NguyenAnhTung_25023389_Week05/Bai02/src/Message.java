// Lớp đại diện cho Tin nhắn
class Message {
    int id;
    String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}