package com.openrbt.carwashmanager.dal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerGateway {
    private String currentServerURI;

    public ServerGateway() {
        currentServerURI = "";
    }

    public String[] GetServerList() throws Exception {
        ArrayList<String> allServers = new ArrayList<String>();
        String[] result = new String[0];

        byte [] defaultIPAddress = null;
        DatagramSocket socket = new DatagramSocket();

        try {
            // For now we do not support external servers
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            defaultIPAddress = socket.getLocalAddress().getAddress();
        }
        finally {
            socket.close();
        }

        if (defaultIPAddress == null) {
            return result;
        }
        if (defaultIPAddress.length > 4) {
            throw  new Exception("IPv6 is not supported yet");
        }

        byte a = defaultIPAddress[0];
        byte b = defaultIPAddress[1];
        byte c = defaultIPAddress[2];

        String IPTemplate = byteStr(a) + "." + byteStr(b) + "." + byteStr(c) + ".";
        String URITemplate = "http://" + IPTemplate;

        for (int i=1;i<255;i++) {
            String curURI  = getURI(URITemplate, i);
            System.out.print("connecting "+curURI+" ... ");
            if (sendPingRequest(curURI)) {
                allServers.add(IPTemplate + Integer.toString(i));
                System.out.println("success!");
            } else {
                System.out.println("failed");
            }
        }

        result = allServers.toArray(result);

        return result;
    }

    public void SetCurrentServer(String ServerURI) throws Exception {
        currentServerURI = ServerURI;
    }

    public String GetCurrentServer() throws Exception {
        return currentServerURI;
    }

    private int unsignedByte(byte a) {
        int b = a & 0xFF;
        return b;
    }

    private String byteStr(byte a) {
        return Integer.toString(unsignedByte(a));
    }

    private boolean sendPingRequest(String URI) throws Exception{
        int defaultTimeout = 200;
        URL possibleServer;
        possibleServer = new URL(URI);
        HttpURLConnection con;
        try {
            con = (HttpURLConnection)possibleServer.openConnection();
            con.setConnectTimeout(defaultTimeout);
            con.setReadTimeout(defaultTimeout);
            con.connect();
            int code = con.getResponseCode();
            con.disconnect();
            return code >=200 && code <300; // 2xx code are OK codes for HTTP
        }
        catch (IOException e) {
            return false;
        }
    }

    private String getURI(String URITemplate, int d) {
        return URITemplate + Integer.toString(d) + ":8020/ping";
    }

}
