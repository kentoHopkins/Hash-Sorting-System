/**
 * DateHashTable class.
 * @author Kento Hopkins
 * @version 2024.02.20
 */
public class DateHashTable {
    private DatedEntry[] table;
    
     /**
     * Constructor, with a parameters, a date.
     * @param size size of array
     */
    public DateHashTable(int size) { 
        table = new DatedEntry[size];
    }

     /**
     * Check entry is exits in table or not.
     * @param entry DatedEntry
     * @return return entry is exist or not
     */
    boolean entryExists(DatedEntry entry)
    {
        if(entry != null){
            for(int i = 0; i < getTableSize(); i++){
                if(table[i] != null){
                    if (table[i].equals(entry)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
    * Store entry.
    * @param entry DatedEntry
    * @return either we can store entry or not.
    */
    boolean storeEntry(DatedEntry entry)
    {
        int position = hashKey(entry);
        if(position >= 0){
            addingToTable(entry, position);
            return true;
        }
        return false;
    }

    /**
    * Get entry from table.
    * @param keyDate date of entry
    * @return get entry if it's exist and return null if it's not.
    */
    DatedEntry getEntry(String keyDate)
    {
        for(int i = 0; i < getTableSize(); i++){
            if(table[i] != null){
                if(table[i].getDate().equals(keyDate)){
                    return table[i];
                }
            }
        }
        return null;
    }

    /**
    * Check table and return possible or existing hash key.
    * @param entry DatedEntry
    * @return hash key
    */
    int hashKey(DatedEntry entry)
    {
        if(entry != null){
            String entryDate = entry.getDate();
            if(entryDate != null){
                int month = entry.getMonth();
                int start = bucketStartIdx(month);
                int end = bucketEndIdx(month);
                for(int i = start; i <= end; i++){
                    if(!(table[i] == null)){
                        String tableDate = table[i].getDate();
                        if(tableDate.equals(entryDate)){
                            return i;
                        }
                    }
                }
                for(int j = start; j <= end; j++){
                    if (table[j] == null){
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    /**
    * Add entry to table.
    * @param d DatedEntry
    * @param index index of d in array
    */
    public void addingToTable(DatedEntry d, int index){
        table[index] = d;
    }

    /**
    * Return length of table.
    * @return length of table
    */
    int getTableSize(){
        return table.length;
    }
 
    /**
    * Return number of elements in table.
    * @return number of elements
    */
    int getNumElements(){
        int count = 0;
        for(int i = 0; i < getTableSize(); i++){
            if(!(table[i] == null)){
                count++;
            }
        }
        return count;
    }

    /**
    * Return number of elements that is in specific month.
    * @param month month that you want to see
    * @return number of elements that has month
    */
    int getNumElementsInMonth(int month)
    {
        int start = bucketStartIdx(month);
        int end = bucketEndIdx(month);
        int count = 0;
        for(int i = start; i <= end; i++){
            if(table[i] != null){
                count++;
            }
        }
        return count;
    }

    /**
    * Return bigging of index of month you are looking for.
    * @param month month that you want to see
    * @return bigging of index of month
    */
    int bucketStartIdx(int month)
    {
        return (month -1)* (getTableSize() / 12);
    }

    /**
    * Return end of index of month you are looking for.
    * @param month month that you want to see
    * @return end of index of month
    */
    int bucketEndIdx(int month){
        if(month==12){return getTableSize()-1;}
        else{
            return month* (getTableSize() / 12) -1;
        }
    }
}