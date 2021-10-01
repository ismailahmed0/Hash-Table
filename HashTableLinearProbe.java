public class HashTableLinearProbe <K,V>
{
    private int size;
    private int elements;
    private HashEntry<K,V> hashtable[];

    // constructor - initialize class
    public HashTableLinearProbe()
    {
        size = 3;
        hashtable = new HashEntry[size];
        elements = 0;
    }

    // nested hash entries class - creates hash entries for each element in hash table
    private static class HashEntry<K,V>
    {
        K key;
        V value;
        boolean deleted;

        // constructor - initialize class
        HashEntry(K key, V value)
        {
            this.key = key;
            this.value = value;
            deleted = false;
        }
    }
    
    public boolean insert(K key, V value) throws IllegalArgumentException
    {
        int hashedValue;
        int count = 0;

        if (!(key instanceof Integer) && !(key instanceof String) || key == null)
        {
            throw new IllegalArgumentException("Invalid key");
        }

        if (elements == size) // rehash if table full
        {
            rehash();
        }

        if (find(key) == null) // insert into HT if there won't be a duplicate key
        {
            hashedValue = getHashValue(key); // maps the key to an index of the hash table array

            for (int i = hashedValue; count != 2; i++) // starting from hashed value index insert into HT where 1st free space
            {
                if (hashtable[i] == null) // if cell empty, add value
                {
                    hashtable[i] = new HashEntry<>(key, value); // insert into HT
                    elements++;
                    return true; // successful entry
                }

                if (i == (size-1)) // if at end of HT go back to beginning to continue search there
                {
                    i = -1; // to account for i++
                }

                // so don't have to go through parts checked/HT over and over again, for first time and last time
                if (i == hashedValue || (i+1) == hashedValue)
                {
                    count++;
                }
            }
        }

        return false; // unsuccessful entry i.e. duplicate entry
    }

    public V find (K key)
    {
        if (!(key instanceof Integer) && !(key instanceof String) || key == null)
        {
            throw new IllegalArgumentException("Invalid key");
        }

        int hashedValue = getHashValue(key); // maps the key to an index of the hash table array
        int count = 0;

        if (elements == 0) // if hash table empty, return null
        {
            return null;
        }

        for (int i = hashedValue; count != 2; i++) // starting from hashed value index insert into HT where 1st free space
        {
            if (i >= size) // so index won't be out of bounds for hash table
            {
                break;
            }
            if (hashtable[i] != null) // if there is an element in the hash table
            {
                if ((hashtable[i].key).equals(key) && hashtable[i].deleted == false) // if key exists
                {
                    return hashtable[i].value;
                }

                if (i == (size-1)) // if at end of HT go back to beginning
                {
                    i = -1; // to account for i++
                }

                // so don't have to go through parts checked/HT over and over again, for first time and last time
                if (i == hashedValue || (i+1) == hashedValue)
                {
                    count++;
                }
            }
            else // go to next index if there isn't an element for this one
            {
                // so don't have to go through parts checked/HT over and over again, for first time and last time
                if (i == hashedValue || (i+1) == hashedValue)
                {
                    count++;
                }
                continue;
            }
        }

        return null; // no key exists
    }

    public boolean delete(K key)
    {
        if (!(key instanceof Integer) && !(key instanceof String) || key == null)
        {
            throw new IllegalArgumentException("Invalid key");
        }

        int hashedValue = getHashValue(key); // maps the key to an index of the hash table array
        int count = 0; // to make sure go through hash table one time and not unnecessarily more

        if (elements == 0) // if no element in hash table
        {
            return false;
        }

        for (int i = hashedValue; count != 2; i++) // starting from hashed value index insert into HT where 1st free space
        {
            if (i >= size) // so index won't be out of bounds for hash table
            {
                break;
            }
            if (hashtable[i] != null) // if there is an element in the hash table
            {
                if ((hashtable[i].key).equals(key) && hashtable[i].deleted == false) // if key exists
                {
                    hashtable[i].deleted = true; // lazy delete
                    return true; // successful deletion
                }

                if (i == (size-1)) // if at end of HT go back to beginning
                {
                    i = -1; // to account for i++
                }

                // so don't have to go through parts checked/HT over and over again, for first time and last time
                if (i == hashedValue || (i+1) == hashedValue)
                {
                    count++;
                }
            }
            else
            {
                // so don't have to go through parts checked/HT over and over again, for first time and last time
                if (i == hashedValue || (i+1) == hashedValue)
                {
                    count++;
                }
                continue;
            }
        }

        return false; // unsuccessful deletion i.e. doesn't exist(already deleted, never was in HT)
    }

    public int getHashValue(K key)
    {
        if (!(key instanceof Integer) && !(key instanceof String) || key == null)
        {
            throw new IllegalArgumentException("Invalid key");
        }

        if (key instanceof Integer) // if key is an Integer object
        {
            int k = (Integer)key; // cast Integer generic object to primitive int

            k = k % size; // convert key to index of hash table

            return k; // return hashed value index

        }
        else if (key instanceof String) // if key is an String object
        {
            String s = (String)key; // cast String generic object to String object
            int sum = 0;

            for (int i = 0; i < s.length(); i++) // sum of the individual ASCII characters in the string
            {
                char character = s.charAt(i);
                sum += (int) character;
            }

            return (sum % size);
        }

        return -1; // not found
    }

    private void rehash()
    {
        int tSize = size;
        size = size * 2;
        size = primeNum(size); // get closest prime to doubled size
        HashEntry<K,V> newHT[] = new HashEntry[size]; // a new temp hash table

        for (int j = 0; j < tSize; j++) // for each element in the original hash table
        {
            if (hashtable[j] != null && hashtable[j].deleted == false) // if element in hash table "exists"
            {
                int hashedValue = getHashValue(hashtable[j].key); // maps the hash table key to an index of the new hash table array
                int count = 0;

                for (int i = hashedValue; count != 2; i++) // starting from hashed value index insert into HT where 1st free space
                {
                    if (newHT[i] == null) // if cell empty add value
                    {
                        newHT[i] = hashtable[j]; // copy over the key,value into the new array
                        break;
                    }
                    if (i == (size-1)) // if at end of HT go back to beginning
                    {
                        i = -1; // to account for i++
                    }

                    // so don't have to go through parts checked/HT over and over again, for first time and last time
                    if (i == hashedValue || (i+1) == hashedValue)
                    {
                        count++;
                    }
                }
            }
        }

        hashtable = newHT; // have the original hash table reference the new hash table
    }

    private int primeNum(int s)
    {
        for (int i = 2; i < s; i++) // check all numbers before it to see if they multiples of it to determine prime or not
        {
            if ((s % i) == 0) // if it is not prime
            {
                i = 2; // reset to start from beginning
                s++; // onto next number
            }
        }

        return s;
    }

    public void printStr()
    {
        for (int i = 0; i < size; i++) // go through each element in the hash table
        {
            if (hashtable[i] != null && hashtable[i].deleted == false) // if index  in hash table has an element and it exists
            {
                System.out.print("Index " + i + ": "); // index count
                System.out.print(hashtable[i].key + " ");
                System.out.println(hashtable[i].value);
            }
            else if (hashtable[i] == null) // if index does not have element in it at all
            {
                System.out.println("Index " + i + ": Empty");
            }
            else if (hashtable[i].deleted == true) // if index has an element that has been "deleted"
            {
                System.out.println("Index " + i + ": Deleted");
            }
        }
    }
}