package Mock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Implementation {

    public int firstUnique(int[] arr){
        int ans = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int a: arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(value == 1) return key;
        }

        return 0;
    }

    public boolean containsDuplicate(int[] arr){

        HashSet<Integer> set = new HashSet<>();
        for(int a: arr){
            if(set.contains(a)) return true;
            set.add(a);
        }

        return false;
    }

    public String reverseWords(String s){


        String[] arr = s.split(" ");

        StringBuilder str = new StringBuilder();


        for(int i = arr.length-1; i >=0; i--){
            str.append(arr[i]);

            if (i != 0) {
                str.append(" ");
            }
        }

        return str.toString();
    }

    public int countElements(int[] arr, int k){
        int count = 0;

        for(int a: arr){
            if(a>k) count++;
        }

        return count;
    }

    public int OverlappingMeeting(int[][] meetings){
        int start = 0;
        int end = 0;
        int count = 0;

        for(int[] meeting : meetings){
            int currStart = meeting[0];
            int currEnd = meeting[1];

            if(start < currEnd){
                count++;
            }else{
                end = currEnd;
            }
            start = currStart;

        }
        return count;
    }
}
