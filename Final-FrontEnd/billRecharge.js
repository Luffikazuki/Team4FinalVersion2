$(document).ready(function(){

  $("#dongle").click(function(){
    $("#dongle-table").show();
    $("#postPaid-table").hide();
    $("#postPaid-div").hide();
    $("#topUp-div").hide();
    $("#dongle-div").show();
    $("#dongle").addClass("active");
    $("#postPaid").removeClass("active");
    $("#topUp").removeClass("active");

  });

  $("#postPaid").click(function(){
    $("#dongle-table").hide();
    $("#postPaid-table").show();
    $("#dongle-div").hide();
    $("#topUp-div").hide();
    $("#postPaid-div").show();
    $("#dongle").removeClass("active");
    $("#topUp").removeClass("active");
    $("#postPaid").addClass("active");

  });

  $("#topUp").click(function(){
    $("#topUp").addClass("active");
    $("#postPaid").removeClass("active");
    $("#dongle").removeClass("active");
    $("#topUp-div").show();
    $("#postPaid-div").hide();
    $("#dongle-div").hide();
  });



  //Toggle between recharge and Bill pay in Post Paid Start here
  $("#PostPaid-Plan").click(function(){
    $("#PostPaid-Plan").css("background","#0076ff");
    $("#PostPaid-Plan").css("color","white");
    $("#PostPaid-bill").css("background","white");
    $("#PostPaid-bill").css("color","#0076ff");
    $("#PostPaid-planDetails").css("display","contents"); //To display the contents as it is
    $("#PostPaid-billDetails").css("display","none");
    $("#PostPaid-makePayment").hide();
  });

  $("#PostPaid-bill").click(function(){
    $("#PostPaid-bill").css("background","#0076ff");
    $("#PostPaid-bill").css("color","white");
    $("#PostPaid-Plan").css("background","white");
    $("#PostPaid-Plan").css("color","#0076ff");
    $("#PostPaid-planDetails").css("display","none");
    $("#PostPaid-billDetails").css("display","contents");
    $("#PostPaid-makePayment").show();
  });

    //Toggle between recharge and Bill pay in Post Paid End here

    //Toggle between recharge and Bill pay in Dongle Start here
    $("#dongle-plan").click(function(){
      $("#dongle-plan").css("background","#0076ff");
      $("#dongle-plan").css("color","white");
      $("#dongle-bill").css("background","white");
      $("#dongle-bill").css("color","#0076ff");
      $("#dongle-planDetails").css("display","contents"); //To display the contents as it is
      $("#dongle-billDetails").css("display","none");
      $("#dongle-makePayment").hide();
    });

    $("#dongle-bill").click(function(){
      $("#dongle-bill").css("background","#0076ff");
      $("#dongle-bill").css("color","white");
      $("#dongle-plan").css("background","white");
      $("#dongle-plan").css("color","#0076ff");
      $("#dongle-planDetails").css("display","none");
      $("#dongle-billDetails").css("display","contents");
      $("#dongle-makePayment").show();
    });

      //Toggle between recharge and Bill pay in Dongle End here

      $("#topUp-postPaid").click(function(){
        $("#topUp-postPaid").css("background","#0076ff");
        $("#topUp-postPaid").css("color","white");
        $("#topUp-dongle").css("background","white");
        $("#topUp-dongle").css("color","#0076ff");
        $("#topUp-donglePlans").css("display","none");
        $("#topUp-postPaidPlans").css("display","contents");
      });

      $("#topUp-dongle").click(function(){
        $("#topUp-dongle").css("background","#0076ff");
        $("#topUp-dongle").css("color","white");
        $("#topUp-postPaid").css("background","white");
        $("#topUp-postPaid").css("color","#0076ff");
        $("#topUp-postPaidPlans").css("display","none");
        $("#topUp-donglePlans").css("display","contents");
      });




});
