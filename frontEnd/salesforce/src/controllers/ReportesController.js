/**
* HomeController
*/
function ReportesController($scope, $http, $cookies, serviceShare) {

    $scope.a = "INFO"

    $scope.productoList = {
        items: [
            {
                "clave": 1,
                "producto": "Hydrogen",
                "cantidad": 2,
                "precio": 10,
                "importe": 20

            }



]
    }


    $http({
        method: 'GET',
        url: service+'/articulosHabilitados'
//        url: 'src/data/emp.json'
    }).success(function (data) { $scope.artList = data.result; });
}