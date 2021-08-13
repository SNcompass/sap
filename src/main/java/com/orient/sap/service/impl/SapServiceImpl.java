package com.orient.sap.service.impl;

import com.orient.sap.service.SapService;

import javax.jws.WebService;
import java.util.Date;

@WebService(name = "SapService",targetNamespace = "https://service.sap.orient.com",endpointInterface = "com.orient.sap.service.SapService")
public class SapServiceImpl implements SapService {

    @Override
    public String sayHello(String user) {
        return user+",现在时间："+"("+new Date()+")";
    }

    @Override
    public String sayBye() {
        return "haha---BayBay";
    }
}
