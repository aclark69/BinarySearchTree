
 
/** **************************************************************************
 *                     The  generic Binary Search Tree class.
 *
 * V.S.Adamchik 2010
 *****************************************************************************/
//Binary Search Tree Class done
//1.) Create Class/Method for Post-order traversal

import java.util.*;

public class BST <T extends Comparable<T>> implements Iterable<T>
{
   private Node<T> root;
   private Comparator<T> comparator;

   public BST()
   {
      root = null;
      comparator = null;
   }

   public BST(Comparator<T> comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(T x, T y)
   {
      if(comparator == null) return x.compareTo(y);
      else
      return comparator.compare(x,y);
   }

/*****************************************************
*
*            INSERT
*
******************************************************/

   public void insert(T data)
   {
      root = insert(root, data);
      System.out.print(data + " ");
   }

   private Node<T> insert(Node<T> p, T toInsert)
   {
      if (p == null)
         return new Node<T>(toInsert);
      //if (compare(toInsert, p.data) == 0)
      //return p;
      if (compare(toInsert, p.data) <= 0)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);
      return p;
   }
 
/*************************************************
 *
 *            toString
 *
 **************************************************/
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      for(T data : this) sb.append(data.toString());
      return sb.toString();
   }

/*************************************************
 *
 *            TRAVERSAL
 *
 **************************************************/

   void postOrderTraversal() {
       postOrderHelper(root);
   }

   private void postOrderHelper(Node r) { 
       if(r != null) {
           postOrderHelper(r.left);
           postOrderHelper(r.right);
           System.out.print(r + " ");
       }
   }


/*****************************************************
*
*            TREE ITERATOR
*
******************************************************/

   public Iterator<T> iterator()
   {
      return new MyIterator();
   }

   private class MyIterator implements Iterator<T>
   {
      Stack<Node<T>> stk = new Stack<Node<T>>();

      public MyIterator()
      {
         if(root != null) stk.push(root);
      }

      public boolean hasNext()
      {
         return !stk.isEmpty();
      }

      public T next()
      {
         Node<T> cur = stk.peek();
         if(cur.left != null)
         {
            stk.push(cur.left);
         }
         else
         {
            Node<T> tmp = stk.pop();
            while( tmp.right == null )
            {
               if(stk.isEmpty()) return cur.data;
               tmp = stk.pop();
            }
            stk.push(tmp.right);
         }
         return cur.data;
      }//end of next()

    @Override
    public void remove() {
        // TODO Auto-generated method stub
     
    }

   }//end of MyIterator



/*****************************************************
*
*            the Node class
*
******************************************************/

   private class Node<T>
   {
      private T data;
      private Node<T> left, right;

      public Node(T data, Node<T> l, Node<T> r)
      {
         left = l; right = r;
         this.data = data;
      }

      public Node(T data)
      {
         this(data, null, null);
      }
   
      public String toString()
      {
         return data.toString();
      }
   
   } //end of Node
}//end of BST

class MyComp1 implements Comparator<Integer>
{
   public int compare(Integer x, Integer y)
   {
        return y-x;
   }
}
