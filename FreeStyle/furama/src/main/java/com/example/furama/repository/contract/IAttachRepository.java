package com.example.furama.repository.contract;

import com.example.furama.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachRepository extends JpaRepository<AttachService,Long> {
}
