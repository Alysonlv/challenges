package corp.alv.challenges.general.graphs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        for (int room = 0; room < rooms.size(); room++) {
            if (seen.contains(room)) {
                dfs(rooms, room, seen);
            }
        }

        return seen.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int currentKey, Set<Integer> seen) {
        for (int keyInsideRoom : rooms.get(currentKey)) {
            if (seen.contains(keyInsideRoom)) {
                continue;
            }
            seen.add(keyInsideRoom);
            dfs(rooms, keyInsideRoom, seen);
        }
    }

    public static void main(String[] args) {
        KeysAndRooms kr = new KeysAndRooms();
        List<List<Integer>> roomsKeys = new ArrayList<>();
//        roomsKeys.add(Arrays.asList(1, 3));
//        roomsKeys.add(Arrays.asList(1, 4));
//        roomsKeys.add(Arrays.asList(2, 3, 4, 1));
//        roomsKeys.add(new ArrayList<>());
//        roomsKeys.add(Arrays.asList(4, 3, 2));

        roomsKeys = new ArrayList<>();
        roomsKeys.add(Arrays.asList(1));
        roomsKeys.add(Arrays.asList(2));
        roomsKeys.add(Arrays.asList(3));
        roomsKeys.add(new ArrayList<>());
        System.out.println(kr.canVisitAllRooms(roomsKeys));

        roomsKeys = new ArrayList<>();
        roomsKeys.add(Arrays.asList(1, 3));//0
        roomsKeys.add(Arrays.asList(3, 0, 1));//1
        roomsKeys.add(Arrays.asList(2));//2
        roomsKeys.add(Arrays.asList(0));//3


        System.out.println(kr.canVisitAllRooms(roomsKeys));
    }
}
