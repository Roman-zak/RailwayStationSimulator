package com.station.lab8;

import java.util.List;

public interface IQueueResolver {
    //void getPosition(List<CashRegister> cashRegisters, Position start);
    void appointCustomerToQueue(List<ICashRegister> cashRegisters, ICustomer customer);
}
