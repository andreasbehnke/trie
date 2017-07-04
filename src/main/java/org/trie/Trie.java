package org.trie;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Trie {

    final TrieNode root;

    final TrieCharacterRange characterRange;

    public Trie() {
        this(new TrieCharacterRange() {});
    }

    public Trie(TrieCharacterRange characterRange) {
        this.characterRange = characterRange;
        this.root = new TrieNode('_', this.characterRange.size());
    }

    public void addWord(String word) {
        String lowercase = word.toLowerCase();
        TrieNode currentNode = root;
        TrieNode nextNode = null;
        int length = lowercase.length();
        for (int i = 0; i < length; i++) {
            char character = lowercase.charAt(i);
            int position =  characterRange.charToPosition(character);
            nextNode = currentNode.children[position];
            if (nextNode == null) {
                nextNode = new TrieNode(character, characterRange.size());
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
            if (position < 0 || position >= characterRange.size()) {
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

    public static Trie createFromWordList(String wordlistFile, Charset charset) throws IOException {
        Trie trie = new Trie();
        Files.lines(Paths.get(wordlistFile), charset).forEach(trie::addWord);
        return trie;
    }
}
