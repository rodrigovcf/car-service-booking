
$("#slotform").validate({
	errorLabelContainer: "#error",
	wrapper: "li",
	rules:{
		name:{
			required: true
		},
		slot:{
			required: true,
			minlength: 3,
			maxlength: 4
		}
	},
	messages:{
		name:{
			required: 'Please fill out this field.(name)'
		},
		slot:{
			required: 'Please fill out this field.(slot)',
			minlength: 'The token must contain min 3 characters.(slot)',
			maxlength: 'The token must contain max 4 characters.(slot)'
		}
	},
	
  submitHandler: function(form) {
    form.submit();
  }
 });


 