package org.trie;

import java.io.IOException;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: trie [dictionary file]");
            return;
        }
        System.out.println("Reading words from dictionary...");
        Trie trie = Trie.createFromWordList(args[0], Charset.forName("ISO-8859-1"), new GermanTrieCharacterRange());
        System.out.println("Finished creating Trie containing " +  trie.getWordCount() + " words.");
    }
}
