import java.util.Stack;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {

        Main m = new Main();
        m.hanoi();

//        System.out.println((~((byte)0 | (byte)1))&0b00000011);
    }


    int size = 20;
    Stack<Disk>[] diskStack = new Stack[]{new Stack<Disk>(), new Stack<Disk>(), new Stack<Disk>()};



    public void hanoi() {
        for (int i = 0; i <= size; i++) {
            diskStack[0].push(new Disk(size - i));
        }


        shift((byte)0, (byte)2, size);

        while(!diskStack[2].isEmpty())
            System.out.println(diskStack[2].pop().size);
    }

    public void shift(byte source, byte target, int quantity) {
//        System.out.println("source " + source + " target " + target + " quantity " + quantity);
        if(quantity == 1) {
            diskStack[target].push(diskStack[source].pop());
            return;
        }


        shift(source, (byte) ((~(source | target))&0b00000011), quantity - 1);

        diskStack[target].push(diskStack[source].pop());

        shift((byte) ((~(source | target))&0b00000011), target, quantity - 1);
    }
    public class Disk {
        int size;

        public Disk(int size) {
            this.size = size;
        }
    }

    /*
    2 -> 1n -> 2c -> 1c
    3 -> (1-2)n -> 3c -> (1-2)c
    4 -> (1-3)n -> 4c -> (1-3)c

    */

}
