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
        /*
        sort(prerequisites.begin(), prerequisites.end());

        bool erased = true;
        while (erased) {
            erased = false;
            for (int i = 0; prerequisites.size() > i; i++) {
                int required = prerequisites[i][1];
                int j = 0, k = prerequisites.size();
                while (j < k) {
                    int m = (j + k) / 2;
                    if (required == prerequisites[m][0]) {
                        break;
                    }

                    if (required < prerequisites[m][0]) {
                        k = m;
                    } else {
                        j = m + 1;
                    }
                }

                if (j >= k) {
                    prerequisites.erase(prerequisites.begin() + i);
                    erased = true;
                }
            }
        }

        return 0 == prerequisites.size();
        */

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