package cn.alex.demo.dubboproducer.service;

import cn.alex.demo.dubboapi.HelloService;
import cn.alex.demo.dubboapi.RpcRespDTO;
import cn.alex.demo.dubboapi.UserDTO;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "dubbo provider"+name;
    }

    @Override
    public RpcRespDTO<UserDTO> getName(String name, Integer age) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(100);
        userDTO.setName("mike");
        RpcRespDTO<UserDTO> objectRpcRespDTO = new RpcRespDTO<>();
        objectRpcRespDTO.setCode("000000");
        objectRpcRespDTO.setMsg("success");
        objectRpcRespDTO.setData(userDTO);
        return objectRpcRespDTO;
    }
}
