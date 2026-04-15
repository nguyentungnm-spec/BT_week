class Task implements Runnable {
    private String name;
    private long durationMs;

    public Task(String name, long durationMs) {
        this.name = name;
        this.durationMs = durationMs;
    }

    @Override
    public void run() {
        System.out.println("Start " + name);
        try {
            // Tạm dừng luồng trong khoảng thời gian durationMs
            Thread.sleep(durationMs);
        } catch (InterruptedException e) {
            System.err.println(name + " bị ngắt quãng.");
        }
        System.out.println("End " + name);
    }
}