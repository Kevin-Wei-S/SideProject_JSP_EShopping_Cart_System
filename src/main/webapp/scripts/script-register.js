$(function(){
    $('#userName').focus(); 
    
    $('#register').click(function(){

        var userNameText = $('#userName').val();
        var regexUserName = /^[-\w\u4e00-\u9fa5]{1,12}$/;
        if(!regexUserName.test(userNameText)){
            $('#error').text('姓名格式不正確!');
            return false;
        }

        var accountText = $('#account').val();
        var regexAccount = /^[\w-]{5,12}$/;
        if(!regexAccount.test(accountText)){
            $('#error').text('帳號格式不正確!');
            return false;
        }

        var emailText = $('#email').val();
        var regexEmail = /^[-\w+]+([.][-\w+]+)*@([a-zA-Z0-9]+([-]*[a-zA-Z0-9]+)*)([.][a-zA-Z0-9]+([-]*[a-zA-z0-9]+)*)*$/;
        if(!regexEmail.test(emailText)){
            $('#error').text('E-mail格式不正確!');
            return false;
        }

        var cellPhoneText = $('#phone').val();
        var regexCellPhone = /^[0][9][0-9]{8}$/;
        if(!regexCellPhone.test(cellPhoneText)){
            $('#error').text('手機格式不正確!');
            return false;
        }

        var passwordText = $('#password').val();
        var regexPassword = /^[\w-!@#$%&*]{5,12}$/;
        if(!regexPassword.test(passwordText)){
            $('#error').text('密碼格式不正確!');
            return false;
        }

        var checkedText = $('#checked').val();
        if(passwordText !== checkedText){
            $('#error').text('請輸入相同密碼!')
            return false;
        }

    
        $('#error').text('');
    });
    
    // 刷新驗證碼
    $('#refresh').click(function(){
	
		$('#token').attr('src', 'http://localhost:8080/BM02/kaptcha.jpg?d=' + new Date());

	})
	
	// 帳號是否已註冊
	$("#account").change(function(){
		
		var account = $("#account").val();
		
		$.getJSON("http://localhost:8080/BM02/userServlet", "action=doubleAccount&account=" + account, function(info){
			
			if(info.existsAccount){
				
				$("#error").text("此帳號已被註冊");
			
			} else{
				
				$("#error").text("");
			
			}
		
		});
		
	});
    
    
});