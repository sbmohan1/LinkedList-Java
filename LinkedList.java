// Name: Sishir Mohan
// ID: 1204721903
// Class: T Th 4:30-5:45
// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }
   	//Create ListIterator Object
	  ListIterator iterate = listIterator();

   //this method prints out the data in the linked list
   public String toString()
   {
 	  ListIterator iterate = listIterator();

 	  String s = "{ ";
 	  while(iterate.hasNext())
 	  {
 		  s = s + iterate.next() + " ";
 	  }
 	  s = s + "}\n";
 	  return s;
   }
   //this method returns the size of the linked list
   public int size()
   {
 	  ListIterator iterate = listIterator();

 	  int sizeOfLinkedList = 0;;
 	  while(iterate.hasNext())
 	  {
 		  sizeOfLinkedList++;
 		  iterate.next();
 	  }
 	  return sizeOfLinkedList;
   }
   //this method checks if the list is empty
   public boolean isEmpty()
   {
	   //boolean to see if list is empty or not
 	  boolean isEmpty = false;
 	  if(size()==0)
 	  {
 		  isEmpty = true;
 	  }
 	  else
 	  {
 		  isEmpty = false;
 	  }
 	  return isEmpty;
   }
   //method to search for a particular element in the list
   public int searchElement(Object element)
   {
	   //Create ListIterator object
 	  ListIterator iterate = listIterator();
 	  int k = -1;
 	  
 	  int index = 0;
 	  //while loop to go through list and find the element
 	  while(iterate.hasNext())
 	  {
 		  if(iterate.next().equals(element))
 		  {
 			  return index;
 		  }
 		  index++;
 	  }
 	  return k;


   }
   //method to add parameter element at the parameter specified indexx
   public void addElement(int index, Object element)
   {
	   //Create ListIterator object
 	  ListIterator iterate = listIterator();
 	  int count = 0;
 	  if((index >= 0) || (index < size()))
 	  {
 		  //all elements to the right of this are shifted to the right
 		  do
 		  {
 			  if(count == index)
 			  {
 				  iterate.add(element);
 			  }
 			  count++;
 			  if(iterate.hasNext())
 			  {
 				  iterate.next();
 			  }
 		  }while(count<=size());
 	  }
 	  //throw exception if parameter index is larger or smaller than indices in list
 	  else
 	  {
 		  IndexOutOfBoundsException exception = new IndexOutOfBoundsException();
 		  throw exception;
 	  }


   }
   //removes and element from the list
   public Object removeElement(int index)
   {
	   //Create ListIterator object
 	  ListIterator iterate = listIterator();

 	 Object objToBeRemoved = null;
 	 
 	  int count = -1;


 	  if((index>= 0) || (index<size()))
 	  {

 		  do
 		  {
 			  if(count==index)
 			  {

 				iterate.remove();
 				return objToBeRemoved;

 			  }
 			  count++;

 			  if(iterate.hasNext())
 			  {
 				  objToBeRemoved = iterate.next();
 			  }
 		  }while(count <= size());
 	  }
 	  //throws exception
 	  else
 	  {
 		  IndexOutOfBoundsException exception = new IndexOutOfBoundsException();
 		  throw exception;
 	  }
 	 return objToBeRemoved;


   }
   //method to find the smallest element in list
   public Object findSmallest()
   {
	   if(isEmpty())
	   {
		   NoSuchElementException ex = new NoSuchElementException();
		   throw ex;
	   }
	   //Create ListIterator object
	 	  ListIterator iterate = listIterator();
	 	  Object smallest = iterate.next();


	 	  while(iterate.hasNext())
	 	  {
	 		  Object nextObj = iterate.next();
	 		  if(((String) smallest).compareTo((String)nextObj) > 0)
	 		  {
	 			  smallest = nextObj;
	 		  }

	 	  }
	 	  return smallest;


   }
   //this method finds and removes all elements that the user wants
   public void removeAllOccurrences(Object stringToBeRemoved)   
   {
 	  ListIterator iter = listIterator();
 	  while(iter.hasNext())
 	  {
 		  if (((String)stringToBeRemoved).equals((String)iter.next()))
 		  {
 			  iter.remove();
 		  }
 	  }

   }







   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // this method adds an element before the iterator position and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) 
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
    	  //if statement to throw exceptions
         if (position == null)
          {
            NoSuchElementException exception = new NoSuchElementException();
            throw exception;
          }
         else
          position.data = element;
      }


   }
}//end of LinkedListIterator class
