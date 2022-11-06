package com.station.lab8;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class QueueResolver implements IQueueResolver {
    @Override
    public void appointCustomerToQueue(List<ICashRegister> cashRegisters, ICustomer customer) {
        throw new NotImplementedException();
    }
    public static Position GetPosition(List<CashRegister> cashRegisterList,Position start){
        Position bestPosition = new Position();
        CashRegister temp = new CashRegister();
        temp = cashRegisterList.get(0);
        for (CashRegister cr:cashRegisterList) {
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

}
