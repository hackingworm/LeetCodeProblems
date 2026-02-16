class LRUCache:
    class Node:
        pass

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.allocated = 0
        self.head = None
        self.map = {}

    def move2end(self, node: Node) -> None:
        if self.head == node:
            self.head = self.head.next
            return

        node.next.prev = node.prev
        node.prev.next = node.next

        node.next = self.head
        node.prev = node.next.prev
        node.next.prev = node
        node.prev.next = node

    def get(self, key: int) -> int:
        node = self.map.get(key)
        if node == None:
            return -1

        self.move2end(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        node = self.map.get(key)
        if node == None:
            if self.capacity > self.allocated:
                self.allocated += 1
                node = self.Node()
                if None == self.head:
                    self.head = node.next = node.prev = node
                else:
                    node.next = self.head
                    node.prev = node.next.prev
                    node.next.prev = node
                    node.prev.next = node
            else:
                node = self.head
                self.map.pop(node.key)
                self.head = self.head.next

            self.map[key] = node
            node.key = key
        else:
            self.move2end(node)

        node.value = value
        
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)