var departmentEdit = [];

function openGroupDetail(id){
    $(".main-content").load("groupdetail.html");
    $.get("http://localhost:8080/departments/"+id, function(data, status){
        
        // reset list departments
        departmentEdit = [];

        // error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        var html = '<table>';
        html += '<tr><th>Department Name</th><td>'+ data.name +'</td></tr>';
        html += '</table>';

        var html1 = '<div class="btnedit">'+
                        '<button type="button" class="btn2 btn-info add-new1" data-toggle="modal" onclick="openEditModal('+ id +')"><i class="far fa-edit" style="font-size:24px"></i>Edit</button>'+
                    '</div>';
        document.getElementById('container-groupdetail').innerHTML = html;
        document.getElementById('container-btnedit').innerHTML = html1;
    });
}

function openEditModal(id){
    var index = departments.findIndex(x => x.id == id);

    document.getElementById("id").value = departments[index].id;
    document.getElementById("name").value = departments[index].name;
    
    showModalEdit();
}

function showModalEdit(){
    $('#myModalEdit').modal('show');
}

function hideModalEdit(){
    $('#myModalEdit').modal('hide'); 
}

function saveEdit(){
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;

    var index = departments.findIndex(x => x.id == id);

    if(name != ""){
        if(name == departments[index].name){
            alert("Have not changed the new name!");
        }
        else{
            if(checkNameGroup(name)){
                var department = {
                    name: name
                };
            
                // $.ajax({
                //     url: 'http://localhost:8080/departments/' + id,
                //     type: 'PUT',
                //     data: department,
                //     success: function(result) {
                //         // error
                //         if (result == undefined || result == null) {
                //             alert("Error when loading data");
                //             return;
                //         }
            
                //         // success
                //         hideModalEdit();
                //         showSuccessAlert1();
                //         openGroupDetail(id);
                //         console.log('done');
                //     }
                // });

                $.ajax({
                    url: 'http://localhost:8080/departments/' + id,
                    type: 'PUT',
                    data: JSON.stringify(department),
                    contentType: "application/json",
                    success: function(result) {
                        // success
                        hideModalEdit();
                        showSuccessAlert1();
                        openGroupDetail(id);
                        console.log('done');
                    },
                    error(jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
            else alert("Group name is exists. Enter another name!");
        }
    }
    else alert("Please fill out the form");
}

function showSuccessAlert1(){
    $("#alert-s1").fadeTo(2000,500).slideUp(500, function(){
        $("#alert-s1").slideUp(500);
    });
}