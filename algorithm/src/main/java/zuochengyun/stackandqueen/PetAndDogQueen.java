package zuochengyun.stackandqueen;

import java.util.Queue;

/**
 * @author Leexiaobu
 * @date 2021-06-07 14:25
 */
public class PetAndDogQueen {

  class PetQueue {

    Pet pet;
    int count;

    public PetQueue(Pet pet, int count) {
      this.pet = pet;
      this.count = count;
    }

    Pet getPet() {
      return this.pet;
    }

    int getCount() {
      return this.count;
    }
  }

  public Queue<PetQueue> dogQueue;
  public Queue<PetQueue> catQueue;

  public Pet pollAll() {
    if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
      if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
        return dogQueue.poll().getPet();
      } else {
        return catQueue.poll().getPet();
      }
    } else if (!catQueue.isEmpty()) {
      return catQueue.poll().getPet();
    } else if (!dogQueue.isEmpty()) {
      return dogQueue.poll().getPet();
    }
    throw new RuntimeException("queue is empty");
  }

}


class Pet {

  public int type;

  public Pet(int type) {
    this.type = type;
  }
}

class Dog extends Pet {

  public Dog(int type) {
    super(1);
  }
}

class Cat extends Pet {

  public Cat(int type) {
    super(0);
  }
}

