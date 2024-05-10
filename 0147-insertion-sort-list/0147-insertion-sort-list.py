# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        newHead = ListNode()
        newHead.next = head
        head = head.next
        newHead.next.next = None
        #print(newHead.next)
        
        while head:
            #print(head)
            before = newHead
            after = newHead.next
            while after and head.val >= after.val:
                before = before.next
                after = after.next

            #print(newHead.next)
        
            before.next = head
            head = head.next
            before.next.next = after

        return newHead.next