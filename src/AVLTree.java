// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<Vaccine extends Comparable<? super Vaccine>> extends BinaryTree<Vaccine>{

   public int searchOpCount = 0;
   public int insertOpCount = 0;

   public int height (BinaryTreeNode<Vaccine> node){
      if (node != null)
         return node.height;
      return -1;
   }
   
   // Caclulating the Balance Factor 
   public int balanceFactor (BinaryTreeNode<Vaccine> node){
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( BinaryTreeNode<Vaccine> node ){
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   //Rotate Right Function
   public BinaryTreeNode<Vaccine> rotateRight ( BinaryTreeNode<Vaccine> p ){
      BinaryTreeNode<Vaccine> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   //Rotate Left Function
   public BinaryTreeNode<Vaccine> rotateLeft ( BinaryTreeNode<Vaccine> q ){
      BinaryTreeNode<Vaccine> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   // Balance Function - that balances a binary tree to ensure it meets an AVL tree's requirements 
   // makes use of the rotate functions above 
   public BinaryTreeNode<Vaccine> balance ( BinaryTreeNode<Vaccine> p ){
      fixHeight (p);
      if (balanceFactor (p) == 2){
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2){
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( Vaccine d ){
      insertOpCount = 0;
      root = insert (d, root);
   }
   public BinaryTreeNode<Vaccine> insert ( Vaccine d, BinaryTreeNode<Vaccine> node ){
      if (node == null){
         return new BinaryTreeNode<Vaccine> (d, null, null); 
      }
      insertOpCount ++;
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   public int getInsertOpCount(){
      return getInsertOpCount();
   }

   public void delete ( Vaccine d ){
      root = delete (d, root);
   }   
   public BinaryTreeNode<Vaccine> delete ( Vaccine d, BinaryTreeNode<Vaccine> node ){
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else{
         BinaryTreeNode<Vaccine> q = node.left;
         BinaryTreeNode<Vaccine> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<Vaccine> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   
   public BinaryTreeNode<Vaccine> findMin ( BinaryTreeNode<Vaccine> node ){
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode<Vaccine> removeMin ( BinaryTreeNode<Vaccine> node ){
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   public BinaryTreeNode<Vaccine> find ( Vaccine d ){
      searchOpCount = 0;
      if (root == null)
         return null;
      else
         return find (d, root);
   }

   public BinaryTreeNode<Vaccine> find ( Vaccine d, BinaryTreeNode<Vaccine> node ){
      searchOpCount ++;
      if (d.compareTo (node.data) == 0) 
         return node;
      else if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   public void treeOrder (){
      treeOrder (root, 0);
   }

   public void treeOrder ( BinaryTreeNode<Vaccine> node, int level ){
      if (node != null){
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

