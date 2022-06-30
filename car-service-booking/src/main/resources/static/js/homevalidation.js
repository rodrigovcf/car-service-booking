
$("#entertoken").validate({
	errorLabelContainer: "#error",
	wrapper: "li",
	rules:{
		token:{
			required: true,
			minlength: 10,
			maxlength: 10
		}
	},
	messages:{
		token:{
			required: 'Please fill out this field.(token)',
			minlength: 'The token must contain 10 characters(token)',
			maxlength: 'The token must contain 10 characters(token)'
		}
	},
	
  submitHandler: function(form) {
    form.submit();
  }
 });
 
 $("#enterdate").validate({
	errorLabelContainer: "#error",
	wrapper: "li",
	rules:{
		date:{
			required: true,
			dateISO: true,
			date:false
			
		}
	},
	messages:{
		date:{
			required: 'Please fill out this field.(date)'
		}
	},
	
  submitHandler: function(form) {
    form.submit();
  }
 });
 
 
 
 
 