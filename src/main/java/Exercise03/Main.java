package Exercise03;

public class Main {
    public static void main(String[] args){
        ITypeChecker<Integer> integerITypeChecker = param -> param instanceof Integer && param > 5;
        System.out.println("Check 1: " + check(15, integerITypeChecker));
        System.out.println("Check 2: " + check(5, integerITypeChecker));

    }
    public static <T> Boolean check(T param, ITypeChecker<T> ITypeChecker) {
        return ITypeChecker.check(param);
    }
}
