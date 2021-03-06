package com.webmihir.IntPlusPlus.interfaces.ctci;

public class StacksAndQueues {
  /**
   * 3.1 (Page 98): Describe how you could use a single array to implement three stacks
   */
  public abstract class SingleArrayForThreeStacks {
    public abstract boolean push(int n);
    public abstract int pop();
  }

  /**
   * 3.2 (Page 98): Design a stack which in addition to push and pop, returns the minimum element.
   * All operations (Push, Pop, Min) should operate in O(1) time
   */
  public abstract class StackWithGetMin {
    public abstract boolean push(int n);
    public abstract int pop();
    public abstract int min();
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
    public abstract boolean push(int n);
    public abstract int pop();
    public abstract int popAt(int index);
  }

  /**
   * 3.4 (Page 99): Implement a MyQueue class which implements a queue using two stacks
   */
  public abstract class MyQueue {
    public abstract boolean offer(int n);
    public abstract int poll();
  }

  /**
   * 3.5 (Page 99): Write a program to sort a stack such that the smallest items are on the top. You can use an
   * additional temporary stack, but you may not copy the elements into any other data structures (such as array).
   * The stack supports the following operations: push, pop, peek, and isEmpty
   */
  public abstract class MinStack {
    public abstract boolean push(int n);
    public abstract int pop();
    public abstract int peek();
    public abstract boolean isEmpty();
  }

  /**
   * 3.6 (Page 99): An animal shelter which holds only dogs and cats operates on a strict "first in first out" basis.
   * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select
   * whether they prefer a dog or a cat, and will receive the oldest animal of that type. They cannot select which
   * specific animal they would like, Create the data structures to maintain this system and implement operations
   * enqueue, dequeueAny, dequeueDog, dequeueCat. You may use the built-in LinkedList data structure.
   */
  public abstract class AnimalShelter {
    public abstract boolean enqueue(Animal animal);
    public abstract Animal dequeueAny();
    public abstract Dog dequeueDog();
    public abstract Cat dequeueCat();
    public abstract class Animal {
      public int id;
    }
    public class Dog extends Animal { public Dog(int id) {this.id = id;} }
    public class Cat extends Animal { public Cat(int id) {this.id = id;}}
  }
}
