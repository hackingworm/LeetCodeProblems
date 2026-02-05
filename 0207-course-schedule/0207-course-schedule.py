class Solution:
    def findPrerequisites(self, course: int) -> List[int]:
        res = []
        begin = 0
        end = len(self.prerequisites)
        while begin < end:
            middle = (begin + end) // 2
            if course < self.prerequisites[middle][0]:
                end = middle
                continue
            
            if course > self.prerequisites[middle][0]:
                begin = middle + 1
                continue

            while 0 <= middle and course == self.prerequisites[middle][0]:
                middle -= 1

            middle += 1

            while len(self.prerequisites) > middle and course == self.prerequisites[middle][0]:
                res.append(self.prerequisites[middle][1])
                middle += 1

            break

        return res

    def check(self, course) -> bool:
        if 2 == self.checked[course]:
            return True

        if 1 == self.checked[course]:
            return False

        self.checked[course] = 1
        prereqs = self.findPrerequisites(course)
        for prereq in prereqs:
            if not self.check(prereq):
                return False

        self.checked[course] = 2
        return True

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        self.prerequisites = sorted(prerequisites)
        self.checked = [0] * numCourses
        
        for i in range(numCourses):
            if not self.check(i):
                return False

        return True
        