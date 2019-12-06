package com.algorithm.qinchao.homework.week06;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/11/20 12:44
 * @description 字典树实现
 */
public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    class TrieNode {
        private TrieNode[] nodes;
        private int R = 26;
        private boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public TrieNode() {
            nodes = new TrieNode[R];
        }

        public void setEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }

        public TrieNode get(char ch) {
            return nodes[ch - 'a'];
        }

        public boolean containsKey(char ch) {
            return nodes[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            nodes[ch - 'a'] = node;
        }
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd(true);

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curLetter = prefix.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
