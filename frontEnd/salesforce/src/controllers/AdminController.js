/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */

function AdminController($scope, $http, $cookies, $routeParams, serviceShare) {
    console.log('--->admin');
    var id = $routeParams.id;
    $scope.formData = {}

// begin process the form proveedores
    if (id == null || id.length == 0) {
        $scope.save = function () {
//            $("#loading-div-background").css("display", "block");
            $http({
                method: 'POST',
                url: service + '/proveedor/guardar',
                data: JSON.stringify($scope.formData), // pass in data as strings//
                headers: { 'Content-Type': 'application/json; charset=utf-8' }  // set the headers so angular passing info as form data (not request payload)
            })
                // if successful, bind success message to message
                .success(function (data, status, headers, config) {  //
                    if (!data.success) {
                        // if not successful, bind errors to error variables
//                        $("#loading-div-background").css("display", "none");
//                        $('#alertError').modal('show');
//                        $("#mensajeAlertError").text(data.result+ 'Error! intente nuevamente' )
                        alert('Error!')
                    } else {
                        // if successful, bind success message to message
                        $scope.formData = null
//                        $("#loading-div-background").css("display", "none");
//                        $('#alertSucces').modal('show');
//                        $("#mensajeAlertSucces").text('Registro Guardado');
                        console.log(data.message)
                        alert(JSON.stringify(data.message))
                    }     //
                }).// if not successful, bind errors to error variables
                error(function (data, status, headers, config) {
//                    $("#loading-div-background").css("display", "none");
//                    $('#alertError').modal('show');
//                    $("#mensajeAlertError").text(data.result+ 'Error! intente nuevamente' )
                    alert("ERROR! intente mas tarde")
                });
        };
    } else {
        //get de form by Id    //
        $http({
            method: 'GET',
            url: service + '/proveedor/get/' + id
        }).success(
            function (data, status) {
//                $("#loading-div-background").css("display", "none");
                $scope.formData = data.result;
                console.log(angular.toJson(data.result));
            }).error(function (data, status) {
                alert("Error de conexion con el servidor.");
            });
    }
// ends proveedores
}


