package com.example.furama.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "contract_detail_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "attach_id",nullable = false,referencedColumnName = "attach_id")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id",nullable = false,referencedColumnName = "contract_id")
    private Contract contract;

    public ContractDetail(long id, AttachService attachService, Contract contract) {
        this.id = id;
        this.attachService = attachService;
        this.contract = contract;
    }

    public ContractDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "ContractDetail{" +
                "id=" + id +
                ", attachService=" + attachService +
                ", contract=" + contract +
                '}';
    }
}
