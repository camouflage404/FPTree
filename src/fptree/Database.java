
package fptree;

import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.text.ParseException;

/*********************
 * Sep 17, 2017         
 * 7:29:28 PM          
 * @author HOSNEARA    
 *********************/
class TransCompare implements Comparator<String>
{
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
}
class Database {
    HashMap<String,Integer> itemCount;
    TransCompare tc;
    TreeMap<String,Integer> sorted;
    ArrayList<ArrayList<String>> strlist;
    ArrayList<String> finList;
    List<Map.Entry<String,Integer>> SortedList;
    int len;
    
    Database()
    {
        itemCount = new HashMap<String, Integer>();
        strlist = new ArrayList<ArrayList<String>>();
        finList = new ArrayList<String>();
    }
    void getData(ArrayList<String> strs)
    {
        strlist.add(strs);
        len = strs.size();
        for(int i=0; i<len; i++)
        {
            if(itemCount.containsKey(strs.get(i)))
            {
                itemCount.replace(strs.get(i), itemCount.get(strs.get(i))+1);
            }
            else 
            {
                itemCount.put(strs.get(i), 1);
                //finList.add(strs.get(i));
            }
        }
    }
    void sort(ArrayList<String> items, ArrayList<String> finList)
    {
        ArrayList<String> baselist = items;
        //Set<String> keys = itemCount.keySet();
       // String[] base = keys.toArray(new String[keys.size()]);
        //System.out.println(finList);
        //Collections.sort(itemlist, new TransCompare());
        Collections.sort(items, new Comparator<String>(){
            public int compare(String i1, String i2)
            {
                //System.out.println(i1 + " " +i2 + "\t"+i1.compareTo(i2));
                return Integer.compare(finList.indexOf(i1), finList.indexOf(i2));
            }
        });
        System.out.println("Sorted: "+baselist);
    }
    
    void Print()
    {
        /*SortedSet<String> keys = new TreeSet<String>(itemCount.keySet());
        Set<Map.Entry<String,Integer>> entries = itemCount.entrySet();
        
        Comparator<Map.Entry<String, Integer>> valuecompare = new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String,Integer> e2){
               int v1 = e1.getValue();
               int v2 = e2.getValue();
               return v2-v1;
            }
        };
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entries);
        ArrayList<String> finList = new ArrayList<String>();
        Collections.sort(list,valuecompare);
        */
        //List<Map.Entry<String,Integer>> list = null;
        HashMapComparator hmc = new HashMapComparator(itemCount);
        SortedList = hmc.Compare();
        //System.out.println("---*** "+list.size());
        
        for(int i=0; i<SortedList.size(); i++)
        {
            finList.add(SortedList.get(i).getKey());
        }
        System.out.println("Hello "+finList);
        for(int i=0; i<strlist.size(); i++)
        {
            sort(strlist.get(i), finList);
        }
        //System.out.println(finList);
        System.out.println(itemCount.toString());
    }
}
