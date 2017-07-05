package domain;

import java.util.Set;

/**
 * Created by ww on 2017/6/22.
 */
public class Department {

    public Department(){


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }

    private Integer id;
    private String name;
    private Set<Employee> emps;

    public Set<Employee> getEmps() {
        return emps;
    }

    public void setEmps(Set<Employee> emps) {
        this.emps = emps;
    }




}
