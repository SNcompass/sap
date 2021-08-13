package com.orient.sap.service;

import javax.jws.WebService;

@WebService(name = "SapService",targetNamespace = "https://service.sap.orient.com")
public interface SapService {

    //做两个测试的接口，一个带参数，一个不带参数。
    String sayHello(String user);

    String sayBye();

}
