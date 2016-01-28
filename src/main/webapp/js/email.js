var sendAjax =  function(url) {
 
    var postString = "";
    $.ajax({
 
        type: "POST",
        url: url,
        data: postString,   //post 형식 전송형태 data: {인자명 : 데이터, num:num},
        success: function(msg) {
            //body 태그 안에서 div로 innerHTML을 적용한 영역을 지정하고 
            //버튼 클릭시 지정한 영역에 HTML을 삽입한다.
            document.getElementById("execute").innerHTML = msg;
        }
    });
 };