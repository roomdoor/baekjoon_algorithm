package guitar;

public class monariza {

    public static int[] mona = new int[4];
    public static boolean[] isChecked = new boolean[4];


    public static void makeMona(int depth) {

        if (depth == 4) {
            for (int i = 0; i < 4; i++) {
                System.out.print(mona[i] + " ");
            }
            System.out.println("\n");

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                mona[depth] = i + 1;
                makeMona(depth + 1);
                isChecked[i] = false;
            }
        }
    }


    public static void main(String[] args) {

        makeMona(0);

    }
}
