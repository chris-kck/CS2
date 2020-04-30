class HashTable 
{
   // hash table size
   int hashTableSize = 37;   

   // array to store items
   String [] hashTableArray;
   // for counting the number of additional comparisons due to collisions
   int collisions;
   
   // include additional functions specified by the user
   HashTableFunctions htf;
   
   // constructor
   public HashTable () 
   {
      hashTableArray = new String [hashTableSize];
      for ( int i=0; i<hashTableSize; i++ )
         hashTableArray[i] = "";
      collisions = 0;
      htf = new HashTableFunctions (hashTableSize, hashTableArray);
   }
   
   // return number of additional collision comparisons
   public int getCollisions ()
   { return collisions; }
   
   // stub to point to external function
   public int hash ( String s )
   {
      return htf.hash (s);
   }   
   
   // inserts string s into the hash table
   public void insert ( String s )
   {
      int h = hash (s);
      while (! hashTableArray[h].equals (""))
      {
         h = (h+1) % hashTableSize;
         collisions++;
      }
      hashTableArray[h] = s;
   }
   
   // stub to point to external function
   boolean find ( String s )
   {
      return htf.find (s);
   }
}
