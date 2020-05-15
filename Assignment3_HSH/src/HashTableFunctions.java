class HashTableFunctions
{
   int hashTableSize;
   String [] hashTableArray;
   
   // constructor
   public HashTableFunctions ( int size, String [] array )
   {
      hashTableSize = size;
      hashTableArray = array;
   }

    // hash function
    public int hash ( String s )
   {

      int sum = 0;
      int hash = 0, i=0;
      int[] coeff={3,5,7,11,13};
      char[] temp=s.toCharArray();
      for (char data: temp){ //loop to use all characters
         hash+= data + coeff[i++%5]*(data<<2)  +  data*coeff[(i+2)%3];
         //make a very very big number then extract only MSB/ certain bits that are more unique.
         //hash += data<<2; //consider location of character in computation
      }
         //hash= hash^0xF; //randomize number
         sum= Math.abs(hash % hashTableSize);
         System.out.println(hash);
      return sum;
   }



   // return True if the hash table contains string s
   // return False if the hash table does not contain string s
   boolean find ( String s )
   {
      boolean found = false;

      for (String data: hashTableArray) {
         if (data.equals(s)){
            found=true;
            break;
         }
         else{ found=false; }
      }
      return found;
   }
}
