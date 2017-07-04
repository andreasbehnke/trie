package org.trie;

public class TrieNode {

    public static final int MAX_POSITION = 26;

    final TrieNode[] children = new TrieNode[MAX_POSITION];

    boolean isLeaf = false;

    final char value;

    public TrieNode(char value) {
        this.value = value;
    }
}
