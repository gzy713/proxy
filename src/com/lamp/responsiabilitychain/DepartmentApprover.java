package com.lamp.responsiabilitychain;

public class DepartmentApprover extends Approver {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PutchaseRequest putchaseRequest) {
        if (putchaseRequest.getPrice() > 1000) {
            System.out.println(this.name);
        } else {
            approver.processRequest(putchaseRequest);
        }
    }
}
