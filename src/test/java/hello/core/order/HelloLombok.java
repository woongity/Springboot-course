package hello.core.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(10);
        helloLombok.setName("andy");

        System.out.println("helloLombok name= " + helloLombok.getName());
        System.out.println("helloLombok age= " + helloLombok.getAge());
    }
}
