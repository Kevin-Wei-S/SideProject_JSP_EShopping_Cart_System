$(function(){
	
	// 在事件function函數中, 有一個this對象, 是當前正在響應事件的DOM對象
	$('.delete').on('click', function(){
		return confirm("確定要刪除項目<-" + $(this).parent().parent().children("td").eq(1).text() + "->嗎?");
	})

})