package com.station.lab8;

import java.util.List;

public interface IQueueResolver {
    Position getPosition(List<CashRegister> cashRegisters, Position start);
    void appointCustomerToQueue(List<CashRegister> cashRegisters, Customer customer);
}
