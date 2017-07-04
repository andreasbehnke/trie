package org.trie;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: trie [dictionary file]");
            return;
        }
        System.out.println("Reading words from dictionary...");
        Trie trie = Trie.createFromWordList(args[0], Charset.forName("ISO-8859-15"), new GermanTrieCharacterRange());


        System.out.println("Finished creating Trie containing " +  trie.getWordCount() + " words.");

        System.out.println("**********************************");

        System.out.println("Reading and matching input:");

        Files.readAllLines(Paths.get(args[1]), Charset.forName("ISO-8859-15")).stream()
                .flatMap(line -> new TrieTokenizer(trie, line).stream())
                .forEach(token -> System.out.println(token.toString()));

        System.out.println("Finished reading and matching input.");
    }
}
