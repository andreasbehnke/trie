package org.trie;

public interface TrieCharacterRange {

    default int size() {
        return 26;
    }

    default int charToPosition(char c) {
        return  c - 'a';
    }

}
