package lab;

public class Main {
    public static void main(String[] args) {
        FlagsSet flagsSet = new BitsArray();
        flagsSet.set(4);
        flagsSet.set(8);
        flagsSet.set(15);
        flagsSet.set(16);
        flagsSet.set(23);
        flagsSet.set(42);
        flagsSet.flip(10);
        flagsSet.flip(11);

        System.out.println(flagsSet.count());
        System.out.println(flagsSet.toString().substring(0, 45));

        flagsSet.clear(4);
        flagsSet.clear(8);
        flagsSet.set(7, true);

        System.out.println(flagsSet.count());
        System.out.println(flagsSet.toString().substring(0, 45));
        System.out.println(flagsSet.get(1));
        System.out.println(flagsSet.get(7));

    }
}
