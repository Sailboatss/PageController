<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 2017/8/15
  Time: 上午9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>首页</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.js" type="text/javascript"></script>






</head>
<body>




<%--两侧留出空白--%>

<div class="container">
<%--col-md-offset-3向右偏移三格--%>
    <%--<button type="button" class="btn btn-primary col-md-6 col-md-offset-3">（首选项）Primary</button>--%>

    <div class="input-group">
        <input id="content" type="text" class="form-control" placeholder="请输入留言...">
        <span class="input-group-btn">
        <button id="btn" class="btn btn-info" type="button">发布</button>
      </span>
    </div>

    <table id="tab" class="table" >

    </table>
</div>


<nav aria-label="Page navigation" class="text-right">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>



</body>

<script>


    $("#btn").click(function(){
        $.ajax({
            url:"/addnew",
            type:"get",
            data:{
                content:$("#content").val()
            },

            success:function (result) {

                console.log(result)

                addNewTR(0,result.content,0,0)
            }
        })




    })

    function addNewTR(id, content, upCount, downCount) {

        var tdleft = $("<td></td>").html("<p class='text-center'>"+content+"</p>")

        var tdright = $("<td></td>")

        tdright.append("顶:")
        $("<a href='#'></a>").html(upCount).appendTo(tdright).attr("topId",id).click(topTop)

        tdright.append("踩:")
        $("<a href='#'></a>").html(downCount).appendTo(tdright).attr("downId",id).click(downCountId)

        $("<a href='#'>删除</a>").appendTo(tdright).attr("num",id).click(delfunc)

        var trOb = $("<tr></tr>").append(tdleft).append(tdright).attr("id","ss"+id)

        $("#tab").append(trOb)
    }


    function getAllMessage() {
        $.ajax({
            url:"/getall",
            success:function (result){
                for (var i = 0; i < result.length; i++){
                    var msg = result[i];
                    addNewTR(msg.id,msg.content,msg.upCount,msg.downCount)
                }
            }

        })
    }



    getAllMessage()

    var delfunc = function () {
        var aid = $(this).attr("num")

        $.ajax({
            url:"/deleteId",
            type:"get",
            data:{
                id:aid
            },
            success:function(result){
                $("#ss"+aid).remove()
            }
        })

    }

    var topTop = function () {

        var topId = $(this).attr("topId")

        $.ajax({
            url:"/top",
            type:"get",
            data:{
                topId:topId
            }
        })
        window.location.reload();
    }

    var downCountId = function () {

        var downId = $(this).attr("downId")
        $.ajax({
            url:"/downCountStep",
            type:"get",
            data:{
                downCountId:downId
            }
        })
        window.location.reload()


    }




</script>




</html>
