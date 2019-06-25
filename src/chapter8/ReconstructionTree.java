package chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReconstructionTree {
    int size;
    List<Integer> preorder;
    List<Integer> inorder;
    List<Integer> postorder;
    int post;

    public ReconstructionTree(int n) {
        size = n;
        post = 0;
        postorder = new ArrayList<>();
    }

    public String getPostOrder(String preorder, String inorder) {
        this.preorder = splitOrder(preorder);
        this.inorder = splitOrder(inorder);
        reconstruct(0, size);
        return joinOrder(postorder);
    }

    void reconstruct(int left, int right) {
        if (left >= right) return;

        int root = preorder.get(post++);
        int middle = inorder.indexOf(root);

        reconstruct(left, middle);
        reconstruct(middle + 1, right);

        postorder.add(root);
    }

    List<Integer> splitOrder(String preorder) {
        return Stream.of(preorder.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    String joinOrder(List<Integer> postorder) {
        return postorder.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
