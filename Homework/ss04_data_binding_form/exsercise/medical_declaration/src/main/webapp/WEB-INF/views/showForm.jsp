<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VICTUS
  Date: 6/16/2023
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .text-color-red {
            color: red;
        }

        form input {
            width: 100%;
        }
    </style>
</head>
<body>
<h2>TỜ KHAI Y TẾ</h2>
<h3>ĐÂY LÀ TÀI LIỆU QUANT TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỀ PHÒNG CHÓNG DỊCH
    BỆNH TRUYỀN NHIỄM </h3>
<h4>Khuyên cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h4>

<form:form modelAttribute="medical" method="post">
    <table>
        <tr>
            <td>Họ tên (Ghi chữ IN HOA) <span class="text-color-red">(*)</span></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Nam sinh <span class="text-color-red">(*)</span></td>
            <td>Gioi tinh <span class="text-color-red">(*)</span></td>
            <td>Quoc tich <span class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td>
                <form:select path="yearOfBirth">
                    <form:options items="${yearOfBirth}"/>
                </form:select>
            </td>
            <td>
                <form:select path="gender">
                    <form:option value="Nam"/>
                    <form:option value="Nữ"/>
                </form:select>
            </td>
            <td>
                <form:select path="nationality">
                    <form:options items="${nationality}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="3">Số hộ chiếu hoặc CMND hoặc giấy thông hành hợp pháp khác <span
                    class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td colspan="3"><form:input path="idCard"/></td>
        </tr>
        <tr>
            <td>Thông tin đi lại <span class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td>
                <form:checkboxes path="travelInformation" items="${travelInformation}"/>
            </td>
        </tr>
        <tr>
            <td>Số hiệu phương tiện</td>
            <td>Số ghế</td>
        </tr>
        <tr>
            <td><form:input path="vehicleNumber"/></td>
            <td><form:input path="numberOfSeats"/></td>
        </tr>
        <tr>
            <td>Ngày khởi hành <span class="text-color-red">(*)</span></td>
            <td>Ngày kết thúc <span class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td>
                <form:select path="starDay.day">
                    <form:options items="${dayOfBirth}"/>
                </form:select>

                <form:select path="starDay.month">
                    <form:options items="${monthOfBirth}"/>
                </form:select>

                <form:select path="starDay.year">
                    <form:options items="${yearOfBirth}"/>
                </form:select>
            </td>

            <td>
                <form:select path="endDay.day">
                    <form:options items="${dayOfBirth}"/>
                </form:select>

                <form:select path="endDay.month">
                    <form:options items="${monthOfBirth}"/>
                </form:select>
                <form:select path="endDay.year">
                    <form:options items="${yearOfBirth}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="3">Trong vòng 14 ngày qua, Anh/Chi có đến tỉnh/thành phố nào? <span
                    class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="travelTest"/>
            </td>
        </tr>
        <tr>
            <td><b>Địa chỉ liên lạc</b></td>
        </tr>
        <tr>
            <td>Tinh / thành phố <span class="text-color-red">(*)</span></td>
            <td>Quận / huyện <span class="text-color-red">(*)</span></td>
            <td>Phường / xã <span class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td>
                <form:select path="contacts.tinh">
                    <form:options items="${town}"/>
                </form:select>
            </td>
            <td>
                <form:select path="contacts.quan">
                    <form:options items="${county}"/>
                </form:select>
            </td>
            <td>
                <form:select path="contacts.phuong">
                    <form:options items="${ward}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Địa chỉ nơi ở <span class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="contactDetails"/>
            </td>
        </tr>
        <tr>
            <td>Điện thoại <span class="text-color-red">(*)</span></td>
            <td>Email <span class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td>
                <form:input path="phone"/>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>
            <td>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không? <span
                    class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td>Triệu chứng</td>
            <td>Có</td>
            <td>Không</td>
            <td>Triệu chứng</td>
            <td>Có</td>
            <td>Không</td>
        </tr>

        <tr>
            <td>
                Sốt <span class="text-color-red">(*)</span>
            </td>
            <td><form:hidden path="symptom.yes"/>
                <input type="checkbox" name="symptom.yes" value="Sốt"/>
            </td>
            <td><input type="checkbox"/></td>

            <td>
                Ho <span class="text-color-red">(*)</span>
            </td>
            <td>
                <input type="checkbox" name="symptom.yes" value="Ho"/>
            </td>
            <td><input type="checkbox"/></td>
        </tr>

        <tr>
            <td>
                Khó thở <span class="text-color-red">(*)</span>
            </td>
            <td>
                <input type="checkbox" name="symptom.yes" value="Khó Thở"/>
            </td>
            <td><input type="checkbox"/></td>

            <td>
                Đau họng <span class="text-color-red">(*)</span>
            </td>
            <td>
                <input type="checkbox" name="symptom.yes" value="Đau họng"/>
            </td>
            <td><input type="checkbox"/></td>
        </tr>

        <tr>
            <td>
                Nôn <span class="text-color-red">(*)</span>
            </td>
            <td>
                <input type="checkbox" name="symptom.yes" value="Nôn"/>
            </td>
            <td><input type="checkbox"/></td>

            <td>
                Tiêu chảy <span class="text-color-red">(*)</span>
            </td>
            <td>
                <input type="checkbox" name="symptom.yes" value="Tiêu chảy"/>
            </td>
            <td><input type="checkbox"/></td>
        </tr>

        <tr>
            <td>
                Xuất huyết ngoài da <span class="text-color-red">(*)</span>
            </td>
            <td>
                <input type="checkbox" name="symptom.yes" value="Xuất huyết ngoài da"/>
            </td>
            <td><input type="checkbox"/></td>

            <td>
                nổi ban ngoài da <span class="text-color-red">(*)</span>
            </td>
            <td>
                <input type="checkbox" name="symptom.yes" value="nổi ban ngoài da"/>
            </td>
            <td><input type="checkbox"/></td>
        </tr>

        <tr>
            <td colspan="4">Lịch sử phơi nhiễm: Trong vonng 14 ngày qua, Anh/Chị có <span
                    class="text-color-red">(*)</span></td>
        </tr>
        <tr>
            <td></td>
            <td>Có</td>
            <td>Không</td>
        </tr>
        <tr>
            <form:hidden path="exposureHistory"/>
            <td>Đến trang traại chăn nuôi/ chợ buôn bán động vật sống / cơ sở giết mổ động vật / tiếp xúc động vật <span
                    class="text-color-red">(*)</span></td>
            <td>
                <input type="checkbox" name="exposureHistory" value="Có tiếp xúc"/>
            </td>
            <td><input type="checkbox"/></td>
        </tr>
        <tr>
            <td>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV<span class="text-color-red">(*)</span>
            </td>
            <td>
                <input type="checkbox" name="exposureHistory" value="Có tiếp xúc"/>
            </td>
            <td><input type="checkbox"/></td>
        </tr>
        <tr>
            <p class="text-color-red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc chống dịch, thuộc
                quản lý của ban chỉ đạo quốc gia về phòng chóng dịch
                Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý</p>
        </tr>
        <tr>
            <td colspan="4">
                <button>GỬI TỜ KHAI</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
