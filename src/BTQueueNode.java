// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BTQueueNode<Vaccine>{
   BinaryTreeNode<Vaccine> node;
   BTQueueNode<Vaccine> next;
   
   public BTQueueNode ( BinaryTreeNode<Vaccine> n, BTQueueNode<Vaccine> nxt ){
      node = n;
      next = nxt;
   }
}