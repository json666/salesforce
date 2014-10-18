/**
 * LoginController
 */
angular.module('myApp', ['ngCookies']);
function LoginController($scope, $cookies, $http) {
	$scope.mensaje_error = '';
	$scope.mensaje_clase = 'hide';

	$scope.login = function() {
        var usuario = $scope.nombreUsuario;
        var password = $scope.password;

        $http({
            method  : 'POST',
            url     : service+'/login/'+usuario+'/'+password,
            data    : JSON.stringify($scope.formData),  // pass in data as strings//
            headers : { 'Content-Type': 'application/json; charset=utf-8' }  // set the headers so angular passing info as form data (not request payload)

        }) .success(function(data) {

                if (!data.success) {
                    // if not successful, bind errors to error variables
                    $scope.mensaje_clase = 'show';
                    $scope.mensaje_error = 'Nombre de usuario o contrase\u00f1a son incorrectos.';
                } else {
                    console.log(data.result);
                    //alert(JSON.stringify(data.result.nombreUsuario+'--'+data.result.rol));
                    $cookies.username = data.result.nombreUsuario;
			        $cookies.usuarioperfil = data.result.rol;
                    $cookies.nombres = data.result.nombres;
                    $cookies.paterno = data.result.paterno;
                    location.href = 'home.html';
//                  $cookies.usuarionombre = nombre;
//			        $cookies.usuarioperfil = perfil;
                }

        }).
            error(function(data, status, headers, config) {

                $("#loading-div-background").css("display", "none");
                $('#alertError').modal('show');
                $("#mensajeAlertError").text(data.result + 'Error! intente nuevamente ')
                alert(JSON.stringify(data.result));
            });

	}

}