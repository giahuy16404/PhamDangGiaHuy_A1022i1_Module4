package com.example.furama.model.contract;

import com.example.furama.model.customer.Customer;
import com.example.furama.model.employee.Employee;
import com.example.furama.model.service.Service;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private long id;
    @Column(columnDefinition = "DATETIME")
    private String starDate;
    @Column(columnDefinition = "DATETIME")
    private String endDate;
    private double deposit;
    private double totalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false,referencedColumnName = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false,referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id",nullable = false,referencedColumnName = "service_id")
    private Service service;

    public Contract(long id, String starDate, String endDate, double deposit, double totalMoney, Employee employee, Customer customer, Service service) {
        this.id = id;
        this.starDate = starDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public Contract() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", starDate='" + starDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", deposit=" + deposit +
                ", totalMoney=" + totalMoney +
                ", employee=" + employee +
                ", customer=" + customer +
                ", service=" + service +
                '}';
    }
}
