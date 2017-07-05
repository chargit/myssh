package test;

/**
 * Created by ww on 2017/6/12.
 */
public class TestService {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void sayHello(){

        System.out.println("HI "+name);
    }

}
