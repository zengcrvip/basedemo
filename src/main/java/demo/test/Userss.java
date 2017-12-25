package demo.test;

/**
 * Created by changrong.zeng on 2017/12/6.
 */
public class Userss {

    private int code;
    private String name;

    public Userss(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Userss{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userss userss = (Userss) o;

        return code == userss.code;

    }

    @Override
    public int hashCode() {
        return code;
    }
}
