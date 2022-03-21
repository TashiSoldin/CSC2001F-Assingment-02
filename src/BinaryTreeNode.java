// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<Vaccine>{
    Vaccine data;
   BinaryTreeNode<Vaccine> left;
   BinaryTreeNode<Vaccine> right;
   int height;
   
   public BinaryTreeNode ( Vaccine d, BinaryTreeNode<Vaccine> l, BinaryTreeNode<Vaccine> r ){
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   BinaryTreeNode<Vaccine> getLeft () { return left; }
   BinaryTreeNode<Vaccine> getRight () { return right; }
}
