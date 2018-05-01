package LeetCode;

import java.util.*;

/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
represent different tasks.Tasks could be done without original order. Each task could be done in one interval.
 For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

 */
public class TaskScheduler {

    /**
     *
     * We need to find the least number of intervals within which all the tasks can be scheduled.
     *
     * n - cooling time interval
     *

     1. Greedy - It’s obvious that we should always process the task which has largest amount left.
     2. Put tasks (only their counts are enough, we don’t care they are ‘A’ or ‘B’) in a PriorityQueue in descending order.
     3. Start to process tasks from front of the queue. If amount left > 0, put it into a coolDown HashMap
     4. If there’s task which cool-down expired, put it into the queue and wait to be processed.
     5. Repeat step 3, 4 till there is no task left.
     *
     */

    public static void main(String[] args) {

        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = new char[]{'A','A','A', 'B','B','B'};
        System.out.println(taskScheduler.leastInterval(tasks,2));
    }

    public int leastInterval(char[] tasks, int n) {

        if (n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> taskToCount = new HashMap<>();

        for (char c : tasks) {
            taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (char c : taskToCount.keySet()){
            queue.offer(taskToCount.get(c));
        }

        Map<Integer, Integer> coolDown = new HashMap<>();

        int currTime = 0;

        while (!queue.isEmpty() || !coolDown.isEmpty()) {

            if (coolDown.containsKey(currTime - n - 1)) {
                queue.offer(coolDown.remove(currTime - n - 1));
            }
            if (!queue.isEmpty()) {
                int left = queue.poll() - 1;
                if (left != 0){
                    coolDown.put(currTime, left);
                }
            }
            currTime++;
        }

        return currTime;
    }
}