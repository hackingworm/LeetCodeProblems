class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        leftLess = [-1] * len(heights)
        stack = [[-1, -1]]
        for i in range(len(heights)):
            while stack[-1][1] >= heights[i]:
                stack.pop()
            leftLess[i] = stack[-1][0]
            stack.append([i, heights[i]])
        #print(leftLess)

        rightLess = [len(heights)] * len(heights)
        stack = [[len(heights), -1]]
        for i in range(len(heights) - 1, -1, -1):
            while stack[-1][1] >= heights[i]:
                stack.pop()
            rightLess[i] = stack[-1][0]
            stack.append([i, heights[i]])
        #print(rightLess)

        largest = 0
        for i in range(len(heights)):
            current = heights[i] * (rightLess[i] - leftLess[i] - 1)
            if largest < current:
                largest = current
        return largest