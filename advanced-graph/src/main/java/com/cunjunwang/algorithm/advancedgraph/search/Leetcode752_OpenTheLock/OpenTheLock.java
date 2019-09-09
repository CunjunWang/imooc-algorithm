package com.cunjunwang.algorithm.advancedgraph.search.Leetcode752_OpenTheLock;

import java.util.*;

/**
 * Created by CunjunWang on 2019-09-08.
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>();
        deadSet.addAll(Arrays.asList(deadends));
        if (deadSet.contains(target))
            return -1;
        if (deadSet.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;

        // 无权图最短路径, BFS
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        queue.add("0000");
        visited.put("0000", 0);
        while (!queue.isEmpty()) {
            String curs = queue.remove();

            // 从cur string出发, 找到后面的状态
            char[] curArray = curs.toCharArray();
            ArrayList<String> nexts = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                char o = curArray[i];
                curArray[i] = Character.forDigit((curArray[i] - '0' + 1) % 10, 10);
                nexts.add(new String(curArray));
                curArray[i] = o;

                curArray[i] = Character.forDigit((curArray[i] - '0' + 9) % 10, 10);
                nexts.add(new String(curArray));
                curArray[i] = o;
            }

            for (String next : nexts) {
                if (!deadSet.contains(next) && !visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next, visited.get(curs) + 1);

                    if (next.equals(target)) {
                        return visited.get(next);
                    }
                }
            }
        }

        return -1;
    }

}
