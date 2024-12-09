class Solution:
    # Insert and keep order. Binary search is used to enhance performance 
    def insert(self, num: int, sorted: List[int]):
        begin = 0
        end = len(sorted)
        while begin < end:
            middle = (begin + end) // 2
            if num < sorted[middle]:
                begin = middle + 1
            elif num > sorted[middle]:
                end = middle
            else:
                begin = middle + 1
                end = middle

        sorted.insert(begin, num)

    def findKthLargest(self, nums: List[int], k: int) -> int:
        # This array is used to keep K largest numbers in 'nums' in descent order
        kLargests = []

        # Construct kLargests
        for num in nums:
            # If there're still not enough "largests" or the current element in 'nums' (num) is larger then the smallest "largests" (the last element in kLargests), then insert 'num' in kLargests, and keep its descent order.
            if k > len(kLargests) or kLargests[-1] < num:
                if k == len(kLargests):
                    # If kLargests is "full", pop up the smallest one
                    kLargests.pop()
                self.insert(num, kLargests)

        # Kth element in kLargest is just what wanted
        return kLargests[-1]