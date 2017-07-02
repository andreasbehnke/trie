package org.trie;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieTest {

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

        TrieNode leaf = trie.root.children['h' - 'a'].children['e' - 'a'].children['l' - 'a'].children['l' - 'a'].children['o' - 'a'];
        assertNotNull(leaf);
        assertTrue(leaf.isLeaf);
    }
}
