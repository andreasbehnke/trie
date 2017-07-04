package org.trie;

public interface TrieCharacterRange {

    default int size() {
        return 26;
    }

    default String prepare(String input) {
        return input.trim().toLowerCase();
    }

    default int charToPosition(char c) {
        return  c - 'a';
    }

}
