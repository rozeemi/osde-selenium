$(document).ready(function(){
	$(".add-row").click(function(){
    	var name = $("#name").val();
        var email = $("#email").val();
        var identification = $("#id").val();
        var markup = "<tr><td>"+identification+ "</td><td>" + name + "</td><td>" + email + "</td>"+"<td> <input type='checkbox' name='record'>"+"</td>"+"</tr>";
        $("table tbody").append(markup);
        });
        
        // Find and remove selected table rows
        $(".delete-row").click(function(){
            $("table tbody").find('input[name="record"]').each(function(){
            	if($(this).is(":checked")){
                    $(this).parents("tr").remove();
                }
            });
        });
});  






 