package org.trie;

public class Trie {

    final TrieNode root = new TrieNode('_');

    public void addWord(String word) {
        String lowercase = word.toLowerCase();
        TrieNode currentNode = root;
        TrieNode nextNode = null;
        int length = lowercase.length();
        for (int i = 0; i < length; i++) {
            char character = lowercase.charAt(i);
            int position =  character - 'a';
            nextNode = currentNode.children[position];
            if (nextNode == null) {
                nextNode = new TrieNode(character);
                currentNode.children[position] = nextNode;
            }
            if (i == length - 1) {
                nextNode.isLeaf = true;
            }
            currentNode = nextNode;
        }
    }
}
