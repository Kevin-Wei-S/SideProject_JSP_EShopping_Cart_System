$(function(){
	
	$(".btn").click(function(){
		var name = $(this).attr("name");
		return confirm("您要選購 <" + name + "> 嗎?");
		
	})
	
})