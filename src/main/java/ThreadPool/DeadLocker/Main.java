package ThreadPool.DeadLocker;

public class Main {
    public static void main(String[] args) {
        var ingredientsMixer = new IngredientsMixer();
        Thread mixingDryIngredients = new Thread(ingredientsMixer::mixingDryIngredients, "mixDryIngredients");
        Thread mixingWetIngredients = new Thread(ingredientsMixer::mixWetIngredients, "mixWetIngredients");

        mixingDryIngredients.start();
        mixingWetIngredients.start();

        try {
            mixingWetIngredients.join();
            mixingDryIngredients.join();
        } catch (InterruptedException e) {
            System.out.println(e.getCause());
        }

    }
}