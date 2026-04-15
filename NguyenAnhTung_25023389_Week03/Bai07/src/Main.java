import java.util.Scanner;

// Lớp trừu tượng đại diện cho một căn phòng
abstract class Room {
  protected int nights;
  protected long pricePerNight;

  public Room(int nights, long pricePerNight) {
    this.nights = nights;
    this.pricePerNight = pricePerNight;
  }

  // Phương thức trừu tượng để các lớp con tự định nghĩa logic tính tiền
  public abstract long calculateTotal();
}

// Lớp cho phòng Standard
class StandardRoom extends Room {
  public StandardRoom(int nights) {
    super(nights, 500000);
  }

  @Override
  public long calculateTotal() {
    long total = nights * pricePerNight;
    // Giảm giá 5% nếu ở trên 3 đêm
    if (nights > 3) {
      total = (long) (total * 0.95);
    }
    return total;
  }
}

// Lớp cho phòng VIP
class VIPRoom extends Room {
  public VIPRoom(int nights) {
    super(nights, 2000000);
  }

  @Override
  public long calculateTotal() {
    // Phòng VIP không giảm giá
    return nights * pricePerNight;
  }
}

// Lớp thực thi chương trình
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    if (sc.hasNext()) {
      String type = sc.next().toUpperCase();
      int nights = sc.nextInt();

      Room room = null;

      // Khởi tạo đối tượng dựa trên loại phòng nhập vào
      if (type.equals("S")) {
        room = new StandardRoom(nights);
      } else if (type.equals("V")) {
        room = new VIPRoom(nights);
      }

      // In kết quả
      if (room != null) {
        System.out.println(room.calculateTotal());
      }
    }
    sc.close();
  }
}