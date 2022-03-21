// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BTQueue<Vaccine>{   
   BTQueueNode<Vaccine> head;
   BTQueueNode<Vaccine> tail;
      
   public BTQueue (){
      head = null;
      tail = null;
   }
   
   public BinaryTreeNode<Vaccine> getNext (){
      if (head == null)
         return null;
      BTQueueNode<Vaccine> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   public void enQueue ( BinaryTreeNode<Vaccine> node ){
      if (tail == null){   
         tail = new BTQueueNode<Vaccine> (node, null);
         head = tail;
      }else{
         tail.next = new BTQueueNode<Vaccine> (node, null);
         tail = tail.next;
      }   
   }   
}
