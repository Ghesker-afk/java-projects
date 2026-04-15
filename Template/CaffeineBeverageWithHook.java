public abstract class CaffeineBeverageWithHook {
  
  final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();

    // We have added a little conditional statement that bases it success on a concrete method, customerWantsCondiments(). If the customer WANTS condiments, only then do we call addCondiments()

    if (customerWantsCondiments()) {
      addCondiments();
    }
  }

  abstract void brew();

  abstract void addCondiments();

  void boilWater() {
    System.out.println("Boiling water");
  }

  void pourInCup() {
    System.out.println("Pouring into cup");
  }

  // Here we have defined a method with a (mostly) empty default implementation. This method just returns true and does nothing else

  // This is a hook because the subclass can override this method, but doesn't have to

  boolean customerWantsCondiments() {
    return true;
  }
}