AJS.toInit(function($) {

  // presence will be available at /rest/chat/1/lhardy when Dave gets it working.

  // Wax on, wax off
  AJS.$(".confluence-userlink").hover(
    function () {
      var matched = /username:([^ ]*).+userlink-(\d*)/.exec($(this).attr("class")),
          username = matched[1],
          userIndex = matched[2];
      
      setTimeout(function () {
        checkStatus(username, userIndex);
      }, 500); 
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
      var chatURL = location.protocol + "//" + location.host + "/confluence/rest/chat/1/" + username,
          getPresenceURL = chatURL + ".json",
          getChatURL = chatURL + "/chat.json";
      
      $.getJSON(getPresenceURL,
        function(presence){
          $.getJSON(getChatURL,
            function(data){
              buildLink(data.url, $profile, presence.online);
          });          
      });
      
     // Call clearStatus TODO: make not buggy
      $profile.add(AJS.$(".user-popup-menu-admin")).mouseleave(function() {
        setTimeout(clearStatus, 1000);
      });
    }
  };

  var buildLink = function(url, $profile, online){
    console.log(online);
    var $chatLink = AJS.$("<a class=\"plugin-chat-link\"></a>")
                      .attr("href", url)
                      .text("Chat");
        $chatLink.prepend("<span>&nbsp;</span>");
        if (online == true) {
          $chatLink.addClass("online");
        }
    
    AJS.$(".values", $profile).append($chatLink);
  }

  // Clears all changes
  var clearStatus = function() {
      AJS.$(".plugin-chat-link").remove();
      AJS.$(".profile-macro", ".ajs-content-hover").toggleClass("confluence-chat-plugin");
  };

})(AJS.$);