package ThreadPool.DeadLocker;

public class IngredientsMixer {

    boolean bowlInUse = false;
    boolean spatulaInUse = false;
    Object resource1 = new Object();
    Object resource2 = new Object();

    public void mixWetIngredients(){
        try {
            synchronized (resource1) {
                System.out.println("mixWetIngredients:: Mixing wet Ingredients in Bowl...");
                while (bowlInUse) {
                    System.out.println("mixWetIngredients:: Waiting for the mixing bowl...");
                    wait();
                }
                System.out.println("mixWetIngredients:: Using mixing bowl...");
                bowlInUse = true;
            }
            Thread.sleep(2000);
            synchronized (resource1) {
                while (spatulaInUse) {
                    System.out.println("mixWetIngredients:: Waiting for Spatula...");
                    wait();
                }
                System.out.println("mixWetIngredients:: Using Spatula");
                spatulaInUse = true;
            }
            Thread.sleep(2000);
            synchronized (resource1) {
                System.out.println("mixWetIngredients:: Releasing both Bowl and Spatula!");
                bowlInUse = false;
                spatulaInUse = false;
                notifyAll();
            }
        }catch (InterruptedException e) {
            e.getCause();
        }
    }

    public void mixingDryIngredients() {
        try {
            synchronized (resource2) {
                System.out.println("mixingDryIngredients:: Mixing Dry Ingredients!");
                while (spatulaInUse) {
                    System.out.println("mixingDryIngredients:: Waiting for Spatula...");
                    wait();
                }
                System.out.println("mixingDryIngredients:: Spatula In use...");
                spatulaInUse = true;
            }
            Thread.sleep(2000);

            synchronized (resource2) {
                while (bowlInUse) {
                    System.out.println("mixingDryIngredients:: Waiting for mixing bowl...");
                    wait();
                }
                System.out.println("mixingDryIngredients:: Using mixing bowl...");
                bowlInUse = true;
            }

            Thread.sleep(2000);
            synchronized (resource2) {
                System.out.println("mixingDryIngredients:: Releasing both Spatula and Mixing bowl...");
                bowlInUse = false;
                spatulaInUse = false;
                notifyAll();
            }
    }catch (InterruptedException e) {
        System.out.println(e.getCause());
    }
    }
}
