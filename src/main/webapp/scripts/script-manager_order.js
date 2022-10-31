$(function(){    

            var info = null;
            var idInfo = null;
            var checked0 = null
            var checked1 = null

           $('.ready, .forward').click(function(){
			   
               info = $(this).text(); 
               idInfo = $(this).parent().find("td").first().text();
               
               if(info == "未出貨") {
					checked0 = "checked";
			   } else {
					checked0 = null;
			   }
			   
			   if(info == "已出貨") {
					checked1 = "checked"; 
			   } else {
					checked1 = null;
			   }

               var content = 
                    "<div id='areaA'></div>" +
                    "<div id='areaZ'>" + 
                        "<div id='idInfo'><span >" + "訂單編號: " + idInfo + "</span></div>"+
                        "<div>" +
                            "<input type='radio' id='status-0'" + checked0 + " name='status' value='0' class='status'>" +
                            "<label for='status-0'>未出貨</label>" +
                            "<input type='radio' id='status-1'" + checked1 + " name='status' value='1' class='status'>" +
                            "<label for='status-1'>已出貨</label>" +
                        "</div>" +
                        "<div id='statusBtn'>" +
                            "<button class='statusBtn' id='update'>更新</button>" +
                            "<button class='statusBtn' id='delete'>取消</button>" +
                        "</div>" +
                    "</div>";

               $('#updateContent').html(content);

               $("#update").click(function(){
                    var status = $("input:radio[name='status']:checked").val();
                                
                    if(status != null){
                        
                        location.href = "http://localhost:8080/BM02/orderServlet?action=sendOrder&status=" + status + "&orderId=" + idInfo;
                        $('#updateContent').html("");
               
                    }
               })

               $("#delete").click(function(){
                $('#updateContent').html("");
               })

           })

        })