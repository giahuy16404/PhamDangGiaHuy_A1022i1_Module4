function update() {
    let id = $("#id").val();
    let name = $("#name").val();
    let img = $("#img").val();
    let des = $("#des").val();
    let quantity = $("#quantity").val();
    let discount = $("#discount").val();
    const product = {
        id: id,
        name: name,
        image: img,
        description: des,
        quantity: quantity,
        discount: discount
    }
    console.log(product);
    $.ajax({
        contentType: "application/json",
        type: "PATCH",
        dataType: "json",
        data: JSON.stringify(product),
        url: "http://localhost:8080/api/product/update",
        success: function () {
            alert("update thành công ")
        }
    })

}

function findById(id) {
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/api/product/findById?id=" + id,
        success: function (data) {
            console.log(data);
            let content = "";
            content +=
                "<tr>\n" +
                "    <td><input type=\"hidden\" value=\"" + data.id + "\" id=\"id\"></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td>Name:</td>\n" +
                "    <td><input type=\"text\" value=\"" + data.name + "\" id=\"name\"></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td>Image:</td>\n" +
                "    <td><img src=\"../../static/img/" + data.image + "\" id=\"img\" width='50' height='50'></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td>Description:</td>\n" +
                "    <td><input type=\"text\" value=\"" + data.description + "\" id=\"des\" ></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td>Quantity:</td>\n" +
                "    <td><input type=\"number\" value=\"" + data.quantity + "\" id=\"quantity\"></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "    <td>Discount:</td>\n" +
                "    <td><input type=\"number\" value=\"" + data.discount + "\" id=\"discount\"></td>\n" +
                "</tr>";
            $("#table-content").html(content);
        }
    })
}