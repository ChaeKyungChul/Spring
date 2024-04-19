$(document).ready(function(){
  
    $('ul.tabs li').click(function(){
      var tab_id = $(this).attr('data-tab');
  
      $('ul.tabs li').removeClass('current');
      $('.tab-content').removeClass('current');
  
      $(this).addClass('current');
      $("#"+tab_id).addClass('current');
      
    })
  
  })

 $(function(){
    $('.bt').click(function(){
        alert("수강신청 하시겠습니까?");
    })
 });

