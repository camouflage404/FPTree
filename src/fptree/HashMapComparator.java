
package fptree;
import java.util.*;

/**
 * @author hosneara
 * @date Sep 21, 2017
 */

/* 
* Descending Order
*/
public class HashMapComparator {
    SortedSet<String> keys = null;
    Set<Map.Entry<String,Integer>> entries = null;
    List<Map.Entry<String,Integer>> list = null;
    
    HashMapComparator(HashMap<String, Integer> itemCount)
    {
        keys = new TreeSet<String>(itemCount.keySet());
        entries = itemCount.entrySet();
        list = new ArrayList<Map.Entry<String, Integer>>(entries);
    }
    List<Map.Entry<String,Integer>> Compare()
    {
        Comparator<Map.Entry<String, Integer>> valuecompare = new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String,Integer> e2){
               int v1 = e1.getValue();
               int v2 = e2.getValue();
               return v2-v1;
            }
        };
        
        Collections.sort(this.list,valuecompare);
       // System.out.println("--- "+list);
        return this.list;
    }
}
