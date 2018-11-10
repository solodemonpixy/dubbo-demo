package cn.alex.demo.dubboapi;

public interface HelloService {

    public String hello(String name);

    public RpcRespDTO<UserDTO> getName(String name,Integer age);

}
