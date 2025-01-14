package com.mock.demomock;


import com.mock.demomock.config.Configuration;
import com.mock.demomock.core.TicketPool;
import com.mock.demomock.logging.Logger;
import com.mock.demomock.threads.Customer;
import com.mock.demomock.threads.Vendor;
import com.mock.demomock.ui.CommandLineInterface;

public class Main {
    public static void main(String[] args) {
        Configuration config = CommandLineInterface.configureSystem();
        TicketPool ticketPool = new TicketPool();
        Thread vendor = new Thread(new Vendor(ticketPool,
                config.getTicketReleaseRate()));
        Thread customer = new Thread(new Customer(ticketPool));
        vendor.start();
        customer.start();
        try {
            vendor.join();
            customer.join();
        } catch (InterruptedException e) {
            Logger.log("Main thread interrupted.");
        }
        Logger.log("System terminated.");
    }
}