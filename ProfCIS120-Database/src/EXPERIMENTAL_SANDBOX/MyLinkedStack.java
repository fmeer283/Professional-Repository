//----------------------------------------------------------------------
// LinkedStack.java         by Dale/Joyce/Weems                Chapter 3
//
// Implements UnboundedStackInterface using a linked list 
// to hold the stack elements.
//-----------------------------------------------------------------------

package EXPERIMENTAL_SANDBOX;

import Dale_Imports.*;

public class MyLinkedStack<T> extends LinkedStack<T>
{
  protected LLNode<T> top;   // reference to the top of this stack

  public MyLinkedStack()
  {
    top = null;
  }

  public void push(T element)
  // Places element at the top of this stack.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(top);
    top = newNode;
  }     

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (!isEmpty())
    {
      top = top.getLink();
    }
    else
      throw new StackUnderflowException("Pop attempted on an empty stack.");
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element from this stack.
  {                 
    if (!isEmpty())
      return top.getInfo();
    else
      throw new StackUnderflowException("Top attempted on an empty stack.");
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    if (top == null) 
      return true;
    else
      return false;
  }
// Homework exercise:
/*  public String toString()
  // Returns a nicely formatted string representing this StringLog.
  {
    String toReturn = "";
    LLNode<T> current = top;
    
    while (current != null)
    {
    	toReturn += current.getInfo().toString();
    	current = current.getLink();
    }  
    return toReturn;
  }*/
  // Recursion example for reversing stack order when printing
}

