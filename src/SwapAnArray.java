import java.util.Arrays;

public class SwapAnArray {
    public static void main(String[] args) {
        int[] inputs = {0,1,3,5,23,3453,12,12,12};
        System.out.println(Arrays.toString(inputs));
        inputs = swapnumbers(inputs, 5,3);
        System.out.println(Arrays.toString(inputs));
    }

    private static int[] swapnumbers(int[] inputs, int i, int i1) {
        int temp = inputs[i];
        inputs[i] = inputs[i1];
        inputs[i1] = temp;
        return inputs;
    }
}
