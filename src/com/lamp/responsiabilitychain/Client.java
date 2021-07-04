package com.lamp.responsiabilitychain;

public class Client {
    public static void main(String[] args) {
        PutchaseRequest putchaseRequest = new PutchaseRequest(1, 20000F, 100);
        DepartmentApprover techer = new DepartmentApprover("张老师");
        techer.processRequest(putchaseRequest);
    }
}
