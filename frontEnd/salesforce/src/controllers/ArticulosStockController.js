/**
 * Created by PC 5 on 10/11/2014.
 */


function ArticulosStockController($scope, $http, $cookies, serviceShare) {
    console.log('--->'+$cookies['username']);

//    if ($cookies['usuarioperfil'] == "ADMINISTRADOR") {
//        $scope.access = true;
//    }

// lista articulos begin
//    $scope.listadoArticuloshabilitados = function () {
        $("#loading").css('display', 'block');
        var oTable = $('#dataTableProductos');
        $http.get(service + '/bodegaAlmacen/articulos/2').success(

            function (data, status, headers, config) {
                $("#loading").css('display', 'none');
                $scope.tableProveedores = data.result;
                oTable = $('#dataTableProductos').dataTable(
                    {
                        "bJQueryUI": true,
                        "bAutoWidth": true,
                        "bProcessing": true,
                        "oLanguage": {
                            "sUrl": "src/js/i18n/dataTable_es.txt"
                        },
                        "aaData": $scope.tableProveedores,
                        "aoColumns": [
//                        {
//                            "mData": "id",
//                            "bSearchable": false,
//                            "bVisible": false
//                        },
                            {
                                "mData": null,
                                "bSortable": false
                            },
                            {
                                "mData": "idArticulo",
                                "bSortable": false
                            },
                            {
                                "mData": "descripcionArticulo"
                            },
                            {
                                "mData": "codigoArticulo"
                            },
                            {
                                "mData": "cantidadExistente"
                            },
                            {
                                "mData": "fechaRegistro"
                            },
                            {
                                "mData": "precioVenta"
                            }



                        ],
                        "fnRowCallback": function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
                            $('td:eq(0)', nRow).html(iDisplayIndexFull + 1);
                            return nRow;
                        },
                        "bDestroy": true

                    });

            }).
            error(function (data, status, headers, config) {
                alert('Error:' + data.result);
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });
//    }
}