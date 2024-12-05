class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        leftLess = [-1] * len(heights)
        stack = [[-1, -1]]
        for i in range(len(heights)):
            while stack[-1][1] >= heights[i]:
                stack.pop()
            leftLess[i] = stack[-1][0]
            stack.append([i, heights[i]])
        print(leftLess)

        rightLess = [len(heights)] * len(heights)
        stack = [[len(heights), -1]]
        for i in range(len(heights) - 1, -1, -1):
            while stack[-1][1] >= heights[i]:
                stack.pop()
            rightLess[i] = stack[-1][0]
            stack.append([i, heights[i]])
        print(rightLess)

        largest = 0
        for i in range(len(heights)):
            current = heights[i] * (rightLess[i] - leftLess[i] - 1)
            if largest < current:
                largest = current
        return largest

        '''
        largest = 0
        i = 0
        while i < len(heights):
            j = i - 1
            while 0 <= j and heights[i] <= heights[j]:
                j -= 1
            
            while len(heights) > i + 1 and heights[i] == heights[i + 1]:
                i += 1

            k = i + 1
            while len(heights) > k and heights[i] <= heights[k]:
                k += 1

            print(heights[i], k - j - 1)
            area = heights[i] * (k - j - 1)  
            if largest < area:
                largest = area

            i += 1

        return largest
        '''

        '''
        largest = 0
        minimium = min(heights)

        i = 0
        while len(heights) > i:
            while len(heights) > i and minimium == heights[i]:
                i += 1

            j = i

            while len(heights) > i and minimium < heights[i]:
                i += 1

            print(j, i)
            if (j < i):
                largest = max(largest, self.largestRectangleArea(heights[j: i]))
        
        largest = max(largest, minimium * len(heights))

        return largest
        '''