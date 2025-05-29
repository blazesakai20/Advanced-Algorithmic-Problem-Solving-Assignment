import java.util.*;
class RadixTree {
    static class Node {
        String label;
        boolean isWord;
        Map<Character, Node> children = new HashMap<>();

        Node(String label) {
            this.label = label;
        }
    }

    private Node root;

    public RadixTree() {
        root = new Node("");
    }

    public void insert(String word) {
        Node node = root;
        int index = 0;

        while (index < word.length()) {
            char currentChar = word.charAt(index);

            Node child = node.children.get(currentChar);
            if (child == null) {
                node.children.put(currentChar, new Node(word.substring(index)));
                node.children.get(currentChar).isWord = true;
                return;
            }

            String label = child.label;
            int i = 0;
            while (i < label.length() && index + i < word.length() && label.charAt(i) == word.charAt(index + i)) {
                i++;
            }

            if (i == label.length()) {
                node = child;
                index += i;
            } else {

                Node split = new Node(label.substring(i));
                split.children = child.children;
                split.isWord = child.isWord;

                child.label = label.substring(0, i);
                child.children = new HashMap<>();
                child.children.put(split.label.charAt(0), split);
                child.isWord = false;

                if (i + index == word.length()) {
                    child.isWord = true;
                } else {
                    Node newNode = new Node(word.substring(index + i));
                    newNode.isWord = true;
                    child.children.put(newNode.label.charAt(0), newNode);
                }
                return;
            }
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        int index = 0;

        while (index < word.length()) {
            char currentChar = word.charAt(index);
            Node child = node.children.get(currentChar);
            if (child == null) return false;

            String label = child.label;
            if (!word.startsWith(label, index)) return false;

            index += label.length();
            node = child;
        }

        return node.isWord;
    }

    public void displayAllWords() {
        display(root, "");
    }

    private void display(Node node, String prefix) {
        if (node.isWord) {
            System.out.println(prefix + node.label);
        }

        for (Node child : node.children.values()) {
            display(child, prefix + node.label);
        }
    }

    public static void main(String[] args) {
        RadixTree tree = new RadixTree();

        tree.insert("cat");
        tree.insert("car");
        tree.insert("cart");
        tree.insert("dog");
        tree.insert("dove");

        System.out.println("Words in Radix Tree:");
        tree.displayAllWords();

        System.out.println("\nSearch Results:");
        System.out.println("cart: " + tree.search("cart"));  
        System.out.println("car: " + tree.search("car"));    
        System.out.println("can: " + tree.search("can"));    
        System.out.println("dove: " + tree.search("dove"));  
    }
}