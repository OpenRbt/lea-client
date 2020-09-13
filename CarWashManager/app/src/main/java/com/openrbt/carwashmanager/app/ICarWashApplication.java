package com.openrbt.carwashmanager.app;

public interface ICarWashApplication {
    // GetServerList returns all found servers
    String[] GetServerList() throws Exception;

    // Login returns a token, application will use the token to get the data
    String Login(String ServerURI, String Name, String Pass) throws Exception;

    // Logout just logs out a user
    void Logout() throws Exception;

    // GetStations just returns list of stations
    Station[] GetStations() throws Exception;

    // GetReport returns how much money/cars earned between specified dates
    StationReport GetReport(int StationID, long StartDateUnixSeconds, long EndDateUnixSeconds) throws Exception;

    // SetCheckReport just puts a point
    void SetCheckPoint(int StationID, long DateUnixSeconds) throws Exception;

    // GetCheckPointsForPeriod returns all CheckPoints between specified dates
    CheckPoint[] GetCheckPointsForPeriod(int StationID, long StartDateUnixSeconds, long EndDateUnixSeconds) throws Exception;

    // GetCheckPointReport returns a report for specific checkpoint
    StationReport GetCheckPointReport(CheckPoint checkPoint) throws Exception;

    // GetVariablesList returns list of all variables
    // set StationID as negative to search through all Stations
    // pass empty ContainsString parameter (or null) to skip name filter
    WashVariable[] GetVariablesList(int StationID, String ContainsString) throws Exception;

    // SetVariable is to set a variable value
    void SetVariable(int StationID, String Key, String Value) throws Exception;

    // LoggedIn returns true if client is logged in
    boolean LoggedIn() throws Exception;
}
