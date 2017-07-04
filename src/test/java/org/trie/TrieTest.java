package org.trie;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {

    private Trie createTrie() {
        Trie trie = new Trie();
        trie.addWord("Fuss");
        trie.addWord("Fussball");
        trie.addWord("Fussboden");
        trie.addWord("Fussbodenheizung");
        trie.addWord("Boden");
        return trie;
    }

    private void assertIsLeaf(Trie trie, String path) {
        TrieNode currentNode = trie.root;
        for (int i = 0; i < path.length(); i++) {
            int position = path.charAt(i) - 'a';
            currentNode = currentNode.children[position];
            assertNotNull(currentNode);
        }
        assertTrue(currentNode.isLeaf);
    }

    @Test
    public void testAddWord() {
        Trie trie = new Trie();
        trie.addWord("Hello");
        assertNull(trie.root.children['a' - 'a']);
        assertNull(trie.root.children['b' - 'a']);
        assertNull(trie.root.children['c' - 'a']);
        assertNull(trie.root.children['d' - 'a']);
        assertNull(trie.root.children['e' - 'a']);
        assertNull(trie.root.children['f' - 'a']);
        assertNull(trie.root.children['g' - 'a']);
        assertNotNull(trie.root.children['h' - 'a']);
        assertNull(trie.root.children['i' - 'a']);
        assertNull(trie.root.children['j' - 'a']);
        assertNull(trie.root.children['k' - 'a']);
        assertNull(trie.root.children['l' - 'a']);
        assertNull(trie.root.children['m' - 'a']);
        assertNull(trie.root.children['n' - 'a']);
        assertNull(trie.root.children['o' - 'a']);
        assertNull(trie.root.children['p' - 'a']);
        assertNull(trie.root.children['q' - 'a']);
        assertNull(trie.root.children['r' - 'a']);
        assertNull(trie.root.children['s' - 'a']);
        assertNull(trie.root.children['t' - 'a']);
        assertNull(trie.root.children['u' - 'a']);
        assertNull(trie.root.children['v' - 'a']);
        assertNull(trie.root.children['w' - 'a']);
        assertNull(trie.root.children['x' - 'a']);
        assertNull(trie.root.children['y' - 'a']);
        assertNull(trie.root.children['z' - 'a']);

        assertIsLeaf(trie, "hello");
    }

    @Test
    public void testAddMultipleWords() {
        Trie trie = createTrie();
        assertIsLeaf(trie, "fuss");
        assertIsLeaf(trie, "fussball");
        assertIsLeaf(trie, "fussboden");
        assertIsLeaf(trie, "fussbodenheizung");
        assertIsLeaf(trie, "boden");
    }

    @Test
    public void testAddIllegalCharacters() {
        Trie trie = new Trie();
        assertTrue(trie.addWord("abc"));
        assertFalse(trie.addWord("!$&"));
    }



    @Test
    public void testSearch() {
        Trie trie = createTrie();
        String input = "bodenblablabla";
        assertEquals("boden", trie.search(input, 0).value);
    }

    @Test
    public void testSearchNotFound() {
        Trie trie = createTrie();
        String input = "haus";
        assertEquals(null, trie.search(input, 0));
    }

    @Test
    public void testSearchFindLongestPrefix() {
        Trie trie = createTrie();
        String input = "fussbodenheizungbodenfussboden";
        Token token = trie.search(input, 0);
        assertEquals("fussbodenheizung", token.value);
        token = trie.search(input, token.end);
        assertEquals("boden", token.value);
        token = trie.search(input, token.end);
        assertEquals("fussboden", token.value);
    }

    @Test
    public void testSearchIllegalCharacter() {
        Trie trie = createTrie();
        String input = "äöü!";
        Token token = trie.search(input, 0);
        assertEquals(null, token);
    }
}
