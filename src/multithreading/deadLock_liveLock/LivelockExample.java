package multithreading.deadLock_liveLock;

/**
 * In this livelock example, two diners, Alice and Bob, are trying to eat with a single spoon.
 * If they both decide to let the other eat first, they get stuck in a loop of politeness and never make any progress.
 */
public class LivelockExample {
    public static void main(String[] args) {
        Diner alice = new Diner("Alice");
        Diner bob = new Diner("Bob");

        Spoon spoon = new Spoon(alice);

        Thread thread1 = new Thread(() -> alice.eatWith(spoon, bob));
        Thread thread2 = new Thread(() -> bob.eatWith(spoon, alice));

        thread1.start();
        thread2.start();
    }

    static class Spoon {
        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public void setOwner(Diner owner) {
            this.owner = owner;
        }

        public Diner getOwner() {
            return owner;
        }

        public synchronized void use() {
            System.out.println(owner.getName() + " is using the spoon.");
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            this.isHungry = true;
        }

        public String getName() {
            return name;
        }

        public void eatWith(Spoon spoon, Diner diner) {
            while (isHungry) {
                if (spoon.getOwner() != this) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    continue;
                }

                if (diner.isHungry()) {
                    System.out.println(name + " says: You eat first, " + diner.getName() + "!");
                    spoon.setOwner(diner);
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.println(name + " has eaten!");
                spoon.setOwner(diner);
            }
        }

        public boolean isHungry() {
            return isHungry;
        }
    }
}