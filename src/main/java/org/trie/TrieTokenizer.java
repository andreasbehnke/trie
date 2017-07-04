package org.trie;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TrieTokenizer implements Spliterator<Token> {

    private final Trie trie;

    private final CharSequence input;

    private final int length;

    private int position = 0;

    public TrieTokenizer(Trie trie, CharSequence input) {
        this.trie = trie;
        this.input = input;
        this.length = input.length();
    }

    public Stream<Token> stream() {
        return StreamSupport.stream(this, false);
    }


    public boolean tryAdvance(Consumer<? super Token> consumer) {
        Token token = null;
        while (position < input.length() && token == null) {
            token = trie.search(input, position);
            position++;
        }
        if (token != null) {
            consumer.accept(token);
            position = token.end;
        }
        return position != length;
    }

    public Spliterator<Token> trySplit() {
        return null;
    }

    public long estimateSize() {
        return 0;
    }

    public int characteristics() {
        return 0;
    }
}
