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
        url: service + '/articulosHabilitados'
//        url: 'src/data/emp.json'
    }).success(function (data) {
        $scope.artList = data.result;
    });
    $scope.idArticulo='';
    $scope.seleccionarArticulo = function () {
        if ($scope.formData.articulo != null) {
            $scope.idArticulo = $scope.formData.articulo.id,
                console.log($scope.formData.articulo.id);
            $('#btn_imprimir_revision').attr("href", service + "/reportes/Articulo/" + $scope.idArticulo);

        } else {
            $('#alertError').modal('show');
            $("#mensajeAlertError").text('Por favor seleccione un articulo');
        }

    }
    console.log('vacio'+$scope.idArticulo);

    //$('#btn_imprimir_revision').attr("href", service + "/reportes/Articulo/" + $scope.idArticulo);
    /*$scope.print = function () {
        var idArticulo = '';
        if ($scope.formData != null) {
            idArticulo = $scope.formData.articulo.id,
            console.log($scope.formData.articulo.id);

        } else {
            $('#alertError').modal('show');
            $("#mensajeAlertError").text(data.result + 'Por favor seleccione un articulo');
        }


    } */

}