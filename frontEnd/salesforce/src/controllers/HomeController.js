/**
* HomeController
*/
function HomeController($scope, $http, $cookies, serviceShare) {
	console.log('--->'+$cookies['username']);

    if ($cookies['usuarioperfil'] == "ADMINISTRADOR") {
        $scope.access = true;
    }
}