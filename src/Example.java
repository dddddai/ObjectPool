public class Example {
    public static void main(String[] args) {
        ObjectPool<String> pool=new ObjectPool<>() {
            @Override
            public String generate() {
                return "dwq";
            }
        };
        System.out.println(pool.get());
        pool.put("123");
        System.out.println(pool.get());
        System.out.println(pool.get());
        pool.put("123");
        System.gc();
        System.out.println(pool.get());
    }
}
