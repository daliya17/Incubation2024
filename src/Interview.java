import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interview {
    public static void main(String[] args){
        System.out.println(getElements(List.of(1,4,3,8,7),7));
    }

    public static List<Integer> getElements(List<Integer> arr,int target){
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.size();i++){
            if(map.containsKey(target-arr.get(i)))
            {
                ans.add(target-arr.get(i));
                ans.add(arr.get(i));
            }
            else{
                map.put(arr.get(i),i);
            }
        }
        return ans;
    }
}
