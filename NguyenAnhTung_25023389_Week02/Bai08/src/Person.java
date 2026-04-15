class Person {
    private String name;
    private Person me;

    public Person(String name) {
        this.name = name;
    }

    public void setMe(Person other) {
        this.me = other;
    }

    public Person getMe() {
        return this.me;
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        // 1. Khởi tạo đối tượng
        Person p = new Person("Hoàng");

        // 2. Set tham chiếu me đến chính nó (p)
        p.setMe(p);

        // 3. Truy cập và in tên thông qua me
        System.out.println("Tên truy cập qua me: " + p.getMe().getName());

        // 4. Set p = null
        p = null;
    }
}