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

    public Token search(CharSequence input, int start) {
        TrieNode currentNode = root;
        int lastLeafNote = -1;
        for (int i = start; i < input.length(); i++) {
            int position = input.charAt(i) - 'a';
            if (position < 0 || position >= TrieNode.MAX_POSITION) {
                break;
            }
            currentNode = currentNode.children[position];
            if (currentNode == null) {
                break;
            }
            if (currentNode.isLeaf) {
                lastLeafNote = i;
            }
        }
        if (lastLeafNote == -1) {
            return null;
        } else {
            return new Token(start, lastLeafNote + 1 , input.subSequence(start, lastLeafNote + 1));
        }
    }
}
