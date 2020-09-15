package com.openrbt.carwashmanager.app;

import android.content.res.Resources;

public class CarWashApplication implements ICarWashApplication {
    private IServerGateway serverGateway;

    // GetServerList returns all found servers
    public String[] GetServerList() throws Exception {
        return  serverGateway.GetServerList();
    }

    // SetCurrentServer just selects a current server
    public void SetCurrentServer(String ServerURI) throws Exception {
        serverGateway.SetCurrentServer(ServerURI);
    }

    // GetCurrentServer just returns the current server
    public String GetCurrentServer() throws Exception {
        return serverGateway.GetCurrentServer();
    }

    // Login returns a token, application will use the token to get the data
    public String Login(String ServerURI, String Name, String Pass) throws Exception {
        throw new Exception();
    }

    // Logout just logs out a user
    public void Logout() throws Exception {
        throw new Exception();
    }

    // GetStations just returns list of stations
    public Station[] GetStations() throws Exception {
        throw new Exception();
    }

    // GetReport returns how much money/cars earned between specified dates
    public StationReport GetReport(int StationID, long StartDateUnixSeconds, long EndDateUnixSeconds) throws Exception {
        throw new Exception();
    }

    // SetCheckReport just puts a point
    public void SetCheckPoint(int StationID, long DateUnixSeconds) throws Exception {
        throw new Exception();
    }

    // GetCheckPointsForPeriod returns all CheckPoints between specified dates
    public CheckPoint[] GetCheckPointsForPeriod(int StationID, long StartDateUnixSeconds, long EndDateUnixSeconds) throws Exception {
        throw new Exception();
    }

    // GetCheckPointReport returns a report for specific checkpoint
    public StationReport GetCheckPointReport(CheckPoint checkPoint) throws Exception {
        throw new Exception();
    }

    // GetVariablesList returns list of all variables
    // set StationID as negative to search through all Stations
    // pass empty ContainsString parameter (or null) to skip name filter
    public WashVariable[] GetVariablesList(int StationID, String ContainsString) throws Exception {
        throw new Exception();
    }

    // SetVariable is to set a variable value
    public void SetVariable(int StationID, String Key, String Value) throws Exception {
        throw new Exception();
    }

    // LoggedIn returns true if client is logged in
    public boolean LoggedIn() throws Exception {
        throw new Exception();
    }

    // GetStation returns information about current station status, like money\program selected
    public StationStatus GetStationStatus(int StationID) throws Exception {
        throw new Exception();
    }

    // TopUpStationMoney just adds some money to the station balance
    public void TopUpStationMoney(int StationID, int MoneyAmount) throws Exception {
        throw new Exception();
    }

}
