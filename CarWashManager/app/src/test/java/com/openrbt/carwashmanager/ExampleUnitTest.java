package com.openrbt.carwashmanager;

import com.openrbt.carwashmanager.dal.ServerGateway;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void serverList_isWorking() {
        // TODO check servers list os not empty and each server is a correct IPv4
        ServerGateway gateway = new ServerGateway();
        try {
            String[] result = gateway.GetServerList();
            System.out.println("FOUND SERVERS:");
            for(int i = 0;i < result.length;i++) {
                System.out.println(result[i]);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR HAPPENED:");
            System.out.println(e.getMessage());
            assertEquals(5, 2 + 2);
        }
    }
}