
$("#entertoken").validate({
	errorLabelContainer: "#error",
	wrapper: "li",
	rules:{
		token:{
			required: true
			
		}
	},
	messages:{
		token:{
			required: 'Please fill out this field.(token)'
			
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
 
 
 
 
 