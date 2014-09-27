/**
* HomeController
*/
function ComprasController($scope, $http, $cookies, serviceShare) {

    $scope.nombre = "YANAPAX SRL"
    $scope.direccion = "Ave. los leones nro. 5898 Alto Obrrajes"
    $scope.fecha = new Date();

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
        url: service+'/proveedores'
//        url: 'src/data/emp.json'
    }).success(function (data) { $scope.provList = data.result; });
}