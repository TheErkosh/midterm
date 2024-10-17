import java.util.*;

public class Main {
    public static void main(String[] args) {

        // BITWISE OPERATORS = special operators used in  a bit level programming ( knowing binary is important for this topic)

        // & = AND
        // | = OR
        // ^ = XOR
        // << LEFT SHIFT
        // >> RIGHT SHIFT

        int x = 6;  // 6 =  00000110
        int y = 12; // 12 = 00001100
        int z = 0;  // 0  = 00000000
        z = x & y;
        System.out.println("AND: "+ z);
        z = x | y;
        System.out.println("OR: "+z);
        z = x ^ y;
        System.out.println("XOR: "+z);
        z = x << 2;
        System.out.println("LEFT SHIFT: "+z);
        z = x >> 1;
        System.out.println("RIGHT SHIFT: "+z);


        int q = 20;
        int n = 3;

        System.out.println(q + " is binary "+Integer.toBinaryString(q));


        q = binary(q, n);
        System.out.println(q+" is binary "+ Integer.toBinaryString(q));







        int d = 120;
        if (EvenOrOdd(d)) {
            System.out.println(d+" is even");
        }
        else {
            System.out.println(d + " is odd");
        }


        System.out.println(addBinary("11", "1"));


        System.out.println(canFinish(2, new int[][]{{0, 1}, {1, 1}}));

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));

        ArrayList<Integer> integers = new ArrayList<>();

        int[] numbs = {-1,1,2,3,1};
        for (int numb : numbs) {
            integers.add(numb);

        }
        int target = 2;
        System.out.println(countPairs(integers, target));

    }

    public static boolean EvenOrOdd(int x) {
        return (x & 1) == 0;
    }

    public static int binary(int n, int k) {
        return n & ~(1 <<(k -1));
    }

    public static void prepareMidterm() {
        System.out.println("We wish you take 100 points");
    }

    public static String addBinary2(String a, String b) {
        StringBuilder result = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        while (indexA >= 0 || indexB >= 0 || carry > 0) {
            if (indexA >= 0) {
                carry += a.charAt(indexA) - '0';
                indexA--;
            }
            if (indexB >= 0) {
                carry += b.charAt(indexB) - '0';
                indexB--;
            }
            result.append(carry % 2);
            carry /= 2;
        }
        return result.reverse().toString();
    }


    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        while (indexA >= 0 || indexB >= 0 || carry > 0) {
            if (indexA >= 0) {
                carry += a.charAt(indexA) - '0';
                indexA--;
            }
            if (indexB >= 0) {
                carry += b.charAt(indexB) - '0';
                indexB--;
            }
            result.append(carry % 2);
            carry /= 2;
        }
        return result.reverse().toString();
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int i, tmp, size = prerequisites.length;
        int[] counter = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        for (i = 0; i < size; i++) {
            counter[prerequisites[i][0]]++;
        }
        for (i = 0; i < numCourses; i++) {
            if (counter[i] == 0) q.add(i);
        }
        int num = q.size();
        while (!q.isEmpty()) {
            tmp = q.remove();
            for (i = 0; i < size; i++) {
                if (prerequisites[i][1] == tmp) {
                    counter[prerequisites[i][0]]--;
                    if (counter[prerequisites[i][0]] == 0) {
                        num++;
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return num == numCourses;
    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0]; // No courses to take

        // Step 1: Initialize the graph and in-degree tracker
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());  // Initialize adjacency lists
        }

        // Step 2: Build the graph and calculate in-degrees
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);  // Add course to the pre req’s list
            inDegree[course]++;             // Increment in-degree of the course
        }

        // Step 3: Add all courses with 0 in-degree to the queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        // Step 4: Process the queue to determine the course order
        int[] courseOrder = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseOrder[index++] = currentCourse;

            // Reduce the in-degree of all adjacent courses
            for (int nextCourse : graph.get(currentCourse)) {
                if (--inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);  // Add to queue if in-degree is 0
                }
            }
        }

        // Step 5: Verify if all courses are processed (no cycles)
        return index == numCourses ? courseOrder : new int[0];
    }

    public static int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if ((0 <= nums.get(i) && nums.get(i) < nums.get(j) && nums.get(j) < nums.size()) && (nums.get(i) + nums.get(j) < target)) {
                    count++;
                }
            }
        }
        return count;
    }


}