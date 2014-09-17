/**
 * Created with IntelliJ IDEA.
 * User: PC 5
 * Date: 13/09/14
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */

function InventarioController($scope, $http, $cookies, $routeParams, serviceShare, paramService) {
    console.log('--->admin');
    var id = $routeParams.id;

    //Cargando parametricas
    paramService.paramMarcasList($scope);
    paramService.paramUnidadList($scope);

    $scope.formData = {}

    $scope.cargarClase=function(){
        alert("sdfds");
        console.log("CODIGO"+$scope.formData.clasif_categoria.id);
        if($scope.formData.clasif_categoria!=null){
            codigoCategoria=$scope.formData.clasif_categoria.id
        }else{
            codigoCategoria=0;
        }

        $http.get(service + '/categoria/'+codigoCategoria+'/clase').success( //
            function (data) {
                $scope.claseList = data.result;
            });
    }
    //console.log('CODIGO'+angular.toJson($scope.formData.clasif_categoria.id));
// begin process the form proveedores
    if (id == null || id.length == 0) {
        $scope.save = function () {
                $http({
                    method: 'POST',
                    url: service + '/articulo/guardar',
                    data: JSON.stringify($scope.formData)
                }).success(function (response) {
                        result = response;
                        alert(result.message)
                        $scope.formData = null
                        $("#ModalArticulo").modal('hide')
                }). error(function (response) {   //
                        alert("ERROR! intente mas tarde")

                    });
            }
           //inventarioService.saveArticulo($scope.formData);

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
//Lista proveedores
    var tableProveedores = new Array();
    var oTable = $('#dataTableProdcutos');
    $http.get(service+'/articulosHabilitados').success(
        function (data, status, headers, config) {
            $scope.tableProveedores = data.result;
            oTable = $('#dataTableProdcutos').dataTable(
                {
                    "bJQueryUI":true,
                    "bAutoWidth":true,
                    "bProcessing":true,
                    "oLanguage":{
                        "sUrl":"src/js/i18n/dataTable_es.txt"
                    },
                    "aaData":$scope.tableProveedores,
                    "aoColumns":[
//                        {
//                            "mData": "id",
//                            "bSearchable": false,
//                            "bVisible": false
//                        },
                        {
                            "mData":null,
                            "bSortable":  false
                        },
                        {
                            "mData": "id"
                        },
                        {
                            "mData":"descripcionArticulo"
                        },
                        {
                            "mData":"cantidadReorden"
                        },
                        {
                            "mData":"precioCosto"
                        },
                        {
                            "bSortable": false,
                            "mData":function (oObj) {
                                var a = " <a href='#/clientes/"+oObj.id+"' class='btn btn-primary'><i class='fa fa-edit'></i></a>";
                                return a;

                            }

                        },
                        {
                            "mData":function (oObj) {
                                var b = " <a href='#/cliente-info/"+oObj.id+"' class='btn btn-danger'><i class='fa fa-trash-o'></i></a>";
                                return b;
                            }
                        }


                    ],
                    "fnRowCallback":function (nRow, aData, iDisplayIndex, iDisplayIndexFull) {
                        $('td:eq(0)', nRow).html(iDisplayIndexFull + 1);
                        return nRow;
                    }
                });

        }).
        error(function (data, status, headers, config) {
            alert(data.result);
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
// ends proveedores
}


