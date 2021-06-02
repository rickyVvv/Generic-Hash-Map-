import java.lang.Math;
public class GenericHashMap<K,V> 
{
    private class Entry<K,V>
    {
        private K key;//my generic key
        private V value; //generic value
        private Entry<K,V> next; //my next
        public Entry(K key, V value){ //overloaded constructor
            this.key = key;
            this.value = value;
        }
        public K getkey(){
            return this.key;
        } //accessor

        public V getValue(){
            return this.value;
        } //accessor
        public void setValue(V value){
            this.value = value;
        }//mutator
    }
    private final int size = 11;//my final size of hashmap
    private Entry <K,V> table[]; //my default hashmap
    public GenericHashMap(){
        table = new Entry[size];
    } //default constructor
    public void put(K key, V value){ //my put function
        int hash = Math.abs(key.hashCode()) % size; //this is my collision handeler
        Entry<K,V>temp = table[hash]; // this is how i make my map
        if (temp == null){
            table[hash] = new Entry<K,V>(key,value);//if temp is empty make new entry
        }else{
            while(temp.next != null){
                String x = (String) temp.getkey();//find key
                String y = (String)key;//find other key
                if(x.compareTo(y) == 0){//compare
                    temp.setValue(value);//return key
                    return;
                }
                temp = temp.next;//look next until null
            }
            String x = (String) temp.getkey();
            String y = (String)key;
            if(x.compareTo(y) == 0){
                temp.setValue(value); //compare again until found 
                return;
            }
            temp.next = new Entry<K,V>(key,value);
        }

    }
    public V get(K key){//get function
        int hash = Math.abs(key.hashCode()) % size;//againt simple hash map formula
        Entry<K,V>temp = table[hash];//implementing it
        if (temp == null){
            return null; //if hashmap is null return null
        }
        while (temp != null ){
            String x = (String) temp.getkey();
            String y = (String)key;
            if (x.compareTo(y) == 0){ //while not null compare values
                return temp.getValue();
            }
            temp= temp.next;//go next until null or found our key

        }
        return null; //else just return null

    }
    public Entry <K,V> remove(K key) //remove
    {
        int hash = key.hashCode() % size; //same things
        Entry<K,V>temp = table[hash];
        if(temp == null){
            return null; //if it is null we have nothing to remove
        }
        if(temp.getkey() == key){ //keep looking for key until we find it
            table[hash] = temp.next; 
            temp.next = null;

        }
        Entry<K,V> previous = temp;
        temp = temp.next;
        while(temp != null){
            if(temp.getkey() == key){
                previous.next = temp.next; //when we find key our previous key equals our temp and our temp goes next
                temp.next = null;
                return temp; //we will return temp
            }

        }
        return null; //else we just return null


    }

}
