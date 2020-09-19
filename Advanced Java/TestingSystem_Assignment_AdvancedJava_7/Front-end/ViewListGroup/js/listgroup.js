function openListGroup(){
    $(".main-content").load("list-group.html");
    builtTable();
}

var departments = [];

function Department(id, name){
    this.id = id;
    this.name = name;
}

function initDepartments(){
    //init data
    $.get("http://localhost:8080/departments", function(data, status){
        
        // reset list departments
        departments = [];

        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }

        // success
        parseData(data);
        fillGroupToTable();
    });
}

function parseData(data) {
    data.forEach(function(item) {
        departments.push(new Department(item.id, item.name));
    });
}

function fillGroupToTable(){
    var stt = 1;
    $('tbody').empty();
    departments.forEach(function(item){
        if(stt%2==0){
            $('tbody').append(
            '<tr>'+
                '<td><input type="checkbox" name="idGroup" value="'+ item.id +'"></td>'+
                '<td>' + stt + '</td>'+
                '<td><a href="#" onclick="openGroupDetail('+ item.id +')">' + item.name + '</a></td>'+
            '</tr>')
        }
        else{
            $('tbody').append(
            '<tr style="background-color: lightgray;">'+
                '<td><input type="checkbox" name="idGroup" value="'+ item.id +'"></td>'+
                '<td>' + stt + '</td>'+
                '<td><a href="#" onclick="openGroupDetail('+ item.id +')">' + item.name + '</a></td>'+
            '</tr>')
        }
        stt++;
    });
}

function builtTable() {
    // $('tbody').empty();
    initDepartments();
}

function builtTableNull(){
    setTimeout(function name(params){
        $('tbody').empty();
        $('tbody').append(
        '<tr style="background-color: lightgray;">'+
            '<td><input type="checkbox" name="idGroup"></td>'+
            '<td></td>'+
            '<td></td>'+
        '</tr>');
    }, 300)
}

function openAddModal(){
    resetForm();
    showModal();
}

function resetForm(){
    document.getElementById("name").value = "";
}

function showModal(){
    $('#myModal').modal('show');
}

function hideModal(){
    $('#myModal').modal('hide');
}

function convertExpandedDateToDate(exDate){
    var date = new Date(exDate);
    var dd = exDate.slice(8,10);
    var mm = date.getMonth()+1;      //As January is 0.
    var yyyy = date.getFullYear();

    if(mm<10) mm='0'+mm;
    return dd+'/'+mm+'/'+yyyy;
}

function convertDateToExpandedDate(date){
    // var date = new Date(date1);
    var dd = date.getDate();
    var mm = date.getMonth()+1;      //As January is 0.
    var yyyy = date.getFullYear();
    var HH = date.getHours();
    var MM = date.getMinutes();
    var SS = date.getSeconds();
    var MLS = date.getMilliseconds();

    if(dd<10) dd='0'+dd;
    if(mm<10) mm='0'+mm;
    if(HH<10) HH='0'+HH;
    if(MM<10) MM='0'+MM;
    if(SS<10) SS='0'+SS;
    if(MLS<10) MLS='00'+MLS
    else if(MLS<100) MLS='0'+MLS;

    return yyyy+'-'+mm+'-'+dd+'T'+HH+':'+MM+':'+SS+'.'+MLS+'Z';
}

function addDepartment(){
    var name = document.getElementById("name").value;
    if(name != ""){
        if(checkNameGroup(name)){

            var department = {
                name: name,
            };

            $.ajax({
                url: 'http://localhost:8080/departments',
                type: 'POST',
                data: JSON.stringify(department), // body
                contentType: "application/json", // type of body (json, xml, text)
                // dataType: 'json', // datatype return
                success: function(data, textStatus, xhr) {
                    hideModal();
                    showSuccessAlert();
                    builtTable();
                },
                error(jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);
                }
            });

        }
        else{
            alert("Department name is exists. Enter another name!");
        }
    }
    else{
        alert("Please fill out the form");
    }
}

function checkNameGroup(name){
    var index = 0;
    var check = false;

    departments.forEach(function(item){
        if(item.name.localeCompare(name) == 0){
            index += 1;
        }
    })
    if (index == 0){
        check = true;
    }
    return check;
}

function openDeleteConfirm(){
    var checkbox = document.getElementsByName('idGroup');
    var result = [];
    var names = [];    

    // Lặp qua từng checkbox để lấy giá trị
    for (var i = 0; i < checkbox.length; i++){
        if (checkbox[i].checked === true){
            result.push(checkbox[i].value);  //Get ID từng checkbox
            var index = departments.findIndex(x => x.id == checkbox[i].value);
            names.push(departments[index].name);
        }
    }

    var result1 = confirm("Are you sure to delete " + names.toString() + " ?");
    if (result1) {
        deleteGroup(result);
    }
}

function deleteGroup(ids){
    for (var i = 0; i < ids.length; i++){
        var id = ids[i];
        $.ajax({
            
            url: "http://localhost:8080/departments/" + id,
            type: 'DELETE',
            success: function(result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }
                // success
                showDeleteAlert();
                builtTable();
            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    }
}

function showSuccessAlert(){
    $("#alert-success").fadeTo(2000,500).slideUp(500, function(){
        $("#alert-success").slideUp(500);
    });
}

function showDeleteAlert(){
    $("#alert-danger").fadeTo(2000,500).slideUp(500, function(){
        $("#alert-danger").slideUp(500);
    });
}