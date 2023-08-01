var editStudentModal = document.getElementById("exampleModal");
editStudentModal.addEventListener("show.bs.modal", function (event) {

    var button = event.relatedTarget;

    var id = button.getAttribute("data-bs-id");
    var name = button.getAttribute("data-bs-name");
    var salary = button.getAttribute("data-bs-salary");
    var idCard = button.getAttribute("data-bs-idCard");
    var birthday = button.getAttribute("data-bs-birthday");
    var phone = button.getAttribute("data-bs-phone");
    var address = button.getAttribute("data-bs-address");
    var email = button.getAttribute("data-bs-email");
    var position = button.getAttribute("data-bs-position");
    var division = button.getAttribute("data-bs-division");
    var educationDegree = button.getAttribute("data-bs-educationDegree");

    var modalBodyInputNewEmployeeName = editStudentModal.querySelector("#nameUpdate");
    var modalBodyInputNewEmployeeSalary = editStudentModal.querySelector("#salaryUpdate");
    var modalBodyInputNewEmployeeCccd = editStudentModal.querySelector("#cccdUpdate");
    var modalBodyInputNewEmployeeBirthday = editStudentModal.querySelector("#birthdayUpdate");
    var modalBodyInputNewEmployeePhone = editStudentModal.querySelector("#phoneUpdate");
    var modalBodyInputNewEmployeeEmail = editStudentModal.querySelector("#emailUpdate");
    var modalBodyInputNewEmployeeAddress = editStudentModal.querySelector("#addressUpdate");
    var modalBodyInputNewEmployeePosition = editStudentModal.querySelector("#positionUpdate");

    modalBodyInputNewEmployeeName.value = name;
    modalBodyInputNewEmployeeSalary.value = salary;
    modalBodyInputNewEmployeeCccd.value = idCard;
    modalBodyInputNewEmployeeBirthday.value = birthday;
    modalBodyInputNewEmployeePhone.value = phone;
    modalBodyInputNewEmployeeEmail.value = email;
    modalBodyInputNewEmployeeAddress.value = address;
    modalBodyInputNewEmployeePosition.value = position;
});