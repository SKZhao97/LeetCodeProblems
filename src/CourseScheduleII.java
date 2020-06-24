import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 * June 24th
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) {
            return new int[0];
        }

        List<List<Integer>> courses = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] states = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        for (int[] course : prerequisites) {
            courses.get(course[0]).add(course[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(courses, i, states, ans)) return new int[0];
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for (int item : ans) {
            res[i++] = item;
        }
        return res;
    }

    public boolean dfs (List<List<Integer>> courses, int start, int[] states, List<Integer> ans) {
        if(states[start] != 0) return states[start] == 1;
        states[start] = 2;
        for (int i = 0; i < courses.get(start).size(); i++) {
            if (!dfs(courses, courses.get(start).get(i), states, ans)) return false;
        }
        states[start] = 1;
        ans.add(start);
        return true;
    }

    public static void main(String[] args) {
        int[][] courses = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int numCourse = 4;
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        System.out.println(Arrays.toString(courseScheduleII.findOrder(numCourse, courses)));
    }
}
