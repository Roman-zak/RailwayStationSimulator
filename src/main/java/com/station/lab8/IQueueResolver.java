package com.station.lab8;

import java.util.List;

public interface IQueueResolver {
    ICashRegister getPosition(List<ICashRegister> cashRegisters, Position start);
 //   void appointCustomerToQueue(List<CashRegister> cashRegisters, Customer customer);
}
