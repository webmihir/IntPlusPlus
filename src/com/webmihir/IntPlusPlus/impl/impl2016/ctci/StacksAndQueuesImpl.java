package com.webmihir.IntPlusPlus.impl.impl2016.ctci;

import com.webmihir.IntPlusPlus.interfaces.ctci.StacksAndQueues;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class StacksAndQueuesImpl extends StacksAndQueues {
  /**
   * 3.1 (Page 98): Describe how you could use a single array to implement three stacks
   */
  public abstract class SingleArrayForThreeStacksImpl extends SingleArrayForThreeStacks {
    public boolean push(int n) {
      throw new NotImplementedException(); }

    public int pop() { throw new NotImplementedException(); }
  }

  /**
   * 3.2 (Page 98): Design a stack which in addition to push and pop, returns the minimum element.
   * All operations (Push, Pop, Min) should operate in O(1) time
   */
  public abstract class StackWithGetMin {
    public boolean push(int n) {
      throw new NotImplementedException();
    }

    public int pop() {
      throw new NotImplementedException();
    }

    public int min() {
      throw new NotImplementedException();
    }
  }

  /**
   * 3.3 (Page 99): Imagine a literal stack of plates. If the stack gets too high, it might topple.
   * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
   * Implement a data structure, SetOfStacks that mimics this. SetOfStacks should be composed of several stack
   * and should create a new stack once the previous one exceeds capacity. push and pop operations should behave
   * identically to a single stack (i.e. pop would return the same values as if there were just a single stack.)
   *
   * Additionally, implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
   */
  public abstract class SetOfStacks {
    public boolean push(int n) { throw new NotImplementedException(); }
    public int pop() { throw new NotImplementedException(); }
    public int popAt(int index) { throw new NotImplementedException(); }
  }

  /**
   * 3.4 (Page 99): Implement a MyQueue class which implements a queue using two stacks
   */
  public abstract class MyQueue {
    public boolean offer(int n) { throw new NotImplementedException(); }
    public int poll() { throw new NotImplementedException(); }
  }

  /**
   * 3.5 (Page 99): Write a program to sort a stack such that the smallest items are on the top. You can use an
   * additional temporary stack, but you may not copy the elements into any other data structures (such as array).
   * The stack supports the following operations: push, pop, peek, and isEmpty
   */
  public abstract class MinStack {
    public boolean push(int n) { throw new NotImplementedException(); }
    public int pop() { throw new NotImplementedException(); }
    public int peek() { throw new NotImplementedException(); }
    public boolean isEmpty() { throw new NotImplementedException(); }
  }

  /**
   * 3.6 (Page 99): An animal shelter which holds only dogs and cats operates on a strict "first in first out" basis.
   * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select
   * whether they prefer a dog or a cat, and will receive the oldest animal of that type. They cannot select which
   * specific animal they would like, Create the data structures to maintain this system and implement operations
   * enqueue, dequeueAny, dequeueDog, dequeueCat. You may use the built-in LinkedList data structure.
   */
  public abstract class AnimalShelter {
    public boolean enqueue(StacksAndQueues.AnimalShelter.Animal animal) { throw new NotImplementedException(); }
    public StacksAndQueues.AnimalShelter.Animal dequeueAny() { throw new NotImplementedException(); }
    public StacksAndQueues.AnimalShelter.Dog dequeueDog() { throw new NotImplementedException(); }
    public StacksAndQueues.AnimalShelter.Cat dequeueCat() { throw new NotImplementedException(); }
  }
}
