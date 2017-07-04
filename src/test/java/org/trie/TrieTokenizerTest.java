package org.trie;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTokenizerTest {

    private Trie createTrie() {
        Trie trie = new Trie();
        trie.addWord("Fuss");
        trie.addWord("Fussball");
        trie.addWord("Fussboden");
        trie.addWord("Fussbodenheizung");
        trie.addWord("Boden");
        return trie;
    }

    @Test
    public void testStreamNoToken() {
        Trie trie = createTrie();
        String input = "äöü!";
        TrieTokenizer tokenizer = new TrieTokenizer(trie, input);
        List<Token> result = tokenizer.stream().collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testStreamMatchAll() {
        Trie trie = createTrie();
        String input = "fussbodenheizungbodenfussboden";
        TrieTokenizer tokenizer = new TrieTokenizer(trie, input);
        List<Token> result = tokenizer.stream().collect(Collectors.toList());
        assertEquals(3, result.size());
        assertEquals("fussbodenheizung", result.get(0).value);
        assertEquals("boden", result.get(1).value);
        assertEquals("fussboden", result.get(2).value);
    }

    @Test
    public void testStreamSkipUnknown() {
        Trie trie = createTrie();
        String input = "f44fbofbodefussbodenheizungfsdf12bodenfsddfussboden$%&";
        TrieTokenizer tokenizer = new TrieTokenizer(trie, input);
        List<Token> result = tokenizer.stream().collect(Collectors.toList());
        assertEquals(3, result.size());
        assertEquals("fussbodenheizung", result.get(0).value);
        assertEquals("boden", result.get(1).value);
        assertEquals("fussboden", result.get(2).value);
    }

}
