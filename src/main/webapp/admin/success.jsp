<%--
Created by IntelliJ IDEA.
User: fyl2003
Date: 2022/9/23
Time: 18:45
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户</title>

</head>
<body>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"></script>

<div style="float: right;width: 200px;" >
    <form action="${pageContext.request.contextPath}/quit" style="float: right">
        <input  style="background-color: red" type="submit" value="logout">
    </form>
    <br>
    <span  style="float: right">${user.userId}</span>

</div>
<br>
<div style="text-align:center;margin-top:100px;width: 1700px;">
    <tr>
    日期<input type="date" id="date">
    <button style="width: 100px;height: 20px;background-color: chartreuse"  onclick="submitDay()">每日查询</button>
    <button style="width: 100px;height: 20px;background-color: chartreuse"  onclick="submitMonth()">按月查询</button>
        <button style="width: 100px;height: 20px;background-color: chartreuse"  onclick="submitMonth2Xls()">按月导出</button>

    </tr>
    <table>
        <tbody id="result"></tbody>
    </table>
</div>
<script type="text/javascript">
    function submitMonth2Xls(){



        $.ajax({

            url:"${pageContext.request.contextPath}/selectByMonth2xls",
            xhrFields: {
                responseType: "arraybuffer"
            },
            //路径
            contentType: "application/json",

            data: {"date":$("#date").val(),"grade":${user.grade}},
            success:function(data){

                /* 文件下载 */
                let blob = new Blob([data], {
                    type: "application/vnd.ms-excel;charset=UTF-8"
                })
                let downloadUrl = window.URL.createObjectURL(blob)
                let link = document.createElement('a')
                link.href = downloadUrl
                var date =$("#date").val();
                var con=date.split('-');
                var conn=con[0]+"-"+con[1];
                link.download = conn+'汇报情况.xlsx';
                document.body.appendChild(link)
                link.click()
                document.body.removeChild(link)
                window.URL.revokeObjectURL(downloadUrl)
            }



        });
    }
    function submitDay(){
        $.ajax({
            url:"${pageContext.request.contextPath}/select",
            data: {"date":$("#date").val(),"grade":${user.grade}},
            success: function (data){
                var html="";
                html+="<tr>"+
                    "<td class='t1'>"+"班级"+"</td>"+
                    "<td class='t2''>"+"具体情况"+"</td>"+"<tr>";
                if(data.length==0){
                    html+="<tr>"+
                        "<td class='t1'>"+"目前无人填报"+"</td>"+
                        "<td class='t2''>"+"目前无人填报"+"</td>"+"<tr>";
                }
                if(data!=null){
                    for(var i=0;i<data.length;i++){
                        html+="<tr>"+
                            "<td class='t1'>"+data[i].gradeAndClass+"</td>"+
                            "<td class='t2''>"+data[i].inf+"</td>"+"<tr>";

                    }
                }

                $("#result").html(html);
            }


        });
    }
    function submitMonth(){
        $.ajax({
            url:"${pageContext.request.contextPath}/selectByMonth",
            data: {"date":$("#date").val(),"grade":${user.grade}},
            success: function (data){
                var html="";
                html+="<tr>"+
                    "<td class='t3'>"+"日期"+"</td>"+
                    "<td class='t4'>"+"班级"+"</td>"+
                    "<td class='t5''>"+"具体情况"+"</td>"+"<tr>";
                if(data.length==0){
                    html+="<tr>"+
                        "<td class='t3'>"+"日期"+"</td>"+
                        "<td class='t4'>"+"目前无人填报"+"</td>"+
                        "<td class='t5''>"+"目前无人填报"+"</td>"+"<tr>";
                }
                if(data!=null){
                    for(var i=0;i<data.length;i++){
                        html+="<tr>"+
                            "<td class='t3'>"+data[i].date+"</td>"+
                            "<td class='t4'>"+data[i].gradeAndClass+"</td>"+
                            "<td class='t5''>"+data[i].inf+"</td>"+"<tr>";

                    }
                }

                $("#result").html(html);
            }


        });
    }




</script>
</body>
</html>
<style type="text/css">
    body{
        background-size: cover;
        background-attachment: fixed;
        background-image: url("${pageContext.request.contextPath}/img/p1.jpg");
        background-repeat: no-repeat;
    }

    .t1{
        width: 100px;
    }
    .t2{
        width: 1500px;
    }
    .t3{
        width: 100px;
    }
    .t4{
        width: 100px;
    }
    .t5{
        width: 1300px;
    }
    tr{
        border:1px  solid cyan;
    }
    td{
        word-break: break-all;
        border:1px  solid cyan

    }
</style>
