// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

public class BinarySearchTree<String extends Comparable<? super String>> extends BinaryTree<String>
{
   public void insert ( String d )
   {  LSArrayApp.insertCount++;
      if (root == null)
         root = new BinaryTreeNode<String> (d, null, null);
      else
         insert (d, root);
   }
   public void insert ( String d, BinaryTreeNode<String> node )
   {
      if (d.compareTo (node.data) <= 0)
      { LSArrayApp.insertCount++;
         if (node.left == null)
            node.left = new BinaryTreeNode<String> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<String> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
   public BinaryTreeNode<String> find ( String d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public BinaryTreeNode<String> find ( String d, BinaryTreeNode<String> node )
   {  String[] split= (String[]) node.data.toString().split(" ");

      if (d.compareTo (split[0]) == 0) {
         LSArrayApp.findCount++;
         return node;
      }
      else if (d.compareTo (split[0]) < 0) {
         LSArrayApp.findCount++;
         return (node.left == null) ? null : find(d, node.left);
      }
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   public void delete ( String d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode<String> delete ( String d, BinaryTreeNode<String> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
   public BinaryTreeNode<String> findMin ( BinaryTreeNode<String> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   public BinaryTreeNode<String> removeMin ( BinaryTreeNode<String> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
