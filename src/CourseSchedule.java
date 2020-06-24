import java.util.ArrayList;
import java.util.List;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 * June 24th
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites == null) {
            return true;
        }
        int[] states = new int[numCourses];
        List<List<Integer>> courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            courses.get(item[0]).add(item[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(courses, i, states)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> courses, int start, int[] states) {
        if (states[start] != 0) {
            return states[start] == 1;
        }

        states[start] = 2;
        for (int course : courses.get(start)) {
            if (!dfs(courses, course, states)) {
                return false;
            }
        }
        states[start] = 1;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prereqisites = new int[][]{{1,0}};
        int numCourses = 2;
        System.out.println(courseSchedule.canFinish(numCourses, prereqisites));
    }
}
