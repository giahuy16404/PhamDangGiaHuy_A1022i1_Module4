display();

function display() {
    let content = "";
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/api/account/list?page=0&size=1",
        success: function (data) {
            data = data.content
            console.log(data)
            for (let i = 0; i < data.length; i++) {
                content +=
                    " <tr>\n" +
                    "        <td>" + (i + 1) + "</td>\n" +
                    "        <td>" + data[i].user.username + "</td>\n" +
                    "        <td>" + data[i].role.name + "</td>\n" +
                    "    </tr>";
            }
            $("#content-table").html(content);
        }
    })
}

//show more
function showMore() {
    if (typeof showMore.currentPage === 'undefined') {
        showMore.currentPage = 0;
    }
    showMore.currentPage++;
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/api/account/list?page=" + showMore.currentPage + "&size=1",
        success: function (data) {
            data = data.content;
            console.log(data);
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content +=
                    " <tr>\n" +
                    "        <td>" + (i + 1) + "</td>\n" +
                    "        <td>" + data[i].user.username + "</td>\n" +
                    "        <td>" + data[i].role.name + "</td>\n" +
                    "    </tr>";
            }
            $("#content-table").append(content);
        }
    });
}


function searchByName() {
    let valueSearch = $("#search-name").val();
    let content = "";
    $.ajax({
        contentType: "application/json",
        type: "POST",
        dataType: "json",
        url: "http://localhost:8080/api/account/find-by-name-user?&page=0&size=5&name=" + valueSearch,
        success: function (data) {
            data = data.content;
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                content +=
                    " <tr>\n" +
                    "        <td>" + (i + 1) + "</td>\n" +
                    "        <td>" + data[i].user.username + "</td>\n" +
                    "        <td>" + data[i].role.name + "</td>\n" +
                    "    </tr>";
            }
            $("#content-table").html(content);
        }
    });
}

