import java.util.Stack;

public class Histogarm {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;

        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] widhths = {2, 8, 4, 6, 6, 9};
        int maxArea = largestRectangleArea(widhths);
        System.out.println("Largest rectangle area is: " + maxArea);
    }
}
