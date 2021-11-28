(function ($) {
	var seats = [];
	 $(document).ready(function () {
    	// Nice Select
   		 $('.select-bar').niceSelect();
   		 $('.seat-book').each(function() {
   		 	var row = $(this).closest('.seat-line').find('.seat-row').text();
        	var col = $(this).find('.sit-num').text();
        	seats.push(row + col + " ");
        	var seatsString = "";
	        for (let i = 0; i < seats.length; i++) {
	        	seatsString += seats[i];
	        }
	        var sc = document.querySelector('.seat-choice');
	        sc.innerHTML = seatsString;
	        var price = seats.length * 10;
	        var tp = document.querySelector('.total-price');
	        tp.innerHTML = "$" + price;
	        $('.seats-input').attr("value", seatsString);
   		 });
   		 var book = document.querySelector('.seat-book');
   		 if (book) {
   		 	$('.proceed-book').removeClass('hide');
        } 
   	})
   	
   	   	
   	 $(".seat").on('click', function(e) {
        $(this).toggleClass('seat-book');
        var row = $(this).closest('.seat-line').find('.seat-row').text();
        var col = $(this).find('.sit-num').text();
        var pos = seats.indexOf(row + col + " ");
        if (pos == -1) {
        	seats.push(row + col + " ");	
        } 
        else {
        	seats.splice(pos, 1);
        }
        var seatsString = "";
        for (let i = 0; i < seats.length; i++) {
        	seatsString += seats[i];
        }
        var sc = document.querySelector('.seat-choice');
        sc.innerHTML = seatsString;
        var price = seats.length * 10;
        var tp = document.querySelector('.total-price');
        tp.innerHTML = "$" + price;
        $('.seats-input').attr("value", seatsString);
        if (seats.length != 0) {
        	$('.proceed-book').removeClass('hide');
        } 
        else {
        	$('.proceed-book').addClass('hide');
        }
    });
    
    $(".ticket-form").on('click', function(e) {
    	$(this).submit();
    });
    
})(jQuery);

function check_pass(){
	var pass1=document.getElementById('pass1').value;
	var pass2=document.getElementById('pass2').value;
	if(pass1!=pass2){
		document.getElementById('icon-green').style.display='none';
		document.getElementById('icon-red').style.display='block';
		document.getElementById('submit').disabled=true;
	}
	else{
		document.getElementById('icon-red').style.display='none';
		document.getElementById('icon-green').style.display='block';
		document.getElementById('submit').disabled=false;
	}
}
