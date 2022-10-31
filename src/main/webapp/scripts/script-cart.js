$(function(){
	
	// change事件 內容值發生改變才觸發
	
	$(".cartCount").change(function(){
		var id = $(this).attr("foodStuffId"); 	
		var name = $(this).parent().parent().find("td").eq(1).text();
		var count = $(this).val();
		
		if(confirm("確定要更新 <"+ name +">" + " 數量為: " + count + "(單位)嗎?")){
			location.href = "http://localhost:8080/BM02/cartServlet?action=updateCount&count=" + count + "&id=" + id;				
		} else {
				//default屬性是表單項DOM對象的屬性 它表示默認的屬性值
				this.value = this.defaultValue;
		}
		
				
	})
	
	// 轉移焦點時觸發 需自行判斷 change事件更為簡潔
	/*var preCount = -1;
	
	$(".cartCount").click(function(){	
		preCount = $(this).val();
	})  
	
	$(".cartCount").focusout(function(){
		var id = $(this).attr("foodStuffId"); 	
		var name = $(this).parent().parent().find("td").eq(1).text();
		var count = $(this).val();
		
		if(preCount != count){
			if(confirm("確定要更新 <"+ name +">" + " 數量為: " + count + "(單位)嗎?")){
				location.href = "http://localhost:8080/BM02/cartServlet?action=updateCount&count=" + count + "&id=" + id;				
			} else {
				$(this).val(preCount);
			}
		}  
				
	})*/
	
	$(".cartDelete").click(function(){
		var name = $(this).parent().parent().find("td").eq(1).text();
		
		return confirm("確定要刪除 <" + name + "> 嗎?");
		
	})
	
	$("#cartClear").click(function(){
		
		return confirm("確定要 <清空購物車> 嗎?");
		
	})
	
	$("#cartBill").click(function(){
		
		return confirm("<確定>購物車內品項並且<結帳>嗎?")
		
	})
	
})













// GJ! 邏輯挑戰賽 - PASS
/*var preCount = -1;

$(function(){
	
	$(".cartDelete").click(function(){		
		return confirm("要刪除 <" + $(this).parent().parent().find("td").eq(1).text() + "> 嗎?");
	})

	$(".cartCount").click(function(){
		preCount = $(this).val();
	})
	
	$(".cartCount").focusout(function(){
		if($(this).val()==preCount){
				
		} else{		
			if(confirm("確定 更新<"+ $(this).parent().parent().find("td").eq(1).text() +">數量為: " + $(this).val() + " (單位)嗎?")){
			location.href = "http://localhost:8080/BM02/cartServlet?action=updateCount&count=" + $(this).val() + 
							"&id=" + $(this).parent().attr("id");
			} else{
				$(this).val(preCount);
			}
		}
	})
	
})*/