package daily.ongoing.finished;

import model.UnionFind;

import java.util.*;

public class AccountsMerge_721 {

    public static List<List<String>> run(List<List<String>> accounts){

        int cnt = accounts.size();
        List<List<String>> ans = new ArrayList<>();
        if(cnt==0) return ans;
        Map<String,Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        int emailCnt= 0;
        for(List<String> accs:accounts){
            String name = accs.get(0);
            int size = accs.size();
            for(int i=1;i<size;i++){
                String email = accs.get(i);
                if(!emailToIndex.containsKey(email)){
                    emailToIndex.put(email,emailCnt++);
                    emailToName.put(email,name);
                }
            }
        }

        UnionFind uf = new UnionFind(emailCnt);
        for(List<String> accs:accounts){
            String firstEmail = accs.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = accs.size();
            for(int i=2;i<size;i++){
                String currEmail = accs.get(i);
                int secondIndex = emailToIndex.get(currEmail);
                uf.union(firstIndex,secondIndex);
            }
        }
        Map<Integer,List<String>> indexToEmails = new HashMap<>();
        for(String email:emailToIndex.keySet()){
            int index = uf.find(emailToIndex.get(email));
            List<String> accs = indexToEmails.getOrDefault(index,new ArrayList<>());
            accs.add(email);
            indexToEmails.put(index,accs);
        }
        for(List<String> emails: indexToEmails.values()){
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> accs = new ArrayList<>();
            accs.add(name);
            accs.addAll(emails);
            ans.add(accs);

        }

        return ans;




    }




}
