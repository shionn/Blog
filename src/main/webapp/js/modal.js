"use strict";
$(function() {
	$.fn.extend({
		__modalClose : function() {
			$(this).css("display","none");
			$(this).removeClass("fade");
		},
		__modalOpen : function() {
			$(this).css("display","block");
			$(this).addClass("fade");
		}, 
		modal : function() {
			$(this).on("click", function(e) {
				if (e.target == this) $(e.target).__modalClose();
			});
			
			$(this).__modalOpen();
		}
	});
});