
package fptree;
import java.util.*;

/**
 * @author hosneara
 * @date Sep 20, 2017
 */
public class Transaction {
    String label;
    ArrayList<String> items;
    String str[];
    
    Transaction(String oneTransaction)
    {
        str = oneTransaction.split(" ");
        this.label = str[0];
        items = new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(str, 1, str.length)));
    }
    public String getLabel()
    {
        return this.label;
    }
    public ArrayList<String> getItems()
    {
        return this.items;
    }
}
