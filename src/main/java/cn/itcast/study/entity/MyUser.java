package cn.itcast.study.entity;

import javax.persistence.*;

/**
 * @author Administrator
 * @Title: User
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
@Entity
@Table(name = "my_user")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "pwdd")
    private String pwdd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwdd() {
        return pwdd;
    }

    public void setPwdd(String pwdd) {
        this.pwdd = pwdd;
    }
}
