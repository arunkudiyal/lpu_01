import java.util.Scanner;

public class Trie {
    Node root;
    class Node {
        Node[] children = new Node[26];
        boolean eow;
        Node() {
            this.eow = false;
            for(int i=0; i < 26; i++)
                this.children[i] = null;
        }
    }
    Trie() {
        root = new Node();
    }
    public void insert(String s) {
        int n = s.length();
        Node temp = root;
        for(int level=0; level < n; level++) {
            int index = s.charAt(level) - 'a';
            if(temp.children[index] == null)
                temp.children[index] = new Node();
        }
        temp.eow = true;
    }
    public boolean lookUp(String s) {
        int index;
        int length = s.length();
        Node temp = root;
        for(int level=0; level < length; level++) {
            index = s.charAt(level) - 'a';
            if(temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return temp.eow;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        int n = sc.nextInt();
        String[] S = new String[n];
        for(int i=0; i < n; i++)
            S[i] = sc.next();
        for(int i=0; i < n; i++)
            trie.insert(S[i]);
        for(int i=0; i < n; i++)
            System.out.println( trie.lookUp(S[i]) );
        System.out.println(trie.lookUp("dog"));
    }
}
