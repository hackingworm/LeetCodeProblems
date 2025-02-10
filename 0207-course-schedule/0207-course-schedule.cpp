class Solution {
    class Course {
    public:
        int status;
        vector<Course*> prereqs;

        Course() {
            status = 0;
            prereqs = vector<Course*>();
        }
    };

    bool canFinish(Course *course) {
        course->status = 1;
        for (auto prereq: course->prereqs) {
            if (   0 == prereq->status && !canFinish(prereq)
                || 1 == prereq->status) {
                return false;
            }
        }

        course->status = 2;
        return true;
    }

public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        Course *courses = new Course[numCourses];

        for (auto prerequisite: prerequisites) {
            courses[prerequisite[0]].prereqs.push_back(&courses[prerequisite[1]]);
        }

        for (int i = 0; numCourses > i; i++) {
            if (0 == courses[i].status && !canFinish(&courses[i])) {
                return false;
            }
        }

        return true;
    }
};