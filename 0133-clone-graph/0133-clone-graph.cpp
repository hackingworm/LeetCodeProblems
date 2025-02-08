/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if (NULL == node) {
            return NULL;
        }

        map<int, Node*> m;
        queue<Node*> q, cq;

        Node* first = new Node(node->val);
        m[node->val] = first;
        cq.push(first);
        q.push(node);
        while (!q.empty()) {
            Node* orig = q.front();
            q.pop();
            Node* cloned = cq.front();
            cq.pop();
            for (auto neighbor: orig->neighbors) {
                if (!m.contains(neighbor->val)) {
                    Node* cNeighbor = new Node(neighbor->val);
                    m[neighbor->val] = cNeighbor;
                    cq.push(cNeighbor);
                    q.push(neighbor);
                }

                cloned->neighbors.push_back(m[neighbor->val]);
            }
        }

        return first;
    }
};