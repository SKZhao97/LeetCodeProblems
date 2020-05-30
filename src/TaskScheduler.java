/**
 * 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 * https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];

        int max = 0;
        int maxCount = 0;

        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int n = 2;
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(tasks, n));
    }
}
