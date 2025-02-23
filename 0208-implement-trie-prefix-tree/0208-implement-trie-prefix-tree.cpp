class Trie {
    unordered_map<char, Trie*> charMap;

public:
    Trie() {
        
    }
    
    void insert(string word) {
        Trie* node = this;
        for (auto c: word) {
            if (!node->charMap.contains(c)) {
                node->charMap[c] = new Trie();
            }

            node = node->charMap[c];
        }
        
        node->charMap['.'] = NULL; 
    }
    
    bool search(string word) {
        Trie* node = this;
        for (auto c: word) {
            if (!node->charMap.contains(c)) {
                return false;
            }

            node = node->charMap[c];
        }

        return node->charMap.contains('.');
    }
    
    bool startsWith(string prefix) {
        Trie* node = this;
        for (auto c: prefix) {
            if (!node->charMap.contains(c)) {
                return false;
            }

            node = node->charMap[c];
        }

        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */