<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <title>填报</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"></script>
<script>

    function match(num){
        var idName="tips"+num;
        document.getElementById(idName).style.display="block";
        //获取div提示对象
        var tips = document.getElementById(idName);
        //清空提示内容
        tips.innerHTML="";


        $.ajax({
            url:"${pageContext.request.contextPath}/match",
            type:"post",
            dataType:"text",
            //将文本框的值作为发送的数据
            data:{"gradeAndClass":$("#gradeAndClass").val(),"content":document.getElementsByName("name")[num].value},
            success:function (result) {

                //当用户输入的内容为空的时候
                if (result==null){//没有查询到相应数据
                    //去掉边框样式并停止下面的操作
                    tips.style.border="none";
                    return;
                }
                var divs ="";
                result=result.split(",");
                //遍历结果集
                for (var i =0;i<result.length;i++){
                    //将遍历的结果拼接在div中存储在divs变量中
                    result[i]=result[i].replaceAll("\"","")
                    result[i]=result[i].replaceAll("[","")
                    result[i]=result[i].replaceAll("]","")
                    divs+="<div onclick='setInput(\""+result[i]+"\""+","+num+"\)' style='border: 1px solid black;background-color: mediumspringgreen'>"+result[i]+"</div>";
                }
                //将拼接的html代码块显示在查询的结果集
                tips.innerHTML=divs;

                //将盒子设置为显示
                tips.style.border="1px solid black";



            },error:function () {
                alert("请求失败")
            }
        })
    }


    function setInput(content,num){
        var idName="tips"+num;
        document.getElementsByName("name")[num].value = content;
        document.getElementById(idName).style.display="none";
    }

    function showIn(){
        var num=document.getElementsByName("total")[0].value;
        var html="";
        html+="班级<input type='text' name='gradeAndClass' style='width: 200px; height:auto ;background-color: rgba(0,0,0,0);' id='gradeAndClass'><br><br>";
        for(var i=0;i<num;i++){
            html+= "姓名<input type='text' style='width: 200px; height:auto ;background-color: rgba(0,0,0,0);' name='name' onkeyup='match("+i+")' >";
            var idName="tips"+i;
            html+="<div id='"+idName+"' style='width: 200px; height:auto ;border:0px;margin-left:20px;text-align: left;display: none;'> </div>";
            html+="<br>"+"原因<input type='text' style='width: 200px; height:auto ;background-color: rgba(0,0,0,0);' name='reason'>"+"<br><br>";
        }
        html+="<br><input type='submit' value='提交'>";
        document.getElementById("out").innerHTML=html;
    }
</script>

<body style="background-color: lavender">
<div style="text-align: center;top: 0">
    <img src="${pageContext.request.contextPath}/img/back2.jpg" style="width: 100%;"/>
</div>
<div>
    <div style="margin: auto;text-align: center;">
        请输入填报人数
        <input name="total" style="background-color: rgba(0,0,0,0);border-color:white;border-bottom-width: 1px">
        <button onclick="showIn()" style="background-color: transparent">确定</button>
    </div>
    <br>

    <div id="divSearch" style="margin: auto;text-align: center; width: 250px;">
        <form action="${pageContext.request.contextPath}/submit2" method="post">
            <div id="out"></div>
        </form>
    </div>
    <!--根据用户输入的内容显示出来的盒子-->


</div>

<a style="position:fixed;bottom: 0;" href="${pageContext.request.contextPath}/admin/submitDetail.html">填报细则</a>

</body>

</html>