package com.example.furama.QueryDb;

public class QueryServiceDb {
    public static final String FIND_ALL_PAGE_SERVICE = "SELECT * FROM service \n" +
            "JOIN rent_type ON service.rent_type_id = rent_type.rent_type_id\n" +
            "JOIN service_type ON service_type.service_type_id = service.service_type_id";

    public static final String FIND_BY_SERVICE_NAME = "SELECT * FROM service \n" +
            "JOIN rent_type ON service.rent_type_id = rent_type.rent_type_id\n" +
            "JOIN service_type ON service_type.service_type_id = service.service_type_id WHERE service_type.name LIKE :service";
    public static final String DELETE_SERVICE_BY_ID = " DELETE FROM service WHERE service_id = :id ";
    public static final String DELETE_CONTRACT_BY_ID_SERVICE = "DELETE FROM contract WHERE service_id = :id ;";

}
