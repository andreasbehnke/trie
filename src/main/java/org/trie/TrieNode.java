package org.trie;

public class TrieNode {

    final TrieNode[] children = new TrieNode[26];

    boolean isLeaf = false;

    final char value;

    public TrieNode(char value) {
        this.value = value;
    }
}
