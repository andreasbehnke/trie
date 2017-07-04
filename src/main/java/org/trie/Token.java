package org.trie;


public class Token {

    int start;

    int end;

    CharSequence value;

    public Token(int start, int end, CharSequence value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "start=" + start +
                ", end=" + end +
                ", value=" + value +
                '}';
    }
}
