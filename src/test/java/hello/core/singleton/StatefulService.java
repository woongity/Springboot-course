package hello.core.singleton;

public class StatefulService {
    // 얘가 문제를 만듦. 무상태로 만들어야함.
//    private int price;

    public int order(String name, int price){
        System.out.println(name+"price = "+price);
//        this.price = price;
        return price;
    }
}
