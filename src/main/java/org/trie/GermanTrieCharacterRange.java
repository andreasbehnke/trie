package org.trie;

public class GermanTrieCharacterRange implements TrieCharacterRange {

    @Override
    public int size() {
        return 53;
    }

    @Override
    public int charToPosition(char c) {
        switch (c) {

            case 'ä':
                return 27;
            case 'å':
                return 28;
            case 'á':
                return 29;
            case 'à':
                return 30;
            case 'ã':
                return 31;
            case 'â':
                return 32;

            case 'ç':
                return 33;

            case 'é':
                return 34;
            case 'è':
                return 35;
            case 'ê':
                return 36;
            case 'ë':
                return 37;

            case 'í':
                return 38;
            case 'ì':
                return 39;
            case 'ï':
                return 40;
            case 'î':
                return 41;

            case 'ñ':
                return 42;

            case 'ö':
                return 43;
            case 'ó':
                return 44;
            case 'ò':
                return 45;
            case 'ô':
                return 46;
            case 'ø':
                return 47;

            case 'ü':
                return 48;
            case 'ú':
                return 49;
            case 'û':
                return 50;

            case 'æ':
                return 51;

            case 'ß':
                return 52;

            default:
                return c - 'a';
        }
    }
}