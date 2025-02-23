class Trie {
    vector<Trie*> charMap = vector<Trie*>('z' - 'a' + 2, NULL);

public:
    Trie() {
        
    }
    
    void insert(string word) {
        Trie* node = this;
        for (auto c: word) {
            int idx = c - 'a';
            if (NULL == node->charMap[idx]) {
                node->charMap[idx] = new Trie();
            }

            node = node->charMap[idx];
        }

        // Use a specifie value to indicate a word ended here.  
        node->charMap['z' - 'a' + 1] = this; 
    }
    
    bool search(string word) {
        Trie* node = this;
        for (auto c: word) {
            int idx = c - 'a';
            if (NULL == node->charMap[idx]) {
                return false;
            }

            node = node->charMap[idx];
        }

        return this == node->charMap['z' - 'a' + 1];
    }
    
    bool startsWith(string prefix) {
        Trie* node = this;
        for (auto c: prefix) {
            int idx = c - 'a';
            if (NULL == node->charMap[idx]) {
                return false;
            }

            node = node->charMap[idx];
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