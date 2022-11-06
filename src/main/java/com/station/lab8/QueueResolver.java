package com.station.lab8;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class QueueResolver implements IQueueResolver {
    @Override
    public Position getPosition(List<CashRegister> cashRegisters, Position start) {
        Position bestPosition = new Position();
        CashRegister temp = new CashRegister();
        temp = cashRegisters.get(0);
        for (CashRegister cr:cashRegisters) {
            if (cr.getQueue().size()==0){
                bestPosition = cr.getPosition();
                break;
            }
            else if(cr.getQueue().size()<temp.getQueue().size()){
                bestPosition = cr.getPosition();
                temp = cr;
            } else if (cr.getQueue().size()==temp.getQueue().size()) {
                bestPosition = cr.getPosition().Distance(start)<temp.getPosition().Distance(start)?cr.getPosition():temp.getPosition();
            }
        }

        return bestPosition;
    }

    @Override
    public void appointCustomerToQueue(List<CashRegister> cashRegisters, Customer customer) {
        Position position = getPosition(cashRegisters, customer.getEntrance().getPosition());
        for (CashRegister cashRegister: cashRegisters) {
            if(cashRegister.getPosition()==position){
                cashRegister.getQueue().add(customer);
            }
        }
    }
}
