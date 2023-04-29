package daily.ongoing.finished;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream_1656 {

    int ptr;
    int limit;
    String[] arr;
    //指针是从1开始哦
    public OrderedStream_1656(int n) {
        ptr = 1;
        limit = n;
        arr = new String[n+1];
    }

    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        arr[idKey] = value;
        if(ptr == idKey){
            res.add(value);
            ptr++;
            while(ptr<=limit && arr[ptr] != null){
                res.add(arr[ptr]);
                ptr++;
            }
        }
        return res;

    }
}
