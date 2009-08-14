AJS.toInit(function($) {

  // To get the chat URL: /rest/chat/1/lhardy/chat
  // where lhardy is the name of the user you want to chat with.
  
  // presence will be available at /rest/chat/1/lhardy when Dave gets it working.

  // Wax on, wax off
  AJS.$(".confluence-userlink").hover(
    function () {
      var matched = /username:([^ ]*).+userlink-(\d*)/.exec($(this).attr("class")),
          username = matched[1],
          userIndex = matched[2];
      
      setTimeout(function () {
        checkStatus(username, userIndex);
      }, 1000); 
    }, 
    function () {
      // necessary?
    }
  );
  
  // Checks and displays chat status
  var checkStatus = function(username, userIndex){
    var $profile = AJS.$("#content-hover-" + userIndex); // Target user-specific content-hover
    if ($profile) {
      $profile.toggleClass("confluence-chat-plugin"); // Provide scope for CSS
      
      
      
      var linkText = "Chat with " + AJS.$("a.fn", $profile).text(),
          getChatURL = location.protocol + "//" + location.host + "/confluence/rest/chat/1/" + username + "/chat.json";
          console.log(getChatURL);
          
          var linkHref = "test";
          $.getJSON(getChatURL,
            function(data){
              alert(data);
          });
          console.log(linkHref);
          
    
      var $chatLink = AJS.$("<a class=\"plugin-chat-link\"></a>").attr("href", linkHref).append(linkText);
      
      AJS.$(".values", $profile).append($chatLink);
      
     // Call clearStatus TODO: make not buggy
      $profile.add(AJS.$(".user-popup-menu-admin")).mouseleave(function() {
        // console.log("called?");
        setTimeout(clearStatus, 1000);
      });
    }
  };

  // Clears all changes
  var clearStatus = function() {
      AJS.$(".plugin-chat-link").remove();
      AJS.$(".profile-macro", ".ajs-content-hover").toggleClass("confluence-chat-plugin");
  };

})(AJS.$);