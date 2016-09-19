public class Tester {
    public static void main(String[] args) {
        SingleLinkedList<String> test = new SingleLinkedList<>();

        test.add("Joao");
        test.add("Barbosa");
        test.add("LOVES");
        test.add("Christabel");

        System.out.println(test);

        test.add("Barrack");

        System.out.println(test);

        test.remove(4);

        System.out.println(test);

        test.remove(1);

        System.out.println(test);
    }
}
