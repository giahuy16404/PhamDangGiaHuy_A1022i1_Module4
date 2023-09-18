package com.example.furama.controller.contract;

import com.example.furama.dto.contractDto.ContractDto;
import com.example.furama.model.contract.AttachService;
import com.example.furama.model.contract.Contract;
import com.example.furama.model.contract.ContractDetail;
import com.example.furama.repository.contract.IAttachRepository;
import com.example.furama.service.contract.itf.IContractService;
import com.example.furama.service.customer.itf.ICustomerService;
import com.example.furama.service.employee.itf.IEmployeeService;
import com.example.furama.service.service.itf.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IService iService;

    @Autowired
    private IContractService iContractService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "0") int size,
                           @RequestParam(defaultValue = "") String valueSearch,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Contract> contractPage = iContractService.findPage(pageable);
        model.addAttribute("contractPage", contractPage);
        return "contract/list";
    }

    @GetMapping("/update")
    public String update(){

        return "contract/list";
    }

    @GetMapping("/add_contract_villa")
    public String addContractVilla(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("listEmployee", iEmployeeService.getEmployee());
        model.addAttribute("listCustomer", iCustomerService.getCustomer());
        model.addAttribute("listAttach", iContractService.findAttach());
        model.addAttribute("listService", iService.findByServiceName("Villa"));
        model.addAttribute("contractDto", new ContractDto());
        return "contract/add";
    }

    @GetMapping("/add_contract_house")
    public String addContractHouse(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("listEmployee", iEmployeeService.getEmployee());
        model.addAttribute("listCustomer", iCustomerService.getCustomer());
        model.addAttribute("listAttach", iContractService.findAttach());
        model.addAttribute("listService", iService.findByServiceName("House"));
        model.addAttribute("contractDto", new ContractDto());
        return "contract/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                      @RequestParam List<Long> valueAttach
    ) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "contract/add";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        iContractService.add(contract);
        Long idContract = iContractService.showMaxId();
        contract.setId(idContract);

        for (Long i:valueAttach) {
            ContractDetail contractDetail = new ContractDetail();
            AttachService attachService = new AttachService();
            attachService.setId(i);
            contractDetail.setContract(contract);
            contractDetail.setAttachService(attachService);
            contractDetail.setQuantity(valueAttach.size());
            iContractService.addContractDetail(contractDetail);
        }
        return "redirect:/contract";
    }
}
