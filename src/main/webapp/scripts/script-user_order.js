$(function(){    

            var idInfo = null;            

           $('.forward').click(function(){
			   
               info = $(this).text(); 
               idInfo = $(this).parent().find("td").first().text();               

               var content = 
                    "<div id='areaA'></div>" +
                    "<div id='areaZ'>" + 
                        "<div id='idInfo'><span >" + "訂單編號: " + idInfo + "</span></div>"+
                        "<div>" +  
                            "<input type='radio' id='status-2' name='status' value='2' class='status'>" +
                            "<label for='status-2' style='color: royalblue;'>已簽收</label>" +
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
               
                    } else {
						alert("請選擇 <已簽收> 並且 <更新> 或者 <取消>");
					}
               })

               $("#delete").click(function(){
                $('#updateContent').html("");
               })

           })

        })