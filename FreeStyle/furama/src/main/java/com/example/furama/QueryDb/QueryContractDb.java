package com.example.furama.QueryDb;

public class QueryContractDb {
    public static final String FIND_PAGE_CONTRACT = "SELECT * FROM contract \n" +
            "            JOIN customer ON customer.customer_id = contract.contract_id\n" +
            "            JOIN employee ON employee.employee_id = contract.employee_id\n" +
            "            JOIN service On service.service_id = contract.service_id";


    public static final String SHOW_MAX_ID = "SELECT MAX(contract.contract_id) FROM contract";
}
