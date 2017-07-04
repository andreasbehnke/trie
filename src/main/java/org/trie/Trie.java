package org.trie;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Trie {

    final TrieNode root;

    private final TrieCharacterRange characterRange;

    private int wordCount = 0;

    public Trie() {
        this(new TrieCharacterRange() {});
    }

    public Trie(TrieCharacterRange characterRange) {
        this.characterRange = characterRange;
        this.root = new TrieNode('_', this.characterRange.size());
    }

    public boolean addWord(String word) {
        String lowercase = characterRange.prepare(word);
        TrieNode currentNode = root;
        TrieNode nextNode = null;
        int length = lowercase.length();
        for (int i = 0; i < length; i++) {
            char character = lowercase.charAt(i);
            int position =  characterRange.charToPosition(character);
            if (position < 0 || position > characterRange.size()) {
                return false;
            }
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
        wordCount++;
        return true;
    }

    public CharSequence prepareInput(CharSequence input) {
        return characterRange.prepare(input.toString());
    }

    public Token search(CharSequence input, int start) {
        TrieNode currentNode = root;
        int lastLeafNote = -1;
        for (int i = start; i < input.length(); i++) {
            int position = characterRange.charToPosition(input.charAt(i));
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

    public int getWordCount() {
        return wordCount;
    }

    public static Trie createFromWordList(String wordlistFile, Charset charset) throws IOException {
        return createFromWordList(wordlistFile, charset, new TrieCharacterRange() {});
    }

    private static void addWord(Trie trie, String word) {
        if (!trie.addWord(word)) {
            System.out.println("Could not add word to Trie: \"" + word + "\"");
        }
    }

    public static Trie createFromWordList(String wordlistFile, Charset charset, TrieCharacterRange characterRange) throws IOException {
        Trie trie = new Trie(characterRange);
        Files.lines(Paths.get(wordlistFile), charset).forEach(s -> addWord(trie, s));
        return trie;
    }

}
