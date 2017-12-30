
public class Simulator {

    // array created in this class
    // talk to the bst in the other class
    BST seekData = new BST();

    public static int x = decideSize();
    public static int[] array2 = new int[x];
   
    public static void main(String[] args) {

        Simulator sim = new Simulator();

        int x = 200000;//decideSize();
        int[] array4 = new int[x];
        BST<Integer> bst = new BST<Integer>();
        System.out.println("x = " + x);
        sim.inArray(array4, x);
       
        System.out.println("insert");
        for (Integer n : array4) {
            bst.insert(n);
        }
        System.out.println();
        System.out.println("x  = " + x);
        long g = System.currentTimeMillis();
        bst.postOrderTraversal();
        long h = System.currentTimeMillis();
        System.out.println();
        System.out.println("h = "+ h);
        long i = h-g;
        System.out.println("g = " + g);
        System.out.println("h = " + h);
        System.out.println(" h - g = " + i);
    }

    public static int decideSize() {

        int x = (int) Math.floor((Math.random() * 100000000) + 10000);
        return x;
    }

    // assigns an array a list of numbers best on the parameterized size
    public void inArray(int[] x, int size) {

        for (int i = 0; i < size; i++) {
            x[i] = (int) Math.floor((Math.random() * 100) + 1);
        }
    }

    public void printArray(int[] y, int size) {

        for (int i = 0; i < size; i++) {
           
            System.out.print(y[i] + " ");
        }
    }

}
