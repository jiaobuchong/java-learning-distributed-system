package com.jiaobuchong.rpc.common.protocol;

import com.alibaba.fastjson.JSON;

public class JSONMessageProtocol implements MessageProtocol {

    @Override
    public byte[] marshallingRequest(Request req) {
        Request temp = new Request();
        temp.setServiceName(req.getServiceName());
        temp.setMethod(req.getMethod());
        temp.setHeaders(req.getHeaders());
        temp.setPrameterTypes(req.getPrameterTypes());

        if (req.getParameters() != null) {
            Object[] params = req.getParameters();
            Object[] serizeParmas = new Object[params.length];
            for (int i = 0; i < params.length; i++) {
                // 这一块是有问题的，如果参数是一个接口的话，这里序列化之后，
                // 服务端是不能获取到完整的信息的，需要带上 Class<?> 信息传过去
                serizeParmas[i] = JSON.toJSONString(params[i]);
            }

            temp.setParameters(serizeParmas);
        }

        return JSON.toJSONBytes(temp);
    }

    @Override
    public Request unmarshallingRequest(byte[] data) {
        Request req = JSON.parseObject(data, Request.class);
        if (req.getParameters() != null) {
            // TODO
        }
        return null;
    }

    @Override
    public byte[] marshallingResponse(Response rsp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response unmarshallingResponse(byte[] data) {
        // TODO Auto-generated method stub
        return null;
    }

}
