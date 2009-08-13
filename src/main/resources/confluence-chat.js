AJS.toInit(function($) {

  AJS.$(".confluence-userlink").hover(
    function () {
      setTimeout(checkStatus, 1000); 
    }, 
    function () {
      // necessary?
    }
  );
  
  var checkStatus = function(testInterval){
    var profile = AJS.$(".profile-macro", ".ajs-content-hover");
    if (profile) {
      console.log("do something useful here");
    }
  };

})(AJS.$);