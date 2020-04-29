// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<String extends Comparable<? super String>> extends BinaryTree<String>
{
   public int height ( BinaryTreeNode<String> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( BinaryTreeNode<String> node )
   {
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( BinaryTreeNode<String> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public BinaryTreeNode<String> rotateRight ( BinaryTreeNode<String> p )
   {
      BinaryTreeNode<String> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode<String> rotateLeft ( BinaryTreeNode<String> q )
   {
      BinaryTreeNode<String> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public BinaryTreeNode<String> balance ( BinaryTreeNode<String> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( String d )
   {  AVLApp.insertCount++;
      root = insert (d, root);
   }
   public BinaryTreeNode<String> insert ( String d, BinaryTreeNode<String> node )
   {
      if (node == null)
         return new BinaryTreeNode<String> (d, null, null);
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
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
      else
      {
         BinaryTreeNode<String> q = node.left;
         BinaryTreeNode<String> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<String> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }

   public BinaryTreeNode<String> findMin ( BinaryTreeNode<String> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode<String> removeMin ( BinaryTreeNode<String> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   public BinaryTreeNode<String> find ( String d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public BinaryTreeNode<String> find ( String d, BinaryTreeNode<String> node )
   {     String[] split= (String[]) node.data.toString().split(" ");
      if (d.compareTo (split[0]) == 0) {
         AVLApp.findCount++;
         return node;
      }
      else if (d.compareTo (split[0]) < 0) {
         AVLApp.findCount++;
         return (node.left == null) ? null : find(d, node.left);
      }
      else {
         AVLApp.findCount++;
         return (node.right == null) ? null : find(d, node.right);
      }
   }

   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode<String> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

