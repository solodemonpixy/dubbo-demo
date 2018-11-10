package cn.alex.demo.dubboapi;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String name;

    private Integer age;


}
