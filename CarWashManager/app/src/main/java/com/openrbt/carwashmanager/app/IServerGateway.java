package com.openrbt.carwashmanager.app;

public interface IServerGateway {
    String[] GetServerList() throws Exception;
    void SetCurrentServer(String ServerURI) throws Exception;
    String GetCurrentServer() throws Exception;
}
