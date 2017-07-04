package org.trie;

class TrieNode {

    final TrieNode[] children;

    boolean isLeaf = false;

    final char value;

    TrieNode(char value, int maxPosition) {
        this.value = value;
        this.children = new TrieNode[maxPosition];
    }
}
