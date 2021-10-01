public class Main
{
    public static void main(String[] args)
    {
        // initialize hash tables
        HashTableLinearProbe<Integer, Integer> hashTable = new HashTableLinearProbe<>();
        HashTableLinearProbe<String, Integer> hashTable2 = new HashTableLinearProbe<>();
        HashTableLinearProbe<String, String> hashTable3 = new HashTableLinearProbe<>();
        HashTableLinearProbe<Integer, String> hashTable4 = new HashTableLinearProbe<>();

        // output tests
        System.out.println("Key: Integer, Value: Integer");
        System.out.println("Insert: " + hashTable.insert(1, 11));
        System.out.println("Insert: " + hashTable.insert(3, 5));
        System.out.println("Insert: " + hashTable.insert(4, 6));
        System.out.println("Pre-Rehash (Prev Results)");
        hashTable.printStr();
        System.out.println(" ");

        System.out.println("Insert: " + hashTable.insert(3, 22) + ", Original key already exists - duplicates not allowed"); // original key already exists - duplicate not allowed
        System.out.println("Insert: " + hashTable.insert(7, 342));
        System.out.println("Post-Rehash");
        hashTable.printStr();
        System.out.println(" ");

        System.out.println("Delete: " + hashTable.delete(7));
        System.out.println("Delete: " + hashTable.delete(7) + ", Doesn't exist");
        System.out.println("Delete: " + hashTable.delete(111) + ", Doesn't exist");
        System.out.println("Post-Delete");
        hashTable.printStr();
        System.out.println(" ");

        System.out.println("Find: " + hashTable.find(7) + ", Doesn't exist");
        System.out.println("Find: " + hashTable.find(642) + ", Doesn't exist");
        System.out.println("Find: " + hashTable.find(1));
        System.out.println("Post-Find");
        hashTable.printStr();

        System.out.println("-------------------------------------------------------");

        System.out.println("Key: String, Value: Integer");
        System.out.println("Insert: " + hashTable2.insert("aasfwb", 11));
        System.out.println("Insert: " + hashTable2.insert("asd", 111));
        System.out.println("Insert: " + hashTable2.insert("ab", 22));
        System.out.println("Pre-Rehash (Prev Results)");
        hashTable2.printStr();
        System.out.println(" ");

        System.out.println("Insert: " + hashTable2.insert("djfg", 22));
        System.out.println("Insert: " + hashTable2.insert("djfg", 32) + ", Original key already exists - duplicates not allowed"); // original key already exists - duplicate not allowed
        System.out.println("Post-Rehash");
        hashTable2.printStr();
        System.out.println(" ");

        System.out.println("Delete: " + hashTable2.delete("asd"));
        System.out.println("Delete: " + hashTable2.delete("asd") + ", Doesn't exist");
        System.out.println("Delete: " + hashTable2.delete("asssd") + ", Doesn't exist");
        System.out.println("Post-Delete");
        hashTable2.printStr();
        System.out.println(" ");

        System.out.println("Find: " + hashTable2.find("asd") + ", Doesn't exist");
        System.out.println("Find: " + hashTable2.find("bfgshrhr") + ", Doesn't exist");
        System.out.println("Find: " + hashTable2.find("aasfwb"));
        System.out.println("Post-Find");
        hashTable2.printStr();
        System.out.println(" ");

        System.out.println("-------------------------------------------------------");

        System.out.println("Key: String, Value: String");
        System.out.println("Insert: " + hashTable3.insert("aasfwb", "11"));
        System.out.println("Insert: " + hashTable3.insert("asd", "asc"));
        System.out.println("Insert: " + hashTable3.insert("ab", "asd"));
        System.out.println("Pre-Rehash (Prev Results)");
        hashTable3.printStr();
        System.out.println(" ");

        System.out.println("Insert: " + hashTable3.insert("djfg", "asdw"));
        System.out.println("Insert: " + hashTable3.insert("djfg", "jdhy") + ", Original key already exists - duplicates not allowed"); // original key already exists - duplicate not allowed
        System.out.println("Post-Rehash");
        hashTable3.printStr();
        System.out.println(" ");

        System.out.println("Delete: " + hashTable3.delete("asd"));
        System.out.println("Delete: " + hashTable3.delete("asd") + ", Doesn't exist");
        System.out.println("Delete: " + hashTable3.delete("asssd") + ", Doesn't exist");
        System.out.println("Post-Delete");
        hashTable3.printStr();
        System.out.println(" ");

        System.out.println("Find: " + hashTable3.find("asd") + ", Doesn't exist");
        System.out.println("Find: " + hashTable3.find("dvdssb") + ", Doesn't exist");
        System.out.println("Find: " + hashTable3.find("aasfwb"));
        System.out.println("Post-Find");
        hashTable3.printStr();
        System.out.println(" ");

        System.out.println("-------------------------------------------------------");

        System.out.println("Key: Integer, Value: String");
        System.out.println("Insert: " + hashTable4.insert(53, "ab"));
        System.out.println("Insert: " + hashTable4.insert(1, "asc"));
        System.out.println("Insert: " + hashTable4.insert(29, "asd"));
        System.out.println("Pre-Rehash (Prev Results)");
        hashTable4.printStr();
        System.out.println(" ");

        System.out.println("Insert: " + hashTable4.insert(0, "asdw"));
        System.out.println("Insert: " + hashTable4.insert(0, "jdhy") + ", Original key already exists - duplicates not allowed"); // original key already exists - duplicate not allowed
        System.out.println("Post-Rehash");
        hashTable4.printStr();
        System.out.println(" ");

        System.out.println("Delete: " + hashTable4.delete(1));
        System.out.println("Delete: " + hashTable4.delete(1) + ", Doesn't exist");
        System.out.println("Delete: " + hashTable4.delete(101) + ", Doesn't exist");
        System.out.println("Post-Delete");
        hashTable4.printStr();
        System.out.println(" ");

        System.out.println("Find: " + hashTable4.find(1) + ", Doesn't exist");
        System.out.println("Find: " + hashTable4.find(99) + ", Doesn't exist");
        System.out.println("Find: " + hashTable4.find(0));
        System.out.println("Post-Find");
        hashTable4.printStr();
    }
}
