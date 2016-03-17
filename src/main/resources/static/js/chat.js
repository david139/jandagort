$(document).ready(function(){
    $("form#sendChatMessage").submit(function(e){
        e.preventDefault();
        var message = $("#message").val();
        $.ajax({
            type: "POST",
            url: "chat",
            data: {"content": message },
            success: function(){
                console.log("success");
                $('#message').val('');
            }
        });
    });
});

$(document).ready(function() {
    var $chatMessages = $("#chat-messages");
    var socket = new SockJS('/chatsocket');
    var stompClient = Stomp.over(socket);
    scrollDown();
    stompClient.connect({ }, function(frame) {
        stompClient.subscribe("/chat/public", function(data) {
            var message = data.body;
            $chatMessages.append("<li>" + message + "</li>");
            scrollDown();
        });
    });
});

function scrollDown(){
    var $chatWindow = $("#chat-window");
    $chatWindow.scrollTop($chatWindow.prop("scrollHeight"));
}