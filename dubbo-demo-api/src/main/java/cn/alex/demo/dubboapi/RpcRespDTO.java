package cn.alex.demo.dubboapi;

import lombok.Data;

import java.io.Serializable;

@Data
public class RpcRespDTO<T> implements Serializable {

    private String msg;

    private String code;

    private T data;

}
