package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class leetcode841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 检查输入是否为空
        if (rooms == null || rooms.isEmpty()) {
            return false;
        }

        // 使用HashSet存储已收集的钥匙和待访问的房间
        HashSet<Integer> collectedKeys = new HashSet<>();
        HashSet<Integer> roomsToVisit = new HashSet<>();

        // 用于记录每个房间是否被访问过的数组
        boolean[] visited = new boolean[rooms.size()];

        // 初始化：将初始房间（假设为第0个房间）及其钥匙加入到待访问房间和已收集钥匙集合中
        roomsToVisit.addAll(rooms.get(0));
        collectedKeys.addAll(rooms.get(0));
        collectedKeys.add(0); // 添加初始房间的钥匙
        roomsToVisit.add(0); // 添加初始房间
        visited[0] = true; // 标记初始房间为已访问

        // 通过循环遍历待访问的房间，收集钥匙并扩展待访问的房间集合
        while (!roomsToVisit.isEmpty()) {
            int key = roomsToVisit.iterator().next();
            if (visited[key]) {
                roomsToVisit.remove(key);
                continue; // 跳过已经访问过的房间
            }

            // 获取当前房间可收集的钥匙，并将其加入到已收集的钥匙集合和待访问的房间集合中
            List<Integer> keysInRoom = rooms.get(key);
            collectedKeys.addAll(keysInRoom);
            roomsToVisit.addAll(keysInRoom);
            visited[key] = true; // 标记当前房间为已访问
        }

        // 检查是否访问了所有房间
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) {
                return false; // 如果有房间未被访问，则返回false
            }
        }

        // 判断是否收集了所有房间的钥匙（即是否访问了所有房间）
        boolean flag = collectedKeys.size() == rooms.size();
        return flag;
    }


    public static void main(String[] args) {

        leetcode841 solution = new leetcode841();

        // Test case 1: 所有房间都可以访问
        List<List<Integer>> rooms1 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList()
        );

        // Test case 2: 无法访问所有房间
        List<List<Integer>> rooms2 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList()
        );
        solution.canVisitAllRooms(rooms2);

    }

}
